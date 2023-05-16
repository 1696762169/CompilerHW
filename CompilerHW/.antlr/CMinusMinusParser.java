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
		LEFT_BRACKET=28, RIGHT_BRACKET=29, WS=30;
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
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(INT);
				setState(55);
				match(ID);
				setState(56);
				declarationType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(VOID);
				setState(58);
				match(ID);
				setState(59);
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
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				variableDeclaration();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				functionDeclaration();
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
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
			setState(67);
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
			setState(69);
			match(LEFT_PAREN);
			setState(70);
			parameterList();
			setState(71);
			match(RIGHT_PAREN);
			setState(72);
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
			setState(74);
			match(LEFT_BRACKET);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				match(NUM);
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFT_BRACKET) {
				{
				{
				setState(80);
				match(LEFT_BRACKET);
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(81);
					match(NUM);
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUM );
				setState(86);
				match(RIGHT_BRACKET);
				}
				}
				setState(91);
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
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				parameter();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(93);
					match(COMMA);
					setState(94);
					parameter();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
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
			setState(103);
			match(INT);
			setState(104);
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
			setState(106);
			match(LEFT_BRACE);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==SEMICOLON) {
				{
				{
				setState(107);
				innerDeclaration();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << ID))) != 0)) {
				{
				{
				setState(113);
				statement();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				variableDeclaration();
				setState(122);
				match(SEMICOLON);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(INT);
				setState(125);
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
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				whileStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				returnStatement();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
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
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(ID);
				setState(135);
				match(ASSIGN);
				setState(136);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				array(0);
				setState(138);
				match(ASSIGN);
				setState(139);
				expression();
				setState(140);
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
			setState(144);
			match(RETURN);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUM) | (1L << LEFT_PAREN))) != 0)) {
				{
				setState(145);
				expression();
				}
			}

			setState(148);
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
			setState(150);
			match(WHILE);
			setState(151);
			match(LEFT_PAREN);
			setState(152);
			expression();
			setState(153);
			match(RIGHT_PAREN);
			setState(154);
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
			setState(156);
			match(IF);
			setState(157);
			match(LEFT_PAREN);
			setState(158);
			expression();
			setState(159);
			match(RIGHT_PAREN);
			setState(160);
			block();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(161);
				match(ELSE);
				setState(162);
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
			setState(165);
			additiveExpression();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATER) | (1L << GREATER_EQUALS) | (1L << LESS) | (1L << LESS_EQUALS) | (1L << NOT_EQUALS))) != 0)) {
				{
				{
				setState(166);
				relop();
				setState(167);
				additiveExpression();
				}
				}
				setState(173);
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
			setState(174);
			term();
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(175);
					match(PLUS);
					setState(176);
					term();
					}
					break;
				case MINUS:
					{
					setState(177);
					match(MINUS);
					setState(178);
					term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(183);
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
			setState(184);
			factor();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				setState(189);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULTIPLY:
					{
					setState(185);
					match(MULTIPLY);
					setState(186);
					factor();
					}
					break;
				case DIVIDE:
					{
					setState(187);
					match(DIVIDE);
					setState(188);
					factor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(193);
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
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(LEFT_PAREN);
				setState(196);
				expression();
				setState(197);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(ID);
				setState(200);
				ftype();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
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
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(204);
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
			setState(210);
			match(LEFT_PAREN);
			setState(211);
			argument();
			setState(212);
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
			setState(215);
			match(ID);
			setState(216);
			match(LEFT_BRACKET);
			setState(217);
			expression();
			setState(218);
			match(RIGHT_BRACKET);
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
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
					setState(220);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(221);
					match(LEFT_BRACKET);
					setState(222);
					expression();
					setState(223);
					match(RIGHT_BRACKET);
					}
					} 
				}
				setState(229);
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
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUM:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				expression();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(231);
					match(COMMA);
					setState(232);
					expression();
					}
					}
					setState(237);
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
			setState(241);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\4"+
		"\3\4\3\4\5\4D\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\6\7O\n\7\r\7\16"+
		"\7P\3\7\3\7\6\7U\n\7\r\7\16\7V\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\b\3\b\3\b"+
		"\7\bb\n\b\f\b\16\be\13\b\3\b\5\bh\n\b\3\t\3\t\3\t\3\n\3\n\7\no\n\n\f\n"+
		"\16\nr\13\n\3\n\7\nu\n\n\f\n\16\nx\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0081\n\13\3\f\3\f\3\f\3\f\5\f\u0087\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u0091\n\r\3\16\3\16\5\16\u0095\n\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a6"+
		"\n\20\3\21\3\21\3\21\3\21\7\21\u00ac\n\21\f\21\16\21\u00af\13\21\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u00b6\n\22\f\22\16\22\u00b9\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00c0\n\23\f\23\16\23\u00c3\13\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00cd\n\24\3\25\5\25\u00d0\n\25\3\25\5"+
		"\25\u00d3\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7\13\27\3\30\3\30"+
		"\3\30\7\30\u00ec\n\30\f\30\16\30\u00ef\13\30\3\30\5\30\u00f2\n\30\3\31"+
		"\3\31\3\31\2\3,\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\2\3\3\2\20\25\2\u00fc\2\65\3\2\2\2\4>\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\n"+
		"G\3\2\2\2\fL\3\2\2\2\16g\3\2\2\2\20i\3\2\2\2\22l\3\2\2\2\24\u0080\3\2"+
		"\2\2\26\u0086\3\2\2\2\30\u0090\3\2\2\2\32\u0092\3\2\2\2\34\u0098\3\2\2"+
		"\2\36\u009e\3\2\2\2 \u00a7\3\2\2\2\"\u00b0\3\2\2\2$\u00ba\3\2\2\2&\u00cc"+
		"\3\2\2\2(\u00d2\3\2\2\2*\u00d4\3\2\2\2,\u00d8\3\2\2\2.\u00f1\3\2\2\2\60"+
		"\u00f3\3\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\66\3\3\2\2\2\67\65\3\2\2\289\7\3\2\29:\7\t\2\2:?\5\6\4"+
		"\2;<\7\4\2\2<=\7\t\2\2=?\5\n\6\2>8\3\2\2\2>;\3\2\2\2?\5\3\2\2\2@D\5\b"+
		"\5\2AD\5\n\6\2BD\5\f\7\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\7\3\2\2\2EF\7"+
		"\26\2\2F\t\3\2\2\2GH\7\32\2\2HI\5\16\b\2IJ\7\33\2\2JK\5\22\n\2K\13\3\2"+
		"\2\2LN\7\36\2\2MO\7\n\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q[\3"+
		"\2\2\2RT\7\36\2\2SU\7\n\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX"+
		"\3\2\2\2XZ\7\37\2\2YR\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\r\3\2\2"+
		"\2][\3\2\2\2^c\5\20\t\2_`\7\27\2\2`b\5\20\t\2a_\3\2\2\2be\3\2\2\2ca\3"+
		"\2\2\2cd\3\2\2\2dh\3\2\2\2ec\3\2\2\2fh\7\4\2\2g^\3\2\2\2gf\3\2\2\2h\17"+
		"\3\2\2\2ij\7\3\2\2jk\7\t\2\2k\21\3\2\2\2lp\7\34\2\2mo\5\24\13\2nm\3\2"+
		"\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qv\3\2\2\2rp\3\2\2\2su\5\26\f\2ts\3"+
		"\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\35\2\2z\23"+
		"\3\2\2\2{|\5\b\5\2|}\7\26\2\2}\u0081\3\2\2\2~\177\7\3\2\2\177\u0081\7"+
		"\t\2\2\u0080{\3\2\2\2\u0080~\3\2\2\2\u0081\25\3\2\2\2\u0082\u0087\5\36"+
		"\20\2\u0083\u0087\5\34\17\2\u0084\u0087\5\32\16\2\u0085\u0087\5\30\r\2"+
		"\u0086\u0082\3\2\2\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\27\3\2\2\2\u0088\u0089\7\t\2\2\u0089\u008a\7\13\2\2\u008a"+
		"\u0091\5 \21\2\u008b\u008c\5,\27\2\u008c\u008d\7\13\2\2\u008d\u008e\5"+
		" \21\2\u008e\u008f\7\26\2\2\u008f\u0091\3\2\2\2\u0090\u0088\3\2\2\2\u0090"+
		"\u008b\3\2\2\2\u0091\31\3\2\2\2\u0092\u0094\7\b\2\2\u0093\u0095\5 \21"+
		"\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\7\26\2\2\u0097\33\3\2\2\2\u0098\u0099\7\7\2\2\u0099\u009a\7\32\2\2\u009a"+
		"\u009b\5 \21\2\u009b\u009c\7\33\2\2\u009c\u009d\5\22\n\2\u009d\35\3\2"+
		"\2\2\u009e\u009f\7\5\2\2\u009f\u00a0\7\32\2\2\u00a0\u00a1\5 \21\2\u00a1"+
		"\u00a2\7\33\2\2\u00a2\u00a5\5\22\n\2\u00a3\u00a4\7\6\2\2\u00a4\u00a6\5"+
		"\22\n\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\37\3\2\2\2\u00a7"+
		"\u00ad\5\"\22\2\u00a8\u00a9\5\60\31\2\u00a9\u00aa\5\"\22\2\u00aa\u00ac"+
		"\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae!\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b7\5$\23\2"+
		"\u00b1\u00b2\7\f\2\2\u00b2\u00b6\5$\23\2\u00b3\u00b4\7\r\2\2\u00b4\u00b6"+
		"\5$\23\2\u00b5\u00b1\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8#\3\2\2\2\u00b9\u00b7\3\2\2\2"+
		"\u00ba\u00c1\5&\24\2\u00bb\u00bc\7\16\2\2\u00bc\u00c0\5&\24\2\u00bd\u00be"+
		"\7\17\2\2\u00be\u00c0\5&\24\2\u00bf\u00bb\3\2\2\2\u00bf\u00bd\3\2\2\2"+
		"\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2%\3"+
		"\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00cd\7\n\2\2\u00c5\u00c6\7\32\2\2\u00c6"+
		"\u00c7\5 \21\2\u00c7\u00c8\7\33\2\2\u00c8\u00cd\3\2\2\2\u00c9\u00ca\7"+
		"\t\2\2\u00ca\u00cd\5(\25\2\u00cb\u00cd\5,\27\2\u00cc\u00c4\3\2\2\2\u00cc"+
		"\u00c5\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\'\3\2\2\2"+
		"\u00ce\u00d0\5*\26\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3"+
		"\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		")\3\2\2\2\u00d4\u00d5\7\32\2\2\u00d5\u00d6\5.\30\2\u00d6\u00d7\7\33\2"+
		"\2\u00d7+\3\2\2\2\u00d8\u00d9\b\27\1\2\u00d9\u00da\7\t\2\2\u00da\u00db"+
		"\7\36\2\2\u00db\u00dc\5 \21\2\u00dc\u00dd\7\37\2\2\u00dd\u00e5\3\2\2\2"+
		"\u00de\u00df\f\3\2\2\u00df\u00e0\7\36\2\2\u00e0\u00e1\5 \21\2\u00e1\u00e2"+
		"\7\37\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00de\3\2\2\2\u00e4\u00e7\3\2\2\2"+
		"\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6-\3\2\2\2\u00e7\u00e5\3"+
		"\2\2\2\u00e8\u00ed\5 \21\2\u00e9\u00ea\7\27\2\2\u00ea\u00ec\5 \21\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00f2\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00e8\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2/\3\2\2\2\u00f3\u00f4\t\2\2\2"+
		"\u00f4\61\3\2\2\2\34\65>CPV[cgpv\u0080\u0086\u0090\u0094\u00a5\u00ad\u00b5"+
		"\u00b7\u00bf\u00c1\u00cc\u00cf\u00d2\u00e5\u00ed\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}