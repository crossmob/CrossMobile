// Generated from LProj.g4 by ANTLR 4.5.3
package org.crossmobile.build.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LProjParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, MLN_COMMENT = 3, SLN_COMMENT = 4, STRING = 5, WS = 6;
    public static final int
            RULE_lproj = 0, RULE_elements = 1, RULE_pair = 2;
    public static final String[] ruleNames = {
            "lproj", "elements", "pair"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'='", "';'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, "MLN_COMMENT", "SLN_COMMENT", "STRING", "WS"
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
    public String getGrammarFileName() {
        return "LProj.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public LProjParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class LprojContext extends ParserRuleContext {
        public ElementsContext elements() {
            return getRuleContext(ElementsContext.class, 0);
        }

        public LprojContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lproj;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).enterLproj(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).exitLproj(this);
        }
    }

    public final LprojContext lproj() throws RecognitionException {
        LprojContext _localctx = new LprojContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_lproj);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(6);
                elements();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ElementsContext extends ParserRuleContext {
        public List<PairContext> pair() {
            return getRuleContexts(PairContext.class);
        }

        public PairContext pair(int i) {
            return getRuleContext(PairContext.class, i);
        }

        public ElementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elements;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).enterElements(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).exitElements(this);
        }
    }

    public final ElementsContext elements() throws RecognitionException {
        ElementsContext _localctx = new ElementsContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_elements);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(11);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == STRING) {
                    {
                        {
                            setState(8);
                            pair();
                        }
                    }
                    setState(13);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PairContext extends ParserRuleContext {
        public Token key;
        public Token value;

        public List<TerminalNode> STRING() {
            return getTokens(LProjParser.STRING);
        }

        public TerminalNode STRING(int i) {
            return getToken(LProjParser.STRING, i);
        }

        public PairContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pair;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).enterPair(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LProjListener) ((LProjListener) listener).exitPair(this);
        }
    }

    public final PairContext pair() throws RecognitionException {
        PairContext _localctx = new PairContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_pair);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(14);
                ((PairContext) _localctx).key = match(STRING);
                setState(15);
                match(T__0);
                setState(16);
                ((PairContext) _localctx).value = match(STRING);
                setState(17);
                match(T__1);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\26\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\3\2\3\3\7\3\f\n\3\f\3\16\3\17\13\3\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\2\2\5\2\4\6\2\2\23\2\b\3\2\2\2\4\r\3\2\2\2\6\20\3\2\2\2\b\t\5\4" +
                    "\3\2\t\3\3\2\2\2\n\f\5\6\4\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r" +
                    "\16\3\2\2\2\16\5\3\2\2\2\17\r\3\2\2\2\20\21\7\7\2\2\21\22\7\3\2\2\22\23" +
                    "\7\7\2\2\23\24\7\4\2\2\24\7\3\2\2\2\3\r";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}