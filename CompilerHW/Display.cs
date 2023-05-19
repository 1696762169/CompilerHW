using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace CompilerHW
{
    /// <summary>
    /// 提供结果展示方法
    /// </summary>
    internal class Display
    {
        /// <summary>
        /// 展示词法分析结果中的所有Token
        /// </summary>
        public static void ShowLexer(CommonTokenStream tokenStream, string? path = null)
        {
            // 此处减一是为了不要尝试输出EOF 否则会报错
            TextWriter writer = string.IsNullOrEmpty(path) ? Console.Out : File.CreateText(path);
            for (int i = 0; i < tokenStream.GetNumberOfOnChannelTokens() - 1; ++i)
            {
                ShowToken(tokenStream.Get(i), writer);
            }
            writer.Flush();
        }
        /// <summary>
        /// 展示词法分析结果中的部分类型的Token
        /// </summary>
        public static void ShowLexer(CommonTokenStream tokenStream, int[] filter, string? path = null)
        {
            TextWriter writer = string.IsNullOrEmpty(path) ? Console.Out : File.CreateText(path);
            for (int i = 0; i < tokenStream.GetNumberOfOnChannelTokens() - 1; ++i)
            {
                if (!filter.Contains(tokenStream.Get(i).Type))
                    continue;
                ShowToken(tokenStream.Get(i), writer);
            }
            writer.Flush();
        }
        private static void ShowToken(IToken token, TextWriter writer)
        {
            writer.WriteLine($"第 {token.TokenIndex + 1, -3} 个token：{token.Text,-10}，类型：{CMinusMinusLexer.ruleNames[token.Type - 1]}");
        }

        public static void ShowParser(RuleContext tree, string[] ruleNames)
        {
            Console.WriteLine(tree.ToString(ruleNames));
            for (int i = 0; i < tree.ChildCount; ++i)
            {
                ShowParser(RuleContext.GetChildContext(tree, i), ruleNames);
            }
        }
    }
}
