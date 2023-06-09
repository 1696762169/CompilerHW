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
		LEFT_BRACKET=28, RIGHT_BRACKET=29, WS=30;
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
			"LEFT_BRACKET", "RIGHT_BRACKET", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'void'", "'if'", "'else'", "'while'", "'return'", null, 
			null, "'='", "'+'", "'-'", "'*'", "'/'", "'=='", "'>'", "'>='", "'<'", 
			"'<='", "'!='", "';'", "','", null, null, "'('", "')'", "'{'", "'}'", 
			"'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "VOID", "IF", "ELSE", "WHILE", "RETURN", "ID", "NUM", "ASSIGN", 
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "EQUALS", "GREATER", "GREATER_EQUALS", 
			"LESS", "LESS_EQUALS", "NOT_EQUALS", "SEMICOLON", "COMMA", "COMMENT", 
			"LINE_COMMENT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00b3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b`\n\b\f\b\16\bc\13"+
		"\b\3\t\6\tf\n\t\r\t\16\tg\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u008c\n\27\f\27"+
		"\16\27\u008f\13\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u009a"+
		"\n\30\f\30\16\30\u009d\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00ae\n\37\r\37\16\37\u00af\3\37"+
		"\3\37\3\u008d\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= \3\2\7\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u00b7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5C\3\2\2\2\7H"+
		"\3\2\2\2\tK\3\2\2\2\13P\3\2\2\2\rV\3\2\2\2\17]\3\2\2\2\21e\3\2\2\2\23"+
		"i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2"+
		"\37v\3\2\2\2!x\3\2\2\2#{\3\2\2\2%}\3\2\2\2\'\u0080\3\2\2\2)\u0083\3\2"+
		"\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2/\u0095\3\2\2\2\61\u00a0\3\2\2\2\63"+
		"\u00a2\3\2\2\2\65\u00a4\3\2\2\2\67\u00a6\3\2\2\29\u00a8\3\2\2\2;\u00aa"+
		"\3\2\2\2=\u00ad\3\2\2\2?@\7k\2\2@A\7p\2\2AB\7v\2\2B\4\3\2\2\2CD\7x\2\2"+
		"DE\7q\2\2EF\7k\2\2FG\7f\2\2G\6\3\2\2\2HI\7k\2\2IJ\7h\2\2J\b\3\2\2\2KL"+
		"\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2O\n\3\2\2\2PQ\7y\2\2QR\7j\2\2RS\7k\2"+
		"\2ST\7n\2\2TU\7g\2\2U\f\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7v\2\2YZ\7w\2\2Z["+
		"\7t\2\2[\\\7p\2\2\\\16\3\2\2\2]a\t\2\2\2^`\t\3\2\2_^\3\2\2\2`c\3\2\2\2"+
		"a_\3\2\2\2ab\3\2\2\2b\20\3\2\2\2ca\3\2\2\2df\t\4\2\2ed\3\2\2\2fg\3\2\2"+
		"\2ge\3\2\2\2gh\3\2\2\2h\22\3\2\2\2ij\7?\2\2j\24\3\2\2\2kl\7-\2\2l\26\3"+
		"\2\2\2mn\7/\2\2n\30\3\2\2\2op\7,\2\2p\32\3\2\2\2qr\7\61\2\2r\34\3\2\2"+
		"\2st\7?\2\2tu\7?\2\2u\36\3\2\2\2vw\7@\2\2w \3\2\2\2xy\7@\2\2yz\7?\2\2"+
		"z\"\3\2\2\2{|\7>\2\2|$\3\2\2\2}~\7>\2\2~\177\7?\2\2\177&\3\2\2\2\u0080"+
		"\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082(\3\2\2\2\u0083\u0084\7=\2\2\u0084"+
		"*\3\2\2\2\u0085\u0086\7.\2\2\u0086,\3\2\2\2\u0087\u0088\7\61\2\2\u0088"+
		"\u0089\7,\2\2\u0089\u008d\3\2\2\2\u008a\u008c\13\2\2\2\u008b\u008a\3\2"+
		"\2\2\u008c\u008f\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7,\2\2\u0091\u0092\7\61"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\27\2\2\u0094.\3\2\2\2\u0095\u0096"+
		"\7\61\2\2\u0096\u0097\7\61\2\2\u0097\u009b\3\2\2\2\u0098\u009a\n\5\2\2"+
		"\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\b\30\2\2"+
		"\u009f\60\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1\62\3\2\2\2\u00a2\u00a3\7+\2"+
		"\2\u00a3\64\3\2\2\2\u00a4\u00a5\7}\2\2\u00a5\66\3\2\2\2\u00a6\u00a7\7"+
		"\177\2\2\u00a78\3\2\2\2\u00a8\u00a9\7]\2\2\u00a9:\3\2\2\2\u00aa\u00ab"+
		"\7_\2\2\u00ab<\3\2\2\2\u00ac\u00ae\t\6\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\b\37\2\2\u00b2>\3\2\2\2\b\2ag\u008d\u009b\u00af\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}