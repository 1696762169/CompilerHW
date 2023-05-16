// Generated from d:\C#\Homework\CompilerHW\CompilerHW\CMinusMinus.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMinusMinusLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, VOID=2, IF=3, ELSE=4, WHILE=5, RETURN=6, ID=7, NUM=8, ASSIGN=9, 
		PLUS=10, MINUS=11, MULTIPLY=12, DIVIDE=13, EQUALS=14, GREATER=15, GREATER_EQUALS=16, 
		LESS=17, LESS_EQUALS=18, NOT_EQUALS=19, SEMICOLON=20, COMMA=21, COMMENT=22, 
		LINE_COMMENT=23, LEFT_PAREN=24, RIGHT_PAREN=25, LEFT_BRACE=26, RIGHT_BRACE=27, 
		LEFT_BRACKET=28, RIGHT_BRACKET=29, WS=30, END_OF_FILE=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "VOID", "IF", "ELSE", "WHILE", "RETURN", "ID", "NUM", "ASSIGN", 
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "EQUALS", "GREATER", "GREATER_EQUALS", 
			"LESS", "LESS_EQUALS", "NOT_EQUALS", "SEMICOLON", "COMMA", "COMMENT", 
			"LINE_COMMENT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "WS", "END_OF_FILE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'void'", "'if'", "'else'", "'while'", "'return'", null, 
			null, "'='", "'+'", "'-'", "'*'", "'/'", "'=='", "'>'", "'>='", "'<'", 
			"'<='", "'!='", "';'", "','", null, null, "'('", "')'", "'{'", "'}'", 
			"'['", "']'", null, "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "VOID", "IF", "ELSE", "WHILE", "RETURN", "ID", "NUM", "ASSIGN", 
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "EQUALS", "GREATER", "GREATER_EQUALS", 
			"LESS", "LESS_EQUALS", "NOT_EQUALS", "SEMICOLON", "COMMA", "COMMENT", 
			"LINE_COMMENT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "WS", "END_OF_FILE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CMinusMinusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CMinusMinus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00b7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\bb\n\b\f\b\16"+
		"\be\13\b\3\t\6\th\n\t\r\t\16\ti\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u008e\n\27"+
		"\f\27\16\27\u0091\13\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7"+
		"\30\u009c\n\30\f\30\16\30\u009f\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00b0\n\37\r\37\16\37"+
		"\u00b1\3\37\3\37\3 \3 \3\u008f\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\7\4\2C\\c|\5\2\62;C\\c|\3\2\62"+
		";\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u00bb\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\3A\3\2\2\2\5E\3\2\2\2\7J\3\2\2\2\tM\3\2\2\2\13R\3\2\2\2\rX\3\2\2\2\17"+
		"_\3\2\2\2\21g\3\2\2\2\23k\3\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2"+
		"\33s\3\2\2\2\35u\3\2\2\2\37x\3\2\2\2!z\3\2\2\2#}\3\2\2\2%\177\3\2\2\2"+
		"\'\u0082\3\2\2\2)\u0085\3\2\2\2+\u0087\3\2\2\2-\u0089\3\2\2\2/\u0097\3"+
		"\2\2\2\61\u00a2\3\2\2\2\63\u00a4\3\2\2\2\65\u00a6\3\2\2\2\67\u00a8\3\2"+
		"\2\29\u00aa\3\2\2\2;\u00ac\3\2\2\2=\u00af\3\2\2\2?\u00b5\3\2\2\2AB\7k"+
		"\2\2BC\7p\2\2CD\7v\2\2D\4\3\2\2\2EF\7x\2\2FG\7q\2\2GH\7k\2\2HI\7f\2\2"+
		"I\6\3\2\2\2JK\7k\2\2KL\7h\2\2L\b\3\2\2\2MN\7g\2\2NO\7n\2\2OP\7u\2\2PQ"+
		"\7g\2\2Q\n\3\2\2\2RS\7y\2\2ST\7j\2\2TU\7k\2\2UV\7n\2\2VW\7g\2\2W\f\3\2"+
		"\2\2XY\7t\2\2YZ\7g\2\2Z[\7v\2\2[\\\7w\2\2\\]\7t\2\2]^\7p\2\2^\16\3\2\2"+
		"\2_c\t\2\2\2`b\t\3\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\20\3\2"+
		"\2\2ec\3\2\2\2fh\t\4\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\22\3"+
		"\2\2\2kl\7?\2\2l\24\3\2\2\2mn\7-\2\2n\26\3\2\2\2op\7/\2\2p\30\3\2\2\2"+
		"qr\7,\2\2r\32\3\2\2\2st\7\61\2\2t\34\3\2\2\2uv\7?\2\2vw\7?\2\2w\36\3\2"+
		"\2\2xy\7@\2\2y \3\2\2\2z{\7@\2\2{|\7?\2\2|\"\3\2\2\2}~\7>\2\2~$\3\2\2"+
		"\2\177\u0080\7>\2\2\u0080\u0081\7?\2\2\u0081&\3\2\2\2\u0082\u0083\7#\2"+
		"\2\u0083\u0084\7?\2\2\u0084(\3\2\2\2\u0085\u0086\7=\2\2\u0086*\3\2\2\2"+
		"\u0087\u0088\7.\2\2\u0088,\3\2\2\2\u0089\u008a\7\61\2\2\u008a\u008b\7"+
		",\2\2\u008b\u008f\3\2\2\2\u008c\u008e\13\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7,\2\2\u0093\u0094\7\61\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0096\b\27\2\2\u0096.\3\2\2\2\u0097\u0098\7\61\2"+
		"\2\u0098\u0099\7\61\2\2\u0099\u009d\3\2\2\2\u009a\u009c\n\5\2\2\u009b"+
		"\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\b\30\2\2\u00a1"+
		"\60\3\2\2\2\u00a2\u00a3\7*\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7+\2\2\u00a5"+
		"\64\3\2\2\2\u00a6\u00a7\7}\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7\177\2\2"+
		"\u00a98\3\2\2\2\u00aa\u00ab\7]\2\2\u00ab:\3\2\2\2\u00ac\u00ad\7_\2\2\u00ad"+
		"<\3\2\2\2\u00ae\u00b0\t\6\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2"+
		"\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4"+
		"\b\37\2\2\u00b4>\3\2\2\2\u00b5\u00b6\7%\2\2\u00b6@\3\2\2\2\b\2ci\u008f"+
		"\u009d\u00b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}