// Generated from LProj.g4 by ANTLR 4.5.3
package org.crossmobile.build.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LProjLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, MLN_COMMENT = 3, SLN_COMMENT = 4, STRING = 5, WS = 6;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    public static final String[] ruleNames = {
            "T__0", "T__1", "MLN_COMMENT", "SLN_COMMENT", "BlockComment", "LineComment",
            "STRING", "ESC", "UNICODE", "HEX", "SAFECODEPOINT", "WS"
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


    public LProjLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bx\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3" +
                    "\6\3\6\3\6\3\6\7\6,\n\6\f\6\16\6/\13\6\3\6\3\6\3\6\5\6\64\n\6\3\7\3\7" +
                    "\3\7\3\7\7\7:\n\7\f\7\16\7=\13\7\3\7\5\7@\n\7\3\7\3\7\7\7D\n\7\f\7\16" +
                    "\7G\13\7\3\7\3\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\7\7R\n\7\f\7\16\7U\13" +
                    "\7\3\b\3\b\3\b\7\bZ\n\b\f\b\16\b]\13\b\3\b\3\b\3\t\3\t\3\t\5\td\n\t\3" +
                    "\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\5\fp\n\f\3\r\6\rs\n\r\r\r\16" +
                    "\rt\3\r\3\r\3-\2\16\3\3\5\4\7\5\t\6\13\2\r\2\17\7\21\2\23\2\25\2\27\2" +
                    "\31\b\3\2\b\4\2\f\f\17\17\4\2\13\13\"\"\5\2\62;CHch\5\2\2!$$^^\4\2\13" +
                    "\f\17\17\5\2\13\f\17\17\"\"}\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3" +
                    "\2\2\2\2\17\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2" +
                    "\2\t#\3\2\2\2\13\'\3\2\2\2\r\65\3\2\2\2\17V\3\2\2\2\21`\3\2\2\2\23e\3" +
                    "\2\2\2\25k\3\2\2\2\27o\3\2\2\2\31r\3\2\2\2\33\34\7?\2\2\34\4\3\2\2\2\35" +
                    "\36\7=\2\2\36\6\3\2\2\2\37 \5\13\6\2 !\3\2\2\2!\"\b\4\2\2\"\b\3\2\2\2" +
                    "#$\5\r\7\2$%\3\2\2\2%&\b\5\2\2&\n\3\2\2\2\'(\7\61\2\2()\7,\2\2)-\3\2\2" +
                    "\2*,\13\2\2\2+*\3\2\2\2,/\3\2\2\2-.\3\2\2\2-+\3\2\2\2.\63\3\2\2\2/-\3" +
                    "\2\2\2\60\61\7,\2\2\61\64\7\61\2\2\62\64\7\2\2\3\63\60\3\2\2\2\63\62\3" +
                    "\2\2\2\64\f\3\2\2\2\65\66\7\61\2\2\66\67\7\61\2\2\67;\3\2\2\28:\n\2\2" +
                    "\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<S\3\2\2\2=;\3\2\2\2>@\7\17" +
                    "\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AE\7\f\2\2BD\t\3\2\2CB\3\2\2\2DG\3\2" +
                    "\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\61\2\2IJ\7\61\2\2JN\3" +
                    "\2\2\2KM\n\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3" +
                    "\2\2\2Q?\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\16\3\2\2\2US\3\2\2\2V" +
                    "[\7$\2\2WZ\5\21\t\2XZ\5\27\f\2YW\3\2\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2" +
                    "[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7$\2\2_\20\3\2\2\2`c\7^\2\2ad\5\23" +
                    "\n\2bd\13\2\2\2ca\3\2\2\2cb\3\2\2\2d\22\3\2\2\2ef\7w\2\2fg\5\25\13\2g" +
                    "h\5\25\13\2hi\5\25\13\2ij\5\25\13\2j\24\3\2\2\2kl\t\4\2\2l\26\3\2\2\2" +
                    "mp\n\5\2\2np\t\6\2\2om\3\2\2\2on\3\2\2\2p\30\3\2\2\2qs\t\7\2\2rq\3\2\2" +
                    "\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\b\r\3\2w\32\3\2\2\2\17\2" +
                    "-\63;?ENSY[cot\4\2\3\2\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}