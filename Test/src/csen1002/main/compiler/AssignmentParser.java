// Generated from C:/Users/maria/OneDrive/Documents/new beginning/ACL/Test/grammar\Assignment.g4 by ANTLR 4.12.0
package csen1002.main.compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AssignmentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, DIGITS=2, WS=3;
	public static final int
		RULE_startOfGrammar = 0, RULE_eachRow = 1, RULE_eachRowDash = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"startOfGrammar", "eachRow", "eachRowDash"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "DIGITS", "WS"
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
	public String getGrammarFileName() { return "Assignment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AssignmentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartOfGrammarContext extends ParserRuleContext {
		public int check;
		public EachRowContext eachRow;
		public EachRowContext eachRow() {
			return getRuleContext(EachRowContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AssignmentParser.EOF, 0); }
		public StartOfGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startOfGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).enterStartOfGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).exitStartOfGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssignmentVisitor ) return ((AssignmentVisitor<? extends T>)visitor).visitStartOfGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartOfGrammarContext startOfGrammar() throws RecognitionException {
		StartOfGrammarContext _localctx = new StartOfGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startOfGrammar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			((StartOfGrammarContext)_localctx).eachRow = eachRow();
			setState(7);
			match(EOF);
			((StartOfGrammarContext)_localctx).check =  (((StartOfGrammarContext)_localctx).eachRow.check == 1 && (((StartOfGrammarContext)_localctx).eachRow.sumOfFirstRow == ((StartOfGrammarContext)_localctx).eachRow.sumOfFirstCol))?1:0;
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

	@SuppressWarnings("CheckReturnValue")
	public static class EachRowContext extends ParserRuleContext {
		public int sumOfFirstRow;
		public int sumOfFirstCol;
		public int length;
		public int check;
		public EachRowDashContext eachRowDash;
		public EachRowContext eachRow1;
		public EachRowDashContext eachRowDash() {
			return getRuleContext(EachRowDashContext.class,0);
		}
		public EachRowContext eachRow() {
			return getRuleContext(EachRowContext.class,0);
		}
		public EachRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eachRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).enterEachRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).exitEachRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssignmentVisitor ) return ((AssignmentVisitor<? extends T>)visitor).visitEachRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EachRowContext eachRow() throws RecognitionException {
		EachRowContext _localctx = new EachRowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eachRow);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				((EachRowContext)_localctx).eachRowDash = eachRowDash();
				setState(11);
				match(T__0);
				setState(12);
				((EachRowContext)_localctx).eachRow1 = eachRow();
				((EachRowContext)_localctx).sumOfFirstRow = ((EachRowContext)_localctx).eachRowDash.sumOfEachRow;
				                     ((EachRowContext)_localctx).sumOfFirstCol =  ((EachRowContext)_localctx).eachRowDash.valOfFirCol + (((EachRowContext)_localctx).eachRow1.sumOfFirstCol);
				                     ((EachRowContext)_localctx).length =  ((EachRowContext)_localctx).eachRowDash.lengthOfEachRow;
				                     ((EachRowContext)_localctx).check =  (((EachRowContext)_localctx).eachRow1.check ==1 && (((EachRowContext)_localctx).eachRowDash.lengthOfEachRow == ((EachRowContext)_localctx).eachRow1.length))?1:0;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				((EachRowContext)_localctx).eachRowDash = eachRowDash();
				((EachRowContext)_localctx).sumOfFirstRow =  ((EachRowContext)_localctx).eachRowDash.sumOfEachRow;
				                                    ((EachRowContext)_localctx).sumOfFirstCol =  ((EachRowContext)_localctx).eachRowDash.valOfFirCol;
				                                    ((EachRowContext)_localctx).length =  ((EachRowContext)_localctx).eachRowDash.lengthOfEachRow;
				                                    ((EachRowContext)_localctx).check =  1;
				                                   
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

	@SuppressWarnings("CheckReturnValue")
	public static class EachRowDashContext extends ParserRuleContext {
		public int lengthOfEachRow;
		public int sumOfEachRow;
		public int valOfFirCol;
		public Token DIGITS;
		public EachRowDashContext eachRowDash1;
		public TerminalNode DIGITS() { return getToken(AssignmentParser.DIGITS, 0); }
		public EachRowDashContext eachRowDash() {
			return getRuleContext(EachRowDashContext.class,0);
		}
		public EachRowDashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eachRowDash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).enterEachRowDash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssignmentListener ) ((AssignmentListener)listener).exitEachRowDash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssignmentVisitor ) return ((AssignmentVisitor<? extends T>)visitor).visitEachRowDash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EachRowDashContext eachRowDash() throws RecognitionException {
		EachRowDashContext _localctx = new EachRowDashContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eachRowDash);
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				((EachRowDashContext)_localctx).DIGITS = match(DIGITS);
				setState(21);
				((EachRowDashContext)_localctx).eachRowDash1 = eachRowDash();
				((EachRowDashContext)_localctx).lengthOfEachRow =  1 + (((EachRowDashContext)_localctx).eachRowDash1.lengthOfEachRow);
				                          ((EachRowDashContext)_localctx).sumOfEachRow =  (((EachRowDashContext)_localctx).eachRowDash1.sumOfEachRow) + (((EachRowDashContext)_localctx).DIGITS!=null?Integer.valueOf(((EachRowDashContext)_localctx).DIGITS.getText()):0);
				                          ((EachRowDashContext)_localctx).valOfFirCol =  (((EachRowDashContext)_localctx).DIGITS!=null?Integer.valueOf(((EachRowDashContext)_localctx).DIGITS.getText()):0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				((EachRowDashContext)_localctx).DIGITS = match(DIGITS);
				((EachRowDashContext)_localctx).lengthOfEachRow =  1;
				                                  ((EachRowDashContext)_localctx).sumOfEachRow =  (((EachRowDashContext)_localctx).DIGITS!=null?Integer.valueOf(((EachRowDashContext)_localctx).DIGITS.getText()):0);
				                                  ((EachRowDashContext)_localctx).valOfFirCol =  (((EachRowDashContext)_localctx).DIGITS!=null?Integer.valueOf(((EachRowDashContext)_localctx).DIGITS.getText()):0);
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
		"\u0004\u0001\u0003\u001d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0013\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u001b\b\u0002"+
		"\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000\u001b\u0000"+
		"\u0006\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000\u0004"+
		"\u001a\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007"+
		"\b\u0005\u0000\u0000\u0001\b\t\u0006\u0000\uffff\uffff\u0000\t\u0001\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0003\u0004\u0002\u0000\u000b\f\u0005\u0001"+
		"\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r\u000e\u0006\u0001\uffff\uffff"+
		"\u0000\u000e\u0013\u0001\u0000\u0000\u0000\u000f\u0010\u0003\u0004\u0002"+
		"\u0000\u0010\u0011\u0006\u0001\uffff\uffff\u0000\u0011\u0013\u0001\u0000"+
		"\u0000\u0000\u0012\n\u0001\u0000\u0000\u0000\u0012\u000f\u0001\u0000\u0000"+
		"\u0000\u0013\u0003\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0002\u0000"+
		"\u0000\u0015\u0016\u0003\u0004\u0002\u0000\u0016\u0017\u0006\u0002\uffff"+
		"\uffff\u0000\u0017\u001b\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0002"+
		"\u0000\u0000\u0019\u001b\u0006\u0002\uffff\uffff\u0000\u001a\u0014\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u0005\u0001"+
		"\u0000\u0000\u0000\u0002\u0012\u001a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}