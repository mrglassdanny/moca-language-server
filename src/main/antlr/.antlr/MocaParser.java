// Generated from c:\dev\moca-language-server\src\main\antlr\Moca.g4 by ANTLR 4.8

		package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MocaParser extends Parser {
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
	public static final int
		RULE_moca_script = 0, RULE_sequence = 1, RULE_stream = 2, RULE_group = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_command = 6, RULE_verb_noun_clause = 7, 
		RULE_verb_noun_clause_args = 8, RULE_verb_noun_clause_arg = 9, RULE_sub_sequence = 10, 
		RULE_if_expr = 11, RULE_if_statement = 12, RULE_else_if_statement = 13, 
		RULE_else_statement = 14, RULE_try_block = 15, RULE_catch_single_expr = 16, 
		RULE_catch_multi_expr = 17, RULE_catch_sequence = 18, RULE_finally_sequence = 19, 
		RULE_moca_redirect_expr = 20, RULE_moca_remote_expr = 21, RULE_expr = 22, 
		RULE_function_expr = 23, RULE_literal_value = 24, RULE_moca_variable = 25, 
		RULE_moca_plus_variable = 26, RULE_moca_at_variable = 27, RULE_moca_environment_variable = 28, 
		RULE_moca_at_minus_variable = 29, RULE_moca_at_plus_variable = 30, RULE_moca_at_mod_variable = 31, 
		RULE_moca_at_star = 32, RULE_moca_at_question = 33, RULE_moca_at_bang = 34, 
		RULE_moca_keep_directive = 35, RULE_moca_at_keep_directive = 36, RULE_moca_at_minus_keep_directive = 37, 
		RULE_moca_at_plus_keep_directive = 38, RULE_moca_at_mod_keep_directive = 39, 
		RULE_moca_onstack_directive = 40, RULE_moca_ignore_directive = 41, RULE_moca_oldvar_directive = 42, 
		RULE_moca_at_plus_oldvar_directive = 43, RULE_moca_at_mod_oldvar_directive = 44, 
		RULE_moca_type_cast_variable = 45, RULE_moca_database_qualifier_variable = 46, 
		RULE_moca_integration_variable = 47, RULE_moca_remote_keyword = 48, RULE_sql_script = 49, 
		RULE_groovy_script = 50;
	private static String[] makeRuleNames() {
		return new String[] {
			"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
			"verb_noun_clause", "verb_noun_clause_args", "verb_noun_clause_arg", 
			"sub_sequence", "if_expr", "if_statement", "else_if_statement", "else_statement", 
			"try_block", "catch_single_expr", "catch_multi_expr", "catch_sequence", 
			"finally_sequence", "moca_redirect_expr", "moca_remote_expr", "expr", 
			"function_expr", "literal_value", "moca_variable", "moca_plus_variable", 
			"moca_at_variable", "moca_environment_variable", "moca_at_minus_variable", 
			"moca_at_plus_variable", "moca_at_mod_variable", "moca_at_star", "moca_at_question", 
			"moca_at_bang", "moca_keep_directive", "moca_at_keep_directive", "moca_at_minus_keep_directive", 
			"moca_at_plus_keep_directive", "moca_at_mod_keep_directive", "moca_onstack_directive", 
			"moca_ignore_directive", "moca_oldvar_directive", "moca_at_plus_oldvar_directive", 
			"moca_at_mod_oldvar_directive", "moca_type_cast_variable", "moca_database_qualifier_variable", 
			"moca_integration_variable", "moca_remote_keyword", "sql_script", "groovy_script"
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

	@Override
	public String getGrammarFileName() { return "Moca.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MocaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Moca_scriptContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MocaParser.EOF, 0); }
		public Moca_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_script; }
	}

	public final Moca_scriptContext moca_script() throws RecognitionException {
		Moca_scriptContext _localctx = new Moca_scriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_moca_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			sequence();
			setState(103);
			match(EOF);
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

	public static class SequenceContext extends ParserRuleContext {
		public List<StreamContext> stream() {
			return getRuleContexts(StreamContext.class);
		}
		public StreamContext stream(int i) {
			return getRuleContext(StreamContext.class,i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(MocaParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(MocaParser.SEMI_COLON, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			stream();
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(106);
					match(SEMI_COLON);
					setState(107);
					stream();
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(113);
				match(SEMI_COLON);
				}
			}

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

	public static class StreamContext extends ParserRuleContext {
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(MocaParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MocaParser.PIPE, i);
		}
		public StreamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stream; }
	}

	public final StreamContext stream() throws RecognitionException {
		StreamContext _localctx = new StreamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stream);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			group();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(117);
				match(PIPE);
				setState(118);
				group();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class GroupContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(MocaParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(MocaParser.AMPERSAND, i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			statement();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(125);
				match(AMPERSAND);
				setState(126);
				statement();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Try_blockContext try_block() {
			return getRuleContext(Try_blockContext.class,0);
		}
		public Catch_multi_exprContext catch_multi_expr() {
			return getRuleContext(Catch_multi_exprContext.class,0);
		}
		public Moca_redirect_exprContext moca_redirect_expr() {
			return getRuleContext(Moca_redirect_exprContext.class,0);
		}
		public List<Else_if_statementContext> else_if_statement() {
			return getRuleContexts(Else_if_statementContext.class);
		}
		public Else_if_statementContext else_if_statement(int i) {
			return getRuleContext(Else_if_statementContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public List<Catch_sequenceContext> catch_sequence() {
			return getRuleContexts(Catch_sequenceContext.class);
		}
		public Catch_sequenceContext catch_sequence(int i) {
			return getRuleContext(Catch_sequenceContext.class,i);
		}
		public Finally_sequenceContext finally_sequence() {
			return getRuleContext(Finally_sequenceContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(132);
				block();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(133);
					catch_multi_expr();
					}
				}

				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(136);
					moca_redirect_expr();
					}
				}

				}
				break;
			case 2:
				{
				setState(139);
				if_statement();
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(140);
						else_if_statement();
						}
						} 
					}
					setState(145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(146);
					else_statement();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(149);
				try_block();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(150);
					catch_sequence();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(156);
					finally_sequence();
					}
				}

				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(159);
					moca_redirect_expr();
					}
				}

				}
				break;
			}
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

	public static class BlockContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public Sub_sequenceContext sub_sequence() {
			return getRuleContext(Sub_sequenceContext.class,0);
		}
		public Moca_remote_exprContext moca_remote_expr() {
			return getRuleContext(Moca_remote_exprContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL))) != 0)) {
					{
					setState(165);
					moca_remote_expr();
					}
				}

				setState(168);
				sub_sequence();
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

	public static class CommandContext extends ParserRuleContext {
		public Sql_scriptContext sql_script() {
			return getRuleContext(Sql_scriptContext.class,0);
		}
		public Groovy_scriptContext groovy_script() {
			return getRuleContext(Groovy_scriptContext.class,0);
		}
		public Verb_noun_clauseContext verb_noun_clause() {
			return getRuleContext(Verb_noun_clauseContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				sql_script();
				}
				break;
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				groovy_script();
				}
				break;
			case CARET:
			case AND:
			case LIKE:
			case OR:
			case IS:
			case NOT:
			case NULL:
			case IF:
			case ELSE:
			case TRY:
			case CATCH:
			case FINALLY:
			case REMOTE:
			case PARALLEL:
			case INPARALLEL:
			case WORD:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				verb_noun_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Verb_noun_clauseContext extends ParserRuleContext {
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public TerminalNode WHERE() { return getToken(MocaParser.WHERE, 0); }
		public Verb_noun_clause_argsContext verb_noun_clause_args() {
			return getRuleContext(Verb_noun_clause_argsContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(MocaParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MocaParser.WORD, i);
		}
		public List<TerminalNode> AND() { return getTokens(MocaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MocaParser.AND, i);
		}
		public List<TerminalNode> LIKE() { return getTokens(MocaParser.LIKE); }
		public TerminalNode LIKE(int i) {
			return getToken(MocaParser.LIKE, i);
		}
		public List<TerminalNode> OR() { return getTokens(MocaParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MocaParser.OR, i);
		}
		public List<TerminalNode> IS() { return getTokens(MocaParser.IS); }
		public TerminalNode IS(int i) {
			return getToken(MocaParser.IS, i);
		}
		public List<TerminalNode> NOT() { return getTokens(MocaParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(MocaParser.NOT, i);
		}
		public List<TerminalNode> NULL() { return getTokens(MocaParser.NULL); }
		public TerminalNode NULL(int i) {
			return getToken(MocaParser.NULL, i);
		}
		public List<TerminalNode> IF() { return getTokens(MocaParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(MocaParser.IF, i);
		}
		public List<TerminalNode> ELSE() { return getTokens(MocaParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(MocaParser.ELSE, i);
		}
		public List<TerminalNode> TRY() { return getTokens(MocaParser.TRY); }
		public TerminalNode TRY(int i) {
			return getToken(MocaParser.TRY, i);
		}
		public List<TerminalNode> CATCH() { return getTokens(MocaParser.CATCH); }
		public TerminalNode CATCH(int i) {
			return getToken(MocaParser.CATCH, i);
		}
		public List<TerminalNode> FINALLY() { return getTokens(MocaParser.FINALLY); }
		public TerminalNode FINALLY(int i) {
			return getToken(MocaParser.FINALLY, i);
		}
		public List<TerminalNode> REMOTE() { return getTokens(MocaParser.REMOTE); }
		public TerminalNode REMOTE(int i) {
			return getToken(MocaParser.REMOTE, i);
		}
		public List<TerminalNode> PARALLEL() { return getTokens(MocaParser.PARALLEL); }
		public TerminalNode PARALLEL(int i) {
			return getToken(MocaParser.PARALLEL, i);
		}
		public List<TerminalNode> INPARALLEL() { return getTokens(MocaParser.INPARALLEL); }
		public TerminalNode INPARALLEL(int i) {
			return getToken(MocaParser.INPARALLEL, i);
		}
		public Verb_noun_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause; }
	}

	public final Verb_noun_clauseContext verb_noun_clause() throws RecognitionException {
		Verb_noun_clauseContext _localctx = new Verb_noun_clauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_verb_noun_clause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(176);
				match(CARET);
				}
			}

			setState(180); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(179);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(182); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(184);
				match(WHERE);
				setState(185);
				verb_noun_clause_args();
				}
			}

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

	public static class Verb_noun_clause_argsContext extends ParserRuleContext {
		public List<Verb_noun_clause_argContext> verb_noun_clause_arg() {
			return getRuleContexts(Verb_noun_clause_argContext.class);
		}
		public Verb_noun_clause_argContext verb_noun_clause_arg(int i) {
			return getRuleContext(Verb_noun_clause_argContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MocaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MocaParser.AND, i);
		}
		public Verb_noun_clause_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause_args; }
	}

	public final Verb_noun_clause_argsContext verb_noun_clause_args() throws RecognitionException {
		Verb_noun_clause_argsContext _localctx = new Verb_noun_clause_argsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_verb_noun_clause_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			verb_noun_clause_arg();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(189);
				match(AND);
				setState(190);
				verb_noun_clause_arg();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class Verb_noun_clause_argContext extends ParserRuleContext {
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public TerminalNode MOCA_INTEGRATOR_OVERSTACKED_ARGS() { return getToken(MocaParser.MOCA_INTEGRATOR_OVERSTACKED_ARGS, 0); }
		public Moca_at_starContext moca_at_star() {
			return getRuleContext(Moca_at_starContext.class,0);
		}
		public Moca_plus_variableContext moca_plus_variable() {
			return getRuleContext(Moca_plus_variableContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(MocaParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MocaParser.WORD, i);
		}
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(MocaParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MocaParser.STRING_LITERAL, 0); }
		public Moca_variableContext moca_variable() {
			return getRuleContext(Moca_variableContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public TerminalNode IS() { return getToken(MocaParser.IS, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(MocaParser.NOT, 0); }
		public TerminalNode EQUAL() { return getToken(MocaParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(MocaParser.NOT_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(MocaParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(MocaParser.GREATER, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(MocaParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(MocaParser.GREATER_EQUAL, 0); }
		public TerminalNode LIKE() { return getToken(MocaParser.LIKE, 0); }
		public Verb_noun_clause_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause_arg; }
	}

	public final Verb_noun_clause_argContext verb_noun_clause_arg() throws RecognitionException {
		Verb_noun_clause_argContext _localctx = new Verb_noun_clause_argContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_verb_noun_clause_arg);
		try {
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case MOCA_INTEGRATOR_OVERSTACKED_ARGS:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(MOCA_INTEGRATOR_OVERSTACKED_ARGS);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(198);
					moca_at_star();
					}
					break;
				case 2:
					{
					setState(199);
					moca_plus_variable();
					}
					break;
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(202);
				match(WORD);
				setState(217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(203);
					match(IS);
					setState(204);
					match(NULL);
					}
					break;
				case 2:
					{
					setState(205);
					match(IS);
					setState(206);
					match(NOT);
					setState(207);
					match(NULL);
					}
					break;
				case 3:
					{
					setState(208);
					match(EQUAL);
					}
					break;
				case 4:
					{
					setState(209);
					match(NOT_EQUAL);
					}
					break;
				case 5:
					{
					setState(210);
					match(LESS);
					}
					break;
				case 6:
					{
					setState(211);
					match(GREATER);
					}
					break;
				case 7:
					{
					setState(212);
					match(LESS_EQUAL);
					}
					break;
				case 8:
					{
					setState(213);
					match(GREATER_EQUAL);
					}
					break;
				case 9:
					{
					setState(214);
					match(LIKE);
					}
					break;
				case 10:
					{
					setState(215);
					match(NOT);
					setState(216);
					match(LIKE);
					}
					break;
				}
				}
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(219);
					match(MINUS);
					setState(220);
					match(NUMERIC_LITERAL);
					}
					break;
				case 2:
					{
					setState(221);
					match(NUMERIC_LITERAL);
					}
					break;
				case 3:
					{
					setState(222);
					match(STRING_LITERAL);
					}
					break;
				case 4:
					{
					setState(223);
					match(WORD);
					}
					break;
				case 5:
					{
					setState(224);
					moca_variable();
					}
					break;
				case 6:
					{
					setState(225);
					function_expr();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Sub_sequenceContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(MocaParser.LEFT_BRACE, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(MocaParser.RIGHT_BRACE, 0); }
		public Sub_sequenceContext sub_sequence() {
			return getRuleContext(Sub_sequenceContext.class,0);
		}
		public Sub_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_sequence; }
	}

	public final Sub_sequenceContext sub_sequence() throws RecognitionException {
		Sub_sequenceContext _localctx = new Sub_sequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sub_sequence);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(LEFT_BRACE);
				setState(231);
				sequence();
				setState(232);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(LEFT_BRACE);
				setState(235);
				sub_sequence();
				setState(236);
				match(RIGHT_BRACE);
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

	public static class If_exprContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MocaParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(IF);
			setState(241);
			match(LEFT_PAREN);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << WORD) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				{
				setState(242);
				expr(0);
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(RIGHT_PAREN);
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

	public static class If_statementContext extends ParserRuleContext {
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			if_expr();
			setState(251);
			statement();
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

	public static class Else_if_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MocaParser.ELSE, 0); }
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Else_if_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if_statement; }
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(ELSE);
			setState(254);
			if_statement();
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

	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MocaParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ELSE);
			setState(257);
			statement();
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

	public static class Try_blockContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(MocaParser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Try_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_block; }
	}

	public final Try_blockContext try_block() throws RecognitionException {
		Try_blockContext _localctx = new Try_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(TRY);
			setState(260);
			block();
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

	public static class Catch_single_exprContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(MocaParser.CATCH, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public Moca_at_questionContext moca_at_question() {
			return getRuleContext(Moca_at_questionContext.class,0);
		}
		public Moca_at_bangContext moca_at_bang() {
			return getRuleContext(Moca_at_bangContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_variableContext moca_variable() {
			return getRuleContext(Moca_variableContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public Catch_single_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_single_expr; }
	}

	public final Catch_single_exprContext catch_single_expr() throws RecognitionException {
		Catch_single_exprContext _localctx = new Catch_single_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_catch_single_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(CATCH);
			setState(263);
			match(LEFT_PAREN);
			{
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(264);
				literal_value();
				}
				break;
			case 2:
				{
				setState(265);
				moca_at_question();
				}
				break;
			case 3:
				{
				setState(266);
				moca_at_bang();
				}
				break;
			case 4:
				{
				setState(267);
				match(WORD);
				}
				break;
			case 5:
				{
				setState(268);
				moca_variable();
				}
				break;
			case 6:
				{
				setState(269);
				function_expr();
				}
				break;
			}
			}
			setState(272);
			match(RIGHT_PAREN);
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

	public static class Catch_multi_exprContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(MocaParser.CATCH, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public List<Literal_valueContext> literal_value() {
			return getRuleContexts(Literal_valueContext.class);
		}
		public Literal_valueContext literal_value(int i) {
			return getRuleContext(Literal_valueContext.class,i);
		}
		public List<Moca_at_questionContext> moca_at_question() {
			return getRuleContexts(Moca_at_questionContext.class);
		}
		public Moca_at_questionContext moca_at_question(int i) {
			return getRuleContext(Moca_at_questionContext.class,i);
		}
		public List<Moca_at_bangContext> moca_at_bang() {
			return getRuleContexts(Moca_at_bangContext.class);
		}
		public Moca_at_bangContext moca_at_bang(int i) {
			return getRuleContext(Moca_at_bangContext.class,i);
		}
		public List<TerminalNode> WORD() { return getTokens(MocaParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MocaParser.WORD, i);
		}
		public List<Moca_variableContext> moca_variable() {
			return getRuleContexts(Moca_variableContext.class);
		}
		public Moca_variableContext moca_variable(int i) {
			return getRuleContext(Moca_variableContext.class,i);
		}
		public List<Function_exprContext> function_expr() {
			return getRuleContexts(Function_exprContext.class);
		}
		public Function_exprContext function_expr(int i) {
			return getRuleContext(Function_exprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MocaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MocaParser.COMMA, i);
		}
		public Catch_multi_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_multi_expr; }
	}

	public final Catch_multi_exprContext catch_multi_expr() throws RecognitionException {
		Catch_multi_exprContext _localctx = new Catch_multi_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_catch_multi_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(CATCH);
			setState(275);
			match(LEFT_PAREN);
			{
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(276);
				literal_value();
				}
				break;
			case 2:
				{
				setState(277);
				moca_at_question();
				}
				break;
			case 3:
				{
				setState(278);
				moca_at_bang();
				}
				break;
			case 4:
				{
				setState(279);
				match(WORD);
				}
				break;
			case 5:
				{
				setState(280);
				moca_variable();
				}
				break;
			case 6:
				{
				setState(281);
				function_expr();
				}
				break;
			}
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(284);
				match(COMMA);
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(285);
					literal_value();
					}
					break;
				case 2:
					{
					setState(286);
					moca_at_question();
					}
					break;
				case 3:
					{
					setState(287);
					moca_at_bang();
					}
					break;
				case 4:
					{
					setState(288);
					match(WORD);
					}
					break;
				case 5:
					{
					setState(289);
					moca_variable();
					}
					break;
				case 6:
					{
					setState(290);
					function_expr();
					}
					break;
				}
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(298);
			match(RIGHT_PAREN);
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

	public static class Catch_sequenceContext extends ParserRuleContext {
		public Catch_single_exprContext catch_single_expr() {
			return getRuleContext(Catch_single_exprContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(MocaParser.LEFT_BRACE, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(MocaParser.RIGHT_BRACE, 0); }
		public Catch_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_sequence; }
	}

	public final Catch_sequenceContext catch_sequence() throws RecognitionException {
		Catch_sequenceContext _localctx = new Catch_sequenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_catch_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			catch_single_expr();
			setState(301);
			match(LEFT_BRACE);
			setState(302);
			sequence();
			setState(303);
			match(RIGHT_BRACE);
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

	public static class Finally_sequenceContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(MocaParser.FINALLY, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(MocaParser.LEFT_BRACE, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(MocaParser.RIGHT_BRACE, 0); }
		public Finally_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_sequence; }
	}

	public final Finally_sequenceContext finally_sequence() throws RecognitionException {
		Finally_sequenceContext _localctx = new Finally_sequenceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_finally_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(FINALLY);
			setState(306);
			match(LEFT_BRACE);
			setState(307);
			sequence();
			setState(308);
			match(RIGHT_BRACE);
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

	public static class Moca_redirect_exprContext extends ParserRuleContext {
		public TerminalNode DOUBLE_GREATER() { return getToken(MocaParser.DOUBLE_GREATER, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_redirect_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_redirect_expr; }
	}

	public final Moca_redirect_exprContext moca_redirect_expr() throws RecognitionException {
		Moca_redirect_exprContext _localctx = new Moca_redirect_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_moca_redirect_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(DOUBLE_GREATER);
			setState(311);
			match(WORD);
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

	public static class Moca_remote_exprContext extends ParserRuleContext {
		public Moca_remote_keywordContext moca_remote_keyword() {
			return getRuleContext(Moca_remote_keywordContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_variableContext moca_variable() {
			return getRuleContext(Moca_variableContext.class,0);
		}
		public Moca_remote_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_remote_expr; }
	}

	public final Moca_remote_exprContext moca_remote_expr() throws RecognitionException {
		Moca_remote_exprContext _localctx = new Moca_remote_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_moca_remote_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			moca_remote_keyword();
			setState(314);
			match(LEFT_PAREN);
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NULL:
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
				{
				setState(315);
				literal_value();
				}
				break;
			case WORD:
				{
				setState(316);
				match(WORD);
				}
				break;
			case COLON:
			case AT:
				{
				setState(317);
				moca_variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(320);
			match(RIGHT_PAREN);
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

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_variableContext moca_variable() {
			return getRuleContext(Moca_variableContext.class,0);
		}
		public Moca_at_bangContext moca_at_bang() {
			return getRuleContext(Moca_at_bangContext.class,0);
		}
		public Moca_at_questionContext moca_at_question() {
			return getRuleContext(Moca_at_questionContext.class,0);
		}
		public Moca_at_starContext moca_at_star() {
			return getRuleContext(Moca_at_starContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public TerminalNode DOUBLE_PIPE() { return getToken(MocaParser.DOUBLE_PIPE, 0); }
		public TerminalNode STAR() { return getToken(MocaParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(MocaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MocaParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(MocaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode LESS() { return getToken(MocaParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(MocaParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(MocaParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(MocaParser.GREATER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(MocaParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(MocaParser.NOT_EQUAL, 0); }
		public TerminalNode IS() { return getToken(MocaParser.IS, 0); }
		public TerminalNode NOT() { return getToken(MocaParser.NOT, 0); }
		public TerminalNode LIKE() { return getToken(MocaParser.LIKE, 0); }
		public TerminalNode AND() { return getToken(MocaParser.AND, 0); }
		public TerminalNode OR() { return getToken(MocaParser.OR, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(323);
				literal_value();
				}
				break;
			case 2:
				{
				setState(324);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(325);
				moca_variable();
				}
				break;
			case 4:
				{
				setState(326);
				moca_at_bang();
				}
				break;
			case 5:
				{
				setState(327);
				moca_at_question();
				}
				break;
			case 6:
				{
				setState(328);
				moca_at_star();
				}
				break;
			case 7:
				{
				setState(329);
				function_expr();
				}
				break;
			case 8:
				{
				{
				setState(330);
				match(BANG);
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(331);
					literal_value();
					}
					break;
				case 2:
					{
					setState(332);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(333);
					moca_variable();
					}
					break;
				case 4:
					{
					setState(334);
					moca_at_bang();
					}
					break;
				case 5:
					{
					setState(335);
					moca_at_question();
					}
					break;
				case 6:
					{
					setState(336);
					moca_at_star();
					}
					break;
				case 7:
					{
					setState(337);
					function_expr();
					}
					break;
				}
				}
				}
				break;
			case 9:
				{
				setState(340);
				match(LEFT_PAREN);
				setState(341);
				expr(0);
				setState(342);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(395);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(393);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(346);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(347);
						match(DOUBLE_PIPE);
						setState(348);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(349);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(350);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(351);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(352);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(353);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(354);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(355);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(356);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(357);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(358);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(365);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(359);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(360);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(361);
							match(IS);
							}
							break;
						case 4:
							{
							setState(362);
							match(IS);
							setState(363);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(364);
							match(LIKE);
							}
							break;
						}
						setState(367);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(368);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(369);
						match(AND);
						setState(370);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(371);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(372);
						match(OR);
						setState(373);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(374);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(376);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(375);
							match(NOT);
							}
						}

						{
						setState(378);
						match(LIKE);
						}
						setState(379);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(380);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(381);
						match(IS);
						setState(383);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(382);
							match(NOT);
							}
						}

						setState(385);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(386);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(391);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(387);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(388);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(389);
							match(NOT);
							setState(390);
							match(NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(397);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_exprContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MocaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MocaParser.COMMA, i);
		}
		public Function_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_expr; }
	}

	public final Function_exprContext function_expr() throws RecognitionException {
		Function_exprContext _localctx = new Function_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(WORD);
			setState(399);
			match(LEFT_PAREN);
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << WORD) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(400);
				expr(0);
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(401);
					match(COMMA);
					setState(402);
					expr(0);
					}
					}
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(410);
			match(RIGHT_PAREN);
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

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(MocaParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MocaParser.STRING_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal_value);
		try {
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				match(MINUS);
				setState(413);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(416);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Moca_variableContext extends ParserRuleContext {
		public Moca_at_variableContext moca_at_variable() {
			return getRuleContext(Moca_at_variableContext.class,0);
		}
		public Moca_at_minus_variableContext moca_at_minus_variable() {
			return getRuleContext(Moca_at_minus_variableContext.class,0);
		}
		public Moca_environment_variableContext moca_environment_variable() {
			return getRuleContext(Moca_environment_variableContext.class,0);
		}
		public Moca_keep_directiveContext moca_keep_directive() {
			return getRuleContext(Moca_keep_directiveContext.class,0);
		}
		public Moca_onstack_directiveContext moca_onstack_directive() {
			return getRuleContext(Moca_onstack_directiveContext.class,0);
		}
		public Moca_type_cast_variableContext moca_type_cast_variable() {
			return getRuleContext(Moca_type_cast_variableContext.class,0);
		}
		public Moca_integration_variableContext moca_integration_variable() {
			return getRuleContext(Moca_integration_variableContext.class,0);
		}
		public Moca_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_variable; }
	}

	public final Moca_variableContext moca_variable() throws RecognitionException {
		Moca_variableContext _localctx = new Moca_variableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_moca_variable);
		try {
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				moca_at_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				moca_at_minus_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(421);
				moca_environment_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				moca_keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(423);
				moca_onstack_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				moca_type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(425);
				moca_integration_variable();
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

	public static class Moca_plus_variableContext extends ParserRuleContext {
		public Moca_at_plus_variableContext moca_at_plus_variable() {
			return getRuleContext(Moca_at_plus_variableContext.class,0);
		}
		public Moca_at_mod_variableContext moca_at_mod_variable() {
			return getRuleContext(Moca_at_mod_variableContext.class,0);
		}
		public Moca_oldvar_directiveContext moca_oldvar_directive() {
			return getRuleContext(Moca_oldvar_directiveContext.class,0);
		}
		public Moca_database_qualifier_variableContext moca_database_qualifier_variable() {
			return getRuleContext(Moca_database_qualifier_variableContext.class,0);
		}
		public Moca_plus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_plus_variable; }
	}

	public final Moca_plus_variableContext moca_plus_variable() throws RecognitionException {
		Moca_plus_variableContext _localctx = new Moca_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_moca_plus_variable);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				moca_at_plus_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				moca_at_mod_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				moca_oldvar_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(431);
				moca_database_qualifier_variable();
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

	public static class Moca_at_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_variable; }
	}

	public final Moca_at_variableContext moca_at_variable() throws RecognitionException {
		Moca_at_variableContext _localctx = new Moca_at_variableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_moca_at_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(AT);
			setState(435);
			match(WORD);
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

	public static class Moca_environment_variableContext extends ParserRuleContext {
		public List<TerminalNode> AT() { return getTokens(MocaParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(MocaParser.AT, i);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_environment_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_environment_variable; }
	}

	public final Moca_environment_variableContext moca_environment_variable() throws RecognitionException {
		Moca_environment_variableContext _localctx = new Moca_environment_variableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_moca_environment_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(AT);
			setState(438);
			match(AT);
			setState(439);
			match(WORD);
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

	public static class Moca_at_minus_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_minus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_minus_variable; }
	}

	public final Moca_at_minus_variableContext moca_at_minus_variable() throws RecognitionException {
		Moca_at_minus_variableContext _localctx = new Moca_at_minus_variableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_moca_at_minus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(AT);
			setState(442);
			match(MINUS);
			setState(443);
			match(WORD);
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

	public static class Moca_at_plus_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode PLUS() { return getToken(MocaParser.PLUS, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_plus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_plus_variable; }
	}

	public final Moca_at_plus_variableContext moca_at_plus_variable() throws RecognitionException {
		Moca_at_plus_variableContext _localctx = new Moca_at_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_moca_at_plus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(AT);
			setState(446);
			match(PLUS);
			setState(447);
			match(WORD);
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

	public static class Moca_at_mod_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode MOD() { return getToken(MocaParser.MOD, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_mod_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_mod_variable; }
	}

	public final Moca_at_mod_variableContext moca_at_mod_variable() throws RecognitionException {
		Moca_at_mod_variableContext _localctx = new Moca_at_mod_variableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_moca_at_mod_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(AT);
			setState(450);
			match(MOD);
			setState(451);
			match(WORD);
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

	public static class Moca_at_starContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode STAR() { return getToken(MocaParser.STAR, 0); }
		public Moca_at_starContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_star; }
	}

	public final Moca_at_starContext moca_at_star() throws RecognitionException {
		Moca_at_starContext _localctx = new Moca_at_starContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_moca_at_star);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(AT);
			setState(454);
			match(STAR);
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

	public static class Moca_at_questionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode QUESTION() { return getToken(MocaParser.QUESTION, 0); }
		public Moca_at_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_question; }
	}

	public final Moca_at_questionContext moca_at_question() throws RecognitionException {
		Moca_at_questionContext _localctx = new Moca_at_questionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_moca_at_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(AT);
			setState(457);
			match(QUESTION);
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

	public static class Moca_at_bangContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public Moca_at_bangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_bang; }
	}

	public final Moca_at_bangContext moca_at_bang() throws RecognitionException {
		Moca_at_bangContext _localctx = new Moca_at_bangContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_moca_at_bang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(AT);
			setState(460);
			match(BANG);
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

	public static class Moca_keep_directiveContext extends ParserRuleContext {
		public Moca_at_keep_directiveContext moca_at_keep_directive() {
			return getRuleContext(Moca_at_keep_directiveContext.class,0);
		}
		public Moca_at_minus_keep_directiveContext moca_at_minus_keep_directive() {
			return getRuleContext(Moca_at_minus_keep_directiveContext.class,0);
		}
		public Moca_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_keep_directive; }
	}

	public final Moca_keep_directiveContext moca_keep_directive() throws RecognitionException {
		Moca_keep_directiveContext _localctx = new Moca_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_moca_keep_directive);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				moca_at_keep_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				moca_at_minus_keep_directive();
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

	public static class Moca_at_keep_directiveContext extends ParserRuleContext {
		public Moca_at_variableContext moca_at_variable() {
			return getRuleContext(Moca_at_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_at_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_keep_directive; }
	}

	public final Moca_at_keep_directiveContext moca_at_keep_directive() throws RecognitionException {
		Moca_at_keep_directiveContext _localctx = new Moca_at_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_moca_at_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			moca_at_variable();
			setState(467);
			match(POUND);
			setState(468);
			match(T__0);
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

	public static class Moca_at_minus_keep_directiveContext extends ParserRuleContext {
		public Moca_at_minus_variableContext moca_at_minus_variable() {
			return getRuleContext(Moca_at_minus_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_at_minus_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_minus_keep_directive; }
	}

	public final Moca_at_minus_keep_directiveContext moca_at_minus_keep_directive() throws RecognitionException {
		Moca_at_minus_keep_directiveContext _localctx = new Moca_at_minus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_moca_at_minus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			moca_at_minus_variable();
			setState(471);
			match(POUND);
			setState(472);
			match(T__0);
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

	public static class Moca_at_plus_keep_directiveContext extends ParserRuleContext {
		public Moca_at_plus_variableContext moca_at_plus_variable() {
			return getRuleContext(Moca_at_plus_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_at_plus_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_plus_keep_directive; }
	}

	public final Moca_at_plus_keep_directiveContext moca_at_plus_keep_directive() throws RecognitionException {
		Moca_at_plus_keep_directiveContext _localctx = new Moca_at_plus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_moca_at_plus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			moca_at_plus_variable();
			setState(475);
			match(POUND);
			setState(476);
			match(T__0);
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

	public static class Moca_at_mod_keep_directiveContext extends ParserRuleContext {
		public Moca_at_mod_variableContext moca_at_mod_variable() {
			return getRuleContext(Moca_at_mod_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_at_mod_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_mod_keep_directive; }
	}

	public final Moca_at_mod_keep_directiveContext moca_at_mod_keep_directive() throws RecognitionException {
		Moca_at_mod_keep_directiveContext _localctx = new Moca_at_mod_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_moca_at_mod_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			moca_at_mod_variable();
			setState(479);
			match(POUND);
			setState(480);
			match(T__0);
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

	public static class Moca_onstack_directiveContext extends ParserRuleContext {
		public Moca_at_variableContext moca_at_variable() {
			return getRuleContext(Moca_at_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_onstack_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_onstack_directive; }
	}

	public final Moca_onstack_directiveContext moca_onstack_directive() throws RecognitionException {
		Moca_onstack_directiveContext _localctx = new Moca_onstack_directiveContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_moca_onstack_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			moca_at_variable();
			setState(483);
			match(POUND);
			setState(484);
			match(T__1);
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

	public static class Moca_ignore_directiveContext extends ParserRuleContext {
		public Moca_at_variableContext moca_at_variable() {
			return getRuleContext(Moca_at_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public Moca_ignore_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_ignore_directive; }
	}

	public final Moca_ignore_directiveContext moca_ignore_directive() throws RecognitionException {
		Moca_ignore_directiveContext _localctx = new Moca_ignore_directiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_moca_ignore_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			moca_at_variable();
			setState(487);
			match(POUND);
			setState(488);
			match(T__2);
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

	public static class Moca_oldvar_directiveContext extends ParserRuleContext {
		public Moca_at_plus_oldvar_directiveContext moca_at_plus_oldvar_directive() {
			return getRuleContext(Moca_at_plus_oldvar_directiveContext.class,0);
		}
		public Moca_at_mod_oldvar_directiveContext moca_at_mod_oldvar_directive() {
			return getRuleContext(Moca_at_mod_oldvar_directiveContext.class,0);
		}
		public Moca_oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_oldvar_directive; }
	}

	public final Moca_oldvar_directiveContext moca_oldvar_directive() throws RecognitionException {
		Moca_oldvar_directiveContext _localctx = new Moca_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_moca_oldvar_directive);
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(490);
				moca_at_plus_oldvar_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				moca_at_mod_oldvar_directive();
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

	public static class Moca_at_plus_oldvar_directiveContext extends ParserRuleContext {
		public Moca_at_plus_variableContext moca_at_plus_variable() {
			return getRuleContext(Moca_at_plus_variableContext.class,0);
		}
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_plus_oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_plus_oldvar_directive; }
	}

	public final Moca_at_plus_oldvar_directiveContext moca_at_plus_oldvar_directive() throws RecognitionException {
		Moca_at_plus_oldvar_directiveContext _localctx = new Moca_at_plus_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_moca_at_plus_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			moca_at_plus_variable();
			setState(495);
			match(CARET);
			setState(496);
			match(WORD);
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

	public static class Moca_at_mod_oldvar_directiveContext extends ParserRuleContext {
		public Moca_at_mod_variableContext moca_at_mod_variable() {
			return getRuleContext(Moca_at_mod_variableContext.class,0);
		}
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_mod_oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_at_mod_oldvar_directive; }
	}

	public final Moca_at_mod_oldvar_directiveContext moca_at_mod_oldvar_directive() throws RecognitionException {
		Moca_at_mod_oldvar_directiveContext _localctx = new Moca_at_mod_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_moca_at_mod_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			moca_at_mod_variable();
			setState(499);
			match(CARET);
			setState(500);
			match(WORD);
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

	public static class Moca_type_cast_variableContext extends ParserRuleContext {
		public Moca_at_variableContext moca_at_variable() {
			return getRuleContext(Moca_at_variableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_at_plus_variableContext moca_at_plus_variable() {
			return getRuleContext(Moca_at_plus_variableContext.class,0);
		}
		public Moca_type_cast_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_type_cast_variable; }
	}

	public final Moca_type_cast_variableContext moca_type_cast_variable() throws RecognitionException {
		Moca_type_cast_variableContext _localctx = new Moca_type_cast_variableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_moca_type_cast_variable);
		try {
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(502);
				moca_at_variable();
				setState(503);
				match(COLON);
				setState(504);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(506);
				moca_at_plus_variable();
				setState(507);
				match(COLON);
				setState(508);
				match(WORD);
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

	public static class Moca_database_qualifier_variableContext extends ParserRuleContext {
		public Moca_at_plus_variableContext moca_at_plus_variable() {
			return getRuleContext(Moca_at_plus_variableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MocaParser.DOT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_database_qualifier_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_database_qualifier_variable; }
	}

	public final Moca_database_qualifier_variableContext moca_database_qualifier_variable() throws RecognitionException {
		Moca_database_qualifier_variableContext _localctx = new Moca_database_qualifier_variableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_moca_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			moca_at_plus_variable();
			setState(513);
			match(DOT);
			setState(514);
			match(WORD);
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

	public static class Moca_integration_variableContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Moca_integration_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_integration_variable; }
	}

	public final Moca_integration_variableContext moca_integration_variable() throws RecognitionException {
		Moca_integration_variableContext _localctx = new Moca_integration_variableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_moca_integration_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(COLON);
			setState(517);
			match(WORD);
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

	public static class Moca_remote_keywordContext extends ParserRuleContext {
		public TerminalNode REMOTE() { return getToken(MocaParser.REMOTE, 0); }
		public TerminalNode PARALLEL() { return getToken(MocaParser.PARALLEL, 0); }
		public TerminalNode INPARALLEL() { return getToken(MocaParser.INPARALLEL, 0); }
		public Moca_remote_keywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_remote_keyword; }
	}

	public final Moca_remote_keywordContext moca_remote_keyword() throws RecognitionException {
		Moca_remote_keywordContext _localctx = new Moca_remote_keywordContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_moca_remote_keyword);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case REMOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				match(REMOTE);
				}
				break;
			case PARALLEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(521);
				match(PARALLEL);
				}
				break;
			case INPARALLEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(522);
				match(INPARALLEL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Sql_scriptContext extends ParserRuleContext {
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public Sql_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_script; }
	}

	public final Sql_scriptContext sql_script() throws RecognitionException {
		Sql_scriptContext _localctx = new Sql_scriptContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(SINGLE_BRACKET_STRING);
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

	public static class Groovy_scriptContext extends ParserRuleContext {
		public TerminalNode DOUBLE_BRACKET_STRING() { return getToken(MocaParser.DOUBLE_BRACKET_STRING, 0); }
		public Groovy_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groovy_script; }
	}

	public final Groovy_scriptContext groovy_script() throws RecognitionException {
		Groovy_scriptContext _localctx = new Groovy_scriptContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(DOUBLE_BRACKET_STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0214\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\3\3\3\3\3\7\3o\n\3\f\3\16\3r\13\3\3\3\5\3u\n\3\3\4\3"+
		"\4\3\4\7\4z\n\4\f\4\16\4}\13\4\3\5\3\5\3\5\7\5\u0082\n\5\f\5\16\5\u0085"+
		"\13\5\3\6\3\6\5\6\u0089\n\6\3\6\5\6\u008c\n\6\3\6\3\6\7\6\u0090\n\6\f"+
		"\6\16\6\u0093\13\6\3\6\5\6\u0096\n\6\3\6\3\6\7\6\u009a\n\6\f\6\16\6\u009d"+
		"\13\6\3\6\5\6\u00a0\n\6\3\6\5\6\u00a3\n\6\5\6\u00a5\n\6\3\7\3\7\5\7\u00a9"+
		"\n\7\3\7\5\7\u00ac\n\7\3\b\3\b\3\b\5\b\u00b1\n\b\3\t\5\t\u00b4\n\t\3\t"+
		"\6\t\u00b7\n\t\r\t\16\t\u00b8\3\t\3\t\5\t\u00bd\n\t\3\n\3\n\3\n\7\n\u00c2"+
		"\n\n\f\n\16\n\u00c5\13\n\3\13\3\13\3\13\3\13\5\13\u00cb\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00dc\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e5\n\13\5\13\u00e7"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f1\n\f\3\r\3\r\3\r\7\r\u00f6"+
		"\n\r\f\r\16\r\u00f9\13\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0111"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u011d\n\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0126\n\23\7\23\u0128\n\23\f"+
		"\23\16\23\u012b\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u0141\n\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0155\n\30\3\30\3\30\3\30\3\30\5\30\u015b\n\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u0170\n\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u017b\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0182\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u018a\n\30\7\30\u018c\n\30\f\30"+
		"\16\30\u018f\13\30\3\31\3\31\3\31\3\31\3\31\7\31\u0196\n\31\f\31\16\31"+
		"\u0199\13\31\5\31\u019b\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u01a4"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u01ad\n\33\3\34\3\34\3\34"+
		"\3\34\5\34\u01b3\n\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\5%\u01d3"+
		"\n%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3,\3,\5,\u01ef\n,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\5/\u0201\n/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\5\62\u020e\n\62\3\63\3\63\3\64\3\64\3\64\2\3.\65\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"f\2\6\3\2(\66\3\2\22\24\3\2\20\21\3\2\n\r\2\u024f\2h\3\2\2\2\4k\3\2\2"+
		"\2\6v\3\2\2\2\b~\3\2\2\2\n\u00a4\3\2\2\2\f\u00ab\3\2\2\2\16\u00b0\3\2"+
		"\2\2\20\u00b3\3\2\2\2\22\u00be\3\2\2\2\24\u00e6\3\2\2\2\26\u00f0\3\2\2"+
		"\2\30\u00f2\3\2\2\2\32\u00fc\3\2\2\2\34\u00ff\3\2\2\2\36\u0102\3\2\2\2"+
		" \u0105\3\2\2\2\"\u0108\3\2\2\2$\u0114\3\2\2\2&\u012e\3\2\2\2(\u0133\3"+
		"\2\2\2*\u0138\3\2\2\2,\u013b\3\2\2\2.\u015a\3\2\2\2\60\u0190\3\2\2\2\62"+
		"\u01a3\3\2\2\2\64\u01ac\3\2\2\2\66\u01b2\3\2\2\28\u01b4\3\2\2\2:\u01b7"+
		"\3\2\2\2<\u01bb\3\2\2\2>\u01bf\3\2\2\2@\u01c3\3\2\2\2B\u01c7\3\2\2\2D"+
		"\u01ca\3\2\2\2F\u01cd\3\2\2\2H\u01d2\3\2\2\2J\u01d4\3\2\2\2L\u01d8\3\2"+
		"\2\2N\u01dc\3\2\2\2P\u01e0\3\2\2\2R\u01e4\3\2\2\2T\u01e8\3\2\2\2V\u01ee"+
		"\3\2\2\2X\u01f0\3\2\2\2Z\u01f4\3\2\2\2\\\u0200\3\2\2\2^\u0202\3\2\2\2"+
		"`\u0206\3\2\2\2b\u020d\3\2\2\2d\u020f\3\2\2\2f\u0211\3\2\2\2hi\5\4\3\2"+
		"ij\7\2\2\3j\3\3\2\2\2kp\5\6\4\2lm\7\33\2\2mo\5\6\4\2nl\3\2\2\2or\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\7\33\2\2ts\3\2\2\2tu\3\2"+
		"\2\2u\5\3\2\2\2v{\5\b\5\2wx\7\35\2\2xz\5\b\5\2yw\3\2\2\2z}\3\2\2\2{y\3"+
		"\2\2\2{|\3\2\2\2|\7\3\2\2\2}{\3\2\2\2~\u0083\5\n\6\2\177\u0080\7\26\2"+
		"\2\u0080\u0082\5\n\6\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\t\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0088\5\f\7\2\u0087\u0089\5$\23\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5*\26\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u00a5\3\2\2\2\u008d\u0091\5\32\16\2\u008e\u0090\5"+
		"\34\17\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\5\36"+
		"\20\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u00a5\3\2\2\2\u0097"+
		"\u009b\5 \21\2\u0098\u009a\5&\24\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u00a0\5(\25\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3\5*\26\2\u00a2\u00a1\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0086\3\2\2\2\u00a4\u008d\3\2"+
		"\2\2\u00a4\u0097\3\2\2\2\u00a5\13\3\2\2\2\u00a6\u00ac\5\16\b\2\u00a7\u00a9"+
		"\5,\27\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\5\26\f\2\u00ab\u00a6\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\r\3\2\2"+
		"\2\u00ad\u00b1\5d\63\2\u00ae\u00b1\5f\64\2\u00af\u00b1\5\20\t\2\u00b0"+
		"\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\17\3\2\2"+
		"\2\u00b2\u00b4\7\27\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u00b7\t\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00bb\7\'\2\2\u00bb\u00bd\5\22\n\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\21\3\2\2\2\u00be\u00c3\5\24\13\2\u00bf\u00c0\7(\2\2\u00c0"+
		"\u00c2\5\24\13\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3"+
		"\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\23\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00e7\7%\2\2\u00c7\u00e7\7&\2\2\u00c8\u00cb\5B\"\2\u00c9\u00cb\5\66\34"+
		"\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00e7\3\2\2\2\u00cc\u00db"+
		"\7\66\2\2\u00cd\u00ce\7+\2\2\u00ce\u00dc\7-\2\2\u00cf\u00d0\7+\2\2\u00d0"+
		"\u00d1\7,\2\2\u00d1\u00dc\7-\2\2\u00d2\u00dc\7!\2\2\u00d3\u00dc\7\"\2"+
		"\2\u00d4\u00dc\7\n\2\2\u00d5\u00dc\7\13\2\2\u00d6\u00dc\7\f\2\2\u00d7"+
		"\u00dc\7\r\2\2\u00d8\u00dc\7)\2\2\u00d9\u00da\7,\2\2\u00da\u00dc\7)\2"+
		"\2\u00db\u00cd\3\2\2\2\u00db\u00cf\3\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d3"+
		"\3\2\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00e4\3\2"+
		"\2\2\u00dd\u00de\7\21\2\2\u00de\u00e5\7\67\2\2\u00df\u00e5\7\67\2\2\u00e0"+
		"\u00e5\78\2\2\u00e1\u00e5\7\66\2\2\u00e2\u00e5\5\64\33\2\u00e3\u00e5\5"+
		"\60\31\2\u00e4\u00dd\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e4"+
		"\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e7\3\2"+
		"\2\2\u00e6\u00c6\3\2\2\2\u00e6\u00c7\3\2\2\2\u00e6\u00ca\3\2\2\2\u00e6"+
		"\u00cc\3\2\2\2\u00e7\25\3\2\2\2\u00e8\u00e9\7\b\2\2\u00e9\u00ea\5\4\3"+
		"\2\u00ea\u00eb\7\t\2\2\u00eb\u00f1\3\2\2\2\u00ec\u00ed\7\b\2\2\u00ed\u00ee"+
		"\5\26\f\2\u00ee\u00ef\7\t\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e8\3\2\2\2"+
		"\u00f0\u00ec\3\2\2\2\u00f1\27\3\2\2\2\u00f2\u00f3\7.\2\2\u00f3\u00f7\7"+
		"\6\2\2\u00f4\u00f6\5.\30\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u00fb\7\7\2\2\u00fb\31\3\2\2\2\u00fc\u00fd\5\30\r\2\u00fd\u00fe"+
		"\5\n\6\2\u00fe\33\3\2\2\2\u00ff\u0100\7/\2\2\u0100\u0101\5\32\16\2\u0101"+
		"\35\3\2\2\2\u0102\u0103\7/\2\2\u0103\u0104\5\n\6\2\u0104\37\3\2\2\2\u0105"+
		"\u0106\7\60\2\2\u0106\u0107\5\f\7\2\u0107!\3\2\2\2\u0108\u0109\7\61\2"+
		"\2\u0109\u0110\7\6\2\2\u010a\u0111\5\62\32\2\u010b\u0111\5D#\2\u010c\u0111"+
		"\5F$\2\u010d\u0111\7\66\2\2\u010e\u0111\5\64\33\2\u010f\u0111\5\60\31"+
		"\2\u0110\u010a\3\2\2\2\u0110\u010b\3\2\2\2\u0110\u010c\3\2\2\2\u0110\u010d"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0113\7\7\2\2\u0113#\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u011c\7\6\2\2"+
		"\u0116\u011d\5\62\32\2\u0117\u011d\5D#\2\u0118\u011d\5F$\2\u0119\u011d"+
		"\7\66\2\2\u011a\u011d\5\64\33\2\u011b\u011d\5\60\31\2\u011c\u0116\3\2"+
		"\2\2\u011c\u0117\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u0119\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u0129\3\2\2\2\u011e\u0125\7\34"+
		"\2\2\u011f\u0126\5\62\32\2\u0120\u0126\5D#\2\u0121\u0126\5F$\2\u0122\u0126"+
		"\7\66\2\2\u0123\u0126\5\64\33\2\u0124\u0126\5\60\31\2\u0125\u011f\3\2"+
		"\2\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2\2\2\u0125\u0122\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u011e\3\2"+
		"\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\7\2\2\u012d%\3\2\2\2"+
		"\u012e\u012f\5\"\22\2\u012f\u0130\7\b\2\2\u0130\u0131\5\4\3\2\u0131\u0132"+
		"\7\t\2\2\u0132\'\3\2\2\2\u0133\u0134\7\62\2\2\u0134\u0135\7\b\2\2\u0135"+
		"\u0136\5\4\3\2\u0136\u0137\7\t\2\2\u0137)\3\2\2\2\u0138\u0139\7\17\2\2"+
		"\u0139\u013a\7\66\2\2\u013a+\3\2\2\2\u013b\u013c\5b\62\2\u013c\u0140\7"+
		"\6\2\2\u013d\u0141\5\62\32\2\u013e\u0141\7\66\2\2\u013f\u0141\5\64\33"+
		"\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0143\7\7\2\2\u0143-\3\2\2\2\u0144\u0145\b\30\1\2\u0145"+
		"\u015b\5\62\32\2\u0146\u015b\7\66\2\2\u0147\u015b\5\64\33\2\u0148\u015b"+
		"\5F$\2\u0149\u015b\5D#\2\u014a\u015b\5B\"\2\u014b\u015b\5\60\31\2\u014c"+
		"\u0154\7\30\2\2\u014d\u0155\5\62\32\2\u014e\u0155\7\66\2\2\u014f\u0155"+
		"\5\64\33\2\u0150\u0155\5F$\2\u0151\u0155\5D#\2\u0152\u0155\5B\"\2\u0153"+
		"\u0155\5\60\31\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3"+
		"\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0153\3\2\2\2\u0155\u015b\3\2\2\2\u0156\u0157\7\6\2\2\u0157\u0158\5."+
		"\30\2\u0158\u0159\7\7\2\2\u0159\u015b\3\2\2\2\u015a\u0144\3\2\2\2\u015a"+
		"\u0146\3\2\2\2\u015a\u0147\3\2\2\2\u015a\u0148\3\2\2\2\u015a\u0149\3\2"+
		"\2\2\u015a\u014a\3\2\2\2\u015a\u014b\3\2\2\2\u015a\u014c\3\2\2\2\u015a"+
		"\u0156\3\2\2\2\u015b\u018d\3\2\2\2\u015c\u015d\f\r\2\2\u015d\u015e\7\36"+
		"\2\2\u015e\u018c\5.\30\16\u015f\u0160\f\f\2\2\u0160\u0161\t\3\2\2\u0161"+
		"\u018c\5.\30\r\u0162\u0163\f\13\2\2\u0163\u0164\t\4\2\2\u0164\u018c\5"+
		".\30\f\u0165\u0166\f\n\2\2\u0166\u0167\t\5\2\2\u0167\u018c\5.\30\13\u0168"+
		"\u016f\f\t\2\2\u0169\u0170\7!\2\2\u016a\u0170\7\"\2\2\u016b\u0170\7+\2"+
		"\2\u016c\u016d\7+\2\2\u016d\u0170\7,\2\2\u016e\u0170\7)\2\2\u016f\u0169"+
		"\3\2\2\2\u016f\u016a\3\2\2\2\u016f\u016b\3\2\2\2\u016f\u016c\3\2\2\2\u016f"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u018c\5.\30\n\u0172\u0173\f\b"+
		"\2\2\u0173\u0174\7(\2\2\u0174\u018c\5.\30\t\u0175\u0176\f\7\2\2\u0176"+
		"\u0177\7*\2\2\u0177\u018c\5.\30\b\u0178\u017a\f\5\2\2\u0179\u017b\7,\2"+
		"\2\u017a\u0179\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d"+
		"\7)\2\2\u017d\u018c\5.\30\6\u017e\u017f\f\3\2\2\u017f\u0181\7+\2\2\u0180"+
		"\u0182\7,\2\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u018c\5.\30\4\u0184\u0189\f\4\2\2\u0185\u018a\7+\2\2\u0186"+
		"\u018a\7-\2\2\u0187\u0188\7,\2\2\u0188\u018a\7-\2\2\u0189\u0185\3\2\2"+
		"\2\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u015c"+
		"\3\2\2\2\u018b\u015f\3\2\2\2\u018b\u0162\3\2\2\2\u018b\u0165\3\2\2\2\u018b"+
		"\u0168\3\2\2\2\u018b\u0172\3\2\2\2\u018b\u0175\3\2\2\2\u018b\u0178\3\2"+
		"\2\2\u018b\u017e\3\2\2\2\u018b\u0184\3\2\2\2\u018c\u018f\3\2\2\2\u018d"+
		"\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e/\3\2\2\2\u018f\u018d\3\2\2\2"+
		"\u0190\u0191\7\66\2\2\u0191\u019a\7\6\2\2\u0192\u0197\5.\30\2\u0193\u0194"+
		"\7\34\2\2\u0194\u0196\5.\30\2\u0195\u0193\3\2\2\2\u0196\u0199\3\2\2\2"+
		"\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u019a\u0192\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019d\7\7\2\2\u019d\61\3\2\2\2\u019e\u019f\7\21\2\2\u019f\u01a4\7\67"+
		"\2\2\u01a0\u01a4\7\67\2\2\u01a1\u01a4\78\2\2\u01a2\u01a4\7-\2\2\u01a3"+
		"\u019e\3\2\2\2\u01a3\u01a0\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2"+
		"\2\2\u01a4\63\3\2\2\2\u01a5\u01ad\58\35\2\u01a6\u01ad\5<\37\2\u01a7\u01ad"+
		"\5:\36\2\u01a8\u01ad\5H%\2\u01a9\u01ad\5R*\2\u01aa\u01ad\5\\/\2\u01ab"+
		"\u01ad\5`\61\2\u01ac\u01a5\3\2\2\2\u01ac\u01a6\3\2\2\2\u01ac\u01a7\3\2"+
		"\2\2\u01ac\u01a8\3\2\2\2\u01ac\u01a9\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ab\3\2\2\2\u01ad\65\3\2\2\2\u01ae\u01b3\5> \2\u01af\u01b3\5@!\2\u01b0"+
		"\u01b3\5V,\2\u01b1\u01b3\5^\60\2\u01b2\u01ae\3\2\2\2\u01b2\u01af\3\2\2"+
		"\2\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\67\3\2\2\2\u01b4\u01b5"+
		"\7 \2\2\u01b5\u01b6\7\66\2\2\u01b69\3\2\2\2\u01b7\u01b8\7 \2\2\u01b8\u01b9"+
		"\7 \2\2\u01b9\u01ba\7\66\2\2\u01ba;\3\2\2\2\u01bb\u01bc\7 \2\2\u01bc\u01bd"+
		"\7\21\2\2\u01bd\u01be\7\66\2\2\u01be=\3\2\2\2\u01bf\u01c0\7 \2\2\u01c0"+
		"\u01c1\7\20\2\2\u01c1\u01c2\7\66\2\2\u01c2?\3\2\2\2\u01c3\u01c4\7 \2\2"+
		"\u01c4\u01c5\7\24\2\2\u01c5\u01c6\7\66\2\2\u01c6A\3\2\2\2\u01c7\u01c8"+
		"\7 \2\2\u01c8\u01c9\7\22\2\2\u01c9C\3\2\2\2\u01ca\u01cb\7 \2\2\u01cb\u01cc"+
		"\7\31\2\2\u01ccE\3\2\2\2\u01cd\u01ce\7 \2\2\u01ce\u01cf\7\30\2\2\u01cf"+
		"G\3\2\2\2\u01d0\u01d3\5J&\2\u01d1\u01d3\5L\'\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3I\3\2\2\2\u01d4\u01d5\58\35\2\u01d5\u01d6\7\37\2\2"+
		"\u01d6\u01d7\7\3\2\2\u01d7K\3\2\2\2\u01d8\u01d9\5<\37\2\u01d9\u01da\7"+
		"\37\2\2\u01da\u01db\7\3\2\2\u01dbM\3\2\2\2\u01dc\u01dd\5> \2\u01dd\u01de"+
		"\7\37\2\2\u01de\u01df\7\3\2\2\u01dfO\3\2\2\2\u01e0\u01e1\5@!\2\u01e1\u01e2"+
		"\7\37\2\2\u01e2\u01e3\7\3\2\2\u01e3Q\3\2\2\2\u01e4\u01e5\58\35\2\u01e5"+
		"\u01e6\7\37\2\2\u01e6\u01e7\7\4\2\2\u01e7S\3\2\2\2\u01e8\u01e9\58\35\2"+
		"\u01e9\u01ea\7\37\2\2\u01ea\u01eb\7\5\2\2\u01ebU\3\2\2\2\u01ec\u01ef\5"+
		"X-\2\u01ed\u01ef\5Z.\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2\2\2\u01efW"+
		"\3\2\2\2\u01f0\u01f1\5> \2\u01f1\u01f2\7\27\2\2\u01f2\u01f3\7\66\2\2\u01f3"+
		"Y\3\2\2\2\u01f4\u01f5\5@!\2\u01f5\u01f6\7\27\2\2\u01f6\u01f7\7\66\2\2"+
		"\u01f7[\3\2\2\2\u01f8\u01f9\58\35\2\u01f9\u01fa\7\32\2\2\u01fa\u01fb\7"+
		"\66\2\2\u01fb\u0201\3\2\2\2\u01fc\u01fd\5> \2\u01fd\u01fe\7\32\2\2\u01fe"+
		"\u01ff\7\66\2\2\u01ff\u0201\3\2\2\2\u0200\u01f8\3\2\2\2\u0200\u01fc\3"+
		"\2\2\2\u0201]\3\2\2\2\u0202\u0203\5> \2\u0203\u0204\7#\2\2\u0204\u0205"+
		"\7\66\2\2\u0205_\3\2\2\2\u0206\u0207\7\32\2\2\u0207\u0208\7\66\2\2\u0208"+
		"a\3\2\2\2\u0209\u020e\3\2\2\2\u020a\u020e\7\63\2\2\u020b\u020e\7\64\2"+
		"\2\u020c\u020e\7\65\2\2\u020d\u0209\3\2\2\2\u020d\u020a\3\2\2\2\u020d"+
		"\u020b\3\2\2\2\u020d\u020c\3\2\2\2\u020ec\3\2\2\2\u020f\u0210\7%\2\2\u0210"+
		"e\3\2\2\2\u0211\u0212\7$\2\2\u0212g\3\2\2\2\61pt{\u0083\u0088\u008b\u0091"+
		"\u0095\u009b\u009f\u00a2\u00a4\u00a8\u00ab\u00b0\u00b3\u00b8\u00bc\u00c3"+
		"\u00ca\u00db\u00e4\u00e6\u00f0\u00f7\u0110\u011c\u0125\u0129\u0140\u0154"+
		"\u015a\u016f\u017a\u0181\u0189\u018b\u018d\u0197\u019a\u01a3\u01ac\u01b2"+
		"\u01d2\u01ee\u0200\u020d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}