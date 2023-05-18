using Antlr4.Runtime;
using LLVMSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using Antlr4.Runtime.Tree;
using LLVMSharp.Interop;
using static CMinusMinusParser;

namespace CompilerHW
{
    /// <summary>
    /// LLVM IR产生器（通过语法树产生）
    /// </summary>
    internal class IRGenerator
    {
        // 上下文对象
        private readonly LLVMContextRef m_Context;
        // 模块对象
        private LLVMModuleRef m_Module;
        // 构造器对象栈
        private LLVMBuilderRef m_Builder;
        // 符号表
        private readonly SymbolTable m_SymbolTable = new();
        // 用于函数之间传递参数的变量栈
        private readonly Dictionary<string, LLVMTypeRef> m_FuncTypes = new();
        // 当前正在构造的函数
        private LLVMValueRef m_Function;

        public IRGenerator()
        {
            m_Context = LLVMContextRef.Create();
            m_Module = LLVMModuleRef.CreateWithName("CMinusMinus");
            m_Builder = LLVMBuilderRef.Create(m_Context);
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
            Console.WriteLine(m_Module.PrintToString());
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
            if (m_SymbolTable.GetSymbol(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            AppendAndGotoBasicBlock("declaration");
            // 创建新变量
            LLVMValueRef variable = m_Builder.BuildAlloca(GetDefaultType(), name);
            m_SymbolTable.AddSymbol(name, variable);
            return variable;
        }

        public void VisitFunctionDeclaration(FunctionDeclarationContext context)
        {
            // 检查函数符号是否已经存在
            m_Function = m_Module.GetNamedFunction(context.ID().GetText());
            if (m_Function.Handle != IntPtr.Zero)
            {
                throw new Exception($"函数 {context.ID().GetText()} 已经存在，不可重载");
            }

            // 获取参数
            LLVMTypeRef[] paramTypes =
                context.parameterList().parameter()?.Select(param => GetDefaultType()).ToArray() ??
                Array.Empty<LLVMTypeRef>();
            LLVMTypeRef retType = context.VOID() != null ? LLVMTypeRef.Void : GetDefaultType();

            // 添加函数
            string name = context.ID().GetText();
            LLVMTypeRef funcType = LLVMTypeRef.CreateFunction(retType, paramTypes);
            m_FuncTypes.Add(name, funcType);
            m_Function = m_Module.AddFunction(name, funcType);
            m_Function.Linkage = LLVMLinkage.LLVMExternalLinkage;

            // 进入函数作用域并创建置参数
            AppendAndGotoBasicBlock("entry", true);
            LLVMTypeRef funcype = new LLVMTypeRef(m_Function.TypeOf.Handle);

            m_SymbolTable.EnterScope();
            VisitParameterList(context.parameterList());

            // 设置函数体
            VisitBlock(context.block());
            // 退出函数定义
            m_Function.Handle = IntPtr.Zero;
            m_SymbolTable.ExitScope();
        }

        public LLVMValueRef VisitArrayDeclaration(ArrayDeclarationContext context)
        {
            // 检查变量符号是否已经存在
            string name = context.ID().GetText();
            if (m_SymbolTable.GetSymbol(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            AppendAndGotoBasicBlock("arrayDeclaration");
            // 创建新的数组变量
            LLVMValueRef array = m_Builder.BuildAlloca(GetArrayType(context), name);
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
            if (m_SymbolTable.GetSymbolInTop(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"参数 {name} 已经存在，不可重定义");
            }

            // 设置函数的函数名
            LLVMValueRef param = m_Function.GetParam((uint)index);
            param.Name = name;

            // 创建新的参数
            LLVMTypeRef type = GetDefaultType();
            LLVMValueRef value = m_Builder.BuildAlloca(type, name);
            m_Builder.BuildStore(value, param);
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

        public void VisitAssignmentStatement(AssignmentStatementContext context)
        {
            LLVMValueRef lhs;
            // 获取普通变量
            if (context.ID() != null)
            {
                string name = context.ID().GetText();
                if (m_SymbolTable.GetSymbol(name).Handle == IntPtr.Zero)
                    throw new Exception($"变量 {name} 未定义");
                lhs = m_SymbolTable.GetSymbol(name);
            }
            // 获取数组变量
            else
            {
                lhs = VisitArray(context.array());
            }

            // 计算右值
            LLVMValueRef rhs = VisitExpression(context.expression());

            // 生成赋值指令
            m_Builder.BuildStore(rhs, lhs);
        }

        public void VisitReturnStatement(ReturnStatementContext context)
        {
            // 如果存在返回值，生成返回值的代码
            LLVMValueRef returnValue = new(IntPtr.Zero);
            if (context.expression() != null)
            {
                returnValue = VisitExpression(context.expression());
            }

            // 生成返回指令
            m_Builder.BuildRet(returnValue);
        }

        public void VisitWhileStatement(WhileStatementContext context)
        {
            // 创建基本块
            LLVMBasicBlockRef condBlock = AppendAndGotoBasicBlock("cond");
            LLVMBasicBlockRef loopBlock = m_Function.AppendBasicBlock("loop");
            LLVMBasicBlockRef endBlock = m_Function.AppendBasicBlock("endLoop");

            // 生成条件判断基本块
            LLVMValueRef condValue = VisitExpression(context.expression());
            m_Builder.BuildCondBr(condValue, loopBlock, endBlock);

            // 生成循环体的代码
            m_Builder.PositionAtEnd(loopBlock);
            VisitBlock(context.block());
            m_Builder.BuildBr(condBlock);  // 从循环体跳转回条件判断基本块

            // 定位到循环结束后的基本块
            m_Builder.PositionAtEnd(endBlock);
        }

        public void VisitIfStatement(IfStatementContext context)
        {
            // 创建基本块
            AppendAndGotoBasicBlock("cond");
            LLVMBasicBlockRef thenBlock = m_Function.AppendBasicBlock("then");
            LLVMBasicBlockRef elseBlock = m_Function.AppendBasicBlock("else");
            LLVMBasicBlockRef mergeBlock = m_Function.AppendBasicBlock("endIf");    // 两个分支需要合并到一个基本块，方便后续处理

            // 生成条件表达式的代码
            LLVMValueRef condValue = VisitExpression(context.expression());

            // 生成分支指令
            m_Builder.BuildCondBr(condValue, thenBlock, elseBlock);

            // 生成then语句的代码
            m_Builder.PositionAtEnd(thenBlock);
            VisitBlock(context.block(0));
            m_Builder.BuildBr(mergeBlock);  // 从then分支跳转到merge基本块

            // 生成else语句的代码（如果存在）
            m_Builder.PositionAtEnd(elseBlock);
            if (context.block().Length > 1)
                VisitBlock(context.block(1));
            m_Builder.BuildBr(mergeBlock);  // 从else分支跳转到merge基本块

            // 定位到merge基本块
            m_Builder.PositionAtEnd(mergeBlock);
        }

        public LLVMValueRef VisitExpression(ExpressionContext context)
        {
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
                return m_Builder.BuildICmp(relop, lhs, rhs, "relop_tmp");
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
                    PLUS  => m_Builder.BuildAdd(ret, rhs, "add_tmp"),
                    MINUS => m_Builder.BuildSub(ret, rhs, "sub_tmp"),
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
                    MULTIPLY => m_Builder.BuildMul(ret, rhs, "mul_tmp"),
                    DIVIDE   => m_Builder.BuildExactSDiv(ret, rhs, "div_tmp"),
                    _        => ret
                };
            }
            return ret;
        }

        public LLVMValueRef VisitFactor(FactorContext context)
        {
            // 数字常量
            if (context.NUM() != null)
                return LLVMValueRef.CreateConstInt(GetDefaultType(), GetNum(context.NUM()));
            // 表达式
            if (context.expression() != null)
                return VisitExpression(context.expression());
            // 数组值
            if (context.array() != null)
                return m_Builder.BuildLoad2(GetDefaultType(), VisitArray(context.array()), "element");
            string name = context.ID().GetText();
            // 函数返回值
            if (context.call() != null)
            {
                LLVMValueRef func = m_Module.GetNamedFunction(name);
                if (func.Handle == IntPtr.Zero)
                    throw new Exception($"函数 {name} 未定义");
                return VisitCall(func, context.call());
            }
            // 变量
            if (m_SymbolTable.GetSymbol(name).Handle == IntPtr.Zero)
                throw new Exception($"变量 {name} 未定义");
            return m_SymbolTable.GetSymbol(name);
        }

        public LLVMValueRef VisitCall(LLVMValueRef func, CallContext context)
        {
            LLVMValueRef[] args = VisitArgument(context.argument());
            return m_Builder.BuildCall2(m_FuncTypes[func.Name], func, args, "call");
        }

        public LLVMValueRef[] VisitArgument(ArgumentContext context)
        {
            return context.expression().Select(VisitExpression).ToArray();
        }

        public LLVMValueRef VisitArray(ArrayContext context)
        {
            // 获取所有索引值
            List<LLVMValueRef> indices = new() { VisitExpression(context.expression()) };
            while (context.array() != null)
            {
                context = context.array();
                indices.Insert(0, VisitExpression(context.expression()));
            }
            // 查找数组
            LLVMValueRef array = m_SymbolTable.GetSymbol(context.ID().GetText());
            if (array.Handle == IntPtr.Zero)
                throw new Exception($"数组 {context.ID().GetText()} 未定义");
            // 返回数组元素的地址
            return m_Builder.BuildGEP2(GetDefaultType(), array, indices.ToArray(), "elementPtr");
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
        private static LLVMTypeRef GetDefaultType() => LLVMTypeRef.Int32;
        // 获取数字解析结果
        private static ulong GetNum(ITerminalNode terminal) => ulong.Parse(terminal.GetText());
        // 获取数组类型
        private static LLVMTypeRef GetArrayType(ArrayDeclarationContext context)
        {
            LLVMTypeRef ret = GetDefaultType();
            return context.NUM().Aggregate(ret, (current, num) => LLVMTypeRef.CreateArray(current, uint.Parse(num.GetText())));
        }

        // 创建基本块并将构造指针置于该基本块起始处
        private LLVMBasicBlockRef AppendAndGotoBasicBlock(string name, bool entry = false)
        {
            LLVMBasicBlockRef block = m_Function.AppendBasicBlock(name);
            if (!entry)
                m_Builder.BuildBr(block);
            m_Builder.PositionAtEnd(block);
            return block;
        }
    }
}
