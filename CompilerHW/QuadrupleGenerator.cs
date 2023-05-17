using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static CMinusMinusParser;

namespace CompilerHW
{
    /// <summary>
    /// 四元式产生器（通过语法树产生）
    /// </summary>
    internal class QuadrupleGenerator : CMinusMinusBaseVisitor<ParserRuleContext>
    {
        private int m_TempVarCount = 0;
        private readonly List<Quadruple> m_Quadruples = new();

        /// <summary>
        /// 通过语法树生成四元式并返回
        /// </summary>
        public List<Quadruple> Generate(ParserRuleContext ruleContext)
        {
            m_Quadruples.Clear();
            Visit(ruleContext);
            return m_Quadruples;
        }

        private ParserRuleContext Visit(ParserRuleContext ruleContext)
        {
            // 这里的返回值并没有什么意义，只是为了能够使用switch表达式
            return ruleContext switch
            {
                ProgramContext context              => VisitProgram(context),
                DeclarationContext context          => VisitDeclaration(context),
                DeclarationTypeContext context      => VisitDeclarationType(context),
                VariableDeclarationContext context  => VisitVariableDeclaration(context),
                FunctionDeclarationContext context  => VisitFunctionDeclaration(context),
                ArrayDeclarationContext context     => VisitArrayDeclaration(context),
                ParameterListContext context        => VisitParameterList(context),
                ParameterContext context            => VisitParameter(context),
                BlockContext context                => VisitBlock(context),
                InnerDeclarationContext context     => VisitInnerDeclaration(context),
                StatementContext context            => VisitStatement(context),
                AssignmentStatementContext context  => VisitAssignmentStatement(context),
                ReturnStatementContext context      => VisitReturnStatement(context),
                WhileStatementContext context       => VisitWhileStatement(context),
                IfStatementContext context          => VisitIfStatement(context),
                ExpressionContext context           => VisitExpression(context),
                AdditiveExpressionContext context   => VisitAdditiveExpression(context),
                MultipleExpressionContext context   => VisitMultipleExpression(context),
                FactorContext context               => VisitFactor(context),
                CallContext context                 => VisitCall(context),
                ArgumentContext context             => VisitArgument(context),
                ArrayContext context                => VisitArray(context),
                RelopContext context                => VisitRelop(context),
                _                                   => ruleContext
            };
        }

        public override ParserRuleContext VisitProgram(ProgramContext context)
        {
            foreach (var declaration in context.declaration())
                Visit(declaration);
            return context;
        }

        public override ParserRuleContext VisitDeclaration(DeclarationContext context)
        {
            if (context.INT() != null)
            {
                var id = context.ID().GetText();
                var declarationTypeContext = context.declarationType();
                Visit(declarationTypeContext);
            }
            else if (context.VOID() != null)
            {
                var id = context.ID().GetText();
                var functionDeclarationContext = context.functionDeclaration();
                Visit(functionDeclarationContext);
            }
            return context;
        }

        public override ParserRuleContext VisitDeclarationType(DeclarationTypeContext context)
        {
            if (context.variableDeclaration() != null)
                Visit(context.variableDeclaration());
            else if (context.functionDeclaration() != null)
                Visit(context.functionDeclaration());
            else if (context.arrayDeclaration() != null)
                Visit(context.arrayDeclaration());
            return context;
        }

        public override ParserRuleContext VisitVariableDeclaration(VariableDeclarationContext context)
        {
            // 这个语句没有具体的执行动作，所以没有四元式产生
            return context;
        }

        public override ParserRuleContext VisitFunctionDeclaration(FunctionDeclarationContext context)
        {
            Visit(context.parameterList());
            Visit(context.block());
            return context;
        }

        public override ParserRuleContext VisitArrayDeclaration(ArrayDeclarationContext context)
        {
            // 数组声明的四元式生成需要考虑数组的大小，这里我们暂时略过这部分，只生成一个基本的声明四元式
            Quadruple q = new Quadruple
            {
                Operator = "array_declaration",
                Operand1 = context.NUM(0).GetText(),
                Result = null
            };
            m_Quadruples.Add(q);
            return context;
        }

        public override ParserRuleContext VisitParameterList(ParameterListContext context)
        {
            foreach (var parameter in context.parameter())
                Visit(parameter);
            if (context.VOID() != null)
            {
                // 如果参数列表只有void，那么不需要生成四元式
            }
            return context;
        }

        public override ParserRuleContext VisitParameter(ParameterContext context)
        {
            // 参数声明的四元式
            Quadruple q = new()
            {
                Operator = "param_declaration",
                Operand1 = context.ID().GetText(),
                Result = null
            };
            m_Quadruples.Add(q);
            return context;
        }

        public override ParserRuleContext VisitBlock(BlockContext context)
        {
            foreach (var innerDeclaration in context.innerDeclaration())
                Visit(innerDeclaration);
            foreach (var statement in context.statement())
                Visit(statement);
            return context;
        }

        public override ParserRuleContext VisitInnerDeclaration(InnerDeclarationContext context)
        {
            if (context.variableDeclaration() != null)
                Visit(context.variableDeclaration());
            else if (context.arrayDeclaration() != null)
                Visit(context.arrayDeclaration());
            return context;
        }

        public override ParserRuleContext VisitStatement(StatementContext context)
        {
            if (context.ifStatement() != null)
                Visit(context.ifStatement());
            else if (context.whileStatement() != null)
                Visit(context.whileStatement());
            else if (context.returnStatement() != null)
                Visit(context.returnStatement());
            else if (context.assignmentStatement() != null)
                Visit(context.assignmentStatement());
            return context;
        }

        public override ParserRuleContext VisitAssignmentStatement(AssignmentStatementContext context)
        {
            // 赋值四元式
            Quadruple q = new()
            {
                Operator = context.ASSIGN().GetText(),
                Operand1 = context.ID().GetText(),
                Operand2 = context.expression().GetText(),
                Result = null
            };
            m_Quadruples.Add(q);
            return context;
        }

        public override ParserRuleContext VisitReturnStatement(ReturnStatementContext context)
        {
            Quadruple q = new();
            if (context.expression() != null)
            {
                q.Operator = "return";
                q.Operand1 = context.expression().GetText();
            }
            else
            {
                q.Operator = "return_void";
            }
            m_Quadruples.Add(q);
            return context;
        }

        public override ParserRuleContext VisitWhileStatement(WhileStatementContext context)
        {
            // while语句的四元式
            Quadruple q = new Quadruple
            {
                Operator = "while",
                Operand1 = context.expression().GetText(),
                Result = null
            };
            m_Quadruples.Add(q);
            Visit(context.block());
            return context;
        }

        public override ParserRuleContext VisitIfStatement(IfStatementContext context)
        {
            // if语句的四元式
            Quadruple q = new()
            {
                Operator = "if",
                Operand1 = context.expression().GetText(),
                Result = null
            };
            m_Quadruples.Add(q);
            Visit(context.block(0));
            // 如果有else语句，那么需要生成一个else四元式
            if (context.block().Length > 1)
            {
                Quadruple qElse = new()
                {
                    Operator = "else",
                    Result = null
                };
                m_Quadruples.Add(qElse);
                Visit(context.block(1));
            }
            return context;
        }

        public override ParserRuleContext VisitExpression(ExpressionContext context)
        {
            Visit(context.additiveExpression(0));
            if (context.relop() != null)
            {
                Visit(context.relop());
                Visit(context.additiveExpression(1));
            }
            return context;
        }

        public override ParserRuleContext VisitAdditiveExpression(AdditiveExpressionContext context)
        {
            Visit(context.multipleExpression(0));

            return context;
        }

        public override ParserRuleContext VisitMultipleExpression(MultipleExpressionContext context)
        {
            return context;
        }

        public override ParserRuleContext VisitFactor(FactorContext context)
        {
            return context;
        }

        public override ParserRuleContext VisitCall(CallContext context)
        {
            return context;
        }

        public override ParserRuleContext VisitArgument(ArgumentContext context)
        {
            return context;
        }

        public override ParserRuleContext VisitArray(ArrayContext context)
        {
            return context;
        }

        public override ParserRuleContext VisitRelop(RelopContext context)
        {
            // 这个语句没有具体的执行动作，所以没有四元式产生
            return context;
        }
    }
}
