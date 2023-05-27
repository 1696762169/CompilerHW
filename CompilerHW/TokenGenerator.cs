using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;

namespace CompilerHW
{
    internal class TokenGenerator : CMinusMinusLexer
    {
        public TokenGenerator(ICharStream input) : base(input)
        {
        }

        public TokenGenerator(ICharStream input, TextWriter output, TextWriter errorOutput) : base(input, output, errorOutput)
        {
        }

        public override string GetErrorDisplay(string s)
        {
            throw new Exception($"未知的符号：{s}，在第 {Line} 行第 {Column + 1} 列");
        }
    }
}
