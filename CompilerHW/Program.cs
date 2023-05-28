//#define SHOW_LEXER
//#define SHOW_PARSER
//#define SHOW_IR

#define GENERATE_EXECUTABLE

using Antlr4.Runtime;
using System.Linq;
using Antlr4.Runtime.Tree;
using System.IO;
using LLVMSharp;

namespace CompilerHW
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            string? inputPath;
            if (args.Length > 0 && File.Exists(args[0]))
            {
                inputPath = args[0];
            }
            else
            {
                Console.WriteLine("请输入待编译文件路径：");
                while (true)
                {
                    inputPath = Console.ReadLine();
                    if (string.IsNullOrEmpty(inputPath))
                    {
                        Console.WriteLine("输入为空，请重新输入：");
                        continue;
                    }
                    if (!File.Exists(inputPath))
                    {
                        Console.WriteLine("文件不存在，请重新输入：");
                        continue;
                    }
                    break;
                }
            }

            using TextReader textReader = File.OpenText(inputPath);
            const string OUT_DIR = "out_files/";
            if (!Directory.Exists(OUT_DIR))
                Directory.CreateDirectory(OUT_DIR);

            // 创建字符流
            AntlrInputStream input = new(textReader);
            textReader.Dispose();
            // 创建词法分析器
            TokenGenerator token = new(input);
            // 通过词法分析器创建Token流
            CommonTokenStream tokens = new(token);
            
#if SHOW_LEXER
            // 展示词法分析结果
            Display.ShowLexer(tokens);
#endif
            const string OUT_LEXER = "LexerResult.txt";
            try
            {
                Display.ShowLexer(tokens, OUT_DIR + OUT_LEXER);
            }
            catch (Exception e)
            {
                Console.WriteLine($"词法解析失败：{e.Message}");
                return;
            }
            Console.WriteLine($"已在 {OUT_DIR} 中生成词法分析结果 {OUT_LEXER}");

            // 通过Token流创建语法分析器
            GrammarGenerator parser = new(tokens);
            // 通过语法分析器创建语法树
            CMinusMinusParser.ProgramContext tree;
            try
            {
                tree = parser.program();
            }
            catch (Exception e)
            {
                Console.WriteLine($"语法解析失败：{e.Message}");
                return;
            }
            DisplayTree display = new (CMinusMinusParser.ruleNames, tree);
#if SHOW_PARSER
            // 展示语法分析结果
            display.PrintTreeAsJson();
#endif
            const string OUT_GRAMMAR = "ParseTree.json";
            display.WriteToFileAsJson(OUT_DIR + OUT_GRAMMAR);
            Console.WriteLine($"已在 {OUT_DIR} 中生成语法分析结果 {OUT_GRAMMAR}");

            // 将语法树转换为IR
            IRGenerator irGenerator = new();
            try
            {
                irGenerator.Generate(tree);
            }
            catch (Exception e)
            {
                Console.WriteLine($"中间代码生成失败：{e.Message}");
                return;
            }

#if SHOW_IR
            // 展示IR
            irGenerator.PrintCode();
#endif
            const string OUT_IR = "IR.ll";
            irGenerator.WriteToFile(OUT_DIR + OUT_IR);
            Console.WriteLine($"已在 {OUT_DIR} 中生成IR {OUT_IR}");

            const string OUT_BITCODE = "bitcode.bc";
            irGenerator.WriteBitcodeToFile(OUT_DIR + OUT_BITCODE);
            Console.WriteLine($"已在 {OUT_DIR} 中生成Bitcode {OUT_BITCODE}");
            irGenerator.Dispose();

#if GENERATE_EXECUTABLE
            // 生成可执行文件
            const string OUT_EXECUTABLE = "CMinusMinus.exe";
            ExecutableGenerator.CreateExecutable(OUT_DIR + OUT_BITCODE, OUT_DIR + OUT_EXECUTABLE);
            Console.WriteLine($"已在 {OUT_DIR} 中生成可执行文件 {OUT_EXECUTABLE}");
#endif

            Console.WriteLine("按任意键退出...");
            Console.ReadKey();
        }
    }
}