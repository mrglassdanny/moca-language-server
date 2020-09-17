// Generated from MocaSql.g4 by ANTLR 4.8

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MocaSqlParser}.
 */
public interface MocaSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_sql_script}.
	 * @param ctx the parse tree
	 */
	void enterMoca_sql_script(MocaSqlParser.Moca_sql_scriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_sql_script}.
	 * @param ctx the parse tree
	 */
	void exitMoca_sql_script(MocaSqlParser.Moca_sql_scriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#sql_clauses}.
	 * @param ctx the parse tree
	 */
	void enterSql_clauses(MocaSqlParser.Sql_clausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#sql_clauses}.
	 * @param ctx the parse tree
	 */
	void exitSql_clauses(MocaSqlParser.Sql_clausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#sql_clause}.
	 * @param ctx the parse tree
	 */
	void enterSql_clause(MocaSqlParser.Sql_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#sql_clause}.
	 * @param ctx the parse tree
	 */
	void exitSql_clause(MocaSqlParser.Sql_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#dml_clause}.
	 * @param ctx the parse tree
	 */
	void enterDml_clause(MocaSqlParser.Dml_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#dml_clause}.
	 * @param ctx the parse tree
	 */
	void exitDml_clause(MocaSqlParser.Dml_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#ddl_clause}.
	 * @param ctx the parse tree
	 */
	void enterDdl_clause(MocaSqlParser.Ddl_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#ddl_clause}.
	 * @param ctx the parse tree
	 */
	void exitDdl_clause(MocaSqlParser.Ddl_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_statement(MocaSqlParser.Empty_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#empty_statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_statement(MocaSqlParser.Empty_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_sequence}.
	 * @param ctx the parse tree
	 */
	void enterDrop_sequence(MocaSqlParser.Drop_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_sequence}.
	 * @param ctx the parse tree
	 */
	void exitDrop_sequence(MocaSqlParser.Drop_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_sequence}.
	 * @param ctx the parse tree
	 */
	void enterAlter_sequence(MocaSqlParser.Alter_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_sequence}.
	 * @param ctx the parse tree
	 */
	void exitAlter_sequence(MocaSqlParser.Alter_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_sequence}.
	 * @param ctx the parse tree
	 */
	void enterCreate_sequence(MocaSqlParser.Create_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_sequence}.
	 * @param ctx the parse tree
	 */
	void exitCreate_sequence(MocaSqlParser.Create_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#merge_statement}.
	 * @param ctx the parse tree
	 */
	void enterMerge_statement(MocaSqlParser.Merge_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#merge_statement}.
	 * @param ctx the parse tree
	 */
	void exitMerge_statement(MocaSqlParser.Merge_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#merge_matched}.
	 * @param ctx the parse tree
	 */
	void enterMerge_matched(MocaSqlParser.Merge_matchedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#merge_matched}.
	 * @param ctx the parse tree
	 */
	void exitMerge_matched(MocaSqlParser.Merge_matchedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#merge_not_matched}.
	 * @param ctx the parse tree
	 */
	void enterMerge_not_matched(MocaSqlParser.Merge_not_matchedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#merge_not_matched}.
	 * @param ctx the parse tree
	 */
	void exitMerge_not_matched(MocaSqlParser.Merge_not_matchedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void enterDelete_statement(MocaSqlParser.Delete_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#delete_statement}.
	 * @param ctx the parse tree
	 */
	void exitDelete_statement(MocaSqlParser.Delete_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#delete_statement_from}.
	 * @param ctx the parse tree
	 */
	void enterDelete_statement_from(MocaSqlParser.Delete_statement_fromContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#delete_statement_from}.
	 * @param ctx the parse tree
	 */
	void exitDelete_statement_from(MocaSqlParser.Delete_statement_fromContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement(MocaSqlParser.Insert_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#insert_statement}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement(MocaSqlParser.Insert_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 */
	void enterInsert_statement_value(MocaSqlParser.Insert_statement_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 */
	void exitInsert_statement_value(MocaSqlParser.Insert_statement_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelect_statement(MocaSqlParser.Select_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelect_statement(MocaSqlParser.Select_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_statement(MocaSqlParser.Update_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#update_statement}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_statement(MocaSqlParser.Update_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#output_clause}.
	 * @param ctx the parse tree
	 */
	void enterOutput_clause(MocaSqlParser.Output_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#output_clause}.
	 * @param ctx the parse tree
	 */
	void exitOutput_clause(MocaSqlParser.Output_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#output_dml_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterOutput_dml_list_elem(MocaSqlParser.Output_dml_list_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#output_dml_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitOutput_dml_list_elem(MocaSqlParser.Output_dml_list_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#output_column_name}.
	 * @param ctx the parse tree
	 */
	void enterOutput_column_name(MocaSqlParser.Output_column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#output_column_name}.
	 * @param ctx the parse tree
	 */
	void exitOutput_column_name(MocaSqlParser.Output_column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void enterCreate_index(MocaSqlParser.Create_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_index}.
	 * @param ctx the parse tree
	 */
	void exitCreate_index(MocaSqlParser.Create_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void enterCreate_table(MocaSqlParser.Create_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_table}.
	 * @param ctx the parse tree
	 */
	void exitCreate_table(MocaSqlParser.Create_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_options}.
	 * @param ctx the parse tree
	 */
	void enterTable_options(MocaSqlParser.Table_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_options}.
	 * @param ctx the parse tree
	 */
	void exitTable_options(MocaSqlParser.Table_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_view}.
	 * @param ctx the parse tree
	 */
	void enterCreate_view(MocaSqlParser.Create_viewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_view}.
	 * @param ctx the parse tree
	 */
	void exitCreate_view(MocaSqlParser.Create_viewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#view_attribute}.
	 * @param ctx the parse tree
	 */
	void enterView_attribute(MocaSqlParser.View_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#view_attribute}.
	 * @param ctx the parse tree
	 */
	void exitView_attribute(MocaSqlParser.View_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_table}.
	 * @param ctx the parse tree
	 */
	void enterAlter_table(MocaSqlParser.Alter_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_table}.
	 * @param ctx the parse tree
	 */
	void exitAlter_table(MocaSqlParser.Alter_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#host}.
	 * @param ctx the parse tree
	 */
	void enterHost(MocaSqlParser.HostContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#host}.
	 * @param ctx the parse tree
	 */
	void exitHost(MocaSqlParser.HostContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_index}.
	 * @param ctx the parse tree
	 */
	void enterDrop_index(MocaSqlParser.Drop_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_index}.
	 * @param ctx the parse tree
	 */
	void exitDrop_index(MocaSqlParser.Drop_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_relational_or_xml_or_spatial_index}.
	 * @param ctx the parse tree
	 */
	void enterDrop_relational_or_xml_or_spatial_index(MocaSqlParser.Drop_relational_or_xml_or_spatial_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_relational_or_xml_or_spatial_index}.
	 * @param ctx the parse tree
	 */
	void exitDrop_relational_or_xml_or_spatial_index(MocaSqlParser.Drop_relational_or_xml_or_spatial_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_backward_compatible_index}.
	 * @param ctx the parse tree
	 */
	void enterDrop_backward_compatible_index(MocaSqlParser.Drop_backward_compatible_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_backward_compatible_index}.
	 * @param ctx the parse tree
	 */
	void exitDrop_backward_compatible_index(MocaSqlParser.Drop_backward_compatible_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_table}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table(MocaSqlParser.Drop_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_table}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table(MocaSqlParser.Drop_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_view}.
	 * @param ctx the parse tree
	 */
	void enterDrop_view(MocaSqlParser.Drop_viewContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_view}.
	 * @param ctx the parse tree
	 */
	void exitDrop_view(MocaSqlParser.Drop_viewContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#rowset_function_limited}.
	 * @param ctx the parse tree
	 */
	void enterRowset_function_limited(MocaSqlParser.Rowset_function_limitedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#rowset_function_limited}.
	 * @param ctx the parse tree
	 */
	void exitRowset_function_limited(MocaSqlParser.Rowset_function_limitedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#openquery}.
	 * @param ctx the parse tree
	 */
	void enterOpenquery(MocaSqlParser.OpenqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#openquery}.
	 * @param ctx the parse tree
	 */
	void exitOpenquery(MocaSqlParser.OpenqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#opendatasource}.
	 * @param ctx the parse tree
	 */
	void enterOpendatasource(MocaSqlParser.OpendatasourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#opendatasource}.
	 * @param ctx the parse tree
	 */
	void exitOpendatasource(MocaSqlParser.OpendatasourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#execute_statement}.
	 * @param ctx the parse tree
	 */
	void enterExecute_statement(MocaSqlParser.Execute_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#execute_statement}.
	 * @param ctx the parse tree
	 */
	void exitExecute_statement(MocaSqlParser.Execute_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#execute_body}.
	 * @param ctx the parse tree
	 */
	void enterExecute_body(MocaSqlParser.Execute_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#execute_body}.
	 * @param ctx the parse tree
	 */
	void exitExecute_body(MocaSqlParser.Execute_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#execute_statement_arg}.
	 * @param ctx the parse tree
	 */
	void enterExecute_statement_arg(MocaSqlParser.Execute_statement_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#execute_statement_arg}.
	 * @param ctx the parse tree
	 */
	void exitExecute_statement_arg(MocaSqlParser.Execute_statement_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#execute_var_string}.
	 * @param ctx the parse tree
	 */
	void enterExecute_var_string(MocaSqlParser.Execute_var_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#execute_var_string}.
	 * @param ctx the parse tree
	 */
	void exitExecute_var_string(MocaSqlParser.Execute_var_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 */
	void enterColumn_def_table_constraints(MocaSqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 */
	void exitColumn_def_table_constraints(MocaSqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColumn_def_table_constraint(MocaSqlParser.Column_def_table_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColumn_def_table_constraint(MocaSqlParser.Column_def_table_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_definition}.
	 * @param ctx the parse tree
	 */
	void enterColumn_definition(MocaSqlParser.Column_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_definition}.
	 * @param ctx the parse tree
	 */
	void exitColumn_definition(MocaSqlParser.Column_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#materialized_column_definition}.
	 * @param ctx the parse tree
	 */
	void enterMaterialized_column_definition(MocaSqlParser.Materialized_column_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#materialized_column_definition}.
	 * @param ctx the parse tree
	 */
	void exitMaterialized_column_definition(MocaSqlParser.Materialized_column_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColumn_constraint(MocaSqlParser.Column_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColumn_constraint(MocaSqlParser.Column_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTable_constraint(MocaSqlParser.Table_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTable_constraint(MocaSqlParser.Table_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#on_delete}.
	 * @param ctx the parse tree
	 */
	void enterOn_delete(MocaSqlParser.On_deleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#on_delete}.
	 * @param ctx the parse tree
	 */
	void exitOn_delete(MocaSqlParser.On_deleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#on_update}.
	 * @param ctx the parse tree
	 */
	void enterOn_update(MocaSqlParser.On_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#on_update}.
	 * @param ctx the parse tree
	 */
	void exitOn_update(MocaSqlParser.On_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#index_options}.
	 * @param ctx the parse tree
	 */
	void enterIndex_options(MocaSqlParser.Index_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#index_options}.
	 * @param ctx the parse tree
	 */
	void exitIndex_options(MocaSqlParser.Index_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#index_option}.
	 * @param ctx the parse tree
	 */
	void enterIndex_option(MocaSqlParser.Index_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#index_option}.
	 * @param ctx the parse tree
	 */
	void exitIndex_option(MocaSqlParser.Index_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#constant_LOCAL_ID}.
	 * @param ctx the parse tree
	 */
	void enterConstant_LOCAL_ID(MocaSqlParser.Constant_LOCAL_IDContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#constant_LOCAL_ID}.
	 * @param ctx the parse tree
	 */
	void exitConstant_LOCAL_ID(MocaSqlParser.Constant_LOCAL_IDContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MocaSqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MocaSqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_variable(MocaSqlParser.Moca_at_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_variable(MocaSqlParser.Moca_at_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_environment_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_environment_variable(MocaSqlParser.Moca_environment_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_environment_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_environment_variable(MocaSqlParser.Moca_environment_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_minus_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_minus_variable(MocaSqlParser.Moca_at_minus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_minus_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_minus_variable(MocaSqlParser.Moca_at_minus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_variable(MocaSqlParser.Moca_at_plus_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_variable(MocaSqlParser.Moca_at_plus_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_star}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_star(MocaSqlParser.Moca_at_starContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_star}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_star(MocaSqlParser.Moca_at_starContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_integration_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_integration_variable(MocaSqlParser.Moca_integration_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_integration_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_integration_variable(MocaSqlParser.Moca_integration_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#primitive_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_expression(MocaSqlParser.Primitive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#primitive_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_expression(MocaSqlParser.Primitive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void enterCase_expression(MocaSqlParser.Case_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void exitCase_expression(MocaSqlParser.Case_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#unary_operator_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator_expression(MocaSqlParser.Unary_operator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#unary_operator_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator_expression(MocaSqlParser.Unary_operator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#bracket_expression}.
	 * @param ctx the parse tree
	 */
	void enterBracket_expression(MocaSqlParser.Bracket_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#bracket_expression}.
	 * @param ctx the parse tree
	 */
	void exitBracket_expression(MocaSqlParser.Bracket_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(MocaSqlParser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(MocaSqlParser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(MocaSqlParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(MocaSqlParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#with_expression}.
	 * @param ctx the parse tree
	 */
	void enterWith_expression(MocaSqlParser.With_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#with_expression}.
	 * @param ctx the parse tree
	 */
	void exitWith_expression(MocaSqlParser.With_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void enterCommon_table_expression(MocaSqlParser.Common_table_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void exitCommon_table_expression(MocaSqlParser.Common_table_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#update_elem}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_elem(MocaSqlParser.Update_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#update_elem}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_elem(MocaSqlParser.Update_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#search_condition_list}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition_list(MocaSqlParser.Search_condition_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#search_condition_list}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition_list(MocaSqlParser.Search_condition_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition(MocaSqlParser.Search_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#search_condition}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition(MocaSqlParser.Search_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#search_condition_and}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition_and(MocaSqlParser.Search_condition_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#search_condition_and}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition_and(MocaSqlParser.Search_condition_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 */
	void enterSearch_condition_not(MocaSqlParser.Search_condition_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 */
	void exitSearch_condition_not(MocaSqlParser.Search_condition_notContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(MocaSqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(MocaSqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuery_expression(MocaSqlParser.Query_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#query_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuery_expression(MocaSqlParser.Query_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#sql_union}.
	 * @param ctx the parse tree
	 */
	void enterSql_union(MocaSqlParser.Sql_unionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#sql_union}.
	 * @param ctx the parse tree
	 */
	void exitSql_union(MocaSqlParser.Sql_unionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void enterQuery_specification(MocaSqlParser.Query_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#query_specification}.
	 * @param ctx the parse tree
	 */
	void exitQuery_specification(MocaSqlParser.Query_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#top_clause}.
	 * @param ctx the parse tree
	 */
	void enterTop_clause(MocaSqlParser.Top_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#top_clause}.
	 * @param ctx the parse tree
	 */
	void exitTop_clause(MocaSqlParser.Top_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#top_percent}.
	 * @param ctx the parse tree
	 */
	void enterTop_percent(MocaSqlParser.Top_percentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#top_percent}.
	 * @param ctx the parse tree
	 */
	void exitTop_percent(MocaSqlParser.Top_percentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#top_count}.
	 * @param ctx the parse tree
	 */
	void enterTop_count(MocaSqlParser.Top_countContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#top_count}.
	 * @param ctx the parse tree
	 */
	void exitTop_count(MocaSqlParser.Top_countContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(MocaSqlParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(MocaSqlParser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#for_clause}.
	 * @param ctx the parse tree
	 */
	void enterFor_clause(MocaSqlParser.For_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#for_clause}.
	 * @param ctx the parse tree
	 */
	void exitFor_clause(MocaSqlParser.For_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#xml_common_directives}.
	 * @param ctx the parse tree
	 */
	void enterXml_common_directives(MocaSqlParser.Xml_common_directivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#xml_common_directives}.
	 * @param ctx the parse tree
	 */
	void exitXml_common_directives(MocaSqlParser.Xml_common_directivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_expression(MocaSqlParser.Order_by_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_expression(MocaSqlParser.Order_by_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by_item(MocaSqlParser.Group_by_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by_item(MocaSqlParser.Group_by_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#option_clause}.
	 * @param ctx the parse tree
	 */
	void enterOption_clause(MocaSqlParser.Option_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#option_clause}.
	 * @param ctx the parse tree
	 */
	void exitOption_clause(MocaSqlParser.Option_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(MocaSqlParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(MocaSqlParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#optimize_for_arg}.
	 * @param ctx the parse tree
	 */
	void enterOptimize_for_arg(MocaSqlParser.Optimize_for_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#optimize_for_arg}.
	 * @param ctx the parse tree
	 */
	void exitOptimize_for_arg(MocaSqlParser.Optimize_for_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list(MocaSqlParser.Select_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#select_list}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list(MocaSqlParser.Select_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#udt_method_arguments}.
	 * @param ctx the parse tree
	 */
	void enterUdt_method_arguments(MocaSqlParser.Udt_method_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#udt_method_arguments}.
	 * @param ctx the parse tree
	 */
	void exitUdt_method_arguments(MocaSqlParser.Udt_method_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#asterisk}.
	 * @param ctx the parse tree
	 */
	void enterAsterisk(MocaSqlParser.AsteriskContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#asterisk}.
	 * @param ctx the parse tree
	 */
	void exitAsterisk(MocaSqlParser.AsteriskContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_elem}.
	 * @param ctx the parse tree
	 */
	void enterColumn_elem(MocaSqlParser.Column_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_elem}.
	 * @param ctx the parse tree
	 */
	void exitColumn_elem(MocaSqlParser.Column_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#udt_elem}.
	 * @param ctx the parse tree
	 */
	void enterUdt_elem(MocaSqlParser.Udt_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#udt_elem}.
	 * @param ctx the parse tree
	 */
	void exitUdt_elem(MocaSqlParser.Udt_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#expression_elem}.
	 * @param ctx the parse tree
	 */
	void enterExpression_elem(MocaSqlParser.Expression_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#expression_elem}.
	 * @param ctx the parse tree
	 */
	void exitExpression_elem(MocaSqlParser.Expression_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list_elem(MocaSqlParser.Select_list_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list_elem(MocaSqlParser.Select_list_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_sources}.
	 * @param ctx the parse tree
	 */
	void enterTable_sources(MocaSqlParser.Table_sourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_sources}.
	 * @param ctx the parse tree
	 */
	void exitTable_sources(MocaSqlParser.Table_sourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void enterTable_source(MocaSqlParser.Table_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_source}.
	 * @param ctx the parse tree
	 */
	void exitTable_source(MocaSqlParser.Table_sourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 */
	void enterTable_source_item_joined(MocaSqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 */
	void exitTable_source_item_joined(MocaSqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void enterTable_source_item(MocaSqlParser.Table_source_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_source_item}.
	 * @param ctx the parse tree
	 */
	void exitTable_source_item(MocaSqlParser.Table_source_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#open_xml}.
	 * @param ctx the parse tree
	 */
	void enterOpen_xml(MocaSqlParser.Open_xmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#open_xml}.
	 * @param ctx the parse tree
	 */
	void exitOpen_xml(MocaSqlParser.Open_xmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#schema_declaration}.
	 * @param ctx the parse tree
	 */
	void enterSchema_declaration(MocaSqlParser.Schema_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#schema_declaration}.
	 * @param ctx the parse tree
	 */
	void exitSchema_declaration(MocaSqlParser.Schema_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_declaration}.
	 * @param ctx the parse tree
	 */
	void enterColumn_declaration(MocaSqlParser.Column_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_declaration}.
	 * @param ctx the parse tree
	 */
	void exitColumn_declaration(MocaSqlParser.Column_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#change_table}.
	 * @param ctx the parse tree
	 */
	void enterChange_table(MocaSqlParser.Change_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#change_table}.
	 * @param ctx the parse tree
	 */
	void exitChange_table(MocaSqlParser.Change_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void enterJoin_part(MocaSqlParser.Join_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#join_part}.
	 * @param ctx the parse tree
	 */
	void exitJoin_part(MocaSqlParser.Join_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#pivot_clause}.
	 * @param ctx the parse tree
	 */
	void enterPivot_clause(MocaSqlParser.Pivot_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#pivot_clause}.
	 * @param ctx the parse tree
	 */
	void exitPivot_clause(MocaSqlParser.Pivot_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#unpivot_clause}.
	 * @param ctx the parse tree
	 */
	void enterUnpivot_clause(MocaSqlParser.Unpivot_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#unpivot_clause}.
	 * @param ctx the parse tree
	 */
	void exitUnpivot_clause(MocaSqlParser.Unpivot_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#full_column_name_list}.
	 * @param ctx the parse tree
	 */
	void enterFull_column_name_list(MocaSqlParser.Full_column_name_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#full_column_name_list}.
	 * @param ctx the parse tree
	 */
	void exitFull_column_name_list(MocaSqlParser.Full_column_name_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 */
	void enterTable_name_with_hint(MocaSqlParser.Table_name_with_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 */
	void exitTable_name_with_hint(MocaSqlParser.Table_name_with_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#rowset_function}.
	 * @param ctx the parse tree
	 */
	void enterRowset_function(MocaSqlParser.Rowset_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#rowset_function}.
	 * @param ctx the parse tree
	 */
	void exitRowset_function(MocaSqlParser.Rowset_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#bulk_option}.
	 * @param ctx the parse tree
	 */
	void enterBulk_option(MocaSqlParser.Bulk_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#bulk_option}.
	 * @param ctx the parse tree
	 */
	void exitBulk_option(MocaSqlParser.Bulk_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void enterDerived_table(MocaSqlParser.Derived_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#derived_table}.
	 * @param ctx the parse tree
	 */
	void exitDerived_table(MocaSqlParser.Derived_tableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BINARY_CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterBINARY_CHECKSUM(MocaSqlParser.BINARY_CHECKSUMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BINARY_CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitBINARY_CHECKSUM(MocaSqlParser.BINARY_CHECKSUMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CAST}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCAST(MocaSqlParser.CASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CAST}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCAST(MocaSqlParser.CASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONVERT}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCONVERT(MocaSqlParser.CONVERTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONVERT}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCONVERT(MocaSqlParser.CONVERTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCHECKSUM(MocaSqlParser.CHECKSUMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCHECKSUM(MocaSqlParser.CHECKSUMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COALESCE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCOALESCE(MocaSqlParser.COALESCEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COALESCE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCOALESCE(MocaSqlParser.COALESCEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CURRENT_TIMESTAMP}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCURRENT_TIMESTAMP(MocaSqlParser.CURRENT_TIMESTAMPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CURRENT_TIMESTAMP}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCURRENT_TIMESTAMP(MocaSqlParser.CURRENT_TIMESTAMPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CURRENT_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterCURRENT_USER(MocaSqlParser.CURRENT_USERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CURRENT_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitCURRENT_USER(MocaSqlParser.CURRENT_USERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DATEADD}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDATEADD(MocaSqlParser.DATEADDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DATEADD}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDATEADD(MocaSqlParser.DATEADDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DATEDIFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDATEDIFF(MocaSqlParser.DATEDIFFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DATEDIFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDATEDIFF(MocaSqlParser.DATEDIFFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DATENAME}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDATENAME(MocaSqlParser.DATENAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DATENAME}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDATENAME(MocaSqlParser.DATENAMEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DATEPART}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDATEPART(MocaSqlParser.DATEPARTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DATEPART}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDATEPART(MocaSqlParser.DATEPARTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GETDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterGETDATE(MocaSqlParser.GETDATEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GETDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitGETDATE(MocaSqlParser.GETDATEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GETUTCDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterGETUTCDATE(MocaSqlParser.GETUTCDATEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GETUTCDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitGETUTCDATE(MocaSqlParser.GETUTCDATEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDENTITY}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterIDENTITY(MocaSqlParser.IDENTITYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDENTITY}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitIDENTITY(MocaSqlParser.IDENTITYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MIN_ACTIVE_ROWVERSION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterMIN_ACTIVE_ROWVERSION(MocaSqlParser.MIN_ACTIVE_ROWVERSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MIN_ACTIVE_ROWVERSION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitMIN_ACTIVE_ROWVERSION(MocaSqlParser.MIN_ACTIVE_ROWVERSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NULLIF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterNULLIF(MocaSqlParser.NULLIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NULLIF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitNULLIF(MocaSqlParser.NULLIFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STUFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSTUFF(MocaSqlParser.STUFFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STUFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSTUFF(MocaSqlParser.STUFFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SESSION_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSESSION_USER(MocaSqlParser.SESSION_USERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SESSION_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSESSION_USER(MocaSqlParser.SESSION_USERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SYSTEM_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSYSTEM_USER(MocaSqlParser.SYSTEM_USERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SYSTEM_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSYSTEM_USER(MocaSqlParser.SYSTEM_USERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ISNULL}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterISNULL(MocaSqlParser.ISNULLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ISNULL}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitISNULL(MocaSqlParser.ISNULLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XML_DATA_TYPE_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterXML_DATA_TYPE_FUNC(MocaSqlParser.XML_DATA_TYPE_FUNCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XML_DATA_TYPE_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitXML_DATA_TYPE_FUNC(MocaSqlParser.XML_DATA_TYPE_FUNCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterIFF(MocaSqlParser.IFFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitIFF(MocaSqlParser.IFFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RANKING_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterRANKING_WINDOWED_FUNC(MocaSqlParser.RANKING_WINDOWED_FUNCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RANKING_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitRANKING_WINDOWED_FUNC(MocaSqlParser.RANKING_WINDOWED_FUNCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AGGREGATE_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterAGGREGATE_WINDOWED_FUNC(MocaSqlParser.AGGREGATE_WINDOWED_FUNCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AGGREGATE_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitAGGREGATE_WINDOWED_FUNC(MocaSqlParser.AGGREGATE_WINDOWED_FUNCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ANALYTIC_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterANALYTIC_WINDOWED_FUNC(MocaSqlParser.ANALYTIC_WINDOWED_FUNCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ANALYTIC_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitANALYTIC_WINDOWED_FUNC(MocaSqlParser.ANALYTIC_WINDOWED_FUNCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SCALAR_FUNCTION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSCALAR_FUNCTION(MocaSqlParser.SCALAR_FUNCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SCALAR_FUNCTION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSCALAR_FUNCTION(MocaSqlParser.SCALAR_FUNCTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRINGAGG}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterSTRINGAGG(MocaSqlParser.STRINGAGGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRINGAGG}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitSTRINGAGG(MocaSqlParser.STRINGAGGContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#xml_data_type_methods}.
	 * @param ctx the parse tree
	 */
	void enterXml_data_type_methods(MocaSqlParser.Xml_data_type_methodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#xml_data_type_methods}.
	 * @param ctx the parse tree
	 */
	void exitXml_data_type_methods(MocaSqlParser.Xml_data_type_methodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#value_method}.
	 * @param ctx the parse tree
	 */
	void enterValue_method(MocaSqlParser.Value_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#value_method}.
	 * @param ctx the parse tree
	 */
	void exitValue_method(MocaSqlParser.Value_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#query_method}.
	 * @param ctx the parse tree
	 */
	void enterQuery_method(MocaSqlParser.Query_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#query_method}.
	 * @param ctx the parse tree
	 */
	void exitQuery_method(MocaSqlParser.Query_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#exist_method}.
	 * @param ctx the parse tree
	 */
	void enterExist_method(MocaSqlParser.Exist_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#exist_method}.
	 * @param ctx the parse tree
	 */
	void exitExist_method(MocaSqlParser.Exist_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#modify_method}.
	 * @param ctx the parse tree
	 */
	void enterModify_method(MocaSqlParser.Modify_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#modify_method}.
	 * @param ctx the parse tree
	 */
	void exitModify_method(MocaSqlParser.Modify_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#nodes_method}.
	 * @param ctx the parse tree
	 */
	void enterNodes_method(MocaSqlParser.Nodes_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#nodes_method}.
	 * @param ctx the parse tree
	 */
	void exitNodes_method(MocaSqlParser.Nodes_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#switch_section}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_section(MocaSqlParser.Switch_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#switch_section}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_section(MocaSqlParser.Switch_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#switch_search_condition_section}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_search_condition_section(MocaSqlParser.Switch_search_condition_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#switch_search_condition_section}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_search_condition_section(MocaSqlParser.Switch_search_condition_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#as_column_alias}.
	 * @param ctx the parse tree
	 */
	void enterAs_column_alias(MocaSqlParser.As_column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#as_column_alias}.
	 * @param ctx the parse tree
	 */
	void exitAs_column_alias(MocaSqlParser.As_column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 */
	void enterAs_table_alias(MocaSqlParser.As_table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 */
	void exitAs_table_alias(MocaSqlParser.As_table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(MocaSqlParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(MocaSqlParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 */
	void enterWith_table_hints(MocaSqlParser.With_table_hintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 */
	void exitWith_table_hints(MocaSqlParser.With_table_hintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#insert_with_table_hints}.
	 * @param ctx the parse tree
	 */
	void enterInsert_with_table_hints(MocaSqlParser.Insert_with_table_hintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#insert_with_table_hints}.
	 * @param ctx the parse tree
	 */
	void exitInsert_with_table_hints(MocaSqlParser.Insert_with_table_hintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_hint}.
	 * @param ctx the parse tree
	 */
	void enterTable_hint(MocaSqlParser.Table_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_hint}.
	 * @param ctx the parse tree
	 */
	void exitTable_hint(MocaSqlParser.Table_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#index_value}.
	 * @param ctx the parse tree
	 */
	void enterIndex_value(MocaSqlParser.Index_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#index_value}.
	 * @param ctx the parse tree
	 */
	void exitIndex_value(MocaSqlParser.Index_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias_list(MocaSqlParser.Column_alias_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias_list(MocaSqlParser.Column_alias_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias(MocaSqlParser.Column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias(MocaSqlParser.Column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 */
	void enterTable_value_constructor(MocaSqlParser.Table_value_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 */
	void exitTable_value_constructor(MocaSqlParser.Table_value_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(MocaSqlParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(MocaSqlParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#ranking_windowed_function}.
	 * @param ctx the parse tree
	 */
	void enterRanking_windowed_function(MocaSqlParser.Ranking_windowed_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#ranking_windowed_function}.
	 * @param ctx the parse tree
	 */
	void exitRanking_windowed_function(MocaSqlParser.Ranking_windowed_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void enterAggregate_windowed_function(MocaSqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 */
	void exitAggregate_windowed_function(MocaSqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#analytic_windowed_function}.
	 * @param ctx the parse tree
	 */
	void enterAnalytic_windowed_function(MocaSqlParser.Analytic_windowed_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#analytic_windowed_function}.
	 * @param ctx the parse tree
	 */
	void exitAnalytic_windowed_function(MocaSqlParser.Analytic_windowed_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 */
	void enterAll_distinct_expression(MocaSqlParser.All_distinct_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 */
	void exitAll_distinct_expression(MocaSqlParser.All_distinct_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#over_clause}.
	 * @param ctx the parse tree
	 */
	void enterOver_clause(MocaSqlParser.Over_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#over_clause}.
	 * @param ctx the parse tree
	 */
	void exitOver_clause(MocaSqlParser.Over_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#row_or_range_clause}.
	 * @param ctx the parse tree
	 */
	void enterRow_or_range_clause(MocaSqlParser.Row_or_range_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#row_or_range_clause}.
	 * @param ctx the parse tree
	 */
	void exitRow_or_range_clause(MocaSqlParser.Row_or_range_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#window_frame_extent}.
	 * @param ctx the parse tree
	 */
	void enterWindow_frame_extent(MocaSqlParser.Window_frame_extentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#window_frame_extent}.
	 * @param ctx the parse tree
	 */
	void exitWindow_frame_extent(MocaSqlParser.Window_frame_extentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#window_frame_bound}.
	 * @param ctx the parse tree
	 */
	void enterWindow_frame_bound(MocaSqlParser.Window_frame_boundContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#window_frame_bound}.
	 * @param ctx the parse tree
	 */
	void exitWindow_frame_bound(MocaSqlParser.Window_frame_boundContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#window_frame_preceding}.
	 * @param ctx the parse tree
	 */
	void enterWindow_frame_preceding(MocaSqlParser.Window_frame_precedingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#window_frame_preceding}.
	 * @param ctx the parse tree
	 */
	void exitWindow_frame_preceding(MocaSqlParser.Window_frame_precedingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#window_frame_following}.
	 * @param ctx the parse tree
	 */
	void enterWindow_frame_following(MocaSqlParser.Window_frame_followingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#window_frame_following}.
	 * @param ctx the parse tree
	 */
	void exitWindow_frame_following(MocaSqlParser.Window_frame_followingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#full_table_name}.
	 * @param ctx the parse tree
	 */
	void enterFull_table_name(MocaSqlParser.Full_table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#full_table_name}.
	 * @param ctx the parse tree
	 */
	void exitFull_table_name(MocaSqlParser.Full_table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(MocaSqlParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(MocaSqlParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#simple_name}.
	 * @param ctx the parse tree
	 */
	void enterSimple_name(MocaSqlParser.Simple_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#simple_name}.
	 * @param ctx the parse tree
	 */
	void exitSimple_name(MocaSqlParser.Simple_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_proc_name_schema}.
	 * @param ctx the parse tree
	 */
	void enterFunc_proc_name_schema(MocaSqlParser.Func_proc_name_schemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_proc_name_schema}.
	 * @param ctx the parse tree
	 */
	void exitFunc_proc_name_schema(MocaSqlParser.Func_proc_name_schemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_proc_name_database_schema}.
	 * @param ctx the parse tree
	 */
	void enterFunc_proc_name_database_schema(MocaSqlParser.Func_proc_name_database_schemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_proc_name_database_schema}.
	 * @param ctx the parse tree
	 */
	void exitFunc_proc_name_database_schema(MocaSqlParser.Func_proc_name_database_schemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_proc_name_server_database_schema}.
	 * @param ctx the parse tree
	 */
	void enterFunc_proc_name_server_database_schema(MocaSqlParser.Func_proc_name_server_database_schemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_proc_name_server_database_schema}.
	 * @param ctx the parse tree
	 */
	void exitFunc_proc_name_server_database_schema(MocaSqlParser.Func_proc_name_server_database_schemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#ddl_object}.
	 * @param ctx the parse tree
	 */
	void enterDdl_object(MocaSqlParser.Ddl_objectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#ddl_object}.
	 * @param ctx the parse tree
	 */
	void exitDdl_object(MocaSqlParser.Ddl_objectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void enterFull_column_name(MocaSqlParser.Full_column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#full_column_name}.
	 * @param ctx the parse tree
	 */
	void exitFull_column_name(MocaSqlParser.Full_column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_name_list_with_order}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_list_with_order(MocaSqlParser.Column_name_list_with_orderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_name_list_with_order}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_list_with_order(MocaSqlParser.Column_name_list_with_orderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_list(MocaSqlParser.Column_name_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#column_name_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_list(MocaSqlParser.Column_name_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#cursor_name}.
	 * @param ctx the parse tree
	 */
	void enterCursor_name(MocaSqlParser.Cursor_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#cursor_name}.
	 * @param ctx the parse tree
	 */
	void exitCursor_name(MocaSqlParser.Cursor_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#on_off}.
	 * @param ctx the parse tree
	 */
	void enterOn_off(MocaSqlParser.On_offContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#on_off}.
	 * @param ctx the parse tree
	 */
	void exitOn_off(MocaSqlParser.On_offContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#clustered}.
	 * @param ctx the parse tree
	 */
	void enterClustered(MocaSqlParser.ClusteredContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#clustered}.
	 * @param ctx the parse tree
	 */
	void exitClustered(MocaSqlParser.ClusteredContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void enterNull_notnull(MocaSqlParser.Null_notnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#null_notnull}.
	 * @param ctx the parse tree
	 */
	void exitNull_notnull(MocaSqlParser.Null_notnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#null_or_default}.
	 * @param ctx the parse tree
	 */
	void enterNull_or_default(MocaSqlParser.Null_or_defaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#null_or_default}.
	 * @param ctx the parse tree
	 */
	void exitNull_or_default(MocaSqlParser.Null_or_defaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 */
	void enterScalar_function_name(MocaSqlParser.Scalar_function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 */
	void exitScalar_function_name(MocaSqlParser.Scalar_function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(MocaSqlParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(MocaSqlParser.Data_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MocaSqlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MocaSqlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(MocaSqlParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(MocaSqlParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MocaSqlParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MocaSqlParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void enterSimple_id(MocaSqlParser.Simple_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#simple_id}.
	 * @param ctx the parse tree
	 */
	void exitSimple_id(MocaSqlParser.Simple_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operator(MocaSqlParser.Comparison_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operator(MocaSqlParser.Comparison_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(MocaSqlParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(MocaSqlParser.Assignment_operatorContext ctx);
}