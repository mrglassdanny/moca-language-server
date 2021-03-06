// Generated from Moca.g4 by ANTLR 4.8

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MocaParser}.
 */
public interface MocaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_script}.
	 * @param ctx the parse tree
	 */
	void enterMoca_script(MocaParser.Moca_scriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_script}.
	 * @param ctx the parse tree
	 */
	void exitMoca_script(MocaParser.Moca_scriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(MocaParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(MocaParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#stream}.
	 * @param ctx the parse tree
	 */
	void enterStream(MocaParser.StreamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#stream}.
	 * @param ctx the parse tree
	 */
	void exitStream(MocaParser.StreamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(MocaParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(MocaParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MocaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MocaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MocaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MocaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(MocaParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(MocaParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#verb_noun_clause}.
	 * @param ctx the parse tree
	 */
	void enterVerb_noun_clause(MocaParser.Verb_noun_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#verb_noun_clause}.
	 * @param ctx the parse tree
	 */
	void exitVerb_noun_clause(MocaParser.Verb_noun_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#verb_noun_clause_arg}.
	 * @param ctx the parse tree
	 */
	void enterVerb_noun_clause_arg(MocaParser.Verb_noun_clause_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#verb_noun_clause_arg}.
	 * @param ctx the parse tree
	 */
	void exitVerb_noun_clause_arg(MocaParser.Verb_noun_clause_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#verb_noun_clause_arg_expr}.
	 * @param ctx the parse tree
	 */
	void enterVerb_noun_clause_arg_expr(MocaParser.Verb_noun_clause_arg_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#verb_noun_clause_arg_expr}.
	 * @param ctx the parse tree
	 */
	void exitVerb_noun_clause_arg_expr(MocaParser.Verb_noun_clause_arg_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#sub_sequence}.
	 * @param ctx the parse tree
	 */
	void enterSub_sequence(MocaParser.Sub_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#sub_sequence}.
	 * @param ctx the parse tree
	 */
	void exitSub_sequence(MocaParser.Sub_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(MocaParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(MocaParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MocaParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MocaParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#else_if_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_if_statement(MocaParser.Else_if_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#else_if_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_if_statement(MocaParser.Else_if_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(MocaParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(MocaParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#try_block}.
	 * @param ctx the parse tree
	 */
	void enterTry_block(MocaParser.Try_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#try_block}.
	 * @param ctx the parse tree
	 */
	void exitTry_block(MocaParser.Try_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#catch_single_expr}.
	 * @param ctx the parse tree
	 */
	void enterCatch_single_expr(MocaParser.Catch_single_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#catch_single_expr}.
	 * @param ctx the parse tree
	 */
	void exitCatch_single_expr(MocaParser.Catch_single_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#catch_multi_expr}.
	 * @param ctx the parse tree
	 */
	void enterCatch_multi_expr(MocaParser.Catch_multi_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#catch_multi_expr}.
	 * @param ctx the parse tree
	 */
	void exitCatch_multi_expr(MocaParser.Catch_multi_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#catch_sequence}.
	 * @param ctx the parse tree
	 */
	void enterCatch_sequence(MocaParser.Catch_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#catch_sequence}.
	 * @param ctx the parse tree
	 */
	void exitCatch_sequence(MocaParser.Catch_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#finally_sequence}.
	 * @param ctx the parse tree
	 */
	void enterFinally_sequence(MocaParser.Finally_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#finally_sequence}.
	 * @param ctx the parse tree
	 */
	void exitFinally_sequence(MocaParser.Finally_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#redirect_expr}.
	 * @param ctx the parse tree
	 */
	void enterRedirect_expr(MocaParser.Redirect_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#redirect_expr}.
	 * @param ctx the parse tree
	 */
	void exitRedirect_expr(MocaParser.Redirect_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#remote_expr}.
	 * @param ctx the parse tree
	 */
	void enterRemote_expr(MocaParser.Remote_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#remote_expr}.
	 * @param ctx the parse tree
	 */
	void exitRemote_expr(MocaParser.Remote_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#suppress_warnings_expr}.
	 * @param ctx the parse tree
	 */
	void enterSuppress_warnings_expr(MocaParser.Suppress_warnings_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#suppress_warnings_expr}.
	 * @param ctx the parse tree
	 */
	void exitSuppress_warnings_expr(MocaParser.Suppress_warnings_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MocaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MocaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#function_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction_expr(MocaParser.Function_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#function_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction_expr(MocaParser.Function_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(MocaParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(MocaParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#at_variable}.
	 * @param ctx the parse tree
	 */
	void enterAt_variable(MocaParser.At_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#at_variable}.
	 * @param ctx the parse tree
	 */
	void exitAt_variable(MocaParser.At_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#environment_variable}.
	 * @param ctx the parse tree
	 */
	void enterEnvironment_variable(MocaParser.Environment_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#environment_variable}.
	 * @param ctx the parse tree
	 */
	void exitEnvironment_variable(MocaParser.Environment_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void enterAt_plus_variable(MocaParser.At_plus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void exitAt_plus_variable(MocaParser.At_plus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#at_star}.
	 * @param ctx the parse tree
	 */
	void enterAt_star(MocaParser.At_starContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#at_star}.
	 * @param ctx the parse tree
	 */
	void exitAt_star(MocaParser.At_starContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#at_question}.
	 * @param ctx the parse tree
	 */
	void enterAt_question(MocaParser.At_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#at_question}.
	 * @param ctx the parse tree
	 */
	void exitAt_question(MocaParser.At_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#at_bang}.
	 * @param ctx the parse tree
	 */
	void enterAt_bang(MocaParser.At_bangContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#at_bang}.
	 * @param ctx the parse tree
	 */
	void exitAt_bang(MocaParser.At_bangContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#integration_variable}.
	 * @param ctx the parse tree
	 */
	void enterIntegration_variable(MocaParser.Integration_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#integration_variable}.
	 * @param ctx the parse tree
	 */
	void exitIntegration_variable(MocaParser.Integration_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#remote_keyword}.
	 * @param ctx the parse tree
	 */
	void enterRemote_keyword(MocaParser.Remote_keywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#remote_keyword}.
	 * @param ctx the parse tree
	 */
	void exitRemote_keyword(MocaParser.Remote_keywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#groovy_script}.
	 * @param ctx the parse tree
	 */
	void enterGroovy_script(MocaParser.Groovy_scriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#groovy_script}.
	 * @param ctx the parse tree
	 */
	void exitGroovy_script(MocaParser.Groovy_scriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#sql_script}.
	 * @param ctx the parse tree
	 */
	void enterSql_script(MocaParser.Sql_scriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#sql_script}.
	 * @param ctx the parse tree
	 */
	void exitSql_script(MocaParser.Sql_scriptContext ctx);
}