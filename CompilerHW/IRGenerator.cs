using Antlr4.Runtime;
using LLVMSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static CMinusMinusParser;

namespace CompilerHW
{
    /// <summary>
    /// LLVM IR产生器（通过语法树产生）
    /// </summary>
    internal class IRGenerator : CMinusMinusBaseVisitor<LLVMValueRef>
    {
        private readonly LLVMModuleRef m_Module;
        private readonly LLVMBuilderRef m_Builder;

        public IRGenerator()
        {
            m_Module = LLVM.ModuleCreateWithName("CMinusMinus");
            m_Builder = LLVM.CreateBuilder();
        }

        /// <summary>
        /// 通过语法树生成四元式并返回
        /// </summary>
        public LLVMValueRef Generate(ProgramContext ctx)
        {
            return VisitProgram(ctx);
        }

        public override LLVMValueRef VisitProgram(ProgramContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitDeclaration(DeclarationContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitDeclarationType(DeclarationTypeContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitVariableDeclaration(VariableDeclarationContext context)
        {
            // 这个语句没有具体的执行动作，所以没有四元式产生
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitFunctionDeclaration(FunctionDeclarationContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitArrayDeclaration(ArrayDeclarationContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitParameterList(ParameterListContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitParameter(ParameterContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitBlock(BlockContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitInnerDeclaration(InnerDeclarationContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitStatement(StatementContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitAssignmentStatement(AssignmentStatementContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitReturnStatement(ReturnStatementContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitWhileStatement(WhileStatementContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitIfStatement(IfStatementContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitExpression(ExpressionContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitAdditiveExpression(AdditiveExpressionContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitMultipleExpression(MultipleExpressionContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitFactor(FactorContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitCall(CallContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitArgument(ArgumentContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitArray(ArrayContext context)
        {
            return new LLVMValueRef();
        }

        public override LLVMValueRef VisitRelop(RelopContext context)
        {
            // 这个语句没有具体的执行动作，所以没有四元式产生
            return new LLVMValueRef();
        }
    }
}
