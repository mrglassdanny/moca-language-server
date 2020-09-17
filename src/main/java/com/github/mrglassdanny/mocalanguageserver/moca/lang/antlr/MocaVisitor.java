// Generated from Moca.g4 by ANTLR 4.8

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MocaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MocaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MocaParser#moca_script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_script(MocaParser.Moca_scriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(MocaParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#stream}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream(MocaParser.StreamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(MocaParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MocaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MocaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(MocaParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#verb_noun_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb_noun_clause(MocaParser.Verb_noun_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#verb_noun_clause_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb_noun_clause_arg(MocaParser.Verb_noun_clause_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#verb_noun_clause_arg_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb_noun_clause_arg_expr(MocaParser.Verb_noun_clause_arg_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#sub_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub_sequence(MocaParser.Sub_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(MocaParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MocaParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#else_if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if_statement(MocaParser.Else_if_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(MocaParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#try_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_block(MocaParser.Try_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#catch_single_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_single_expr(MocaParser.Catch_single_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#catch_multi_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_multi_expr(MocaParser.Catch_multi_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#catch_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_sequence(MocaParser.Catch_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#finally_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_sequence(MocaParser.Finally_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#redirect_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirect_expr(MocaParser.Redirect_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#remote_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemote_expr(MocaParser.Remote_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#suppress_warnings_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuppress_warnings_expr(MocaParser.Suppress_warnings_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MocaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#function_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_expr(MocaParser.Function_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(MocaParser.Literal_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#at_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_variable(MocaParser.At_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#environment_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironment_variable(MocaParser.Environment_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#at_plus_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_plus_variable(MocaParser.At_plus_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#at_star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_star(MocaParser.At_starContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#at_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_question(MocaParser.At_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#at_bang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_bang(MocaParser.At_bangContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#integration_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegration_variable(MocaParser.Integration_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#remote_keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemote_keyword(MocaParser.Remote_keywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#groovy_script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroovy_script(MocaParser.Groovy_scriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaParser#sql_script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_script(MocaParser.Sql_scriptContext ctx);
}