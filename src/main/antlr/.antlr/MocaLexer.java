// Generated from c:\dev\moca-language-server\src\main\antlr\Moca.g4 by ANTLR 4.8

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
		T__0=1, T__1=2, LEFT_PAREN=3, RIGHT_PAREN=4, LEFT_BRACE=5, RIGHT_BRACE=6, 
		LESS=7, GREATER=8, LESS_EQUAL=9, GREATER_EQUAL=10, DOUBLE_LESS=11, DOUBLE_GREATER=12, 
		PLUS=13, MINUS=14, STAR=15, DIV=16, MOD=17, BACKSLASH=18, AMPERSAND=19, 
		CARET=20, BANG=21, QUESTION=22, COLON=23, SEMI_COLON=24, COMMA=25, PIPE=26, 
		DOUBLE_PIPE=27, POUND=28, AT=29, EQUAL=30, NOT_EQUAL=31, DOT=32, DOUBLE_BRACKET_STRING=33, 
		SINGLE_BRACKET_STRING=34, MOCA_INTEGRATOR_OVERSTACKED_ARGS=35, WHERE=36, 
		AND=37, LIKE=38, OR=39, IS=40, NOT=41, NULL=42, IF=43, ELSE=44, TRY=45, 
		CATCH=46, FINALLY=47, REMOTE=48, PARALLEL=49, INPARALLEL=50, WORD=51, 
		NUMERIC_LITERAL=52, STRING_LITERAL=53, BLOCK_COMMENT=54, WHITESPACE=55, 
		NEWLINE=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
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
			null, "'keep'", "'onstack'", "'('", "')'", "'{'", "'}'", "'<'", "'>'", 
			"'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'\\'", 
			"'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", "'#'", 
			"'@'", "'='", null, "'.'", null, null, "'<<OVERSTACKED_ARGS>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u0215\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3"+
		" \5 \u00f8\n \3!\3!\3\"\3\"\3\"\3\"\7\"\u0100\n\"\f\"\16\"\u0103\13\""+
		"\3\"\3\"\3\"\3#\3#\7#\u010a\n#\f#\16#\u010d\13#\3#\3#\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+"+
		"\3+\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\64\3\64\7\64\u017b\n\64\f\64\16\64\u017e\13"+
		"\64\3\65\6\65\u0181\n\65\r\65\16\65\u0182\3\65\3\65\7\65\u0187\n\65\f"+
		"\65\16\65\u018a\13\65\5\65\u018c\n\65\3\65\3\65\5\65\u0190\n\65\3\65\6"+
		"\65\u0193\n\65\r\65\16\65\u0194\5\65\u0197\n\65\3\65\3\65\6\65\u019b\n"+
		"\65\r\65\16\65\u019c\3\65\3\65\5\65\u01a1\n\65\3\65\6\65\u01a4\n\65\r"+
		"\65\16\65\u01a5\5\65\u01a8\n\65\5\65\u01aa\n\65\3\66\3\66\3\66\3\66\7"+
		"\66\u01b0\n\66\f\66\16\66\u01b3\13\66\3\66\3\66\3\66\3\66\3\66\7\66\u01ba"+
		"\n\66\f\66\16\66\u01bd\13\66\3\66\5\66\u01c0\n\66\3\67\3\67\3\67\3\67"+
		"\7\67\u01c6\n\67\f\67\16\67\u01c9\13\67\3\67\3\67\3\67\3\67\3\67\38\6"+
		"8\u01d1\n8\r8\168\u01d2\38\38\39\39\59\u01d9\n9\39\59\u01dc\n9\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3"+
		"E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3"+
		"Q\3Q\3R\3R\3S\3S\3T\3T\5\u0101\u010b\u01c7\2U\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s\2u\2w\2y\2{\2}\2\177"+
		"\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091"+
		"\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3"+
		"\2\u00a5\2\u00a7\2\3\2#\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\3\2$$"+
		"\4\2\13\13\"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHh"+
		"h\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2"+
		"QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\2\u0211\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3\u00a9\3\2\2"+
		"\2\5\u00ae\3\2\2\2\7\u00b6\3\2\2\2\t\u00b8\3\2\2\2\13\u00ba\3\2\2\2\r"+
		"\u00bc\3\2\2\2\17\u00be\3\2\2\2\21\u00c0\3\2\2\2\23\u00c2\3\2\2\2\25\u00c5"+
		"\3\2\2\2\27\u00c8\3\2\2\2\31\u00cb\3\2\2\2\33\u00ce\3\2\2\2\35\u00d0\3"+
		"\2\2\2\37\u00d2\3\2\2\2!\u00d4\3\2\2\2#\u00d6\3\2\2\2%\u00d8\3\2\2\2\'"+
		"\u00da\3\2\2\2)\u00dc\3\2\2\2+\u00de\3\2\2\2-\u00e0\3\2\2\2/\u00e2\3\2"+
		"\2\2\61\u00e4\3\2\2\2\63\u00e6\3\2\2\2\65\u00e8\3\2\2\2\67\u00ea\3\2\2"+
		"\29\u00ed\3\2\2\2;\u00ef\3\2\2\2=\u00f1\3\2\2\2?\u00f7\3\2\2\2A\u00f9"+
		"\3\2\2\2C\u00fb\3\2\2\2E\u0107\3\2\2\2G\u0110\3\2\2\2I\u0125\3\2\2\2K"+
		"\u012b\3\2\2\2M\u012f\3\2\2\2O\u0134\3\2\2\2Q\u0137\3\2\2\2S\u013a\3\2"+
		"\2\2U\u013e\3\2\2\2W\u0143\3\2\2\2Y\u0146\3\2\2\2[\u014b\3\2\2\2]\u014f"+
		"\3\2\2\2_\u0155\3\2\2\2a\u015d\3\2\2\2c\u0164\3\2\2\2e\u016d\3\2\2\2g"+
		"\u0178\3\2\2\2i\u01a9\3\2\2\2k\u01bf\3\2\2\2m\u01c1\3\2\2\2o\u01d0\3\2"+
		"\2\2q\u01db\3\2\2\2s\u01df\3\2\2\2u\u01e1\3\2\2\2w\u01e3\3\2\2\2y\u01e5"+
		"\3\2\2\2{\u01e7\3\2\2\2}\u01e9\3\2\2\2\177\u01eb\3\2\2\2\u0081\u01ed\3"+
		"\2\2\2\u0083\u01ef\3\2\2\2\u0085\u01f1\3\2\2\2\u0087\u01f3\3\2\2\2\u0089"+
		"\u01f5\3\2\2\2\u008b\u01f7\3\2\2\2\u008d\u01f9\3\2\2\2\u008f\u01fb\3\2"+
		"\2\2\u0091\u01fd\3\2\2\2\u0093\u01ff\3\2\2\2\u0095\u0201\3\2\2\2\u0097"+
		"\u0203\3\2\2\2\u0099\u0205\3\2\2\2\u009b\u0207\3\2\2\2\u009d\u0209\3\2"+
		"\2\2\u009f\u020b\3\2\2\2\u00a1\u020d\3\2\2\2\u00a3\u020f\3\2\2\2\u00a5"+
		"\u0211\3\2\2\2\u00a7\u0213\3\2\2\2\u00a9\u00aa\7m\2\2\u00aa\u00ab\7g\2"+
		"\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7r\2\2\u00ad\4\3\2\2\2\u00ae\u00af\7"+
		"q\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7m\2\2\u00b5\6\3\2\2\2\u00b6\u00b7"+
		"\7*\2\2\u00b7\b\3\2\2\2\u00b8\u00b9\7+\2\2\u00b9\n\3\2\2\2\u00ba\u00bb"+
		"\7}\2\2\u00bb\f\3\2\2\2\u00bc\u00bd\7\177\2\2\u00bd\16\3\2\2\2\u00be\u00bf"+
		"\7>\2\2\u00bf\20\3\2\2\2\u00c0\u00c1\7@\2\2\u00c1\22\3\2\2\2\u00c2\u00c3"+
		"\7>\2\2\u00c3\u00c4\7?\2\2\u00c4\24\3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7\26\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca\7>\2\2\u00ca\30"+
		"\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc\u00cd\7@\2\2\u00cd\32\3\2\2\2\u00ce"+
		"\u00cf\7-\2\2\u00cf\34\3\2\2\2\u00d0\u00d1\7/\2\2\u00d1\36\3\2\2\2\u00d2"+
		"\u00d3\7,\2\2\u00d3 \3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5\"\3\2\2\2\u00d6"+
		"\u00d7\7\'\2\2\u00d7$\3\2\2\2\u00d8\u00d9\7^\2\2\u00d9&\3\2\2\2\u00da"+
		"\u00db\7(\2\2\u00db(\3\2\2\2\u00dc\u00dd\7`\2\2\u00dd*\3\2\2\2\u00de\u00df"+
		"\7#\2\2\u00df,\3\2\2\2\u00e0\u00e1\7A\2\2\u00e1.\3\2\2\2\u00e2\u00e3\7"+
		"<\2\2\u00e3\60\3\2\2\2\u00e4\u00e5\7=\2\2\u00e5\62\3\2\2\2\u00e6\u00e7"+
		"\7.\2\2\u00e7\64\3\2\2\2\u00e8\u00e9\7~\2\2\u00e9\66\3\2\2\2\u00ea\u00eb"+
		"\7~\2\2\u00eb\u00ec\7~\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7%\2\2\u00ee:\3"+
		"\2\2\2\u00ef\u00f0\7B\2\2\u00f0<\3\2\2\2\u00f1\u00f2\7?\2\2\u00f2>\3\2"+
		"\2\2\u00f3\u00f4\7#\2\2\u00f4\u00f8\7?\2\2\u00f5\u00f6\7>\2\2\u00f6\u00f8"+
		"\7@\2\2\u00f7\u00f3\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8@\3\2\2\2\u00f9\u00fa"+
		"\7\60\2\2\u00faB\3\2\2\2\u00fb\u00fc\7]\2\2\u00fc\u00fd\7]\2\2\u00fd\u0101"+
		"\3\2\2\2\u00fe\u0100\13\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2"+
		"\u0101\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0104\u0105\7_\2\2\u0105\u0106\7_\2\2\u0106D\3\2\2\2\u0107\u010b"+
		"\7]\2\2\u0108\u010a\13\2\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010e\u010f\7_\2\2\u010fF\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112"+
		"\7>\2\2\u0112\u0113\7Q\2\2\u0113\u0114\7X\2\2\u0114\u0115\7G\2\2\u0115"+
		"\u0116\7T\2\2\u0116\u0117\7U\2\2\u0117\u0118\7V\2\2\u0118\u0119\7C\2\2"+
		"\u0119\u011a\7E\2\2\u011a\u011b\7M\2\2\u011b\u011c\7G\2\2\u011c\u011d"+
		"\7F\2\2\u011d\u011e\7a\2\2\u011e\u011f\7C\2\2\u011f\u0120\7T\2\2\u0120"+
		"\u0121\7I\2\2\u0121\u0122\7U\2\2\u0122\u0123\7@\2\2\u0123\u0124\7@\2\2"+
		"\u0124H\3\2\2\2\u0125\u0126\5\u00a1Q\2\u0126\u0127\5\u0083B\2\u0127\u0128"+
		"\5}?\2\u0128\u0129\5\u0097L\2\u0129\u012a\5}?\2\u012aJ\3\2\2\2\u012b\u012c"+
		"\5u;\2\u012c\u012d\5\u008fH\2\u012d\u012e\5{>\2\u012eL\3\2\2\2\u012f\u0130"+
		"\5\u008bF\2\u0130\u0131\5\u0085C\2\u0131\u0132\5\u0089E\2\u0132\u0133"+
		"\5}?\2\u0133N\3\2\2\2\u0134\u0135\5\u0091I\2\u0135\u0136\5\u0097L\2\u0136"+
		"P\3\2\2\2\u0137\u0138\5\u0085C\2\u0138\u0139\5\u0099M\2\u0139R\3\2\2\2"+
		"\u013a\u013b\5\u008fH\2\u013b\u013c\5\u0091I\2\u013c\u013d\5\u009bN\2"+
		"\u013dT\3\2\2\2\u013e\u013f\5\u008fH\2\u013f\u0140\5\u009dO\2\u0140\u0141"+
		"\5\u008bF\2\u0141\u0142\5\u008bF\2\u0142V\3\2\2\2\u0143\u0144\5\u0085"+
		"C\2\u0144\u0145\5\177@\2\u0145X\3\2\2\2\u0146\u0147\5}?\2\u0147\u0148"+
		"\5\u008bF\2\u0148\u0149\5\u0099M\2\u0149\u014a\5}?\2\u014aZ\3\2\2\2\u014b"+
		"\u014c\5\u009bN\2\u014c\u014d\5\u0097L\2\u014d\u014e\5\u00a5S\2\u014e"+
		"\\\3\2\2\2\u014f\u0150\5y=\2\u0150\u0151\5u;\2\u0151\u0152\5\u009bN\2"+
		"\u0152\u0153\5y=\2\u0153\u0154\5\u0083B\2\u0154^\3\2\2\2\u0155\u0156\5"+
		"\177@\2\u0156\u0157\5\u0085C\2\u0157\u0158\5\u008fH\2\u0158\u0159\5u;"+
		"\2\u0159\u015a\5\u008bF\2\u015a\u015b\5\u008bF\2\u015b\u015c\5\u00a5S"+
		"\2\u015c`\3\2\2\2\u015d\u015e\5\u0097L\2\u015e\u015f\5}?\2\u015f\u0160"+
		"\5\u008dG\2\u0160\u0161\5\u0091I\2\u0161\u0162\5\u009bN\2\u0162\u0163"+
		"\5}?\2\u0163b\3\2\2\2\u0164\u0165\5\u0093J\2\u0165\u0166\5u;\2\u0166\u0167"+
		"\5\u0097L\2\u0167\u0168\5u;\2\u0168\u0169\5\u008bF\2\u0169\u016a\5\u008b"+
		"F\2\u016a\u016b\5}?\2\u016b\u016c\5\u008bF\2\u016cd\3\2\2\2\u016d\u016e"+
		"\5\u0085C\2\u016e\u016f\5\u008fH\2\u016f\u0170\5\u0093J\2\u0170\u0171"+
		"\5u;\2\u0171\u0172\5\u0097L\2\u0172\u0173\5u;\2\u0173\u0174\5\u008bF\2"+
		"\u0174\u0175\5\u008bF\2\u0175\u0176\5}?\2\u0176\u0177\5\u008bF\2\u0177"+
		"f\3\2\2\2\u0178\u017c\t\2\2\2\u0179\u017b\t\3\2\2\u017a\u0179\3\2\2\2"+
		"\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017dh\3"+
		"\2\2\2\u017e\u017c\3\2\2\2\u017f\u0181\5s:\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u018b\3\2"+
		"\2\2\u0184\u0188\7\60\2\2\u0185\u0187\5s:\2\u0186\u0185\3\2\2\2\u0187"+
		"\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018c\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018b\u0184\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u0196\3\2\2\2\u018d\u018f\5}?\2\u018e\u0190\t\4\2\2\u018f\u018e\3\2\2"+
		"\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\5s:\2\u0192\u0191"+
		"\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u018d\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u01aa\3\2"+
		"\2\2\u0198\u019a\7\60\2\2\u0199\u019b\5s:\2\u019a\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a7\3\2"+
		"\2\2\u019e\u01a0\5}?\2\u019f\u01a1\t\4\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a4\5s:\2\u01a3\u01a2\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2"+
		"\2\2\u01a7\u019e\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u0180\3\2\2\2\u01a9\u0198\3\2\2\2\u01aaj\3\2\2\2\u01ab\u01b1\7)\2\2\u01ac"+
		"\u01b0\n\5\2\2\u01ad\u01ae\7)\2\2\u01ae\u01b0\7)\2\2\u01af\u01ac\3\2\2"+
		"\2\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2"+
		"\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01c0\7)\2\2\u01b5"+
		"\u01bb\7$\2\2\u01b6\u01ba\n\6\2\2\u01b7\u01b8\7$\2\2\u01b8\u01ba\7$\2"+
		"\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01c0\7$\2\2\u01bf\u01ab\3\2\2\2\u01bf\u01b5\3\2\2\2\u01c0l\3\2\2\2\u01c1"+
		"\u01c2\7\61\2\2\u01c2\u01c3\7,\2\2\u01c3\u01c7\3\2\2\2\u01c4\u01c6\13"+
		"\2\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cb\7,"+
		"\2\2\u01cb\u01cc\7\61\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\b\67\2\2\u01ce"+
		"n\3\2\2\2\u01cf\u01d1\t\7\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2"+
		"\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5"+
		"\b8\2\2\u01d5p\3\2\2\2\u01d6\u01d8\7\17\2\2\u01d7\u01d9\7\f\2\2\u01d8"+
		"\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01dc\7\f"+
		"\2\2\u01db\u01d6\3\2\2\2\u01db\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd"+
		"\u01de\b9\2\2\u01der\3\2\2\2\u01df\u01e0\t\b\2\2\u01e0t\3\2\2\2\u01e1"+
		"\u01e2\t\t\2\2\u01e2v\3\2\2\2\u01e3\u01e4\t\n\2\2\u01e4x\3\2\2\2\u01e5"+
		"\u01e6\t\13\2\2\u01e6z\3\2\2\2\u01e7\u01e8\t\f\2\2\u01e8|\3\2\2\2\u01e9"+
		"\u01ea\t\r\2\2\u01ea~\3\2\2\2\u01eb\u01ec\t\16\2\2\u01ec\u0080\3\2\2\2"+
		"\u01ed\u01ee\t\17\2\2\u01ee\u0082\3\2\2\2\u01ef\u01f0\t\20\2\2\u01f0\u0084"+
		"\3\2\2\2\u01f1\u01f2\t\21\2\2\u01f2\u0086\3\2\2\2\u01f3\u01f4\t\22\2\2"+
		"\u01f4\u0088\3\2\2\2\u01f5\u01f6\t\23\2\2\u01f6\u008a\3\2\2\2\u01f7\u01f8"+
		"\t\24\2\2\u01f8\u008c\3\2\2\2\u01f9\u01fa\t\25\2\2\u01fa\u008e\3\2\2\2"+
		"\u01fb\u01fc\t\26\2\2\u01fc\u0090\3\2\2\2\u01fd\u01fe\t\27\2\2\u01fe\u0092"+
		"\3\2\2\2\u01ff\u0200\t\30\2\2\u0200\u0094\3\2\2\2\u0201\u0202\t\31\2\2"+
		"\u0202\u0096\3\2\2\2\u0203\u0204\t\32\2\2\u0204\u0098\3\2\2\2\u0205\u0206"+
		"\t\33\2\2\u0206\u009a\3\2\2\2\u0207\u0208\t\34\2\2\u0208\u009c\3\2\2\2"+
		"\u0209\u020a\t\35\2\2\u020a\u009e\3\2\2\2\u020b\u020c\t\36\2\2\u020c\u00a0"+
		"\3\2\2\2\u020d\u020e\t\37\2\2\u020e\u00a2\3\2\2\2\u020f\u0210\t \2\2\u0210"+
		"\u00a4\3\2\2\2\u0211\u0212\t!\2\2\u0212\u00a6\3\2\2\2\u0213\u0214\t\""+
		"\2\2\u0214\u00a8\3\2\2\2\33\2\u00f7\u0101\u010b\u017c\u0182\u0188\u018b"+
		"\u018f\u0194\u0196\u019c\u01a0\u01a5\u01a7\u01a9\u01af\u01b1\u01b9\u01bb"+
		"\u01bf\u01c7\u01d2\u01d8\u01db\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}