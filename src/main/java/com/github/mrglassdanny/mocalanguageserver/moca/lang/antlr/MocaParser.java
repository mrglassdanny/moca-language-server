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
		SPECIAL_COMMAND_ARG_NO_ROWS=36, SPECIAL_COMMAND_ARG_DUMMY_ARG=37, SUPPRESS_WARNINGS=38, 
		WHERE=39, AND=40, LIKE=41, OR=42, IS=43, NOT=44, NULL=45, IF=46, ELSE=47, 
		TRY=48, CATCH=49, FINALLY=50, REMOTE=51, PARALLEL=52, INPARALLEL=53, ONSTACK=54, 
		KEEP=55, NUMERIC_LITERAL=56, STRING_LITERAL=57, WORD=58, BLOCK_COMMENT=59, 
		WHITESPACE=60, NEWLINE=61;
	public static final int
		RULE_moca_script = 0, RULE_sequence = 1, RULE_stream = 2, RULE_group = 3, 
		RULE_statement = 4, RULE_block = 5, RULE_command = 6, RULE_verb_noun_clause = 7, 
		RULE_verb_noun_clause_arg = 8, RULE_verb_noun_clause_arg_expr = 9, RULE_sub_sequence = 10, 
		RULE_if_expr = 11, RULE_if_statement = 12, RULE_else_if_statement = 13, 
		RULE_else_statement = 14, RULE_try_block = 15, RULE_catch_single_expr = 16, 
		RULE_catch_multi_expr = 17, RULE_catch_sequence = 18, RULE_finally_sequence = 19, 
		RULE_redirect_expr = 20, RULE_remote_expr = 21, RULE_suppress_warnings_expr = 22, 
		RULE_expr = 23, RULE_function_expr = 24, RULE_literal_value = 25, RULE_at_variables = 26, 
		RULE_at_plus_variables = 27, RULE_at_variable = 28, RULE_environment_variable = 29, 
		RULE_at_minus_variable = 30, RULE_at_plus_variable = 31, RULE_at_mod_variable = 32, 
		RULE_at_star = 33, RULE_at_question = 34, RULE_at_bang = 35, RULE_at_keep_directives = 36, 
		RULE_at_keep_directive = 37, RULE_at_minus_keep_directive = 38, RULE_at_plus_keep_directive = 39, 
		RULE_at_mod_keep_directive = 40, RULE_at_onstack_directive = 41, RULE_at_plus_oldvar_directives = 42, 
		RULE_at_plus_oldvar_directive = 43, RULE_at_mod_oldvar_directive = 44, 
		RULE_at_type_cast_variable = 45, RULE_at_plus_type_cast_variable = 46, 
		RULE_at_plus_database_qualifier_variable = 47, RULE_at_mod_database_qualifier_variable = 48, 
		RULE_integration_variable = 49, RULE_remote_keyword = 50, RULE_groovy_script = 51, 
		RULE_sql_script = 52;
	public static final String[] ruleNames = {
		"moca_script", "sequence", "stream", "group", "statement", "block", "command", 
		"verb_noun_clause", "verb_noun_clause_arg", "verb_noun_clause_arg_expr", 
		"sub_sequence", "if_expr", "if_statement", "else_if_statement", "else_statement", 
		"try_block", "catch_single_expr", "catch_multi_expr", "catch_sequence", 
		"finally_sequence", "redirect_expr", "remote_expr", "suppress_warnings_expr", 
		"expr", "function_expr", "literal_value", "at_variables", "at_plus_variables", 
		"at_variable", "environment_variable", "at_minus_variable", "at_plus_variable", 
		"at_mod_variable", "at_star", "at_question", "at_bang", "at_keep_directives", 
		"at_keep_directive", "at_minus_keep_directive", "at_plus_keep_directive", 
		"at_mod_keep_directive", "at_onstack_directive", "at_plus_oldvar_directives", 
		"at_plus_oldvar_directive", "at_mod_oldvar_directive", "at_type_cast_variable", 
		"at_plus_type_cast_variable", "at_plus_database_qualifier_variable", "at_mod_database_qualifier_variable", 
		"integration_variable", "remote_keyword", "groovy_script", "sql_script"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'<'", "'>'", 
		"'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'\\'", 
		"'&'", "'^'", "'!'", "'?'", "':'", "';'", "','", "'|'", "'||'", "'#'", 
		"'@'", "'='", null, "'.'", "'<<OVERSTACKED_ARGS>>'", "'#NO_ROWS'", "'#DUMMY_ARG'", 
		"'@SuppressWarnings'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOUBLE_BRACKET_STRING", "SINGLE_BRACKET_STRING", "LEFT_PAREN", 
		"RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", 
		"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "DOUBLE_LESS", "DOUBLE_GREATER", 
		"PLUS", "MINUS", "STAR", "DIV", "MOD", "BACKSLASH", "AMPERSAND", "CARET", 
		"BANG", "QUESTION", "COLON", "SEMI_COLON", "COMMA", "PIPE", "DOUBLE_PIPE", 
		"POUND", "AT", "EQUAL", "NOT_EQUAL", "DOT", "OVERSTACKED_ARGS", "SPECIAL_COMMAND_ARG_NO_ROWS", 
		"SPECIAL_COMMAND_ARG_DUMMY_ARG", "SUPPRESS_WARNINGS", "WHERE", "AND", 
		"LIKE", "OR", "IS", "NOT", "NULL", "IF", "ELSE", "TRY", "CATCH", "FINALLY", 
		"REMOTE", "PARALLEL", "INPARALLEL", "ONSTACK", "KEEP", "NUMERIC_LITERAL", 
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
			setState(106);
			sequence();
			setState(107);
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
			setState(109);
			stream();
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(110);
					match(SEMI_COLON);
					setState(111);
					stream();
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(118);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(117);
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
			setState(120);
			group();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(121);
				match(PIPE);
				setState(122);
				group();
				}
				}
				setState(127);
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
			setState(128);
			statement();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(129);
				match(AMPERSAND);
				setState(130);
				statement();
				}
				}
				setState(135);
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
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(136);
				block();
				setState(138);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(137);
					catch_multi_expr();
					}
				}

				setState(141);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(140);
					redirect_expr();
					}
				}

				}
				break;
			case 2:
				{
				setState(143);
				if_statement();
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(144);
						else_if_statement();
						}
						} 
					}
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(150);
					else_statement();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(153);
				try_block();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(154);
					catch_sequence();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(160);
					finally_sequence();
					}
				}

				setState(164);
				_la = _input.LA(1);
				if (_la==DOUBLE_GREATER) {
					{
					setState(163);
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
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(168);
						remote_expr();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(172);
					_la = _input.LA(1);
					if (_la==SUPPRESS_WARNINGS) {
						{
						setState(171);
						suppress_warnings_expr();
						}
					}

					}
					break;
				}
				setState(176);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(178);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAREN) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL))) != 0)) {
						{
						setState(177);
						remote_expr();
						}
					}

					}
					break;
				case 2:
					{
					setState(181);
					_la = _input.LA(1);
					if (_la==SUPPRESS_WARNINGS) {
						{
						setState(180);
						suppress_warnings_expr();
						}
					}

					}
					break;
				}
				setState(185);
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
			setState(191);
			switch (_input.LA(1)) {
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				groovy_script();
				}
				break;
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
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
				setState(190);
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
			setState(194);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(193);
				match(CARET);
				}
			}

			setState(197); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(196);
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
				setState(199); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(210);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(201);
				match(WHERE);
				setState(202);
				verb_noun_clause_arg();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(203);
					match(AND);
					setState(204);
					verb_noun_clause_arg();
					}
					}
					setState(209);
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
		public At_plus_variablesContext at_plus_variables() {
			return getRuleContext(At_plus_variablesContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitVerb_noun_clause_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Verb_noun_clause_argContext verb_noun_clause_arg() throws RecognitionException {
		Verb_noun_clause_argContext _localctx = new Verb_noun_clause_argContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_verb_noun_clause_arg);
		int _la;
		try {
			setState(242);
			switch (_input.LA(1)) {
			case OVERSTACKED_ARGS:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(OVERSTACKED_ARGS);
				}
				break;
			case SPECIAL_COMMAND_ARG_NO_ROWS:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(SPECIAL_COMMAND_ARG_NO_ROWS);
				}
				break;
			case SPECIAL_COMMAND_ARG_DUMMY_ARG:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(SPECIAL_COMMAND_ARG_DUMMY_ARG);
				}
				break;
			case DOUBLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				groovy_script();
				}
				break;
			case SINGLE_BRACKET_STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 6);
				{
				setState(219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(217);
					at_star();
					}
					break;
				case 2:
					{
					setState(218);
					at_plus_variables();
					}
					break;
				}
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				match(WORD);
				setState(240);
				switch (_input.LA(1)) {
				case IS:
					{
					{
					setState(222);
					match(IS);
					setState(224);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(223);
						match(NOT);
						}
					}

					setState(226);
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
					setState(237);
					switch (_input.LA(1)) {
					case LIKE:
					case NOT:
						{
						setState(228);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(227);
							match(NOT);
							}
						}

						setState(230);
						match(LIKE);
						}
						break;
					case LESS:
						{
						setState(231);
						match(LESS);
						}
						break;
					case GREATER:
						{
						setState(232);
						match(GREATER);
						}
						break;
					case LESS_EQUAL:
						{
						setState(233);
						match(LESS_EQUAL);
						}
						break;
					case GREATER_EQUAL:
						{
						setState(234);
						match(GREATER_EQUAL);
						}
						break;
					case EQUAL:
						{
						setState(235);
						match(EQUAL);
						}
						break;
					case NOT_EQUAL:
						{
						setState(236);
						match(NOT_EQUAL);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(239);
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
		public At_variablesContext at_variables() {
			return getRuleContext(At_variablesContext.class,0);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_verb_noun_clause_arg_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(245);
				literal_value();
				}
				break;
			case 2:
				{
				setState(246);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(247);
				at_variables();
				}
				break;
			case 4:
				{
				setState(248);
				at_bang();
				}
				break;
			case 5:
				{
				setState(249);
				at_question();
				}
				break;
			case 6:
				{
				setState(250);
				at_star();
				}
				break;
			case 7:
				{
				setState(251);
				function_expr();
				}
				break;
			case 8:
				{
				setState(252);
				groovy_script();
				}
				break;
			case 9:
				{
				setState(253);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 10:
				{
				{
				setState(254);
				match(BANG);
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(255);
					literal_value();
					}
					break;
				case 2:
					{
					setState(256);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(257);
					at_variables();
					}
					break;
				case 4:
					{
					setState(258);
					at_bang();
					}
					break;
				case 5:
					{
					setState(259);
					at_question();
					}
					break;
				case 6:
					{
					setState(260);
					at_star();
					}
					break;
				case 7:
					{
					setState(261);
					function_expr();
					}
					break;
				case 8:
					{
					setState(262);
					groovy_script();
					}
					break;
				case 9:
					{
					setState(263);
					match(SINGLE_BRACKET_STRING);
					}
					break;
				case 10:
					{
					setState(264);
					verb_noun_clause_arg_expr(0);
					}
					break;
				}
				}
				}
				break;
			case 11:
				{
				setState(267);
				match(LEFT_PAREN);
				setState(268);
				verb_noun_clause_arg_expr(0);
				setState(269);
				match(AND);
				setState(270);
				verb_noun_clause_arg_expr(0);
				setState(271);
				match(RIGHT_PAREN);
				}
				break;
			case 12:
				{
				setState(273);
				match(LEFT_PAREN);
				setState(274);
				verb_noun_clause_arg_expr(0);
				setState(275);
				match(OR);
				setState(276);
				verb_noun_clause_arg_expr(0);
				setState(277);
				match(RIGHT_PAREN);
				}
				break;
			case 13:
				{
				setState(279);
				match(LEFT_PAREN);
				setState(280);
				verb_noun_clause_arg_expr(0);
				setState(281);
				match(RIGHT_PAREN);
				}
				break;
			case 14:
				{
				setState(283);
				match(LEFT_PAREN);
				setState(284);
				verb_noun_clause_arg_expr(0);
				setState(286);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(285);
					match(NOT);
					}
				}

				{
				setState(288);
				match(LIKE);
				}
				setState(289);
				verb_noun_clause_arg_expr(0);
				setState(290);
				match(RIGHT_PAREN);
				}
				break;
			case 15:
				{
				setState(292);
				match(LEFT_PAREN);
				setState(293);
				verb_noun_clause_arg_expr(0);
				setState(298);
				switch (_input.LA(1)) {
				case IS:
					{
					setState(294);
					match(IS);
					}
					break;
				case NULL:
					{
					setState(295);
					match(NULL);
					}
					break;
				case NOT:
					{
					setState(296);
					match(NOT);
					setState(297);
					match(NULL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(300);
				match(RIGHT_PAREN);
				}
				break;
			case 16:
				{
				setState(302);
				match(LEFT_PAREN);
				setState(303);
				verb_noun_clause_arg_expr(0);
				setState(304);
				match(IS);
				setState(306);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(305);
					match(NOT);
					}
				}

				setState(308);
				verb_noun_clause_arg_expr(0);
				setState(309);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(335);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(313);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(314);
						match(DOUBLE_PIPE);
						setState(315);
						verb_noun_clause_arg_expr(12);
						}
						break;
					case 2:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(316);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(317);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(318);
						verb_noun_clause_arg_expr(11);
						}
						break;
					case 3:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(319);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(320);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(321);
						verb_noun_clause_arg_expr(10);
						}
						break;
					case 4:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(322);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(323);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(324);
						verb_noun_clause_arg_expr(9);
						}
						break;
					case 5:
						{
						_localctx = new Verb_noun_clause_arg_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_verb_noun_clause_arg_expr);
						setState(325);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(332);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
						case 1:
							{
							setState(326);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(327);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(328);
							match(IS);
							}
							break;
						case 4:
							{
							setState(329);
							match(IS);
							setState(330);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(331);
							match(LIKE);
							}
							break;
						}
						setState(334);
						verb_noun_clause_arg_expr(8);
						}
						break;
					}
					} 
				}
				setState(339);
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
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(LEFT_BRACE);
				setState(341);
				sequence();
				setState(342);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				match(LEFT_BRACE);
				setState(345);
				sub_sequence();
				setState(346);
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
			setState(350);
			match(IF);
			setState(351);
			match(LEFT_PAREN);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				{
				setState(352);
				expr(0);
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
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
			setState(360);
			if_expr();
			setState(361);
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
			setState(363);
			match(ELSE);
			setState(364);
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
			setState(366);
			match(ELSE);
			setState(367);
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
			setState(369);
			match(TRY);
			setState(370);
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
			setState(372);
			match(CATCH);
			setState(373);
			match(LEFT_PAREN);
			setState(374);
			expr(0);
			setState(375);
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
			setState(377);
			match(CATCH);
			setState(378);
			match(LEFT_PAREN);
			setState(379);
			expr(0);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(380);
				match(COMMA);
				setState(381);
				expr(0);
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
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
			setState(389);
			catch_single_expr();
			setState(390);
			match(LEFT_BRACE);
			setState(392);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << CARET) | (1L << SUPPRESS_WARNINGS) | (1L << AND) | (1L << LIKE) | (1L << OR) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << IF) | (1L << ELSE) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << REMOTE) | (1L << PARALLEL) | (1L << INPARALLEL) | (1L << ONSTACK) | (1L << KEEP) | (1L << WORD))) != 0)) {
				{
				setState(391);
				sequence();
				}
			}

			setState(394);
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
			setState(396);
			match(FINALLY);
			setState(397);
			match(LEFT_BRACE);
			setState(398);
			sequence();
			setState(399);
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
			setState(401);
			match(DOUBLE_GREATER);
			setState(402);
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
			setState(404);
			remote_keyword();
			setState(405);
			match(LEFT_PAREN);
			setState(406);
			expr(0);
			setState(407);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitSuppress_warnings_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suppress_warnings_exprContext suppress_warnings_expr() throws RecognitionException {
		Suppress_warnings_exprContext _localctx = new Suppress_warnings_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_suppress_warnings_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(SUPPRESS_WARNINGS);
			setState(410);
			match(LEFT_PAREN);
			setState(411);
			expr(0);
			setState(412);
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
		public At_variablesContext at_variables() {
			return getRuleContext(At_variablesContext.class,0);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(415);
				literal_value();
				}
				break;
			case 2:
				{
				setState(416);
				match(WORD);
				}
				break;
			case 3:
				{
				setState(417);
				at_variables();
				}
				break;
			case 4:
				{
				setState(418);
				at_bang();
				}
				break;
			case 5:
				{
				setState(419);
				at_question();
				}
				break;
			case 6:
				{
				setState(420);
				at_star();
				}
				break;
			case 7:
				{
				setState(421);
				function_expr();
				}
				break;
			case 8:
				{
				setState(422);
				groovy_script();
				}
				break;
			case 9:
				{
				setState(423);
				match(SINGLE_BRACKET_STRING);
				}
				break;
			case 10:
				{
				{
				setState(424);
				match(BANG);
				setState(435);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(425);
					literal_value();
					}
					break;
				case 2:
					{
					setState(426);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(427);
					at_variables();
					}
					break;
				case 4:
					{
					setState(428);
					at_bang();
					}
					break;
				case 5:
					{
					setState(429);
					at_question();
					}
					break;
				case 6:
					{
					setState(430);
					at_star();
					}
					break;
				case 7:
					{
					setState(431);
					function_expr();
					}
					break;
				case 8:
					{
					setState(432);
					groovy_script();
					}
					break;
				case 9:
					{
					setState(433);
					match(SINGLE_BRACKET_STRING);
					}
					break;
				case 10:
					{
					setState(434);
					expr(0);
					}
					break;
				}
				}
				}
				break;
			case 11:
				{
				setState(437);
				match(LEFT_PAREN);
				setState(438);
				expr(0);
				setState(439);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(490);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(443);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(444);
						match(DOUBLE_PIPE);
						setState(445);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(446);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(447);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(448);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(449);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(450);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(451);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(452);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(453);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << GREATER_EQUAL))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(454);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(455);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(462);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
						case 1:
							{
							setState(456);
							match(EQUAL);
							}
							break;
						case 2:
							{
							setState(457);
							match(NOT_EQUAL);
							}
							break;
						case 3:
							{
							setState(458);
							match(IS);
							}
							break;
						case 4:
							{
							setState(459);
							match(IS);
							setState(460);
							match(NOT);
							}
							break;
						case 5:
							{
							setState(461);
							match(LIKE);
							}
							break;
						}
						setState(464);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(465);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(466);
						match(AND);
						setState(467);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(468);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(469);
						match(OR);
						setState(470);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(471);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(473);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(472);
							match(NOT);
							}
						}

						{
						setState(475);
						match(LIKE);
						}
						setState(476);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(477);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(478);
						match(IS);
						setState(480);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(479);
							match(NOT);
							}
						}

						setState(482);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(483);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(488);
						switch (_input.LA(1)) {
						case IS:
							{
							setState(484);
							match(IS);
							}
							break;
						case NULL:
							{
							setState(485);
							match(NULL);
							}
							break;
						case NOT:
							{
							setState(486);
							match(NOT);
							setState(487);
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
				setState(494);
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
			setState(495);
			match(WORD);
			setState(496);
			match(LEFT_PAREN);
			setState(505);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_BRACKET_STRING) | (1L << SINGLE_BRACKET_STRING) | (1L << LEFT_PAREN) | (1L << MINUS) | (1L << BANG) | (1L << COLON) | (1L << AT) | (1L << NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << WORD))) != 0)) {
				{
				setState(497);
				expr(0);
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(498);
					match(COMMA);
					setState(499);
					expr(0);
					}
					}
					setState(504);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(507);
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
			setState(514);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				match(MINUS);
				setState(510);
				match(NUMERIC_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(NUMERIC_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(512);
				match(STRING_LITERAL);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(513);
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

	public static class At_variablesContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public At_minus_variableContext at_minus_variable() {
			return getRuleContext(At_minus_variableContext.class,0);
		}
		public Environment_variableContext environment_variable() {
			return getRuleContext(Environment_variableContext.class,0);
		}
		public At_keep_directivesContext at_keep_directives() {
			return getRuleContext(At_keep_directivesContext.class,0);
		}
		public At_onstack_directiveContext at_onstack_directive() {
			return getRuleContext(At_onstack_directiveContext.class,0);
		}
		public At_type_cast_variableContext at_type_cast_variable() {
			return getRuleContext(At_type_cast_variableContext.class,0);
		}
		public Integration_variableContext integration_variable() {
			return getRuleContext(Integration_variableContext.class,0);
		}
		public At_variablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_variables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_variables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_variables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_variablesContext at_variables() throws RecognitionException {
		At_variablesContext _localctx = new At_variablesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_at_variables);
		try {
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				at_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				at_minus_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				environment_variable();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				at_keep_directives();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(520);
				at_onstack_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(521);
				at_type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(522);
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

	public static class At_plus_variablesContext extends ParserRuleContext {
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
		public At_plus_oldvar_directivesContext at_plus_oldvar_directives() {
			return getRuleContext(At_plus_oldvar_directivesContext.class,0);
		}
		public At_plus_type_cast_variableContext at_plus_type_cast_variable() {
			return getRuleContext(At_plus_type_cast_variableContext.class,0);
		}
		public At_plus_database_qualifier_variableContext at_plus_database_qualifier_variable() {
			return getRuleContext(At_plus_database_qualifier_variableContext.class,0);
		}
		public At_mod_database_qualifier_variableContext at_mod_database_qualifier_variable() {
			return getRuleContext(At_mod_database_qualifier_variableContext.class,0);
		}
		public At_plus_variablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_variables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_variables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_variables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_variablesContext at_plus_variables() throws RecognitionException {
		At_plus_variablesContext _localctx = new At_plus_variablesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_at_plus_variables);
		try {
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(525);
				at_plus_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(526);
				at_mod_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(527);
				at_plus_keep_directive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(528);
				at_mod_keep_directive();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(529);
				at_plus_oldvar_directives();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(530);
				at_plus_type_cast_variable();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(531);
				at_plus_database_qualifier_variable();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(532);
				at_mod_database_qualifier_variable();
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
		enterRule(_localctx, 56, RULE_at_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(AT);
			setState(536);
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
		enterRule(_localctx, 58, RULE_environment_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			match(AT);
			setState(539);
			match(AT);
			setState(540);
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
		enterRule(_localctx, 60, RULE_at_minus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(AT);
			setState(543);
			match(MINUS);
			setState(544);
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
		enterRule(_localctx, 62, RULE_at_plus_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(AT);
			setState(547);
			match(PLUS);
			setState(548);
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
		enterRule(_localctx, 64, RULE_at_mod_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(AT);
			setState(551);
			match(MOD);
			setState(552);
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
		enterRule(_localctx, 66, RULE_at_star);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(AT);
			setState(555);
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
		enterRule(_localctx, 68, RULE_at_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(AT);
			setState(558);
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
		enterRule(_localctx, 70, RULE_at_bang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(AT);
			setState(561);
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

	public static class At_keep_directivesContext extends ParserRuleContext {
		public At_keep_directiveContext at_keep_directive() {
			return getRuleContext(At_keep_directiveContext.class,0);
		}
		public At_minus_keep_directiveContext at_minus_keep_directive() {
			return getRuleContext(At_minus_keep_directiveContext.class,0);
		}
		public At_keep_directivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_keep_directives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_keep_directives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_keep_directives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_keep_directives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_keep_directivesContext at_keep_directives() throws RecognitionException {
		At_keep_directivesContext _localctx = new At_keep_directivesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_at_keep_directives);
		try {
			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				at_keep_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(564);
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
		enterRule(_localctx, 74, RULE_at_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			at_variable();
			setState(568);
			match(POUND);
			setState(569);
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
		enterRule(_localctx, 76, RULE_at_minus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			at_minus_variable();
			setState(572);
			match(POUND);
			setState(573);
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
		enterRule(_localctx, 78, RULE_at_plus_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			at_plus_variable();
			setState(576);
			match(POUND);
			setState(577);
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
		enterRule(_localctx, 80, RULE_at_mod_keep_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			at_mod_variable();
			setState(580);
			match(POUND);
			setState(581);
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

	public static class At_onstack_directiveContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public TerminalNode POUND() { return getToken(MocaParser.POUND, 0); }
		public TerminalNode ONSTACK() { return getToken(MocaParser.ONSTACK, 0); }
		public At_minus_variableContext at_minus_variable() {
			return getRuleContext(At_minus_variableContext.class,0);
		}
		public At_onstack_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_onstack_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_onstack_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_onstack_directive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_onstack_directive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_onstack_directiveContext at_onstack_directive() throws RecognitionException {
		At_onstack_directiveContext _localctx = new At_onstack_directiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_at_onstack_directive);
		try {
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(583);
				at_variable();
				setState(584);
				match(POUND);
				setState(585);
				match(ONSTACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				at_minus_variable();
				setState(588);
				match(POUND);
				setState(589);
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

	public static class At_plus_oldvar_directivesContext extends ParserRuleContext {
		public At_plus_oldvar_directiveContext at_plus_oldvar_directive() {
			return getRuleContext(At_plus_oldvar_directiveContext.class,0);
		}
		public At_mod_oldvar_directiveContext at_mod_oldvar_directive() {
			return getRuleContext(At_mod_oldvar_directiveContext.class,0);
		}
		public At_plus_oldvar_directivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_oldvar_directives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_oldvar_directives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_oldvar_directives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_oldvar_directives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_oldvar_directivesContext at_plus_oldvar_directives() throws RecognitionException {
		At_plus_oldvar_directivesContext _localctx = new At_plus_oldvar_directivesContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_at_plus_oldvar_directives);
		try {
			setState(595);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(593);
				at_plus_oldvar_directive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
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
		enterRule(_localctx, 86, RULE_at_plus_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			at_plus_variable();
			setState(598);
			match(CARET);
			setState(599);
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
		enterRule(_localctx, 88, RULE_at_mod_oldvar_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			at_mod_variable();
			setState(602);
			match(CARET);
			setState(603);
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

	public static class At_type_cast_variableContext extends ParserRuleContext {
		public At_variableContext at_variable() {
			return getRuleContext(At_variableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_type_cast_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_type_cast_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_type_cast_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_type_cast_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_type_cast_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_type_cast_variableContext at_type_cast_variable() throws RecognitionException {
		At_type_cast_variableContext _localctx = new At_type_cast_variableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_at_type_cast_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			at_variable();
			setState(606);
			match(COLON);
			setState(607);
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

	public static class At_plus_type_cast_variableContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MocaParser.COLON, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_plus_type_cast_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_type_cast_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_type_cast_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_type_cast_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_type_cast_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_type_cast_variableContext at_plus_type_cast_variable() throws RecognitionException {
		At_plus_type_cast_variableContext _localctx = new At_plus_type_cast_variableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_at_plus_type_cast_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			at_plus_variable();
			setState(610);
			match(COLON);
			setState(611);
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

	public static class At_plus_database_qualifier_variableContext extends ParserRuleContext {
		public At_plus_variableContext at_plus_variable() {
			return getRuleContext(At_plus_variableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MocaParser.DOT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_plus_database_qualifier_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_plus_database_qualifier_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_plus_database_qualifier_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_plus_database_qualifier_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_plus_database_qualifier_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_plus_database_qualifier_variableContext at_plus_database_qualifier_variable() throws RecognitionException {
		At_plus_database_qualifier_variableContext _localctx = new At_plus_database_qualifier_variableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_at_plus_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			at_plus_variable();
			setState(614);
			match(DOT);
			setState(615);
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

	public static class At_mod_database_qualifier_variableContext extends ParserRuleContext {
		public At_mod_variableContext at_mod_variable() {
			return getRuleContext(At_mod_variableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MocaParser.DOT, 0); }
		public TerminalNode WORD() { return getToken(MocaParser.WORD, 0); }
		public At_mod_database_qualifier_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_mod_database_qualifier_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).enterAt_mod_database_qualifier_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MocaListener ) ((MocaListener)listener).exitAt_mod_database_qualifier_variable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MocaVisitor ) return ((MocaVisitor<? extends T>)visitor).visitAt_mod_database_qualifier_variable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final At_mod_database_qualifier_variableContext at_mod_database_qualifier_variable() throws RecognitionException {
		At_mod_database_qualifier_variableContext _localctx = new At_mod_database_qualifier_variableContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_at_mod_database_qualifier_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			at_mod_variable();
			setState(618);
			match(DOT);
			setState(619);
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
		enterRule(_localctx, 98, RULE_integration_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(COLON);
			setState(622);
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
		enterRule(_localctx, 100, RULE_remote_keyword);
		try {
			setState(628);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case REMOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(625);
				match(REMOTE);
				}
				break;
			case PARALLEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(626);
				match(PARALLEL);
				}
				break;
			case INPARALLEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(627);
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
		enterRule(_localctx, 102, RULE_groovy_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
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
		enterRule(_localctx, 104, RULE_sql_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u027d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\3\3\3\3\3\7\3s\n\3\f\3\16\3v\13"+
		"\3\3\3\5\3y\n\3\3\4\3\4\3\4\7\4~\n\4\f\4\16\4\u0081\13\4\3\5\3\5\3\5\7"+
		"\5\u0086\n\5\f\5\16\5\u0089\13\5\3\6\3\6\5\6\u008d\n\6\3\6\5\6\u0090\n"+
		"\6\3\6\3\6\7\6\u0094\n\6\f\6\16\6\u0097\13\6\3\6\5\6\u009a\n\6\3\6\3\6"+
		"\7\6\u009e\n\6\f\6\16\6\u00a1\13\6\3\6\5\6\u00a4\n\6\3\6\5\6\u00a7\n\6"+
		"\5\6\u00a9\n\6\3\7\5\7\u00ac\n\7\3\7\5\7\u00af\n\7\5\7\u00b1\n\7\3\7\3"+
		"\7\5\7\u00b5\n\7\3\7\5\7\u00b8\n\7\5\7\u00ba\n\7\3\7\5\7\u00bd\n\7\3\b"+
		"\3\b\3\b\5\b\u00c2\n\b\3\t\5\t\u00c5\n\t\3\t\6\t\u00c8\n\t\r\t\16\t\u00c9"+
		"\3\t\3\t\3\t\3\t\7\t\u00d0\n\t\f\t\16\t\u00d3\13\t\5\t\u00d5\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00de\n\n\3\n\3\n\3\n\5\n\u00e3\n\n\3\n\3\n"+
		"\5\n\u00e7\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00f0\n\n\3\n\5\n\u00f3"+
		"\n\n\5\n\u00f5\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u010c\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0121\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u012d\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0135\n\13\3\13\3\13\3\13\5\13\u013a\n\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u014f\n\13\3\13\7\13\u0152\n\13\f\13\16\13\u0155\13\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u015f\n\f\3\r\3\r\3\r\7\r\u0164\n\r\f\r\16\r"+
		"\u0167\13\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u0181"+
		"\n\23\f\23\16\23\u0184\13\23\3\23\3\23\3\24\3\24\3\24\5\24\u018b\n\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u01b6\n\31\3\31\3\31\3\31\3\31\5\31\u01bc\n\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u01d1\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u01dc\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u01e3\n\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\5\31\u01eb\n\31\7\31\u01ed\n\31\f\31\16\31\u01f0\13\31\3"+
		"\32\3\32\3\32\3\32\3\32\7\32\u01f7\n\32\f\32\16\32\u01fa\13\32\5\32\u01fc"+
		"\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0205\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u020e\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u0218\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\5&\u0238\n"+
		"&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\5+\u0252\n+\3,\3,\5,\u0256\n,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\5\64\u0277\n\64\3\65\3\65\3\66\3\66\3\66"+
		"\2\4\24\60\67\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\6\4\2*9<<\3\2\23\25\3\2\21\22\3\2\13"+
		"\16\u02d7\2l\3\2\2\2\4o\3\2\2\2\6z\3\2\2\2\b\u0082\3\2\2\2\n\u00a8\3\2"+
		"\2\2\f\u00bc\3\2\2\2\16\u00c1\3\2\2\2\20\u00c4\3\2\2\2\22\u00f4\3\2\2"+
		"\2\24\u0139\3\2\2\2\26\u015e\3\2\2\2\30\u0160\3\2\2\2\32\u016a\3\2\2\2"+
		"\34\u016d\3\2\2\2\36\u0170\3\2\2\2 \u0173\3\2\2\2\"\u0176\3\2\2\2$\u017b"+
		"\3\2\2\2&\u0187\3\2\2\2(\u018e\3\2\2\2*\u0193\3\2\2\2,\u0196\3\2\2\2."+
		"\u019b\3\2\2\2\60\u01bb\3\2\2\2\62\u01f1\3\2\2\2\64\u0204\3\2\2\2\66\u020d"+
		"\3\2\2\28\u0217\3\2\2\2:\u0219\3\2\2\2<\u021c\3\2\2\2>\u0220\3\2\2\2@"+
		"\u0224\3\2\2\2B\u0228\3\2\2\2D\u022c\3\2\2\2F\u022f\3\2\2\2H\u0232\3\2"+
		"\2\2J\u0237\3\2\2\2L\u0239\3\2\2\2N\u023d\3\2\2\2P\u0241\3\2\2\2R\u0245"+
		"\3\2\2\2T\u0251\3\2\2\2V\u0255\3\2\2\2X\u0257\3\2\2\2Z\u025b\3\2\2\2\\"+
		"\u025f\3\2\2\2^\u0263\3\2\2\2`\u0267\3\2\2\2b\u026b\3\2\2\2d\u026f\3\2"+
		"\2\2f\u0276\3\2\2\2h\u0278\3\2\2\2j\u027a\3\2\2\2lm\5\4\3\2mn\7\2\2\3"+
		"n\3\3\2\2\2ot\5\6\4\2pq\7\34\2\2qs\5\6\4\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wy\7\34\2\2xw\3\2\2\2xy\3\2\2\2y\5\3\2"+
		"\2\2z\177\5\b\5\2{|\7\36\2\2|~\5\b\5\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\7\3\2\2\2\u0081\177\3\2\2\2\u0082\u0087"+
		"\5\n\6\2\u0083\u0084\7\27\2\2\u0084\u0086\5\n\6\2\u0085\u0083\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\t\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\f\7\2\u008b\u008d\5$\23\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0090\5*"+
		"\26\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u00a9\3\2\2\2\u0091"+
		"\u0095\5\32\16\2\u0092\u0094\5\34\17\2\u0093\u0092\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009a\5\36\20\2\u0099\u0098\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u00a9\3\2\2\2\u009b\u009f\5 \21\2\u009c\u009e\5&\24\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5(\25\2\u00a3"+
		"\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\5*"+
		"\26\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u008a\3\2\2\2\u00a8\u0091\3\2\2\2\u00a8\u009b\3\2\2\2\u00a9\13\3\2\2"+
		"\2\u00aa\u00ac\5,\27\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b1"+
		"\3\2\2\2\u00ad\u00af\5.\30\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00bd\5\16\b\2\u00b3\u00b5\5,\27\2\u00b4\u00b3\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00ba\3\2\2\2\u00b6\u00b8\5.\30\2\u00b7\u00b6\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\5\26\f\2\u00bc\u00b0\3"+
		"\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\r\3\2\2\2\u00be\u00c2\5h\65\2\u00bf\u00c2"+
		"\5j\66\2\u00c0\u00c2\5\20\t\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\17\3\2\2\2\u00c3\u00c5\7\30\2\2\u00c4\u00c3"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c8\t\2\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00d4\3\2\2\2\u00cb\u00cc\7)\2\2\u00cc\u00d1\5\22\n\2\u00cd"+
		"\u00ce\7*\2\2\u00ce\u00d0\5\22\n\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00cb\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\21\3\2\2"+
		"\2\u00d6\u00f5\7%\2\2\u00d7\u00f5\7&\2\2\u00d8\u00f5\7\'\2\2\u00d9\u00f5"+
		"\5h\65\2\u00da\u00f5\7\4\2\2\u00db\u00de\5D#\2\u00dc\u00de\58\35\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00f5\3\2\2\2\u00df\u00f2\7<"+
		"\2\2\u00e0\u00e2\7-\2\2\u00e1\u00e3\7.\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00f3\7/\2\2\u00e5\u00e7\7.\2\2\u00e6"+
		"\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00f0\7+"+
		"\2\2\u00e9\u00f0\7\13\2\2\u00ea\u00f0\7\f\2\2\u00eb\u00f0\7\r\2\2\u00ec"+
		"\u00f0\7\16\2\2\u00ed\u00f0\7\"\2\2\u00ee\u00f0\7#\2\2\u00ef\u00e6\3\2"+
		"\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ea\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef"+
		"\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f3\5\24\13\2\u00f2\u00e0\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00d6\3\2\2\2\u00f4\u00d7\3\2\2\2\u00f4\u00d8\3\2"+
		"\2\2\u00f4\u00d9\3\2\2\2\u00f4\u00da\3\2\2\2\u00f4\u00dd\3\2\2\2\u00f4"+
		"\u00df\3\2\2\2\u00f5\23\3\2\2\2\u00f6\u00f7\b\13\1\2\u00f7\u013a\5\64"+
		"\33\2\u00f8\u013a\7<\2\2\u00f9\u013a\5\66\34\2\u00fa\u013a\5H%\2\u00fb"+
		"\u013a\5F$\2\u00fc\u013a\5D#\2\u00fd\u013a\5\62\32\2\u00fe\u013a\5h\65"+
		"\2\u00ff\u013a\7\4\2\2\u0100\u010b\7\31\2\2\u0101\u010c\5\64\33\2\u0102"+
		"\u010c\7<\2\2\u0103\u010c\5\66\34\2\u0104\u010c\5H%\2\u0105\u010c\5F$"+
		"\2\u0106\u010c\5D#\2\u0107\u010c\5\62\32\2\u0108\u010c\5h\65\2\u0109\u010c"+
		"\7\4\2\2\u010a\u010c\5\24\13\2\u010b\u0101\3\2\2\2\u010b\u0102\3\2\2\2"+
		"\u010b\u0103\3\2\2\2\u010b\u0104\3\2\2\2\u010b\u0105\3\2\2\2\u010b\u0106"+
		"\3\2\2\2\u010b\u0107\3\2\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010a\3\2\2\2\u010c\u013a\3\2\2\2\u010d\u010e\7\5\2\2\u010e\u010f\5\24"+
		"\13\2\u010f\u0110\7*\2\2\u0110\u0111\5\24\13\2\u0111\u0112\7\6\2\2\u0112"+
		"\u013a\3\2\2\2\u0113\u0114\7\5\2\2\u0114\u0115\5\24\13\2\u0115\u0116\7"+
		",\2\2\u0116\u0117\5\24\13\2\u0117\u0118\7\6\2\2\u0118\u013a\3\2\2\2\u0119"+
		"\u011a\7\5\2\2\u011a\u011b\5\24\13\2\u011b\u011c\7\6\2\2\u011c\u013a\3"+
		"\2\2\2\u011d\u011e\7\5\2\2\u011e\u0120\5\24\13\2\u011f\u0121\7.\2\2\u0120"+
		"\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\7+"+
		"\2\2\u0123\u0124\5\24\13\2\u0124\u0125\7\6\2\2\u0125\u013a\3\2\2\2\u0126"+
		"\u0127\7\5\2\2\u0127\u012c\5\24\13\2\u0128\u012d\7-\2\2\u0129\u012d\7"+
		"/\2\2\u012a\u012b\7.\2\2\u012b\u012d\7/\2\2\u012c\u0128\3\2\2\2\u012c"+
		"\u0129\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7\6"+
		"\2\2\u012f\u013a\3\2\2\2\u0130\u0131\7\5\2\2\u0131\u0132\5\24\13\2\u0132"+
		"\u0134\7-\2\2\u0133\u0135\7.\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2"+
		"\2\u0135\u0136\3\2\2\2\u0136\u0137\5\24\13\2\u0137\u0138\7\6\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u00f6\3\2\2\2\u0139\u00f8\3\2\2\2\u0139\u00f9\3\2"+
		"\2\2\u0139\u00fa\3\2\2\2\u0139\u00fb\3\2\2\2\u0139\u00fc\3\2\2\2\u0139"+
		"\u00fd\3\2\2\2\u0139\u00fe\3\2\2\2\u0139\u00ff\3\2\2\2\u0139\u0100\3\2"+
		"\2\2\u0139\u010d\3\2\2\2\u0139\u0113\3\2\2\2\u0139\u0119\3\2\2\2\u0139"+
		"\u011d\3\2\2\2\u0139\u0126\3\2\2\2\u0139\u0130\3\2\2\2\u013a\u0153\3\2"+
		"\2\2\u013b\u013c\f\r\2\2\u013c\u013d\7\37\2\2\u013d\u0152\5\24\13\16\u013e"+
		"\u013f\f\f\2\2\u013f\u0140\t\3\2\2\u0140\u0152\5\24\13\r\u0141\u0142\f"+
		"\13\2\2\u0142\u0143\t\4\2\2\u0143\u0152\5\24\13\f\u0144\u0145\f\n\2\2"+
		"\u0145\u0146\t\5\2\2\u0146\u0152\5\24\13\13\u0147\u014e\f\t\2\2\u0148"+
		"\u014f\7\"\2\2\u0149\u014f\7#\2\2\u014a\u014f\7-\2\2\u014b\u014c\7-\2"+
		"\2\u014c\u014f\7.\2\2\u014d\u014f\7+\2\2\u014e\u0148\3\2\2\2\u014e\u0149"+
		"\3\2\2\2\u014e\u014a\3\2\2\2\u014e\u014b\3\2\2\2\u014e\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0152\5\24\13\n\u0151\u013b\3\2\2\2\u0151\u013e\3"+
		"\2\2\2\u0151\u0141\3\2\2\2\u0151\u0144\3\2\2\2\u0151\u0147\3\2\2\2\u0152"+
		"\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\25\3\2\2"+
		"\2\u0155\u0153\3\2\2\2\u0156\u0157\7\7\2\2\u0157\u0158\5\4\3\2\u0158\u0159"+
		"\7\b\2\2\u0159\u015f\3\2\2\2\u015a\u015b\7\7\2\2\u015b\u015c\5\26\f\2"+
		"\u015c\u015d\7\b\2\2\u015d\u015f\3\2\2\2\u015e\u0156\3\2\2\2\u015e\u015a"+
		"\3\2\2\2\u015f\27\3\2\2\2\u0160\u0161\7\60\2\2\u0161\u0165\7\5\2\2\u0162"+
		"\u0164\5\60\31\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3"+
		"\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u0169\7\6\2\2\u0169\31\3\2\2\2\u016a\u016b\5\30\r\2\u016b\u016c\5\n\6"+
		"\2\u016c\33\3\2\2\2\u016d\u016e\7\61\2\2\u016e\u016f\5\32\16\2\u016f\35"+
		"\3\2\2\2\u0170\u0171\7\61\2\2\u0171\u0172\5\n\6\2\u0172\37\3\2\2\2\u0173"+
		"\u0174\7\62\2\2\u0174\u0175\5\f\7\2\u0175!\3\2\2\2\u0176\u0177\7\63\2"+
		"\2\u0177\u0178\7\5\2\2\u0178\u0179\5\60\31\2\u0179\u017a\7\6\2\2\u017a"+
		"#\3\2\2\2\u017b\u017c\7\63\2\2\u017c\u017d\7\5\2\2\u017d\u0182\5\60\31"+
		"\2\u017e\u017f\7\35\2\2\u017f\u0181\5\60\31\2\u0180\u017e\3\2\2\2\u0181"+
		"\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2"+
		"\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7\6\2\2\u0186%\3\2\2\2\u0187\u0188"+
		"\5\"\22\2\u0188\u018a\7\7\2\2\u0189\u018b\5\4\3\2\u018a\u0189\3\2\2\2"+
		"\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7\b\2\2\u018d\'\3"+
		"\2\2\2\u018e\u018f\7\64\2\2\u018f\u0190\7\7\2\2\u0190\u0191\5\4\3\2\u0191"+
		"\u0192\7\b\2\2\u0192)\3\2\2\2\u0193\u0194\7\20\2\2\u0194\u0195\7<\2\2"+
		"\u0195+\3\2\2\2\u0196\u0197\5f\64\2\u0197\u0198\7\5\2\2\u0198\u0199\5"+
		"\60\31\2\u0199\u019a\7\6\2\2\u019a-\3\2\2\2\u019b\u019c\7(\2\2\u019c\u019d"+
		"\7\5\2\2\u019d\u019e\5\60\31\2\u019e\u019f\7\6\2\2\u019f/\3\2\2\2\u01a0"+
		"\u01a1\b\31\1\2\u01a1\u01bc\5\64\33\2\u01a2\u01bc\7<\2\2\u01a3\u01bc\5"+
		"\66\34\2\u01a4\u01bc\5H%\2\u01a5\u01bc\5F$\2\u01a6\u01bc\5D#\2\u01a7\u01bc"+
		"\5\62\32\2\u01a8\u01bc\5h\65\2\u01a9\u01bc\7\4\2\2\u01aa\u01b5\7\31\2"+
		"\2\u01ab\u01b6\5\64\33\2\u01ac\u01b6\7<\2\2\u01ad\u01b6\5\66\34\2\u01ae"+
		"\u01b6\5H%\2\u01af\u01b6\5F$\2\u01b0\u01b6\5D#\2\u01b1\u01b6\5\62\32\2"+
		"\u01b2\u01b6\5h\65\2\u01b3\u01b6\7\4\2\2\u01b4\u01b6\5\60\31\2\u01b5\u01ab"+
		"\3\2\2\2\u01b5\u01ac\3\2\2\2\u01b5\u01ad\3\2\2\2\u01b5\u01ae\3\2\2\2\u01b5"+
		"\u01af\3\2\2\2\u01b5\u01b0\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b2\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01bc\3\2\2\2\u01b7"+
		"\u01b8\7\5\2\2\u01b8\u01b9\5\60\31\2\u01b9\u01ba\7\6\2\2\u01ba\u01bc\3"+
		"\2\2\2\u01bb\u01a0\3\2\2\2\u01bb\u01a2\3\2\2\2\u01bb\u01a3\3\2\2\2\u01bb"+
		"\u01a4\3\2\2\2\u01bb\u01a5\3\2\2\2\u01bb\u01a6\3\2\2\2\u01bb\u01a7\3\2"+
		"\2\2\u01bb\u01a8\3\2\2\2\u01bb\u01a9\3\2\2\2\u01bb\u01aa\3\2\2\2\u01bb"+
		"\u01b7\3\2\2\2\u01bc\u01ee\3\2\2\2\u01bd\u01be\f\r\2\2\u01be\u01bf\7\37"+
		"\2\2\u01bf\u01ed\5\60\31\16\u01c0\u01c1\f\f\2\2\u01c1\u01c2\t\3\2\2\u01c2"+
		"\u01ed\5\60\31\r\u01c3\u01c4\f\13\2\2\u01c4\u01c5\t\4\2\2\u01c5\u01ed"+
		"\5\60\31\f\u01c6\u01c7\f\n\2\2\u01c7\u01c8\t\5\2\2\u01c8\u01ed\5\60\31"+
		"\13\u01c9\u01d0\f\t\2\2\u01ca\u01d1\7\"\2\2\u01cb\u01d1\7#\2\2\u01cc\u01d1"+
		"\7-\2\2\u01cd\u01ce\7-\2\2\u01ce\u01d1\7.\2\2\u01cf\u01d1\7+\2\2\u01d0"+
		"\u01ca\3\2\2\2\u01d0\u01cb\3\2\2\2\u01d0\u01cc\3\2\2\2\u01d0\u01cd\3\2"+
		"\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01ed\5\60\31\n\u01d3"+
		"\u01d4\f\b\2\2\u01d4\u01d5\7*\2\2\u01d5\u01ed\5\60\31\t\u01d6\u01d7\f"+
		"\7\2\2\u01d7\u01d8\7,\2\2\u01d8\u01ed\5\60\31\b\u01d9\u01db\f\5\2\2\u01da"+
		"\u01dc\7.\2\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2"+
		"\2\2\u01dd\u01de\7+\2\2\u01de\u01ed\5\60\31\6\u01df\u01e0\f\3\2\2\u01e0"+
		"\u01e2\7-\2\2\u01e1\u01e3\7.\2\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2"+
		"\2\u01e3\u01e4\3\2\2\2\u01e4\u01ed\5\60\31\4\u01e5\u01ea\f\4\2\2\u01e6"+
		"\u01eb\7-\2\2\u01e7\u01eb\7/\2\2\u01e8\u01e9\7.\2\2\u01e9\u01eb\7/\2\2"+
		"\u01ea\u01e6\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ed"+
		"\3\2\2\2\u01ec\u01bd\3\2\2\2\u01ec\u01c0\3\2\2\2\u01ec\u01c3\3\2\2\2\u01ec"+
		"\u01c6\3\2\2\2\u01ec\u01c9\3\2\2\2\u01ec\u01d3\3\2\2\2\u01ec\u01d6\3\2"+
		"\2\2\u01ec\u01d9\3\2\2\2\u01ec\u01df\3\2\2\2\u01ec\u01e5\3\2\2\2\u01ed"+
		"\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\61\3\2\2"+
		"\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7<\2\2\u01f2\u01fb\7\5\2\2\u01f3\u01f8"+
		"\5\60\31\2\u01f4\u01f5\7\35\2\2\u01f5\u01f7\5\60\31\2\u01f6\u01f4\3\2"+
		"\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01fc\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7\6\2\2\u01fe\63\3\2\2\2\u01ff\u0200"+
		"\7\22\2\2\u0200\u0205\7:\2\2\u0201\u0205\7:\2\2\u0202\u0205\7;\2\2\u0203"+
		"\u0205\7/\2\2\u0204\u01ff\3\2\2\2\u0204\u0201\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0204\u0203\3\2\2\2\u0205\65\3\2\2\2\u0206\u020e\5:\36\2\u0207\u020e"+
		"\5> \2\u0208\u020e\5<\37\2\u0209\u020e\5J&\2\u020a\u020e\5T+\2\u020b\u020e"+
		"\5\\/\2\u020c\u020e\5d\63\2\u020d\u0206\3\2\2\2\u020d\u0207\3\2\2\2\u020d"+
		"\u0208\3\2\2\2\u020d\u0209\3\2\2\2\u020d\u020a\3\2\2\2\u020d\u020b\3\2"+
		"\2\2\u020d\u020c\3\2\2\2\u020e\67\3\2\2\2\u020f\u0218\5@!\2\u0210\u0218"+
		"\5B\"\2\u0211\u0218\5P)\2\u0212\u0218\5R*\2\u0213\u0218\5V,\2\u0214\u0218"+
		"\5^\60\2\u0215\u0218\5`\61\2\u0216\u0218\5b\62\2\u0217\u020f\3\2\2\2\u0217"+
		"\u0210\3\2\2\2\u0217\u0211\3\2\2\2\u0217\u0212\3\2\2\2\u0217\u0213\3\2"+
		"\2\2\u0217\u0214\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0216\3\2\2\2\u0218"+
		"9\3\2\2\2\u0219\u021a\7!\2\2\u021a\u021b\7<\2\2\u021b;\3\2\2\2\u021c\u021d"+
		"\7!\2\2\u021d\u021e\7!\2\2\u021e\u021f\7<\2\2\u021f=\3\2\2\2\u0220\u0221"+
		"\7!\2\2\u0221\u0222\7\22\2\2\u0222\u0223\7<\2\2\u0223?\3\2\2\2\u0224\u0225"+
		"\7!\2\2\u0225\u0226\7\21\2\2\u0226\u0227\7<\2\2\u0227A\3\2\2\2\u0228\u0229"+
		"\7!\2\2\u0229\u022a\7\25\2\2\u022a\u022b\7<\2\2\u022bC\3\2\2\2\u022c\u022d"+
		"\7!\2\2\u022d\u022e\7\23\2\2\u022eE\3\2\2\2\u022f\u0230\7!\2\2\u0230\u0231"+
		"\7\32\2\2\u0231G\3\2\2\2\u0232\u0233\7!\2\2\u0233\u0234\7\31\2\2\u0234"+
		"I\3\2\2\2\u0235\u0238\5L\'\2\u0236\u0238\5N(\2\u0237\u0235\3\2\2\2\u0237"+
		"\u0236\3\2\2\2\u0238K\3\2\2\2\u0239\u023a\5:\36\2\u023a\u023b\7 \2\2\u023b"+
		"\u023c\79\2\2\u023cM\3\2\2\2\u023d\u023e\5> \2\u023e\u023f\7 \2\2\u023f"+
		"\u0240\79\2\2\u0240O\3\2\2\2\u0241\u0242\5@!\2\u0242\u0243\7 \2\2\u0243"+
		"\u0244\79\2\2\u0244Q\3\2\2\2\u0245\u0246\5B\"\2\u0246\u0247\7 \2\2\u0247"+
		"\u0248\79\2\2\u0248S\3\2\2\2\u0249\u024a\5:\36\2\u024a\u024b\7 \2\2\u024b"+
		"\u024c\78\2\2\u024c\u0252\3\2\2\2\u024d\u024e\5> \2\u024e\u024f\7 \2\2"+
		"\u024f\u0250\78\2\2\u0250\u0252\3\2\2\2\u0251\u0249\3\2\2\2\u0251\u024d"+
		"\3\2\2\2\u0252U\3\2\2\2\u0253\u0256\5X-\2\u0254\u0256\5Z.\2\u0255\u0253"+
		"\3\2\2\2\u0255\u0254\3\2\2\2\u0256W\3\2\2\2\u0257\u0258\5@!\2\u0258\u0259"+
		"\7\30\2\2\u0259\u025a\7<\2\2\u025aY\3\2\2\2\u025b\u025c\5B\"\2\u025c\u025d"+
		"\7\30\2\2\u025d\u025e\7<\2\2\u025e[\3\2\2\2\u025f\u0260\5:\36\2\u0260"+
		"\u0261\7\33\2\2\u0261\u0262\7<\2\2\u0262]\3\2\2\2\u0263\u0264\5@!\2\u0264"+
		"\u0265\7\33\2\2\u0265\u0266\7<\2\2\u0266_\3\2\2\2\u0267\u0268\5@!\2\u0268"+
		"\u0269\7$\2\2\u0269\u026a\7<\2\2\u026aa\3\2\2\2\u026b\u026c\5B\"\2\u026c"+
		"\u026d\7$\2\2\u026d\u026e\7<\2\2\u026ec\3\2\2\2\u026f\u0270\7\33\2\2\u0270"+
		"\u0271\7<\2\2\u0271e\3\2\2\2\u0272\u0277\3\2\2\2\u0273\u0277\7\65\2\2"+
		"\u0274\u0277\7\66\2\2\u0275\u0277\7\67\2\2\u0276\u0272\3\2\2\2\u0276\u0273"+
		"\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0275\3\2\2\2\u0277g\3\2\2\2\u0278"+
		"\u0279\7\3\2\2\u0279i\3\2\2\2\u027a\u027b\7\4\2\2\u027bk\3\2\2\2=tx\177"+
		"\u0087\u008c\u008f\u0095\u0099\u009f\u00a3\u00a6\u00a8\u00ab\u00ae\u00b0"+
		"\u00b4\u00b7\u00b9\u00bc\u00c1\u00c4\u00c9\u00d1\u00d4\u00dd\u00e2\u00e6"+
		"\u00ef\u00f2\u00f4\u010b\u0120\u012c\u0134\u0139\u014e\u0151\u0153\u015e"+
		"\u0165\u0182\u018a\u01b5\u01bb\u01d0\u01db\u01e2\u01ea\u01ec\u01ee\u01f8"+
		"\u01fb\u0204\u020d\u0217\u0237\u0251\u0255\u0276";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}