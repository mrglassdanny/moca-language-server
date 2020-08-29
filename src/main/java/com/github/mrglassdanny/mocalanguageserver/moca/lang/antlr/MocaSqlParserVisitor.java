// Generated from MocaSqlParser.g4 by ANTLR 4.5.3

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MocaSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MocaSqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_sql_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_sql_file(MocaSqlParser.Moca_sql_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#batch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBatch(MocaSqlParser.BatchContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_statement(MocaSqlParser.Backup_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#cfl_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCfl_statement(MocaSqlParser.Cfl_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(MocaSqlParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#break_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_statement(MocaSqlParser.Break_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#continue_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_statement(MocaSqlParser.Continue_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#goto_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto_statement(MocaSqlParser.Goto_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(MocaSqlParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MocaSqlParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#throw_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrow_statement(MocaSqlParser.Throw_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#throw_error_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrow_error_number(MocaSqlParser.Throw_error_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#throw_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrow_message(MocaSqlParser.Throw_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#throw_state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrow_state(MocaSqlParser.Throw_stateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#try_catch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_catch_statement(MocaSqlParser.Try_catch_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#waitfor_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitfor_statement(MocaSqlParser.Waitfor_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(MocaSqlParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#print_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_statement(MocaSqlParser.Print_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#raiseerror_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaiseerror_statement(MocaSqlParser.Raiseerror_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#empty_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_statement(MocaSqlParser.Empty_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#another_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnother_statement(MocaSqlParser.Another_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_application_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_application_role(MocaSqlParser.Alter_application_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_application_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_application_role(MocaSqlParser.Create_application_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_aggregate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_aggregate(MocaSqlParser.Drop_aggregateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_application_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_application_role(MocaSqlParser.Drop_application_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly(MocaSqlParser.Alter_assemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_start(MocaSqlParser.Alter_assembly_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_clause(MocaSqlParser.Alter_assembly_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_from_clause(MocaSqlParser.Alter_assembly_from_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_from_clause_start(MocaSqlParser.Alter_assembly_from_clause_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_drop_clause(MocaSqlParser.Alter_assembly_drop_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_multiple_files}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_drop_multiple_files(MocaSqlParser.Alter_assembly_drop_multiple_filesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_drop(MocaSqlParser.Alter_assembly_dropContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_add_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_add_clause(MocaSqlParser.Alter_assembly_add_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_asssembly_add_clause_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_asssembly_add_clause_start(MocaSqlParser.Alter_asssembly_add_clause_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_client_file_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_client_file_clause(MocaSqlParser.Alter_assembly_client_file_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_file_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_file_name(MocaSqlParser.Alter_assembly_file_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_file_bits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_file_bits(MocaSqlParser.Alter_assembly_file_bitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_as(MocaSqlParser.Alter_assembly_asContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_with_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_with_clause(MocaSqlParser.Alter_assembly_with_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_assembly_with}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_assembly_with(MocaSqlParser.Alter_assembly_withContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#client_assembly_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClient_assembly_specifier(MocaSqlParser.Client_assembly_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#assembly_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssembly_option(MocaSqlParser.Assembly_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#network_file_share}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNetwork_file_share(MocaSqlParser.Network_file_shareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#network_computer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNetwork_computer(MocaSqlParser.Network_computerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#network_file_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNetwork_file_start(MocaSqlParser.Network_file_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#file_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_path(MocaSqlParser.File_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#file_directory_path_separator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_directory_path_separator(MocaSqlParser.File_directory_path_separatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#local_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_file(MocaSqlParser.Local_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#local_drive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_drive(MocaSqlParser.Local_driveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#multiple_local_files}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_local_files(MocaSqlParser.Multiple_local_filesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#multiple_local_file_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_local_file_start(MocaSqlParser.Multiple_local_file_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_assembly(MocaSqlParser.Create_assemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_assembly(MocaSqlParser.Drop_assemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_asymmetric_key(MocaSqlParser.Alter_asymmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_asymmetric_key_start(MocaSqlParser.Alter_asymmetric_key_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#asymmetric_key_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsymmetric_key_option(MocaSqlParser.Asymmetric_key_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#asymmetric_key_option_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsymmetric_key_option_start(MocaSqlParser.Asymmetric_key_option_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#asymmetric_key_password_change_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsymmetric_key_password_change_option(MocaSqlParser.Asymmetric_key_password_change_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_asymmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_asymmetric_key(MocaSqlParser.Create_asymmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_asymmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_asymmetric_key(MocaSqlParser.Drop_asymmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_authorization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_authorization(MocaSqlParser.Alter_authorizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#authorization_grantee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthorization_grantee(MocaSqlParser.Authorization_granteeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#entity_to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_to(MocaSqlParser.Entity_toContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#colon_colon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColon_colon(MocaSqlParser.Colon_colonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_authorization_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_authorization_start(MocaSqlParser.Alter_authorization_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_sql_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_authorization_for_sql_database(MocaSqlParser.Alter_authorization_for_sql_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_azure_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_authorization_for_azure_dw(MocaSqlParser.Alter_authorization_for_azure_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_parallel_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_authorization_for_parallel_dw(MocaSqlParser.Alter_authorization_for_parallel_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#class_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type(MocaSqlParser.Class_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#class_type_for_sql_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type_for_sql_database(MocaSqlParser.Class_type_for_sql_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#class_type_for_azure_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type_for_azure_dw(MocaSqlParser.Class_type_for_azure_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#class_type_for_parallel_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type_for_parallel_dw(MocaSqlParser.Class_type_for_parallel_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_availability_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_availability_group(MocaSqlParser.Drop_availability_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_availability_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_availability_group(MocaSqlParser.Alter_availability_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_availability_group_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_availability_group_start(MocaSqlParser.Alter_availability_group_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_availability_group_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_availability_group_options(MocaSqlParser.Alter_availability_group_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_broker_priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_broker_priority(MocaSqlParser.Create_or_alter_broker_priorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_broker_priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_broker_priority(MocaSqlParser.Drop_broker_priorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_certificate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_certificate(MocaSqlParser.Alter_certificateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_column_encryption_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_column_encryption_key(MocaSqlParser.Alter_column_encryption_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_column_encryption_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_column_encryption_key(MocaSqlParser.Create_column_encryption_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_certificate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_certificate(MocaSqlParser.Drop_certificateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_column_encryption_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_column_encryption_key(MocaSqlParser.Drop_column_encryption_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_column_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_column_master_key(MocaSqlParser.Drop_column_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_contract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_contract(MocaSqlParser.Drop_contractContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_credential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_credential(MocaSqlParser.Drop_credentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_cryptograhic_provider}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_cryptograhic_provider(MocaSqlParser.Drop_cryptograhic_providerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_database(MocaSqlParser.Drop_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_database_audit_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_database_audit_specification(MocaSqlParser.Drop_database_audit_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_database_scoped_credential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_database_scoped_credential(MocaSqlParser.Drop_database_scoped_credentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_default}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_default(MocaSqlParser.Drop_defaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_endpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_endpoint(MocaSqlParser.Drop_endpointContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_external_data_source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_external_data_source(MocaSqlParser.Drop_external_data_sourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_external_file_format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_external_file_format(MocaSqlParser.Drop_external_file_formatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_external_library}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_external_library(MocaSqlParser.Drop_external_libraryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_external_resource_pool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_external_resource_pool(MocaSqlParser.Drop_external_resource_poolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_external_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_external_table(MocaSqlParser.Drop_external_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_event_notifications}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_event_notifications(MocaSqlParser.Drop_event_notificationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_event_session}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_event_session(MocaSqlParser.Drop_event_sessionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_fulltext_catalog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_fulltext_catalog(MocaSqlParser.Drop_fulltext_catalogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_fulltext_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_fulltext_index(MocaSqlParser.Drop_fulltext_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_fulltext_stoplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_fulltext_stoplist(MocaSqlParser.Drop_fulltext_stoplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_login}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_login(MocaSqlParser.Drop_loginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_master_key(MocaSqlParser.Drop_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_message_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_message_type(MocaSqlParser.Drop_message_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_partition_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_partition_function(MocaSqlParser.Drop_partition_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_partition_scheme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_partition_scheme(MocaSqlParser.Drop_partition_schemeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_queue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_queue(MocaSqlParser.Drop_queueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_remote_service_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_remote_service_binding(MocaSqlParser.Drop_remote_service_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_resource_pool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_resource_pool(MocaSqlParser.Drop_resource_poolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_db_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_db_role(MocaSqlParser.Drop_db_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_route}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_route(MocaSqlParser.Drop_routeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_rule(MocaSqlParser.Drop_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_schema(MocaSqlParser.Drop_schemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_search_property_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_search_property_list(MocaSqlParser.Drop_search_property_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_security_policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_security_policy(MocaSqlParser.Drop_security_policyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_sequence(MocaSqlParser.Drop_sequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_server_audit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_server_audit(MocaSqlParser.Drop_server_auditContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_server_audit_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_server_audit_specification(MocaSqlParser.Drop_server_audit_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_server_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_server_role(MocaSqlParser.Drop_server_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_service(MocaSqlParser.Drop_serviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_signature(MocaSqlParser.Drop_signatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_statistics_name_azure_dw_and_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_statistics_name_azure_dw_and_pdw(MocaSqlParser.Drop_statistics_name_azure_dw_and_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_symmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_symmetric_key(MocaSqlParser.Drop_symmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_synonym}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_synonym(MocaSqlParser.Drop_synonymContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_user(MocaSqlParser.Drop_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_workload_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_workload_group(MocaSqlParser.Drop_workload_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_xml_schema_collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_xml_schema_collection(MocaSqlParser.Drop_xml_schema_collectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#disable_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisable_trigger(MocaSqlParser.Disable_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#enable_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnable_trigger(MocaSqlParser.Enable_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#lock_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLock_table(MocaSqlParser.Lock_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#truncate_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncate_table(MocaSqlParser.Truncate_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_column_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_column_master_key(MocaSqlParser.Create_column_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_credential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_credential(MocaSqlParser.Alter_credentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_credential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_credential(MocaSqlParser.Create_credentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_cryptographic_provider}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_cryptographic_provider(MocaSqlParser.Alter_cryptographic_providerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_cryptographic_provider}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_cryptographic_provider(MocaSqlParser.Create_cryptographic_providerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_event_notification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_event_notification(MocaSqlParser.Create_event_notificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_event_session}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_event_session(MocaSqlParser.Create_or_alter_event_sessionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#event_session_predicate_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_session_predicate_expression(MocaSqlParser.Event_session_predicate_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#event_session_predicate_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_session_predicate_factor(MocaSqlParser.Event_session_predicate_factorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#event_session_predicate_leaf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_session_predicate_leaf(MocaSqlParser.Event_session_predicate_leafContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_external_data_source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_external_data_source(MocaSqlParser.Alter_external_data_sourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_external_library}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_external_library(MocaSqlParser.Alter_external_libraryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_external_library}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_external_library(MocaSqlParser.Create_external_libraryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_external_resource_pool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_external_resource_pool(MocaSqlParser.Alter_external_resource_poolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_external_resource_pool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_external_resource_pool(MocaSqlParser.Create_external_resource_poolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_fulltext_catalog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_fulltext_catalog(MocaSqlParser.Alter_fulltext_catalogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_fulltext_catalog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_fulltext_catalog(MocaSqlParser.Create_fulltext_catalogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_fulltext_stoplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_fulltext_stoplist(MocaSqlParser.Alter_fulltext_stoplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_fulltext_stoplist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_fulltext_stoplist(MocaSqlParser.Create_fulltext_stoplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_login_sql_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_login_sql_server(MocaSqlParser.Alter_login_sql_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_login_sql_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_login_sql_server(MocaSqlParser.Create_login_sql_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_login_azure_sql(MocaSqlParser.Alter_login_azure_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_login_azure_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_login_azure_sql(MocaSqlParser.Create_login_azure_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_login_azure_sql_dw_and_pdw(MocaSqlParser.Alter_login_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_login_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_login_pdw(MocaSqlParser.Create_login_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_master_key_sql_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_master_key_sql_server(MocaSqlParser.Alter_master_key_sql_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_master_key_sql_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_master_key_sql_server(MocaSqlParser.Create_master_key_sql_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_master_key_azure_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_master_key_azure_sql(MocaSqlParser.Alter_master_key_azure_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_master_key_azure_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_master_key_azure_sql(MocaSqlParser.Create_master_key_azure_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_message_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_message_type(MocaSqlParser.Alter_message_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_partition_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_partition_function(MocaSqlParser.Alter_partition_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_partition_scheme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_partition_scheme(MocaSqlParser.Alter_partition_schemeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_remote_service_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_remote_service_binding(MocaSqlParser.Alter_remote_service_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_remote_service_binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_remote_service_binding(MocaSqlParser.Create_remote_service_bindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_resource_pool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_resource_pool(MocaSqlParser.Create_resource_poolContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_resource_governor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_resource_governor(MocaSqlParser.Alter_resource_governorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_db_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_db_role(MocaSqlParser.Alter_db_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_db_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_db_role(MocaSqlParser.Create_db_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_route}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_route(MocaSqlParser.Create_routeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_rule(MocaSqlParser.Create_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_schema_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_schema_sql(MocaSqlParser.Alter_schema_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_schema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_schema(MocaSqlParser.Create_schemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_schema_azure_sql_dw_and_pdw(MocaSqlParser.Create_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_schema_azure_sql_dw_and_pdw(MocaSqlParser.Alter_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_search_property_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_search_property_list(MocaSqlParser.Create_search_property_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_security_policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_security_policy(MocaSqlParser.Create_security_policyContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_server_audit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server_audit(MocaSqlParser.Alter_server_auditContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_server_audit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_server_audit(MocaSqlParser.Create_server_auditContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_server_audit_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server_audit_specification(MocaSqlParser.Alter_server_audit_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_server_audit_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_server_audit_specification(MocaSqlParser.Create_server_audit_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_server_configuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server_configuration(MocaSqlParser.Alter_server_configurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_server_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server_role(MocaSqlParser.Alter_server_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_server_role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_server_role(MocaSqlParser.Create_server_roleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_server_role_pdw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_server_role_pdw(MocaSqlParser.Alter_server_role_pdwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_service(MocaSqlParser.Alter_serviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_service(MocaSqlParser.Create_serviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_service_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_service_master_key(MocaSqlParser.Alter_service_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_symmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_symmetric_key(MocaSqlParser.Alter_symmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_symmetric_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_symmetric_key(MocaSqlParser.Create_symmetric_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_synonym}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_synonym(MocaSqlParser.Create_synonymContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_user(MocaSqlParser.Alter_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_user(MocaSqlParser.Create_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_user_azure_sql_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_user_azure_sql_dw(MocaSqlParser.Create_user_azure_sql_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_user_azure_sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_user_azure_sql(MocaSqlParser.Alter_user_azure_sqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_workload_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_workload_group(MocaSqlParser.Alter_workload_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_workload_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_workload_group(MocaSqlParser.Create_workload_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_xml_schema_collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_xml_schema_collection(MocaSqlParser.Create_xml_schema_collectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_queue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_queue(MocaSqlParser.Create_queueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#queue_settings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueue_settings(MocaSqlParser.Queue_settingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_queue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_queue(MocaSqlParser.Alter_queueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#queue_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueue_action(MocaSqlParser.Queue_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#queue_rebuild_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueue_rebuild_options(MocaSqlParser.Queue_rebuild_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_contract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_contract(MocaSqlParser.Create_contractContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#conversation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversation_statement(MocaSqlParser.Conversation_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#message_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_statement(MocaSqlParser.Message_statementContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#receive_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceive_statement(MocaSqlParser.Receive_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_statement(MocaSqlParser.Select_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(MocaSqlParser.TimeContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#create_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_database(MocaSqlParser.Create_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_index(MocaSqlParser.Create_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_procedure(MocaSqlParser.Create_or_alter_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_trigger(MocaSqlParser.Create_or_alter_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_dml_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_dml_trigger(MocaSqlParser.Create_or_alter_dml_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#dml_trigger_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDml_trigger_option(MocaSqlParser.Dml_trigger_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#dml_trigger_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDml_trigger_operation(MocaSqlParser.Dml_trigger_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_ddl_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_ddl_trigger(MocaSqlParser.Create_or_alter_ddl_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#ddl_trigger_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdl_trigger_operation(MocaSqlParser.Ddl_trigger_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_or_alter_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_or_alter_function(MocaSqlParser.Create_or_alter_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_body_returns_select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body_returns_select(MocaSqlParser.Func_body_returns_selectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_body_returns_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body_returns_table(MocaSqlParser.Func_body_returns_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#func_body_returns_scalar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body_returns_scalar(MocaSqlParser.Func_body_returns_scalarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#procedure_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_param(MocaSqlParser.Procedure_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#procedure_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_option(MocaSqlParser.Procedure_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#function_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_option(MocaSqlParser.Function_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_statistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_statistics(MocaSqlParser.Create_statisticsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#update_statistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_statistics(MocaSqlParser.Update_statisticsContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_database(MocaSqlParser.Alter_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#database_optionspec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_optionspec(MocaSqlParser.Database_optionspecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#auto_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuto_option(MocaSqlParser.Auto_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#change_tracking_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_tracking_option(MocaSqlParser.Change_tracking_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#change_tracking_option_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange_tracking_option_list(MocaSqlParser.Change_tracking_option_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#containment_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainment_option(MocaSqlParser.Containment_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#cursor_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_option(MocaSqlParser.Cursor_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#alter_endpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_endpoint(MocaSqlParser.Alter_endpointContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#database_mirroring_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_mirroring_option(MocaSqlParser.Database_mirroring_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#mirroring_set_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMirroring_set_option(MocaSqlParser.Mirroring_set_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#mirroring_partner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMirroring_partner(MocaSqlParser.Mirroring_partnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#mirroring_witness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMirroring_witness(MocaSqlParser.Mirroring_witnessContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#witness_partner_equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWitness_partner_equal(MocaSqlParser.Witness_partner_equalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#partner_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartner_option(MocaSqlParser.Partner_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#witness_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWitness_option(MocaSqlParser.Witness_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#witness_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWitness_server(MocaSqlParser.Witness_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#partner_server}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartner_server(MocaSqlParser.Partner_serverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#mirroring_host_port_seperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMirroring_host_port_seperator(MocaSqlParser.Mirroring_host_port_seperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#partner_server_tcp_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartner_server_tcp_prefix(MocaSqlParser.Partner_server_tcp_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#port_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort_number(MocaSqlParser.Port_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#host}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHost(MocaSqlParser.HostContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#date_correlation_optimization_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_correlation_optimization_option(MocaSqlParser.Date_correlation_optimization_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#db_encryption_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb_encryption_option(MocaSqlParser.Db_encryption_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#db_state_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb_state_option(MocaSqlParser.Db_state_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#db_update_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb_update_option(MocaSqlParser.Db_update_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#db_user_access_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb_user_access_option(MocaSqlParser.Db_user_access_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#delayed_durability_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayed_durability_option(MocaSqlParser.Delayed_durability_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#external_access_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternal_access_option(MocaSqlParser.External_access_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#hadr_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHadr_options(MocaSqlParser.Hadr_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#mixed_page_allocation_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixed_page_allocation_option(MocaSqlParser.Mixed_page_allocation_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#parameterization_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterization_option(MocaSqlParser.Parameterization_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#recovery_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecovery_option(MocaSqlParser.Recovery_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#service_broker_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_broker_option(MocaSqlParser.Service_broker_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#snapshot_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSnapshot_option(MocaSqlParser.Snapshot_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#sql_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_option(MocaSqlParser.Sql_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#target_recovery_time_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_recovery_time_option(MocaSqlParser.Target_recovery_time_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#termination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermination(MocaSqlParser.TerminationContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_procedure(MocaSqlParser.Drop_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_trigger(MocaSqlParser.Drop_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_dml_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_dml_trigger(MocaSqlParser.Drop_dml_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_ddl_trigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_ddl_trigger(MocaSqlParser.Drop_ddl_triggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_function(MocaSqlParser.Drop_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_statistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_statistics(MocaSqlParser.Drop_statisticsContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#create_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_type(MocaSqlParser.Create_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#drop_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_type(MocaSqlParser.Drop_typeContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#declare_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_statement(MocaSqlParser.Declare_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_statement(MocaSqlParser.Cursor_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_database(MocaSqlParser.Backup_databaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_log(MocaSqlParser.Backup_logContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_certificate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_certificate(MocaSqlParser.Backup_certificateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_master_key(MocaSqlParser.Backup_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#backup_service_master_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackup_service_master_key(MocaSqlParser.Backup_service_master_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#kill_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill_statement(MocaSqlParser.Kill_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#kill_process}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill_process(MocaSqlParser.Kill_processContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#kill_query_notification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill_query_notification(MocaSqlParser.Kill_query_notificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#kill_stats_job}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill_stats_job(MocaSqlParser.Kill_stats_jobContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#security_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecurity_statement(MocaSqlParser.Security_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_certificate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_certificate(MocaSqlParser.Create_certificateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#existing_keys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExisting_keys(MocaSqlParser.Existing_keysContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#private_key_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivate_key_options(MocaSqlParser.Private_key_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#generate_new_keys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerate_new_keys(MocaSqlParser.Generate_new_keysContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#date_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_options(MocaSqlParser.Date_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#open_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_key(MocaSqlParser.Open_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#close_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClose_key(MocaSqlParser.Close_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#create_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_key(MocaSqlParser.Create_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#key_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey_options(MocaSqlParser.Key_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#algorithm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorithm(MocaSqlParser.AlgorithmContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#encryption_mechanism}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryption_mechanism(MocaSqlParser.Encryption_mechanismContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#decryption_mechanism}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecryption_mechanism(MocaSqlParser.Decryption_mechanismContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#grant_permission}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrant_permission(MocaSqlParser.Grant_permissionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#set_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_statement(MocaSqlParser.Set_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransaction_statement(MocaSqlParser.Transaction_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#go_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGo_statement(MocaSqlParser.Go_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#use_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_statement(MocaSqlParser.Use_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#setuser_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetuser_statement(MocaSqlParser.Setuser_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#reconfigure_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReconfigure_statement(MocaSqlParser.Reconfigure_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShutdown_statement(MocaSqlParser.Shutdown_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#dbcc_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbcc_clause(MocaSqlParser.Dbcc_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#dbcc_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbcc_options(MocaSqlParser.Dbcc_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#execute_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_clause(MocaSqlParser.Execute_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#declare_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_local(MocaSqlParser.Declare_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#table_type_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_type_definition(MocaSqlParser.Table_type_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#xml_type_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml_type_definition(MocaSqlParser.Xml_type_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#xml_schema_collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml_schema_collection(MocaSqlParser.Xml_schema_collectionContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_cursor(MocaSqlParser.Declare_cursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_set_cursor_common(MocaSqlParser.Declare_set_cursor_commonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common_partial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_set_cursor_common_partial(MocaSqlParser.Declare_set_cursor_common_partialContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#fetch_cursor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetch_cursor(MocaSqlParser.Fetch_cursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#set_special}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_special(MocaSqlParser.Set_specialContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_variable(MocaSqlParser.Moca_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_anywhere_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_anywhere_variable(MocaSqlParser.Moca_anywhere_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_plus_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_plus_variable(MocaSqlParser.Moca_plus_variableContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_mod_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_mod_variable(MocaSqlParser.Moca_at_mod_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_star(MocaSqlParser.Moca_at_starContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_keep_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_keep_directive(MocaSqlParser.Moca_keep_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_keep_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_keep_directive(MocaSqlParser.Moca_at_keep_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_minus_keep_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_minus_keep_directive(MocaSqlParser.Moca_at_minus_keep_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_plus_keep_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_plus_keep_directive(MocaSqlParser.Moca_at_plus_keep_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_mod_keep_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_mod_keep_directive(MocaSqlParser.Moca_at_mod_keep_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_onstack_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_onstack_directive(MocaSqlParser.Moca_onstack_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_ignore_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_ignore_directive(MocaSqlParser.Moca_ignore_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_oldvar_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_oldvar_directive(MocaSqlParser.Moca_oldvar_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_plus_oldvar_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_plus_oldvar_directive(MocaSqlParser.Moca_at_plus_oldvar_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_at_mod_oldvar_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_at_mod_oldvar_directive(MocaSqlParser.Moca_at_mod_oldvar_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_type_cast_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_type_cast_variable(MocaSqlParser.Moca_type_cast_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#moca_database_qualifier_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoca_database_qualifier_variable(MocaSqlParser.Moca_database_qualifier_variableContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#create_database_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_database_option(MocaSqlParser.Create_database_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#database_filestream_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_filestream_option(MocaSqlParser.Database_filestream_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#database_file_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_file_spec(MocaSqlParser.Database_file_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#file_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_group(MocaSqlParser.File_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#file_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_spec(MocaSqlParser.File_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#entity_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_name(MocaSqlParser.Entity_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#entity_name_for_azure_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_name_for_azure_dw(MocaSqlParser.Entity_name_for_azure_dwContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#entity_name_for_parallel_dw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_name_for_parallel_dw(MocaSqlParser.Entity_name_for_parallel_dwContext ctx);
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
	 * Visit a parse tree produced by {@link MocaSqlParser#begin_conversation_timer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_conversation_timer(MocaSqlParser.Begin_conversation_timerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#begin_conversation_dialog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_conversation_dialog(MocaSqlParser.Begin_conversation_dialogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#contract_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContract_name(MocaSqlParser.Contract_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#service_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_name(MocaSqlParser.Service_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#end_conversation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_conversation(MocaSqlParser.End_conversationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#waitfor_conversation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitfor_conversation(MocaSqlParser.Waitfor_conversationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#get_conversation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet_conversation(MocaSqlParser.Get_conversationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#queue_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueue_id(MocaSqlParser.Queue_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#send_conversation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend_conversation(MocaSqlParser.Send_conversationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(MocaSqlParser.Data_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#default_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_value(MocaSqlParser.Default_valueContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link MocaSqlParser#file_size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_size(MocaSqlParser.File_sizeContext ctx);
}