#define PRINTF
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
    internal class IRGenerator : IDisposable
    {
        // 上下文对象
        private LLVMContextRef m_Context;
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

        // printf格式字符串索引
        private enum PrintfType
        {
            DeclareVar,
            DeclareArray,
            Call,
            Assign,
            Return,
            ReturnVoid,
            Argument,
        }
        private readonly Dictionary<PrintfType, LLVMValueRef> m_PrintfTypes = new();

        public IRGenerator()
        {
            m_Context = LLVMContextRef.Create();

            m_Module = LLVMModuleRef.CreateWithName("CMinusMinus");
            //m_Module.Target = "x86_64-pc-windows-msvc19.35.32216";  // 设置目标平台
            m_Builder = LLVMBuilderRef.Create(m_Context);

#if PRINTF
            // 创建printf函数的声明
            LLVMTypeRef printfType = LLVMTypeRef.CreateFunction(LLVMTypeRef.Int32, Array.Empty<LLVMTypeRef>(), true);
            m_Module.AddFunction("printf", printfType);
            m_FuncTypes.Add("printf", printfType);

            LLVMValueRef globalFunc = m_Module.AddFunction("global", LLVMTypeRef.CreateFunction(LLVMTypeRef.Void, Array.Empty<LLVMTypeRef>()));
            m_Builder.PositionAtEnd(globalFunc.AppendBasicBlock("entry"));

            m_PrintfTypes.Add(PrintfType.DeclareVar, m_Builder.BuildGlobalStringPtr("定义变量：%s\n", "DeclareVarFormat"));
            m_PrintfTypes.Add(PrintfType.DeclareArray, m_Builder.BuildGlobalStringPtr("定义数组：%s\n", "DeclareArrayFormat"));
            m_PrintfTypes.Add(PrintfType.Call, m_Builder.BuildGlobalStringPtr("调用函数：%s\n", "CallFormat"));
            m_PrintfTypes.Add(PrintfType.Assign, m_Builder.BuildGlobalStringPtr("赋值为：%d\n", "AssignFormat"));
            m_PrintfTypes.Add(PrintfType.Return, m_Builder.BuildGlobalStringPtr("函数返回：%d\n", "ReturnFormat"));
            m_PrintfTypes.Add(PrintfType.ReturnVoid, m_Builder.BuildGlobalStringPtr("函数返回 无返回值\n", "ReturnVoidFormat"));
            m_PrintfTypes.Add(PrintfType.Argument, m_Builder.BuildGlobalStringPtr("参数：%d\n", "ArgumentFormat"));

            m_Builder.BuildRet(new LLVMValueRef());
#endif
        }

        /// <summary>
        /// 通过语法树生成四元式并返回
        /// </summary>
        public void Generate(ProgramContext ctx)
        {
            VisitProgram(ctx);
            try
            {
                m_Module.Verify(LLVMVerifierFailureAction.LLVMReturnStatusAction);
            }
            catch (ExternalException e)
            {
                Console.ForegroundColor = ConsoleColor.DarkRed;
                Console.WriteLine($"生成的模块有错误：\n{e.Message}\n");
                Console.ResetColor();
            }
        }

        public void PrintCode()
        {
            Console.WriteLine(m_Module.PrintToString());
        }
        public void WriteToFile(string path)
        {
            File.WriteAllText(path, m_Module.PrintToString());
        }
        public void WriteBitcodeToFile(string path)
        {
            if (!File.Exists(path))
                File.Create(path).Close();
            m_Module.WriteBitcodeToFile(path);
        }

        public LLVMModuleRef GetModule()
        {
            return m_Module;
        }

        private void VisitProgram(ProgramContext context)
        {
            foreach (var declaration in context.declaration())
            {
                VisitDeclaration(declaration);
            }
        }

        private void VisitDeclaration(DeclarationContext context)
        {
            if (context.variableDeclaration() != null)
                VisitVariableDeclaration(context.variableDeclaration());
            else if (context.functionDeclaration() != null)
                VisitFunctionDeclaration(context.functionDeclaration());
            else if (context.arrayDeclaration() != null)
                VisitArrayDeclaration(context.arrayDeclaration());
        }

        private LLVMValueRef VisitVariableDeclaration(VariableDeclarationContext context)
        {
            // 检查变量符号是否已经存在
            string name = context.ID().GetText();
            if (m_SymbolTable.GetValue(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            //AppendAndGotoBasicBlock("declaration");
            // 创建新变量
            LLVMTypeRef varType = GetDefaultType();
            LLVMValueRef variable = m_Builder.BuildAlloca(varType, name);
            m_SymbolTable.AddSymbol(name, variable, varType);

            PrintF(PrintfType.DeclareVar, name);
            return variable;
        }

        private void VisitFunctionDeclaration(FunctionDeclarationContext context)
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

            m_SymbolTable.EnterScope();
            VisitParameterList(context.parameterList());

            // 设置函数体
            VisitBlock(context.block());
            // 退出函数定义
            m_Function.Handle = IntPtr.Zero;
            m_SymbolTable.ExitScope();
        }

        private LLVMValueRef VisitArrayDeclaration(ArrayDeclarationContext context)
        {
            // 检查变量符号是否已经存在
            string name = context.ID().GetText();
            if (m_SymbolTable.GetValue(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"变量 {name} 已经存在，不可重定义");
            }

            // 创建基本块
            //AppendAndGotoBasicBlock("arrayDeclaration");
            // 创建新的数组变量
            LLVMTypeRef arrayType = GetArrayType(context);
            LLVMValueRef array = m_Builder.BuildAlloca(arrayType, name);
            m_SymbolTable.AddSymbol(name, array, arrayType);

            PrintF(PrintfType.DeclareArray, name);
            return array;
        }

        private LLVMTypeRef[] VisitParameterList(ParameterListContext context)
        {
            return context.parameter().Select(VisitParameter).ToArray();
        }

        private LLVMTypeRef VisitParameter(ParameterContext context, int index)
        {
            // 检查参数名是否重定义
            string name = context.ID().GetText();
            if (m_SymbolTable.GetValueInTop(name).Handle != IntPtr.Zero)
            {
                throw new Exception($"参数 {name} 已经存在，不可重定义");
            }

            // 设置函数的函数名
            LLVMValueRef param = m_Function.GetParam((uint)index);
            param.Name = name;

            // 创建新的参数（此处创建一个新变量并将参数值赋予该变量）
            LLVMTypeRef type = GetDefaultType();
            LLVMValueRef arg = m_Builder.BuildAlloca(param.TypeOf, "arg_" + name);
            m_Builder.BuildStore(param, arg);
            m_SymbolTable.AddSymbol(name, arg, type);
            return type;
        }

        private void VisitBlock(BlockContext context)
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

        private LLVMValueRef VisitInnerDeclaration(InnerDeclarationContext context)
        {
            // 执行创建变量语句
            if (context.variableDeclaration() != null)
                return VisitVariableDeclaration(context.variableDeclaration());
            if (context.arrayDeclaration() != null)
                return VisitArrayDeclaration(context.arrayDeclaration());
            return new LLVMValueRef();
        }

        private void VisitStatement(StatementContext context)
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

        private void VisitAssignmentStatement(AssignmentStatementContext context)
        {
            LLVMValueRef lhs;
            // 获取普通变量
            if (context.ID() != null)
            {
                string name = context.ID().GetText();
                if (m_SymbolTable.GetValue(name).Handle == IntPtr.Zero)
                    throw new Exception($"变量 {name} 未定义");
                lhs = m_SymbolTable.GetValue(name);
            }
            // 获取数组变量
            else
            {
                lhs = VisitArray(context.array());
            }

            // 计算右值
            LLVMValueRef rhs = VisitExpression(context.expression());

            // 生成赋值指令
            PrintF(PrintfType.Assign, rhs);
            m_Builder.BuildStore(rhs, lhs);
        }

        private void VisitReturnStatement(ReturnStatementContext context)
        {
            // 如果存在返回值，生成返回值的代码
            LLVMValueRef returnValue = new(IntPtr.Zero);
            if (context.expression() != null)
            {
                returnValue = VisitExpression(context.expression());
            }

            // 生成返回指令
            if (returnValue.Handle == IntPtr.Zero)
                PrintF(PrintfType.ReturnVoid);
            else
                PrintF(PrintfType.Return, returnValue);
            m_Builder.BuildRet(returnValue);
        }

        private void VisitWhileStatement(WhileStatementContext context)
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

        private void VisitIfStatement(IfStatementContext context)
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

        private LLVMValueRef VisitExpression(ExpressionContext context)
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

        private LLVMValueRef VisitAdditiveExpression(AdditiveExpressionContext context)
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

        private LLVMValueRef VisitMultipleExpression(MultipleExpressionContext context)
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

        private LLVMValueRef VisitFactor(FactorContext context)
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
            if (m_SymbolTable.GetValue(name).Handle == IntPtr.Zero)
                throw new Exception($"变量 {name} 未定义");
            LLVMValueRef value = m_SymbolTable.GetValue(name);
            return m_Builder.BuildLoad2(GetDefaultType(), value, $"{name}_value");
        }

        private LLVMValueRef VisitCall(LLVMValueRef func, CallContext context)
        {
            LLVMValueRef[] args = VisitArgument(context.argument());
            PrintF(PrintfType.Call, func.Name);
            foreach (LLVMValueRef arg in args)
                PrintF(PrintfType.Argument, arg);
            return m_Builder.BuildCall2(m_FuncTypes[func.Name], func, args, "call");
        }

        private LLVMValueRef[] VisitArgument(ArgumentContext context)
        {
            return context.expression().Select(VisitExpression).ToArray();
        }

        private LLVMValueRef VisitArray(ArrayContext context)
        {
            // 获取所有索引值
            List<LLVMValueRef> indices = new() { VisitExpression(context.expression()) };
            while (context.array() != null)
            {
                context = context.array();
                indices.Insert(0, VisitExpression(context.expression()));
            }
            // 查找数组
            string name = context.ID().GetText();
            LLVMValueRef array = m_SymbolTable.GetValue(name);
            if (array.Handle == IntPtr.Zero)
                throw new Exception($"数组 {name} 未定义");
            // 返回数组元素的地址
            LLVMTypeRef arrayType = m_SymbolTable.GetType(name);
            return m_Builder.BuildGEP2(arrayType, array, indices.ToArray(), "elementPtr");
        }

        private LLVMIntPredicate VisitRelop(RelopContext context)
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

        private void PrintF(PrintfType format, params object[] args)
        {
#if PRINTF
            LLVMValueRef func = m_Module.GetNamedFunction("printf");
            if (func.Handle == IntPtr.Zero)
                throw new Exception("函数 printf 未定义");
            LLVMValueRef formatStr = m_PrintfTypes[format];
            LLVMValueRef[] callArgs = args.Select(arg =>
            {
                return arg switch
                {
                    int      => LLVMValueRef.CreateConstInt(GetDefaultType(), (ulong)arg),
                    string str => m_Builder.BuildGlobalStringPtr(str, "string"),
                    LLVMValueRef value => value,
                    _ => throw new Exception("未知类型的printf参数：" + arg.GetType())
                };
            }).ToArray();
            m_Builder.BuildCall2(m_FuncTypes["printf"], func, new[] { formatStr }.Concat(callArgs).ToArray(), "print");
#endif
        }

        public void Dispose()
        {
            m_Builder.Dispose();
            m_Module.Dispose();
            m_Context.Dispose();
        }
    }
}
