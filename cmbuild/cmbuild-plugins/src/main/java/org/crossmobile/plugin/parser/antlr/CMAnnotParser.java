// Generated from CMAnnot.g4 by ANTLR 4.7.1
package org.crossmobile.plugin.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMAnnotParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, LINE_COMMENT=37, COMMENT=38, 
		WS=39, UI_APPEARANCE_SELECTOR=40, UIKIT_EXTERN=41, NULLABLE=42, NONNULL=43, 
		EXTERN=44, ONEWAY=45, UNSIGNED=46, KINDOF=47, ID=48, VERSION=49, NUM=50;
	public static final int
		RULE_classdef = 0, RULE_protinheritance = 1, RULE_inheritance = 2, RULE_method = 3, 
		RULE_property = 4, RULE_propertydef = 5, RULE_cparts = 6, RULE_func = 7, 
		RULE_extconst = 8, RULE_selector = 9, RULE_selectorNamedParam = 10, RULE_selectorParam = 11, 
		RULE_returntype = 12, RULE_listofvariables = 13, RULE_var_type_name = 14, 
		RULE_variable = 15, RULE_vartype = 16, RULE_block = 17, RULE_simple_vartype_name = 18, 
		RULE_simple_vartype = 19, RULE_visibility = 20;
	public static final String[] ruleNames = {
		"classdef", "protinheritance", "inheritance", "method", "property", "propertydef", 
		"cparts", "func", "extconst", "selector", "selectorNamedParam", "selectorParam", 
		"returntype", "listofvariables", "var_type_name", "variable", "vartype", 
		"block", "simple_vartype_name", "simple_vartype", "visibility"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@interface'", "'@protocol'", "'('", "')'", "'@end'", "'<'", "','", 
		"'>'", "':'", "'@property'", "';'", "'atomic'", "'nonatomic'", "'readwrite'", 
		"'class'", "'retain'", "'strong'", "'assign'", "'weak'", "'copy'", "'readonly'", 
		"'getter'", "'='", "'const'", "'...'", "'+'", "'-'", "'['", "']'", "'*'", 
		"'id<'", "'^'", "'@private'", "'@public'", "'@protected'", "'@package'", 
		null, null, null, "'UI_APPEARANCE_SELECTOR'", "'UIKIT_EXTERN'", "'_Nullable'", 
		"'_Nonnull'", "'extern'", "'oneway'", "'unsigned'", "'__kindof'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LINE_COMMENT", "COMMENT", "WS", "UI_APPEARANCE_SELECTOR", "UIKIT_EXTERN", 
		"NULLABLE", "NONNULL", "EXTERN", "ONEWAY", "UNSIGNED", "KINDOF", "ID", 
		"VERSION", "NUM"
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
	public String getGrammarFileName() { return "CMAnnot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CMAnnotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ClassdefContext extends ParserRuleContext {
		public Token classtype;
		public Token classname;
		public Token category;
		public List<TerminalNode> ID() { return getTokens(CMAnnotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CMAnnotParser.ID, i);
		}
		public InheritanceContext inheritance() {
			return getRuleContext(InheritanceContext.class,0);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitClassdef(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((ClassdefContext)_localctx).classtype = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
				((ClassdefContext)_localctx).classtype = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(43);
			((ClassdefContext)_localctx).classname = match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(44);
				match(T__2);
				setState(45);
				((ClassdefContext)_localctx).category = match(ID);
				setState(46);
				match(T__3);
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(49);
				inheritance();
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__30) | (1L << ID))) != 0)) {
				{
				{
				setState(52);
				method();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__4);
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

	public static class ProtinheritanceContext extends ParserRuleContext {
		public Token inh;
		public List<TerminalNode> ID() { return getTokens(CMAnnotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CMAnnotParser.ID, i);
		}
		public ProtinheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protinheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterProtinheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitProtinheritance(this);
		}
	}

	public final ProtinheritanceContext protinheritance() throws RecognitionException {
		ProtinheritanceContext _localctx = new ProtinheritanceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_protinheritance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__5);
			setState(61);
			((ProtinheritanceContext)_localctx).inh = match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(62);
				match(T__6);
				setState(63);
				((ProtinheritanceContext)_localctx).inh = match(ID);
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(T__7);
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

	public static class InheritanceContext extends ParserRuleContext {
		public Token classname;
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public ProtinheritanceContext protinheritance() {
			return getRuleContext(ProtinheritanceContext.class,0);
		}
		public InheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitInheritance(this);
		}
	}

	public final InheritanceContext inheritance() throws RecognitionException {
		InheritanceContext _localctx = new InheritanceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inheritance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__8);
			setState(72);
			((InheritanceContext)_localctx).classname = match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(73);
				protinheritance();
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

	public static class MethodContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__23:
			case T__30:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				property();
				}
				break;
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				selector();
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

	public static class PropertyContext extends ParserRuleContext {
		public Token objc;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<PropertydefContext> propertydef() {
			return getRuleContexts(PropertydefContext.class);
		}
		public PropertydefContext propertydef(int i) {
			return getRuleContext(PropertydefContext.class,i);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_property);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((PropertyContext)_localctx).objc = match(T__9);
				setState(81);
				variable();
				setState(82);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((PropertyContext)_localctx).objc = match(T__9);
				setState(85);
				match(T__2);
				setState(86);
				propertydef();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(87);
					match(T__6);
					setState(88);
					propertydef();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(T__3);
				setState(95);
				variable();
				setState(96);
				match(T__10);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				variable();
				setState(99);
				match(T__10);
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

	public static class PropertydefContext extends ParserRuleContext {
		public Token clazz;
		public Token strong;
		public Token weak;
		public Token copy;
		public Token readonly;
		public Token getter;
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public PropertydefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertydef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterPropertydef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitPropertydef(this);
		}
	}

	public final PropertydefContext propertydef() throws RecognitionException {
		PropertydefContext _localctx = new PropertydefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_propertydef);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				((PropertydefContext)_localctx).clazz = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				((PropertydefContext)_localctx).strong = match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				((PropertydefContext)_localctx).strong = match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				((PropertydefContext)_localctx).weak = match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				((PropertydefContext)_localctx).weak = match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				((PropertydefContext)_localctx).copy = match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				((PropertydefContext)_localctx).readonly = match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 11);
				{
				setState(113);
				match(T__21);
				setState(114);
				match(T__22);
				setState(115);
				((PropertydefContext)_localctx).getter = match(ID);
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

	public static class CpartsContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ExtconstContext extconst() {
			return getRuleContext(ExtconstContext.class,0);
		}
		public CpartsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cparts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterCparts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitCparts(this);
		}
	}

	public final CpartsContext cparts() throws RecognitionException {
		CpartsContext _localctx = new CpartsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cparts);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				func();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				extconst();
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

	public static class FuncContext extends ParserRuleContext {
		public Token constant;
		public Token name;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public ListofvariablesContext listofvariables() {
			return getRuleContext(ListofvariablesContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(122);
				((FuncContext)_localctx).constant = match(T__23);
				}
				break;
			}
			setState(125);
			vartype();
			setState(126);
			((FuncContext)_localctx).name = match(ID);
			setState(127);
			match(T__2);
			setState(128);
			listofvariables();
			setState(129);
			match(T__3);
			setState(130);
			match(T__10);
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

	public static class ExtconstContext extends ParserRuleContext {
		public Token constant;
		public Token name;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public ExtconstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extconst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterExtconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitExtconst(this);
		}
	}

	public final ExtconstContext extconst() throws RecognitionException {
		ExtconstContext _localctx = new ExtconstContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_extconst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(132);
				((ExtconstContext)_localctx).constant = match(T__23);
				}
				break;
			}
			setState(135);
			vartype();
			setState(136);
			((ExtconstContext)_localctx).name = match(ID);
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

	public static class SelectorContext extends ParserRuleContext {
		public Token name;
		public Token retain;
		public Token varargs;
		public ReturntypeContext returntype() {
			return getRuleContext(ReturntypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public SelectorParamContext selectorParam() {
			return getRuleContext(SelectorParamContext.class,0);
		}
		public List<SelectorNamedParamContext> selectorNamedParam() {
			return getRuleContexts(SelectorNamedParamContext.class);
		}
		public SelectorNamedParamContext selectorNamedParam(int i) {
			return getRuleContext(SelectorNamedParamContext.class,i);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			returntype();
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(139);
				((SelectorContext)_localctx).name = match(ID);
				}
				break;
			case T__15:
				{
				setState(140);
				((SelectorContext)_localctx).retain = match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(143);
				selectorParam();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8 || _la==ID) {
					{
					{
					setState(144);
					selectorNamedParam();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(152);
				match(T__6);
				setState(153);
				((SelectorContext)_localctx).varargs = match(T__24);
				}
			}

			setState(156);
			match(T__10);
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

	public static class SelectorNamedParamContext extends ParserRuleContext {
		public Token paramname;
		public SelectorParamContext selectorparam;
		public SelectorParamContext selectorParam() {
			return getRuleContext(SelectorParamContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public SelectorNamedParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorNamedParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterSelectorNamedParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitSelectorNamedParam(this);
		}
	}

	public final SelectorNamedParamContext selectorNamedParam() throws RecognitionException {
		SelectorNamedParamContext _localctx = new SelectorNamedParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selectorNamedParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(158);
				((SelectorNamedParamContext)_localctx).paramname = match(ID);
				}
			}

			setState(161);
			((SelectorNamedParamContext)_localctx).selectorparam = selectorParam();
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

	public static class SelectorParamContext extends ParserRuleContext {
		public Token variablename;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public SelectorParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterSelectorParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitSelectorParam(this);
		}
	}

	public final SelectorParamContext selectorParam() throws RecognitionException {
		SelectorParamContext _localctx = new SelectorParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_selectorParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__8);
			setState(164);
			match(T__2);
			setState(165);
			vartype();
			setState(166);
			match(T__3);
			setState(167);
			((SelectorParamContext)_localctx).variablename = match(ID);
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

	public static class ReturntypeContext extends ParserRuleContext {
		public Token isstatic;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public ReturntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returntype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterReturntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitReturntype(this);
		}
	}

	public final ReturntypeContext returntype() throws RecognitionException {
		ReturntypeContext _localctx = new ReturntypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returntype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((ReturntypeContext)_localctx).isstatic = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
				((ReturntypeContext)_localctx).isstatic = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(170);
			match(T__2);
			setState(171);
			vartype();
			setState(172);
			match(T__3);
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

	public static class ListofvariablesContext extends ParserRuleContext {
		public Token voidTK;
		public List<Var_type_nameContext> var_type_name() {
			return getRuleContexts(Var_type_nameContext.class);
		}
		public Var_type_nameContext var_type_name(int i) {
			return getRuleContext(Var_type_nameContext.class,i);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public ListofvariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listofvariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterListofvariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitListofvariables(this);
		}
	}

	public final ListofvariablesContext listofvariables() throws RecognitionException {
		ListofvariablesContext _localctx = new ListofvariablesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listofvariables);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				var_type_name();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(175);
					match(T__6);
					setState(176);
					var_type_name();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				((ListofvariablesContext)_localctx).voidTK = match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
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

	public static class Var_type_nameContext extends ParserRuleContext {
		public Token varname;
		public Token s3;
		public Token varargs;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public Var_type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterVar_type_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitVar_type_name(this);
		}
	}

	public final Var_type_nameContext var_type_name() throws RecognitionException {
		Var_type_nameContext _localctx = new Var_type_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			vartype();
			setState(187);
			((Var_type_nameContext)_localctx).varname = match(ID);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(188);
				((Var_type_nameContext)_localctx).s3 = match(T__27);
				setState(189);
				match(T__28);
				}
			}

			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(192);
				match(T__6);
				setState(193);
				((Var_type_nameContext)_localctx).varargs = match(T__24);
				}
				break;
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

	public static class VariableContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			vartype();
			setState(197);
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

	public static class VartypeContext extends ParserRuleContext {
		public Token constant;
		public Token type;
		public Token s1;
		public Token s2;
		public Token protocol;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<VartypeContext> vartype() {
			return getRuleContexts(VartypeContext.class);
		}
		public VartypeContext vartype(int i) {
			return getRuleContext(VartypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CMAnnotParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CMAnnotParser.ID, i);
		}
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterVartype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitVartype(this);
		}
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_vartype);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(200);
					((VartypeContext)_localctx).constant = match(T__23);
					}
				}

				setState(203);
				((VartypeContext)_localctx).type = match(ID);
				setState(204);
				match(T__5);
				setState(205);
				vartype();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(206);
					match(T__6);
					setState(207);
					vartype();
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(213);
				match(T__7);
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(214);
					((VartypeContext)_localctx).s1 = match(T__29);
					}
					break;
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(217);
					((VartypeContext)_localctx).s2 = match(T__29);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(220);
					((VartypeContext)_localctx).constant = match(T__23);
					}
				}

				setState(223);
				((VartypeContext)_localctx).type = match(ID);
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(224);
					match(ID);
					}
					break;
				}
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(227);
					((VartypeContext)_localctx).s1 = match(T__29);
					}
					break;
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(230);
					((VartypeContext)_localctx).s2 = match(T__29);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(T__30);
				setState(234);
				((VartypeContext)_localctx).protocol = match(ID);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(235);
					match(T__6);
					setState(236);
					((VartypeContext)_localctx).protocol = match(ID);
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(242);
				match(T__7);
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

	public static class BlockContext extends ParserRuleContext {
		public Token constant;
		public List<Simple_vartype_nameContext> simple_vartype_name() {
			return getRuleContexts(Simple_vartype_nameContext.class);
		}
		public Simple_vartype_nameContext simple_vartype_name(int i) {
			return getRuleContext(Simple_vartype_nameContext.class,i);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(245);
				((BlockContext)_localctx).constant = match(T__23);
				}
				break;
			}
			setState(248);
			simple_vartype_name();
			setState(249);
			match(T__2);
			setState(250);
			match(T__31);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(251);
				match(ID);
				}
			}

			setState(254);
			match(T__3);
			setState(255);
			match(T__2);
			setState(256);
			simple_vartype_name();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(257);
				match(T__6);
				setState(258);
				simple_vartype_name();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(T__3);
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

	public static class Simple_vartype_nameContext extends ParserRuleContext {
		public Token name;
		public Simple_vartypeContext simple_vartype() {
			return getRuleContext(Simple_vartypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public Simple_vartype_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_vartype_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterSimple_vartype_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitSimple_vartype_name(this);
		}
	}

	public final Simple_vartype_nameContext simple_vartype_name() throws RecognitionException {
		Simple_vartype_nameContext _localctx = new Simple_vartype_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_simple_vartype_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			simple_vartype();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(267);
				((Simple_vartype_nameContext)_localctx).name = match(ID);
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

	public static class Simple_vartypeContext extends ParserRuleContext {
		public Token constant;
		public Token type;
		public Token s1;
		public Token s2;
		public List<Simple_vartypeContext> simple_vartype() {
			return getRuleContexts(Simple_vartypeContext.class);
		}
		public Simple_vartypeContext simple_vartype(int i) {
			return getRuleContext(Simple_vartypeContext.class,i);
		}
		public TerminalNode ID() { return getToken(CMAnnotParser.ID, 0); }
		public Simple_vartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_vartype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterSimple_vartype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitSimple_vartype(this);
		}
	}

	public final Simple_vartypeContext simple_vartype() throws RecognitionException {
		Simple_vartypeContext _localctx = new Simple_vartypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simple_vartype);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(270);
					((Simple_vartypeContext)_localctx).constant = match(T__23);
					}
				}

				setState(273);
				((Simple_vartypeContext)_localctx).type = match(ID);
				setState(274);
				match(T__5);
				setState(275);
				simple_vartype();
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(276);
					match(T__6);
					setState(277);
					simple_vartype();
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				match(T__7);
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(284);
					((Simple_vartypeContext)_localctx).s1 = match(T__29);
					}
					break;
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(287);
					((Simple_vartypeContext)_localctx).s2 = match(T__29);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(290);
					((Simple_vartypeContext)_localctx).constant = match(T__23);
					}
				}

				setState(293);
				match(T__30);
				setState(294);
				((Simple_vartypeContext)_localctx).type = match(ID);
				setState(295);
				match(T__7);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(296);
					((Simple_vartypeContext)_localctx).s1 = match(T__29);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				((Simple_vartypeContext)_localctx).type = match(ID);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(300);
					((Simple_vartypeContext)_localctx).s1 = match(T__29);
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

	public static class VisibilityContext extends ParserRuleContext {
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).enterVisibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMAnnotListener ) ((CMAnnotListener)listener).exitVisibility(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u0136\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\5\2\62\n"+
		"\2\3\2\5\2\65\n\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\7\3C\n\3\f\3\16\3F\13\3\3\3\3\3\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\5\5Q\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6h\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7w\n\7\3\b\3\b\5\b{\n\b\3\t\5\t~\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\5\n\u0088\n\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0090\n\13"+
		"\3\13\3\13\7\13\u0094\n\13\f\13\16\13\u0097\13\13\5\13\u0099\n\13\3\13"+
		"\3\13\5\13\u009d\n\13\3\13\3\13\3\f\5\f\u00a2\n\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00b4\n\17\f"+
		"\17\16\17\u00b7\13\17\3\17\3\17\5\17\u00bb\n\17\3\20\3\20\3\20\3\20\5"+
		"\20\u00c1\n\20\3\20\3\20\5\20\u00c5\n\20\3\21\3\21\3\21\3\22\3\22\5\22"+
		"\u00cc\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u00d3\n\22\f\22\16\22\u00d6"+
		"\13\22\3\22\3\22\5\22\u00da\n\22\3\22\5\22\u00dd\n\22\3\22\5\22\u00e0"+
		"\n\22\3\22\3\22\5\22\u00e4\n\22\3\22\5\22\u00e7\n\22\3\22\5\22\u00ea\n"+
		"\22\3\22\3\22\3\22\3\22\7\22\u00f0\n\22\f\22\16\22\u00f3\13\22\3\22\5"+
		"\22\u00f6\n\22\3\23\5\23\u00f9\n\23\3\23\3\23\3\23\3\23\5\23\u00ff\n\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u0106\n\23\f\23\16\23\u0109\13\23\3\23"+
		"\3\23\3\24\3\24\5\24\u010f\n\24\3\25\5\25\u0112\n\25\3\25\3\25\3\25\3"+
		"\25\3\25\7\25\u0119\n\25\f\25\16\25\u011c\13\25\3\25\3\25\5\25\u0120\n"+
		"\25\3\25\5\25\u0123\n\25\3\25\5\25\u0126\n\25\3\25\3\25\3\25\3\25\5\25"+
		"\u012c\n\25\3\25\3\25\5\25\u0130\n\25\5\25\u0132\n\25\3\26\3\26\3\26\2"+
		"\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\5\3\2\3\4\3\2\34"+
		"\35\3\2#&\2\u0159\2,\3\2\2\2\4>\3\2\2\2\6I\3\2\2\2\bP\3\2\2\2\ng\3\2\2"+
		"\2\fv\3\2\2\2\16z\3\2\2\2\20}\3\2\2\2\22\u0087\3\2\2\2\24\u008c\3\2\2"+
		"\2\26\u00a1\3\2\2\2\30\u00a5\3\2\2\2\32\u00ab\3\2\2\2\34\u00ba\3\2\2\2"+
		"\36\u00bc\3\2\2\2 \u00c6\3\2\2\2\"\u00f5\3\2\2\2$\u00f8\3\2\2\2&\u010c"+
		"\3\2\2\2(\u0131\3\2\2\2*\u0133\3\2\2\2,-\t\2\2\2-\61\7\62\2\2./\7\5\2"+
		"\2/\60\7\62\2\2\60\62\7\6\2\2\61.\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2"+
		"\63\65\5\6\4\2\64\63\3\2\2\2\64\65\3\2\2\2\659\3\2\2\2\668\5\b\5\2\67"+
		"\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\7"+
		"\2\2=\3\3\2\2\2>?\7\b\2\2?D\7\62\2\2@A\7\t\2\2AC\7\62\2\2B@\3\2\2\2CF"+
		"\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\n\2\2H\5\3\2\2\2"+
		"IJ\7\13\2\2JL\7\62\2\2KM\5\4\3\2LK\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NQ\5\n"+
		"\6\2OQ\5\24\13\2PN\3\2\2\2PO\3\2\2\2Q\t\3\2\2\2RS\7\f\2\2ST\5 \21\2TU"+
		"\7\r\2\2Uh\3\2\2\2VW\7\f\2\2WX\7\5\2\2X]\5\f\7\2YZ\7\t\2\2Z\\\5\f\7\2"+
		"[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\6\2"+
		"\2ab\5 \21\2bc\7\r\2\2ch\3\2\2\2de\5 \21\2ef\7\r\2\2fh\3\2\2\2gR\3\2\2"+
		"\2gV\3\2\2\2gd\3\2\2\2h\13\3\2\2\2iw\7\16\2\2jw\7\17\2\2kw\7\20\2\2lw"+
		"\7\21\2\2mw\7\22\2\2nw\7\23\2\2ow\7\24\2\2pw\7\25\2\2qw\7\26\2\2rw\7\27"+
		"\2\2st\7\30\2\2tu\7\31\2\2uw\7\62\2\2vi\3\2\2\2vj\3\2\2\2vk\3\2\2\2vl"+
		"\3\2\2\2vm\3\2\2\2vn\3\2\2\2vo\3\2\2\2vp\3\2\2\2vq\3\2\2\2vr\3\2\2\2v"+
		"s\3\2\2\2w\r\3\2\2\2x{\5\20\t\2y{\5\22\n\2zx\3\2\2\2zy\3\2\2\2{\17\3\2"+
		"\2\2|~\7\32\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\5\"\22\2\u0080"+
		"\u0081\7\62\2\2\u0081\u0082\7\5\2\2\u0082\u0083\5\34\17\2\u0083\u0084"+
		"\7\6\2\2\u0084\u0085\7\r\2\2\u0085\21\3\2\2\2\u0086\u0088\7\32\2\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5\""+
		"\22\2\u008a\u008b\7\62\2\2\u008b\23\3\2\2\2\u008c\u008f\5\32\16\2\u008d"+
		"\u0090\7\62\2\2\u008e\u0090\7\22\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3"+
		"\2\2\2\u0090\u0098\3\2\2\2\u0091\u0095\5\30\r\2\u0092\u0094\5\26\f\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0091\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u009d\7\33"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\7\r\2\2\u009f\25\3\2\2\2\u00a0\u00a2\7\62\2\2\u00a1\u00a0\3\2\2"+
		"\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\5\30\r\2\u00a4"+
		"\27\3\2\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7\7\5\2\2\u00a7\u00a8\5\"\22"+
		"\2\u00a8\u00a9\7\6\2\2\u00a9\u00aa\7\62\2\2\u00aa\31\3\2\2\2\u00ab\u00ac"+
		"\t\3\2\2\u00ac\u00ad\7\5\2\2\u00ad\u00ae\5\"\22\2\u00ae\u00af\7\6\2\2"+
		"\u00af\33\3\2\2\2\u00b0\u00b5\5\36\20\2\u00b1\u00b2\7\t\2\2\u00b2\u00b4"+
		"\5\36\20\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00bb\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb"+
		"\7\62\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b8\3\2\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00bd\5\"\22\2\u00bd\u00c0"+
		"\7\62\2\2\u00be\u00bf\7\36\2\2\u00bf\u00c1\7\37\2\2\u00c0\u00be\3\2\2"+
		"\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c3\7\t\2\2\u00c3\u00c5"+
		"\7\33\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\37\3\2\2\2\u00c6"+
		"\u00c7\5\"\22\2\u00c7\u00c8\7\62\2\2\u00c8!\3\2\2\2\u00c9\u00f6\5$\23"+
		"\2\u00ca\u00cc\7\32\2\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\7\62\2\2\u00ce\u00cf\7\b\2\2\u00cf\u00d4\5"+
		"\"\22\2\u00d0\u00d1\7\t\2\2\u00d1\u00d3\5\"\22\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\7\n\2\2\u00d8\u00da\7 \2\2\u00d9"+
		"\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00dd\7 "+
		"\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00f6\3\2\2\2\u00de"+
		"\u00e0\7\32\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\u00e3\7\62\2\2\u00e2\u00e4\7\62\2\2\u00e3\u00e2\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e7\7 \2\2\u00e6\u00e5\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00ea\7 \2\2\u00e9"+
		"\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00f6\3\2\2\2\u00eb\u00ec\7!"+
		"\2\2\u00ec\u00f1\7\62\2\2\u00ed\u00ee\7\t\2\2\u00ee\u00f0\7\62\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f6\7\n\2\2\u00f5"+
		"\u00c9\3\2\2\2\u00f5\u00cb\3\2\2\2\u00f5\u00df\3\2\2\2\u00f5\u00eb\3\2"+
		"\2\2\u00f6#\3\2\2\2\u00f7\u00f9\7\32\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\5&\24\2\u00fb\u00fc\7\5\2\2\u00fc"+
		"\u00fe\7\"\2\2\u00fd\u00ff\7\62\2\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7\6\2\2\u0101\u0102\7\5\2\2\u0102"+
		"\u0107\5&\24\2\u0103\u0104\7\t\2\2\u0104\u0106\5&\24\2\u0105\u0103\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\7\6\2\2\u010b%\3\2\2\2"+
		"\u010c\u010e\5(\25\2\u010d\u010f\7\62\2\2\u010e\u010d\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\'\3\2\2\2\u0110\u0112\7\32\2\2\u0111\u0110\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7\62\2\2\u0114\u0115\7"+
		"\b\2\2\u0115\u011a\5(\25\2\u0116\u0117\7\t\2\2\u0117\u0119\5(\25\2\u0118"+
		"\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f\7\n\2\2\u011e"+
		"\u0120\7 \2\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2"+
		"\2\2\u0121\u0123\7 \2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0132\3\2\2\2\u0124\u0126\7\32\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\7!\2\2\u0128\u0129\7\62\2\2\u0129"+
		"\u012b\7\n\2\2\u012a\u012c\7 \2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u0132\3\2\2\2\u012d\u012f\7\62\2\2\u012e\u0130\7 \2\2\u012f"+
		"\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u0111\3\2"+
		"\2\2\u0131\u0125\3\2\2\2\u0131\u012d\3\2\2\2\u0132)\3\2\2\2\u0133\u0134"+
		"\t\4\2\2\u0134+\3\2\2\2-\61\649DLP]gvz}\u0087\u008f\u0095\u0098\u009c"+
		"\u00a1\u00b5\u00ba\u00c0\u00c4\u00cb\u00d4\u00d9\u00dc\u00df\u00e3\u00e6"+
		"\u00e9\u00f1\u00f5\u00f8\u00fe\u0107\u010e\u0111\u011a\u011f\u0122\u0125"+
		"\u012b\u012f\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}