// Generated from d:\C#\Homework\CompilerHW\CompilerHW\CMinusMinus.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMinusMinusParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_declarationType = 2, RULE_variableDeclaration = 3, 
		RULE_functionDeclaration = 4, RULE_arrayDeclaration = 5, RULE_parameterList = 6, 
		RULE_parameter = 7, RULE_block = 8, RULE_innerDeclaration = 9, RULE_statement = 10, 
		RULE_assignmentStatement = 11, RULE_returnStatement = 12, RULE_whileStatement = 13, 
		RULE_ifStatement = 14, RULE_expression = 15, RULE_additiveExpression = 16, 
		RULE_term = 17, RULE_factor = 18, RULE_ftype = 19, RULE_call = 20, RULE_array = 21, 
		RULE_argument = 22, RULE_relop = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "declarationType", "variableDeclaration", "functionDeclaration", 
			"arrayDeclaration", "parameterList", "parameter", "block", "innerDeclaration", 
			"statement", "assignmentStatement", "returnStatement", "whileStatement", 
			"ifStatement", "expression", "additiveExpression", "term", "factor", 
			"ftype", "call", "array", "argument", "relop"
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

	@Override
	public String getGrammarFileName() { return "CMinusMinus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CMinusMinusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode END_OF_FILE() { return getToken(CMinusMinusParser.END_OF_FILE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==VOID) {
				{
				{
				setState(48);
				declaration();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(END_OF_FILE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CMinusMinusParser.INT, 0); }
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public DeclarationTypeContext declarationType() {
			return getRuleContext(DeclarationTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CMinusMinusParser.VOID, 0); }
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(INT);
				setState(57);
				match(ID);
				setState(58);
				declarationType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(VOID);
				setState(60);
				match(ID);
				setState(61);
				functionDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationTypeContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public DeclarationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationType; }
	}

	public final DeclarationTypeContext declarationType() throws RecognitionException {
		DeclarationTypeContext _localctx = new DeclarationTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarationType);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				variableDeclaration();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				functionDeclaration();
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				arrayDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(CMinusMinusParser.LEFT_PAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CMinusMinusParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(LEFT_PAREN);
			setState(72);
			parameterList();
			setState(73);
			match(RIGHT_PAREN);
			setState(74);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> LEFT_BRACKET() { return getTokens(CMinusMinusParser.LEFT_BRACKET); }
		public TerminalNode LEFT_BRACKET(int i) {
			return getToken(CMinusMinusParser.LEFT_BRACKET, i);
		}
		public List<TerminalNode> NUM() { return getTokens(CMinusMinusParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(CMinusMinusParser.NUM, i);
		}
		public List<TerminalNode> RIGHT_BRACKET() { return getTokens(CMinusMinusParser.RIGHT_BRACKET); }
		public TerminalNode RIGHT_BRACKET(int i) {
			return getToken(CMinusMinusParser.RIGHT_BRACKET, i);
		}
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(LEFT_BRACKET);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				match(NUM);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_BRACKET) {
				{
				{
				setState(82);
				match(LEFT_BRACKET);
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(83);
					match(NUM);
					}
					}
					setState(86); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUM );
				setState(88);
				match(RIGHT_BRACKET);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CMinusMinusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CMinusMinusParser.COMMA, i);
		}
		public TerminalNode VOID() { return getToken(CMinusMinusParser.VOID, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameterList);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				parameter();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(95);
					match(COMMA);
					setState(96);
					parameter();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CMinusMinusParser.INT, 0); }
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(INT);
			setState(106);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(CMinusMinusParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(CMinusMinusParser.RIGHT_BRACE, 0); }
		public List<InnerDeclarationContext> innerDeclaration() {
			return getRuleContexts(InnerDeclarationContext.class);
		}
		public InnerDeclarationContext innerDeclaration(int i) {
			return getRuleContext(InnerDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(LEFT_BRACE);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==SEMICOLON) {
				{
				{
				setState(109);
				innerDeclaration();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(115);
				statement();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerDeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public TerminalNode INT() { return getToken(CMinusMinusParser.INT, 0); }
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public InnerDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerDeclaration; }
	}

	public final InnerDeclarationContext innerDeclaration() throws RecognitionException {
		InnerDeclarationContext _localctx = new InnerDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_innerDeclaration);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				variableDeclaration();
				setState(124);
				match(SEMICOLON);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(INT);
				setState(127);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				whileStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				returnStatement();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				assignmentStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CMinusMinusParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignmentStatement);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(ID);
				setState(137);
				match(ASSIGN);
				setState(138);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				array(0);
				setState(140);
				match(ASSIGN);
				setState(141);
				expression();
				setState(142);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CMinusMinusParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(RETURN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUM) | (1L << LEFT_PAREN))) != 0)) {
				{
				setState(147);
				expression();
				}
			}

			setState(150);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CMinusMinusParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CMinusMinusParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CMinusMinusParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(WHILE);
			setState(153);
			match(LEFT_PAREN);
			setState(154);
			expression();
			setState(155);
			match(RIGHT_PAREN);
			setState(156);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CMinusMinusParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CMinusMinusParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CMinusMinusParser.RIGHT_PAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CMinusMinusParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(IF);
			setState(159);
			match(LEFT_PAREN);
			setState(160);
			expression();
			setState(161);
			match(RIGHT_PAREN);
			setState(162);
			block();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(163);
				match(ELSE);
				setState(164);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<RelopContext> relop() {
			return getRuleContexts(RelopContext.class);
		}
		public RelopContext relop(int i) {
			return getRuleContext(RelopContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			additiveExpression();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATER) | (1L << GREATER_EQUALS) | (1L << LESS) | (1L << LESS_EQUALS) | (1L << NOT_EQUALS))) != 0)) {
				{
				{
				setState(168);
				relop();
				setState(169);
				additiveExpression();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CMinusMinusParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CMinusMinusParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CMinusMinusParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CMinusMinusParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			term();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(177);
					match(PLUS);
					setState(178);
					term();
					}
					break;
				case MINUS:
					{
					setState(179);
					match(MINUS);
					setState(180);
					term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(CMinusMinusParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(CMinusMinusParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(CMinusMinusParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(CMinusMinusParser.DIVIDE, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			factor();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				setState(191);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULTIPLY:
					{
					setState(187);
					match(MULTIPLY);
					setState(188);
					factor();
					}
					break;
				case DIVIDE:
					{
					setState(189);
					match(DIVIDE);
					setState(190);
					factor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(CMinusMinusParser.NUM, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(CMinusMinusParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CMinusMinusParser.RIGHT_PAREN, 0); }
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public FtypeContext ftype() {
			return getRuleContext(FtypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_factor);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(LEFT_PAREN);
				setState(198);
				expression();
				setState(199);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(ID);
				setState(202);
				ftype();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				array(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FtypeContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ftype; }
	}

	public final FtypeContext ftype() throws RecognitionException {
		FtypeContext _localctx = new FtypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ftype);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(206);
					call();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(CMinusMinusParser.LEFT_PAREN, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(CMinusMinusParser.RIGHT_PAREN, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LEFT_PAREN);
			setState(213);
			argument();
			setState(214);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(CMinusMinusParser.LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(CMinusMinusParser.RIGHT_BRACKET, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		return array(0);
	}

	private ArrayContext array(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayContext _localctx = new ArrayContext(_ctx, _parentState);
		ArrayContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_array, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(217);
			match(ID);
			setState(218);
			match(LEFT_BRACKET);
			setState(219);
			expression();
			setState(220);
			match(RIGHT_BRACKET);
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_array);
					setState(222);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(223);
					match(LEFT_BRACKET);
					setState(224);
					expression();
					setState(225);
					match(RIGHT_BRACKET);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CMinusMinusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CMinusMinusParser.COMMA, i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUM:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				expression();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(233);
					match(COMMA);
					setState(234);
					expression();
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RIGHT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(CMinusMinusParser.LESS, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(CMinusMinusParser.LESS_EQUALS, 0); }
		public TerminalNode GREATER() { return getToken(CMinusMinusParser.GREATER, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(CMinusMinusParser.GREATER_EQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(CMinusMinusParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(CMinusMinusParser.NOT_EQUALS, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATER) | (1L << GREATER_EQUALS) | (1L << LESS) | (1L << LESS_EQUALS) | (1L << NOT_EQUALS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return array_sempred((ArrayContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean array_sempred(ArrayContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3A"+
		"\n\3\3\4\3\4\3\4\5\4F\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\6\7Q\n\7"+
		"\r\7\16\7R\3\7\3\7\6\7W\n\7\r\7\16\7X\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b"+
		"\3\b\3\b\7\bd\n\b\f\b\16\bg\13\b\3\b\5\bj\n\b\3\t\3\t\3\t\3\n\3\n\7\n"+
		"q\n\n\f\n\16\nt\13\n\3\n\7\nw\n\n\f\n\16\nz\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0083\n\13\3\f\3\f\3\f\3\f\5\f\u0089\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0093\n\r\3\16\3\16\5\16\u0097\n\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a8"+
		"\n\20\3\21\3\21\3\21\3\21\7\21\u00ae\n\21\f\21\16\21\u00b1\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u00b8\n\22\f\22\16\22\u00bb\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00c2\n\23\f\23\16\23\u00c5\13\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00cf\n\24\3\25\5\25\u00d2\n\25\3\25\5"+
		"\25\u00d5\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u00e6\n\27\f\27\16\27\u00e9\13\27\3\30\3\30"+
		"\3\30\7\30\u00ee\n\30\f\30\16\30\u00f1\13\30\3\30\5\30\u00f4\n\30\3\31"+
		"\3\31\3\31\2\3,\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\2\3\3\2\20\25\2\u00fe\2\65\3\2\2\2\4@\3\2\2\2\6E\3\2\2\2\bG\3\2\2\2\n"+
		"I\3\2\2\2\fN\3\2\2\2\16i\3\2\2\2\20k\3\2\2\2\22n\3\2\2\2\24\u0082\3\2"+
		"\2\2\26\u0088\3\2\2\2\30\u0092\3\2\2\2\32\u0094\3\2\2\2\34\u009a\3\2\2"+
		"\2\36\u00a0\3\2\2\2 \u00a9\3\2\2\2\"\u00b2\3\2\2\2$\u00bc\3\2\2\2&\u00ce"+
		"\3\2\2\2(\u00d4\3\2\2\2*\u00d6\3\2\2\2,\u00da\3\2\2\2.\u00f3\3\2\2\2\60"+
		"\u00f5\3\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7!\2\29\3\3\2\2\2:;\7\3\2\2"+
		";<\7\t\2\2<A\5\6\4\2=>\7\4\2\2>?\7\t\2\2?A\5\n\6\2@:\3\2\2\2@=\3\2\2\2"+
		"A\5\3\2\2\2BF\5\b\5\2CF\5\n\6\2DF\5\f\7\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2"+
		"\2F\7\3\2\2\2GH\7\26\2\2H\t\3\2\2\2IJ\7\32\2\2JK\5\16\b\2KL\7\33\2\2L"+
		"M\5\22\n\2M\13\3\2\2\2NP\7\36\2\2OQ\7\n\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2"+
		"\2\2RS\3\2\2\2S]\3\2\2\2TV\7\36\2\2UW\7\n\2\2VU\3\2\2\2WX\3\2\2\2XV\3"+
		"\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7\37\2\2[T\3\2\2\2\\_\3\2\2\2][\3\2\2\2"+
		"]^\3\2\2\2^\r\3\2\2\2_]\3\2\2\2`e\5\20\t\2ab\7\27\2\2bd\5\20\t\2ca\3\2"+
		"\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fj\3\2\2\2ge\3\2\2\2hj\7\4\2\2i`\3\2"+
		"\2\2ih\3\2\2\2j\17\3\2\2\2kl\7\3\2\2lm\7\t\2\2m\21\3\2\2\2nr\7\34\2\2"+
		"oq\5\24\13\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sx\3\2\2\2tr\3\2\2"+
		"\2uw\5\26\f\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2"+
		"\2\2{|\7\35\2\2|\23\3\2\2\2}~\5\b\5\2~\177\7\26\2\2\177\u0083\3\2\2\2"+
		"\u0080\u0081\7\3\2\2\u0081\u0083\7\t\2\2\u0082}\3\2\2\2\u0082\u0080\3"+
		"\2\2\2\u0083\25\3\2\2\2\u0084\u0089\5\36\20\2\u0085\u0089\5\34\17\2\u0086"+
		"\u0089\5\32\16\2\u0087\u0089\5\30\r\2\u0088\u0084\3\2\2\2\u0088\u0085"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\27\3\2\2\2\u008a"+
		"\u008b\7\t\2\2\u008b\u008c\7\13\2\2\u008c\u0093\5 \21\2\u008d\u008e\5"+
		",\27\2\u008e\u008f\7\13\2\2\u008f\u0090\5 \21\2\u0090\u0091\7\26\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008d\3\2\2\2\u0093\31\3\2\2"+
		"\2\u0094\u0096\7\b\2\2\u0095\u0097\5 \21\2\u0096\u0095\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\26\2\2\u0099\33\3\2\2\2\u009a"+
		"\u009b\7\7\2\2\u009b\u009c\7\32\2\2\u009c\u009d\5 \21\2\u009d\u009e\7"+
		"\33\2\2\u009e\u009f\5\22\n\2\u009f\35\3\2\2\2\u00a0\u00a1\7\5\2\2\u00a1"+
		"\u00a2\7\32\2\2\u00a2\u00a3\5 \21\2\u00a3\u00a4\7\33\2\2\u00a4\u00a7\5"+
		"\22\n\2\u00a5\u00a6\7\6\2\2\u00a6\u00a8\5\22\n\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\37\3\2\2\2\u00a9\u00af\5\"\22\2\u00aa\u00ab\5\60"+
		"\31\2\u00ab\u00ac\5\"\22\2\u00ac\u00ae\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0!\3\2\2\2"+
		"\u00b1\u00af\3\2\2\2\u00b2\u00b9\5$\23\2\u00b3\u00b4\7\f\2\2\u00b4\u00b8"+
		"\5$\23\2\u00b5\u00b6\7\r\2\2\u00b6\u00b8\5$\23\2\u00b7\u00b3\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba#\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00c3\5&\24\2\u00bd\u00be"+
		"\7\16\2\2\u00be\u00c2\5&\24\2\u00bf\u00c0\7\17\2\2\u00c0\u00c2\5&\24\2"+
		"\u00c1\u00bd\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4%\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00cf\7\n\2\2\u00c7\u00c8\7\32\2\2\u00c8\u00c9\5 \21\2\u00c9\u00ca\7"+
		"\33\2\2\u00ca\u00cf\3\2\2\2\u00cb\u00cc\7\t\2\2\u00cc\u00cf\5(\25\2\u00cd"+
		"\u00cf\5,\27\2\u00ce\u00c6\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00cb\3\2"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00cf\'\3\2\2\2\u00d0\u00d2\5*\26\2\u00d1\u00d0"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00d1\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5)\3\2\2\2\u00d6\u00d7\7\32\2\2"+
		"\u00d7\u00d8\5.\30\2\u00d8\u00d9\7\33\2\2\u00d9+\3\2\2\2\u00da\u00db\b"+
		"\27\1\2\u00db\u00dc\7\t\2\2\u00dc\u00dd\7\36\2\2\u00dd\u00de\5 \21\2\u00de"+
		"\u00df\7\37\2\2\u00df\u00e7\3\2\2\2\u00e0\u00e1\f\3\2\2\u00e1\u00e2\7"+
		"\36\2\2\u00e2\u00e3\5 \21\2\u00e3\u00e4\7\37\2\2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00e0\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8-\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ef\5 \21\2\u00eb\u00ec"+
		"\7\27\2\2\u00ec\u00ee\5 \21\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2"+
		"\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"/\3\2\2\2\u00f5\u00f6\t\2\2\2\u00f6\61\3\2\2\2\34\65@ERX]eirx\u0082\u0088"+
		"\u0092\u0096\u00a7\u00af\u00b7\u00b9\u00c1\u00c3\u00ce\u00d1\u00d4\u00e7"+
		"\u00ef\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}