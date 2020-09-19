// Generated from Moca.g4 by ANTLR 4.8

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
	public static final int
		RULE_moca_script = 0, RULE_sequence = 1, RULE_stream = 2, RULE_group = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_command = 6, RULE_verb_noun_clause = 7, 
		RULE_verb_noun_clause_arg = 8, RULE_verb_noun_clause_arg_expr = 9, RULE_sub_sequence = 10, 
		RULE_if_expr = 11, RULE_if_statement = 12, RULE_else_if_statement = 13, 
		RULE_else_statement = 14, RULE_try_block = 15, RULE_catch_single_expr = 16, 
		RULE_catch_multi_expr = 17, RULE_catch_sequence = 18, RULE_finally_sequence = 19, 
		RULE_redirect_expr = 20, RULE_remote_expr = 21, RULE_suppress_warnings_expr = 22, 
		RULE_expr = 23, RULE_function_expr = 24, RULE_literal_value = 25, RULE_at_variable = 26, 
		RULE_environment_variable = 27, RULE_at_plus_variable = 28, RULE_at_star = 29, 
		RULE_at_question = 30, RULE_at_bang = 31, RULE_integration_variable = 32, 
		RULE_remote_keyword = 33, RULE_groovy_script = 34, RULE_sql_script = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
			"verb_noun_clause", "verb_noun_clause_arg", "verb_noun_clause_arg_expr", 
			"sub_sequence", "if_expr", "if_statement", "else_if_statement", "else_statement", 
			"try_block", "catch_single_expr", "catch_multi_expr", "catch_sequence", 
			"finally_sequence", "redirect_expr", "remote_expr", "suppress_warnings_expr", 
			"expr", "function_expr", "literal_value", "at_variable", "environment_variable", 
			"at_plus_variable", "at_star", "at_question", "at_bang", "integration_variable", 
			"remote_keyword", "groovy_script", "sql_script"
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_script(this);
		}
	}

	public final Moca_scriptContext moca_script() throws RecognitionException {
		Moca_scriptContext _localctx = new Moca_scriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_moca_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			sequence();
			setState(73);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitSequence(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			stream();
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					match(SEMI_COLON);
					setState(77);
					stream();
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(83);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitStream(this);
		}
	}

	public final StreamContext stream() throws RecognitionException {
		StreamContext _localctx = new StreamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stream);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			group();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(87);
				match(PIPE);
				setState(88);
				group();
				}
				}
				setState(93);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitGroup(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			statement();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(95);
				match(AMPERSAND);
				setState(96);
				statement();
				}
				}
				setState(101);
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
		public Redirect_exprContext redirect_expr() {
			return getRuleContext(Redirect_exprContext.class,0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(102);
				block();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(103);
					catch_multi_expr();
					}
				}

				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(106);
					redirect_expr();
					}
				}

				}
				break;
			case 2:
				{
				setState(109);
				if_statement();
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(110);
						else_if_statement();
						}
						} 
					}
					setState(115);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(116);
					else_statement();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(119);
				try_block();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(120);
					catch_sequence();
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(126);
					finally_sequence();
					}
				}

				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(129);
					redirect_expr();
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
		public Remote_exprContext remote_expr() {
			return getRuleContext(Remote_exprContext.class,0);
		}
		public Suppress_warnings_exprContext suppress_warnings_expr() {
			return getRuleContext(Suppress_warnings_exprContext.class,0);
		}
		public Sub_sequenceContext sub_sequence() {
			return getRuleContext(Sub_sequenceContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(135);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(134);
						remote_expr();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SUPPRESS_WARNINGS) {
						{
						setState(137);
						suppress_warnings_expr();
						}
					}

					}
					break;
				}
				setState(142);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL))) != 0)) {
						{
						setState(143);
						remote_expr();
						}
					}

					}
					break;
				case 2:
					{
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SUPPRESS_WARNINGS) {
						{
						setState(146);
						suppress_warnings_expr();
						}
					}

					}
					break;
				}
				setState(151);
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
		public Groovy_scriptContext groovy_script() {
			return getRuleContext(Groovy_scriptContext.class,0);
		}
		public Sql_scriptContext sql_script() {
			return getRuleContext(Sql_scriptContext.class,0);
		}
		public Verb_noun_clauseContext verb_noun_clause() {
			return getRuleContext(Verb_noun_clauseContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				groovy_script();
				}
				break;
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				sql_script();
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
			case ONSTACK:
			case KEEP:
			case WORD:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
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
		public List<Verb_noun_clause_argContext> verb_noun_clause_arg() {
			return getRuleContexts(Verb_noun_clause_argContext.class);
		}
		public Verb_noun_clause_argContext verb_noun_clause_arg(int i) {
			return getRuleContext(Verb_noun_clause_argContext.class,i);
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
		public List<TerminalNode> KEEP() { return getTokens(MocaParser.KEEP); }
		public TerminalNode KEEP(int i) {
			return getToken(MocaParser.KEEP, i);
		}
		public List<TerminalNode> ONSTACK() { return getTokens(MocaParser.ONSTACK); }
		public TerminalNode ONSTACK(int i) {
			return getToken(MocaParser.ONSTACK, i);
		}
		public Verb_noun_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVerb_noun_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVerb_noun_clause(this);
		}
	}

	public final Verb_noun_clauseContext verb_noun_clause() throws RecognitionException {
		Verb_noun_clauseContext _localctx = new Verb_noun_clauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_verb_noun_clause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(159);
				match(CARET);
				}
			}

			setState(163); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(162);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << ONSTACK) | (1L << KEEP) | (1L << WORD))) != 0)) ) {
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
				setState(165); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(167);
				match(WHERE);
				setState(168);
				verb_noun_clause_arg();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(169);
					match(AND);
					setState(170);
					verb_noun_clause_arg();
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Verb_noun_clause_argContext extends ParserRuleContext {
		public TerminalNode OVERSTACKED_ARGS() { return getToken(MocaParser.OVERSTACKED_ARGS, 0); }
		public TerminalNode SPECIAL_COMMAND_ARG_NO_ROWS() { return getToken(MocaParser.SPECIAL_COMMAND_ARG_NO_ROWS, 0); }
		public TerminalNode SPECIAL_COMMAND_ARG_DUMMY_ARG() { return getToken(MocaParser.SPECIAL_COMMAND_ARG_DUMMY_ARG, 0); }
		public Groovy_scriptContext groovy_script() {
			return getRuleContext(Groovy_scriptContext.class,0);
		}
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public At_starContext at_star() {
			return getRuleContext(At_starContext.class,0);
		}
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr() {
			return getRuleContext(Verb_noun_clause_arg_exprContext.class,0);
		}
		public TerminalNode IS() { return getToken(MocaParser.IS, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
		public TerminalNode LIKE() { return getToken(MocaParser.LIKE, 0); }
		public TerminalNode LESS() { return getToken(MocaParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(MocaParser.GREATER, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(MocaParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(MocaParser.GREATER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(MocaParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(MocaParser.NOT_EQUAL, 0); }
		public TerminalNode NOT() { return getToken(MocaParser.NOT, 0); }
		public Verb_noun_clause_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVerb_noun_clause_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVerb_noun_clause_arg(this);
		}
	}

	public final Verb_noun_clause_argContext verb_noun_clause_arg() throws RecognitionException {
		Verb_noun_clause_argContext _localctx = new Verb_noun_clause_argContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_verb_noun_clause_arg);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OVERSTACKED_ARGS:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(OVERSTACKED_ARGS);
				}
				break;
			case SPECIAL_COMMAND_ARG_NO_ROWS:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(SPECIAL_COMMAND_ARG_NO_ROWS);
				}
				break;
			case SPECIAL_COMMAND_ARG_DUMMY_ARG:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				match(SPECIAL_COMMAND_ARG_DUMMY_ARG);
				}
				break;
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				groovy_script();
				}
				break;
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(183);
					at_star();
					}
					break;
				case 2:
					{
					setState(184);
					at_plus_variable();
					}
					break;
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(WORD);
				setState(206);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IS:
					{
					{
					setState(188);
					match(IS);
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(189);
						match(NOT);
						}
					}

					setState(192);
					match(NULL);
					}
					}
					break;
				case LESS:
				case GREATER:
				case LESS_EQUAL:
				case GREATER_EQUAL:
				case EQUAL:
				case NOT_EQUAL:
				case LIKE:
				case NOT:
					{
					setState(203);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LIKE:
					case NOT:
						{
						setState(194);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(193);
							match(NOT);
							}
						}

						setState(196);
						match(LIKE);
						}
						break;
					case LESS:
						{
						setState(197);
						match(LESS);
						}
						break;
					case GREATER:
						{
						setState(198);
						match(GREATER);
						}
						break;
					case LESS_EQUAL:
						{
						setState(199);
						match(LESS_EQUAL);
						}
						break;
					case GREATER_EQUAL:
						{
						setState(200);
						match(GREATER_EQUAL);
						}
						break;
					case EQUAL:
						{
						setState(201);
						match(EQUAL);
						}
						break;
					case NOT_EQUAL:
						{
						setState(202);
						match(NOT_EQUAL);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(205);
					verb_noun_clause_arg_expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class Verb_noun_clause_arg_exprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public Environment_variableContext environment_variable() {
			return getRuleContext(Environment_variableContext.class,0);
		}
		public Integration_variableContext integration_variable() {
			return getRuleContext(Integration_variableContext.class,0);
		}
		public At_bangContext at_bang() {
			return getRuleContext(At_bangContext.class,0);
		}
		public At_questionContext at_question() {
			return getRuleContext(At_questionContext.class,0);
		}
		public At_starContext at_star() {
			return getRuleContext(At_starContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public Groovy_scriptContext groovy_script() {
			return getRuleContext(Groovy_scriptContext.class,0);
		}
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public List<Verb_noun_clause_arg_exprContext> verb_noun_clause_arg_expr() {
			return getRuleContexts(Verb_noun_clause_arg_exprContext.class);
		}
		public Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr(int i) {
			return getRuleContext(Verb_noun_clause_arg_exprContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public TerminalNode AND() { return getToken(MocaParser.AND, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public TerminalNode OR() { return getToken(MocaParser.OR, 0); }
		public TerminalNode LIKE() { return getToken(MocaParser.LIKE, 0); }
		public TerminalNode NOT() { return getToken(MocaParser.NOT, 0); }
		public TerminalNode IS() { return getToken(MocaParser.IS, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
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
		public Verb_noun_clause_arg_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb_noun_clause_arg_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVerb_noun_clause_arg_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVerb_noun_clause_arg_expr(this);
		}
	}

	public final Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr() throws RecognitionException {
		return verb_noun_clause_arg_expr(0);
	}

	private Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Verb_noun_clause_arg_exprContext _localctx = new Verb_noun_clause_arg_exprContext(_ctx, _parentState);
		Verb_noun_clause_arg_exprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_verb_noun_clause_arg_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(211);
				literal_value();
				}
				break;
			case 2:
				{
				setState(212);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(213);
				at_variable();
				}
				break;
			case 4:
				{
				setState(214);
				environment_variable();
				}
				break;
			case 5:
				{
				setState(215);
				integration_variable();
				}
				break;
			case 6:
				{
				setState(216);
				at_bang();
				}
				break;
			case 7:
				{
				setState(217);
				at_question();
				}
				break;
			case 8:
				{
				setState(218);
				at_star();
				}
				break;
			case 9:
				{
				setState(219);
				function_expr();
				}
				break;
			case 10:
				{
				setState(220);
				groovy_script();
				}
				break;
			case 11:
				{
				setState(221);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 12:
				{
				{
				setState(222);
				match(BANG);
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(223);
					literal_value();
					}
					break;
				case 2:
					{
					setState(224);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(225);
					at_variable();
					}
					break;
				case 4:
					{
					setState(226);
					environment_variable();
					}
					break;
				case 5:
					{
					setState(227);
					integration_variable();
					}
					break;
				case 6:
					{
					setState(228);
					at_bang();
					}
					break;
				case 7:
					{
					setState(229);
					at_question();
					}
					break;
				case 8:
					{
					setState(230);
					at_star();
					}
					break;
				case 9:
					{
					setState(231);
					function_expr();
					}
					break;
				case 10:
					{
					setState(232);
					groovy_script();
					}
					break;
				case 11:
					{
					setState(233);
					match(SINGLE_BRACKET_STRING);
					}
					break;
				case 12:
					{
					setState(234);
					verb_noun_clause_arg_expr(0);
					}
					break;
				}
				}
				}
				break;
			case 13:
				{
				setState(237);
				match(LEFT_PAREN);
				setState(238);
				verb_noun_clause_arg_expr(0);
				setState(239);
				match(AND);
				setState(240);
				verb_noun_clause_arg_expr(0);
				setState(241);
				match(RIGHT_PAREN);
				}
				break;
			case 14:
				{
				setState(243);
				match(LEFT_PAREN);
				setState(244);
				verb_noun_clause_arg_expr(0);
				setState(245);
				match(OR);
				setState(246);
				verb_noun_clause_arg_expr(0);
				setState(247);
				match(RIGHT_PAREN);
				}
				break;
			case 15:
				{
				setState(249);
				match(LEFT_PAREN);
				setState(250);
				verb_noun_clause_arg_expr(0);
				setState(251);
				match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(253);
				match(LEFT_PAREN);
				setState(254);
				verb_noun_clause_arg_expr(0);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(255);
					match(NOT);
					}
				}

				{
				setState(258);
				match(LIKE);
				}
				setState(259);
				verb_noun_clause_arg_expr(0);
				setState(260);
				match(RIGHT_PAREN);
				}
				break;
			case 17:
				{
				setState(262);
				match(LEFT_PAREN);
				setState(263);
				verb_noun_clause_arg_expr(0);
				setState(268);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IS:
					{
					setState(264);
					match(IS);
					}
					break;
				case NULL:
					{
					setState(265);
					match(NULL);
					}
					break;
				case NOT:
					{
					setState(266);
					match(NOT);
					setState(267);
					match(NULL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(270);
				match(RIGHT_PAREN);
				}
				break;
			case 18:
				{
				setState(272);
				match(LEFT_PAREN);
				setState(273);
				verb_noun_clause_arg_expr(0);
				setState(274);
				match(IS);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(275);
					match(NOT);
					}
				}

				setState(278);
				verb_noun_clause_arg_expr(0);
				setState(279);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(283);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(284);
						match(DOUBLE_PIPE);
						setState(285);
						verb_noun_clause_arg_expr(12);
						}
						break;
					case 2:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(286);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(287);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(288);
						verb_noun_clause_arg_expr(11);
						}
						break;
					case 3:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(289);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(290);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(291);
						verb_noun_clause_arg_expr(10);
						}
						break;
					case 4:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(292);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(293);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(294);
						verb_noun_clause_arg_expr(9);
						}
						break;
					case 5:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(295);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(302);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
						case 1:
							{
							setState(296);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(297);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(298);
							match(IS);
							}
							break;
						case 4:
							{
							setState(299);
							match(IS);
							setState(300);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(301);
							match(LIKE);
							}
							break;
						}
						setState(304);
						verb_noun_clause_arg_expr(8);
						}
						break;
					}
					} 
				}
				setState(309);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterSub_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitSub_sequence(this);
		}
	}

	public final Sub_sequenceContext sub_sequence() throws RecognitionException {
		Sub_sequenceContext _localctx = new Sub_sequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sub_sequence);
		try {
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(LEFT_BRACE);
				setState(311);
				sequence();
				setState(312);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(LEFT_BRACE);
				setState(315);
				sub_sequence();
				setState(316);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitIf_expr(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(IF);
			setState(321);
			match(LEFT_PAREN);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				{
				setState(322);
				expr(0);
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			if_expr();
			setState(331);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterElse_if_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitElse_if_statement(this);
		}
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(ELSE);
			setState(334);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ELSE);
			setState(337);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterTry_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitTry_block(this);
		}
	}

	public final Try_blockContext try_block() throws RecognitionException {
		Try_blockContext _localctx = new Try_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(TRY);
			setState(340);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Catch_single_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_single_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterCatch_single_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitCatch_single_expr(this);
		}
	}

	public final Catch_single_exprContext catch_single_expr() throws RecognitionException {
		Catch_single_exprContext _localctx = new Catch_single_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_catch_single_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(CATCH);
			setState(343);
			match(LEFT_PAREN);
			setState(344);
			expr(0);
			setState(345);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MocaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MocaParser.COMMA, i);
		}
		public Catch_multi_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_multi_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterCatch_multi_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitCatch_multi_expr(this);
		}
	}

	public final Catch_multi_exprContext catch_multi_expr() throws RecognitionException {
		Catch_multi_exprContext _localctx = new Catch_multi_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_catch_multi_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(CATCH);
			setState(348);
			match(LEFT_PAREN);
			setState(349);
			expr(0);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(350);
				match(COMMA);
				setState(351);
				expr(0);
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357);
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
		public TerminalNode RIGHT_BRACE() { return getToken(MocaParser.RIGHT_BRACE, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public Catch_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterCatch_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitCatch_sequence(this);
		}
	}

	public final Catch_sequenceContext catch_sequence() throws RecognitionException {
		Catch_sequenceContext _localctx = new Catch_sequenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_catch_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			catch_single_expr();
			setState(360);
			match(LEFT_BRACE);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << CARET) | (1L << SUPPRESS_WARNINGS) | (1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << ONSTACK) | (1L << KEEP) | (1L << WORD))) != 0)) {
				{
				setState(361);
				sequence();
				}
			}

			setState(364);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterFinally_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitFinally_sequence(this);
		}
	}

	public final Finally_sequenceContext finally_sequence() throws RecognitionException {
		Finally_sequenceContext _localctx = new Finally_sequenceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_finally_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(FINALLY);
			setState(367);
			match(LEFT_BRACE);
			setState(368);
			sequence();
			setState(369);
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

	public static class Redirect_exprContext extends ParserRuleContext {
		public TerminalNode DOUBLE_GREATER() { return getToken(MocaParser.DOUBLE_GREATER, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Redirect_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redirect_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterRedirect_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitRedirect_expr(this);
		}
	}

	public final Redirect_exprContext redirect_expr() throws RecognitionException {
		Redirect_exprContext _localctx = new Redirect_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_redirect_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(DOUBLE_GREATER);
			setState(372);
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

	public static class Remote_exprContext extends ParserRuleContext {
		public Remote_keywordContext remote_keyword() {
			return getRuleContext(Remote_keywordContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Remote_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remote_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterRemote_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitRemote_expr(this);
		}
	}

	public final Remote_exprContext remote_expr() throws RecognitionException {
		Remote_exprContext _localctx = new Remote_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_remote_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			remote_keyword();
			setState(375);
			match(LEFT_PAREN);
			setState(376);
			expr(0);
			setState(377);
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

	public static class Suppress_warnings_exprContext extends ParserRuleContext {
		public TerminalNode SUPPRESS_WARNINGS() { return getToken(MocaParser.SUPPRESS_WARNINGS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Suppress_warnings_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suppress_warnings_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterSuppress_warnings_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitSuppress_warnings_expr(this);
		}
	}

	public final Suppress_warnings_exprContext suppress_warnings_expr() throws RecognitionException {
		Suppress_warnings_exprContext _localctx = new Suppress_warnings_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_suppress_warnings_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(SUPPRESS_WARNINGS);
			setState(380);
			match(LEFT_PAREN);
			setState(381);
			expr(0);
			setState(382);
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
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public Environment_variableContext environment_variable() {
			return getRuleContext(Environment_variableContext.class,0);
		}
		public Integration_variableContext integration_variable() {
			return getRuleContext(Integration_variableContext.class,0);
		}
		public At_bangContext at_bang() {
			return getRuleContext(At_bangContext.class,0);
		}
		public At_questionContext at_question() {
			return getRuleContext(At_questionContext.class,0);
		}
		public At_starContext at_star() {
			return getRuleContext(At_starContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public Groovy_scriptContext groovy_script() {
			return getRuleContext(Groovy_scriptContext.class,0);
		}
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(385);
				literal_value();
				}
				break;
			case 2:
				{
				setState(386);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(387);
				at_variable();
				}
				break;
			case 4:
				{
				setState(388);
				environment_variable();
				}
				break;
			case 5:
				{
				setState(389);
				integration_variable();
				}
				break;
			case 6:
				{
				setState(390);
				at_bang();
				}
				break;
			case 7:
				{
				setState(391);
				at_question();
				}
				break;
			case 8:
				{
				setState(392);
				at_star();
				}
				break;
			case 9:
				{
				setState(393);
				function_expr();
				}
				break;
			case 10:
				{
				setState(394);
				groovy_script();
				}
				break;
			case 11:
				{
				setState(395);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 12:
				{
				{
				setState(396);
				match(BANG);
				setState(409);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(397);
					literal_value();
					}
					break;
				case 2:
					{
					setState(398);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(399);
					at_variable();
					}
					break;
				case 4:
					{
					setState(400);
					environment_variable();
					}
					break;
				case 5:
					{
					setState(401);
					integration_variable();
					}
					break;
				case 6:
					{
					setState(402);
					at_bang();
					}
					break;
				case 7:
					{
					setState(403);
					at_question();
					}
					break;
				case 8:
					{
					setState(404);
					at_star();
					}
					break;
				case 9:
					{
					setState(405);
					function_expr();
					}
					break;
				case 10:
					{
					setState(406);
					groovy_script();
					}
					break;
				case 11:
					{
					setState(407);
					match(SINGLE_BRACKET_STRING);
					}
					break;
				case 12:
					{
					setState(408);
					expr(0);
					}
					break;
				}
				}
				}
				break;
			case 13:
				{
				setState(411);
				match(LEFT_PAREN);
				setState(412);
				expr(0);
				setState(413);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(464);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(417);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(418);
						match(DOUBLE_PIPE);
						setState(419);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(420);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(421);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(422);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(423);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(424);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(425);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(426);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(427);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(428);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(429);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(436);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
						case 1:
							{
							setState(430);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(431);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(432);
							match(IS);
							}
							break;
						case 4:
							{
							setState(433);
							match(IS);
							setState(434);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(435);
							match(LIKE);
							}
							break;
						}
						setState(438);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(439);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(440);
						match(AND);
						setState(441);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(442);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(443);
						match(OR);
						setState(444);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(445);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(447);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(446);
							match(NOT);
							}
						}

						{
						setState(449);
						match(LIKE);
						}
						setState(450);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(451);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(452);
						match(IS);
						setState(454);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(453);
							match(NOT);
							}
						}

						setState(456);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(457);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(462);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(458);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(459);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(460);
							match(NOT);
							setState(461);
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
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterFunction_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitFunction_expr(this);
		}
	}

	public final Function_exprContext function_expr() throws RecognitionException {
		Function_exprContext _localctx = new Function_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(WORD);
			setState(470);
			match(LEFT_PAREN);
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				setState(471);
				expr(0);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(472);
					match(COMMA);
					setState(473);
					expr(0);
					}
					}
					setState(478);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(481);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitLiteral_value(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal_value);
		try {
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				match(MINUS);
				setState(484);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(486);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(487);
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

	public static class At_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public List<TerminalNode> WORD() { return getTokens(MocaParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MocaParser.WORD, i);
		}
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode KEEP() { return getToken(MocaParser.KEEP, 0); }
		public TerminalNode ONSTACK() { return getToken(MocaParser.ONSTACK, 0); }
		public At_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_variable(this);
		}
	}

	public final At_variableContext at_variable() throws RecognitionException {
		At_variableContext _localctx = new At_variableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_at_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(AT);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(491);
				match(MINUS);
				}
			}

			setState(494);
			match(WORD);
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				{
				setState(495);
				match(COLON);
				setState(496);
				match(WORD);
				}
				}
				break;
			case 2:
				{
				setState(501);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					{
					setState(497);
					match(POUND);
					setState(498);
					match(KEEP);
					}
					}
					break;
				case 2:
					{
					{
					setState(499);
					match(POUND);
					setState(500);
					match(ONSTACK);
					}
					}
					break;
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

	public static class Environment_variableContext extends ParserRuleContext {
		public List<TerminalNode> AT() { return getTokens(MocaParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(MocaParser.AT, i);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Environment_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environment_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterEnvironment_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitEnvironment_variable(this);
		}
	}

	public final Environment_variableContext environment_variable() throws RecognitionException {
		Environment_variableContext _localctx = new Environment_variableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_environment_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(AT);
			setState(506);
			match(AT);
			setState(507);
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

	public static class At_plus_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public List<TerminalNode> WORD() { return getTokens(MocaParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MocaParser.WORD, i);
		}
		public TerminalNode PLUS() { return getToken(MocaParser.PLUS, 0); }
		public TerminalNode MOD() { return getToken(MocaParser.MOD, 0); }
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public At_plus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_variable(this);
		}
	}

	public final At_plus_variableContext at_plus_variable() throws RecognitionException {
		At_plus_variableContext _localctx = new At_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_at_plus_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(AT);
			setState(510);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MOD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(511);
			match(WORD);
			setState(516);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				{
				{
				setState(512);
				match(COLON);
				setState(513);
				match(WORD);
				}
				}
				break;
			case CARET:
				{
				{
				setState(514);
				match(CARET);
				setState(515);
				match(WORD);
				}
				}
				break;
			case EOF:
			case RIGHT_BRACE:
			case DOUBLE_GREATER:
			case AMPERSAND:
			case SEMI_COLON:
			case PIPE:
			case AND:
			case ELSE:
			case CATCH:
			case FINALLY:
				break;
			default:
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

	public static class At_starContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode STAR() { return getToken(MocaParser.STAR, 0); }
		public At_starContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_star; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_star(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_star(this);
		}
	}

	public final At_starContext at_star() throws RecognitionException {
		At_starContext _localctx = new At_starContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_at_star);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(AT);
			setState(519);
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

	public static class At_questionContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode QUESTION() { return getToken(MocaParser.QUESTION, 0); }
		public At_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_question(this);
		}
	}

	public final At_questionContext at_question() throws RecognitionException {
		At_questionContext _localctx = new At_questionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_at_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(AT);
			setState(522);
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

	public static class At_bangContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public At_bangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_bang; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_bang(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_bang(this);
		}
	}

	public final At_bangContext at_bang() throws RecognitionException {
		At_bangContext _localctx = new At_bangContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_at_bang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(AT);
			setState(525);
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

	public static class Integration_variableContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Integration_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integration_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterIntegration_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitIntegration_variable(this);
		}
	}

	public final Integration_variableContext integration_variable() throws RecognitionException {
		Integration_variableContext _localctx = new Integration_variableContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_integration_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(COLON);
			setState(528);
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

	public static class Remote_keywordContext extends ParserRuleContext {
		public TerminalNode REMOTE() { return getToken(MocaParser.REMOTE, 0); }
		public TerminalNode PARALLEL() { return getToken(MocaParser.PARALLEL, 0); }
		public TerminalNode INPARALLEL() { return getToken(MocaParser.INPARALLEL, 0); }
		public Remote_keywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remote_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterRemote_keyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitRemote_keyword(this);
		}
	}

	public final Remote_keywordContext remote_keyword() throws RecognitionException {
		Remote_keywordContext _localctx = new Remote_keywordContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_remote_keyword);
		try {
			setState(534);
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
				setState(531);
				match(REMOTE);
				}
				break;
			case PARALLEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(532);
				match(PARALLEL);
				}
				break;
			case INPARALLEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(533);
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

	public static class Groovy_scriptContext extends ParserRuleContext {
		public TerminalNode DOUBLE_BRACKET_STRING() { return getToken(MocaParser.DOUBLE_BRACKET_STRING, 0); }
		public Groovy_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groovy_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterGroovy_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitGroovy_script(this);
		}
	}

	public final Groovy_scriptContext groovy_script() throws RecognitionException {
		Groovy_scriptContext _localctx = new Groovy_scriptContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
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

	public static class Sql_scriptContext extends ParserRuleContext {
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public Sql_scriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterSql_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitSql_script(this);
		}
	}

	public final Sql_scriptContext sql_script() throws RecognitionException {
		Sql_scriptContext _localctx = new Sql_scriptContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return verb_noun_clause_arg_expr_sempred((Verb_noun_clause_arg_exprContext)_localctx, predIndex);
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean verb_noun_clause_arg_expr_sempred(Verb_noun_clause_arg_exprContext _localctx, int predIndex) {
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
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 1);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u021f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\3\3\3\3\3\7\3Q\n\3\f\3\16"+
		"\3T\13\3\3\3\5\3W\n\3\3\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\5\3\5\3\5"+
		"\7\5d\n\5\f\5\16\5g\13\5\3\6\3\6\5\6k\n\6\3\6\5\6n\n\6\3\6\3\6\7\6r\n"+
		"\6\f\6\16\6u\13\6\3\6\5\6x\n\6\3\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\6"+
		"\5\6\u0082\n\6\3\6\5\6\u0085\n\6\5\6\u0087\n\6\3\7\5\7\u008a\n\7\3\7\5"+
		"\7\u008d\n\7\5\7\u008f\n\7\3\7\3\7\5\7\u0093\n\7\3\7\5\7\u0096\n\7\5\7"+
		"\u0098\n\7\3\7\5\7\u009b\n\7\3\b\3\b\3\b\5\b\u00a0\n\b\3\t\5\t\u00a3\n"+
		"\t\3\t\6\t\u00a6\n\t\r\t\16\t\u00a7\3\t\3\t\3\t\3\t\7\t\u00ae\n\t\f\t"+
		"\16\t\u00b1\13\t\5\t\u00b3\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bc\n"+
		"\n\3\n\3\n\3\n\5\n\u00c1\n\n\3\n\3\n\5\n\u00c5\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00ce\n\n\3\n\5\n\u00d1\n\n\5\n\u00d3\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ee\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0103\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u010f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0117\n\13\3"+
		"\13\3\13\3\13\5\13\u011c\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0131\n\13"+
		"\3\13\7\13\u0134\n\13\f\13\16\13\u0137\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0141\n\f\3\r\3\r\3\r\7\r\u0146\n\r\f\r\16\r\u0149\13\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u0163\n\23\f\23\16"+
		"\23\u0166\13\23\3\23\3\23\3\24\3\24\3\24\5\24\u016d\n\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u019c\n\31\3\31\3\31\3\31\3\31\5\31\u01a2\n\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u01b7\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u01c2\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u01c9\n\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u01d1\n\31\7\31\u01d3\n\31\f\31\16\31\u01d6\13"+
		"\31\3\32\3\32\3\32\3\32\3\32\7\32\u01dd\n\32\f\32\16\32\u01e0\13\32\5"+
		"\32\u01e2\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u01eb\n\33\3\34"+
		"\3\34\5\34\u01ef\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u01f8\n"+
		"\34\5\34\u01fa\n\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0207\n\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\5#\u0219\n#\3$\3$\3%\3%\3%\2\4\24\60&\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\7\4\2+:==\3\2\23\25\3"+
		"\2\21\22\3\2\13\16\4\2\21\21\25\25\2\u0288\2J\3\2\2\2\4M\3\2\2\2\6X\3"+
		"\2\2\2\b`\3\2\2\2\n\u0086\3\2\2\2\f\u009a\3\2\2\2\16\u009f\3\2\2\2\20"+
		"\u00a2\3\2\2\2\22\u00d2\3\2\2\2\24\u011b\3\2\2\2\26\u0140\3\2\2\2\30\u0142"+
		"\3\2\2\2\32\u014c\3\2\2\2\34\u014f\3\2\2\2\36\u0152\3\2\2\2 \u0155\3\2"+
		"\2\2\"\u0158\3\2\2\2$\u015d\3\2\2\2&\u0169\3\2\2\2(\u0170\3\2\2\2*\u0175"+
		"\3\2\2\2,\u0178\3\2\2\2.\u017d\3\2\2\2\60\u01a1\3\2\2\2\62\u01d7\3\2\2"+
		"\2\64\u01ea\3\2\2\2\66\u01ec\3\2\2\28\u01fb\3\2\2\2:\u01ff\3\2\2\2<\u0208"+
		"\3\2\2\2>\u020b\3\2\2\2@\u020e\3\2\2\2B\u0211\3\2\2\2D\u0218\3\2\2\2F"+
		"\u021a\3\2\2\2H\u021c\3\2\2\2JK\5\4\3\2KL\7\2\2\3L\3\3\2\2\2MR\5\6\4\2"+
		"NO\7\34\2\2OQ\5\6\4\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2"+
		"\2TR\3\2\2\2UW\7\34\2\2VU\3\2\2\2VW\3\2\2\2W\5\3\2\2\2X]\5\b\5\2YZ\7\36"+
		"\2\2Z\\\5\b\5\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\7\3\2\2\2_]"+
		"\3\2\2\2`e\5\n\6\2ab\7\27\2\2bd\5\n\6\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2f\t\3\2\2\2ge\3\2\2\2hj\5\f\7\2ik\5$\23\2ji\3\2\2\2jk\3\2\2"+
		"\2km\3\2\2\2ln\5*\26\2ml\3\2\2\2mn\3\2\2\2n\u0087\3\2\2\2os\5\32\16\2"+
		"pr\5\34\17\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2vx\5\36\20\2wv\3\2\2\2wx\3\2\2\2x\u0087\3\2\2\2y}\5 \21\2z|\5&\24\2"+
		"{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0082\5(\25\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0085\5*\26\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086h\3\2\2\2\u0086o\3\2\2\2\u0086y\3\2\2\2\u0087\13\3"+
		"\2\2\2\u0088\u008a\5,\27\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008f\3\2\2\2\u008b\u008d\5.\30\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u009b\5\16\b\2\u0091\u0093\5,\27\2\u0092\u0091\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0098\3\2\2\2\u0094\u0096\5.\30\2\u0095"+
		"\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0092\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\5\26\f\2\u009a"+
		"\u008e\3\2\2\2\u009a\u0097\3\2\2\2\u009b\r\3\2\2\2\u009c\u00a0\5F$\2\u009d"+
		"\u00a0\5H%\2\u009e\u00a0\5\20\t\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u009e\3\2\2\2\u00a0\17\3\2\2\2\u00a1\u00a3\7\30\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a6\t\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00b2\3\2\2\2\u00a9\u00aa\7*\2\2\u00aa\u00af\5\22\n\2\u00ab"+
		"\u00ac\7+\2\2\u00ac\u00ae\5\22\n\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\21\3\2\2"+
		"\2\u00b4\u00d3\7&\2\2\u00b5\u00d3\7\'\2\2\u00b6\u00d3\7(\2\2\u00b7\u00d3"+
		"\5F$\2\u00b8\u00d3\7\4\2\2\u00b9\u00bc\5<\37\2\u00ba\u00bc\5:\36\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00d3\3\2\2\2\u00bd\u00d0\7="+
		"\2\2\u00be\u00c0\7.\2\2\u00bf\u00c1\7/\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00d1\7\60\2\2\u00c3\u00c5\7/\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00ce\7,"+
		"\2\2\u00c7\u00ce\7\13\2\2\u00c8\u00ce\7\f\2\2\u00c9\u00ce\7\r\2\2\u00ca"+
		"\u00ce\7\16\2\2\u00cb\u00ce\7\"\2\2\u00cc\u00ce\7#\2\2\u00cd\u00c4\3\2"+
		"\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd"+
		"\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d1\5\24\13\2\u00d0\u00be\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00b4\3\2\2\2\u00d2\u00b5\3\2\2\2\u00d2\u00b6\3\2"+
		"\2\2\u00d2\u00b7\3\2\2\2\u00d2\u00b8\3\2\2\2\u00d2\u00bb\3\2\2\2\u00d2"+
		"\u00bd\3\2\2\2\u00d3\23\3\2\2\2\u00d4\u00d5\b\13\1\2\u00d5\u011c\5\64"+
		"\33\2\u00d6\u011c\7=\2\2\u00d7\u011c\5\66\34\2\u00d8\u011c\58\35\2\u00d9"+
		"\u011c\5B\"\2\u00da\u011c\5@!\2\u00db\u011c\5> \2\u00dc\u011c\5<\37\2"+
		"\u00dd\u011c\5\62\32\2\u00de\u011c\5F$\2\u00df\u011c\7\4\2\2\u00e0\u00ed"+
		"\7\31\2\2\u00e1\u00ee\5\64\33\2\u00e2\u00ee\7=\2\2\u00e3\u00ee\5\66\34"+
		"\2\u00e4\u00ee\58\35\2\u00e5\u00ee\5B\"\2\u00e6\u00ee\5@!\2\u00e7\u00ee"+
		"\5> \2\u00e8\u00ee\5<\37\2\u00e9\u00ee\5\62\32\2\u00ea\u00ee\5F$\2\u00eb"+
		"\u00ee\7\4\2\2\u00ec\u00ee\5\24\13\2\u00ed\u00e1\3\2\2\2\u00ed\u00e2\3"+
		"\2\2\2\u00ed\u00e3\3\2\2\2\u00ed\u00e4\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed"+
		"\u00e6\3\2\2\2\u00ed\u00e7\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ed\u00e9\3\2"+
		"\2\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u011c\3\2\2\2\u00ef\u00f0\7\5\2\2\u00f0\u00f1\5\24\13\2\u00f1\u00f2\7"+
		"+\2\2\u00f2\u00f3\5\24\13\2\u00f3\u00f4\7\6\2\2\u00f4\u011c\3\2\2\2\u00f5"+
		"\u00f6\7\5\2\2\u00f6\u00f7\5\24\13\2\u00f7\u00f8\7-\2\2\u00f8\u00f9\5"+
		"\24\13\2\u00f9\u00fa\7\6\2\2\u00fa\u011c\3\2\2\2\u00fb\u00fc\7\5\2\2\u00fc"+
		"\u00fd\5\24\13\2\u00fd\u00fe\7\6\2\2\u00fe\u011c\3\2\2\2\u00ff\u0100\7"+
		"\5\2\2\u0100\u0102\5\24\13\2\u0101\u0103\7/\2\2\u0102\u0101\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\7,\2\2\u0105\u0106\5\24"+
		"\13\2\u0106\u0107\7\6\2\2\u0107\u011c\3\2\2\2\u0108\u0109\7\5\2\2\u0109"+
		"\u010e\5\24\13\2\u010a\u010f\7.\2\2\u010b\u010f\7\60\2\2\u010c\u010d\7"+
		"/\2\2\u010d\u010f\7\60\2\2\u010e\u010a\3\2\2\2\u010e\u010b\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\6\2\2\u0111\u011c\3\2"+
		"\2\2\u0112\u0113\7\5\2\2\u0113\u0114\5\24\13\2\u0114\u0116\7.\2\2\u0115"+
		"\u0117\7/\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\6\2\2\u011a\u011c\3\2\2\2\u011b"+
		"\u00d4\3\2\2\2\u011b\u00d6\3\2\2\2\u011b\u00d7\3\2\2\2\u011b\u00d8\3\2"+
		"\2\2\u011b\u00d9\3\2\2\2\u011b\u00da\3\2\2\2\u011b\u00db\3\2\2\2\u011b"+
		"\u00dc\3\2\2\2\u011b\u00dd\3\2\2\2\u011b\u00de\3\2\2\2\u011b\u00df\3\2"+
		"\2\2\u011b\u00e0\3\2\2\2\u011b\u00ef\3\2\2\2\u011b\u00f5\3\2\2\2\u011b"+
		"\u00fb\3\2\2\2\u011b\u00ff\3\2\2\2\u011b\u0108\3\2\2\2\u011b\u0112\3\2"+
		"\2\2\u011c\u0135\3\2\2\2\u011d\u011e\f\r\2\2\u011e\u011f\7\37\2\2\u011f"+
		"\u0134\5\24\13\16\u0120\u0121\f\f\2\2\u0121\u0122\t\3\2\2\u0122\u0134"+
		"\5\24\13\r\u0123\u0124\f\13\2\2\u0124\u0125\t\4\2\2\u0125\u0134\5\24\13"+
		"\f\u0126\u0127\f\n\2\2\u0127\u0128\t\5\2\2\u0128\u0134\5\24\13\13\u0129"+
		"\u0130\f\t\2\2\u012a\u0131\7\"\2\2\u012b\u0131\7#\2\2\u012c\u0131\7.\2"+
		"\2\u012d\u012e\7.\2\2\u012e\u0131\7/\2\2\u012f\u0131\7,\2\2\u0130\u012a"+
		"\3\2\2\2\u0130\u012b\3\2\2\2\u0130\u012c\3\2\2\2\u0130\u012d\3\2\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\5\24\13\n\u0133\u011d\3"+
		"\2\2\2\u0133\u0120\3\2\2\2\u0133\u0123\3\2\2\2\u0133\u0126\3\2\2\2\u0133"+
		"\u0129\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\25\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7\7\2\2\u0139\u013a"+
		"\5\4\3\2\u013a\u013b\7\b\2\2\u013b\u0141\3\2\2\2\u013c\u013d\7\7\2\2\u013d"+
		"\u013e\5\26\f\2\u013e\u013f\7\b\2\2\u013f\u0141\3\2\2\2\u0140\u0138\3"+
		"\2\2\2\u0140\u013c\3\2\2\2\u0141\27\3\2\2\2\u0142\u0143\7\61\2\2\u0143"+
		"\u0147\7\5\2\2\u0144\u0146\5\60\31\2\u0145\u0144\3\2\2\2\u0146\u0149\3"+
		"\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\7\6\2\2\u014b\31\3\2\2\2\u014c\u014d\5\30\r"+
		"\2\u014d\u014e\5\n\6\2\u014e\33\3\2\2\2\u014f\u0150\7\62\2\2\u0150\u0151"+
		"\5\32\16\2\u0151\35\3\2\2\2\u0152\u0153\7\62\2\2\u0153\u0154\5\n\6\2\u0154"+
		"\37\3\2\2\2\u0155\u0156\7\63\2\2\u0156\u0157\5\f\7\2\u0157!\3\2\2\2\u0158"+
		"\u0159\7\64\2\2\u0159\u015a\7\5\2\2\u015a\u015b\5\60\31\2\u015b\u015c"+
		"\7\6\2\2\u015c#\3\2\2\2\u015d\u015e\7\64\2\2\u015e\u015f\7\5\2\2\u015f"+
		"\u0164\5\60\31\2\u0160\u0161\7\35\2\2\u0161\u0163\5\60\31\2\u0162\u0160"+
		"\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7\6\2\2\u0168%\3\2\2\2"+
		"\u0169\u016a\5\"\22\2\u016a\u016c\7\7\2\2\u016b\u016d\5\4\3\2\u016c\u016b"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\7\b\2\2\u016f"+
		"\'\3\2\2\2\u0170\u0171\7\65\2\2\u0171\u0172\7\7\2\2\u0172\u0173\5\4\3"+
		"\2\u0173\u0174\7\b\2\2\u0174)\3\2\2\2\u0175\u0176\7\20\2\2\u0176\u0177"+
		"\7=\2\2\u0177+\3\2\2\2\u0178\u0179\5D#\2\u0179\u017a\7\5\2\2\u017a\u017b"+
		"\5\60\31\2\u017b\u017c\7\6\2\2\u017c-\3\2\2\2\u017d\u017e\7)\2\2\u017e"+
		"\u017f\7\5\2\2\u017f\u0180\5\60\31\2\u0180\u0181\7\6\2\2\u0181/\3\2\2"+
		"\2\u0182\u0183\b\31\1\2\u0183\u01a2\5\64\33\2\u0184\u01a2\7=\2\2\u0185"+
		"\u01a2\5\66\34\2\u0186\u01a2\58\35\2\u0187\u01a2\5B\"\2\u0188\u01a2\5"+
		"@!\2\u0189\u01a2\5> \2\u018a\u01a2\5<\37\2\u018b\u01a2\5\62\32\2\u018c"+
		"\u01a2\5F$\2\u018d\u01a2\7\4\2\2\u018e\u019b\7\31\2\2\u018f\u019c\5\64"+
		"\33\2\u0190\u019c\7=\2\2\u0191\u019c\5\66\34\2\u0192\u019c\58\35\2\u0193"+
		"\u019c\5B\"\2\u0194\u019c\5@!\2\u0195\u019c\5> \2\u0196\u019c\5<\37\2"+
		"\u0197\u019c\5\62\32\2\u0198\u019c\5F$\2\u0199\u019c\7\4\2\2\u019a\u019c"+
		"\5\60\31\2\u019b\u018f\3\2\2\2\u019b\u0190\3\2\2\2\u019b\u0191\3\2\2\2"+
		"\u019b\u0192\3\2\2\2\u019b\u0193\3\2\2\2\u019b\u0194\3\2\2\2\u019b\u0195"+
		"\3\2\2\2\u019b\u0196\3\2\2\2\u019b\u0197\3\2\2\2\u019b\u0198\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c\u01a2\3\2\2\2\u019d\u019e\7\5"+
		"\2\2\u019e\u019f\5\60\31\2\u019f\u01a0\7\6\2\2\u01a0\u01a2\3\2\2\2\u01a1"+
		"\u0182\3\2\2\2\u01a1\u0184\3\2\2\2\u01a1\u0185\3\2\2\2\u01a1\u0186\3\2"+
		"\2\2\u01a1\u0187\3\2\2\2\u01a1\u0188\3\2\2\2\u01a1\u0189\3\2\2\2\u01a1"+
		"\u018a\3\2\2\2\u01a1\u018b\3\2\2\2\u01a1\u018c\3\2\2\2\u01a1\u018d\3\2"+
		"\2\2\u01a1\u018e\3\2\2\2\u01a1\u019d\3\2\2\2\u01a2\u01d4\3\2\2\2\u01a3"+
		"\u01a4\f\r\2\2\u01a4\u01a5\7\37\2\2\u01a5\u01d3\5\60\31\16\u01a6\u01a7"+
		"\f\f\2\2\u01a7\u01a8\t\3\2\2\u01a8\u01d3\5\60\31\r\u01a9\u01aa\f\13\2"+
		"\2\u01aa\u01ab\t\4\2\2\u01ab\u01d3\5\60\31\f\u01ac\u01ad\f\n\2\2\u01ad"+
		"\u01ae\t\5\2\2\u01ae\u01d3\5\60\31\13\u01af\u01b6\f\t\2\2\u01b0\u01b7"+
		"\7\"\2\2\u01b1\u01b7\7#\2\2\u01b2\u01b7\7.\2\2\u01b3\u01b4\7.\2\2\u01b4"+
		"\u01b7\7/\2\2\u01b5\u01b7\7,\2\2\u01b6\u01b0\3\2\2\2\u01b6\u01b1\3\2\2"+
		"\2\u01b6\u01b2\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8"+
		"\3\2\2\2\u01b8\u01d3\5\60\31\n\u01b9\u01ba\f\b\2\2\u01ba\u01bb\7+\2\2"+
		"\u01bb\u01d3\5\60\31\t\u01bc\u01bd\f\7\2\2\u01bd\u01be\7-\2\2\u01be\u01d3"+
		"\5\60\31\b\u01bf\u01c1\f\5\2\2\u01c0\u01c2\7/\2\2\u01c1\u01c0\3\2\2\2"+
		"\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\7,\2\2\u01c4\u01d3"+
		"\5\60\31\6\u01c5\u01c6\f\3\2\2\u01c6\u01c8\7.\2\2\u01c7\u01c9\7/\2\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01d3\5\60"+
		"\31\4\u01cb\u01d0\f\4\2\2\u01cc\u01d1\7.\2\2\u01cd\u01d1\7\60\2\2\u01ce"+
		"\u01cf\7/\2\2\u01cf\u01d1\7\60\2\2\u01d0\u01cc\3\2\2\2\u01d0\u01cd\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01a3\3\2\2\2\u01d2"+
		"\u01a6\3\2\2\2\u01d2\u01a9\3\2\2\2\u01d2\u01ac\3\2\2\2\u01d2\u01af\3\2"+
		"\2\2\u01d2\u01b9\3\2\2\2\u01d2\u01bc\3\2\2\2\u01d2\u01bf\3\2\2\2\u01d2"+
		"\u01c5\3\2\2\2\u01d2\u01cb\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2"+
		"\2\2\u01d4\u01d5\3\2\2\2\u01d5\61\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8"+
		"\7=\2\2\u01d8\u01e1\7\5\2\2\u01d9\u01de\5\60\31\2\u01da\u01db\7\35\2\2"+
		"\u01db\u01dd\5\60\31\2\u01dc\u01da\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc"+
		"\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1"+
		"\u01d9\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\7\6"+
		"\2\2\u01e4\63\3\2\2\2\u01e5\u01e6\7\22\2\2\u01e6\u01eb\7;\2\2\u01e7\u01eb"+
		"\7;\2\2\u01e8\u01eb\7<\2\2\u01e9\u01eb\7\60\2\2\u01ea\u01e5\3\2\2\2\u01ea"+
		"\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb\65\3\2\2"+
		"\2\u01ec\u01ee\7!\2\2\u01ed\u01ef\7\22\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef"+
		"\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f9\7=\2\2\u01f1\u01f2\7\33\2\2\u01f2"+
		"\u01fa\7=\2\2\u01f3\u01f4\7 \2\2\u01f4\u01f8\7:\2\2\u01f5\u01f6\7 \2\2"+
		"\u01f6\u01f8\79\2\2\u01f7\u01f3\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01fa"+
		"\3\2\2\2\u01f9\u01f1\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa"+
		"\67\3\2\2\2\u01fb\u01fc\7!\2\2\u01fc\u01fd\7!\2\2\u01fd\u01fe\7=\2\2\u01fe"+
		"9\3\2\2\2\u01ff\u0200\7!\2\2\u0200\u0201\t\6\2\2\u0201\u0206\7=\2\2\u0202"+
		"\u0203\7\33\2\2\u0203\u0207\7=\2\2\u0204\u0205\7\30\2\2\u0205\u0207\7"+
		"=\2\2\u0206\u0202\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		";\3\2\2\2\u0208\u0209\7!\2\2\u0209\u020a\7\23\2\2\u020a=\3\2\2\2\u020b"+
		"\u020c\7!\2\2\u020c\u020d\7\32\2\2\u020d?\3\2\2\2\u020e\u020f\7!\2\2\u020f"+
		"\u0210\7\31\2\2\u0210A\3\2\2\2\u0211\u0212\7\33\2\2\u0212\u0213\7=\2\2"+
		"\u0213C\3\2\2\2\u0214\u0219\3\2\2\2\u0215\u0219\7\66\2\2\u0216\u0219\7"+
		"\67\2\2\u0217\u0219\78\2\2\u0218\u0214\3\2\2\2\u0218\u0215\3\2\2\2\u0218"+
		"\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219E\3\2\2\2\u021a\u021b\7\3\2\2"+
		"\u021bG\3\2\2\2\u021c\u021d\7\4\2\2\u021dI\3\2\2\2<RV]ejmsw}\u0081\u0084"+
		"\u0086\u0089\u008c\u008e\u0092\u0095\u0097\u009a\u009f\u00a2\u00a7\u00af"+
		"\u00b2\u00bb\u00c0\u00c4\u00cd\u00d0\u00d2\u00ed\u0102\u010e\u0116\u011b"+
		"\u0130\u0133\u0135\u0140\u0147\u0164\u016c\u019b\u01a1\u01b6\u01c1\u01c8"+
		"\u01d0\u01d2\u01d4\u01de\u01e1\u01ea\u01ee\u01f7\u01f9\u0206\u0218";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}