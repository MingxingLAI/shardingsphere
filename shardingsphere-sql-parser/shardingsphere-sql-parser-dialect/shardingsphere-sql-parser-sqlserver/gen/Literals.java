// Generated from /Users/williamlai/repo/shardingsphere/shardingsphere-sql-parser/shardingsphere-sql-parser-dialect/shardingsphere-sql-parser-sqlserver/src/main/antlr4/imports/sqlserver/Literals.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Literals extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER_=1, STRING_=2, NUMBER_=3, INT_NUM_=4, FLOAT_NUM_=5, DECIMAL_NUM_=6, 
		HEX_DIGIT_=7, BIT_NUM_=8, FOR_GENERATOR=9, AND_=10, OR_=11, NOT_=12, TILDE_=13, 
		VERTICAL_BAR_=14, AMPERSAND_=15, SIGNED_LEFT_SHIFT_=16, SIGNED_RIGHT_SHIFT_=17, 
		CARET_=18, MOD_=19, COLON_=20, PLUS_=21, MINUS_=22, ASTERISK_=23, SLASH_=24, 
		BACKSLASH_=25, DOT_=26, DOT_ASTERISK_=27, SAFE_EQ_=28, DEQ_=29, EQ_=30, 
		NEQ_=31, GT_=32, GTE_=33, LT_=34, LTE_=35, POUND_=36, LP_=37, RP_=38, 
		LBE_=39, RBE_=40, LBT_=41, RBT_=42, COMMA_=43, DQ_=44, SQ_=45, BQ_=46, 
		QUESTION_=47, AT_=48, SEMI_=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER_", "STRING_", "NUMBER_", "INT_NUM_", "FLOAT_NUM_", "DECIMAL_NUM_", 
			"HEX_DIGIT_", "BIT_NUM_", "DIGIT", "HEX_", "FOR_GENERATOR", "A", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "UL_", "AND_", "OR_", 
			"NOT_", "TILDE_", "VERTICAL_BAR_", "AMPERSAND_", "SIGNED_LEFT_SHIFT_", 
			"SIGNED_RIGHT_SHIFT_", "CARET_", "MOD_", "COLON_", "PLUS_", "MINUS_", 
			"ASTERISK_", "SLASH_", "BACKSLASH_", "DOT_", "DOT_ASTERISK_", "SAFE_EQ_", 
			"DEQ_", "EQ_", "NEQ_", "GT_", "GTE_", "LT_", "LTE_", "POUND_", "LP_", 
			"RP_", "LBE_", "RBE_", "LBT_", "RBT_", "COMMA_", "DQ_", "SQ_", "BQ_", 
			"QUESTION_", "AT_", "SEMI_"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'DO NOT MATCH ANY THING, JUST FOR GENERATOR'", 
			"'&&'", "'||'", "'!'", "'~'", "'|'", "'&'", "'<<'", "'>>'", "'^'", "'%'", 
			"':'", "'+'", "'-'", "'*'", "'/'", "'\\'", "'.'", "'.*'", "'<=>'", "'=='", 
			"'='", null, "'>'", "'>='", "'<'", "'<='", "'#'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "','", "'\"'", "'''", "'`'", "'?'", "'@'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENTIFIER_", "STRING_", "NUMBER_", "INT_NUM_", "FLOAT_NUM_", 
			"DECIMAL_NUM_", "HEX_DIGIT_", "BIT_NUM_", "FOR_GENERATOR", "AND_", "OR_", 
			"NOT_", "TILDE_", "VERTICAL_BAR_", "AMPERSAND_", "SIGNED_LEFT_SHIFT_", 
			"SIGNED_RIGHT_SHIFT_", "CARET_", "MOD_", "COLON_", "PLUS_", "MINUS_", 
			"ASTERISK_", "SLASH_", "BACKSLASH_", "DOT_", "DOT_ASTERISK_", "SAFE_EQ_", 
			"DEQ_", "EQ_", "NEQ_", "GT_", "GTE_", "LT_", "LTE_", "POUND_", "LP_", 
			"RP_", "LBE_", "RBE_", "LBT_", "RBT_", "COMMA_", "DQ_", "SQ_", "BQ_", 
			"QUESTION_", "AT_", "SEMI_"
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


	public Literals(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Literals.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01d5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\5\2\u00a1\n\2\3\2\5\2\u00a4"+
		"\n\2\3\2\3\2\7\2\u00a8\n\2\f\2\16\2\u00ab\13\2\3\2\5\2\u00ae\n\2\3\2\5"+
		"\2\u00b1\n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00b9\n\3\f\3\16\3\u00bc\13\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00c6\n\3\f\3\16\3\u00c9\13\3\3\3"+
		"\3\3\5\3\u00cd\n\3\3\4\3\4\3\4\5\4\u00d2\n\4\3\5\6\5\u00d5\n\5\r\5\16"+
		"\5\u00d6\3\6\5\6\u00da\n\6\3\6\5\6\u00dd\n\6\3\6\3\6\3\6\3\6\5\6\u00e3"+
		"\n\6\3\6\3\6\3\7\5\7\u00e8\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\6\b\u00f1\n"+
		"\b\r\b\16\b\u00f2\3\b\3\b\3\b\6\b\u00f8\n\b\r\b\16\b\u00f9\3\b\3\b\5\b"+
		"\u00fe\n\b\3\t\3\t\3\t\3\t\6\t\u0104\n\t\r\t\16\t\u0105\3\t\3\t\3\t\6"+
		"\t\u010b\n\t\r\t\16\t\u010c\3\t\3\t\5\t\u0111\n\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3("+
		"\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\39\3:\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3=\5=\u01ae\n=\3>\3>\3?\3?"+
		"\3?\3@\3@\3A\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J"+
		"\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\2\2P\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\2\25\2\27\13\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\fQ\rS\16U\17W\20Y\21[\22"+
		"]\23_\24a\25c\26e\27g\30i\31k\32m\33o\34q\35s\36u\37w y!{\"}#\177$\u0081"+
		"%\u0083&\u0085\'\u0087(\u0089)\u008b*\u008d+\u008f,\u0091-\u0093.\u0095"+
		"/\u0097\60\u0099\61\u009b\62\u009d\63\3\2\"\6\2%&C\\aac|\7\2%&\62;C\\"+
		"aac|\4\2$$^^\4\2))^^\3\2\62;\5\2\62;CHch\4\2CCcc\4\2DDdd\4\2EEee\4\2F"+
		"Fff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4"+
		"\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWw"+
		"w\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01d2\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\27\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2"+
		"\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\3\u00a0\3\2\2\2\5\u00cc"+
		"\3\2\2\2\7\u00d1\3\2\2\2\t\u00d4\3\2\2\2\13\u00d9\3\2\2\2\r\u00e7\3\2"+
		"\2\2\17\u00fd\3\2\2\2\21\u0110\3\2\2\2\23\u0112\3\2\2\2\25\u0114\3\2\2"+
		"\2\27\u0116\3\2\2\2\31\u0141\3\2\2\2\33\u0143\3\2\2\2\35\u0145\3\2\2\2"+
		"\37\u0147\3\2\2\2!\u0149\3\2\2\2#\u014b\3\2\2\2%\u014d\3\2\2\2\'\u014f"+
		"\3\2\2\2)\u0151\3\2\2\2+\u0153\3\2\2\2-\u0155\3\2\2\2/\u0157\3\2\2\2\61"+
		"\u0159\3\2\2\2\63\u015b\3\2\2\2\65\u015d\3\2\2\2\67\u015f\3\2\2\29\u0161"+
		"\3\2\2\2;\u0163\3\2\2\2=\u0165\3\2\2\2?\u0167\3\2\2\2A\u0169\3\2\2\2C"+
		"\u016b\3\2\2\2E\u016d\3\2\2\2G\u016f\3\2\2\2I\u0171\3\2\2\2K\u0173\3\2"+
		"\2\2M\u0175\3\2\2\2O\u0177\3\2\2\2Q\u017a\3\2\2\2S\u017d\3\2\2\2U\u017f"+
		"\3\2\2\2W\u0181\3\2\2\2Y\u0183\3\2\2\2[\u0185\3\2\2\2]\u0188\3\2\2\2_"+
		"\u018b\3\2\2\2a\u018d\3\2\2\2c\u018f\3\2\2\2e\u0191\3\2\2\2g\u0193\3\2"+
		"\2\2i\u0195\3\2\2\2k\u0197\3\2\2\2m\u0199\3\2\2\2o\u019b\3\2\2\2q\u019d"+
		"\3\2\2\2s\u01a0\3\2\2\2u\u01a4\3\2\2\2w\u01a7\3\2\2\2y\u01ad\3\2\2\2{"+
		"\u01af\3\2\2\2}\u01b1\3\2\2\2\177\u01b4\3\2\2\2\u0081\u01b6\3\2\2\2\u0083"+
		"\u01b9\3\2\2\2\u0085\u01bb\3\2\2\2\u0087\u01bd\3\2\2\2\u0089\u01bf\3\2"+
		"\2\2\u008b\u01c1\3\2\2\2\u008d\u01c3\3\2\2\2\u008f\u01c5\3\2\2\2\u0091"+
		"\u01c7\3\2\2\2\u0093\u01c9\3\2\2\2\u0095\u01cb\3\2\2\2\u0097\u01cd\3\2"+
		"\2\2\u0099\u01cf\3\2\2\2\u009b\u01d1\3\2\2\2\u009d\u01d3\3\2\2\2\u009f"+
		"\u00a1\5\u008dG\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3"+
		"\3\2\2\2\u00a2\u00a4\5\u0093J\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5\u00a9\t\2\2\2\u00a6\u00a8\t\3\2\2\u00a7\u00a6"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\5\u0093J\2\u00ad\u00ac"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00b1\5\u008fH"+
		"\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\4\3\2\2\2\u00b2\u00ba"+
		"\5\u0093J\2\u00b3\u00b4\7^\2\2\u00b4\u00b9\13\2\2\2\u00b5\u00b6\7$\2\2"+
		"\u00b6\u00b9\7$\2\2\u00b7\u00b9\n\4\2\2\u00b8\u00b3\3\2\2\2\u00b8\u00b5"+
		"\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\5\u0093"+
		"J\2\u00be\u00cd\3\2\2\2\u00bf\u00c7\5\u0095K\2\u00c0\u00c1\7^\2\2\u00c1"+
		"\u00c6\13\2\2\2\u00c2\u00c3\7)\2\2\u00c3\u00c6\7)\2\2\u00c4\u00c6\n\5"+
		"\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\5\u0095K\2\u00cb\u00cd\3\2\2\2\u00cc"+
		"\u00b2\3\2\2\2\u00cc\u00bf\3\2\2\2\u00cd\6\3\2\2\2\u00ce\u00d2\5\t\5\2"+
		"\u00cf\u00d2\5\13\6\2\u00d0\u00d2\5\r\7\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\b\3\2\2\2\u00d3\u00d5\5\23\n\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\n\3\2\2\2\u00d8\u00da\5\t\5\2\u00d9\u00d8\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00dd\5o8\2\u00dc\u00db\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\5\t\5\2\u00df\u00e2\5!"+
		"\21\2\u00e0\u00e3\5e\63\2\u00e1\u00e3\5g\64\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\5\t"+
		"\5\2\u00e5\f\3\2\2\2\u00e6\u00e8\5\t\5\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\5o8\2\u00ea\u00eb\5\t\5\2\u00eb"+
		"\16\3\2\2\2\u00ec\u00ed\7\62\2\2\u00ed\u00ee\7z\2\2\u00ee\u00f0\3\2\2"+
		"\2\u00ef\u00f1\5\25\13\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00fe\3\2\2\2\u00f4\u00f5\7Z"+
		"\2\2\u00f5\u00f7\5\u0095K\2\u00f6\u00f8\5\25\13\2\u00f7\u00f6\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fc\5\u0095K\2\u00fc\u00fe\3\2\2\2\u00fd\u00ec\3\2\2"+
		"\2\u00fd\u00f4\3\2\2\2\u00fe\20\3\2\2\2\u00ff\u0100\7\62\2\2\u0100\u0101"+
		"\7d\2\2\u0101\u0103\3\2\2\2\u0102\u0104\4\62\63\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0111"+
		"\3\2\2\2\u0107\u0108\5\33\16\2\u0108\u010a\5\u0095K\2\u0109\u010b\4\62"+
		"\63\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\5\u0095K\2\u010f\u0111"+
		"\3\2\2\2\u0110\u00ff\3\2\2\2\u0110\u0107\3\2\2\2\u0111\22\3\2\2\2\u0112"+
		"\u0113\t\6\2\2\u0113\24\3\2\2\2\u0114\u0115\t\7\2\2\u0115\26\3\2\2\2\u0116"+
		"\u0117\7F\2\2\u0117\u0118\7Q\2\2\u0118\u0119\7\"\2\2\u0119\u011a\7P\2"+
		"\2\u011a\u011b\7Q\2\2\u011b\u011c\7V\2\2\u011c\u011d\7\"\2\2\u011d\u011e"+
		"\7O\2\2\u011e\u011f\7C\2\2\u011f\u0120\7V\2\2\u0120\u0121\7E\2\2\u0121"+
		"\u0122\7J\2\2\u0122\u0123\7\"\2\2\u0123\u0124\7C\2\2\u0124\u0125\7P\2"+
		"\2\u0125\u0126\7[\2\2\u0126\u0127\7\"\2\2\u0127\u0128\7V\2\2\u0128\u0129"+
		"\7J\2\2\u0129\u012a\7K\2\2\u012a\u012b\7P\2\2\u012b\u012c\7I\2\2\u012c"+
		"\u012d\7.\2\2\u012d\u012e\7\"\2\2\u012e\u012f\7L\2\2\u012f\u0130\7W\2"+
		"\2\u0130\u0131\7U\2\2\u0131\u0132\7V\2\2\u0132\u0133\7\"\2\2\u0133\u0134"+
		"\7H\2\2\u0134\u0135\7Q\2\2\u0135\u0136\7T\2\2\u0136\u0137\7\"\2\2\u0137"+
		"\u0138\7I\2\2\u0138\u0139\7G\2\2\u0139\u013a\7P\2\2\u013a\u013b\7G\2\2"+
		"\u013b\u013c\7T\2\2\u013c\u013d\7C\2\2\u013d\u013e\7V\2\2\u013e\u013f"+
		"\7Q\2\2\u013f\u0140\7T\2\2\u0140\30\3\2\2\2\u0141\u0142\t\b\2\2\u0142"+
		"\32\3\2\2\2\u0143\u0144\t\t\2\2\u0144\34\3\2\2\2\u0145\u0146\t\n\2\2\u0146"+
		"\36\3\2\2\2\u0147\u0148\t\13\2\2\u0148 \3\2\2\2\u0149\u014a\t\f\2\2\u014a"+
		"\"\3\2\2\2\u014b\u014c\t\r\2\2\u014c$\3\2\2\2\u014d\u014e\t\16\2\2\u014e"+
		"&\3\2\2\2\u014f\u0150\t\17\2\2\u0150(\3\2\2\2\u0151\u0152\t\20\2\2\u0152"+
		"*\3\2\2\2\u0153\u0154\t\21\2\2\u0154,\3\2\2\2\u0155\u0156\t\22\2\2\u0156"+
		".\3\2\2\2\u0157\u0158\t\23\2\2\u0158\60\3\2\2\2\u0159\u015a\t\24\2\2\u015a"+
		"\62\3\2\2\2\u015b\u015c\t\25\2\2\u015c\64\3\2\2\2\u015d\u015e\t\26\2\2"+
		"\u015e\66\3\2\2\2\u015f\u0160\t\27\2\2\u01608\3\2\2\2\u0161\u0162\t\30"+
		"\2\2\u0162:\3\2\2\2\u0163\u0164\t\31\2\2\u0164<\3\2\2\2\u0165\u0166\t"+
		"\32\2\2\u0166>\3\2\2\2\u0167\u0168\t\33\2\2\u0168@\3\2\2\2\u0169\u016a"+
		"\t\34\2\2\u016aB\3\2\2\2\u016b\u016c\t\35\2\2\u016cD\3\2\2\2\u016d\u016e"+
		"\t\36\2\2\u016eF\3\2\2\2\u016f\u0170\t\37\2\2\u0170H\3\2\2\2\u0171\u0172"+
		"\t \2\2\u0172J\3\2\2\2\u0173\u0174\t!\2\2\u0174L\3\2\2\2\u0175\u0176\7"+
		"a\2\2\u0176N\3\2\2\2\u0177\u0178\7(\2\2\u0178\u0179\7(\2\2\u0179P\3\2"+
		"\2\2\u017a\u017b\7~\2\2\u017b\u017c\7~\2\2\u017cR\3\2\2\2\u017d\u017e"+
		"\7#\2\2\u017eT\3\2\2\2\u017f\u0180\7\u0080\2\2\u0180V\3\2\2\2\u0181\u0182"+
		"\7~\2\2\u0182X\3\2\2\2\u0183\u0184\7(\2\2\u0184Z\3\2\2\2\u0185\u0186\7"+
		">\2\2\u0186\u0187\7>\2\2\u0187\\\3\2\2\2\u0188\u0189\7@\2\2\u0189\u018a"+
		"\7@\2\2\u018a^\3\2\2\2\u018b\u018c\7`\2\2\u018c`\3\2\2\2\u018d\u018e\7"+
		"\'\2\2\u018eb\3\2\2\2\u018f\u0190\7<\2\2\u0190d\3\2\2\2\u0191\u0192\7"+
		"-\2\2\u0192f\3\2\2\2\u0193\u0194\7/\2\2\u0194h\3\2\2\2\u0195\u0196\7,"+
		"\2\2\u0196j\3\2\2\2\u0197\u0198\7\61\2\2\u0198l\3\2\2\2\u0199\u019a\7"+
		"^\2\2\u019an\3\2\2\2\u019b\u019c\7\60\2\2\u019cp\3\2\2\2\u019d\u019e\7"+
		"\60\2\2\u019e\u019f\7,\2\2\u019fr\3\2\2\2\u01a0\u01a1\7>\2\2\u01a1\u01a2"+
		"\7?\2\2\u01a2\u01a3\7@\2\2\u01a3t\3\2\2\2\u01a4\u01a5\7?\2\2\u01a5\u01a6"+
		"\7?\2\2\u01a6v\3\2\2\2\u01a7\u01a8\7?\2\2\u01a8x\3\2\2\2\u01a9\u01aa\7"+
		">\2\2\u01aa\u01ae\7@\2\2\u01ab\u01ac\7#\2\2\u01ac\u01ae\7?\2\2\u01ad\u01a9"+
		"\3\2\2\2\u01ad\u01ab\3\2\2\2\u01aez\3\2\2\2\u01af\u01b0\7@\2\2\u01b0|"+
		"\3\2\2\2\u01b1\u01b2\7@\2\2\u01b2\u01b3\7?\2\2\u01b3~\3\2\2\2\u01b4\u01b5"+
		"\7>\2\2\u01b5\u0080\3\2\2\2\u01b6\u01b7\7>\2\2\u01b7\u01b8\7?\2\2\u01b8"+
		"\u0082\3\2\2\2\u01b9\u01ba\7%\2\2\u01ba\u0084\3\2\2\2\u01bb\u01bc\7*\2"+
		"\2\u01bc\u0086\3\2\2\2\u01bd\u01be\7+\2\2\u01be\u0088\3\2\2\2\u01bf\u01c0"+
		"\7}\2\2\u01c0\u008a\3\2\2\2\u01c1\u01c2\7\177\2\2\u01c2\u008c\3\2\2\2"+
		"\u01c3\u01c4\7]\2\2\u01c4\u008e\3\2\2\2\u01c5\u01c6\7_\2\2\u01c6\u0090"+
		"\3\2\2\2\u01c7\u01c8\7.\2\2\u01c8\u0092\3\2\2\2\u01c9\u01ca\7$\2\2\u01ca"+
		"\u0094\3\2\2\2\u01cb\u01cc\7)\2\2\u01cc\u0096\3\2\2\2\u01cd\u01ce\7b\2"+
		"\2\u01ce\u0098\3\2\2\2\u01cf\u01d0\7A\2\2\u01d0\u009a\3\2\2\2\u01d1\u01d2"+
		"\7B\2\2\u01d2\u009c\3\2\2\2\u01d3\u01d4\7=\2\2\u01d4\u009e\3\2\2\2\32"+
		"\2\u00a0\u00a3\u00a9\u00ad\u00b0\u00b8\u00ba\u00c5\u00c7\u00cc\u00d1\u00d6"+
		"\u00d9\u00dc\u00e2\u00e7\u00f2\u00f9\u00fd\u0105\u010c\u0110\u01ad\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}