// Generated from C:/Users/Gianluca/git/FOOL2017/src/parser\FOOL.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMIC=1, COLON=2, COMMA=3, EQ=4, ASM=5, PLUS=6, MINUS=7, TIMES=8, DIV=9, 
		TRUE=10, FALSE=11, LPAR=12, RPAR=13, CLPAR=14, CRPAR=15, IF=16, THEN=17, 
		ELSE=18, LET=19, IN=20, VAR=21, FUN=22, INT=23, BOOL=24, CLASS=25, IMPLEMENTS=26, 
		THIS=27, NEW=28, DOT=29, INTEGER=30, ID=31, WS=32, LINECOMENTS=33, BLOCKCOMENTS=34, 
		ERR=35;
	public static final int
		RULE_prog = 0, RULE_simpleprog = 1, RULE_classdec = 2, RULE_let = 3, RULE_vardec = 4, 
		RULE_varasm = 5, RULE_fun = 6, RULE_dec = 7, RULE_type = 8, RULE_exp = 9, 
		RULE_term = 10, RULE_factor = 11, RULE_value = 12;
	public static final String[] ruleNames = {
		"prog", "simpleprog", "classdec", "let", "vardec", "varasm", "fun", "dec", 
		"type", "exp", "term", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "','", "'=='", "'='", "'+'", "'-'", "'*'", "'/'", 
		"'true'", "'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'implements'", 
		"'this'", "'new'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", "TIMES", 
		"DIV", "TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", 
		"ELSE", "LET", "IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "IMPLEMENTS", 
		"THIS", "NEW", "DOT", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
		"ERR"
	};
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
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassExpContext extends ProgContext {
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public SimpleprogContext simpleprog() {
			return getRuleContext(SimpleprogContext.class,0);
		}
		public List<ClassdecContext> classdec() {
			return getRuleContexts(ClassdecContext.class);
		}
		public ClassdecContext classdec(int i) {
			return getRuleContext(ClassdecContext.class,i);
		}
		public ClassExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitClassExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProgExpContext extends ProgContext {
		public SimpleprogContext simpleprog() {
			return getRuleContext(SimpleprogContext.class,0);
		}
		public ProgExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitProgExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case LET:
			case THIS:
			case NEW:
			case INTEGER:
			case ID:
				_localctx = new ProgExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				simpleprog();
				}
				break;
			case CLASS:
				_localctx = new ClassExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(27);
					classdec();
					}
					}
					setState(30); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CLASS );
				setState(32);
				match(SEMIC);
				setState(33);
				simpleprog();
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

	public static class SimpleprogContext extends ParserRuleContext {
		public SimpleprogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleprog; }
	 
		public SimpleprogContext() { }
		public void copyFrom(SimpleprogContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpContext extends SimpleprogContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public LetInExpContext(SimpleprogContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends SimpleprogContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public SingleExpContext(SimpleprogContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleprogContext simpleprog() throws RecognitionException {
		SimpleprogContext _localctx = new SimpleprogContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_simpleprog);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case THIS:
			case NEW:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				exp();
				setState(38);
				match(SEMIC);
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				let();
				setState(41);
				exp();
				setState(42);
				match(SEMIC);
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

	public static class ClassdecContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FOOLParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode IMPLEMENTS() { return getToken(FOOLParser.IMPLEMENTS, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FOOLParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FOOLParser.CRPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public ClassdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitClassdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdecContext classdec() throws RecognitionException {
		ClassdecContext _localctx = new ClassdecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(CLASS);
			setState(47);
			match(ID);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(48);
				match(IMPLEMENTS);
				setState(49);
				match(ID);
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(52);
				match(LPAR);
				setState(53);
				vardec();
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(54);
					match(COMMA);
					setState(55);
					vardec();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(RPAR);
				}
			}

			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(65);
				match(CLPAR);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(66);
					fun();
					setState(67);
					match(SEMIC);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0) );
				setState(73);
				match(CRPAR);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(LET);
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				dec();
				setState(79);
				match(SEMIC);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0) );
			setState(85);
			match(IN);
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			type();
			setState(88);
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

	public static class VarasmContext extends ParserRuleContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode ASM() { return getToken(FOOLParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarasm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			vardec();
			setState(91);
			match(ASM);
			setState(92);
			exp();
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			type();
			setState(95);
			match(ID);
			setState(96);
			match(LPAR);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				setState(97);
				vardec();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(98);
					match(COMMA);
					setState(99);
					vardec();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(107);
			match(RPAR);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(108);
				let();
				}
			}

			setState(111);
			exp();
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignmentContext extends DecContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarAssignmentContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFunDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dec);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new VarAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				varasm();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				fun();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) ) {
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

	public static class ExpContext extends ParserRuleContext {
		public TermContext left;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FOOLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(119);
				match(MINUS);
				}
			}

			setState(122);
			((ExpContext)_localctx).left = term();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(123);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(124);
				((ExpContext)_localctx).right = exp();
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FOOLParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FOOLParser.DIV, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((TermContext)_localctx).left = factor();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(128);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				((TermContext)_localctx).right = term();
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FOOLParser.EQ, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			((FactorContext)_localctx).left = value();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(133);
				match(EQ);
				setState(134);
				((FactorContext)_localctx).right = value();
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public VarExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodExpContext extends ValueContext {
		public TerminalNode DOT() { return getToken(FOOLParser.DOT, 0); }
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode THIS() { return getToken(FOOLParser.THIS, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public MethodExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitMethodExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpContext extends ValueContext {
		public TerminalNode NEW() { return getToken(FOOLParser.NEW, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public NewExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitNewExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpContext extends ValueContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitIfExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExpContext extends ValueContext {
		public TerminalNode THIS() { return getToken(FOOLParser.THIS, 0); }
		public ThisExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitThisExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public FunExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(LPAR);
				setState(140);
				exp();
				setState(141);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(IF);
				setState(144);
				((IfExpContext)_localctx).cond = exp();
				setState(145);
				match(THEN);
				setState(146);
				match(CLPAR);
				setState(147);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(148);
				match(CRPAR);
				setState(149);
				match(ELSE);
				setState(150);
				match(CLPAR);
				setState(151);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(152);
				match(CRPAR);
				}
				break;
			case 5:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(ID);
				}
				break;
			case 6:
				_localctx = new ThisExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				match(THIS);
				}
				break;
			case 7:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				match(ID);
				{
				setState(157);
				match(LPAR);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << THIS) | (1L << NEW) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(158);
					exp();
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(159);
						match(COMMA);
						setState(160);
						exp();
						}
						}
						setState(165);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(168);
				match(RPAR);
				}
				}
				break;
			case 8:
				_localctx = new MethodExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(169);
				_la = _input.LA(1);
				if ( !(_la==THIS || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				match(DOT);
				setState(171);
				match(ID);
				{
				setState(172);
				match(LPAR);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << THIS) | (1L << NEW) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(173);
					exp();
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(174);
						match(COMMA);
						setState(175);
						exp();
						}
						}
						setState(180);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(183);
				match(RPAR);
				}
				}
				break;
			case 9:
				_localctx = new NewExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(184);
				match(NEW);
				setState(185);
				match(ID);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(186);
					match(LPAR);
					setState(187);
					exp();
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(188);
						match(COMMA);
						setState(189);
						exp();
						}
						}
						setState(194);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(195);
					match(RPAR);
					}
				}

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00cc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\3\2"+
		"\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\5\4\65"+
		"\n\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\5\4B\n\4\3\4\3\4"+
		"\3\4\3\4\6\4H\n\4\r\4\16\4I\3\4\3\4\5\4N\n\4\3\5\3\5\3\5\3\5\6\5T\n\5"+
		"\r\5\16\5U\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bg\n\b\f\b\16\bj\13\b\5\bl\n\b\3\b\3\b\5\bp\n\b\3\b\3\b\3\t\3\t\5\t"+
		"v\n\t\3\n\3\n\3\13\5\13{\n\13\3\13\3\13\3\13\5\13\u0080\n\13\3\f\3\f\3"+
		"\f\5\f\u0085\n\f\3\r\3\r\3\r\5\r\u008a\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00a4\n\16\f\16\16\16\u00a7\13\16\5\16\u00a9"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00b3\n\16\f\16\16"+
		"\16\u00b6\13\16\5\16\u00b8\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00c1\n\16\f\16\16\16\u00c4\13\16\3\16\3\16\5\16\u00c8\n\16\5\16\u00ca"+
		"\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\7\4\2\31\32!!\3\2"+
		"\b\t\3\2\n\13\3\2\f\r\4\2\35\35!!\2\u00dd\2%\3\2\2\2\4.\3\2\2\2\6\60\3"+
		"\2\2\2\bO\3\2\2\2\nY\3\2\2\2\f\\\3\2\2\2\16`\3\2\2\2\20u\3\2\2\2\22w\3"+
		"\2\2\2\24z\3\2\2\2\26\u0081\3\2\2\2\30\u0086\3\2\2\2\32\u00c9\3\2\2\2"+
		"\34&\5\4\3\2\35\37\5\6\4\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2"+
		"\2\2!\"\3\2\2\2\"#\7\3\2\2#$\5\4\3\2$&\3\2\2\2%\34\3\2\2\2%\36\3\2\2\2"+
		"&\3\3\2\2\2\'(\5\24\13\2()\7\3\2\2)/\3\2\2\2*+\5\b\5\2+,\5\24\13\2,-\7"+
		"\3\2\2-/\3\2\2\2.\'\3\2\2\2.*\3\2\2\2/\5\3\2\2\2\60\61\7\33\2\2\61\64"+
		"\7!\2\2\62\63\7\34\2\2\63\65\7!\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65A\3"+
		"\2\2\2\66\67\7\16\2\2\67<\5\n\6\289\7\5\2\29;\5\n\6\2:8\3\2\2\2;>\3\2"+
		"\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\17\2\2@B\3\2\2\2A\66"+
		"\3\2\2\2AB\3\2\2\2BM\3\2\2\2CG\7\20\2\2DE\5\16\b\2EF\7\3\2\2FH\3\2\2\2"+
		"GD\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\21\2\2LN\3\2\2"+
		"\2MC\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OS\7\25\2\2PQ\5\20\t\2QR\7\3\2\2RT\3"+
		"\2\2\2SP\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\26\2\2X\t"+
		"\3\2\2\2YZ\5\22\n\2Z[\7!\2\2[\13\3\2\2\2\\]\5\n\6\2]^\7\7\2\2^_\5\24\13"+
		"\2_\r\3\2\2\2`a\5\22\n\2ab\7!\2\2bk\7\16\2\2ch\5\n\6\2de\7\5\2\2eg\5\n"+
		"\6\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2kc\3\2"+
		"\2\2kl\3\2\2\2lm\3\2\2\2mo\7\17\2\2np\5\b\5\2on\3\2\2\2op\3\2\2\2pq\3"+
		"\2\2\2qr\5\24\13\2r\17\3\2\2\2sv\5\f\7\2tv\5\16\b\2us\3\2\2\2ut\3\2\2"+
		"\2v\21\3\2\2\2wx\t\2\2\2x\23\3\2\2\2y{\7\t\2\2zy\3\2\2\2z{\3\2\2\2{|\3"+
		"\2\2\2|\177\5\26\f\2}~\t\3\2\2~\u0080\5\24\13\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\25\3\2\2\2\u0081\u0084\5\30\r\2\u0082\u0083\t\4\2\2\u0083"+
		"\u0085\5\26\f\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\27\3\2\2"+
		"\2\u0086\u0089\5\32\16\2\u0087\u0088\7\6\2\2\u0088\u008a\5\32\16\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\31\3\2\2\2\u008b\u00ca\7 \2\2"+
		"\u008c\u00ca\t\5\2\2\u008d\u008e\7\16\2\2\u008e\u008f\5\24\13\2\u008f"+
		"\u0090\7\17\2\2\u0090\u00ca\3\2\2\2\u0091\u0092\7\22\2\2\u0092\u0093\5"+
		"\24\13\2\u0093\u0094\7\23\2\2\u0094\u0095\7\20\2\2\u0095\u0096\5\24\13"+
		"\2\u0096\u0097\7\21\2\2\u0097\u0098\7\24\2\2\u0098\u0099\7\20\2\2\u0099"+
		"\u009a\5\24\13\2\u009a\u009b\7\21\2\2\u009b\u00ca\3\2\2\2\u009c\u00ca"+
		"\7!\2\2\u009d\u00ca\7\35\2\2\u009e\u009f\7!\2\2\u009f\u00a8\7\16\2\2\u00a0"+
		"\u00a5\5\24\13\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\5\24\13\2\u00a3\u00a1"+
		"\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ca\7\17\2\2\u00ab\u00ac\t\6\2\2\u00ac"+
		"\u00ad\7\37\2\2\u00ad\u00ae\7!\2\2\u00ae\u00b7\7\16\2\2\u00af\u00b4\5"+
		"\24\13\2\u00b0\u00b1\7\5\2\2\u00b1\u00b3\5\24\13\2\u00b2\u00b0\3\2\2\2"+
		"\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ca\7\17\2\2\u00ba\u00bb\7\36\2\2\u00bb\u00c7\7"+
		"!\2\2\u00bc\u00bd\7\16\2\2\u00bd\u00c2\5\24\13\2\u00be\u00bf\7\5\2\2\u00bf"+
		"\u00c1\5\24\13\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c6\7\17\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00bc\3\2\2\2\u00c7\u00c8\3"+
		"\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u008b\3\2\2\2\u00c9\u008c\3\2\2\2\u00c9"+
		"\u008d\3\2\2\2\u00c9\u0091\3\2\2\2\u00c9\u009c\3\2\2\2\u00c9\u009d\3\2"+
		"\2\2\u00c9\u009e\3\2\2\2\u00c9\u00ab\3\2\2\2\u00c9\u00ba\3\2\2\2\u00ca"+
		"\33\3\2\2\2\32 %.\64<AIMUhkouz\177\u0084\u0089\u00a5\u00a8\u00b4\u00b7"+
		"\u00c2\u00c7\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}