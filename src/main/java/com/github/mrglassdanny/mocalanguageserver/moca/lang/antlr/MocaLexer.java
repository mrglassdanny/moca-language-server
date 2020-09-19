// Generated from Moca.g4 by ANTLR 4.8

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

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
		DOUBLE_BRACKET_STRING=1, SINGLE_BRACKET_STRING=2, LEFT_PAREN=3, RIGHT_PAREN=4, 
		LEFT_BRACE=5, RIGHT_BRACE=6, LEFT_BRACKET=7, RIGHT_BRACKET=8, LESS=9, 
		GREATER=10, LESS_EQUAL=11, GREATER_EQUAL=12, DOUBLE_LESS=13, DOUBLE_GREATER=14, 
		PLUS=15, MINUS=16, STAR=17, DIV=18, MOD=19, BACKSLASH=20, AMPERSAND=21, 
		CARET=22, BANG=23, QUESTION=24, COLON=25, SEMI_COLON=26, COMMA=27, PIPE=28, 
		DOUBLE_PIPE=29, POUND=30, AT=31, EQUAL=32, NOT_EQUAL=33, DOT=34, DOLLAR_SIGN=35, 
		OVERSTACKED_ARGS=36, SPECIAL_COMMAND_ARG_NO_ROWS=37, SPECIAL_COMMAND_ARG_DUMMY_ARG=38, 
		SUPPRESS_WARNINGS=39, WHERE=40, AND=41, LIKE=42, OR=43, IS=44, NOT=45, 
		NULL=46, IF=47, ELSE=48, TRY=49, CATCH=50, FINALLY=51, REMOTE=52, PARALLEL=53, 
		INPARALLEL=54, ONSTACK=55, KEEP=56, NUMERIC_LITERAL=57, STRING_LITERAL=58, 
		WORD=59, BLOCK_COMMENT=60, WHITESPACE=61, NEWLINE=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", "FRAGMENT_SINGLE_BRACKET_STRING", 
			"LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", 
			"DOUBLE_GREATER", "PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", 
			"AMPERSAND", "CARET", "BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", 
			"PIPE", "DOUBLE_PIPE", "POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOLLAR_SIGN", 
			"OVERSTACKED_ARGS", "SPECIAL_COMMAND_ARG_NO_ROWS", "SPECIAL_COMMAND_ARG_DUMMY_ARG", 
			"SUPPRESS_WARNINGS", "WHERE", "AND", "LIKE", "OR", "IS", "NOT", "NULL", 
			"IF", "ELSE", "TRY", "CATCH", "FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", 
			"ONSTACK", "KEEP", "NUMERIC_LITERAL", "STRING_LITERAL", "WORD", "BLOCK_COMMENT", 
			"WHITESPACE", "NEWLINE", "DIGIT", "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'<'", "'>'", 
			"'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'\\'", 
			"'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", "'#'", 
			"'@'", "'='", null, "'.'", "'$'", "'<<OVERSTACKED_ARGS>>'", "'#NO_ROWS'", 
			"'#DUMMY_ARG'", "'@SuppressWarnings'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", "LEFT_PAREN", 
			"RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
			"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
			"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
			"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOLLAR_SIGN", "OVERSTACKED_ARGS", 
			"SPECIAL_COMMAND_ARG_NO_ROWS", "SPECIAL_COMMAND_ARG_DUMMY_ARG", "SUPPRESS_WARNINGS", 
			"WHERE", "AND", "LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", 
			"CATCH", "FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", "ONSTACK", "KEEP", 
			"NUMERIC_LITERAL", "STRING_LITERAL", "WORD", "BLOCK_COMMENT", "WHITESPACE", 
			"NEWLINE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u0248\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\u00c1\n\4\f\4\16\4\u00c4\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3#\3#\5#\u010d\n#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\38"+
		"\38\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\6;\u01af\n;\r;\16"+
		";\u01b0\3;\3;\7;\u01b5\n;\f;\16;\u01b8\13;\5;\u01ba\n;\3;\3;\5;\u01be"+
		"\n;\3;\6;\u01c1\n;\r;\16;\u01c2\5;\u01c5\n;\3;\3;\6;\u01c9\n;\r;\16;\u01ca"+
		"\3;\3;\5;\u01cf\n;\3;\6;\u01d2\n;\r;\16;\u01d3\5;\u01d6\n;\5;\u01d8\n"+
		";\3<\3<\3<\3<\7<\u01de\n<\f<\16<\u01e1\13<\3<\3<\3<\3<\3<\7<\u01e8\n<"+
		"\f<\16<\u01eb\13<\3<\5<\u01ee\n<\3=\6=\u01f1\n=\r=\16=\u01f2\3>\3>\3>"+
		"\3>\7>\u01f9\n>\f>\16>\u01fc\13>\3>\3>\3>\3>\3>\3?\6?\u0204\n?\r?\16?"+
		"\u0205\3?\3?\3@\3@\5@\u020c\n@\3@\5@\u020f\n@\3@\3@\3A\3A\3B\3B\3C\3C"+
		"\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O"+
		"\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z"+
		"\3[\3[\3\u01fa\2\\\3\3\5\4\7\2\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f"+
		"\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65"+
		"\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63"+
		"g\64i\65k\66m\67o8q9s:u;w<y={>}?\177@\u0081\2\u0083\2\u0085\2\u0087\2"+
		"\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab"+
		"\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\3\2#\4\2]]__\4\2--//\3\2))"+
		"\3\2$$\7\2\60\60\62;C\\aac|\4\2\13\13\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2"+
		"EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4"+
		"\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVv"+
		"v\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0243\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\3\u00b7\3\2\2\2\5\u00bb\3\2\2\2\7\u00bd\3\2\2\2\t\u00c7\3"+
		"\2\2\2\13\u00c9\3\2\2\2\r\u00cb\3\2\2\2\17\u00cd\3\2\2\2\21\u00cf\3\2"+
		"\2\2\23\u00d1\3\2\2\2\25\u00d3\3\2\2\2\27\u00d5\3\2\2\2\31\u00d7\3\2\2"+
		"\2\33\u00da\3\2\2\2\35\u00dd\3\2\2\2\37\u00e0\3\2\2\2!\u00e3\3\2\2\2#"+
		"\u00e5\3\2\2\2%\u00e7\3\2\2\2\'\u00e9\3\2\2\2)\u00eb\3\2\2\2+\u00ed\3"+
		"\2\2\2-\u00ef\3\2\2\2/\u00f1\3\2\2\2\61\u00f3\3\2\2\2\63\u00f5\3\2\2\2"+
		"\65\u00f7\3\2\2\2\67\u00f9\3\2\2\29\u00fb\3\2\2\2;\u00fd\3\2\2\2=\u00ff"+
		"\3\2\2\2?\u0102\3\2\2\2A\u0104\3\2\2\2C\u0106\3\2\2\2E\u010c\3\2\2\2G"+
		"\u010e\3\2\2\2I\u0110\3\2\2\2K\u0112\3\2\2\2M\u0127\3\2\2\2O\u0130\3\2"+
		"\2\2Q\u013b\3\2\2\2S\u014d\3\2\2\2U\u0153\3\2\2\2W\u0157\3\2\2\2Y\u015c"+
		"\3\2\2\2[\u015f\3\2\2\2]\u0162\3\2\2\2_\u0166\3\2\2\2a\u016b\3\2\2\2c"+
		"\u016e\3\2\2\2e\u0173\3\2\2\2g\u0177\3\2\2\2i\u017d\3\2\2\2k\u0185\3\2"+
		"\2\2m\u018c\3\2\2\2o\u0195\3\2\2\2q\u01a0\3\2\2\2s\u01a8\3\2\2\2u\u01d7"+
		"\3\2\2\2w\u01ed\3\2\2\2y\u01f0\3\2\2\2{\u01f4\3\2\2\2}\u0203\3\2\2\2\177"+
		"\u020e\3\2\2\2\u0081\u0212\3\2\2\2\u0083\u0214\3\2\2\2\u0085\u0216\3\2"+
		"\2\2\u0087\u0218\3\2\2\2\u0089\u021a\3\2\2\2\u008b\u021c\3\2\2\2\u008d"+
		"\u021e\3\2\2\2\u008f\u0220\3\2\2\2\u0091\u0222\3\2\2\2\u0093\u0224\3\2"+
		"\2\2\u0095\u0226\3\2\2\2\u0097\u0228\3\2\2\2\u0099\u022a\3\2\2\2\u009b"+
		"\u022c\3\2\2\2\u009d\u022e\3\2\2\2\u009f\u0230\3\2\2\2\u00a1\u0232\3\2"+
		"\2\2\u00a3\u0234\3\2\2\2\u00a5\u0236\3\2\2\2\u00a7\u0238\3\2\2\2\u00a9"+
		"\u023a\3\2\2\2\u00ab\u023c\3\2\2\2\u00ad\u023e\3\2\2\2\u00af\u0240\3\2"+
		"\2\2\u00b1\u0242\3\2\2\2\u00b3\u0244\3\2\2\2\u00b5\u0246\3\2\2\2\u00b7"+
		"\u00b8\5\21\t\2\u00b8\u00b9\5\7\4\2\u00b9\u00ba\5\23\n\2\u00ba\4\3\2\2"+
		"\2\u00bb\u00bc\5\7\4\2\u00bc\6\3\2\2\2\u00bd\u00c2\5\21\t\2\u00be\u00c1"+
		"\n\2\2\2\u00bf\u00c1\5\7\4\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\5\23\n\2\u00c6\b\3\2\2\2\u00c7\u00c8"+
		"\7*\2\2\u00c8\n\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca\f\3\2\2\2\u00cb\u00cc"+
		"\7}\2\2\u00cc\16\3\2\2\2\u00cd\u00ce\7\177\2\2\u00ce\20\3\2\2\2\u00cf"+
		"\u00d0\7]\2\2\u00d0\22\3\2\2\2\u00d1\u00d2\7_\2\2\u00d2\24\3\2\2\2\u00d3"+
		"\u00d4\7>\2\2\u00d4\26\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6\30\3\2\2\2\u00d7"+
		"\u00d8\7>\2\2\u00d8\u00d9\7?\2\2\u00d9\32\3\2\2\2\u00da\u00db\7@\2\2\u00db"+
		"\u00dc\7?\2\2\u00dc\34\3\2\2\2\u00dd\u00de\7>\2\2\u00de\u00df\7>\2\2\u00df"+
		"\36\3\2\2\2\u00e0\u00e1\7@\2\2\u00e1\u00e2\7@\2\2\u00e2 \3\2\2\2\u00e3"+
		"\u00e4\7-\2\2\u00e4\"\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6$\3\2\2\2\u00e7"+
		"\u00e8\7,\2\2\u00e8&\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea(\3\2\2\2\u00eb"+
		"\u00ec\7\'\2\2\u00ec*\3\2\2\2\u00ed\u00ee\7^\2\2\u00ee,\3\2\2\2\u00ef"+
		"\u00f0\7(\2\2\u00f0.\3\2\2\2\u00f1\u00f2\7`\2\2\u00f2\60\3\2\2\2\u00f3"+
		"\u00f4\7#\2\2\u00f4\62\3\2\2\2\u00f5\u00f6\7A\2\2\u00f6\64\3\2\2\2\u00f7"+
		"\u00f8\7<\2\2\u00f8\66\3\2\2\2\u00f9\u00fa\7=\2\2\u00fa8\3\2\2\2\u00fb"+
		"\u00fc\7.\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7~\2\2\u00fe<\3\2\2\2\u00ff\u0100"+
		"\7~\2\2\u0100\u0101\7~\2\2\u0101>\3\2\2\2\u0102\u0103\7%\2\2\u0103@\3"+
		"\2\2\2\u0104\u0105\7B\2\2\u0105B\3\2\2\2\u0106\u0107\7?\2\2\u0107D\3\2"+
		"\2\2\u0108\u0109\7#\2\2\u0109\u010d\7?\2\2\u010a\u010b\7>\2\2\u010b\u010d"+
		"\7@\2\2\u010c\u0108\3\2\2\2\u010c\u010a\3\2\2\2\u010dF\3\2\2\2\u010e\u010f"+
		"\7\60\2\2\u010fH\3\2\2\2\u0110\u0111\7&\2\2\u0111J\3\2\2\2\u0112\u0113"+
		"\7>\2\2\u0113\u0114\7>\2\2\u0114\u0115\7Q\2\2\u0115\u0116\7X\2\2\u0116"+
		"\u0117\7G\2\2\u0117\u0118\7T\2\2\u0118\u0119\7U\2\2\u0119\u011a\7V\2\2"+
		"\u011a\u011b\7C\2\2\u011b\u011c\7E\2\2\u011c\u011d\7M\2\2\u011d\u011e"+
		"\7G\2\2\u011e\u011f\7F\2\2\u011f\u0120\7a\2\2\u0120\u0121\7C\2\2\u0121"+
		"\u0122\7T\2\2\u0122\u0123\7I\2\2\u0123\u0124\7U\2\2\u0124\u0125\7@\2\2"+
		"\u0125\u0126\7@\2\2\u0126L\3\2\2\2\u0127\u0128\7%\2\2\u0128\u0129\7P\2"+
		"\2\u0129\u012a\7Q\2\2\u012a\u012b\7a\2\2\u012b\u012c\7T\2\2\u012c\u012d"+
		"\7Q\2\2\u012d\u012e\7Y\2\2\u012e\u012f\7U\2\2\u012fN\3\2\2\2\u0130\u0131"+
		"\7%\2\2\u0131\u0132\7F\2\2\u0132\u0133\7W\2\2\u0133\u0134\7O\2\2\u0134"+
		"\u0135\7O\2\2\u0135\u0136\7[\2\2\u0136\u0137\7a\2\2\u0137\u0138\7C\2\2"+
		"\u0138\u0139\7T\2\2\u0139\u013a\7I\2\2\u013aP\3\2\2\2\u013b\u013c\7B\2"+
		"\2\u013c\u013d\7U\2\2\u013d\u013e\7w\2\2\u013e\u013f\7r\2\2\u013f\u0140"+
		"\7r\2\2\u0140\u0141\7t\2\2\u0141\u0142\7g\2\2\u0142\u0143\7u\2\2\u0143"+
		"\u0144\7u\2\2\u0144\u0145\7Y\2\2\u0145\u0146\7c\2\2\u0146\u0147\7t\2\2"+
		"\u0147\u0148\7p\2\2\u0148\u0149\7k\2\2\u0149\u014a\7p\2\2\u014a\u014b"+
		"\7i\2\2\u014b\u014c\7u\2\2\u014cR\3\2\2\2\u014d\u014e\5\u00afX\2\u014e"+
		"\u014f\5\u0091I\2\u014f\u0150\5\u008bF\2\u0150\u0151\5\u00a5S\2\u0151"+
		"\u0152\5\u008bF\2\u0152T\3\2\2\2\u0153\u0154\5\u0083B\2\u0154\u0155\5"+
		"\u009dO\2\u0155\u0156\5\u0089E\2\u0156V\3\2\2\2\u0157\u0158\5\u0099M\2"+
		"\u0158\u0159\5\u0093J\2\u0159\u015a\5\u0097L\2\u015a\u015b\5\u008bF\2"+
		"\u015bX\3\2\2\2\u015c\u015d\5\u009fP\2\u015d\u015e\5\u00a5S\2\u015eZ\3"+
		"\2\2\2\u015f\u0160\5\u0093J\2\u0160\u0161\5\u00a7T\2\u0161\\\3\2\2\2\u0162"+
		"\u0163\5\u009dO\2\u0163\u0164\5\u009fP\2\u0164\u0165\5\u00a9U\2\u0165"+
		"^\3\2\2\2\u0166\u0167\5\u009dO\2\u0167\u0168\5\u00abV\2\u0168\u0169\5"+
		"\u0099M\2\u0169\u016a\5\u0099M\2\u016a`\3\2\2\2\u016b\u016c\5\u0093J\2"+
		"\u016c\u016d\5\u008dG\2\u016db\3\2\2\2\u016e\u016f\5\u008bF\2\u016f\u0170"+
		"\5\u0099M\2\u0170\u0171\5\u00a7T\2\u0171\u0172\5\u008bF\2\u0172d\3\2\2"+
		"\2\u0173\u0174\5\u00a9U\2\u0174\u0175\5\u00a5S\2\u0175\u0176\5\u00b3Z"+
		"\2\u0176f\3\2\2\2\u0177\u0178\5\u0087D\2\u0178\u0179\5\u0083B\2\u0179"+
		"\u017a\5\u00a9U\2\u017a\u017b\5\u0087D\2\u017b\u017c\5\u0091I\2\u017c"+
		"h\3\2\2\2\u017d\u017e\5\u008dG\2\u017e\u017f\5\u0093J\2\u017f\u0180\5"+
		"\u009dO\2\u0180\u0181\5\u0083B\2\u0181\u0182\5\u0099M\2\u0182\u0183\5"+
		"\u0099M\2\u0183\u0184\5\u00b3Z\2\u0184j\3\2\2\2\u0185\u0186\5\u00a5S\2"+
		"\u0186\u0187\5\u008bF\2\u0187\u0188\5\u009bN\2\u0188\u0189\5\u009fP\2"+
		"\u0189\u018a\5\u00a9U\2\u018a\u018b\5\u008bF\2\u018bl\3\2\2\2\u018c\u018d"+
		"\5\u00a1Q\2\u018d\u018e\5\u0083B\2\u018e\u018f\5\u00a5S\2\u018f\u0190"+
		"\5\u0083B\2\u0190\u0191\5\u0099M\2\u0191\u0192\5\u0099M\2\u0192\u0193"+
		"\5\u008bF\2\u0193\u0194\5\u0099M\2\u0194n\3\2\2\2\u0195\u0196\5\u0093"+
		"J\2\u0196\u0197\5\u009dO\2\u0197\u0198\5\u00a1Q\2\u0198\u0199\5\u0083"+
		"B\2\u0199\u019a\5\u00a5S\2\u019a\u019b\5\u0083B\2\u019b\u019c\5\u0099"+
		"M\2\u019c\u019d\5\u0099M\2\u019d\u019e\5\u008bF\2\u019e\u019f\5\u0099"+
		"M\2\u019fp\3\2\2\2\u01a0\u01a1\5\u009fP\2\u01a1\u01a2\5\u009dO\2\u01a2"+
		"\u01a3\5\u00a7T\2\u01a3\u01a4\5\u00a9U\2\u01a4\u01a5\5\u0083B\2\u01a5"+
		"\u01a6\5\u0087D\2\u01a6\u01a7\5\u0097L\2\u01a7r\3\2\2\2\u01a8\u01a9\5"+
		"\u0097L\2\u01a9\u01aa\5\u008bF\2\u01aa\u01ab\5\u008bF\2\u01ab\u01ac\5"+
		"\u00a1Q\2\u01act\3\2\2\2\u01ad\u01af\5\u0081A\2\u01ae\u01ad\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b9\3\2"+
		"\2\2\u01b2\u01b6\7\60\2\2\u01b3\u01b5\5\u0081A\2\u01b4\u01b3\3\2\2\2\u01b5"+
		"\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01ba\3\2"+
		"\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01b2\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01c4\3\2\2\2\u01bb\u01bd\5\u008bF\2\u01bc\u01be\t\3\2\2\u01bd\u01bc"+
		"\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf\u01c1\5\u0081A"+
		"\2\u01c0\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3"+
		"\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01bb\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01d8\3\2\2\2\u01c6\u01c8\7\60\2\2\u01c7\u01c9\5\u0081A\2\u01c8\u01c7"+
		"\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01d5\3\2\2\2\u01cc\u01ce\5\u008bF\2\u01cd\u01cf\t\3\2\2\u01ce\u01cd"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01d2\5\u0081A"+
		"\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01cc\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d8\3\2\2\2\u01d7\u01ae\3\2\2\2\u01d7\u01c6\3\2\2\2\u01d8v\3\2\2\2"+
		"\u01d9\u01df\7)\2\2\u01da\u01de\n\4\2\2\u01db\u01dc\7)\2\2\u01dc\u01de"+
		"\7)\2\2\u01dd\u01da\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01e1\3\2\2\2\u01df"+
		"\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01df\3\2"+
		"\2\2\u01e2\u01ee\7)\2\2\u01e3\u01e9\7$\2\2\u01e4\u01e8\n\5\2\2\u01e5\u01e6"+
		"\7$\2\2\u01e6\u01e8\7$\2\2\u01e7\u01e4\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8"+
		"\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ee\7$\2\2\u01ed\u01d9\3\2\2\2\u01ed"+
		"\u01e3\3\2\2\2\u01eex\3\2\2\2\u01ef\u01f1\t\6\2\2\u01f0\u01ef\3\2\2\2"+
		"\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3z\3"+
		"\2\2\2\u01f4\u01f5\7\61\2\2\u01f5\u01f6\7,\2\2\u01f6\u01fa\3\2\2\2\u01f7"+
		"\u01f9\13\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa\u01fb\3"+
		"\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fd"+
		"\u01fe\7,\2\2\u01fe\u01ff\7\61\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\b>"+
		"\2\2\u0201|\3\2\2\2\u0202\u0204\t\7\2\2\u0203\u0202\3\2\2\2\u0204\u0205"+
		"\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0208\b?\2\2\u0208~\3\2\2\2\u0209\u020b\7\17\2\2\u020a\u020c\7\f\2\2"+
		"\u020b\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020f\3\2\2\2\u020d\u020f"+
		"\7\f\2\2\u020e\u0209\3\2\2\2\u020e\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0211\b@\2\2\u0211\u0080\3\2\2\2\u0212\u0213\t\b\2\2\u0213\u0082\3\2"+
		"\2\2\u0214\u0215\t\t\2\2\u0215\u0084\3\2\2\2\u0216\u0217\t\n\2\2\u0217"+
		"\u0086\3\2\2\2\u0218\u0219\t\13\2\2\u0219\u0088\3\2\2\2\u021a\u021b\t"+
		"\f\2\2\u021b\u008a\3\2\2\2\u021c\u021d\t\r\2\2\u021d\u008c\3\2\2\2\u021e"+
		"\u021f\t\16\2\2\u021f\u008e\3\2\2\2\u0220\u0221\t\17\2\2\u0221\u0090\3"+
		"\2\2\2\u0222\u0223\t\20\2\2\u0223\u0092\3\2\2\2\u0224\u0225\t\21\2\2\u0225"+
		"\u0094\3\2\2\2\u0226\u0227\t\22\2\2\u0227\u0096\3\2\2\2\u0228\u0229\t"+
		"\23\2\2\u0229\u0098\3\2\2\2\u022a\u022b\t\24\2\2\u022b\u009a\3\2\2\2\u022c"+
		"\u022d\t\25\2\2\u022d\u009c\3\2\2\2\u022e\u022f\t\26\2\2\u022f\u009e\3"+
		"\2\2\2\u0230\u0231\t\27\2\2\u0231\u00a0\3\2\2\2\u0232\u0233\t\30\2\2\u0233"+
		"\u00a2\3\2\2\2\u0234\u0235\t\31\2\2\u0235\u00a4\3\2\2\2\u0236\u0237\t"+
		"\32\2\2\u0237\u00a6\3\2\2\2\u0238\u0239\t\33\2\2\u0239\u00a8\3\2\2\2\u023a"+
		"\u023b\t\34\2\2\u023b\u00aa\3\2\2\2\u023c\u023d\t\35\2\2\u023d\u00ac\3"+
		"\2\2\2\u023e\u023f\t\36\2\2\u023f\u00ae\3\2\2\2\u0240\u0241\t\37\2\2\u0241"+
		"\u00b0\3\2\2\2\u0242\u0243\t \2\2\u0243\u00b2\3\2\2\2\u0244\u0245\t!\2"+
		"\2\u0245\u00b4\3\2\2\2\u0246\u0247\t\"\2\2\u0247\u00b6\3\2\2\2\33\2\u00c0"+
		"\u00c2\u010c\u01b0\u01b6\u01b9\u01bd\u01c2\u01c4\u01ca\u01ce\u01d3\u01d5"+
		"\u01d7\u01dd\u01df\u01e7\u01e9\u01ed\u01f2\u01fa\u0205\u020b\u020e\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}