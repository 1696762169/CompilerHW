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
        public static void ShowLexer(CommonTokenStream tokenStream)
        {
            // 此处减一是为了不要尝试输出EOF 否则会报错
            for (int i = 0; i < tokenStream.GetNumberOfOnChannelTokens() - 1; ++i)
            {
                ShowToken(tokenStream.Get(i));
            }
        }
        /// <summary>
        /// 展示词法分析结果中的部分类型的Token
        /// </summary>
        public static void ShowLexer(CommonTokenStream tokenStream, int[] filter)
        {
            for (int i = 0; i < tokenStream.GetNumberOfOnChannelTokens() - 1; ++i)
            {
                if (!filter.Contains(tokenStream.Get(i).Type))
                    continue;
                ShowToken(tokenStream.Get(i));
            }
        }
        private static void ShowToken(IToken token)
        {
            Console.WriteLine($"第 {token.TokenIndex + 1:000} 个token：{token.Text, -10}，类型：{CMinusMinusLexer.ruleNames[token.Type - 1]}");
        }

        public static void ShowParser(IParseTree tree)
        {
            Console.WriteLine(tree.ToStringTree());
        }
    }
}
