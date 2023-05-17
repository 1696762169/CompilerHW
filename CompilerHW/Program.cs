//#define SHOW_LEXER
#define SHOW_PARSER
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System.IO;

namespace CompilerHW
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            using TextReader textReader = File.OpenText("input.txt");

            // 创建字符流
            AntlrInputStream input = new(textReader);
            // 创建词法分析器
            CMinusMinusLexer lexer = new(input);
            // 通过词法分析器创建Token流
            CommonTokenStream tokens = new(lexer);
#if SHOW_LEXER
            // 展示词法分析结果
            Display.ShowLexer(tokens, new[]
            {
                CMinusMinusLexer.INT,
                CMinusMinusLexer.VOID,
                CMinusMinusLexer.IF,
                CMinusMinusLexer.ELSE,
                CMinusMinusLexer.WHILE,
                CMinusMinusLexer.RETURN,
            });
            Display.ShowLexer(tokens, new[]
            {
                CMinusMinusLexer.ID,
            });
#endif

            // 通过Token流创建语法分析器
            CMinusMinusParser parser = new(tokens);
            // 通过语法分析器创建语法树
            IParseTree tree = parser.program();
#if SHOW_PARSER
            // 展示语法分析结果
            Display.ShowParser(tree);
#endif
        }
    }
}