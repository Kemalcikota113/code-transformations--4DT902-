// Generated from c:/Users/Blin/Desktop/code transformation/A1/Parser.g4 by ANTLR 4.13.1

    package generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		INT=18, ID=19, TYPE=20, WS=21, LINE_COMMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"INT", "ID", "TYPE", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'{'", "'}'", "';'", "'('", "')'", "'*'", "'/'", "'+'", 
			"'-'", "'<'", "'>'", "'='", "'if'", "'else'", "'while'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "INT", "ID", "TYPE", "WS", "LINE_COMMENT"
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


	public SimpleParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Parser.g4"; }

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
		"\u0004\u0000\u0016\u0097\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0004\u0011`\b\u0011\u000b\u0011\f\u0011a\u0003\u0011d\b\u0011"+
		"\u0001\u0012\u0004\u0012g\b\u0012\u000b\u0012\f\u0012h\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0081\b\u0013\u0001\u0013\u0003"+
		"\u0013\u0084\b\u0013\u0001\u0014\u0004\u0014\u0087\b\u0014\u000b\u0014"+
		"\f\u0014\u0088\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u0091\b\u0015\n\u0015\f\u0015\u0094\t\u0015\u0001"+
		"\u0015\u0001\u0015\u0000\u0000\u0016\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0004\u0002\u0000AZaz\u0002"+
		"\u0000  [[\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00a0\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000"+
		"\u0000\u00057\u0001\u0000\u0000\u0000\u00079\u0001\u0000\u0000\u0000\t"+
		";\u0001\u0000\u0000\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001\u0000"+
		"\u0000\u0000\u000fA\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000"+
		"\u0013E\u0001\u0000\u0000\u0000\u0015G\u0001\u0000\u0000\u0000\u0017I"+
		"\u0001\u0000\u0000\u0000\u0019K\u0001\u0000\u0000\u0000\u001bM\u0001\u0000"+
		"\u0000\u0000\u001dP\u0001\u0000\u0000\u0000\u001fU\u0001\u0000\u0000\u0000"+
		"![\u0001\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000%f\u0001\u0000\u0000"+
		"\u0000\'\u0080\u0001\u0000\u0000\u0000)\u0086\u0001\u0000\u0000\u0000"+
		"+\u008c\u0001\u0000\u0000\u0000-.\u0005p\u0000\u0000./\u0005r\u0000\u0000"+
		"/0\u0005o\u0000\u000001\u0005g\u0000\u000012\u0005r\u0000\u000023\u0005"+
		"a\u0000\u000034\u0005m\u0000\u00004\u0002\u0001\u0000\u0000\u000056\u0005"+
		"{\u0000\u00006\u0004\u0001\u0000\u0000\u000078\u0005}\u0000\u00008\u0006"+
		"\u0001\u0000\u0000\u00009:\u0005;\u0000\u0000:\b\u0001\u0000\u0000\u0000"+
		";<\u0005(\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000"+
		">\f\u0001\u0000\u0000\u0000?@\u0005*\u0000\u0000@\u000e\u0001\u0000\u0000"+
		"\u0000AB\u0005/\u0000\u0000B\u0010\u0001\u0000\u0000\u0000CD\u0005+\u0000"+
		"\u0000D\u0012\u0001\u0000\u0000\u0000EF\u0005-\u0000\u0000F\u0014\u0001"+
		"\u0000\u0000\u0000GH\u0005<\u0000\u0000H\u0016\u0001\u0000\u0000\u0000"+
		"IJ\u0005>\u0000\u0000J\u0018\u0001\u0000\u0000\u0000KL\u0005=\u0000\u0000"+
		"L\u001a\u0001\u0000\u0000\u0000MN\u0005i\u0000\u0000NO\u0005f\u0000\u0000"+
		"O\u001c\u0001\u0000\u0000\u0000PQ\u0005e\u0000\u0000QR\u0005l\u0000\u0000"+
		"RS\u0005s\u0000\u0000ST\u0005e\u0000\u0000T\u001e\u0001\u0000\u0000\u0000"+
		"UV\u0005w\u0000\u0000VW\u0005h\u0000\u0000WX\u0005i\u0000\u0000XY\u0005"+
		"l\u0000\u0000YZ\u0005e\u0000\u0000Z \u0001\u0000\u0000\u0000[\\\u0005"+
		",\u0000\u0000\\\"\u0001\u0000\u0000\u0000]d\u00050\u0000\u0000^`\u0002"+
		"09\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000c]\u0001"+
		"\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000d$\u0001\u0000\u0000\u0000"+
		"eg\u0007\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i&\u0001\u0000"+
		"\u0000\u0000jk\u0005i\u0000\u0000kl\u0005n\u0000\u0000l\u0081\u0005t\u0000"+
		"\u0000mn\u0005f\u0000\u0000no\u0005l\u0000\u0000op\u0005o\u0000\u0000"+
		"pq\u0005a\u0000\u0000q\u0081\u0005t\u0000\u0000rs\u0005s\u0000\u0000s"+
		"t\u0005t\u0000\u0000tu\u0005r\u0000\u0000uv\u0005i\u0000\u0000vw\u0005"+
		"n\u0000\u0000w\u0081\u0005g\u0000\u0000xy\u0005c\u0000\u0000yz\u0005h"+
		"\u0000\u0000z{\u0005a\u0000\u0000{\u0081\u0005r\u0000\u0000|}\u0005b\u0000"+
		"\u0000}~\u0005o\u0000\u0000~\u007f\u0005o\u0000\u0000\u007f\u0081\u0005"+
		"l\u0000\u0000\u0080j\u0001\u0000\u0000\u0000\u0080m\u0001\u0000\u0000"+
		"\u0000\u0080r\u0001\u0000\u0000\u0000\u0080x\u0001\u0000\u0000\u0000\u0080"+
		"|\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u0084"+
		"\u0007\u0001\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084(\u0001\u0000\u0000\u0000\u0085\u0087\u0007"+
		"\u0002\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0006"+
		"\u0014\u0000\u0000\u008b*\u0001\u0000\u0000\u0000\u008c\u008d\u0005/\u0000"+
		"\u0000\u008d\u008e\u0005/\u0000\u0000\u008e\u0092\u0001\u0000\u0000\u0000"+
		"\u008f\u0091\b\u0003\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u0015\u0000\u0000\u0096"+
		",\u0001\u0000\u0000\u0000\b\u0000ach\u0080\u0083\u0088\u0092\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}