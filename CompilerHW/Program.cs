using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System.IO;

namespace CompilerHW
{
    internal class Program
    {
        static void Main(string[] args)
        {
            using TextReader text_reader = File.OpenText("input.txt");

            // Create an input character stream from standard in
            AntlrInputStream input = new(text_reader);
            // Create an ExprLexer that feeds from that stream
            CMinusMinusLexer lexer = new(input);
            // Create a stream of tokens fed by the lexer
            CommonTokenStream tokens = new(lexer);
            // Create a parser that feeds off the token stream
            CMinusMinusParser parser = new(tokens);
            // Begin parsing at rule r
            IParseTree tree = parser.program();

            Console.WriteLine(tree.ToStringTree(parser)); // print LISP-style tree

            // Look in obj/Debug/net6.0/HelloParser.cs
            // public RContext r()
        }
    }
}