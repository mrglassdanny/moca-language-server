// Generated from Moca.g4 by ANTLR 4.5.3

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
	 * Enter a parse tree produced by {@link MocaParser#verb_noun_clause_args}.
	 * @param ctx the parse tree
	 */
	void enterVerb_noun_clause_args(MocaParser.Verb_noun_clause_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#verb_noun_clause_args}.
	 * @param ctx the parse tree
	 */
	void exitVerb_noun_clause_args(MocaParser.Verb_noun_clause_argsContext ctx);
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
	 * Enter a parse tree produced by {@link MocaParser#moca_redirect_expr}.
	 * @param ctx the parse tree
	 */
	void enterMoca_redirect_expr(MocaParser.Moca_redirect_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_redirect_expr}.
	 * @param ctx the parse tree
	 */
	void exitMoca_redirect_expr(MocaParser.Moca_redirect_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_remote_expr}.
	 * @param ctx the parse tree
	 */
	void enterMoca_remote_expr(MocaParser.Moca_remote_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_remote_expr}.
	 * @param ctx the parse tree
	 */
	void exitMoca_remote_expr(MocaParser.Moca_remote_exprContext ctx);
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
	 * Enter a parse tree produced by {@link MocaParser#moca_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_variable(MocaParser.Moca_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_variable(MocaParser.Moca_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_plus_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_plus_variable(MocaParser.Moca_plus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_plus_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_plus_variable(MocaParser.Moca_plus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_variable(MocaParser.Moca_at_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_variable(MocaParser.Moca_at_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_environment_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_environment_variable(MocaParser.Moca_environment_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_environment_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_environment_variable(MocaParser.Moca_environment_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_minus_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_minus_variable(MocaParser.Moca_at_minus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_minus_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_minus_variable(MocaParser.Moca_at_minus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_variable(MocaParser.Moca_at_plus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_variable(MocaParser.Moca_at_plus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_mod_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_variable(MocaParser.Moca_at_mod_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_mod_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_variable(MocaParser.Moca_at_mod_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_star}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_star(MocaParser.Moca_at_starContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_star}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_star(MocaParser.Moca_at_starContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_question}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_question(MocaParser.Moca_at_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_question}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_question(MocaParser.Moca_at_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_bang}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_bang(MocaParser.Moca_at_bangContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_bang}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_bang(MocaParser.Moca_at_bangContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_keep_directive(MocaParser.Moca_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_keep_directive(MocaParser.Moca_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_keep_directive(MocaParser.Moca_at_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_keep_directive(MocaParser.Moca_at_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_minus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_minus_keep_directive(MocaParser.Moca_at_minus_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_minus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_minus_keep_directive(MocaParser.Moca_at_minus_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_plus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_keep_directive(MocaParser.Moca_at_plus_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_plus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_keep_directive(MocaParser.Moca_at_plus_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_mod_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_keep_directive(MocaParser.Moca_at_mod_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_mod_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_keep_directive(MocaParser.Moca_at_mod_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_onstack_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_onstack_directive(MocaParser.Moca_onstack_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_onstack_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_onstack_directive(MocaParser.Moca_onstack_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_ignore_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_ignore_directive(MocaParser.Moca_ignore_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_ignore_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_ignore_directive(MocaParser.Moca_ignore_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_oldvar_directive(MocaParser.Moca_oldvar_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_oldvar_directive(MocaParser.Moca_oldvar_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_plus_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_oldvar_directive(MocaParser.Moca_at_plus_oldvar_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_plus_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_oldvar_directive(MocaParser.Moca_at_plus_oldvar_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_at_mod_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_oldvar_directive(MocaParser.Moca_at_mod_oldvar_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_at_mod_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_oldvar_directive(MocaParser.Moca_at_mod_oldvar_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_type_cast_variable(MocaParser.Moca_type_cast_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_type_cast_variable(MocaParser.Moca_type_cast_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_database_qualifier_variable(MocaParser.Moca_database_qualifier_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_database_qualifier_variable(MocaParser.Moca_database_qualifier_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_integration_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_integration_variable(MocaParser.Moca_integration_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_integration_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_integration_variable(MocaParser.Moca_integration_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaParser#moca_remote_keyword}.
	 * @param ctx the parse tree
	 */
	void enterMoca_remote_keyword(MocaParser.Moca_remote_keywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaParser#moca_remote_keyword}.
	 * @param ctx the parse tree
	 */
	void exitMoca_remote_keyword(MocaParser.Moca_remote_keywordContext ctx);
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
}