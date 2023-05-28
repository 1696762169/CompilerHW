using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Dfa;
using Antlr4.Runtime.Sharpen;

namespace CompilerHW
{
    internal sealed class GrammarGenerator : CMinusMinusParser
    {
        public GrammarGenerator(ITokenStream input) : this(input, Console.Out, Console.Error) { }

        public GrammarGenerator(ITokenStream input, TextWriter output, TextWriter errorOutput) : base(input, output, errorOutput)
        {
            RemoveErrorListeners();
            AddErrorListener(new ParseErrorListener());
        }

        internal class ParseErrorListener : IParserErrorListener
        {
            public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine,
                string msg, RecognitionException e)
            {
                throw new Exception($"在第 {line} 行第 {charPositionInLine + 1} 列的符号 {offendingSymbol.Text} 附近发生错误\n内部错误：{msg}");
            }

            public void ReportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, bool exact, BitSet ambigAlts,
                ATNConfigSet configs) { }

            public void ReportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts,
                SimulatorState conflictState) { }

            public void ReportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
                SimulatorState acceptState) { }
        }
    }
}
