//#define SHOW_LEXER
//#define SHOW_PARSER
//#define SHOW_QUAD

//#define TEST_EXPRESSION
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System.IO;
using LLVMSharp;

namespace CompilerHW
{
    internal class Program
    {
        private static void Main(string[] args)
        {
#if TEST_EXPRESSION
            using TextReader textReader = File.OpenText("test_files/expression.txt");
#else
            using TextReader textReader = File.OpenText("test_files/input.txt");
#endif
            string outDir = "out_files/";

            // 创建字符流
            AntlrInputStream input = new(textReader);
            // 创建词法分析器
            CMinusMinusLexer lexer = new(input);
            // 通过词法分析器创建Token流
            CommonTokenStream tokens = new(lexer);
#if SHOW_LEXER
            // 展示词法分析结果
            Display.ShowLexer(tokens);
#endif
            Display.ShowLexer(tokens, outDir + "LexerResult.txt");

            // 通过Token流创建语法分析器
            CMinusMinusParser parser = new(tokens);
            // 通过语法分析器创建语法树
#if TEST_EXPRESSION
            CMinusMinusParser.ExpressionContext tree = parser.expression();
#else
            CMinusMinusParser.ProgramContext tree = parser.program();
#endif
            DisplayTree display = new (CMinusMinusParser.ruleNames, tree);
#if SHOW_PARSER
            // 展示语法分析结果
            display.PrintTreeAsJson();
#endif
            display.WriteToFileAsJson(outDir + "ParseTree.json");

            // 将语法树转换为四元式序列
            IRGenerator quadGenerator = new();
#if TEST_EXPRESSION
            quadGenerator.VisitExpression(tree);
#else
            quadGenerator.Generate(tree);
#endif
#if SHOW_QUAD
            // 展示四元式序列
            quadGenerator.PrintCode();
#endif
            quadGenerator.WriteToFile(outDir + "IR.ll");
            string bcPath = outDir + "bitcode.bc";
            quadGenerator.WriteBitcodeToFile(bcPath);

            // 生成可执行文件
            ExecutableCreater.CreateExecutable(bcPath, outDir + "CMinusMinus.exe");
        }
    }
}