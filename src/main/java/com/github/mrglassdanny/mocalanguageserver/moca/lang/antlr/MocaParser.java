// Generated from Moca.g4 by ANTLR 4.5.3

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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
		CATCH=46, FINALLY=47, REMOTE=48, PARALLEL=49, INPARALLEL=50, NUMERIC_LITERAL=51, 
		STRING_LITERAL=52, WORD=53, BLOCK_COMMENT=54, WHITESPACE=55, NEWLINE=56;
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
		RULE_moca_onstack_directive = 40, RULE_moca_oldvar_directive = 41, RULE_moca_at_plus_oldvar_directive = 42, 
		RULE_moca_at_mod_oldvar_directive = 43, RULE_moca_type_cast_variable = 44, 
		RULE_moca_database_qualifier_variable = 45, RULE_moca_integration_variable = 46, 
		RULE_moca_remote_keyword = 47, RULE_sql_script = 48, RULE_groovy_script = 49;
	public static final String[] ruleNames = {
		"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
		"verb_noun_clause", "verb_noun_clause_args", "verb_noun_clause_arg", "sub_sequence", 
		"if_expr", "if_statement", "else_if_statement", "else_statement", "try_block", 
		"catch_single_expr", "catch_multi_expr", "catch_sequence", "finally_sequence", 
		"moca_redirect_expr", "moca_remote_expr", "expr", "function_expr", "literal_value", 
		"moca_variable", "moca_plus_variable", "moca_at_variable", "moca_environment_variable", 
		"moca_at_minus_variable", "moca_at_plus_variable", "moca_at_mod_variable", 
		"moca_at_star", "moca_at_question", "moca_at_bang", "moca_keep_directive", 
		"moca_at_keep_directive", "moca_at_minus_keep_directive", "moca_at_plus_keep_directive", 
		"moca_at_mod_keep_directive", "moca_onstack_directive", "moca_oldvar_directive", 
		"moca_at_plus_oldvar_directive", "moca_at_mod_oldvar_directive", "moca_type_cast_variable", 
		"moca_database_qualifier_variable", "moca_integration_variable", "moca_remote_keyword", 
		"sql_script", "groovy_script"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'keep'", "'onstack'", "'('", "')'", "'{'", "'}'", "'<'", "'>'", 
		"'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'\\'", 
		"'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", "'#'", 
		"'@'", "'='", null, "'.'", null, null, "'<<OVERSTACKED_ARGS>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
		"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
		"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
		"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
		"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", 
		"MOCA_INTEGRATOR_OVERSTACKED_ARGS", "WHERE", "AND", "LIKE", "OR", "IS", 
		"NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", "FINALLY", "REMOTE", "PARALLEL", 
		"INPARALLEL", "NUMERIC_LITERAL", "STRING_LITERAL", "WORD", "BLOCK_COMMENT", 
		"WHITESPACE", "NEWLINE"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_script(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_scriptContext moca_script() throws RecognitionException {
		Moca_scriptContext _localctx = new Moca_scriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_moca_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			sequence();
			setState(101);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
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
			setState(103);
			stream();
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(SEMI_COLON);
					setState(105);
					stream();
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(112);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(111);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitStream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StreamContext stream() throws RecognitionException {
		StreamContext _localctx = new StreamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stream);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			group();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(115);
				match(PIPE);
				setState(116);
				group();
				}
				}
				setState(121);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			statement();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(123);
				match(AMPERSAND);
				setState(124);
				statement();
				}
				}
				setState(129);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
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
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(130);
				block();
				setState(132);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(131);
					catch_multi_expr();
					}
				}

				setState(135);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(134);
					moca_redirect_expr();
					}
				}

				}
				break;
			case 2:
				{
				setState(137);
				if_statement();
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138);
						else_if_statement();
						}
						} 
					}
					setState(143);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(144);
					else_statement();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(147);
				try_block();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(148);
					catch_sequence();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(155);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(154);
					finally_sequence();
					}
				}

				setState(158);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(157);
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
		public Moca_remote_exprContext moca_remote_expr() {
			return getRuleContext(Moca_remote_exprContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(162);
					moca_remote_expr();
					}
					break;
				}
				setState(165);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL))) != 0)) {
					{
					setState(166);
					moca_remote_expr();
					}
				}

				setState(169);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_command);
		try {
			setState(175);
			switch (_input.LA(1)) {
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				sql_script();
				}
				break;
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
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
				setState(174);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVerb_noun_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVerb_noun_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVerb_noun_clause(this);
			else return visitor.visitChildren(this);
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
			setState(178);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(177);
				match(CARET);
				}
			}

			setState(181); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(180);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(183); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(187);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(185);
				match(WHERE);
				setState(186);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVerb_noun_clause_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVerb_noun_clause_args(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVerb_noun_clause_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Verb_noun_clause_argsContext verb_noun_clause_args() throws RecognitionException {
		Verb_noun_clause_argsContext _localctx = new Verb_noun_clause_argsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_verb_noun_clause_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			verb_noun_clause_arg();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(190);
				match(AND);
				setState(191);
				verb_noun_clause_arg();
				}
				}
				setState(196);
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
		public TerminalNode DOUBLE_BRACKET_STRING() { return getToken(MocaParser.DOUBLE_BRACKET_STRING, 0); }
		public TerminalNode MOCA_INTEGRATOR_OVERSTACKED_ARGS() { return getToken(MocaParser.MOCA_INTEGRATOR_OVERSTACKED_ARGS, 0); }
		public Moca_at_starContext moca_at_star() {
			return getRuleContext(Moca_at_starContext.class,0);
		}
		public Moca_plus_variableContext moca_plus_variable() {
			return getRuleContext(Moca_plus_variableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVerb_noun_clause_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Verb_noun_clause_argContext verb_noun_clause_arg() throws RecognitionException {
		Verb_noun_clause_argContext _localctx = new Verb_noun_clause_argContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_verb_noun_clause_arg);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(DOUBLE_BRACKET_STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(MOCA_INTEGRATOR_OVERSTACKED_ARGS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(200);
					moca_at_star();
					}
					break;
				case 2:
					{
					setState(201);
					moca_plus_variable();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				expr(0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSub_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sub_sequenceContext sub_sequence() throws RecognitionException {
		Sub_sequenceContext _localctx = new Sub_sequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sub_sequence);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(LEFT_BRACE);
				setState(208);
				sequence();
				setState(209);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(LEFT_BRACE);
				setState(212);
				sub_sequence();
				setState(213);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(IF);
			setState(218);
			match(LEFT_PAREN);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				{
				setState(219);
				expr(0);
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			if_expr();
			setState(228);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitElse_if_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ELSE);
			setState(231);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(ELSE);
			setState(234);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitTry_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_blockContext try_block() throws RecognitionException {
		Try_blockContext _localctx = new Try_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(TRY);
			setState(237);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitCatch_single_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_single_exprContext catch_single_expr() throws RecognitionException {
		Catch_single_exprContext _localctx = new Catch_single_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_catch_single_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(CATCH);
			setState(240);
			match(LEFT_PAREN);
			setState(241);
			expr(0);
			setState(242);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitCatch_multi_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_multi_exprContext catch_multi_expr() throws RecognitionException {
		Catch_multi_exprContext _localctx = new Catch_multi_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_catch_multi_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(CATCH);
			setState(245);
			match(LEFT_PAREN);
			setState(246);
			expr(0);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247);
				match(COMMA);
				setState(248);
				expr(0);
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitCatch_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_sequenceContext catch_sequence() throws RecognitionException {
		Catch_sequenceContext _localctx = new Catch_sequenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_catch_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			catch_single_expr();
			setState(257);
			match(LEFT_BRACE);
			setState(259);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << CARET) | (1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << WORD))) != 0)) {
				{
				setState(258);
				sequence();
				}
			}

			setState(261);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitFinally_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Finally_sequenceContext finally_sequence() throws RecognitionException {
		Finally_sequenceContext _localctx = new Finally_sequenceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_finally_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(FINALLY);
			setState(264);
			match(LEFT_BRACE);
			setState(265);
			sequence();
			setState(266);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_redirect_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_redirect_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_redirect_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_redirect_exprContext moca_redirect_expr() throws RecognitionException {
		Moca_redirect_exprContext _localctx = new Moca_redirect_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_moca_redirect_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(DOUBLE_GREATER);
			setState(269);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public Moca_remote_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_remote_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_remote_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_remote_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_remote_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_remote_exprContext moca_remote_expr() throws RecognitionException {
		Moca_remote_exprContext _localctx = new Moca_remote_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_moca_remote_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			moca_remote_keyword();
			setState(272);
			match(LEFT_PAREN);
			setState(273);
			expr(0);
			setState(274);
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
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public TerminalNode DOUBLE_BRACKET_STRING() { return getToken(MocaParser.DOUBLE_BRACKET_STRING, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(277);
				literal_value();
				}
				break;
			case 2:
				{
				setState(278);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(279);
				moca_variable();
				}
				break;
			case 4:
				{
				setState(280);
				moca_at_bang();
				}
				break;
			case 5:
				{
				setState(281);
				moca_at_question();
				}
				break;
			case 6:
				{
				setState(282);
				moca_at_star();
				}
				break;
			case 7:
				{
				setState(283);
				function_expr();
				}
				break;
			case 8:
				{
				setState(284);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 9:
				{
				setState(285);
				match(DOUBLE_BRACKET_STRING);
				}
				break;
			case 10:
				{
				{
				setState(286);
				match(BANG);
				setState(295);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(287);
					literal_value();
					}
					break;
				case 2:
					{
					setState(288);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(289);
					moca_variable();
					}
					break;
				case 4:
					{
					setState(290);
					moca_at_bang();
					}
					break;
				case 5:
					{
					setState(291);
					moca_at_question();
					}
					break;
				case 6:
					{
					setState(292);
					moca_at_star();
					}
					break;
				case 7:
					{
					setState(293);
					function_expr();
					}
					break;
				case 8:
					{
					setState(294);
					expr(0);
					}
					break;
				}
				}
				}
				break;
			case 11:
				{
				setState(297);
				match(LEFT_PAREN);
				setState(298);
				expr(0);
				setState(299);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(304);
						match(DOUBLE_PIPE);
						setState(305);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(307);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(308);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(310);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(311);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(312);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(313);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(314);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(315);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(322);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
						case 1:
							{
							setState(316);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(317);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(318);
							match(IS);
							}
							break;
						case 4:
							{
							setState(319);
							match(IS);
							setState(320);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(321);
							match(LIKE);
							}
							break;
						}
						setState(324);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(326);
						match(AND);
						setState(327);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(328);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(329);
						match(OR);
						setState(330);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(333);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(332);
							match(NOT);
							}
						}

						{
						setState(335);
						match(LIKE);
						}
						setState(336);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(338);
						match(IS);
						setState(340);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(339);
							match(NOT);
							}
						}

						setState(342);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(343);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(348);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(344);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(345);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(346);
							match(NOT);
							setState(347);
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
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitFunction_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_exprContext function_expr() throws RecognitionException {
		Function_exprContext _localctx = new Function_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(WORD);
			setState(356);
			match(LEFT_PAREN);
			setState(365);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				setState(357);
				expr(0);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358);
					match(COMMA);
					setState(359);
					expr(0);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(367);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal_value);
		try {
			setState(374);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(MINUS);
				setState(370);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(373);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_variableContext moca_variable() throws RecognitionException {
		Moca_variableContext _localctx = new Moca_variableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_moca_variable);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				moca_at_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				moca_at_minus_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				moca_environment_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				moca_keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(380);
				moca_onstack_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(381);
				moca_type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(382);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_plus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_plus_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_plus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_plus_variableContext moca_plus_variable() throws RecognitionException {
		Moca_plus_variableContext _localctx = new Moca_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_moca_plus_variable);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				moca_at_plus_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				moca_at_mod_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
				moca_oldvar_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_variableContext moca_at_variable() throws RecognitionException {
		Moca_at_variableContext _localctx = new Moca_at_variableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_moca_at_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(AT);
			setState(392);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_environment_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_environment_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_environment_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_environment_variableContext moca_environment_variable() throws RecognitionException {
		Moca_environment_variableContext _localctx = new Moca_environment_variableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_moca_environment_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(AT);
			setState(395);
			match(AT);
			setState(396);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_minus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_minus_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_minus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_minus_variableContext moca_at_minus_variable() throws RecognitionException {
		Moca_at_minus_variableContext _localctx = new Moca_at_minus_variableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_moca_at_minus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(AT);
			setState(399);
			match(MINUS);
			setState(400);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_plus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_plus_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_plus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_plus_variableContext moca_at_plus_variable() throws RecognitionException {
		Moca_at_plus_variableContext _localctx = new Moca_at_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_moca_at_plus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(AT);
			setState(403);
			match(PLUS);
			setState(404);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_mod_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_mod_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_mod_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_mod_variableContext moca_at_mod_variable() throws RecognitionException {
		Moca_at_mod_variableContext _localctx = new Moca_at_mod_variableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_moca_at_mod_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(AT);
			setState(407);
			match(MOD);
			setState(408);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_star(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_star(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_star(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_starContext moca_at_star() throws RecognitionException {
		Moca_at_starContext _localctx = new Moca_at_starContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_moca_at_star);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(AT);
			setState(411);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_questionContext moca_at_question() throws RecognitionException {
		Moca_at_questionContext _localctx = new Moca_at_questionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_moca_at_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(AT);
			setState(414);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_bang(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_bang(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_bang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_bangContext moca_at_bang() throws RecognitionException {
		Moca_at_bangContext _localctx = new Moca_at_bangContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_moca_at_bang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(AT);
			setState(417);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_keep_directiveContext moca_keep_directive() throws RecognitionException {
		Moca_keep_directiveContext _localctx = new Moca_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_moca_keep_directive);
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				moca_at_keep_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_keep_directiveContext moca_at_keep_directive() throws RecognitionException {
		Moca_at_keep_directiveContext _localctx = new Moca_at_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_moca_at_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			moca_at_variable();
			setState(424);
			match(POUND);
			setState(425);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_minus_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_minus_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_minus_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_minus_keep_directiveContext moca_at_minus_keep_directive() throws RecognitionException {
		Moca_at_minus_keep_directiveContext _localctx = new Moca_at_minus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_moca_at_minus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			moca_at_minus_variable();
			setState(428);
			match(POUND);
			setState(429);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_plus_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_plus_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_plus_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_plus_keep_directiveContext moca_at_plus_keep_directive() throws RecognitionException {
		Moca_at_plus_keep_directiveContext _localctx = new Moca_at_plus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_moca_at_plus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			moca_at_plus_variable();
			setState(432);
			match(POUND);
			setState(433);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_mod_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_mod_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_mod_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_mod_keep_directiveContext moca_at_mod_keep_directive() throws RecognitionException {
		Moca_at_mod_keep_directiveContext _localctx = new Moca_at_mod_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_moca_at_mod_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			moca_at_mod_variable();
			setState(436);
			match(POUND);
			setState(437);
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
		public Moca_at_minus_variableContext moca_at_minus_variable() {
			return getRuleContext(Moca_at_minus_variableContext.class,0);
		}
		public Moca_onstack_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moca_onstack_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_onstack_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_onstack_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_onstack_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_onstack_directiveContext moca_onstack_directive() throws RecognitionException {
		Moca_onstack_directiveContext _localctx = new Moca_onstack_directiveContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_moca_onstack_directive);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				moca_at_variable();
				setState(440);
				match(POUND);
				setState(441);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				moca_at_minus_variable();
				setState(444);
				match(POUND);
				setState(445);
				match(T__1);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_oldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_oldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_oldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_oldvar_directiveContext moca_oldvar_directive() throws RecognitionException {
		Moca_oldvar_directiveContext _localctx = new Moca_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_moca_oldvar_directive);
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				moca_at_plus_oldvar_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_plus_oldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_plus_oldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_plus_oldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_plus_oldvar_directiveContext moca_at_plus_oldvar_directive() throws RecognitionException {
		Moca_at_plus_oldvar_directiveContext _localctx = new Moca_at_plus_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_moca_at_plus_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			moca_at_plus_variable();
			setState(454);
			match(CARET);
			setState(455);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_at_mod_oldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_at_mod_oldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_at_mod_oldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_at_mod_oldvar_directiveContext moca_at_mod_oldvar_directive() throws RecognitionException {
		Moca_at_mod_oldvar_directiveContext _localctx = new Moca_at_mod_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_moca_at_mod_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			moca_at_mod_variable();
			setState(458);
			match(CARET);
			setState(459);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_type_cast_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_type_cast_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_type_cast_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_type_cast_variableContext moca_type_cast_variable() throws RecognitionException {
		Moca_type_cast_variableContext _localctx = new Moca_type_cast_variableContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_moca_type_cast_variable);
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				moca_at_variable();
				setState(462);
				match(COLON);
				setState(463);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				moca_at_plus_variable();
				setState(466);
				match(COLON);
				setState(467);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_database_qualifier_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_database_qualifier_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_database_qualifier_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_database_qualifier_variableContext moca_database_qualifier_variable() throws RecognitionException {
		Moca_database_qualifier_variableContext _localctx = new Moca_database_qualifier_variableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_moca_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			moca_at_plus_variable();
			setState(472);
			match(DOT);
			setState(473);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_integration_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_integration_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_integration_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_integration_variableContext moca_integration_variable() throws RecognitionException {
		Moca_integration_variableContext _localctx = new Moca_integration_variableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_moca_integration_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(COLON);
			setState(476);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_remote_keyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_remote_keyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_remote_keyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_remote_keywordContext moca_remote_keyword() throws RecognitionException {
		Moca_remote_keywordContext _localctx = new Moca_remote_keywordContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_moca_remote_keyword);
		try {
			setState(482);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case REMOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(479);
				match(REMOTE);
				}
				break;
			case PARALLEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(480);
				match(PARALLEL);
				}
				break;
			case INPARALLEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(481);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterSql_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitSql_script(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSql_script(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_scriptContext sql_script() throws RecognitionException {
		Sql_scriptContext _localctx = new Sql_scriptContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterGroovy_script(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitGroovy_script(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitGroovy_script(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Groovy_scriptContext groovy_script() throws RecognitionException {
		Groovy_scriptContext _localctx = new Groovy_scriptContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u01eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\5\3s\n\3\3\4\3\4\3\4\7\4"+
		"x\n\4\f\4\16\4{\13\4\3\5\3\5\3\5\7\5\u0080\n\5\f\5\16\5\u0083\13\5\3\6"+
		"\3\6\5\6\u0087\n\6\3\6\5\6\u008a\n\6\3\6\3\6\7\6\u008e\n\6\f\6\16\6\u0091"+
		"\13\6\3\6\5\6\u0094\n\6\3\6\3\6\7\6\u0098\n\6\f\6\16\6\u009b\13\6\3\6"+
		"\5\6\u009e\n\6\3\6\5\6\u00a1\n\6\5\6\u00a3\n\6\3\7\5\7\u00a6\n\7\3\7\3"+
		"\7\5\7\u00aa\n\7\3\7\5\7\u00ad\n\7\3\b\3\b\3\b\5\b\u00b2\n\b\3\t\5\t\u00b5"+
		"\n\t\3\t\6\t\u00b8\n\t\r\t\16\t\u00b9\3\t\3\t\5\t\u00be\n\t\3\n\3\n\3"+
		"\n\7\n\u00c3\n\n\f\n\16\n\u00c6\13\n\3\13\3\13\3\13\3\13\3\13\5\13\u00cd"+
		"\n\13\3\13\5\13\u00d0\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00da\n"+
		"\f\3\r\3\r\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u00fc\n\23\f\23\16\23\u00ff\13\23\3\23"+
		"\3\23\3\24\3\24\3\24\5\24\u0106\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u012a\n\30\3\30\3\30\3\30\3\30\5\30\u0130\n\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0145\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0150\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0157\n\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\5\30\u015f\n\30\7\30\u0161\n\30\f\30\16\30\u0164\13\30\3"+
		"\31\3\31\3\31\3\31\3\31\7\31\u016b\n\31\f\31\16\31\u016e\13\31\5\31\u0170"+
		"\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0179\n\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0182\n\33\3\34\3\34\3\34\3\34\5\34\u0188\n"+
		"\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\5%\u01a8\n%\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\5"+
		"*\u01c2\n*\3+\3+\5+\u01c6\n+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3"+
		".\3.\3.\5.\u01d8\n.\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\5\61"+
		"\u01e5\n\61\3\62\3\62\3\63\3\63\3\63\2\3.\64\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\6\4\2\'\64"+
		"\67\67\3\2\21\23\3\2\17\20\3\2\t\f\u020f\2f\3\2\2\2\4i\3\2\2\2\6t\3\2"+
		"\2\2\b|\3\2\2\2\n\u00a2\3\2\2\2\f\u00ac\3\2\2\2\16\u00b1\3\2\2\2\20\u00b4"+
		"\3\2\2\2\22\u00bf\3\2\2\2\24\u00cf\3\2\2\2\26\u00d9\3\2\2\2\30\u00db\3"+
		"\2\2\2\32\u00e5\3\2\2\2\34\u00e8\3\2\2\2\36\u00eb\3\2\2\2 \u00ee\3\2\2"+
		"\2\"\u00f1\3\2\2\2$\u00f6\3\2\2\2&\u0102\3\2\2\2(\u0109\3\2\2\2*\u010e"+
		"\3\2\2\2,\u0111\3\2\2\2.\u012f\3\2\2\2\60\u0165\3\2\2\2\62\u0178\3\2\2"+
		"\2\64\u0181\3\2\2\2\66\u0187\3\2\2\28\u0189\3\2\2\2:\u018c\3\2\2\2<\u0190"+
		"\3\2\2\2>\u0194\3\2\2\2@\u0198\3\2\2\2B\u019c\3\2\2\2D\u019f\3\2\2\2F"+
		"\u01a2\3\2\2\2H\u01a7\3\2\2\2J\u01a9\3\2\2\2L\u01ad\3\2\2\2N\u01b1\3\2"+
		"\2\2P\u01b5\3\2\2\2R\u01c1\3\2\2\2T\u01c5\3\2\2\2V\u01c7\3\2\2\2X\u01cb"+
		"\3\2\2\2Z\u01d7\3\2\2\2\\\u01d9\3\2\2\2^\u01dd\3\2\2\2`\u01e4\3\2\2\2"+
		"b\u01e6\3\2\2\2d\u01e8\3\2\2\2fg\5\4\3\2gh\7\2\2\3h\3\3\2\2\2in\5\6\4"+
		"\2jk\7\32\2\2km\5\6\4\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2"+
		"\2\2pn\3\2\2\2qs\7\32\2\2rq\3\2\2\2rs\3\2\2\2s\5\3\2\2\2ty\5\b\5\2uv\7"+
		"\34\2\2vx\5\b\5\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\7\3\2\2\2{"+
		"y\3\2\2\2|\u0081\5\n\6\2}~\7\25\2\2~\u0080\5\n\6\2\177}\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\t\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0086\5\f\7\2\u0085\u0087\5$\23\2\u0086\u0085\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u008a\5*\26\2\u0089"+
		"\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u00a3\3\2\2\2\u008b\u008f\5\32"+
		"\16\2\u008c\u008e\5\34\17\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0094\5\36\20\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u00a3\3\2\2\2\u0095\u0099\5 \21\2\u0096\u0098\5&\24\2\u0097\u0096\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\5(\25\2\u009d\u009c\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5*\26\2\u00a0"+
		"\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u0084\3\2"+
		"\2\2\u00a2\u008b\3\2\2\2\u00a2\u0095\3\2\2\2\u00a3\13\3\2\2\2\u00a4\u00a6"+
		"\5,\27\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00ad\5\16\b\2\u00a8\u00aa\5,\27\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\5\26\f\2\u00ac\u00a5\3\2\2\2\u00ac"+
		"\u00a9\3\2\2\2\u00ad\r\3\2\2\2\u00ae\u00b2\5b\62\2\u00af\u00b2\5d\63\2"+
		"\u00b0\u00b2\5\20\t\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\17\3\2\2\2\u00b3\u00b5\7\26\2\2\u00b4\u00b3\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b8\t\2\2\2\u00b7\u00b6\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00bc\7&\2\2\u00bc\u00be\5\22\n\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\21\3\2\2\2\u00bf\u00c4\5\24\13\2\u00c0"+
		"\u00c1\7\'\2\2\u00c1\u00c3\5\24\13\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3"+
		"\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\23\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00d0\7$\2\2\u00c8\u00d0\7#\2\2\u00c9\u00d0\7%\2"+
		"\2\u00ca\u00cd\5B\"\2\u00cb\u00cd\5\66\34\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00d0\5.\30\2\u00cf\u00c7\3\2"+
		"\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\25\3\2\2\2\u00d1\u00d2\7\7\2\2\u00d2\u00d3\5\4\3"+
		"\2\u00d3\u00d4\7\b\2\2\u00d4\u00da\3\2\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7"+
		"\5\26\f\2\u00d7\u00d8\7\b\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d1\3\2\2\2"+
		"\u00d9\u00d5\3\2\2\2\u00da\27\3\2\2\2\u00db\u00dc\7-\2\2\u00dc\u00e0\7"+
		"\5\2\2\u00dd\u00df\5.\30\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e3\u00e4\7\6\2\2\u00e4\31\3\2\2\2\u00e5\u00e6\5\30\r\2\u00e6\u00e7"+
		"\5\n\6\2\u00e7\33\3\2\2\2\u00e8\u00e9\7.\2\2\u00e9\u00ea\5\32\16\2\u00ea"+
		"\35\3\2\2\2\u00eb\u00ec\7.\2\2\u00ec\u00ed\5\n\6\2\u00ed\37\3\2\2\2\u00ee"+
		"\u00ef\7/\2\2\u00ef\u00f0\5\f\7\2\u00f0!\3\2\2\2\u00f1\u00f2\7\60\2\2"+
		"\u00f2\u00f3\7\5\2\2\u00f3\u00f4\5.\30\2\u00f4\u00f5\7\6\2\2\u00f5#\3"+
		"\2\2\2\u00f6\u00f7\7\60\2\2\u00f7\u00f8\7\5\2\2\u00f8\u00fd\5.\30\2\u00f9"+
		"\u00fa\7\33\2\2\u00fa\u00fc\5.\30\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3"+
		"\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0101\7\6\2\2\u0101%\3\2\2\2\u0102\u0103\5\"\22\2"+
		"\u0103\u0105\7\7\2\2\u0104\u0106\5\4\3\2\u0105\u0104\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\b\2\2\u0108\'\3\2\2\2\u0109"+
		"\u010a\7\61\2\2\u010a\u010b\7\7\2\2\u010b\u010c\5\4\3\2\u010c\u010d\7"+
		"\b\2\2\u010d)\3\2\2\2\u010e\u010f\7\16\2\2\u010f\u0110\7\67\2\2\u0110"+
		"+\3\2\2\2\u0111\u0112\5`\61\2\u0112\u0113\7\5\2\2\u0113\u0114\5.\30\2"+
		"\u0114\u0115\7\6\2\2\u0115-\3\2\2\2\u0116\u0117\b\30\1\2\u0117\u0130\5"+
		"\62\32\2\u0118\u0130\7\67\2\2\u0119\u0130\5\64\33\2\u011a\u0130\5F$\2"+
		"\u011b\u0130\5D#\2\u011c\u0130\5B\"\2\u011d\u0130\5\60\31\2\u011e\u0130"+
		"\7$\2\2\u011f\u0130\7#\2\2\u0120\u0129\7\27\2\2\u0121\u012a\5\62\32\2"+
		"\u0122\u012a\7\67\2\2\u0123\u012a\5\64\33\2\u0124\u012a\5F$\2\u0125\u012a"+
		"\5D#\2\u0126\u012a\5B\"\2\u0127\u012a\5\60\31\2\u0128\u012a\5.\30\2\u0129"+
		"\u0121\3\2\2\2\u0129\u0122\3\2\2\2\u0129\u0123\3\2\2\2\u0129\u0124\3\2"+
		"\2\2\u0129\u0125\3\2\2\2\u0129\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u0130\3\2\2\2\u012b\u012c\7\5\2\2\u012c\u012d\5."+
		"\30\2\u012d\u012e\7\6\2\2\u012e\u0130\3\2\2\2\u012f\u0116\3\2\2\2\u012f"+
		"\u0118\3\2\2\2\u012f\u0119\3\2\2\2\u012f\u011a\3\2\2\2\u012f\u011b\3\2"+
		"\2\2\u012f\u011c\3\2\2\2\u012f\u011d\3\2\2\2\u012f\u011e\3\2\2\2\u012f"+
		"\u011f\3\2\2\2\u012f\u0120\3\2\2\2\u012f\u012b\3\2\2\2\u0130\u0162\3\2"+
		"\2\2\u0131\u0132\f\r\2\2\u0132\u0133\7\35\2\2\u0133\u0161\5.\30\16\u0134"+
		"\u0135\f\f\2\2\u0135\u0136\t\3\2\2\u0136\u0161\5.\30\r\u0137\u0138\f\13"+
		"\2\2\u0138\u0139\t\4\2\2\u0139\u0161\5.\30\f\u013a\u013b\f\n\2\2\u013b"+
		"\u013c\t\5\2\2\u013c\u0161\5.\30\13\u013d\u0144\f\t\2\2\u013e\u0145\7"+
		" \2\2\u013f\u0145\7!\2\2\u0140\u0145\7*\2\2\u0141\u0142\7*\2\2\u0142\u0145"+
		"\7+\2\2\u0143\u0145\7(\2\2\u0144\u013e\3\2\2\2\u0144\u013f\3\2\2\2\u0144"+
		"\u0140\3\2\2\2\u0144\u0141\3\2\2\2\u0144\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0161\5.\30\n\u0147\u0148\f\b\2\2\u0148\u0149\7\'\2\2\u0149"+
		"\u0161\5.\30\t\u014a\u014b\f\7\2\2\u014b\u014c\7)\2\2\u014c\u0161\5.\30"+
		"\b\u014d\u014f\f\5\2\2\u014e\u0150\7+\2\2\u014f\u014e\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\7(\2\2\u0152\u0161\5.\30\6\u0153"+
		"\u0154\f\3\2\2\u0154\u0156\7*\2\2\u0155\u0157\7+\2\2\u0156\u0155\3\2\2"+
		"\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0161\5.\30\4\u0159\u015e"+
		"\f\4\2\2\u015a\u015f\7*\2\2\u015b\u015f\7,\2\2\u015c\u015d\7+\2\2\u015d"+
		"\u015f\7,\2\2\u015e\u015a\3\2\2\2\u015e\u015b\3\2\2\2\u015e\u015c\3\2"+
		"\2\2\u015f\u0161\3\2\2\2\u0160\u0131\3\2\2\2\u0160\u0134\3\2\2\2\u0160"+
		"\u0137\3\2\2\2\u0160\u013a\3\2\2\2\u0160\u013d\3\2\2\2\u0160\u0147\3\2"+
		"\2\2\u0160\u014a\3\2\2\2\u0160\u014d\3\2\2\2\u0160\u0153\3\2\2\2\u0160"+
		"\u0159\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163/\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7\67\2\2\u0166\u016f"+
		"\7\5\2\2\u0167\u016c\5.\30\2\u0168\u0169\7\33\2\2\u0169\u016b\5.\30\2"+
		"\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0167\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7\6\2\2\u0172\61\3\2\2"+
		"\2\u0173\u0174\7\20\2\2\u0174\u0179\7\65\2\2\u0175\u0179\7\65\2\2\u0176"+
		"\u0179\7\66\2\2\u0177\u0179\7,\2\2\u0178\u0173\3\2\2\2\u0178\u0175\3\2"+
		"\2\2\u0178\u0176\3\2\2\2\u0178\u0177\3\2\2\2\u0179\63\3\2\2\2\u017a\u0182"+
		"\58\35\2\u017b\u0182\5<\37\2\u017c\u0182\5:\36\2\u017d\u0182\5H%\2\u017e"+
		"\u0182\5R*\2\u017f\u0182\5Z.\2\u0180\u0182\5^\60\2\u0181\u017a\3\2\2\2"+
		"\u0181\u017b\3\2\2\2\u0181\u017c\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u017e"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182\65\3\2\2\2\u0183"+
		"\u0188\5> \2\u0184\u0188\5@!\2\u0185\u0188\5T+\2\u0186\u0188\5\\/\2\u0187"+
		"\u0183\3\2\2\2\u0187\u0184\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2"+
		"\2\2\u0188\67\3\2\2\2\u0189\u018a\7\37\2\2\u018a\u018b\7\67\2\2\u018b"+
		"9\3\2\2\2\u018c\u018d\7\37\2\2\u018d\u018e\7\37\2\2\u018e\u018f\7\67\2"+
		"\2\u018f;\3\2\2\2\u0190\u0191\7\37\2\2\u0191\u0192\7\20\2\2\u0192\u0193"+
		"\7\67\2\2\u0193=\3\2\2\2\u0194\u0195\7\37\2\2\u0195\u0196\7\17\2\2\u0196"+
		"\u0197\7\67\2\2\u0197?\3\2\2\2\u0198\u0199\7\37\2\2\u0199\u019a\7\23\2"+
		"\2\u019a\u019b\7\67\2\2\u019bA\3\2\2\2\u019c\u019d\7\37\2\2\u019d\u019e"+
		"\7\21\2\2\u019eC\3\2\2\2\u019f\u01a0\7\37\2\2\u01a0\u01a1\7\30\2\2\u01a1"+
		"E\3\2\2\2\u01a2\u01a3\7\37\2\2\u01a3\u01a4\7\27\2\2\u01a4G\3\2\2\2\u01a5"+
		"\u01a8\5J&\2\u01a6\u01a8\5L\'\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2"+
		"\2\u01a8I\3\2\2\2\u01a9\u01aa\58\35\2\u01aa\u01ab\7\36\2\2\u01ab\u01ac"+
		"\7\3\2\2\u01acK\3\2\2\2\u01ad\u01ae\5<\37\2\u01ae\u01af\7\36\2\2\u01af"+
		"\u01b0\7\3\2\2\u01b0M\3\2\2\2\u01b1\u01b2\5> \2\u01b2\u01b3\7\36\2\2\u01b3"+
		"\u01b4\7\3\2\2\u01b4O\3\2\2\2\u01b5\u01b6\5@!\2\u01b6\u01b7\7\36\2\2\u01b7"+
		"\u01b8\7\3\2\2\u01b8Q\3\2\2\2\u01b9\u01ba\58\35\2\u01ba\u01bb\7\36\2\2"+
		"\u01bb\u01bc\7\4\2\2\u01bc\u01c2\3\2\2\2\u01bd\u01be\5<\37\2\u01be\u01bf"+
		"\7\36\2\2\u01bf\u01c0\7\4\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01b9\3\2\2\2"+
		"\u01c1\u01bd\3\2\2\2\u01c2S\3\2\2\2\u01c3\u01c6\5V,\2\u01c4\u01c6\5X-"+
		"\2\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6U\3\2\2\2\u01c7\u01c8"+
		"\5> \2\u01c8\u01c9\7\26\2\2\u01c9\u01ca\7\67\2\2\u01caW\3\2\2\2\u01cb"+
		"\u01cc\5@!\2\u01cc\u01cd\7\26\2\2\u01cd\u01ce\7\67\2\2\u01ceY\3\2\2\2"+
		"\u01cf\u01d0\58\35\2\u01d0\u01d1\7\31\2\2\u01d1\u01d2\7\67\2\2\u01d2\u01d8"+
		"\3\2\2\2\u01d3\u01d4\5> \2\u01d4\u01d5\7\31\2\2\u01d5\u01d6\7\67\2\2\u01d6"+
		"\u01d8\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7\u01d3\3\2\2\2\u01d8[\3\2\2\2"+
		"\u01d9\u01da\5> \2\u01da\u01db\7\"\2\2\u01db\u01dc\7\67\2\2\u01dc]\3\2"+
		"\2\2\u01dd\u01de\7\31\2\2\u01de\u01df\7\67\2\2\u01df_\3\2\2\2\u01e0\u01e5"+
		"\3\2\2\2\u01e1\u01e5\7\62\2\2\u01e2\u01e5\7\63\2\2\u01e3\u01e5\7\64\2"+
		"\2\u01e4\u01e0\3\2\2\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e3"+
		"\3\2\2\2\u01e5a\3\2\2\2\u01e6\u01e7\7$\2\2\u01e7c\3\2\2\2\u01e8\u01e9"+
		"\7#\2\2\u01e9e\3\2\2\2.nry\u0081\u0086\u0089\u008f\u0093\u0099\u009d\u00a0"+
		"\u00a2\u00a5\u00a9\u00ac\u00b1\u00b4\u00b9\u00bd\u00c4\u00cc\u00cf\u00d9"+
		"\u00e0\u00fd\u0105\u0129\u012f\u0144\u014f\u0156\u015e\u0160\u0162\u016c"+
		"\u016f\u0178\u0181\u0187\u01a7\u01c1\u01c5\u01d7\u01e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}