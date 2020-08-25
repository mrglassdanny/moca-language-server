// Generated from c:\dev\moca-language-server\src\main\antlr\Moca.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MocaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LEFT_PAREN=4, RIGHT_PAREN=5, LEFT_BRACE=6, RIGHT_BRACE=7, 
		LESS=8, GREATER=9, LESS_EQUAL=10, GREATER_EQUAL=11, DOUBLE_LESS=12, DOUBLE_GREATER=13, 
		PLUS=14, MINUS=15, STAR=16, DIV=17, MOD=18, BACKSLASH=19, AMPERSAND=20, 
		CARET=21, BANG=22, QUESTION=23, COLON=24, SEMI_COLON=25, COMMA=26, PIPE=27, 
		DOUBLE_PIPE=28, POUND=29, AT=30, EQUAL=31, NOT_EQUAL=32, DOT=33, DOUBLE_BRACKET_STRING=34, 
		SINGLE_BRACKET_STRING=35, MOCA_INTEGRATOR_OVERSTACKED_ARGS=36, WHERE=37, 
		AND=38, LIKE=39, OR=40, IS=41, NOT=42, NULL=43, IF=44, ELSE=45, TRY=46, 
		CATCH=47, FINALLY=48, REMOTE=49, PARALLEL=50, INPARALLEL=51, WORD=52, 
		NUMERIC_LITERAL=53, STRING_LITERAL=54, BLOCK_COMMENT=55, WHITESPACE=56, 
		NEWLINE=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
			"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
			"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
			"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOUBLE_BRACKET_STRING", 
			"SINGLE_BRACKET_STRING", "MOCA_INTEGRATOR_OVERSTACKED_ARGS", "WHERE", 
			"AND", "LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", 
			"FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", "WORD", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "BLOCK_COMMENT", "WHITESPACE", "NEWLINE", "DIGIT", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'keep'", "'onstack'", "'ignore'", "'('", "')'", "'{'", "'}'", 
			"'<'", "'>'", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'\\'", "'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", 
			"'||'", "'#'", "'@'", "'='", null, "'.'", null, null, "'<<OVERSTACKED_ARGS>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
			"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
			"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
			"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOUBLE_BRACKET_STRING", 
			"SINGLE_BRACKET_STRING", "MOCA_INTEGRATOR_OVERSTACKED_ARGS", "WHERE", 
			"AND", "LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", 
			"FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", "WORD", "NUMERIC_LITERAL", 
			"STRING_LITERAL", "BLOCK_COMMENT", "WHITESPACE", "NEWLINE"
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


	public MocaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Moca.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u021e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0101\n!\3\"\3\"\3#\3#\3#\3#\7#\u0109"+
		"\n#\f#\16#\u010c\13#\3#\3#\3#\3$\3$\7$\u0113\n$\f$\16$\u0116\13$\3$\3"+
		"$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3"+
		"+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\7\65\u0184"+
		"\n\65\f\65\16\65\u0187\13\65\3\66\6\66\u018a\n\66\r\66\16\66\u018b\3\66"+
		"\3\66\7\66\u0190\n\66\f\66\16\66\u0193\13\66\5\66\u0195\n\66\3\66\3\66"+
		"\5\66\u0199\n\66\3\66\6\66\u019c\n\66\r\66\16\66\u019d\5\66\u01a0\n\66"+
		"\3\66\3\66\6\66\u01a4\n\66\r\66\16\66\u01a5\3\66\3\66\5\66\u01aa\n\66"+
		"\3\66\6\66\u01ad\n\66\r\66\16\66\u01ae\5\66\u01b1\n\66\5\66\u01b3\n\66"+
		"\3\67\3\67\3\67\3\67\7\67\u01b9\n\67\f\67\16\67\u01bc\13\67\3\67\3\67"+
		"\3\67\3\67\3\67\7\67\u01c3\n\67\f\67\16\67\u01c6\13\67\3\67\5\67\u01c9"+
		"\n\67\38\38\38\38\78\u01cf\n8\f8\168\u01d2\138\38\38\38\38\38\39\69\u01da"+
		"\n9\r9\169\u01db\39\39\3:\3:\5:\u01e2\n:\3:\5:\u01e5\n:\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3"+
		"G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3"+
		"S\3S\3T\3T\3U\3U\5\u010a\u0114\u01d0\2V\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2}\2\177\2\u0081"+
		"\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093"+
		"\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5"+
		"\2\u00a7\2\u00a9\2\3\2#\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\3\2$$"+
		"\4\2\13\13\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHh"+
		"h\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2"+
		"QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\2\u021a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3\u00ab"+
		"\3\2\2\2\5\u00b0\3\2\2\2\7\u00b8\3\2\2\2\t\u00bf\3\2\2\2\13\u00c1\3\2"+
		"\2\2\r\u00c3\3\2\2\2\17\u00c5\3\2\2\2\21\u00c7\3\2\2\2\23\u00c9\3\2\2"+
		"\2\25\u00cb\3\2\2\2\27\u00ce\3\2\2\2\31\u00d1\3\2\2\2\33\u00d4\3\2\2\2"+
		"\35\u00d7\3\2\2\2\37\u00d9\3\2\2\2!\u00db\3\2\2\2#\u00dd\3\2\2\2%\u00df"+
		"\3\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3\2\2\2-\u00e7\3\2\2\2"+
		"/\u00e9\3\2\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2\65\u00ef\3\2\2\2\67"+
		"\u00f1\3\2\2\29\u00f3\3\2\2\2;\u00f6\3\2\2\2=\u00f8\3\2\2\2?\u00fa\3\2"+
		"\2\2A\u0100\3\2\2\2C\u0102\3\2\2\2E\u0104\3\2\2\2G\u0110\3\2\2\2I\u0119"+
		"\3\2\2\2K\u012e\3\2\2\2M\u0134\3\2\2\2O\u0138\3\2\2\2Q\u013d\3\2\2\2S"+
		"\u0140\3\2\2\2U\u0143\3\2\2\2W\u0147\3\2\2\2Y\u014c\3\2\2\2[\u014f\3\2"+
		"\2\2]\u0154\3\2\2\2_\u0158\3\2\2\2a\u015e\3\2\2\2c\u0166\3\2\2\2e\u016d"+
		"\3\2\2\2g\u0176\3\2\2\2i\u0181\3\2\2\2k\u01b2\3\2\2\2m\u01c8\3\2\2\2o"+
		"\u01ca\3\2\2\2q\u01d9\3\2\2\2s\u01e4\3\2\2\2u\u01e8\3\2\2\2w\u01ea\3\2"+
		"\2\2y\u01ec\3\2\2\2{\u01ee\3\2\2\2}\u01f0\3\2\2\2\177\u01f2\3\2\2\2\u0081"+
		"\u01f4\3\2\2\2\u0083\u01f6\3\2\2\2\u0085\u01f8\3\2\2\2\u0087\u01fa\3\2"+
		"\2\2\u0089\u01fc\3\2\2\2\u008b\u01fe\3\2\2\2\u008d\u0200\3\2\2\2\u008f"+
		"\u0202\3\2\2\2\u0091\u0204\3\2\2\2\u0093\u0206\3\2\2\2\u0095\u0208\3\2"+
		"\2\2\u0097\u020a\3\2\2\2\u0099\u020c\3\2\2\2\u009b\u020e\3\2\2\2\u009d"+
		"\u0210\3\2\2\2\u009f\u0212\3\2\2\2\u00a1\u0214\3\2\2\2\u00a3\u0216\3\2"+
		"\2\2\u00a5\u0218\3\2\2\2\u00a7\u021a\3\2\2\2\u00a9\u021c\3\2\2\2\u00ab"+
		"\u00ac\7m\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7r\2\2"+
		"\u00af\4\3\2\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7u"+
		"\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7"+
		"\7m\2\2\u00b7\6\3\2\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7i\2\2\u00ba\u00bb"+
		"\7p\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be"+
		"\b\3\2\2\2\u00bf\u00c0\7*\2\2\u00c0\n\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2"+
		"\f\3\2\2\2\u00c3\u00c4\7}\2\2\u00c4\16\3\2\2\2\u00c5\u00c6\7\177\2\2\u00c6"+
		"\20\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\22\3\2\2\2\u00c9\u00ca\7@\2\2\u00ca"+
		"\24\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc\u00cd\7?\2\2\u00cd\26\3\2\2\2\u00ce"+
		"\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0\30\3\2\2\2\u00d1\u00d2\7>\2\2\u00d2"+
		"\u00d3\7>\2\2\u00d3\32\3\2\2\2\u00d4\u00d5\7@\2\2\u00d5\u00d6\7@\2\2\u00d6"+
		"\34\3\2\2\2\u00d7\u00d8\7-\2\2\u00d8\36\3\2\2\2\u00d9\u00da\7/\2\2\u00da"+
		" \3\2\2\2\u00db\u00dc\7,\2\2\u00dc\"\3\2\2\2\u00dd\u00de\7\61\2\2\u00de"+
		"$\3\2\2\2\u00df\u00e0\7\'\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7^\2\2\u00e2"+
		"(\3\2\2\2\u00e3\u00e4\7(\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7`\2\2\u00e6,"+
		"\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7A\2\2\u00ea\60"+
		"\3\2\2\2\u00eb\u00ec\7<\2\2\u00ec\62\3\2\2\2\u00ed\u00ee\7=\2\2\u00ee"+
		"\64\3\2\2\2\u00ef\u00f0\7.\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7~\2\2\u00f2"+
		"8\3\2\2\2\u00f3\u00f4\7~\2\2\u00f4\u00f5\7~\2\2\u00f5:\3\2\2\2\u00f6\u00f7"+
		"\7%\2\2\u00f7<\3\2\2\2\u00f8\u00f9\7B\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7"+
		"?\2\2\u00fb@\3\2\2\2\u00fc\u00fd\7#\2\2\u00fd\u0101\7?\2\2\u00fe\u00ff"+
		"\7>\2\2\u00ff\u0101\7@\2\2\u0100\u00fc\3\2\2\2\u0100\u00fe\3\2\2\2\u0101"+
		"B\3\2\2\2\u0102\u0103\7\60\2\2\u0103D\3\2\2\2\u0104\u0105\7]\2\2\u0105"+
		"\u0106\7]\2\2\u0106\u010a\3\2\2\2\u0107\u0109\13\2\2\2\u0108\u0107\3\2"+
		"\2\2\u0109\u010c\3\2\2\2\u010a\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\7_\2\2\u010e\u010f\7_\2"+
		"\2\u010fF\3\2\2\2\u0110\u0114\7]\2\2\u0111\u0113\13\2\2\2\u0112\u0111"+
		"\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0117\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\7_\2\2\u0118H\3\2\2\2\u0119"+
		"\u011a\7>\2\2\u011a\u011b\7>\2\2\u011b\u011c\7Q\2\2\u011c\u011d\7X\2\2"+
		"\u011d\u011e\7G\2\2\u011e\u011f\7T\2\2\u011f\u0120\7U\2\2\u0120\u0121"+
		"\7V\2\2\u0121\u0122\7C\2\2\u0122\u0123\7E\2\2\u0123\u0124\7M\2\2\u0124"+
		"\u0125\7G\2\2\u0125\u0126\7F\2\2\u0126\u0127\7a\2\2\u0127\u0128\7C\2\2"+
		"\u0128\u0129\7T\2\2\u0129\u012a\7I\2\2\u012a\u012b\7U\2\2\u012b\u012c"+
		"\7@\2\2\u012c\u012d\7@\2\2\u012dJ\3\2\2\2\u012e\u012f\5\u00a3R\2\u012f"+
		"\u0130\5\u0085C\2\u0130\u0131\5\177@\2\u0131\u0132\5\u0099M\2\u0132\u0133"+
		"\5\177@\2\u0133L\3\2\2\2\u0134\u0135\5w<\2\u0135\u0136\5\u0091I\2\u0136"+
		"\u0137\5}?\2\u0137N\3\2\2\2\u0138\u0139\5\u008dG\2\u0139\u013a\5\u0087"+
		"D\2\u013a\u013b\5\u008bF\2\u013b\u013c\5\177@\2\u013cP\3\2\2\2\u013d\u013e"+
		"\5\u0093J\2\u013e\u013f\5\u0099M\2\u013fR\3\2\2\2\u0140\u0141\5\u0087"+
		"D\2\u0141\u0142\5\u009bN\2\u0142T\3\2\2\2\u0143\u0144\5\u0091I\2\u0144"+
		"\u0145\5\u0093J\2\u0145\u0146\5\u009dO\2\u0146V\3\2\2\2\u0147\u0148\5"+
		"\u0091I\2\u0148\u0149\5\u009fP\2\u0149\u014a\5\u008dG\2\u014a\u014b\5"+
		"\u008dG\2\u014bX\3\2\2\2\u014c\u014d\5\u0087D\2\u014d\u014e\5\u0081A\2"+
		"\u014eZ\3\2\2\2\u014f\u0150\5\177@\2\u0150\u0151\5\u008dG\2\u0151\u0152"+
		"\5\u009bN\2\u0152\u0153\5\177@\2\u0153\\\3\2\2\2\u0154\u0155\5\u009dO"+
		"\2\u0155\u0156\5\u0099M\2\u0156\u0157\5\u00a7T\2\u0157^\3\2\2\2\u0158"+
		"\u0159\5{>\2\u0159\u015a\5w<\2\u015a\u015b\5\u009dO\2\u015b\u015c\5{>"+
		"\2\u015c\u015d\5\u0085C\2\u015d`\3\2\2\2\u015e\u015f\5\u0081A\2\u015f"+
		"\u0160\5\u0087D\2\u0160\u0161\5\u0091I\2\u0161\u0162\5w<\2\u0162\u0163"+
		"\5\u008dG\2\u0163\u0164\5\u008dG\2\u0164\u0165\5\u00a7T\2\u0165b\3\2\2"+
		"\2\u0166\u0167\5\u0099M\2\u0167\u0168\5\177@\2\u0168\u0169\5\u008fH\2"+
		"\u0169\u016a\5\u0093J\2\u016a\u016b\5\u009dO\2\u016b\u016c\5\177@\2\u016c"+
		"d\3\2\2\2\u016d\u016e\5\u0095K\2\u016e\u016f\5w<\2\u016f\u0170\5\u0099"+
		"M\2\u0170\u0171\5w<\2\u0171\u0172\5\u008dG\2\u0172\u0173\5\u008dG\2\u0173"+
		"\u0174\5\177@\2\u0174\u0175\5\u008dG\2\u0175f\3\2\2\2\u0176\u0177\5\u0087"+
		"D\2\u0177\u0178\5\u0091I\2\u0178\u0179\5\u0095K\2\u0179\u017a\5w<\2\u017a"+
		"\u017b\5\u0099M\2\u017b\u017c\5w<\2\u017c\u017d\5\u008dG\2\u017d\u017e"+
		"\5\u008dG\2\u017e\u017f\5\177@\2\u017f\u0180\5\u008dG\2\u0180h\3\2\2\2"+
		"\u0181\u0185\t\2\2\2\u0182\u0184\t\3\2\2\u0183\u0182\3\2\2\2\u0184\u0187"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186j\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0188\u018a\5u;\2\u0189\u0188\3\2\2\2\u018a\u018b\3\2\2"+
		"\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0194\3\2\2\2\u018d\u0191"+
		"\7\60\2\2\u018e\u0190\5u;\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2"+
		"\2\2\u0194\u018d\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u019f\3\2\2\2\u0196"+
		"\u0198\5\177@\2\u0197\u0199\t\4\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3"+
		"\2\2\2\u0199\u019b\3\2\2\2\u019a\u019c\5u;\2\u019b\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2"+
		"\2\2\u019f\u0196\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01b3\3\2\2\2\u01a1"+
		"\u01a3\7\60\2\2\u01a2\u01a4\5u;\2\u01a3\u01a2\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01b0\3\2\2\2\u01a7"+
		"\u01a9\5\177@\2\u01a8\u01aa\t\4\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01ad\5u;\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2"+
		"\2\2\u01b0\u01a7\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u0189\3\2\2\2\u01b2\u01a1\3\2\2\2\u01b3l\3\2\2\2\u01b4\u01ba\7)\2\2\u01b5"+
		"\u01b9\n\5\2\2\u01b6\u01b7\7)\2\2\u01b7\u01b9\7)\2\2\u01b8\u01b5\3\2\2"+
		"\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb"+
		"\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01c9\7)\2\2\u01be"+
		"\u01c4\7$\2\2\u01bf\u01c3\n\6\2\2\u01c0\u01c1\7$\2\2\u01c1\u01c3\7$\2"+
		"\2\u01c2\u01bf\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2"+
		"\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01c9\7$\2\2\u01c8\u01b4\3\2\2\2\u01c8\u01be\3\2\2\2\u01c9n\3\2\2\2\u01ca"+
		"\u01cb\7\61\2\2\u01cb\u01cc\7,\2\2\u01cc\u01d0\3\2\2\2\u01cd\u01cf\13"+
		"\2\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\7,"+
		"\2\2\u01d4\u01d5\7\61\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\b8\2\2\u01d7"+
		"p\3\2\2\2\u01d8\u01da\t\7\2\2\u01d9\u01d8\3\2\2\2\u01da\u01db\3\2\2\2"+
		"\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de"+
		"\b9\3\2\u01der\3\2\2\2\u01df\u01e1\7\17\2\2\u01e0\u01e2\7\f\2\2\u01e1"+
		"\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e5\7\f"+
		"\2\2\u01e4\u01df\3\2\2\2\u01e4\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e7\b:\3\2\u01e7t\3\2\2\2\u01e8\u01e9\t\b\2\2\u01e9v\3\2\2\2\u01ea"+
		"\u01eb\t\t\2\2\u01ebx\3\2\2\2\u01ec\u01ed\t\n\2\2\u01edz\3\2\2\2\u01ee"+
		"\u01ef\t\13\2\2\u01ef|\3\2\2\2\u01f0\u01f1\t\f\2\2\u01f1~\3\2\2\2\u01f2"+
		"\u01f3\t\r\2\2\u01f3\u0080\3\2\2\2\u01f4\u01f5\t\16\2\2\u01f5\u0082\3"+
		"\2\2\2\u01f6\u01f7\t\17\2\2\u01f7\u0084\3\2\2\2\u01f8\u01f9\t\20\2\2\u01f9"+
		"\u0086\3\2\2\2\u01fa\u01fb\t\21\2\2\u01fb\u0088\3\2\2\2\u01fc\u01fd\t"+
		"\22\2\2\u01fd\u008a\3\2\2\2\u01fe\u01ff\t\23\2\2\u01ff\u008c\3\2\2\2\u0200"+
		"\u0201\t\24\2\2\u0201\u008e\3\2\2\2\u0202\u0203\t\25\2\2\u0203\u0090\3"+
		"\2\2\2\u0204\u0205\t\26\2\2\u0205\u0092\3\2\2\2\u0206\u0207\t\27\2\2\u0207"+
		"\u0094\3\2\2\2\u0208\u0209\t\30\2\2\u0209\u0096\3\2\2\2\u020a\u020b\t"+
		"\31\2\2\u020b\u0098\3\2\2\2\u020c\u020d\t\32\2\2\u020d\u009a\3\2\2\2\u020e"+
		"\u020f\t\33\2\2\u020f\u009c\3\2\2\2\u0210\u0211\t\34\2\2\u0211\u009e\3"+
		"\2\2\2\u0212\u0213\t\35\2\2\u0213\u00a0\3\2\2\2\u0214\u0215\t\36\2\2\u0215"+
		"\u00a2\3\2\2\2\u0216\u0217\t\37\2\2\u0217\u00a4\3\2\2\2\u0218\u0219\t"+
		" \2\2\u0219\u00a6\3\2\2\2\u021a\u021b\t!\2\2\u021b\u00a8\3\2\2\2\u021c"+
		"\u021d\t\"\2\2\u021d\u00aa\3\2\2\2\33\2\u0100\u010a\u0114\u0185\u018b"+
		"\u0191\u0194\u0198\u019d\u019f\u01a5\u01a9\u01ae\u01b0\u01b2\u01b8\u01ba"+
		"\u01c2\u01c4\u01c8\u01d0\u01db\u01e1\u01e4\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}