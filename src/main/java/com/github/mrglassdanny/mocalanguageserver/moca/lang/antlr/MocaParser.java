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
		RULE_verb_noun_clause_args = 8, RULE_verb_noun_clause_arg = 9, RULE_verb_noun_clause_arg_expr = 10, 
		RULE_sub_sequence = 11, RULE_if_expr = 12, RULE_if_statement = 13, RULE_else_if_statement = 14, 
		RULE_else_statement = 15, RULE_try_block = 16, RULE_catch_single_expr = 17, 
		RULE_catch_multi_expr = 18, RULE_catch_sequence = 19, RULE_finally_sequence = 20, 
		RULE_moca_redirect_expr = 21, RULE_moca_remote_expr = 22, RULE_expr = 23, 
		RULE_function_expr = 24, RULE_literal_value = 25, RULE_moca_variable = 26, 
		RULE_moca_plus_variable = 27, RULE_moca_at_variable = 28, RULE_moca_environment_variable = 29, 
		RULE_moca_at_minus_variable = 30, RULE_moca_at_plus_variable = 31, RULE_moca_at_mod_variable = 32, 
		RULE_moca_at_star = 33, RULE_moca_at_question = 34, RULE_moca_at_bang = 35, 
		RULE_moca_keep_directive = 36, RULE_moca_at_keep_directive = 37, RULE_moca_at_minus_keep_directive = 38, 
		RULE_moca_at_plus_keep_directive = 39, RULE_moca_at_mod_keep_directive = 40, 
		RULE_moca_onstack_directive = 41, RULE_moca_ignore_directive = 42, RULE_moca_oldvar_directive = 43, 
		RULE_moca_at_plus_oldvar_directive = 44, RULE_moca_at_mod_oldvar_directive = 45, 
		RULE_moca_type_cast_variable = 46, RULE_moca_database_qualifier_variable = 47, 
		RULE_moca_integration_variable = 48, RULE_moca_remote_keyword = 49, RULE_sql_script = 50, 
		RULE_groovy_script = 51;
	public static final String[] ruleNames = {
		"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
		"verb_noun_clause", "verb_noun_clause_args", "verb_noun_clause_arg", "verb_noun_clause_arg_expr", 
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

	private static final String[] _LITERAL_NAMES = {
		null, "'keep'", "'onstack'", "'ignore'", "'('", "')'", "'{'", "'}'", "'<'", 
		"'>'", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'\\'", "'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", 
		"'#'", "'@'", "'='", null, "'.'", null, null, "'<<OVERSTACKED_ARGS>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", 
		"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
		"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
		"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
		"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", 
		"MOCA_INTEGRATOR_OVERSTACKED_ARGS", "WHERE", "AND", "LIKE", "OR", "IS", 
		"NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", "FINALLY", "REMOTE", "PARALLEL", 
		"INPARALLEL", "WORD", "NUMERIC_LITERAL", "STRING_LITERAL", "BLOCK_COMMENT", 
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
			setState(104);
			sequence();
			setState(105);
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
			setState(107);
			stream();
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108);
					match(SEMI_COLON);
					setState(109);
					stream();
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(116);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(115);
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
			setState(118);
			group();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(119);
				match(PIPE);
				setState(120);
				group();
				}
				}
				setState(125);
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
			setState(126);
			statement();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(127);
				match(AMPERSAND);
				setState(128);
				statement();
				}
				}
				setState(133);
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
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(134);
				block();
				setState(136);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(135);
					catch_multi_expr();
					}
				}

				setState(139);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(138);
					moca_redirect_expr();
					}
				}

				}
				break;
			case 2:
				{
				setState(141);
				if_statement();
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(142);
						else_if_statement();
						}
						} 
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(148);
					else_statement();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(151);
				try_block();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(152);
					catch_sequence();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(158);
					finally_sequence();
					}
				}

				setState(162);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(161);
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
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL))) != 0)) {
					{
					setState(167);
					moca_remote_expr();
					}
				}

				setState(170);
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
			setState(176);
			switch (_input.LA(1)) {
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				sql_script();
				}
				break;
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
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
				setState(175);
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
			setState(179);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(178);
				match(CARET);
				}
			}

			setState(182); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(181);
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
				setState(184); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(188);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(186);
				match(WHERE);
				setState(187);
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
			setState(190);
			verb_noun_clause_arg();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(191);
				match(AND);
				setState(192);
				verb_noun_clause_arg();
				}
				}
				setState(197);
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
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr() {
			return getRuleContext(Verb_noun_clause_arg_exprContext.class,0);
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
			setState(222);
			switch (_input.LA(1)) {
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case MOCA_INTEGRATOR_OVERSTACKED_ARGS:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(MOCA_INTEGRATOR_OVERSTACKED_ARGS);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
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
			case WORD:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(204);
				match(WORD);
				setState(219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(205);
					match(IS);
					setState(206);
					match(NULL);
					}
					break;
				case 2:
					{
					setState(207);
					match(IS);
					setState(208);
					match(NOT);
					setState(209);
					match(NULL);
					}
					break;
				case 3:
					{
					setState(210);
					match(EQUAL);
					}
					break;
				case 4:
					{
					setState(211);
					match(NOT_EQUAL);
					}
					break;
				case 5:
					{
					setState(212);
					match(LESS);
					}
					break;
				case 6:
					{
					setState(213);
					match(GREATER);
					}
					break;
				case 7:
					{
					setState(214);
					match(LESS_EQUAL);
					}
					break;
				case 8:
					{
					setState(215);
					match(GREATER_EQUAL);
					}
					break;
				case 9:
					{
					setState(216);
					match(LIKE);
					}
					break;
				case 10:
					{
					setState(217);
					match(NOT);
					setState(218);
					match(LIKE);
					}
					break;
				}
				}
				{
				setState(221);
				verb_noun_clause_arg_expr(0);
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
		public Moca_variableContext moca_variable() {
			return getRuleContext(Moca_variableContext.class,0);
		}
		public Moca_at_bangContext moca_at_bang() {
			return getRuleContext(Moca_at_bangContext.class,0);
		}
		public Moca_at_questionContext moca_at_question() {
			return getRuleContext(Moca_at_questionContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public TerminalNode SINGLE_BRACKET_STRING() { return getToken(MocaParser.SINGLE_BRACKET_STRING, 0); }
		public TerminalNode BANG() { return getToken(MocaParser.BANG, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(MocaParser.LEFT_PAREN, 0); }
		public List<Verb_noun_clause_arg_exprContext> verb_noun_clause_arg_expr() {
			return getRuleContexts(Verb_noun_clause_arg_exprContext.class);
		}
		public Verb_noun_clause_arg_exprContext verb_noun_clause_arg_expr(int i) {
			return getRuleContext(Verb_noun_clause_arg_exprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(MocaParser.RIGHT_PAREN, 0); }
		public TerminalNode DOUBLE_PIPE() { return getToken(MocaParser.DOUBLE_PIPE, 0); }
		public TerminalNode STAR() { return getToken(MocaParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(MocaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MocaParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(MocaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode LIKE() { return getToken(MocaParser.LIKE, 0); }
		public TerminalNode NOT() { return getToken(MocaParser.NOT, 0); }
		public TerminalNode IS() { return getToken(MocaParser.IS, 0); }
		public TerminalNode NULL() { return getToken(MocaParser.NULL, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVerb_noun_clause_arg_expr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_verb_noun_clause_arg_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(225);
				literal_value();
				}
				break;
			case 2:
				{
				setState(226);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(227);
				moca_variable();
				}
				break;
			case 4:
				{
				setState(228);
				moca_at_bang();
				}
				break;
			case 5:
				{
				setState(229);
				moca_at_question();
				}
				break;
			case 6:
				{
				setState(230);
				function_expr();
				}
				break;
			case 7:
				{
				setState(231);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 8:
				{
				{
				setState(232);
				match(BANG);
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(233);
					literal_value();
					}
					break;
				case 2:
					{
					setState(234);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(235);
					moca_variable();
					}
					break;
				case 4:
					{
					setState(236);
					moca_at_bang();
					}
					break;
				case 5:
					{
					setState(237);
					moca_at_question();
					}
					break;
				case 6:
					{
					setState(238);
					function_expr();
					}
					break;
				}
				}
				}
				break;
			case 9:
				{
				setState(241);
				match(LEFT_PAREN);
				setState(242);
				verb_noun_clause_arg_expr(0);
				setState(243);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(247);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(248);
						match(DOUBLE_PIPE);
						setState(249);
						verb_noun_clause_arg_expr(7);
						}
						break;
					case 2:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(250);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(251);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(252);
						verb_noun_clause_arg_expr(6);
						}
						break;
					case 3:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(253);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(254);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(255);
						verb_noun_clause_arg_expr(5);
						}
						break;
					case 4:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(256);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(258);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(257);
							match(NOT);
							}
						}

						{
						setState(260);
						match(LIKE);
						}
						setState(261);
						verb_noun_clause_arg_expr(3);
						}
						break;
					case 5:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(262);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(267);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(263);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(264);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(265);
							match(NOT);
							setState(266);
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
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSub_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sub_sequenceContext sub_sequence() throws RecognitionException {
		Sub_sequenceContext _localctx = new Sub_sequenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sub_sequence);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(LEFT_BRACE);
				setState(275);
				sequence();
				setState(276);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(LEFT_BRACE);
				setState(279);
				sub_sequence();
				setState(280);
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
		enterRule(_localctx, 24, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(IF);
			setState(285);
			match(LEFT_PAREN);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << SINGLE_BRACKET_STRING) | (1L << NULL) | (1L << WORD) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				{
				setState(286);
				expr(0);
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292);
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
		enterRule(_localctx, 26, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			if_expr();
			setState(295);
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
		enterRule(_localctx, 28, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(ELSE);
			setState(298);
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
		enterRule(_localctx, 30, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(ELSE);
			setState(301);
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
		enterRule(_localctx, 32, RULE_try_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(TRY);
			setState(304);
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
		enterRule(_localctx, 34, RULE_catch_single_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(CATCH);
			setState(307);
			match(LEFT_PAREN);
			{
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(308);
				literal_value();
				}
				break;
			case 2:
				{
				setState(309);
				moca_at_question();
				}
				break;
			case 3:
				{
				setState(310);
				moca_at_bang();
				}
				break;
			case 4:
				{
				setState(311);
				match(WORD);
				}
				break;
			case 5:
				{
				setState(312);
				moca_variable();
				}
				break;
			case 6:
				{
				setState(313);
				function_expr();
				}
				break;
			}
			}
			setState(316);
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
		enterRule(_localctx, 36, RULE_catch_multi_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(CATCH);
			setState(319);
			match(LEFT_PAREN);
			{
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(320);
				literal_value();
				}
				break;
			case 2:
				{
				setState(321);
				moca_at_question();
				}
				break;
			case 3:
				{
				setState(322);
				moca_at_bang();
				}
				break;
			case 4:
				{
				setState(323);
				match(WORD);
				}
				break;
			case 5:
				{
				setState(324);
				moca_variable();
				}
				break;
			case 6:
				{
				setState(325);
				function_expr();
				}
				break;
			}
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(328);
				match(COMMA);
				setState(335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(329);
					literal_value();
					}
					break;
				case 2:
					{
					setState(330);
					moca_at_question();
					}
					break;
				case 3:
					{
					setState(331);
					moca_at_bang();
					}
					break;
				case 4:
					{
					setState(332);
					match(WORD);
					}
					break;
				case 5:
					{
					setState(333);
					moca_variable();
					}
					break;
				case 6:
					{
					setState(334);
					function_expr();
					}
					break;
				}
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(342);
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
		enterRule(_localctx, 38, RULE_catch_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			catch_single_expr();
			setState(345);
			match(LEFT_BRACE);
			setState(346);
			sequence();
			setState(347);
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
		enterRule(_localctx, 40, RULE_finally_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(FINALLY);
			setState(350);
			match(LEFT_BRACE);
			setState(351);
			sequence();
			setState(352);
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
		enterRule(_localctx, 42, RULE_moca_redirect_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(DOUBLE_GREATER);
			setState(355);
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
		enterRule(_localctx, 44, RULE_moca_remote_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			moca_remote_keyword();
			setState(358);
			match(LEFT_PAREN);
			setState(362);
			switch (_input.LA(1)) {
			case MINUS:
			case NULL:
			case NUMERIC_LITERAL:
			case STRING_LITERAL:
				{
				setState(359);
				literal_value();
				}
				break;
			case WORD:
				{
				setState(360);
				match(WORD);
				}
				break;
			case COLON:
			case AT:
				{
				setState(361);
				moca_variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(364);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(367);
				literal_value();
				}
				break;
			case 2:
				{
				setState(368);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(369);
				moca_variable();
				}
				break;
			case 4:
				{
				setState(370);
				moca_at_bang();
				}
				break;
			case 5:
				{
				setState(371);
				moca_at_question();
				}
				break;
			case 6:
				{
				setState(372);
				moca_at_star();
				}
				break;
			case 7:
				{
				setState(373);
				function_expr();
				}
				break;
			case 8:
				{
				setState(374);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 9:
				{
				{
				setState(375);
				match(BANG);
				setState(383);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(376);
					literal_value();
					}
					break;
				case 2:
					{
					setState(377);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(378);
					moca_variable();
					}
					break;
				case 4:
					{
					setState(379);
					moca_at_bang();
					}
					break;
				case 5:
					{
					setState(380);
					moca_at_question();
					}
					break;
				case 6:
					{
					setState(381);
					moca_at_star();
					}
					break;
				case 7:
					{
					setState(382);
					function_expr();
					}
					break;
				}
				}
				}
				break;
			case 10:
				{
				setState(385);
				match(LEFT_PAREN);
				setState(386);
				expr(0);
				setState(387);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(438);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(391);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(392);
						match(DOUBLE_PIPE);
						setState(393);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(394);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(395);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(396);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(397);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(398);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(399);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(400);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(401);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(402);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(403);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(410);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
						case 1:
							{
							setState(404);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(405);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(406);
							match(IS);
							}
							break;
						case 4:
							{
							setState(407);
							match(IS);
							setState(408);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(409);
							match(LIKE);
							}
							break;
						}
						setState(412);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(413);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(414);
						match(AND);
						setState(415);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(416);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(417);
						match(OR);
						setState(418);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(419);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(421);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(420);
							match(NOT);
							}
						}

						{
						setState(423);
						match(LIKE);
						}
						setState(424);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(425);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(426);
						match(IS);
						setState(428);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(427);
							match(NOT);
							}
						}

						setState(430);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(431);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(436);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(432);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(433);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(434);
							match(NOT);
							setState(435);
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
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		enterRule(_localctx, 48, RULE_function_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(WORD);
			setState(444);
			match(LEFT_PAREN);
			setState(453);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << SINGLE_BRACKET_STRING) | (1L << NULL) | (1L << WORD) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL))) != 0)) {
				{
				setState(445);
				expr(0);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(446);
					match(COMMA);
					setState(447);
					expr(0);
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(455);
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
		enterRule(_localctx, 50, RULE_literal_value);
		try {
			setState(462);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				match(MINUS);
				setState(458);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(459);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(460);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(461);
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
		enterRule(_localctx, 52, RULE_moca_variable);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(464);
				moca_at_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				moca_at_minus_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				moca_environment_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(467);
				moca_keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(468);
				moca_onstack_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(469);
				moca_type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(470);
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
		enterRule(_localctx, 54, RULE_moca_plus_variable);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				moca_at_plus_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				moca_at_mod_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				moca_oldvar_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(476);
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
		enterRule(_localctx, 56, RULE_moca_at_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(AT);
			setState(480);
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
		enterRule(_localctx, 58, RULE_moca_environment_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(AT);
			setState(483);
			match(AT);
			setState(484);
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
		enterRule(_localctx, 60, RULE_moca_at_minus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(AT);
			setState(487);
			match(MINUS);
			setState(488);
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
		enterRule(_localctx, 62, RULE_moca_at_plus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(AT);
			setState(491);
			match(PLUS);
			setState(492);
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
		enterRule(_localctx, 64, RULE_moca_at_mod_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(AT);
			setState(495);
			match(MOD);
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
		enterRule(_localctx, 66, RULE_moca_at_star);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(AT);
			setState(499);
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
		enterRule(_localctx, 68, RULE_moca_at_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(AT);
			setState(502);
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
		enterRule(_localctx, 70, RULE_moca_at_bang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(AT);
			setState(505);
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
		enterRule(_localctx, 72, RULE_moca_keep_directive);
		try {
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				moca_at_keep_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
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
		enterRule(_localctx, 74, RULE_moca_at_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			moca_at_variable();
			setState(512);
			match(POUND);
			setState(513);
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
		enterRule(_localctx, 76, RULE_moca_at_minus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			moca_at_minus_variable();
			setState(516);
			match(POUND);
			setState(517);
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
		enterRule(_localctx, 78, RULE_moca_at_plus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			moca_at_plus_variable();
			setState(520);
			match(POUND);
			setState(521);
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
		enterRule(_localctx, 80, RULE_moca_at_mod_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			moca_at_mod_variable();
			setState(524);
			match(POUND);
			setState(525);
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
		enterRule(_localctx, 82, RULE_moca_onstack_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			moca_at_variable();
			setState(528);
			match(POUND);
			setState(529);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterMoca_ignore_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitMoca_ignore_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitMoca_ignore_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Moca_ignore_directiveContext moca_ignore_directive() throws RecognitionException {
		Moca_ignore_directiveContext _localctx = new Moca_ignore_directiveContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_moca_ignore_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			moca_at_variable();
			setState(532);
			match(POUND);
			setState(533);
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
		enterRule(_localctx, 86, RULE_moca_oldvar_directive);
		try {
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				moca_at_plus_oldvar_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
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
		enterRule(_localctx, 88, RULE_moca_at_plus_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			moca_at_plus_variable();
			setState(540);
			match(CARET);
			setState(541);
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
		enterRule(_localctx, 90, RULE_moca_at_mod_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			moca_at_mod_variable();
			setState(544);
			match(CARET);
			setState(545);
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
		enterRule(_localctx, 92, RULE_moca_type_cast_variable);
		try {
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				moca_at_variable();
				setState(548);
				match(COLON);
				setState(549);
				match(WORD);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(551);
				moca_at_plus_variable();
				setState(552);
				match(COLON);
				setState(553);
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
		enterRule(_localctx, 94, RULE_moca_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			moca_at_plus_variable();
			setState(558);
			match(DOT);
			setState(559);
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
		enterRule(_localctx, 96, RULE_moca_integration_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(COLON);
			setState(562);
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
		enterRule(_localctx, 98, RULE_moca_remote_keyword);
		try {
			setState(568);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case REMOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(565);
				match(REMOTE);
				}
				break;
			case PARALLEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(566);
				match(PARALLEL);
				}
				break;
			case INPARALLEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(567);
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
		enterRule(_localctx, 100, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
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
		enterRule(_localctx, 102, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
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
		case 10:
			return verb_noun_clause_arg_expr_sempred((Verb_noun_clause_arg_exprContext)_localctx, predIndex);
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean verb_noun_clause_arg_expr_sempred(Verb_noun_clause_arg_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u0241\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\3\2\3\2\3\3\3\3\3\3\7\3q\n\3\f\3\16\3t\13\3\3\3\5\3"+
		"w\n\3\3\4\3\4\3\4\7\4|\n\4\f\4\16\4\177\13\4\3\5\3\5\3\5\7\5\u0084\n\5"+
		"\f\5\16\5\u0087\13\5\3\6\3\6\5\6\u008b\n\6\3\6\5\6\u008e\n\6\3\6\3\6\7"+
		"\6\u0092\n\6\f\6\16\6\u0095\13\6\3\6\5\6\u0098\n\6\3\6\3\6\7\6\u009c\n"+
		"\6\f\6\16\6\u009f\13\6\3\6\5\6\u00a2\n\6\3\6\5\6\u00a5\n\6\5\6\u00a7\n"+
		"\6\3\7\3\7\5\7\u00ab\n\7\3\7\5\7\u00ae\n\7\3\b\3\b\3\b\5\b\u00b3\n\b\3"+
		"\t\5\t\u00b6\n\t\3\t\6\t\u00b9\n\t\r\t\16\t\u00ba\3\t\3\t\5\t\u00bf\n"+
		"\t\3\n\3\n\3\n\7\n\u00c4\n\n\f\n\16\n\u00c7\13\n\3\13\3\13\3\13\3\13\5"+
		"\13\u00cd\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00de\n\13\3\13\5\13\u00e1\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f2\n\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00f8\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u0105\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u010e\n\f\7\f\u0110\n\f\f\f"+
		"\16\f\u0113\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u011d\n\r\3\16\3"+
		"\16\3\16\7\16\u0122\n\16\f\16\16\16\u0125\13\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u013d\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0149\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0152\n\24\7\24\u0154\n\24\f\24\16\24\u0157\13\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u016d\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0182\n\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0188\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u019d\n\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01a8\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u01af\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01b7"+
		"\n\31\7\31\u01b9\n\31\f\31\16\31\u01bc\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u01c3\n\32\f\32\16\32\u01c6\13\32\5\32\u01c8\n\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u01d1\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u01da\n\34\3\35\3\35\3\35\3\35\5\35\u01e0\n\35\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"$\3$\3$\3%\3%\3%\3&\3&\5&\u0200\n&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\5-\u021c\n-\3.\3.\3.\3"+
		".\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u022e\n\60"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u023b\n\63"+
		"\3\64\3\64\3\65\3\65\3\65\2\4\26\60\66\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfh\2\6\3\2(\66\3\2"+
		"\22\24\3\2\20\21\3\2\n\r\u028c\2j\3\2\2\2\4m\3\2\2\2\6x\3\2\2\2\b\u0080"+
		"\3\2\2\2\n\u00a6\3\2\2\2\f\u00ad\3\2\2\2\16\u00b2\3\2\2\2\20\u00b5\3\2"+
		"\2\2\22\u00c0\3\2\2\2\24\u00e0\3\2\2\2\26\u00f7\3\2\2\2\30\u011c\3\2\2"+
		"\2\32\u011e\3\2\2\2\34\u0128\3\2\2\2\36\u012b\3\2\2\2 \u012e\3\2\2\2\""+
		"\u0131\3\2\2\2$\u0134\3\2\2\2&\u0140\3\2\2\2(\u015a\3\2\2\2*\u015f\3\2"+
		"\2\2,\u0164\3\2\2\2.\u0167\3\2\2\2\60\u0187\3\2\2\2\62\u01bd\3\2\2\2\64"+
		"\u01d0\3\2\2\2\66\u01d9\3\2\2\28\u01df\3\2\2\2:\u01e1\3\2\2\2<\u01e4\3"+
		"\2\2\2>\u01e8\3\2\2\2@\u01ec\3\2\2\2B\u01f0\3\2\2\2D\u01f4\3\2\2\2F\u01f7"+
		"\3\2\2\2H\u01fa\3\2\2\2J\u01ff\3\2\2\2L\u0201\3\2\2\2N\u0205\3\2\2\2P"+
		"\u0209\3\2\2\2R\u020d\3\2\2\2T\u0211\3\2\2\2V\u0215\3\2\2\2X\u021b\3\2"+
		"\2\2Z\u021d\3\2\2\2\\\u0221\3\2\2\2^\u022d\3\2\2\2`\u022f\3\2\2\2b\u0233"+
		"\3\2\2\2d\u023a\3\2\2\2f\u023c\3\2\2\2h\u023e\3\2\2\2jk\5\4\3\2kl\7\2"+
		"\2\3l\3\3\2\2\2mr\5\6\4\2no\7\33\2\2oq\5\6\4\2pn\3\2\2\2qt\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2\2\2uw\7\33\2\2vu\3\2\2\2vw\3\2\2\2w\5"+
		"\3\2\2\2x}\5\b\5\2yz\7\35\2\2z|\5\b\5\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2"+
		"\2}~\3\2\2\2~\7\3\2\2\2\177}\3\2\2\2\u0080\u0085\5\n\6\2\u0081\u0082\7"+
		"\26\2\2\u0082\u0084\5\n\6\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\t\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0088\u008a\5\f\7\2\u0089\u008b\5&\24\2\u008a\u0089\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5,\27\2\u008d\u008c\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u00a7\3\2\2\2\u008f\u0093\5\34\17\2\u0090\u0092\5"+
		"\36\20\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\5 "+
		"\21\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00a7\3\2\2\2\u0099"+
		"\u009d\5\"\22\2\u009a\u009c\5(\25\2\u009b\u009a\3\2\2\2\u009c\u009f\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a2\5*\26\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5\5,\27\2\u00a4\u00a3\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0088\3\2\2\2\u00a6\u008f\3\2"+
		"\2\2\u00a6\u0099\3\2\2\2\u00a7\13\3\2\2\2\u00a8\u00ae\5\16\b\2\u00a9\u00ab"+
		"\5.\30\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\5\30\r\2\u00ad\u00a8\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae\r\3\2\2"+
		"\2\u00af\u00b3\5f\64\2\u00b0\u00b3\5h\65\2\u00b1\u00b3\5\20\t\2\u00b2"+
		"\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\17\3\2\2"+
		"\2\u00b4\u00b6\7\27\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b9\t\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00bd\7\'\2\2\u00bd\u00bf\5\22\n\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3"+
		"\2\2\2\u00bf\21\3\2\2\2\u00c0\u00c5\5\24\13\2\u00c1\u00c2\7(\2\2\u00c2"+
		"\u00c4\5\24\13\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\23\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00e1\7%\2\2\u00c9\u00e1\7&\2\2\u00ca\u00cd\5D#\2\u00cb\u00cd\58\35\2"+
		"\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00e1\3\2\2\2\u00ce\u00dd"+
		"\7\66\2\2\u00cf\u00d0\7+\2\2\u00d0\u00de\7-\2\2\u00d1\u00d2\7+\2\2\u00d2"+
		"\u00d3\7,\2\2\u00d3\u00de\7-\2\2\u00d4\u00de\7!\2\2\u00d5\u00de\7\"\2"+
		"\2\u00d6\u00de\7\n\2\2\u00d7\u00de\7\13\2\2\u00d8\u00de\7\f\2\2\u00d9"+
		"\u00de\7\r\2\2\u00da\u00de\7)\2\2\u00db\u00dc\7,\2\2\u00dc\u00de\7)\2"+
		"\2\u00dd\u00cf\3\2\2\2\u00dd\u00d1\3\2\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00d5"+
		"\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd"+
		"\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e1\5\26\f\2\u00e0\u00c8\3\2\2\2\u00e0\u00c9\3\2\2\2\u00e0"+
		"\u00cc\3\2\2\2\u00e0\u00ce\3\2\2\2\u00e1\25\3\2\2\2\u00e2\u00e3\b\f\1"+
		"\2\u00e3\u00f8\5\64\33\2\u00e4\u00f8\7\66\2\2\u00e5\u00f8\5\66\34\2\u00e6"+
		"\u00f8\5H%\2\u00e7\u00f8\5F$\2\u00e8\u00f8\5\62\32\2\u00e9\u00f8\7%\2"+
		"\2\u00ea\u00f1\7\30\2\2\u00eb\u00f2\5\64\33\2\u00ec\u00f2\7\66\2\2\u00ed"+
		"\u00f2\5\66\34\2\u00ee\u00f2\5H%\2\u00ef\u00f2\5F$\2\u00f0\u00f2\5\62"+
		"\32\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1"+
		"\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f8\3\2"+
		"\2\2\u00f3\u00f4\7\6\2\2\u00f4\u00f5\5\26\f\2\u00f5\u00f6\7\7\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00e2\3\2\2\2\u00f7\u00e4\3\2\2\2\u00f7\u00e5\3\2"+
		"\2\2\u00f7\u00e6\3\2\2\2\u00f7\u00e7\3\2\2\2\u00f7\u00e8\3\2\2\2\u00f7"+
		"\u00e9\3\2\2\2\u00f7\u00ea\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8\u0111\3\2"+
		"\2\2\u00f9\u00fa\f\b\2\2\u00fa\u00fb\7\36\2\2\u00fb\u0110\5\26\f\t\u00fc"+
		"\u00fd\f\7\2\2\u00fd\u00fe\t\3\2\2\u00fe\u0110\5\26\f\b\u00ff\u0100\f"+
		"\6\2\2\u0100\u0101\t\4\2\2\u0101\u0110\5\26\f\7\u0102\u0104\f\4\2\2\u0103"+
		"\u0105\7,\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\7)\2\2\u0107\u0110\5\26\f\5\u0108\u010d\f\3\2\2\u0109"+
		"\u010e\7+\2\2\u010a\u010e\7-\2\2\u010b\u010c\7,\2\2\u010c\u010e\7-\2\2"+
		"\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110"+
		"\3\2\2\2\u010f\u00f9\3\2\2\2\u010f\u00fc\3\2\2\2\u010f\u00ff\3\2\2\2\u010f"+
		"\u0102\3\2\2\2\u010f\u0108\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\27\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115"+
		"\7\b\2\2\u0115\u0116\5\4\3\2\u0116\u0117\7\t\2\2\u0117\u011d\3\2\2\2\u0118"+
		"\u0119\7\b\2\2\u0119\u011a\5\30\r\2\u011a\u011b\7\t\2\2\u011b\u011d\3"+
		"\2\2\2\u011c\u0114\3\2\2\2\u011c\u0118\3\2\2\2\u011d\31\3\2\2\2\u011e"+
		"\u011f\7.\2\2\u011f\u0123\7\6\2\2\u0120\u0122\5\60\31\2\u0121\u0120\3"+
		"\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7\7\2\2\u0127\33\3\2\2"+
		"\2\u0128\u0129\5\32\16\2\u0129\u012a\5\n\6\2\u012a\35\3\2\2\2\u012b\u012c"+
		"\7/\2\2\u012c\u012d\5\34\17\2\u012d\37\3\2\2\2\u012e\u012f\7/\2\2\u012f"+
		"\u0130\5\n\6\2\u0130!\3\2\2\2\u0131\u0132\7\60\2\2\u0132\u0133\5\f\7\2"+
		"\u0133#\3\2\2\2\u0134\u0135\7\61\2\2\u0135\u013c\7\6\2\2\u0136\u013d\5"+
		"\64\33\2\u0137\u013d\5F$\2\u0138\u013d\5H%\2\u0139\u013d\7\66\2\2\u013a"+
		"\u013d\5\66\34\2\u013b\u013d\5\62\32\2\u013c\u0136\3\2\2\2\u013c\u0137"+
		"\3\2\2\2\u013c\u0138\3\2\2\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7\7\2\2\u013f%\3\2\2\2"+
		"\u0140\u0141\7\61\2\2\u0141\u0148\7\6\2\2\u0142\u0149\5\64\33\2\u0143"+
		"\u0149\5F$\2\u0144\u0149\5H%\2\u0145\u0149\7\66\2\2\u0146\u0149\5\66\34"+
		"\2\u0147\u0149\5\62\32\2\u0148\u0142\3\2\2\2\u0148\u0143\3\2\2\2\u0148"+
		"\u0144\3\2\2\2\u0148\u0145\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2"+
		"\2\2\u0149\u0155\3\2\2\2\u014a\u0151\7\34\2\2\u014b\u0152\5\64\33\2\u014c"+
		"\u0152\5F$\2\u014d\u0152\5H%\2\u014e\u0152\7\66\2\2\u014f\u0152\5\66\34"+
		"\2\u0150\u0152\5\62\32\2\u0151\u014b\3\2\2\2\u0151\u014c\3\2\2\2\u0151"+
		"\u014d\3\2\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2"+
		"\2\2\u0152\u0154\3\2\2\2\u0153\u014a\3\2\2\2\u0154\u0157\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0158\u0159\7\7\2\2\u0159\'\3\2\2\2\u015a\u015b\5$\23\2\u015b\u015c"+
		"\7\b\2\2\u015c\u015d\5\4\3\2\u015d\u015e\7\t\2\2\u015e)\3\2\2\2\u015f"+
		"\u0160\7\62\2\2\u0160\u0161\7\b\2\2\u0161\u0162\5\4\3\2\u0162\u0163\7"+
		"\t\2\2\u0163+\3\2\2\2\u0164\u0165\7\17\2\2\u0165\u0166\7\66\2\2\u0166"+
		"-\3\2\2\2\u0167\u0168\5d\63\2\u0168\u016c\7\6\2\2\u0169\u016d\5\64\33"+
		"\2\u016a\u016d\7\66\2\2\u016b\u016d\5\66\34\2\u016c\u0169\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\7\7"+
		"\2\2\u016f/\3\2\2\2\u0170\u0171\b\31\1\2\u0171\u0188\5\64\33\2\u0172\u0188"+
		"\7\66\2\2\u0173\u0188\5\66\34\2\u0174\u0188\5H%\2\u0175\u0188\5F$\2\u0176"+
		"\u0188\5D#\2\u0177\u0188\5\62\32\2\u0178\u0188\7%\2\2\u0179\u0181\7\30"+
		"\2\2\u017a\u0182\5\64\33\2\u017b\u0182\7\66\2\2\u017c\u0182\5\66\34\2"+
		"\u017d\u0182\5H%\2\u017e\u0182\5F$\2\u017f\u0182\5D#\2\u0180\u0182\5\62"+
		"\32\2\u0181\u017a\3\2\2\2\u0181\u017b\3\2\2\2\u0181\u017c\3\2\2\2\u0181"+
		"\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2"+
		"\2\2\u0182\u0188\3\2\2\2\u0183\u0184\7\6\2\2\u0184\u0185\5\60\31\2\u0185"+
		"\u0186\7\7\2\2\u0186\u0188\3\2\2\2\u0187\u0170\3\2\2\2\u0187\u0172\3\2"+
		"\2\2\u0187\u0173\3\2\2\2\u0187\u0174\3\2\2\2\u0187\u0175\3\2\2\2\u0187"+
		"\u0176\3\2\2\2\u0187\u0177\3\2\2\2\u0187\u0178\3\2\2\2\u0187\u0179\3\2"+
		"\2\2\u0187\u0183\3\2\2\2\u0188\u01ba\3\2\2\2\u0189\u018a\f\r\2\2\u018a"+
		"\u018b\7\36\2\2\u018b\u01b9\5\60\31\16\u018c\u018d\f\f\2\2\u018d\u018e"+
		"\t\3\2\2\u018e\u01b9\5\60\31\r\u018f\u0190\f\13\2\2\u0190\u0191\t\4\2"+
		"\2\u0191\u01b9\5\60\31\f\u0192\u0193\f\n\2\2\u0193\u0194\t\5\2\2\u0194"+
		"\u01b9\5\60\31\13\u0195\u019c\f\t\2\2\u0196\u019d\7!\2\2\u0197\u019d\7"+
		"\"\2\2\u0198\u019d\7+\2\2\u0199\u019a\7+\2\2\u019a\u019d\7,\2\2\u019b"+
		"\u019d\7)\2\2\u019c\u0196\3\2\2\2\u019c\u0197\3\2\2\2\u019c\u0198\3\2"+
		"\2\2\u019c\u0199\3\2\2\2\u019c\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u01b9\5\60\31\n\u019f\u01a0\f\b\2\2\u01a0\u01a1\7(\2\2\u01a1\u01b9\5"+
		"\60\31\t\u01a2\u01a3\f\7\2\2\u01a3\u01a4\7*\2\2\u01a4\u01b9\5\60\31\b"+
		"\u01a5\u01a7\f\5\2\2\u01a6\u01a8\7,\2\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8"+
		"\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7)\2\2\u01aa\u01b9\5\60\31\6"+
		"\u01ab\u01ac\f\3\2\2\u01ac\u01ae\7+\2\2\u01ad\u01af\7,\2\2\u01ae\u01ad"+
		"\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b9\5\60\31\4"+
		"\u01b1\u01b6\f\4\2\2\u01b2\u01b7\7+\2\2\u01b3\u01b7\7-\2\2\u01b4\u01b5"+
		"\7,\2\2\u01b5\u01b7\7-\2\2\u01b6\u01b2\3\2\2\2\u01b6\u01b3\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u0189\3\2\2\2\u01b8\u018c\3\2"+
		"\2\2\u01b8\u018f\3\2\2\2\u01b8\u0192\3\2\2\2\u01b8\u0195\3\2\2\2\u01b8"+
		"\u019f\3\2\2\2\u01b8\u01a2\3\2\2\2\u01b8\u01a5\3\2\2\2\u01b8\u01ab\3\2"+
		"\2\2\u01b8\u01b1\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\61\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7\66\2"+
		"\2\u01be\u01c7\7\6\2\2\u01bf\u01c4\5\60\31\2\u01c0\u01c1\7\34\2\2\u01c1"+
		"\u01c3\5\60\31\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3"+
		"\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01bf\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\7\7"+
		"\2\2\u01ca\63\3\2\2\2\u01cb\u01cc\7\21\2\2\u01cc\u01d1\7\67\2\2\u01cd"+
		"\u01d1\7\67\2\2\u01ce\u01d1\78\2\2\u01cf\u01d1\7-\2\2\u01d0\u01cb\3\2"+
		"\2\2\u01d0\u01cd\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01cf\3\2\2\2\u01d1"+
		"\65\3\2\2\2\u01d2\u01da\5:\36\2\u01d3\u01da\5> \2\u01d4\u01da\5<\37\2"+
		"\u01d5\u01da\5J&\2\u01d6\u01da\5T+\2\u01d7\u01da\5^\60\2\u01d8\u01da\5"+
		"b\62\2\u01d9\u01d2\3\2\2\2\u01d9\u01d3\3\2\2\2\u01d9\u01d4\3\2\2\2\u01d9"+
		"\u01d5\3\2\2\2\u01d9\u01d6\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01d8\3\2"+
		"\2\2\u01da\67\3\2\2\2\u01db\u01e0\5@!\2\u01dc\u01e0\5B\"\2\u01dd\u01e0"+
		"\5X-\2\u01de\u01e0\5`\61\2\u01df\u01db\3\2\2\2\u01df\u01dc\3\2\2\2\u01df"+
		"\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e09\3\2\2\2\u01e1\u01e2\7 \2\2\u01e2"+
		"\u01e3\7\66\2\2\u01e3;\3\2\2\2\u01e4\u01e5\7 \2\2\u01e5\u01e6\7 \2\2\u01e6"+
		"\u01e7\7\66\2\2\u01e7=\3\2\2\2\u01e8\u01e9\7 \2\2\u01e9\u01ea\7\21\2\2"+
		"\u01ea\u01eb\7\66\2\2\u01eb?\3\2\2\2\u01ec\u01ed\7 \2\2\u01ed\u01ee\7"+
		"\20\2\2\u01ee\u01ef\7\66\2\2\u01efA\3\2\2\2\u01f0\u01f1\7 \2\2\u01f1\u01f2"+
		"\7\24\2\2\u01f2\u01f3\7\66\2\2\u01f3C\3\2\2\2\u01f4\u01f5\7 \2\2\u01f5"+
		"\u01f6\7\22\2\2\u01f6E\3\2\2\2\u01f7\u01f8\7 \2\2\u01f8\u01f9\7\31\2\2"+
		"\u01f9G\3\2\2\2\u01fa\u01fb\7 \2\2\u01fb\u01fc\7\30\2\2\u01fcI\3\2\2\2"+
		"\u01fd\u0200\5L\'\2\u01fe\u0200\5N(\2\u01ff\u01fd\3\2\2\2\u01ff\u01fe"+
		"\3\2\2\2\u0200K\3\2\2\2\u0201\u0202\5:\36\2\u0202\u0203\7\37\2\2\u0203"+
		"\u0204\7\3\2\2\u0204M\3\2\2\2\u0205\u0206\5> \2\u0206\u0207\7\37\2\2\u0207"+
		"\u0208\7\3\2\2\u0208O\3\2\2\2\u0209\u020a\5@!\2\u020a\u020b\7\37\2\2\u020b"+
		"\u020c\7\3\2\2\u020cQ\3\2\2\2\u020d\u020e\5B\"\2\u020e\u020f\7\37\2\2"+
		"\u020f\u0210\7\3\2\2\u0210S\3\2\2\2\u0211\u0212\5:\36\2\u0212\u0213\7"+
		"\37\2\2\u0213\u0214\7\4\2\2\u0214U\3\2\2\2\u0215\u0216\5:\36\2\u0216\u0217"+
		"\7\37\2\2\u0217\u0218\7\5\2\2\u0218W\3\2\2\2\u0219\u021c\5Z.\2\u021a\u021c"+
		"\5\\/\2\u021b\u0219\3\2\2\2\u021b\u021a\3\2\2\2\u021cY\3\2\2\2\u021d\u021e"+
		"\5@!\2\u021e\u021f\7\27\2\2\u021f\u0220\7\66\2\2\u0220[\3\2\2\2\u0221"+
		"\u0222\5B\"\2\u0222\u0223\7\27\2\2\u0223\u0224\7\66\2\2\u0224]\3\2\2\2"+
		"\u0225\u0226\5:\36\2\u0226\u0227\7\32\2\2\u0227\u0228\7\66\2\2\u0228\u022e"+
		"\3\2\2\2\u0229\u022a\5@!\2\u022a\u022b\7\32\2\2\u022b\u022c\7\66\2\2\u022c"+
		"\u022e\3\2\2\2\u022d\u0225\3\2\2\2\u022d\u0229\3\2\2\2\u022e_\3\2\2\2"+
		"\u022f\u0230\5@!\2\u0230\u0231\7#\2\2\u0231\u0232\7\66\2\2\u0232a\3\2"+
		"\2\2\u0233\u0234\7\32\2\2\u0234\u0235\7\66\2\2\u0235c\3\2\2\2\u0236\u023b"+
		"\3\2\2\2\u0237\u023b\7\63\2\2\u0238\u023b\7\64\2\2\u0239\u023b\7\65\2"+
		"\2\u023a\u0236\3\2\2\2\u023a\u0237\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u0239"+
		"\3\2\2\2\u023be\3\2\2\2\u023c\u023d\7%\2\2\u023dg\3\2\2\2\u023e\u023f"+
		"\7$\2\2\u023fi\3\2\2\2\66rv}\u0085\u008a\u008d\u0093\u0097\u009d\u00a1"+
		"\u00a4\u00a6\u00aa\u00ad\u00b2\u00b5\u00ba\u00be\u00c5\u00cc\u00dd\u00e0"+
		"\u00f1\u00f7\u0104\u010d\u010f\u0111\u011c\u0123\u013c\u0148\u0151\u0155"+
		"\u016c\u0181\u0187\u019c\u01a7\u01ae\u01b6\u01b8\u01ba\u01c4\u01c7\u01d0"+
		"\u01d9\u01df\u01ff\u021b\u022d\u023a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}