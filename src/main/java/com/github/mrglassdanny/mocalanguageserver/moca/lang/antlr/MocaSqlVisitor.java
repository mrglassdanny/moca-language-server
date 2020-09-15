// Generated from MocaSql.g4 by ANTLR 4.5.3

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MocaSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MocaSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_sql_script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_sql_script(MocaSqlParser.Moca_sql_scriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#sql_clauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_clauses(MocaSqlParser.Sql_clausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#sql_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_clause(MocaSqlParser.Sql_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#dml_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDml_clause(MocaSqlParser.Dml_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#ddl_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdl_clause(MocaSqlParser.Ddl_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#empty_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(MocaSqlParser.Empty_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_sequence(MocaSqlParser.Drop_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_sequence(MocaSqlParser.Alter_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_sequence(MocaSqlParser.Create_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#merge_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_statement(MocaSqlParser.Merge_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#merge_matched}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_matched(MocaSqlParser.Merge_matchedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#merge_not_matched}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_not_matched(MocaSqlParser.Merge_not_matchedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#delete_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_statement(MocaSqlParser.Delete_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#delete_statement_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_statement_from(MocaSqlParser.Delete_statement_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#insert_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_statement(MocaSqlParser.Insert_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#insert_statement_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_statement_value(MocaSqlParser.Insert_statement_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_statement(MocaSqlParser.Select_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#update_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_statement(MocaSqlParser.Update_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#output_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_clause(MocaSqlParser.Output_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#output_dml_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_dml_list_elem(MocaSqlParser.Output_dml_list_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#output_column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_column_name(MocaSqlParser.Output_column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_index(MocaSqlParser.Create_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_table(MocaSqlParser.Create_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_options(MocaSqlParser.Table_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_view(MocaSqlParser.Create_viewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#view_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitView_attribute(MocaSqlParser.View_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table(MocaSqlParser.Alter_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#host}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHost(MocaSqlParser.HostContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_index(MocaSqlParser.Drop_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_relational_or_xml_or_spatial_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_relational_or_xml_or_spatial_index(MocaSqlParser.Drop_relational_or_xml_or_spatial_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_backward_compatible_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_backward_compatible_index(MocaSqlParser.Drop_backward_compatible_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table(MocaSqlParser.Drop_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_view(MocaSqlParser.Drop_viewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#rowset_function_limited}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowset_function_limited(MocaSqlParser.Rowset_function_limitedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#openquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenquery(MocaSqlParser.OpenqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#opendatasource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpendatasource(MocaSqlParser.OpendatasourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#execute_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_statement(MocaSqlParser.Execute_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#execute_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_body(MocaSqlParser.Execute_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#execute_statement_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_statement_arg(MocaSqlParser.Execute_statement_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#execute_var_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_var_string(MocaSqlParser.Execute_var_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_def_table_constraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_def_table_constraints(MocaSqlParser.Column_def_table_constraintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_def_table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_def_table_constraint(MocaSqlParser.Column_def_table_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_definition(MocaSqlParser.Column_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#materialized_column_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterialized_column_definition(MocaSqlParser.Materialized_column_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_constraint(MocaSqlParser.Column_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_constraint(MocaSqlParser.Table_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#on_delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_delete(MocaSqlParser.On_deleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#on_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_update(MocaSqlParser.On_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#index_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_options(MocaSqlParser.Index_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#index_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_option(MocaSqlParser.Index_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#constant_LOCAL_ID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_LOCAL_ID(MocaSqlParser.Constant_LOCAL_IDContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MocaSqlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_variable(MocaSqlParser.Moca_at_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_environment_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_environment_variable(MocaSqlParser.Moca_environment_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_minus_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_minus_variable(MocaSqlParser.Moca_at_minus_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_plus_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_plus_variable(MocaSqlParser.Moca_at_plus_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_star(MocaSqlParser.Moca_at_starContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_integration_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_integration_variable(MocaSqlParser.Moca_integration_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#primitive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_expression(MocaSqlParser.Primitive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#case_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_expression(MocaSqlParser.Case_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#unary_operator_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator_expression(MocaSqlParser.Unary_operator_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#bracket_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket_expression(MocaSqlParser.Bracket_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(MocaSqlParser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(MocaSqlParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#with_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_expression(MocaSqlParser.With_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#common_table_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommon_table_expression(MocaSqlParser.Common_table_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#update_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_elem(MocaSqlParser.Update_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#search_condition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition_list(MocaSqlParser.Search_condition_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#search_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition(MocaSqlParser.Search_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#search_condition_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition_and(MocaSqlParser.Search_condition_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#search_condition_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearch_condition_not(MocaSqlParser.Search_condition_notContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(MocaSqlParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#query_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_expression(MocaSqlParser.Query_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#sql_union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_union(MocaSqlParser.Sql_unionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#query_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_specification(MocaSqlParser.Query_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#top_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_clause(MocaSqlParser.Top_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#top_percent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_percent(MocaSqlParser.Top_percentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#top_count}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_count(MocaSqlParser.Top_countContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#order_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_clause(MocaSqlParser.Order_by_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#for_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_clause(MocaSqlParser.For_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#xml_common_directives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml_common_directives(MocaSqlParser.Xml_common_directivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#order_by_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_expression(MocaSqlParser.Order_by_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#group_by_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by_item(MocaSqlParser.Group_by_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#option_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_clause(MocaSqlParser.Option_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(MocaSqlParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#optimize_for_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptimize_for_arg(MocaSqlParser.Optimize_for_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#select_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list(MocaSqlParser.Select_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#udt_method_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdt_method_arguments(MocaSqlParser.Udt_method_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#asterisk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsterisk(MocaSqlParser.AsteriskContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_elem(MocaSqlParser.Column_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#udt_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdt_elem(MocaSqlParser.Udt_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#expression_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_elem(MocaSqlParser.Expression_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#select_list_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list_elem(MocaSqlParser.Select_list_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_sources}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_sources(MocaSqlParser.Table_sourcesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source(MocaSqlParser.Table_sourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_source_item_joined}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source_item_joined(MocaSqlParser.Table_source_item_joinedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_source_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_source_item(MocaSqlParser.Table_source_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#open_xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_xml(MocaSqlParser.Open_xmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#schema_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_declaration(MocaSqlParser.Schema_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_declaration(MocaSqlParser.Column_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#change_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_table(MocaSqlParser.Change_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#join_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_part(MocaSqlParser.Join_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#pivot_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivot_clause(MocaSqlParser.Pivot_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#unpivot_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpivot_clause(MocaSqlParser.Unpivot_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#full_column_name_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_column_name_list(MocaSqlParser.Full_column_name_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_name_with_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name_with_hint(MocaSqlParser.Table_name_with_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#rowset_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowset_function(MocaSqlParser.Rowset_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#bulk_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulk_option(MocaSqlParser.Bulk_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#derived_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerived_table(MocaSqlParser.Derived_tableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARY_CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARY_CHECKSUM(MocaSqlParser.BINARY_CHECKSUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CAST}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCAST(MocaSqlParser.CASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONVERT}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONVERT(MocaSqlParser.CONVERTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CHECKSUM}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCHECKSUM(MocaSqlParser.CHECKSUMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COALESCE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOALESCE(MocaSqlParser.COALESCEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CURRENT_TIMESTAMP}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCURRENT_TIMESTAMP(MocaSqlParser.CURRENT_TIMESTAMPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CURRENT_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCURRENT_USER(MocaSqlParser.CURRENT_USERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DATEADD}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDATEADD(MocaSqlParser.DATEADDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DATEDIFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDATEDIFF(MocaSqlParser.DATEDIFFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DATENAME}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDATENAME(MocaSqlParser.DATENAMEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DATEPART}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDATEPART(MocaSqlParser.DATEPARTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GETDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGETDATE(MocaSqlParser.GETDATEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GETUTCDATE}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGETUTCDATE(MocaSqlParser.GETUTCDATEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDENTITY}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDENTITY(MocaSqlParser.IDENTITYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MIN_ACTIVE_ROWVERSION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMIN_ACTIVE_ROWVERSION(MocaSqlParser.MIN_ACTIVE_ROWVERSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NULLIF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNULLIF(MocaSqlParser.NULLIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STUFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTUFF(MocaSqlParser.STUFFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SESSION_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSESSION_USER(MocaSqlParser.SESSION_USERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SYSTEM_USER}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSYSTEM_USER(MocaSqlParser.SYSTEM_USERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ISNULL}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISNULL(MocaSqlParser.ISNULLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XML_DATA_TYPE_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXML_DATA_TYPE_FUNC(MocaSqlParser.XML_DATA_TYPE_FUNCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFF}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFF(MocaSqlParser.IFFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RANKING_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRANKING_WINDOWED_FUNC(MocaSqlParser.RANKING_WINDOWED_FUNCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AGGREGATE_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAGGREGATE_WINDOWED_FUNC(MocaSqlParser.AGGREGATE_WINDOWED_FUNCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ANALYTIC_WINDOWED_FUNC}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitANALYTIC_WINDOWED_FUNC(MocaSqlParser.ANALYTIC_WINDOWED_FUNCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SCALAR_FUNCTION}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSCALAR_FUNCTION(MocaSqlParser.SCALAR_FUNCTIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRINGAGG}
	 * labeled alternative in {@link MocaSqlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRINGAGG(MocaSqlParser.STRINGAGGContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#xml_data_type_methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml_data_type_methods(MocaSqlParser.Xml_data_type_methodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#value_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_method(MocaSqlParser.Value_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#query_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_method(MocaSqlParser.Query_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#exist_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExist_method(MocaSqlParser.Exist_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#modify_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModify_method(MocaSqlParser.Modify_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#nodes_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodes_method(MocaSqlParser.Nodes_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#switch_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_section(MocaSqlParser.Switch_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#switch_search_condition_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_search_condition_section(MocaSqlParser.Switch_search_condition_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#as_column_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_column_alias(MocaSqlParser.As_column_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#as_table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_table_alias(MocaSqlParser.As_table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_alias(MocaSqlParser.Table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#with_table_hints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_table_hints(MocaSqlParser.With_table_hintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#insert_with_table_hints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_with_table_hints(MocaSqlParser.Insert_with_table_hintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_hint(MocaSqlParser.Table_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#index_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_value(MocaSqlParser.Index_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_alias_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias_list(MocaSqlParser.Column_alias_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias(MocaSqlParser.Column_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_value_constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_value_constructor(MocaSqlParser.Table_value_constructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(MocaSqlParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#ranking_windowed_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRanking_windowed_function(MocaSqlParser.Ranking_windowed_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#aggregate_windowed_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate_windowed_function(MocaSqlParser.Aggregate_windowed_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#analytic_windowed_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalytic_windowed_function(MocaSqlParser.Analytic_windowed_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#all_distinct_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll_distinct_expression(MocaSqlParser.All_distinct_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#over_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOver_clause(MocaSqlParser.Over_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#row_or_range_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_or_range_clause(MocaSqlParser.Row_or_range_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#window_frame_extent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindow_frame_extent(MocaSqlParser.Window_frame_extentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#window_frame_bound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindow_frame_bound(MocaSqlParser.Window_frame_boundContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#window_frame_preceding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindow_frame_preceding(MocaSqlParser.Window_frame_precedingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#window_frame_following}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindow_frame_following(MocaSqlParser.Window_frame_followingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#full_table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_table_name(MocaSqlParser.Full_table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(MocaSqlParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#simple_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_name(MocaSqlParser.Simple_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_proc_name_schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_proc_name_schema(MocaSqlParser.Func_proc_name_schemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_proc_name_database_schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_proc_name_database_schema(MocaSqlParser.Func_proc_name_database_schemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_proc_name_server_database_schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_proc_name_server_database_schema(MocaSqlParser.Func_proc_name_server_database_schemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#ddl_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdl_object(MocaSqlParser.Ddl_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#full_column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_column_name(MocaSqlParser.Full_column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_name_list_with_order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_list_with_order(MocaSqlParser.Column_name_list_with_orderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#column_name_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_list(MocaSqlParser.Column_name_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#cursor_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_name(MocaSqlParser.Cursor_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#on_off}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn_off(MocaSqlParser.On_offContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#clustered}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClustered(MocaSqlParser.ClusteredContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#null_notnull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_notnull(MocaSqlParser.Null_notnullContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#null_or_default}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_or_default(MocaSqlParser.Null_or_defaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#scalar_function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar_function_name(MocaSqlParser.Scalar_function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(MocaSqlParser.Data_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MocaSqlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(MocaSqlParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MocaSqlParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#simple_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_id(MocaSqlParser.Simple_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operator(MocaSqlParser.Comparison_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#assignment_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_operator(MocaSqlParser.Assignment_operatorContext ctx);
}