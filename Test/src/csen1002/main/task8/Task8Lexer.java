// Generated from C:/Users/maria/OneDrive/Documents/new beginning/ACL/Test/grammar\Task8.g4 by ANTLR 4.12.0
package csen1002.main.task8;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, IF=2, ELSE=3, COMP=4, ID=5, LIT=6, NUM=7, LP=8, RP=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "IF", "ELSE", "COMP", "ID", "LIT", "NUM", "LP", "RP", "DIGIT", 
			"ALPA", "E", "EEXPR", "DECIMAL", "DOUBLEQ", "MATCHESANYTHINGEXCEPT", 
			"ANTTHINGPRECEEDWITH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "IF", "ELSE", "COMP", "ID", "LIT", "NUM", "LP", "RP"
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


	public Task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Task8.g4"; }

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
		"\u0004\u0000\t{\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00039\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004=\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004\f\u0004"+
		"E\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005J\b\u0005\n\u0005"+
		"\f\u0005M\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006R\b\u0006"+
		"\u000b\u0006\f\u0006S\u0001\u0006\u0003\u0006W\b\u0006\u0001\u0006\u0003"+
		"\u0006Z\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\fh\b"+
		"\f\u0001\f\u0004\fk\b\f\u000b\f\f\fl\u0001\r\u0001\r\u0004\rq\b\r\u000b"+
		"\r\f\rr\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\u0000\u0015"+
		"\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000"+
		"\u0001\u0000\u000b\u0003\u0000\t\n\r\r  \u0002\u0000IIii\u0002\u0000F"+
		"Fff\u0002\u0000EEee\u0002\u0000LLll\u0002\u0000SSss\u0002\u0000<<>>\u0001"+
		"\u000009\u0002\u0000AZaz\u0002\u0000++--\u0002\u0000\"\"\\\\\u0082\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003\'\u0001"+
		"\u0000\u0000\u0000\u0005*\u0001\u0000\u0000\u0000\u00078\u0001\u0000\u0000"+
		"\u0000\t<\u0001\u0000\u0000\u0000\u000bF\u0001\u0000\u0000\u0000\rQ\u0001"+
		"\u0000\u0000\u0000\u000f[\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000"+
		"\u0000\u0013_\u0001\u0000\u0000\u0000\u0015a\u0001\u0000\u0000\u0000\u0017"+
		"c\u0001\u0000\u0000\u0000\u0019e\u0001\u0000\u0000\u0000\u001bn\u0001"+
		"\u0000\u0000\u0000\u001dt\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000"+
		"\u0000!x\u0001\u0000\u0000\u0000#$\u0007\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0006\u0000\u0000\u0000&\u0002\u0001\u0000\u0000\u0000"+
		"\'(\u0007\u0001\u0000\u0000()\u0007\u0002\u0000\u0000)\u0004\u0001\u0000"+
		"\u0000\u0000*+\u0007\u0003\u0000\u0000+,\u0007\u0004\u0000\u0000,-\u0007"+
		"\u0005\u0000\u0000-.\u0007\u0003\u0000\u0000.\u0006\u0001\u0000\u0000"+
		"\u0000/9\u0007\u0006\u0000\u000001\u0005>\u0000\u000019\u0005=\u0000\u0000"+
		"23\u0005<\u0000\u000039\u0005=\u0000\u000045\u0005=\u0000\u000059\u0005"+
		"=\u0000\u000067\u0005!\u0000\u000079\u0005=\u0000\u00008/\u0001\u0000"+
		"\u0000\u000080\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u000084\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u00009\b\u0001\u0000\u0000\u0000"+
		":=\u0003\u0015\n\u0000;=\u0005_\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<;\u0001\u0000\u0000\u0000=C\u0001\u0000\u0000\u0000>B\u0003\u0015\n\u0000"+
		"?B\u0003\u0013\t\u0000@B\u0005_\u0000\u0000A>\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000D\n\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000FK\u0003\u001d\u000e\u0000GJ\u0003"+
		"\u001f\u000f\u0000HJ\u0003!\u0010\u0000IG\u0001\u0000\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000NO\u0003\u001d\u000e\u0000O\f\u0001\u0000\u0000\u0000PR\u0003\u0013"+
		"\t\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000UW\u0003"+
		"\u001b\r\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XZ\u0003\u0019\f\u0000YX\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\u000e\u0001\u0000\u0000\u0000[\\\u0005(\u0000\u0000"+
		"\\\u0010\u0001\u0000\u0000\u0000]^\u0005)\u0000\u0000^\u0012\u0001\u0000"+
		"\u0000\u0000_`\u0007\u0007\u0000\u0000`\u0014\u0001\u0000\u0000\u0000"+
		"ab\u0007\b\u0000\u0000b\u0016\u0001\u0000\u0000\u0000cd\u0007\u0003\u0000"+
		"\u0000d\u0018\u0001\u0000\u0000\u0000eg\u0003\u0017\u000b\u0000fh\u0007"+
		"\t\u0000\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001"+
		"\u0000\u0000\u0000ik\u0003\u0013\t\u0000ji\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"m\u001a\u0001\u0000\u0000\u0000np\u0005.\u0000\u0000oq\u0003\u0013\t\u0000"+
		"po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000s\u001c\u0001\u0000\u0000\u0000tu\u0005"+
		"\"\u0000\u0000u\u001e\u0001\u0000\u0000\u0000vw\b\n\u0000\u0000w \u0001"+
		"\u0000\u0000\u0000xy\u0005\\\u0000\u0000yz\t\u0000\u0000\u0000z\"\u0001"+
		"\u0000\u0000\u0000\r\u00008<ACIKSVYglr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}