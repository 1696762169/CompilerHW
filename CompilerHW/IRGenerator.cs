using Antlr4.Runtime;
using LLVMSharp;
using SharpCompress.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Tree;
using static CMinusMinusParser;

namespace CompilerHW
{
    /// <summary>
    /// LLVM IR产生器（通过语法树产生）
    /// </summary>
    internal class IRGenerator
    {
        // 模块对象
        private readonly LLVMModuleRef m_Module;
        // 构造器对象栈
        private readonly LLVMBuilderRef m_Builder;
        // 符号表
        private readonly SymbolTable m_SymbolTable = new();
        // 用于函数之间传递参数的变量栈
        private readonly Stack<LLVMValueRef> m_ValueStack = new();
        // 当前正在构造的函数
        private LLVMValueRef m_Function;

        public IRGenerator()
        {
            m_Module = LLVM.ModuleCreateWithName("CMinusMinus");
            m_Builder = LLVM.CreateBuilder();
        }

        /// <summary>
        /// 通过语法树生成四元式并返回
        /// </summary>
        public void Generate(ProgramContext ctx)
        {
            VisitProgram(ctx);
        }

        public void PrintCode()
        { 
            nint ptr = LLVM.PrintModuleToString(m_Module);
            Console.WriteLine(Marshal.PtrToStringAnsi(ptr));
        }

        public void VisitProgram(ProgramContext context)
        {
            foreach (var declaration in context.declaration())
            {
                VisitDeclaration(declaration);
            }
        }

        public void VisitDeclaration(DeclarationContext context)
        {
            if (context.variableDeclaration() != null)
                VisitVariableDeclaration(context.variableDeclaration());
            else if (context.functionDeclaration() != null)
                VisitFunctionDeclaration(context.functionDeclaration());
            else if (context.arrayDeclaration() != null)
                VisitArrayDeclaration(context.arrayDeclaration());
        }

        public LLVMValueRef VisitVariableDeclaration(VariableDeclarationContext context)
        {
            // 检查变量符号是否已经存在
            string name = context.ID().GetText();
            if (m_SymbolTable.GetSymbol(name).Pointer != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            LLVM.BuildBr(m_Builder, AppendBasicBlock("declaration"));
            // 创建新变量
            LLVMValueRef variable = LLVM.BuildAlloca(m_Builder, GetDefaultType(), name);
            m_SymbolTable.AddSymbol(name, variable);
            return variable;
        }

        public void VisitFunctionDeclaration(FunctionDeclarationContext context)
        {
            // 检查函数符号是否已经存在
            m_Function = LLVM.GetNamedFunction(m_Module, context.ID().GetText());
            if (m_Function.Pointer != IntPtr.Zero)
            {
                throw new Exception($"函数 {context.ID().GetText()} 已经存在，不可重载");
            }

            // 获取参数
            LLVMTypeRef[] paramTypes =
                context.parameterList().parameter()?.Select(param => GetDefaultType()).ToArray() ??
                Array.Empty<LLVMTypeRef>();
            LLVMTypeRef retType = context.VOID() != null ? LLVM.VoidType() : GetDefaultType();

            // 添加函数
            m_Function = LLVM.AddFunction(m_Module, context.ID().GetText(), LLVM.FunctionType(retType, paramTypes, false));
            LLVM.SetLinkage(m_Function, LLVMLinkage.LLVMExternalLinkage);

            // 进入函数作用域并创建置参数
            AppendBasicBlock("entry");
            m_SymbolTable.EnterScope();
            VisitParameterList(context.parameterList());

            // 设置函数体
            VisitBlock(context.block());
            // 退出函数定义
            m_Function.Pointer = IntPtr.Zero;
            m_SymbolTable.ExitScope();
        }

        public LLVMValueRef VisitArrayDeclaration(ArrayDeclarationContext context)
        {
            // 检查变量符号是否已经存在
            string name = context.ID().GetText();
            if (m_SymbolTable.GetSymbol(name).Pointer != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            LLVM.BuildBr(m_Builder, AppendBasicBlock("arrayDeclaration"));
            // 创建新的数组变量
            LLVMValueRef array = LLVM.BuildAlloca(m_Builder, GetArrayType(context), name);
            m_SymbolTable.AddSymbol(name, array);
            return array;
        }

        public LLVMTypeRef[] VisitParameterList(ParameterListContext context)
        {
            return context.parameter().Select(VisitParameter).ToArray();
        }

        public LLVMTypeRef VisitParameter(ParameterContext context, int index)
        {
            // 检查参数名是否重定义
            string name = context.ID().GetText();
            if (m_SymbolTable.GetSymbolInTop(name).Pointer != IntPtr.Zero)
            {
                throw new Exception($"参数 {name} 已经存在，不可重定义");
            }

            // 设置函数的函数名
            LLVMValueRef param = LLVM.GetParam(m_Function, (uint)index);
            LLVM.SetValueName(param, name);

            // 创建新的参数
            LLVMTypeRef type = GetDefaultType();
            LLVMValueRef value = LLVM.BuildAlloca(m_Builder, type, name);
            LLVM.BuildStore(m_Builder, value, param);
            m_SymbolTable.AddSymbol(name, value);
            return type;
        }

        public void VisitBlock(BlockContext context)
        {
            // 进入作用域
            m_SymbolTable.EnterScope();
            // 遍历声明与其它语句
            for (int i = 0; i < context.ChildCount; ++i)
            {
                if (context.GetChild(i) is StatementContext statement)
                    VisitStatement(statement);
                else if (context.GetChild(i) is InnerDeclarationContext innerDeclaration)
                    VisitInnerDeclaration(innerDeclaration);
            }
            // 离开作用域
            m_SymbolTable.ExitScope();
        }

        public LLVMValueRef VisitInnerDeclaration(InnerDeclarationContext context)
        {
            // 执行创建变量语句
            if (context.variableDeclaration() != null)
                return VisitVariableDeclaration(context.variableDeclaration());
            if (context.arrayDeclaration() != null)
                return VisitArrayDeclaration(context.arrayDeclaration());
            return new LLVMValueRef();
        }

        public void VisitStatement(StatementContext context)
        {
            if (context.assignmentStatement() != null)
                VisitAssignmentStatement(context.assignmentStatement());
            else if (context.returnStatement() != null)
                VisitReturnStatement(context.returnStatement());
            else if (context.whileStatement() != null)
                VisitWhileStatement(context.whileStatement());
            else if (context.ifStatement() != null)
                VisitIfStatement(context.ifStatement());
        }

        public LLVMValueRef VisitAssignmentStatement(AssignmentStatementContext context)
        {
            return new LLVMValueRef();
        }

        public LLVMValueRef VisitReturnStatement(ReturnStatementContext context)
        {
            return new LLVMValueRef();
        }

        public LLVMValueRef VisitWhileStatement(WhileStatementContext context)
        {
            return new LLVMValueRef();
        }

        public void VisitIfStatement(IfStatementContext context)
        {
            // 创建基本块
            LLVMBasicBlockRef thenBlock = LLVM.AppendBasicBlock(m_Function, "then");
            LLVMBasicBlockRef elseBlock = LLVM.AppendBasicBlock(m_Function, "else");
            LLVMBasicBlockRef mergeBlock = LLVM.AppendBasicBlock(m_Function, "ifStatement");    // 两个分支需要合并到一个基本块，方便后续处理

            // 生成条件表达式的代码
            LLVMValueRef condValue = VisitExpression(context.expression());

            // 生成分支指令
            LLVM.BuildCondBr(m_Builder, condValue, thenBlock, elseBlock);

            // 生成then语句的代码
            LLVM.PositionBuilderAtEnd(m_Builder, thenBlock);
            VisitBlock(context.block(0));
            LLVM.BuildBr(m_Builder, mergeBlock);  // 从then分支跳转到merge基本块

            // 生成else语句的代码（如果存在）
            LLVM.PositionBuilderAtEnd(m_Builder, elseBlock);
            if (context.block().Length > 1)
                VisitBlock(context.block(1));
            LLVM.BuildBr(m_Builder, mergeBlock);  // 从else分支跳转到merge基本块

            // 定位到merge基本块
            LLVM.PositionBuilderAtEnd(m_Builder, mergeBlock);
        }

        public LLVMValueRef VisitExpression(ExpressionContext context)
        {
            // 生成基本块
            LLVM.BuildBr(m_Builder, AppendBasicBlock("expression"));

            // 非比较表达式
            if (context.relop() == null)
            {
                return VisitAdditiveExpression(context.additiveExpression(0));
            }
            // 比较表达式
            else
            {
                LLVMValueRef lhs = VisitAdditiveExpression(context.additiveExpression(0));
                LLVMIntPredicate relop = VisitRelop(context.relop());
                LLVMValueRef rhs = VisitAdditiveExpression(context.additiveExpression(1));
                return LLVM.BuildICmp(m_Builder, relop, lhs, rhs, "relop_tmp");
            }
        }

        public LLVMValueRef VisitAdditiveExpression(AdditiveExpressionContext context)
        {
            LLVMValueRef ret = VisitMultipleExpression(context.multipleExpression(0));
            // 取两个子节点 分别是操作符和操作数
            for (int i = 1; i < context.ChildCount; i += 2)
            {
                if (context.GetChild(i) is not ITerminalNode terminal)
                    throw new Exception("表达式操作符不正确");
                LLVMValueRef rhs = VisitMultipleExpression(context.multipleExpression(i));
                ret = terminal.Symbol.Type switch
                {
                    PLUS  => LLVM.BuildAdd(m_Builder, ret, rhs, "add_tmp"),
                    MINUS => LLVM.BuildSub(m_Builder, ret, rhs, "sub_tmp"),
                    _     => ret
                };
            }
            return ret;
        }

        public LLVMValueRef VisitMultipleExpression(MultipleExpressionContext context)
        {
            LLVMValueRef ret = VisitFactor(context.factor(0));
            // 取两个子节点 分别是操作符和操作数
            for (int i = 1; i < context.ChildCount; i += 2)
            {
                if (context.GetChild(i) is not ITerminalNode terminal)
                    throw new Exception("表达式操作符不正确");
                LLVMValueRef rhs = VisitFactor(context.factor(i));
                ret = terminal.Symbol.Type switch
                {
                    MULTIPLY => LLVM.BuildMul(m_Builder, ret, rhs, "mul_tmp"),
                    DIVIDE   => LLVM.BuildExactUDiv(m_Builder, ret, rhs, "div_tmp"),
                    _        => ret
                };
            }
            return ret;
        }

        public LLVMValueRef VisitFactor(FactorContext context)
        {
            // 数字常量
            if (context.NUM() != null)
                return LLVM.ConstInt(GetDefaultType(), GetNum(context.NUM()), false);
            // 表达式
            if (context.expression() != null)
                return VisitExpression(context.expression());
            // 数组值
            if (context.array() != null)
                return VisitArray(context.array());
            string name = context.ID().GetText();
            // 函数返回值
            if (context.call() != null)
            {
                if (LLVM.GetNamedFunction(m_Module, name).Pointer == IntPtr.Zero)
                    throw new Exception($"函数 {name} 未定义");
                return VisitCall(name, context.call());
            }
            // 变量
            if (m_SymbolTable.GetSymbol(name).Pointer == IntPtr.Zero)
                throw new Exception($"变量 {name} 未定义");
            return m_SymbolTable.GetSymbol(name);
        }

        public LLVMValueRef VisitCall(string funcName, CallContext context)
        {
            return new LLVMValueRef();
        }

        public LLVMValueRef VisitArgument(ArgumentContext context)
        {
            return new LLVMValueRef();
        }

        public LLVMValueRef VisitArray(ArrayContext context)
        {
            return new LLVMValueRef();
        }

        public LLVMIntPredicate VisitRelop(RelopContext context)
        {
            // 根据比较符号返回类型
            if (context.LESS() != null)
                return LLVMIntPredicate.LLVMIntSLT;
            if (context.LESS_EQUALS() != null)
                return LLVMIntPredicate.LLVMIntSLE;
            if (context.GREATER() != null)
                return LLVMIntPredicate.LLVMIntSGT;
            if (context.GREATER_EQUALS() != null)
                return LLVMIntPredicate.LLVMIntSGE;
            if (context.EQUALS() != null)
                return LLVMIntPredicate.LLVMIntEQ;
            if (context.NOT_EQUALS() != null)
                return LLVMIntPredicate.LLVMIntNE;
            throw new Exception("Unknown relop");
        }

        // 获取默认类型
        private static LLVMTypeRef GetDefaultType() => LLVM.Int32Type();
        // 获取数字解析结果
        private static ulong GetNum(ITerminalNode terminal) => ulong.Parse(terminal.GetText());
        // 获取数组类型
        private static LLVMTypeRef GetArrayType(ArrayDeclarationContext context)
        {
            LLVMTypeRef ret = GetDefaultType();
            return context.NUM().Aggregate(ret, (current, num) => LLVM.ArrayType(current, uint.Parse(num.GetText())));
        }

        // 创建基本块并将构造指针置于该基本块起始处
        private LLVMBasicBlockRef AppendBasicBlock(string name)
        {
            LLVMBasicBlockRef block = LLVM.AppendBasicBlock(m_Function, name);
            LLVM.PositionBuilderAtEnd(m_Builder, block);
            return block;
        }
    }
}
