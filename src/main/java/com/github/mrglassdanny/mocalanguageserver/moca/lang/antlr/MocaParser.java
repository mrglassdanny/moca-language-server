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
	public static final int
		RULE_moca_script = 0, RULE_sequence = 1, RULE_stream = 2, RULE_group = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_command = 6, RULE_verb_noun_clause = 7, 
		RULE_verb_noun_clause_args = 8, RULE_verb_noun_clause_arg = 9, RULE_sub_sequence = 10, 
		RULE_if_expr = 11, RULE_if_statement = 12, RULE_else_if_statement = 13, 
		RULE_else_statement = 14, RULE_try_block = 15, RULE_catch_single_expr = 16, 
		RULE_catch_multi_expr = 17, RULE_catch_sequence = 18, RULE_finally_sequence = 19, 
		RULE_redirect_expr = 20, RULE_remote_expr = 21, RULE_expr = 22, RULE_function_expr = 23, 
		RULE_literal_value = 24, RULE_variable = 25, RULE_plus_variable = 26, 
		RULE_at_variable = 27, RULE_environment_variable = 28, RULE_at_minus_variable = 29, 
		RULE_at_plus_variable = 30, RULE_at_mod_variable = 31, RULE_at_star = 32, 
		RULE_at_question = 33, RULE_at_bang = 34, RULE_keep_directive = 35, RULE_at_keep_directive = 36, 
		RULE_at_minus_keep_directive = 37, RULE_at_plus_keep_directive = 38, RULE_at_mod_keep_directive = 39, 
		RULE_onstack_directive = 40, RULE_oldvar_directive = 41, RULE_at_plus_oldvar_directive = 42, 
		RULE_at_mod_oldvar_directive = 43, RULE_type_cast_variable = 44, RULE_database_qualifier_variable = 45, 
		RULE_integration_variable = 46, RULE_remote_keyword = 47, RULE_groovy_script = 48, 
		RULE_sql_script = 49;
	public static final String[] ruleNames = {
		"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
		"verb_noun_clause", "verb_noun_clause_args", "verb_noun_clause_arg", "sub_sequence", 
		"if_expr", "if_statement", "else_if_statement", "else_statement", "try_block", 
		"catch_single_expr", "catch_multi_expr", "catch_sequence", "finally_sequence", 
		"redirect_expr", "remote_expr", "expr", "function_expr", "literal_value", 
		"variable", "plus_variable", "at_variable", "environment_variable", "at_minus_variable", 
		"at_plus_variable", "at_mod_variable", "at_star", "at_question", "at_bang", 
		"keep_directive", "at_keep_directive", "at_minus_keep_directive", "at_plus_keep_directive", 
		"at_mod_keep_directive", "onstack_directive", "oldvar_directive", "at_plus_oldvar_directive", 
		"at_mod_oldvar_directive", "type_cast_variable", "database_qualifier_variable", 
		"integration_variable", "remote_keyword", "groovy_script", "sql_script"
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
					redirect_expr();
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
					remote_expr();
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
					remote_expr();
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
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				groovy_script();
				}
				break;
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
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
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << ONSTACK) | (1L << KEEP) | (1L << WORD))) != 0)) ) {
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
		public TerminalNode OVERSTACKED_ARGS() { return getToken(MocaParser.OVERSTACKED_ARGS, 0); }
		public At_starContext at_star() {
			return getRuleContext(At_starContext.class,0);
		}
		public Plus_variableContext plus_variable() {
			return getRuleContext(Plus_variableContext.class,0);
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
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(OVERSTACKED_ARGS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(198);
					at_star();
					}
					break;
				case 2:
					{
					setState(199);
					plus_variable();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
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
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(LEFT_BRACE);
				setState(206);
				sequence();
				setState(207);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(LEFT_BRACE);
				setState(210);
				sub_sequence();
				setState(211);
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
			setState(215);
			match(IF);
			setState(216);
			match(LEFT_PAREN);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				{
				setState(217);
				expr(0);
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
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
			setState(225);
			if_expr();
			setState(226);
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
			setState(228);
			match(ELSE);
			setState(229);
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
			setState(231);
			match(ELSE);
			setState(232);
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
			setState(234);
			match(TRY);
			setState(235);
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
			setState(237);
			match(CATCH);
			setState(238);
			match(LEFT_PAREN);
			setState(239);
			expr(0);
			setState(240);
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
			setState(242);
			match(CATCH);
			setState(243);
			match(LEFT_PAREN);
			setState(244);
			expr(0);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(245);
				match(COMMA);
				setState(246);
				expr(0);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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
			setState(254);
			catch_single_expr();
			setState(255);
			match(LEFT_BRACE);
			setState(257);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << CARET) | (1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << ONSTACK) | (1L << KEEP) | (1L << WORD))) != 0)) {
				{
				setState(256);
				sequence();
				}
			}

			setState(259);
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
			setState(261);
			match(FINALLY);
			setState(262);
			match(LEFT_BRACE);
			setState(263);
			sequence();
			setState(264);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitRedirect_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Redirect_exprContext redirect_expr() throws RecognitionException {
		Redirect_exprContext _localctx = new Redirect_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_redirect_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(DOUBLE_GREATER);
			setState(267);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitRemote_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Remote_exprContext remote_expr() throws RecognitionException {
		Remote_exprContext _localctx = new Remote_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_remote_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			remote_keyword();
			setState(270);
			match(LEFT_PAREN);
			setState(271);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(275);
				literal_value();
				}
				break;
			case 2:
				{
				setState(276);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(277);
				variable();
				}
				break;
			case 4:
				{
				setState(278);
				at_bang();
				}
				break;
			case 5:
				{
				setState(279);
				at_question();
				}
				break;
			case 6:
				{
				setState(280);
				at_star();
				}
				break;
			case 7:
				{
				setState(281);
				function_expr();
				}
				break;
			case 8:
				{
				setState(282);
				groovy_script();
				}
				break;
			case 9:
				{
				setState(283);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 10:
				{
				{
				setState(284);
				match(BANG);
				setState(293);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(285);
					literal_value();
					}
					break;
				case 2:
					{
					setState(286);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(287);
					variable();
					}
					break;
				case 4:
					{
					setState(288);
					at_bang();
					}
					break;
				case 5:
					{
					setState(289);
					at_question();
					}
					break;
				case 6:
					{
					setState(290);
					at_star();
					}
					break;
				case 7:
					{
					setState(291);
					function_expr();
					}
					break;
				case 8:
					{
					setState(292);
					expr(0);
					}
					break;
				}
				}
				}
				break;
			case 11:
				{
				setState(295);
				match(LEFT_PAREN);
				setState(296);
				expr(0);
				setState(297);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(302);
						match(DOUBLE_PIPE);
						setState(303);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(305);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(306);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(308);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(309);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(311);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(312);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(320);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
						case 1:
							{
							setState(314);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(315);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(316);
							match(IS);
							}
							break;
						case 4:
							{
							setState(317);
							match(IS);
							setState(318);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(319);
							match(LIKE);
							}
							break;
						}
						setState(322);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(323);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(324);
						match(AND);
						setState(325);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(326);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(327);
						match(OR);
						setState(328);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(329);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(331);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(330);
							match(NOT);
							}
						}

						{
						setState(333);
						match(LIKE);
						}
						setState(334);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(335);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(336);
						match(IS);
						setState(338);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(337);
							match(NOT);
							}
						}

						setState(340);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(341);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(346);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(342);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(343);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(344);
							match(NOT);
							setState(345);
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
				setState(352);
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
			setState(353);
			match(WORD);
			setState(354);
			match(LEFT_PAREN);
			setState(363);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				setState(355);
				expr(0);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(356);
					match(COMMA);
					setState(357);
					expr(0);
					}
					}
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(365);
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
			setState(372);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(MINUS);
				setState(368);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(370);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(371);
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

	public static class VariableContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public At_minus_variableContext at_minus_variable() {
			return getRuleContext(At_minus_variableContext.class,0);
		}
		public Environment_variableContext environment_variable() {
			return getRuleContext(Environment_variableContext.class,0);
		}
		public Keep_directiveContext keep_directive() {
			return getRuleContext(Keep_directiveContext.class,0);
		}
		public Onstack_directiveContext onstack_directive() {
			return getRuleContext(Onstack_directiveContext.class,0);
		}
		public Type_cast_variableContext type_cast_variable() {
			return getRuleContext(Type_cast_variableContext.class,0);
		}
		public Integration_variableContext integration_variable() {
			return getRuleContext(Integration_variableContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variable);
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				at_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				at_minus_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				environment_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(377);
				keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(378);
				onstack_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(379);
				type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(380);
				integration_variable();
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

	public static class Plus_variableContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public At_mod_variableContext at_mod_variable() {
			return getRuleContext(At_mod_variableContext.class,0);
		}
		public At_plus_keep_directiveContext at_plus_keep_directive() {
			return getRuleContext(At_plus_keep_directiveContext.class,0);
		}
		public At_mod_keep_directiveContext at_mod_keep_directive() {
			return getRuleContext(At_mod_keep_directiveContext.class,0);
		}
		public Oldvar_directiveContext oldvar_directive() {
			return getRuleContext(Oldvar_directiveContext.class,0);
		}
		public Database_qualifier_variableContext database_qualifier_variable() {
			return getRuleContext(Database_qualifier_variableContext.class,0);
		}
		public Plus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plus_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterPlus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitPlus_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitPlus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Plus_variableContext plus_variable() throws RecognitionException {
		Plus_variableContext _localctx = new Plus_variableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_plus_variable);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				at_plus_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				at_mod_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				at_plus_keep_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(386);
				at_mod_keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(387);
				oldvar_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(388);
				database_qualifier_variable();
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

	public static class At_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_variableContext at_variable() throws RecognitionException {
		At_variableContext _localctx = new At_variableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_at_variable);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitEnvironment_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Environment_variableContext environment_variable() throws RecognitionException {
		Environment_variableContext _localctx = new Environment_variableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_environment_variable);
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

	public static class At_minus_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode MINUS() { return getToken(MocaParser.MINUS, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_minus_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_minus_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_minus_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_minus_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_minus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_minus_variableContext at_minus_variable() throws RecognitionException {
		At_minus_variableContext _localctx = new At_minus_variableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_at_minus_variable);
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

	public static class At_plus_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode PLUS() { return getToken(MocaParser.PLUS, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_variableContext at_plus_variable() throws RecognitionException {
		At_plus_variableContext _localctx = new At_plus_variableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_at_plus_variable);
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

	public static class At_mod_variableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MocaParser.AT, 0); }
		public TerminalNode MOD() { return getToken(MocaParser.MOD, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_mod_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_mod_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_mod_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_mod_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_mod_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_mod_variableContext at_mod_variable() throws RecognitionException {
		At_mod_variableContext _localctx = new At_mod_variableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_at_mod_variable);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_star(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_starContext at_star() throws RecognitionException {
		At_starContext _localctx = new At_starContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_at_star);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_questionContext at_question() throws RecognitionException {
		At_questionContext _localctx = new At_questionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_at_question);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_bang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_bangContext at_bang() throws RecognitionException {
		At_bangContext _localctx = new At_bangContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_at_bang);
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

	public static class Keep_directiveContext extends ParserRuleContext {
		public At_keep_directiveContext at_keep_directive() {
			return getRuleContext(At_keep_directiveContext.class,0);
		}
		public At_minus_keep_directiveContext at_minus_keep_directive() {
			return getRuleContext(At_minus_keep_directiveContext.class,0);
		}
		public Keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keep_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterKeep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitKeep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitKeep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keep_directiveContext keep_directive() throws RecognitionException {
		Keep_directiveContext _localctx = new Keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_keep_directive);
		try {
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				at_keep_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				at_minus_keep_directive();
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

	public static class At_keep_directiveContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode KEEP() { return getToken(MocaParser.KEEP, 0); }
		public At_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_keep_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_keep_directiveContext at_keep_directive() throws RecognitionException {
		At_keep_directiveContext _localctx = new At_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_at_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			at_variable();
			setState(424);
			match(POUND);
			setState(425);
			match(KEEP);
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

	public static class At_minus_keep_directiveContext extends ParserRuleContext {
		public At_minus_variableContext at_minus_variable() {
			return getRuleContext(At_minus_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode KEEP() { return getToken(MocaParser.KEEP, 0); }
		public At_minus_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_minus_keep_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_minus_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_minus_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_minus_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_minus_keep_directiveContext at_minus_keep_directive() throws RecognitionException {
		At_minus_keep_directiveContext _localctx = new At_minus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_at_minus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			at_minus_variable();
			setState(428);
			match(POUND);
			setState(429);
			match(KEEP);
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

	public static class At_plus_keep_directiveContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode KEEP() { return getToken(MocaParser.KEEP, 0); }
		public At_plus_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_keep_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_keep_directiveContext at_plus_keep_directive() throws RecognitionException {
		At_plus_keep_directiveContext _localctx = new At_plus_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_at_plus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			at_plus_variable();
			setState(432);
			match(POUND);
			setState(433);
			match(KEEP);
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

	public static class At_mod_keep_directiveContext extends ParserRuleContext {
		public At_mod_variableContext at_mod_variable() {
			return getRuleContext(At_mod_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode KEEP() { return getToken(MocaParser.KEEP, 0); }
		public At_mod_keep_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_mod_keep_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_mod_keep_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_mod_keep_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_mod_keep_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_mod_keep_directiveContext at_mod_keep_directive() throws RecognitionException {
		At_mod_keep_directiveContext _localctx = new At_mod_keep_directiveContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_at_mod_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			at_mod_variable();
			setState(436);
			match(POUND);
			setState(437);
			match(KEEP);
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

	public static class Onstack_directiveContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode ONSTACK() { return getToken(MocaParser.ONSTACK, 0); }
		public At_minus_variableContext at_minus_variable() {
			return getRuleContext(At_minus_variableContext.class,0);
		}
		public Onstack_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onstack_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterOnstack_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitOnstack_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitOnstack_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Onstack_directiveContext onstack_directive() throws RecognitionException {
		Onstack_directiveContext _localctx = new Onstack_directiveContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_onstack_directive);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				at_variable();
				setState(440);
				match(POUND);
				setState(441);
				match(ONSTACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				at_minus_variable();
				setState(444);
				match(POUND);
				setState(445);
				match(ONSTACK);
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

	public static class Oldvar_directiveContext extends ParserRuleContext {
		public At_plus_oldvar_directiveContext at_plus_oldvar_directive() {
			return getRuleContext(At_plus_oldvar_directiveContext.class,0);
		}
		public At_mod_oldvar_directiveContext at_mod_oldvar_directive() {
			return getRuleContext(At_mod_oldvar_directiveContext.class,0);
		}
		public Oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oldvar_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterOldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitOldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitOldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Oldvar_directiveContext oldvar_directive() throws RecognitionException {
		Oldvar_directiveContext _localctx = new Oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_oldvar_directive);
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				at_plus_oldvar_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				at_mod_oldvar_directive();
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

	public static class At_plus_oldvar_directiveContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_plus_oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_oldvar_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_oldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_oldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_oldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_oldvar_directiveContext at_plus_oldvar_directive() throws RecognitionException {
		At_plus_oldvar_directiveContext _localctx = new At_plus_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_at_plus_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			at_plus_variable();
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

	public static class At_mod_oldvar_directiveContext extends ParserRuleContext {
		public At_mod_variableContext at_mod_variable() {
			return getRuleContext(At_mod_variableContext.class,0);
		}
		public TerminalNode CARET() { return getToken(MocaParser.CARET, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_mod_oldvar_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_mod_oldvar_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_mod_oldvar_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_mod_oldvar_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_mod_oldvar_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_mod_oldvar_directiveContext at_mod_oldvar_directive() throws RecognitionException {
		At_mod_oldvar_directiveContext _localctx = new At_mod_oldvar_directiveContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_at_mod_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			at_mod_variable();
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

	public static class Type_cast_variableContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public Type_cast_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_cast_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterType_cast_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitType_cast_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitType_cast_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_cast_variableContext type_cast_variable() throws RecognitionException {
		Type_cast_variableContext _localctx = new Type_cast_variableContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_type_cast_variable);
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				at_variable();
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
				at_plus_variable();
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

	public static class Database_qualifier_variableContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MocaParser.DOT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public Database_qualifier_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_qualifier_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterDatabase_qualifier_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitDatabase_qualifier_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitDatabase_qualifier_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Database_qualifier_variableContext database_qualifier_variable() throws RecognitionException {
		Database_qualifier_variableContext _localctx = new Database_qualifier_variableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			at_plus_variable();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitIntegration_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integration_variableContext integration_variable() throws RecognitionException {
		Integration_variableContext _localctx = new Integration_variableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_integration_variable);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitRemote_keyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Remote_keywordContext remote_keyword() throws RecognitionException {
		Remote_keywordContext _localctx = new Remote_keywordContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_remote_keyword);
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
		enterRule(_localctx, 96, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSql_script(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_scriptContext sql_script() throws RecognitionException {
		Sql_scriptContext _localctx = new Sql_scriptContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u01eb\4\2\t\2\4"+
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
		"\n\7\n\u00c3\n\n\f\n\16\n\u00c6\13\n\3\13\3\13\3\13\5\13\u00cb\n\13\3"+
		"\13\5\13\u00ce\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d8\n\f\3\r"+
		"\3\r\3\r\7\r\u00dd\n\r\f\r\16\r\u00e0\13\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00fa\n\23\f\23\16\23\u00fd\13\23\3\23\3\23"+
		"\3\24\3\24\3\24\5\24\u0104\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0128"+
		"\n\30\3\30\3\30\3\30\3\30\5\30\u012e\n\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0143\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u014e\n"+
		"\30\3\30\3\30\3\30\3\30\3\30\5\30\u0155\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u015d\n\30\7\30\u015f\n\30\f\30\16\30\u0162\13\30\3\31\3\31"+
		"\3\31\3\31\3\31\7\31\u0169\n\31\f\31\16\31\u016c\13\31\5\31\u016e\n\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0177\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u0180\n\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0188"+
		"\n\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\5%\u01a8\n%\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\5*\u01c2\n*\3+\3+\5+\u01c6\n+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u01d8\n.\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\5\61\u01e5\n\61\3\62\3\62\3\63\3\63\3\63\2\3.\64\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\6\4"+
		"\2\'\6699\3\2\23\25\3\2\21\22\3\2\13\16\u020f\2f\3\2\2\2\4i\3\2\2\2\6"+
		"t\3\2\2\2\b|\3\2\2\2\n\u00a2\3\2\2\2\f\u00ac\3\2\2\2\16\u00b1\3\2\2\2"+
		"\20\u00b4\3\2\2\2\22\u00bf\3\2\2\2\24\u00cd\3\2\2\2\26\u00d7\3\2\2\2\30"+
		"\u00d9\3\2\2\2\32\u00e3\3\2\2\2\34\u00e6\3\2\2\2\36\u00e9\3\2\2\2 \u00ec"+
		"\3\2\2\2\"\u00ef\3\2\2\2$\u00f4\3\2\2\2&\u0100\3\2\2\2(\u0107\3\2\2\2"+
		"*\u010c\3\2\2\2,\u010f\3\2\2\2.\u012d\3\2\2\2\60\u0163\3\2\2\2\62\u0176"+
		"\3\2\2\2\64\u017f\3\2\2\2\66\u0187\3\2\2\28\u0189\3\2\2\2:\u018c\3\2\2"+
		"\2<\u0190\3\2\2\2>\u0194\3\2\2\2@\u0198\3\2\2\2B\u019c\3\2\2\2D\u019f"+
		"\3\2\2\2F\u01a2\3\2\2\2H\u01a7\3\2\2\2J\u01a9\3\2\2\2L\u01ad\3\2\2\2N"+
		"\u01b1\3\2\2\2P\u01b5\3\2\2\2R\u01c1\3\2\2\2T\u01c5\3\2\2\2V\u01c7\3\2"+
		"\2\2X\u01cb\3\2\2\2Z\u01d7\3\2\2\2\\\u01d9\3\2\2\2^\u01dd\3\2\2\2`\u01e4"+
		"\3\2\2\2b\u01e6\3\2\2\2d\u01e8\3\2\2\2fg\5\4\3\2gh\7\2\2\3h\3\3\2\2\2"+
		"in\5\6\4\2jk\7\34\2\2km\5\6\4\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2"+
		"\2or\3\2\2\2pn\3\2\2\2qs\7\34\2\2rq\3\2\2\2rs\3\2\2\2s\5\3\2\2\2ty\5\b"+
		"\5\2uv\7\36\2\2vx\5\b\5\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\7\3"+
		"\2\2\2{y\3\2\2\2|\u0081\5\n\6\2}~\7\27\2\2~\u0080\5\n\6\2\177}\3\2\2\2"+
		"\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\t\3\2"+
		"\2\2\u0083\u0081\3\2\2\2\u0084\u0086\5\f\7\2\u0085\u0087\5$\23\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u008a\5*"+
		"\26\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u00a3\3\2\2\2\u008b"+
		"\u008f\5\32\16\2\u008c\u008e\5\34\17\2\u008d\u008c\3\2\2\2\u008e\u0091"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\5\36\20\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u00a3\3\2\2\2\u0095\u0099\5 \21\2\u0096\u0098\5&\24\2\u0097"+
		"\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\5(\25\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5*"+
		"\26\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u0084\3\2\2\2\u00a2\u008b\3\2\2\2\u00a2\u0095\3\2\2\2\u00a3\13\3\2\2"+
		"\2\u00a4\u00a6\5,\27\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00ad\5\16\b\2\u00a8\u00aa\5,\27\2\u00a9\u00a8\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\5\26\f\2\u00ac\u00a5"+
		"\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\r\3\2\2\2\u00ae\u00b2\5b\62\2\u00af"+
		"\u00b2\5d\63\2\u00b0\u00b2\5\20\t\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3"+
		"\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\17\3\2\2\2\u00b3\u00b5\7\30\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b8\t\2"+
		"\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00bc\7&\2\2\u00bc\u00be\5\22"+
		"\n\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\21\3\2\2\2\u00bf\u00c4"+
		"\5\24\13\2\u00c0\u00c1\7\'\2\2\u00c1\u00c3\5\24\13\2\u00c2\u00c0\3\2\2"+
		"\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\23"+
		"\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00ce\7%\2\2\u00c8\u00cb\5B\"\2\u00c9"+
		"\u00cb\5\66\34\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3"+
		"\2\2\2\u00cc\u00ce\5.\30\2\u00cd\u00c7\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\25\3\2\2\2\u00cf\u00d0\7\7\2\2\u00d0\u00d1\5\4\3"+
		"\2\u00d1\u00d2\7\b\2\2\u00d2\u00d8\3\2\2\2\u00d3\u00d4\7\7\2\2\u00d4\u00d5"+
		"\5\26\f\2\u00d5\u00d6\7\b\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00cf\3\2\2\2"+
		"\u00d7\u00d3\3\2\2\2\u00d8\27\3\2\2\2\u00d9\u00da\7-\2\2\u00da\u00de\7"+
		"\5\2\2\u00db\u00dd\5.\30\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e1\u00e2\7\6\2\2\u00e2\31\3\2\2\2\u00e3\u00e4\5\30\r\2\u00e4\u00e5"+
		"\5\n\6\2\u00e5\33\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7\u00e8\5\32\16\2\u00e8"+
		"\35\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea\u00eb\5\n\6\2\u00eb\37\3\2\2\2\u00ec"+
		"\u00ed\7/\2\2\u00ed\u00ee\5\f\7\2\u00ee!\3\2\2\2\u00ef\u00f0\7\60\2\2"+
		"\u00f0\u00f1\7\5\2\2\u00f1\u00f2\5.\30\2\u00f2\u00f3\7\6\2\2\u00f3#\3"+
		"\2\2\2\u00f4\u00f5\7\60\2\2\u00f5\u00f6\7\5\2\2\u00f6\u00fb\5.\30\2\u00f7"+
		"\u00f8\7\35\2\2\u00f8\u00fa\5.\30\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00ff\7\6\2\2\u00ff%\3\2\2\2\u0100\u0101\5\"\22\2"+
		"\u0101\u0103\7\7\2\2\u0102\u0104\5\4\3\2\u0103\u0102\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7\b\2\2\u0106\'\3\2\2\2\u0107"+
		"\u0108\7\61\2\2\u0108\u0109\7\7\2\2\u0109\u010a\5\4\3\2\u010a\u010b\7"+
		"\b\2\2\u010b)\3\2\2\2\u010c\u010d\7\20\2\2\u010d\u010e\79\2\2\u010e+\3"+
		"\2\2\2\u010f\u0110\5`\61\2\u0110\u0111\7\5\2\2\u0111\u0112\5.\30\2\u0112"+
		"\u0113\7\6\2\2\u0113-\3\2\2\2\u0114\u0115\b\30\1\2\u0115\u012e\5\62\32"+
		"\2\u0116\u012e\79\2\2\u0117\u012e\5\64\33\2\u0118\u012e\5F$\2\u0119\u012e"+
		"\5D#\2\u011a\u012e\5B\"\2\u011b\u012e\5\60\31\2\u011c\u012e\5b\62\2\u011d"+
		"\u012e\7\4\2\2\u011e\u0127\7\31\2\2\u011f\u0128\5\62\32\2\u0120\u0128"+
		"\79\2\2\u0121\u0128\5\64\33\2\u0122\u0128\5F$\2\u0123\u0128\5D#\2\u0124"+
		"\u0128\5B\"\2\u0125\u0128\5\60\31\2\u0126\u0128\5.\30\2\u0127\u011f\3"+
		"\2\2\2\u0127\u0120\3\2\2\2\u0127\u0121\3\2\2\2\u0127\u0122\3\2\2\2\u0127"+
		"\u0123\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2"+
		"\2\2\u0128\u012e\3\2\2\2\u0129\u012a\7\5\2\2\u012a\u012b\5.\30\2\u012b"+
		"\u012c\7\6\2\2\u012c\u012e\3\2\2\2\u012d\u0114\3\2\2\2\u012d\u0116\3\2"+
		"\2\2\u012d\u0117\3\2\2\2\u012d\u0118\3\2\2\2\u012d\u0119\3\2\2\2\u012d"+
		"\u011a\3\2\2\2\u012d\u011b\3\2\2\2\u012d\u011c\3\2\2\2\u012d\u011d\3\2"+
		"\2\2\u012d\u011e\3\2\2\2\u012d\u0129\3\2\2\2\u012e\u0160\3\2\2\2\u012f"+
		"\u0130\f\r\2\2\u0130\u0131\7\37\2\2\u0131\u015f\5.\30\16\u0132\u0133\f"+
		"\f\2\2\u0133\u0134\t\3\2\2\u0134\u015f\5.\30\r\u0135\u0136\f\13\2\2\u0136"+
		"\u0137\t\4\2\2\u0137\u015f\5.\30\f\u0138\u0139\f\n\2\2\u0139\u013a\t\5"+
		"\2\2\u013a\u015f\5.\30\13\u013b\u0142\f\t\2\2\u013c\u0143\7\"\2\2\u013d"+
		"\u0143\7#\2\2\u013e\u0143\7*\2\2\u013f\u0140\7*\2\2\u0140\u0143\7+\2\2"+
		"\u0141\u0143\7(\2\2\u0142\u013c\3\2\2\2\u0142\u013d\3\2\2\2\u0142\u013e"+
		"\3\2\2\2\u0142\u013f\3\2\2\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u015f\5.\30\n\u0145\u0146\f\b\2\2\u0146\u0147\7\'\2\2\u0147\u015f\5."+
		"\30\t\u0148\u0149\f\7\2\2\u0149\u014a\7)\2\2\u014a\u015f\5.\30\b\u014b"+
		"\u014d\f\5\2\2\u014c\u014e\7+\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0150\7(\2\2\u0150\u015f\5.\30\6\u0151"+
		"\u0152\f\3\2\2\u0152\u0154\7*\2\2\u0153\u0155\7+\2\2\u0154\u0153\3\2\2"+
		"\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015f\5.\30\4\u0157\u015c"+
		"\f\4\2\2\u0158\u015d\7*\2\2\u0159\u015d\7,\2\2\u015a\u015b\7+\2\2\u015b"+
		"\u015d\7,\2\2\u015c\u0158\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u015f\3\2\2\2\u015e\u012f\3\2\2\2\u015e\u0132\3\2\2\2\u015e"+
		"\u0135\3\2\2\2\u015e\u0138\3\2\2\2\u015e\u013b\3\2\2\2\u015e\u0145\3\2"+
		"\2\2\u015e\u0148\3\2\2\2\u015e\u014b\3\2\2\2\u015e\u0151\3\2\2\2\u015e"+
		"\u0157\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161/\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\79\2\2\u0164\u016d"+
		"\7\5\2\2\u0165\u016a\5.\30\2\u0166\u0167\7\35\2\2\u0167\u0169\5.\30\2"+
		"\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u0165\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\7\6\2\2\u0170\61\3\2\2"+
		"\2\u0171\u0172\7\22\2\2\u0172\u0177\7\67\2\2\u0173\u0177\7\67\2\2\u0174"+
		"\u0177\78\2\2\u0175\u0177\7,\2\2\u0176\u0171\3\2\2\2\u0176\u0173\3\2\2"+
		"\2\u0176\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177\63\3\2\2\2\u0178\u0180"+
		"\58\35\2\u0179\u0180\5<\37\2\u017a\u0180\5:\36\2\u017b\u0180\5H%\2\u017c"+
		"\u0180\5R*\2\u017d\u0180\5Z.\2\u017e\u0180\5^\60\2\u017f\u0178\3\2\2\2"+
		"\u017f\u0179\3\2\2\2\u017f\u017a\3\2\2\2\u017f\u017b\3\2\2\2\u017f\u017c"+
		"\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180\65\3\2\2\2\u0181"+
		"\u0188\5> \2\u0182\u0188\5@!\2\u0183\u0188\5N(\2\u0184\u0188\5P)\2\u0185"+
		"\u0188\5T+\2\u0186\u0188\5\\/\2\u0187\u0181\3\2\2\2\u0187\u0182\3\2\2"+
		"\2\u0187\u0183\3\2\2\2\u0187\u0184\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0186"+
		"\3\2\2\2\u0188\67\3\2\2\2\u0189\u018a\7!\2\2\u018a\u018b\79\2\2\u018b"+
		"9\3\2\2\2\u018c\u018d\7!\2\2\u018d\u018e\7!\2\2\u018e\u018f\79\2\2\u018f"+
		";\3\2\2\2\u0190\u0191\7!\2\2\u0191\u0192\7\22\2\2\u0192\u0193\79\2\2\u0193"+
		"=\3\2\2\2\u0194\u0195\7!\2\2\u0195\u0196\7\21\2\2\u0196\u0197\79\2\2\u0197"+
		"?\3\2\2\2\u0198\u0199\7!\2\2\u0199\u019a\7\25\2\2\u019a\u019b\79\2\2\u019b"+
		"A\3\2\2\2\u019c\u019d\7!\2\2\u019d\u019e\7\23\2\2\u019eC\3\2\2\2\u019f"+
		"\u01a0\7!\2\2\u01a0\u01a1\7\32\2\2\u01a1E\3\2\2\2\u01a2\u01a3\7!\2\2\u01a3"+
		"\u01a4\7\31\2\2\u01a4G\3\2\2\2\u01a5\u01a8\5J&\2\u01a6\u01a8\5L\'\2\u01a7"+
		"\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8I\3\2\2\2\u01a9\u01aa\58\35\2"+
		"\u01aa\u01ab\7 \2\2\u01ab\u01ac\7\66\2\2\u01acK\3\2\2\2\u01ad\u01ae\5"+
		"<\37\2\u01ae\u01af\7 \2\2\u01af\u01b0\7\66\2\2\u01b0M\3\2\2\2\u01b1\u01b2"+
		"\5> \2\u01b2\u01b3\7 \2\2\u01b3\u01b4\7\66\2\2\u01b4O\3\2\2\2\u01b5\u01b6"+
		"\5@!\2\u01b6\u01b7\7 \2\2\u01b7\u01b8\7\66\2\2\u01b8Q\3\2\2\2\u01b9\u01ba"+
		"\58\35\2\u01ba\u01bb\7 \2\2\u01bb\u01bc\7\65\2\2\u01bc\u01c2\3\2\2\2\u01bd"+
		"\u01be\5<\37\2\u01be\u01bf\7 \2\2\u01bf\u01c0\7\65\2\2\u01c0\u01c2\3\2"+
		"\2\2\u01c1\u01b9\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c2S\3\2\2\2\u01c3\u01c6"+
		"\5V,\2\u01c4\u01c6\5X-\2\u01c5\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6"+
		"U\3\2\2\2\u01c7\u01c8\5> \2\u01c8\u01c9\7\30\2\2\u01c9\u01ca\79\2\2\u01ca"+
		"W\3\2\2\2\u01cb\u01cc\5@!\2\u01cc\u01cd\7\30\2\2\u01cd\u01ce\79\2\2\u01ce"+
		"Y\3\2\2\2\u01cf\u01d0\58\35\2\u01d0\u01d1\7\33\2\2\u01d1\u01d2\79\2\2"+
		"\u01d2\u01d8\3\2\2\2\u01d3\u01d4\5> \2\u01d4\u01d5\7\33\2\2\u01d5\u01d6"+
		"\79\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7\u01d3\3\2\2\2\u01d8"+
		"[\3\2\2\2\u01d9\u01da\5> \2\u01da\u01db\7$\2\2\u01db\u01dc\79\2\2\u01dc"+
		"]\3\2\2\2\u01dd\u01de\7\33\2\2\u01de\u01df\79\2\2\u01df_\3\2\2\2\u01e0"+
		"\u01e5\3\2\2\2\u01e1\u01e5\7\62\2\2\u01e2\u01e5\7\63\2\2\u01e3\u01e5\7"+
		"\64\2\2\u01e4\u01e0\3\2\2\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5a\3\2\2\2\u01e6\u01e7\7\3\2\2\u01e7c\3\2\2\2\u01e8"+
		"\u01e9\7\4\2\2\u01e9e\3\2\2\2.nry\u0081\u0086\u0089\u008f\u0093\u0099"+
		"\u009d\u00a0\u00a2\u00a5\u00a9\u00ac\u00b1\u00b4\u00b9\u00bd\u00c4\u00ca"+
		"\u00cd\u00d7\u00de\u00fb\u0103\u0127\u012d\u0142\u014d\u0154\u015c\u015e"+
		"\u0160\u016a\u016d\u0176\u017f\u0187\u01a7\u01c1\u01c5\u01d7\u01e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}