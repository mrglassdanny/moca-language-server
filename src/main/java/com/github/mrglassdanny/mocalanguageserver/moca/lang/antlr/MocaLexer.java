// Generated from Moca.g4 by ANTLR 4.5.3

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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOUBLE_BRACKET_STRING=1, SINGLE_BRACKET_STRING=2, LEFT_PAREN=3, RIGHT_PAREN=4, 
		LEFT_BRACE=5, RIGHT_BRACE=6, LEFT_BRACKET=7, RIGHT_BRACKET=8, LESS=9, 
		GREATER=10, LESS_EQUAL=11, GREATER_EQUAL=12, DOUBLE_LESS=13, DOUBLE_GREATER=14, 
		PLUS=15, MINUS=16, STAR=17, DIV=18, MOD=19, BACKSLASH=20, AMPERSAND=21, 
		CARET=22, BANG=23, QUESTION=24, COLON=25, SEMI_COLON=26, COMMA=27, PIPE=28, 
		DOUBLE_PIPE=29, POUND=30, AT=31, EQUAL=32, NOT_EQUAL=33, DOT=34, OVERSTACKED_ARGS=35, 
		WHERE=36, AND=37, LIKE=38, OR=39, IS=40, NOT=41, NULL=42, IF=43, ELSE=44, 
		TRY=45, CATCH=46, FINALLY=47, REMOTE=48, PARALLEL=49, INPARALLEL=50, ONSTACK=51, 
		KEEP=52, NUMERIC_LITERAL=53, STRING_LITERAL=54, WORD=55, BLOCK_COMMENT=56, 
		WHITESPACE=57, NEWLINE=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", "LEFT_PAREN", "RIGHT_PAREN", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "LESS", 
		"GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
		"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
		"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
		"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "OVERSTACKED_ARGS", "WHERE", 
		"AND", "LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", 
		"FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", "ONSTACK", "KEEP", "NUMERIC_LITERAL", 
		"STRING_LITERAL", "WORD", "BLOCK_COMMENT", "WHITESPACE", "NEWLINE", "DIGIT", 
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'<'", "'>'", 
		"'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'\\'", 
		"'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", "'#'", 
		"'@'", "'='", null, "'.'", "'<<OVERSTACKED_ARGS>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", "LEFT_PAREN", 
		"RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", 
		"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
		"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
		"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
		"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "OVERSTACKED_ARGS", "WHERE", 
		"AND", "LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", 
		"FINALLY", "REMOTE", "PARALLEL", "INPARALLEL", "ONSTACK", "KEEP", "NUMERIC_LITERAL", 
		"STRING_LITERAL", "WORD", "BLOCK_COMMENT", "WHITESPACE", "NEWLINE"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u021a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\7\2\u00b1\n\2\f\2\16\2\u00b4\13\2\3\2\3\2\3\2"+
		"\3\3\3\3\7\3\u00bb\n\3\f\3\16\3\u00be\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3\"\3\"\5\"\u0107\n\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		"-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3"+
		"\66\6\66\u0181\n\66\r\66\16\66\u0182\3\66\3\66\7\66\u0187\n\66\f\66\16"+
		"\66\u018a\13\66\5\66\u018c\n\66\3\66\3\66\5\66\u0190\n\66\3\66\6\66\u0193"+
		"\n\66\r\66\16\66\u0194\5\66\u0197\n\66\3\66\3\66\6\66\u019b\n\66\r\66"+
		"\16\66\u019c\3\66\3\66\5\66\u01a1\n\66\3\66\6\66\u01a4\n\66\r\66\16\66"+
		"\u01a5\5\66\u01a8\n\66\5\66\u01aa\n\66\3\67\3\67\3\67\3\67\7\67\u01b0"+
		"\n\67\f\67\16\67\u01b3\13\67\3\67\3\67\3\67\3\67\3\67\7\67\u01ba\n\67"+
		"\f\67\16\67\u01bd\13\67\3\67\5\67\u01c0\n\67\38\68\u01c3\n8\r8\168\u01c4"+
		"\39\39\39\39\79\u01cb\n9\f9\169\u01ce\139\39\39\39\39\39\3:\6:\u01d6\n"+
		":\r:\16:\u01d7\3:\3:\3;\3;\5;\u01de\n;\3;\5;\u01e1\n;\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3"+
		"I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3"+
		"T\3U\3U\3V\3V\3\u01cc\2W\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085"+
		"\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097"+
		"\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9"+
		"\2\u00ab\2\3\2\"\4\2--//\3\2))\3\2$$\7\2\60\60\62;C\\aac|\4\2\13\13\""+
		"\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\u0216\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3\u00ad"+
		"\3\2\2\2\5\u00b8\3\2\2\2\7\u00c1\3\2\2\2\t\u00c3\3\2\2\2\13\u00c5\3\2"+
		"\2\2\r\u00c7\3\2\2\2\17\u00c9\3\2\2\2\21\u00cb\3\2\2\2\23\u00cd\3\2\2"+
		"\2\25\u00cf\3\2\2\2\27\u00d1\3\2\2\2\31\u00d4\3\2\2\2\33\u00d7\3\2\2\2"+
		"\35\u00da\3\2\2\2\37\u00dd\3\2\2\2!\u00df\3\2\2\2#\u00e1\3\2\2\2%\u00e3"+
		"\3\2\2\2\'\u00e5\3\2\2\2)\u00e7\3\2\2\2+\u00e9\3\2\2\2-\u00eb\3\2\2\2"+
		"/\u00ed\3\2\2\2\61\u00ef\3\2\2\2\63\u00f1\3\2\2\2\65\u00f3\3\2\2\2\67"+
		"\u00f5\3\2\2\29\u00f7\3\2\2\2;\u00f9\3\2\2\2=\u00fc\3\2\2\2?\u00fe\3\2"+
		"\2\2A\u0100\3\2\2\2C\u0106\3\2\2\2E\u0108\3\2\2\2G\u010a\3\2\2\2I\u011f"+
		"\3\2\2\2K\u0125\3\2\2\2M\u0129\3\2\2\2O\u012e\3\2\2\2Q\u0131\3\2\2\2S"+
		"\u0134\3\2\2\2U\u0138\3\2\2\2W\u013d\3\2\2\2Y\u0140\3\2\2\2[\u0145\3\2"+
		"\2\2]\u0149\3\2\2\2_\u014f\3\2\2\2a\u0157\3\2\2\2c\u015e\3\2\2\2e\u0167"+
		"\3\2\2\2g\u0172\3\2\2\2i\u017a\3\2\2\2k\u01a9\3\2\2\2m\u01bf\3\2\2\2o"+
		"\u01c2\3\2\2\2q\u01c6\3\2\2\2s\u01d5\3\2\2\2u\u01e0\3\2\2\2w\u01e4\3\2"+
		"\2\2y\u01e6\3\2\2\2{\u01e8\3\2\2\2}\u01ea\3\2\2\2\177\u01ec\3\2\2\2\u0081"+
		"\u01ee\3\2\2\2\u0083\u01f0\3\2\2\2\u0085\u01f2\3\2\2\2\u0087\u01f4\3\2"+
		"\2\2\u0089\u01f6\3\2\2\2\u008b\u01f8\3\2\2\2\u008d\u01fa\3\2\2\2\u008f"+
		"\u01fc\3\2\2\2\u0091\u01fe\3\2\2\2\u0093\u0200\3\2\2\2\u0095\u0202\3\2"+
		"\2\2\u0097\u0204\3\2\2\2\u0099\u0206\3\2\2\2\u009b\u0208\3\2\2\2\u009d"+
		"\u020a\3\2\2\2\u009f\u020c\3\2\2\2\u00a1\u020e\3\2\2\2\u00a3\u0210\3\2"+
		"\2\2\u00a5\u0212\3\2\2\2\u00a7\u0214\3\2\2\2\u00a9\u0216\3\2\2\2\u00ab"+
		"\u0218\3\2\2\2\u00ad\u00ae\5\17\b\2\u00ae\u00b2\5\17\b\2\u00af\u00b1\13"+
		"\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\5\21"+
		"\t\2\u00b6\u00b7\5\21\t\2\u00b7\4\3\2\2\2\u00b8\u00bc\5\17\b\2\u00b9\u00bb"+
		"\13\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0"+
		"\5\21\t\2\u00c0\6\3\2\2\2\u00c1\u00c2\7*\2\2\u00c2\b\3\2\2\2\u00c3\u00c4"+
		"\7+\2\2\u00c4\n\3\2\2\2\u00c5\u00c6\7}\2\2\u00c6\f\3\2\2\2\u00c7\u00c8"+
		"\7\177\2\2\u00c8\16\3\2\2\2\u00c9\u00ca\7]\2\2\u00ca\20\3\2\2\2\u00cb"+
		"\u00cc\7_\2\2\u00cc\22\3\2\2\2\u00cd\u00ce\7>\2\2\u00ce\24\3\2\2\2\u00cf"+
		"\u00d0\7@\2\2\u00d0\26\3\2\2\2\u00d1\u00d2\7>\2\2\u00d2\u00d3\7?\2\2\u00d3"+
		"\30\3\2\2\2\u00d4\u00d5\7@\2\2\u00d5\u00d6\7?\2\2\u00d6\32\3\2\2\2\u00d7"+
		"\u00d8\7>\2\2\u00d8\u00d9\7>\2\2\u00d9\34\3\2\2\2\u00da\u00db\7@\2\2\u00db"+
		"\u00dc\7@\2\2\u00dc\36\3\2\2\2\u00dd\u00de\7-\2\2\u00de \3\2\2\2\u00df"+
		"\u00e0\7/\2\2\u00e0\"\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2$\3\2\2\2\u00e3"+
		"\u00e4\7\61\2\2\u00e4&\3\2\2\2\u00e5\u00e6\7\'\2\2\u00e6(\3\2\2\2\u00e7"+
		"\u00e8\7^\2\2\u00e8*\3\2\2\2\u00e9\u00ea\7(\2\2\u00ea,\3\2\2\2\u00eb\u00ec"+
		"\7`\2\2\u00ec.\3\2\2\2\u00ed\u00ee\7#\2\2\u00ee\60\3\2\2\2\u00ef\u00f0"+
		"\7A\2\2\u00f0\62\3\2\2\2\u00f1\u00f2\7<\2\2\u00f2\64\3\2\2\2\u00f3\u00f4"+
		"\7=\2\2\u00f4\66\3\2\2\2\u00f5\u00f6\7.\2\2\u00f68\3\2\2\2\u00f7\u00f8"+
		"\7~\2\2\u00f8:\3\2\2\2\u00f9\u00fa\7~\2\2\u00fa\u00fb\7~\2\2\u00fb<\3"+
		"\2\2\2\u00fc\u00fd\7%\2\2\u00fd>\3\2\2\2\u00fe\u00ff\7B\2\2\u00ff@\3\2"+
		"\2\2\u0100\u0101\7?\2\2\u0101B\3\2\2\2\u0102\u0103\7#\2\2\u0103\u0107"+
		"\7?\2\2\u0104\u0105\7>\2\2\u0105\u0107\7@\2\2\u0106\u0102\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107D\3\2\2\2\u0108\u0109\7\60\2\2\u0109F\3\2\2\2\u010a"+
		"\u010b\7>\2\2\u010b\u010c\7>\2\2\u010c\u010d\7Q\2\2\u010d\u010e\7X\2\2"+
		"\u010e\u010f\7G\2\2\u010f\u0110\7T\2\2\u0110\u0111\7U\2\2\u0111\u0112"+
		"\7V\2\2\u0112\u0113\7C\2\2\u0113\u0114\7E\2\2\u0114\u0115\7M\2\2\u0115"+
		"\u0116\7G\2\2\u0116\u0117\7F\2\2\u0117\u0118\7a\2\2\u0118\u0119\7C\2\2"+
		"\u0119\u011a\7T\2\2\u011a\u011b\7I\2\2\u011b\u011c\7U\2\2\u011c\u011d"+
		"\7@\2\2\u011d\u011e\7@\2\2\u011eH\3\2\2\2\u011f\u0120\5\u00a5S\2\u0120"+
		"\u0121\5\u0087D\2\u0121\u0122\5\u0081A\2\u0122\u0123\5\u009bN\2\u0123"+
		"\u0124\5\u0081A\2\u0124J\3\2\2\2\u0125\u0126\5y=\2\u0126\u0127\5\u0093"+
		"J\2\u0127\u0128\5\177@\2\u0128L\3\2\2\2\u0129\u012a\5\u008fH\2\u012a\u012b"+
		"\5\u0089E\2\u012b\u012c\5\u008dG\2\u012c\u012d\5\u0081A\2\u012dN\3\2\2"+
		"\2\u012e\u012f\5\u0095K\2\u012f\u0130\5\u009bN\2\u0130P\3\2\2\2\u0131"+
		"\u0132\5\u0089E\2\u0132\u0133\5\u009dO\2\u0133R\3\2\2\2\u0134\u0135\5"+
		"\u0093J\2\u0135\u0136\5\u0095K\2\u0136\u0137\5\u009fP\2\u0137T\3\2\2\2"+
		"\u0138\u0139\5\u0093J\2\u0139\u013a\5\u00a1Q\2\u013a\u013b\5\u008fH\2"+
		"\u013b\u013c\5\u008fH\2\u013cV\3\2\2\2\u013d\u013e\5\u0089E\2\u013e\u013f"+
		"\5\u0083B\2\u013fX\3\2\2\2\u0140\u0141\5\u0081A\2\u0141\u0142\5\u008f"+
		"H\2\u0142\u0143\5\u009dO\2\u0143\u0144\5\u0081A\2\u0144Z\3\2\2\2\u0145"+
		"\u0146\5\u009fP\2\u0146\u0147\5\u009bN\2\u0147\u0148\5\u00a9U\2\u0148"+
		"\\\3\2\2\2\u0149\u014a\5}?\2\u014a\u014b\5y=\2\u014b\u014c\5\u009fP\2"+
		"\u014c\u014d\5}?\2\u014d\u014e\5\u0087D\2\u014e^\3\2\2\2\u014f\u0150\5"+
		"\u0083B\2\u0150\u0151\5\u0089E\2\u0151\u0152\5\u0093J\2\u0152\u0153\5"+
		"y=\2\u0153\u0154\5\u008fH\2\u0154\u0155\5\u008fH\2\u0155\u0156\5\u00a9"+
		"U\2\u0156`\3\2\2\2\u0157\u0158\5\u009bN\2\u0158\u0159\5\u0081A\2\u0159"+
		"\u015a\5\u0091I\2\u015a\u015b\5\u0095K\2\u015b\u015c\5\u009fP\2\u015c"+
		"\u015d\5\u0081A\2\u015db\3\2\2\2\u015e\u015f\5\u0097L\2\u015f\u0160\5"+
		"y=\2\u0160\u0161\5\u009bN\2\u0161\u0162\5y=\2\u0162\u0163\5\u008fH\2\u0163"+
		"\u0164\5\u008fH\2\u0164\u0165\5\u0081A\2\u0165\u0166\5\u008fH\2\u0166"+
		"d\3\2\2\2\u0167\u0168\5\u0089E\2\u0168\u0169\5\u0093J\2\u0169\u016a\5"+
		"\u0097L\2\u016a\u016b\5y=\2\u016b\u016c\5\u009bN\2\u016c\u016d\5y=\2\u016d"+
		"\u016e\5\u008fH\2\u016e\u016f\5\u008fH\2\u016f\u0170\5\u0081A\2\u0170"+
		"\u0171\5\u008fH\2\u0171f\3\2\2\2\u0172\u0173\5\u0095K\2\u0173\u0174\5"+
		"\u0093J\2\u0174\u0175\5\u009dO\2\u0175\u0176\5\u009fP\2\u0176\u0177\5"+
		"y=\2\u0177\u0178\5}?\2\u0178\u0179\5\u008dG\2\u0179h\3\2\2\2\u017a\u017b"+
		"\5\u008dG\2\u017b\u017c\5\u0081A\2\u017c\u017d\5\u0081A\2\u017d\u017e"+
		"\5\u0097L\2\u017ej\3\2\2\2\u017f\u0181\5w<\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u018b\3\2"+
		"\2\2\u0184\u0188\7\60\2\2\u0185\u0187\5w<\2\u0186\u0185\3\2\2\2\u0187"+
		"\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018c\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018b\u0184\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u0196\3\2\2\2\u018d\u018f\5\u0081A\2\u018e\u0190\t\2\2\2\u018f\u018e"+
		"\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\5w<\2\u0192"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0197\3\2\2\2\u0196\u018d\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u01aa\3\2\2\2\u0198\u019a\7\60\2\2\u0199\u019b\5w<\2\u019a\u0199\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u01a7\3\2\2\2\u019e\u01a0\5\u0081A\2\u019f\u01a1\t\2\2\2\u01a0\u019f"+
		"\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a4\5w<\2\u01a3"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a8\3\2\2\2\u01a7\u019e\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01aa\3\2\2\2\u01a9\u0180\3\2\2\2\u01a9\u0198\3\2\2\2\u01aal\3\2\2\2"+
		"\u01ab\u01b1\7)\2\2\u01ac\u01b0\n\3\2\2\u01ad\u01ae\7)\2\2\u01ae\u01b0"+
		"\7)\2\2\u01af\u01ac\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1"+
		"\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b4\u01c0\7)\2\2\u01b5\u01bb\7$\2\2\u01b6\u01ba\n\4\2\2\u01b7\u01b8"+
		"\7$\2\2\u01b8\u01ba\7$\2\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba"+
		"\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2"+
		"\2\2\u01bd\u01bb\3\2\2\2\u01be\u01c0\7$\2\2\u01bf\u01ab\3\2\2\2\u01bf"+
		"\u01b5\3\2\2\2\u01c0n\3\2\2\2\u01c1\u01c3\t\5\2\2\u01c2\u01c1\3\2\2\2"+
		"\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5p\3"+
		"\2\2\2\u01c6\u01c7\7\61\2\2\u01c7\u01c8\7,\2\2\u01c8\u01cc\3\2\2\2\u01c9"+
		"\u01cb\13\2\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01cd\3"+
		"\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf"+
		"\u01d0\7,\2\2\u01d0\u01d1\7\61\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\b9"+
		"\2\2\u01d3r\3\2\2\2\u01d4\u01d6\t\6\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\b:\2\2\u01dat\3\2\2\2\u01db\u01dd\7\17\2\2\u01dc\u01de\7\f\2\2"+
		"\u01dd\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01e1"+
		"\7\f\2\2\u01e0\u01db\3\2\2\2\u01e0\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e3\b;\2\2\u01e3v\3\2\2\2\u01e4\u01e5\t\7\2\2\u01e5x\3\2\2\2\u01e6"+
		"\u01e7\t\b\2\2\u01e7z\3\2\2\2\u01e8\u01e9\t\t\2\2\u01e9|\3\2\2\2\u01ea"+
		"\u01eb\t\n\2\2\u01eb~\3\2\2\2\u01ec\u01ed\t\13\2\2\u01ed\u0080\3\2\2\2"+
		"\u01ee\u01ef\t\f\2\2\u01ef\u0082\3\2\2\2\u01f0\u01f1\t\r\2\2\u01f1\u0084"+
		"\3\2\2\2\u01f2\u01f3\t\16\2\2\u01f3\u0086\3\2\2\2\u01f4\u01f5\t\17\2\2"+
		"\u01f5\u0088\3\2\2\2\u01f6\u01f7\t\20\2\2\u01f7\u008a\3\2\2\2\u01f8\u01f9"+
		"\t\21\2\2\u01f9\u008c\3\2\2\2\u01fa\u01fb\t\22\2\2\u01fb\u008e\3\2\2\2"+
		"\u01fc\u01fd\t\23\2\2\u01fd\u0090\3\2\2\2\u01fe\u01ff\t\24\2\2\u01ff\u0092"+
		"\3\2\2\2\u0200\u0201\t\25\2\2\u0201\u0094\3\2\2\2\u0202\u0203\t\26\2\2"+
		"\u0203\u0096\3\2\2\2\u0204\u0205\t\27\2\2\u0205\u0098\3\2\2\2\u0206\u0207"+
		"\t\30\2\2\u0207\u009a\3\2\2\2\u0208\u0209\t\31\2\2\u0209\u009c\3\2\2\2"+
		"\u020a\u020b\t\32\2\2\u020b\u009e\3\2\2\2\u020c\u020d\t\33\2\2\u020d\u00a0"+
		"\3\2\2\2\u020e\u020f\t\34\2\2\u020f\u00a2\3\2\2\2\u0210\u0211\t\35\2\2"+
		"\u0211\u00a4\3\2\2\2\u0212\u0213\t\36\2\2\u0213\u00a6\3\2\2\2\u0214\u0215"+
		"\t\37\2\2\u0215\u00a8\3\2\2\2\u0216\u0217\t \2\2\u0217\u00aa\3\2\2\2\u0218"+
		"\u0219\t!\2\2\u0219\u00ac\3\2\2\2\33\2\u00b2\u00bc\u0106\u0182\u0188\u018b"+
		"\u018f\u0194\u0196\u019c\u01a0\u01a5\u01a7\u01a9\u01af\u01b1\u01b9\u01bb"+
		"\u01bf\u01c4\u01cc\u01d7\u01dd\u01e0\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}