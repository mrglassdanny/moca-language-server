// Generated from MocaSql.g4 by ANTLR 4.5.3

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
	 * Enter a parse tree produced by {@link MocaSqlParser#batch}.
	 * @param ctx the parse tree
	 */
	void enterBatch(MocaSqlParser.BatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#batch}.
	 * @param ctx the parse tree
	 */
	void exitBatch(MocaSqlParser.BatchContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_statement}.
	 * @param ctx the parse tree
	 */
	void enterBackup_statement(MocaSqlParser.Backup_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_statement}.
	 * @param ctx the parse tree
	 */
	void exitBackup_statement(MocaSqlParser.Backup_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#cfl_statement}.
	 * @param ctx the parse tree
	 */
	void enterCfl_statement(MocaSqlParser.Cfl_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#cfl_statement}.
	 * @param ctx the parse tree
	 */
	void exitCfl_statement(MocaSqlParser.Cfl_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(MocaSqlParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(MocaSqlParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#break_statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_statement(MocaSqlParser.Break_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#break_statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_statement(MocaSqlParser.Break_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_statement(MocaSqlParser.Continue_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_statement(MocaSqlParser.Continue_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#goto_statement}.
	 * @param ctx the parse tree
	 */
	void enterGoto_statement(MocaSqlParser.Goto_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#goto_statement}.
	 * @param ctx the parse tree
	 */
	void exitGoto_statement(MocaSqlParser.Goto_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(MocaSqlParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(MocaSqlParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MocaSqlParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MocaSqlParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#throw_statement}.
	 * @param ctx the parse tree
	 */
	void enterThrow_statement(MocaSqlParser.Throw_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#throw_statement}.
	 * @param ctx the parse tree
	 */
	void exitThrow_statement(MocaSqlParser.Throw_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#throw_error_number}.
	 * @param ctx the parse tree
	 */
	void enterThrow_error_number(MocaSqlParser.Throw_error_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#throw_error_number}.
	 * @param ctx the parse tree
	 */
	void exitThrow_error_number(MocaSqlParser.Throw_error_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#throw_message}.
	 * @param ctx the parse tree
	 */
	void enterThrow_message(MocaSqlParser.Throw_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#throw_message}.
	 * @param ctx the parse tree
	 */
	void exitThrow_message(MocaSqlParser.Throw_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#throw_state}.
	 * @param ctx the parse tree
	 */
	void enterThrow_state(MocaSqlParser.Throw_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#throw_state}.
	 * @param ctx the parse tree
	 */
	void exitThrow_state(MocaSqlParser.Throw_stateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#try_catch_statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_catch_statement(MocaSqlParser.Try_catch_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#try_catch_statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_catch_statement(MocaSqlParser.Try_catch_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#waitfor_statement}.
	 * @param ctx the parse tree
	 */
	void enterWaitfor_statement(MocaSqlParser.Waitfor_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#waitfor_statement}.
	 * @param ctx the parse tree
	 */
	void exitWaitfor_statement(MocaSqlParser.Waitfor_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(MocaSqlParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(MocaSqlParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(MocaSqlParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(MocaSqlParser.Print_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#raiseerror_statement}.
	 * @param ctx the parse tree
	 */
	void enterRaiseerror_statement(MocaSqlParser.Raiseerror_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#raiseerror_statement}.
	 * @param ctx the parse tree
	 */
	void exitRaiseerror_statement(MocaSqlParser.Raiseerror_statementContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#another_statement}.
	 * @param ctx the parse tree
	 */
	void enterAnother_statement(MocaSqlParser.Another_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#another_statement}.
	 * @param ctx the parse tree
	 */
	void exitAnother_statement(MocaSqlParser.Another_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_application_role}.
	 * @param ctx the parse tree
	 */
	void enterAlter_application_role(MocaSqlParser.Alter_application_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_application_role}.
	 * @param ctx the parse tree
	 */
	void exitAlter_application_role(MocaSqlParser.Alter_application_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_application_role}.
	 * @param ctx the parse tree
	 */
	void enterCreate_application_role(MocaSqlParser.Create_application_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_application_role}.
	 * @param ctx the parse tree
	 */
	void exitCreate_application_role(MocaSqlParser.Create_application_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_aggregate}.
	 * @param ctx the parse tree
	 */
	void enterDrop_aggregate(MocaSqlParser.Drop_aggregateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_aggregate}.
	 * @param ctx the parse tree
	 */
	void exitDrop_aggregate(MocaSqlParser.Drop_aggregateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_application_role}.
	 * @param ctx the parse tree
	 */
	void enterDrop_application_role(MocaSqlParser.Drop_application_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_application_role}.
	 * @param ctx the parse tree
	 */
	void exitDrop_application_role(MocaSqlParser.Drop_application_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly(MocaSqlParser.Alter_assemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly(MocaSqlParser.Alter_assemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_start(MocaSqlParser.Alter_assembly_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_start(MocaSqlParser.Alter_assembly_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_clause(MocaSqlParser.Alter_assembly_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_clause(MocaSqlParser.Alter_assembly_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_from_clause(MocaSqlParser.Alter_assembly_from_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_from_clause(MocaSqlParser.Alter_assembly_from_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_from_clause_start(MocaSqlParser.Alter_assembly_from_clause_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_from_clause_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_from_clause_start(MocaSqlParser.Alter_assembly_from_clause_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_drop_clause(MocaSqlParser.Alter_assembly_drop_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_drop_clause(MocaSqlParser.Alter_assembly_drop_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_multiple_files}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_drop_multiple_files(MocaSqlParser.Alter_assembly_drop_multiple_filesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop_multiple_files}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_drop_multiple_files(MocaSqlParser.Alter_assembly_drop_multiple_filesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_drop}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_drop(MocaSqlParser.Alter_assembly_dropContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_drop}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_drop(MocaSqlParser.Alter_assembly_dropContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_add_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_add_clause(MocaSqlParser.Alter_assembly_add_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_add_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_add_clause(MocaSqlParser.Alter_assembly_add_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_asssembly_add_clause_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_asssembly_add_clause_start(MocaSqlParser.Alter_asssembly_add_clause_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_asssembly_add_clause_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_asssembly_add_clause_start(MocaSqlParser.Alter_asssembly_add_clause_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_client_file_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_client_file_clause(MocaSqlParser.Alter_assembly_client_file_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_client_file_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_client_file_clause(MocaSqlParser.Alter_assembly_client_file_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_file_name}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_file_name(MocaSqlParser.Alter_assembly_file_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_file_name}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_file_name(MocaSqlParser.Alter_assembly_file_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_file_bits}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_file_bits(MocaSqlParser.Alter_assembly_file_bitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_file_bits}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_file_bits(MocaSqlParser.Alter_assembly_file_bitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_as}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_as(MocaSqlParser.Alter_assembly_asContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_as}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_as(MocaSqlParser.Alter_assembly_asContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_with_clause}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_with_clause(MocaSqlParser.Alter_assembly_with_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_with_clause}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_with_clause(MocaSqlParser.Alter_assembly_with_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_assembly_with}.
	 * @param ctx the parse tree
	 */
	void enterAlter_assembly_with(MocaSqlParser.Alter_assembly_withContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_assembly_with}.
	 * @param ctx the parse tree
	 */
	void exitAlter_assembly_with(MocaSqlParser.Alter_assembly_withContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#client_assembly_specifier}.
	 * @param ctx the parse tree
	 */
	void enterClient_assembly_specifier(MocaSqlParser.Client_assembly_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#client_assembly_specifier}.
	 * @param ctx the parse tree
	 */
	void exitClient_assembly_specifier(MocaSqlParser.Client_assembly_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#assembly_option}.
	 * @param ctx the parse tree
	 */
	void enterAssembly_option(MocaSqlParser.Assembly_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#assembly_option}.
	 * @param ctx the parse tree
	 */
	void exitAssembly_option(MocaSqlParser.Assembly_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#network_file_share}.
	 * @param ctx the parse tree
	 */
	void enterNetwork_file_share(MocaSqlParser.Network_file_shareContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#network_file_share}.
	 * @param ctx the parse tree
	 */
	void exitNetwork_file_share(MocaSqlParser.Network_file_shareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#network_computer}.
	 * @param ctx the parse tree
	 */
	void enterNetwork_computer(MocaSqlParser.Network_computerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#network_computer}.
	 * @param ctx the parse tree
	 */
	void exitNetwork_computer(MocaSqlParser.Network_computerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#network_file_start}.
	 * @param ctx the parse tree
	 */
	void enterNetwork_file_start(MocaSqlParser.Network_file_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#network_file_start}.
	 * @param ctx the parse tree
	 */
	void exitNetwork_file_start(MocaSqlParser.Network_file_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#file_path}.
	 * @param ctx the parse tree
	 */
	void enterFile_path(MocaSqlParser.File_pathContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#file_path}.
	 * @param ctx the parse tree
	 */
	void exitFile_path(MocaSqlParser.File_pathContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#file_directory_path_separator}.
	 * @param ctx the parse tree
	 */
	void enterFile_directory_path_separator(MocaSqlParser.File_directory_path_separatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#file_directory_path_separator}.
	 * @param ctx the parse tree
	 */
	void exitFile_directory_path_separator(MocaSqlParser.File_directory_path_separatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#local_file}.
	 * @param ctx the parse tree
	 */
	void enterLocal_file(MocaSqlParser.Local_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#local_file}.
	 * @param ctx the parse tree
	 */
	void exitLocal_file(MocaSqlParser.Local_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#local_drive}.
	 * @param ctx the parse tree
	 */
	void enterLocal_drive(MocaSqlParser.Local_driveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#local_drive}.
	 * @param ctx the parse tree
	 */
	void exitLocal_drive(MocaSqlParser.Local_driveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#multiple_local_files}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_local_files(MocaSqlParser.Multiple_local_filesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#multiple_local_files}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_local_files(MocaSqlParser.Multiple_local_filesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#multiple_local_file_start}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_local_file_start(MocaSqlParser.Multiple_local_file_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#multiple_local_file_start}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_local_file_start(MocaSqlParser.Multiple_local_file_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_assembly}.
	 * @param ctx the parse tree
	 */
	void enterCreate_assembly(MocaSqlParser.Create_assemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_assembly}.
	 * @param ctx the parse tree
	 */
	void exitCreate_assembly(MocaSqlParser.Create_assemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_assembly}.
	 * @param ctx the parse tree
	 */
	void enterDrop_assembly(MocaSqlParser.Drop_assemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_assembly}.
	 * @param ctx the parse tree
	 */
	void exitDrop_assembly(MocaSqlParser.Drop_assemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterAlter_asymmetric_key(MocaSqlParser.Alter_asymmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitAlter_asymmetric_key(MocaSqlParser.Alter_asymmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_asymmetric_key_start(MocaSqlParser.Alter_asymmetric_key_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_asymmetric_key_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_asymmetric_key_start(MocaSqlParser.Alter_asymmetric_key_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#asymmetric_key_option}.
	 * @param ctx the parse tree
	 */
	void enterAsymmetric_key_option(MocaSqlParser.Asymmetric_key_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#asymmetric_key_option}.
	 * @param ctx the parse tree
	 */
	void exitAsymmetric_key_option(MocaSqlParser.Asymmetric_key_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#asymmetric_key_option_start}.
	 * @param ctx the parse tree
	 */
	void enterAsymmetric_key_option_start(MocaSqlParser.Asymmetric_key_option_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#asymmetric_key_option_start}.
	 * @param ctx the parse tree
	 */
	void exitAsymmetric_key_option_start(MocaSqlParser.Asymmetric_key_option_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#asymmetric_key_password_change_option}.
	 * @param ctx the parse tree
	 */
	void enterAsymmetric_key_password_change_option(MocaSqlParser.Asymmetric_key_password_change_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#asymmetric_key_password_change_option}.
	 * @param ctx the parse tree
	 */
	void exitAsymmetric_key_password_change_option(MocaSqlParser.Asymmetric_key_password_change_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterCreate_asymmetric_key(MocaSqlParser.Create_asymmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitCreate_asymmetric_key(MocaSqlParser.Create_asymmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterDrop_asymmetric_key(MocaSqlParser.Drop_asymmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_asymmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitDrop_asymmetric_key(MocaSqlParser.Drop_asymmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_authorization}.
	 * @param ctx the parse tree
	 */
	void enterAlter_authorization(MocaSqlParser.Alter_authorizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_authorization}.
	 * @param ctx the parse tree
	 */
	void exitAlter_authorization(MocaSqlParser.Alter_authorizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#authorization_grantee}.
	 * @param ctx the parse tree
	 */
	void enterAuthorization_grantee(MocaSqlParser.Authorization_granteeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#authorization_grantee}.
	 * @param ctx the parse tree
	 */
	void exitAuthorization_grantee(MocaSqlParser.Authorization_granteeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#entity_to}.
	 * @param ctx the parse tree
	 */
	void enterEntity_to(MocaSqlParser.Entity_toContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#entity_to}.
	 * @param ctx the parse tree
	 */
	void exitEntity_to(MocaSqlParser.Entity_toContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#colon_colon}.
	 * @param ctx the parse tree
	 */
	void enterColon_colon(MocaSqlParser.Colon_colonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#colon_colon}.
	 * @param ctx the parse tree
	 */
	void exitColon_colon(MocaSqlParser.Colon_colonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_authorization_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_authorization_start(MocaSqlParser.Alter_authorization_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_authorization_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_authorization_start(MocaSqlParser.Alter_authorization_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_authorization_for_sql_database}.
	 * @param ctx the parse tree
	 */
	void enterAlter_authorization_for_sql_database(MocaSqlParser.Alter_authorization_for_sql_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_sql_database}.
	 * @param ctx the parse tree
	 */
	void exitAlter_authorization_for_sql_database(MocaSqlParser.Alter_authorization_for_sql_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_authorization_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void enterAlter_authorization_for_azure_dw(MocaSqlParser.Alter_authorization_for_azure_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void exitAlter_authorization_for_azure_dw(MocaSqlParser.Alter_authorization_for_azure_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_authorization_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void enterAlter_authorization_for_parallel_dw(MocaSqlParser.Alter_authorization_for_parallel_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_authorization_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void exitAlter_authorization_for_parallel_dw(MocaSqlParser.Alter_authorization_for_parallel_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#class_type}.
	 * @param ctx the parse tree
	 */
	void enterClass_type(MocaSqlParser.Class_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#class_type}.
	 * @param ctx the parse tree
	 */
	void exitClass_type(MocaSqlParser.Class_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#class_type_for_sql_database}.
	 * @param ctx the parse tree
	 */
	void enterClass_type_for_sql_database(MocaSqlParser.Class_type_for_sql_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#class_type_for_sql_database}.
	 * @param ctx the parse tree
	 */
	void exitClass_type_for_sql_database(MocaSqlParser.Class_type_for_sql_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#class_type_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void enterClass_type_for_azure_dw(MocaSqlParser.Class_type_for_azure_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#class_type_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void exitClass_type_for_azure_dw(MocaSqlParser.Class_type_for_azure_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#class_type_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void enterClass_type_for_parallel_dw(MocaSqlParser.Class_type_for_parallel_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#class_type_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void exitClass_type_for_parallel_dw(MocaSqlParser.Class_type_for_parallel_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_availability_group}.
	 * @param ctx the parse tree
	 */
	void enterDrop_availability_group(MocaSqlParser.Drop_availability_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_availability_group}.
	 * @param ctx the parse tree
	 */
	void exitDrop_availability_group(MocaSqlParser.Drop_availability_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_availability_group}.
	 * @param ctx the parse tree
	 */
	void enterAlter_availability_group(MocaSqlParser.Alter_availability_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_availability_group}.
	 * @param ctx the parse tree
	 */
	void exitAlter_availability_group(MocaSqlParser.Alter_availability_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_availability_group_start}.
	 * @param ctx the parse tree
	 */
	void enterAlter_availability_group_start(MocaSqlParser.Alter_availability_group_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_availability_group_start}.
	 * @param ctx the parse tree
	 */
	void exitAlter_availability_group_start(MocaSqlParser.Alter_availability_group_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_availability_group_options}.
	 * @param ctx the parse tree
	 */
	void enterAlter_availability_group_options(MocaSqlParser.Alter_availability_group_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_availability_group_options}.
	 * @param ctx the parse tree
	 */
	void exitAlter_availability_group_options(MocaSqlParser.Alter_availability_group_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_broker_priority}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_broker_priority(MocaSqlParser.Create_or_alter_broker_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_broker_priority}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_broker_priority(MocaSqlParser.Create_or_alter_broker_priorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_broker_priority}.
	 * @param ctx the parse tree
	 */
	void enterDrop_broker_priority(MocaSqlParser.Drop_broker_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_broker_priority}.
	 * @param ctx the parse tree
	 */
	void exitDrop_broker_priority(MocaSqlParser.Drop_broker_priorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_certificate}.
	 * @param ctx the parse tree
	 */
	void enterAlter_certificate(MocaSqlParser.Alter_certificateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_certificate}.
	 * @param ctx the parse tree
	 */
	void exitAlter_certificate(MocaSqlParser.Alter_certificateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void enterAlter_column_encryption_key(MocaSqlParser.Alter_column_encryption_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void exitAlter_column_encryption_key(MocaSqlParser.Alter_column_encryption_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void enterCreate_column_encryption_key(MocaSqlParser.Create_column_encryption_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void exitCreate_column_encryption_key(MocaSqlParser.Create_column_encryption_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_certificate}.
	 * @param ctx the parse tree
	 */
	void enterDrop_certificate(MocaSqlParser.Drop_certificateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_certificate}.
	 * @param ctx the parse tree
	 */
	void exitDrop_certificate(MocaSqlParser.Drop_certificateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void enterDrop_column_encryption_key(MocaSqlParser.Drop_column_encryption_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_column_encryption_key}.
	 * @param ctx the parse tree
	 */
	void exitDrop_column_encryption_key(MocaSqlParser.Drop_column_encryption_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_column_master_key}.
	 * @param ctx the parse tree
	 */
	void enterDrop_column_master_key(MocaSqlParser.Drop_column_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_column_master_key}.
	 * @param ctx the parse tree
	 */
	void exitDrop_column_master_key(MocaSqlParser.Drop_column_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_contract}.
	 * @param ctx the parse tree
	 */
	void enterDrop_contract(MocaSqlParser.Drop_contractContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_contract}.
	 * @param ctx the parse tree
	 */
	void exitDrop_contract(MocaSqlParser.Drop_contractContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_credential}.
	 * @param ctx the parse tree
	 */
	void enterDrop_credential(MocaSqlParser.Drop_credentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_credential}.
	 * @param ctx the parse tree
	 */
	void exitDrop_credential(MocaSqlParser.Drop_credentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_cryptograhic_provider}.
	 * @param ctx the parse tree
	 */
	void enterDrop_cryptograhic_provider(MocaSqlParser.Drop_cryptograhic_providerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_cryptograhic_provider}.
	 * @param ctx the parse tree
	 */
	void exitDrop_cryptograhic_provider(MocaSqlParser.Drop_cryptograhic_providerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database(MocaSqlParser.Drop_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_database}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database(MocaSqlParser.Drop_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_database_audit_specification}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database_audit_specification(MocaSqlParser.Drop_database_audit_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_database_audit_specification}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database_audit_specification(MocaSqlParser.Drop_database_audit_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_database_scoped_credential}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database_scoped_credential(MocaSqlParser.Drop_database_scoped_credentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_database_scoped_credential}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database_scoped_credential(MocaSqlParser.Drop_database_scoped_credentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_default}.
	 * @param ctx the parse tree
	 */
	void enterDrop_default(MocaSqlParser.Drop_defaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_default}.
	 * @param ctx the parse tree
	 */
	void exitDrop_default(MocaSqlParser.Drop_defaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_endpoint}.
	 * @param ctx the parse tree
	 */
	void enterDrop_endpoint(MocaSqlParser.Drop_endpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_endpoint}.
	 * @param ctx the parse tree
	 */
	void exitDrop_endpoint(MocaSqlParser.Drop_endpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_external_data_source}.
	 * @param ctx the parse tree
	 */
	void enterDrop_external_data_source(MocaSqlParser.Drop_external_data_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_external_data_source}.
	 * @param ctx the parse tree
	 */
	void exitDrop_external_data_source(MocaSqlParser.Drop_external_data_sourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_external_file_format}.
	 * @param ctx the parse tree
	 */
	void enterDrop_external_file_format(MocaSqlParser.Drop_external_file_formatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_external_file_format}.
	 * @param ctx the parse tree
	 */
	void exitDrop_external_file_format(MocaSqlParser.Drop_external_file_formatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_external_library}.
	 * @param ctx the parse tree
	 */
	void enterDrop_external_library(MocaSqlParser.Drop_external_libraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_external_library}.
	 * @param ctx the parse tree
	 */
	void exitDrop_external_library(MocaSqlParser.Drop_external_libraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void enterDrop_external_resource_pool(MocaSqlParser.Drop_external_resource_poolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void exitDrop_external_resource_pool(MocaSqlParser.Drop_external_resource_poolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_external_table}.
	 * @param ctx the parse tree
	 */
	void enterDrop_external_table(MocaSqlParser.Drop_external_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_external_table}.
	 * @param ctx the parse tree
	 */
	void exitDrop_external_table(MocaSqlParser.Drop_external_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_event_notifications}.
	 * @param ctx the parse tree
	 */
	void enterDrop_event_notifications(MocaSqlParser.Drop_event_notificationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_event_notifications}.
	 * @param ctx the parse tree
	 */
	void exitDrop_event_notifications(MocaSqlParser.Drop_event_notificationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_event_session}.
	 * @param ctx the parse tree
	 */
	void enterDrop_event_session(MocaSqlParser.Drop_event_sessionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_event_session}.
	 * @param ctx the parse tree
	 */
	void exitDrop_event_session(MocaSqlParser.Drop_event_sessionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void enterDrop_fulltext_catalog(MocaSqlParser.Drop_fulltext_catalogContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void exitDrop_fulltext_catalog(MocaSqlParser.Drop_fulltext_catalogContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_fulltext_index}.
	 * @param ctx the parse tree
	 */
	void enterDrop_fulltext_index(MocaSqlParser.Drop_fulltext_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_fulltext_index}.
	 * @param ctx the parse tree
	 */
	void exitDrop_fulltext_index(MocaSqlParser.Drop_fulltext_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void enterDrop_fulltext_stoplist(MocaSqlParser.Drop_fulltext_stoplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void exitDrop_fulltext_stoplist(MocaSqlParser.Drop_fulltext_stoplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_login}.
	 * @param ctx the parse tree
	 */
	void enterDrop_login(MocaSqlParser.Drop_loginContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_login}.
	 * @param ctx the parse tree
	 */
	void exitDrop_login(MocaSqlParser.Drop_loginContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_master_key}.
	 * @param ctx the parse tree
	 */
	void enterDrop_master_key(MocaSqlParser.Drop_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_master_key}.
	 * @param ctx the parse tree
	 */
	void exitDrop_master_key(MocaSqlParser.Drop_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_message_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_message_type(MocaSqlParser.Drop_message_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_message_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_message_type(MocaSqlParser.Drop_message_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_partition_function}.
	 * @param ctx the parse tree
	 */
	void enterDrop_partition_function(MocaSqlParser.Drop_partition_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_partition_function}.
	 * @param ctx the parse tree
	 */
	void exitDrop_partition_function(MocaSqlParser.Drop_partition_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_partition_scheme}.
	 * @param ctx the parse tree
	 */
	void enterDrop_partition_scheme(MocaSqlParser.Drop_partition_schemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_partition_scheme}.
	 * @param ctx the parse tree
	 */
	void exitDrop_partition_scheme(MocaSqlParser.Drop_partition_schemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_queue}.
	 * @param ctx the parse tree
	 */
	void enterDrop_queue(MocaSqlParser.Drop_queueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_queue}.
	 * @param ctx the parse tree
	 */
	void exitDrop_queue(MocaSqlParser.Drop_queueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void enterDrop_remote_service_binding(MocaSqlParser.Drop_remote_service_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void exitDrop_remote_service_binding(MocaSqlParser.Drop_remote_service_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_resource_pool}.
	 * @param ctx the parse tree
	 */
	void enterDrop_resource_pool(MocaSqlParser.Drop_resource_poolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_resource_pool}.
	 * @param ctx the parse tree
	 */
	void exitDrop_resource_pool(MocaSqlParser.Drop_resource_poolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_db_role}.
	 * @param ctx the parse tree
	 */
	void enterDrop_db_role(MocaSqlParser.Drop_db_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_db_role}.
	 * @param ctx the parse tree
	 */
	void exitDrop_db_role(MocaSqlParser.Drop_db_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_route}.
	 * @param ctx the parse tree
	 */
	void enterDrop_route(MocaSqlParser.Drop_routeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_route}.
	 * @param ctx the parse tree
	 */
	void exitDrop_route(MocaSqlParser.Drop_routeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_rule}.
	 * @param ctx the parse tree
	 */
	void enterDrop_rule(MocaSqlParser.Drop_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_rule}.
	 * @param ctx the parse tree
	 */
	void exitDrop_rule(MocaSqlParser.Drop_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_schema}.
	 * @param ctx the parse tree
	 */
	void enterDrop_schema(MocaSqlParser.Drop_schemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_schema}.
	 * @param ctx the parse tree
	 */
	void exitDrop_schema(MocaSqlParser.Drop_schemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_search_property_list}.
	 * @param ctx the parse tree
	 */
	void enterDrop_search_property_list(MocaSqlParser.Drop_search_property_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_search_property_list}.
	 * @param ctx the parse tree
	 */
	void exitDrop_search_property_list(MocaSqlParser.Drop_search_property_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_security_policy}.
	 * @param ctx the parse tree
	 */
	void enterDrop_security_policy(MocaSqlParser.Drop_security_policyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_security_policy}.
	 * @param ctx the parse tree
	 */
	void exitDrop_security_policy(MocaSqlParser.Drop_security_policyContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_server_audit}.
	 * @param ctx the parse tree
	 */
	void enterDrop_server_audit(MocaSqlParser.Drop_server_auditContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_server_audit}.
	 * @param ctx the parse tree
	 */
	void exitDrop_server_audit(MocaSqlParser.Drop_server_auditContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void enterDrop_server_audit_specification(MocaSqlParser.Drop_server_audit_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void exitDrop_server_audit_specification(MocaSqlParser.Drop_server_audit_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_server_role}.
	 * @param ctx the parse tree
	 */
	void enterDrop_server_role(MocaSqlParser.Drop_server_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_server_role}.
	 * @param ctx the parse tree
	 */
	void exitDrop_server_role(MocaSqlParser.Drop_server_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_service}.
	 * @param ctx the parse tree
	 */
	void enterDrop_service(MocaSqlParser.Drop_serviceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_service}.
	 * @param ctx the parse tree
	 */
	void exitDrop_service(MocaSqlParser.Drop_serviceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_signature}.
	 * @param ctx the parse tree
	 */
	void enterDrop_signature(MocaSqlParser.Drop_signatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_signature}.
	 * @param ctx the parse tree
	 */
	void exitDrop_signature(MocaSqlParser.Drop_signatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_statistics_name_azure_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void enterDrop_statistics_name_azure_dw_and_pdw(MocaSqlParser.Drop_statistics_name_azure_dw_and_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_statistics_name_azure_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void exitDrop_statistics_name_azure_dw_and_pdw(MocaSqlParser.Drop_statistics_name_azure_dw_and_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterDrop_symmetric_key(MocaSqlParser.Drop_symmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitDrop_symmetric_key(MocaSqlParser.Drop_symmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_synonym}.
	 * @param ctx the parse tree
	 */
	void enterDrop_synonym(MocaSqlParser.Drop_synonymContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_synonym}.
	 * @param ctx the parse tree
	 */
	void exitDrop_synonym(MocaSqlParser.Drop_synonymContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_user}.
	 * @param ctx the parse tree
	 */
	void enterDrop_user(MocaSqlParser.Drop_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_user}.
	 * @param ctx the parse tree
	 */
	void exitDrop_user(MocaSqlParser.Drop_userContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_workload_group}.
	 * @param ctx the parse tree
	 */
	void enterDrop_workload_group(MocaSqlParser.Drop_workload_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_workload_group}.
	 * @param ctx the parse tree
	 */
	void exitDrop_workload_group(MocaSqlParser.Drop_workload_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void enterDrop_xml_schema_collection(MocaSqlParser.Drop_xml_schema_collectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void exitDrop_xml_schema_collection(MocaSqlParser.Drop_xml_schema_collectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#disable_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDisable_trigger(MocaSqlParser.Disable_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#disable_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDisable_trigger(MocaSqlParser.Disable_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#enable_trigger}.
	 * @param ctx the parse tree
	 */
	void enterEnable_trigger(MocaSqlParser.Enable_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#enable_trigger}.
	 * @param ctx the parse tree
	 */
	void exitEnable_trigger(MocaSqlParser.Enable_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#lock_table}.
	 * @param ctx the parse tree
	 */
	void enterLock_table(MocaSqlParser.Lock_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#lock_table}.
	 * @param ctx the parse tree
	 */
	void exitLock_table(MocaSqlParser.Lock_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#truncate_table}.
	 * @param ctx the parse tree
	 */
	void enterTruncate_table(MocaSqlParser.Truncate_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#truncate_table}.
	 * @param ctx the parse tree
	 */
	void exitTruncate_table(MocaSqlParser.Truncate_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_column_master_key}.
	 * @param ctx the parse tree
	 */
	void enterCreate_column_master_key(MocaSqlParser.Create_column_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_column_master_key}.
	 * @param ctx the parse tree
	 */
	void exitCreate_column_master_key(MocaSqlParser.Create_column_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_credential}.
	 * @param ctx the parse tree
	 */
	void enterAlter_credential(MocaSqlParser.Alter_credentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_credential}.
	 * @param ctx the parse tree
	 */
	void exitAlter_credential(MocaSqlParser.Alter_credentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_credential}.
	 * @param ctx the parse tree
	 */
	void enterCreate_credential(MocaSqlParser.Create_credentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_credential}.
	 * @param ctx the parse tree
	 */
	void exitCreate_credential(MocaSqlParser.Create_credentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_cryptographic_provider}.
	 * @param ctx the parse tree
	 */
	void enterAlter_cryptographic_provider(MocaSqlParser.Alter_cryptographic_providerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_cryptographic_provider}.
	 * @param ctx the parse tree
	 */
	void exitAlter_cryptographic_provider(MocaSqlParser.Alter_cryptographic_providerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_cryptographic_provider}.
	 * @param ctx the parse tree
	 */
	void enterCreate_cryptographic_provider(MocaSqlParser.Create_cryptographic_providerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_cryptographic_provider}.
	 * @param ctx the parse tree
	 */
	void exitCreate_cryptographic_provider(MocaSqlParser.Create_cryptographic_providerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_event_notification}.
	 * @param ctx the parse tree
	 */
	void enterCreate_event_notification(MocaSqlParser.Create_event_notificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_event_notification}.
	 * @param ctx the parse tree
	 */
	void exitCreate_event_notification(MocaSqlParser.Create_event_notificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_event_session}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_event_session(MocaSqlParser.Create_or_alter_event_sessionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_event_session}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_event_session(MocaSqlParser.Create_or_alter_event_sessionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#event_session_predicate_expression}.
	 * @param ctx the parse tree
	 */
	void enterEvent_session_predicate_expression(MocaSqlParser.Event_session_predicate_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#event_session_predicate_expression}.
	 * @param ctx the parse tree
	 */
	void exitEvent_session_predicate_expression(MocaSqlParser.Event_session_predicate_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#event_session_predicate_factor}.
	 * @param ctx the parse tree
	 */
	void enterEvent_session_predicate_factor(MocaSqlParser.Event_session_predicate_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#event_session_predicate_factor}.
	 * @param ctx the parse tree
	 */
	void exitEvent_session_predicate_factor(MocaSqlParser.Event_session_predicate_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#event_session_predicate_leaf}.
	 * @param ctx the parse tree
	 */
	void enterEvent_session_predicate_leaf(MocaSqlParser.Event_session_predicate_leafContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#event_session_predicate_leaf}.
	 * @param ctx the parse tree
	 */
	void exitEvent_session_predicate_leaf(MocaSqlParser.Event_session_predicate_leafContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_external_data_source}.
	 * @param ctx the parse tree
	 */
	void enterAlter_external_data_source(MocaSqlParser.Alter_external_data_sourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_external_data_source}.
	 * @param ctx the parse tree
	 */
	void exitAlter_external_data_source(MocaSqlParser.Alter_external_data_sourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_external_library}.
	 * @param ctx the parse tree
	 */
	void enterAlter_external_library(MocaSqlParser.Alter_external_libraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_external_library}.
	 * @param ctx the parse tree
	 */
	void exitAlter_external_library(MocaSqlParser.Alter_external_libraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_external_library}.
	 * @param ctx the parse tree
	 */
	void enterCreate_external_library(MocaSqlParser.Create_external_libraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_external_library}.
	 * @param ctx the parse tree
	 */
	void exitCreate_external_library(MocaSqlParser.Create_external_libraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void enterAlter_external_resource_pool(MocaSqlParser.Alter_external_resource_poolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void exitAlter_external_resource_pool(MocaSqlParser.Alter_external_resource_poolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void enterCreate_external_resource_pool(MocaSqlParser.Create_external_resource_poolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_external_resource_pool}.
	 * @param ctx the parse tree
	 */
	void exitCreate_external_resource_pool(MocaSqlParser.Create_external_resource_poolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void enterAlter_fulltext_catalog(MocaSqlParser.Alter_fulltext_catalogContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void exitAlter_fulltext_catalog(MocaSqlParser.Alter_fulltext_catalogContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void enterCreate_fulltext_catalog(MocaSqlParser.Create_fulltext_catalogContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_fulltext_catalog}.
	 * @param ctx the parse tree
	 */
	void exitCreate_fulltext_catalog(MocaSqlParser.Create_fulltext_catalogContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void enterAlter_fulltext_stoplist(MocaSqlParser.Alter_fulltext_stoplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void exitAlter_fulltext_stoplist(MocaSqlParser.Alter_fulltext_stoplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void enterCreate_fulltext_stoplist(MocaSqlParser.Create_fulltext_stoplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_fulltext_stoplist}.
	 * @param ctx the parse tree
	 */
	void exitCreate_fulltext_stoplist(MocaSqlParser.Create_fulltext_stoplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_login_sql_server}.
	 * @param ctx the parse tree
	 */
	void enterAlter_login_sql_server(MocaSqlParser.Alter_login_sql_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_login_sql_server}.
	 * @param ctx the parse tree
	 */
	void exitAlter_login_sql_server(MocaSqlParser.Alter_login_sql_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_login_sql_server}.
	 * @param ctx the parse tree
	 */
	void enterCreate_login_sql_server(MocaSqlParser.Create_login_sql_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_login_sql_server}.
	 * @param ctx the parse tree
	 */
	void exitCreate_login_sql_server(MocaSqlParser.Create_login_sql_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql}.
	 * @param ctx the parse tree
	 */
	void enterAlter_login_azure_sql(MocaSqlParser.Alter_login_azure_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql}.
	 * @param ctx the parse tree
	 */
	void exitAlter_login_azure_sql(MocaSqlParser.Alter_login_azure_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_login_azure_sql}.
	 * @param ctx the parse tree
	 */
	void enterCreate_login_azure_sql(MocaSqlParser.Create_login_azure_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_login_azure_sql}.
	 * @param ctx the parse tree
	 */
	void exitCreate_login_azure_sql(MocaSqlParser.Create_login_azure_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void enterAlter_login_azure_sql_dw_and_pdw(MocaSqlParser.Alter_login_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_login_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void exitAlter_login_azure_sql_dw_and_pdw(MocaSqlParser.Alter_login_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_login_pdw}.
	 * @param ctx the parse tree
	 */
	void enterCreate_login_pdw(MocaSqlParser.Create_login_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_login_pdw}.
	 * @param ctx the parse tree
	 */
	void exitCreate_login_pdw(MocaSqlParser.Create_login_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_master_key_sql_server}.
	 * @param ctx the parse tree
	 */
	void enterAlter_master_key_sql_server(MocaSqlParser.Alter_master_key_sql_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_master_key_sql_server}.
	 * @param ctx the parse tree
	 */
	void exitAlter_master_key_sql_server(MocaSqlParser.Alter_master_key_sql_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_master_key_sql_server}.
	 * @param ctx the parse tree
	 */
	void enterCreate_master_key_sql_server(MocaSqlParser.Create_master_key_sql_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_master_key_sql_server}.
	 * @param ctx the parse tree
	 */
	void exitCreate_master_key_sql_server(MocaSqlParser.Create_master_key_sql_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_master_key_azure_sql}.
	 * @param ctx the parse tree
	 */
	void enterAlter_master_key_azure_sql(MocaSqlParser.Alter_master_key_azure_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_master_key_azure_sql}.
	 * @param ctx the parse tree
	 */
	void exitAlter_master_key_azure_sql(MocaSqlParser.Alter_master_key_azure_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_master_key_azure_sql}.
	 * @param ctx the parse tree
	 */
	void enterCreate_master_key_azure_sql(MocaSqlParser.Create_master_key_azure_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_master_key_azure_sql}.
	 * @param ctx the parse tree
	 */
	void exitCreate_master_key_azure_sql(MocaSqlParser.Create_master_key_azure_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_message_type}.
	 * @param ctx the parse tree
	 */
	void enterAlter_message_type(MocaSqlParser.Alter_message_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_message_type}.
	 * @param ctx the parse tree
	 */
	void exitAlter_message_type(MocaSqlParser.Alter_message_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_partition_function}.
	 * @param ctx the parse tree
	 */
	void enterAlter_partition_function(MocaSqlParser.Alter_partition_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_partition_function}.
	 * @param ctx the parse tree
	 */
	void exitAlter_partition_function(MocaSqlParser.Alter_partition_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_partition_scheme}.
	 * @param ctx the parse tree
	 */
	void enterAlter_partition_scheme(MocaSqlParser.Alter_partition_schemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_partition_scheme}.
	 * @param ctx the parse tree
	 */
	void exitAlter_partition_scheme(MocaSqlParser.Alter_partition_schemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void enterAlter_remote_service_binding(MocaSqlParser.Alter_remote_service_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void exitAlter_remote_service_binding(MocaSqlParser.Alter_remote_service_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void enterCreate_remote_service_binding(MocaSqlParser.Create_remote_service_bindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_remote_service_binding}.
	 * @param ctx the parse tree
	 */
	void exitCreate_remote_service_binding(MocaSqlParser.Create_remote_service_bindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_resource_pool}.
	 * @param ctx the parse tree
	 */
	void enterCreate_resource_pool(MocaSqlParser.Create_resource_poolContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_resource_pool}.
	 * @param ctx the parse tree
	 */
	void exitCreate_resource_pool(MocaSqlParser.Create_resource_poolContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_resource_governor}.
	 * @param ctx the parse tree
	 */
	void enterAlter_resource_governor(MocaSqlParser.Alter_resource_governorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_resource_governor}.
	 * @param ctx the parse tree
	 */
	void exitAlter_resource_governor(MocaSqlParser.Alter_resource_governorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_db_role}.
	 * @param ctx the parse tree
	 */
	void enterAlter_db_role(MocaSqlParser.Alter_db_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_db_role}.
	 * @param ctx the parse tree
	 */
	void exitAlter_db_role(MocaSqlParser.Alter_db_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_db_role}.
	 * @param ctx the parse tree
	 */
	void enterCreate_db_role(MocaSqlParser.Create_db_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_db_role}.
	 * @param ctx the parse tree
	 */
	void exitCreate_db_role(MocaSqlParser.Create_db_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_route}.
	 * @param ctx the parse tree
	 */
	void enterCreate_route(MocaSqlParser.Create_routeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_route}.
	 * @param ctx the parse tree
	 */
	void exitCreate_route(MocaSqlParser.Create_routeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_rule}.
	 * @param ctx the parse tree
	 */
	void enterCreate_rule(MocaSqlParser.Create_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_rule}.
	 * @param ctx the parse tree
	 */
	void exitCreate_rule(MocaSqlParser.Create_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_schema_sql}.
	 * @param ctx the parse tree
	 */
	void enterAlter_schema_sql(MocaSqlParser.Alter_schema_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_schema_sql}.
	 * @param ctx the parse tree
	 */
	void exitAlter_schema_sql(MocaSqlParser.Alter_schema_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_schema}.
	 * @param ctx the parse tree
	 */
	void enterCreate_schema(MocaSqlParser.Create_schemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_schema}.
	 * @param ctx the parse tree
	 */
	void exitCreate_schema(MocaSqlParser.Create_schemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void enterCreate_schema_azure_sql_dw_and_pdw(MocaSqlParser.Create_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void exitCreate_schema_azure_sql_dw_and_pdw(MocaSqlParser.Create_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void enterAlter_schema_azure_sql_dw_and_pdw(MocaSqlParser.Alter_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_schema_azure_sql_dw_and_pdw}.
	 * @param ctx the parse tree
	 */
	void exitAlter_schema_azure_sql_dw_and_pdw(MocaSqlParser.Alter_schema_azure_sql_dw_and_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_search_property_list}.
	 * @param ctx the parse tree
	 */
	void enterCreate_search_property_list(MocaSqlParser.Create_search_property_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_search_property_list}.
	 * @param ctx the parse tree
	 */
	void exitCreate_search_property_list(MocaSqlParser.Create_search_property_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_security_policy}.
	 * @param ctx the parse tree
	 */
	void enterCreate_security_policy(MocaSqlParser.Create_security_policyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_security_policy}.
	 * @param ctx the parse tree
	 */
	void exitCreate_security_policy(MocaSqlParser.Create_security_policyContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_server_audit}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server_audit(MocaSqlParser.Alter_server_auditContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_server_audit}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server_audit(MocaSqlParser.Alter_server_auditContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_server_audit}.
	 * @param ctx the parse tree
	 */
	void enterCreate_server_audit(MocaSqlParser.Create_server_auditContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_server_audit}.
	 * @param ctx the parse tree
	 */
	void exitCreate_server_audit(MocaSqlParser.Create_server_auditContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server_audit_specification(MocaSqlParser.Alter_server_audit_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server_audit_specification(MocaSqlParser.Alter_server_audit_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void enterCreate_server_audit_specification(MocaSqlParser.Create_server_audit_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_server_audit_specification}.
	 * @param ctx the parse tree
	 */
	void exitCreate_server_audit_specification(MocaSqlParser.Create_server_audit_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_server_configuration}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server_configuration(MocaSqlParser.Alter_server_configurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_server_configuration}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server_configuration(MocaSqlParser.Alter_server_configurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_server_role}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server_role(MocaSqlParser.Alter_server_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_server_role}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server_role(MocaSqlParser.Alter_server_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_server_role}.
	 * @param ctx the parse tree
	 */
	void enterCreate_server_role(MocaSqlParser.Create_server_roleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_server_role}.
	 * @param ctx the parse tree
	 */
	void exitCreate_server_role(MocaSqlParser.Create_server_roleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_server_role_pdw}.
	 * @param ctx the parse tree
	 */
	void enterAlter_server_role_pdw(MocaSqlParser.Alter_server_role_pdwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_server_role_pdw}.
	 * @param ctx the parse tree
	 */
	void exitAlter_server_role_pdw(MocaSqlParser.Alter_server_role_pdwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_service}.
	 * @param ctx the parse tree
	 */
	void enterAlter_service(MocaSqlParser.Alter_serviceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_service}.
	 * @param ctx the parse tree
	 */
	void exitAlter_service(MocaSqlParser.Alter_serviceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_service}.
	 * @param ctx the parse tree
	 */
	void enterCreate_service(MocaSqlParser.Create_serviceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_service}.
	 * @param ctx the parse tree
	 */
	void exitCreate_service(MocaSqlParser.Create_serviceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_service_master_key}.
	 * @param ctx the parse tree
	 */
	void enterAlter_service_master_key(MocaSqlParser.Alter_service_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_service_master_key}.
	 * @param ctx the parse tree
	 */
	void exitAlter_service_master_key(MocaSqlParser.Alter_service_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterAlter_symmetric_key(MocaSqlParser.Alter_symmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitAlter_symmetric_key(MocaSqlParser.Alter_symmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void enterCreate_symmetric_key(MocaSqlParser.Create_symmetric_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_symmetric_key}.
	 * @param ctx the parse tree
	 */
	void exitCreate_symmetric_key(MocaSqlParser.Create_symmetric_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_synonym}.
	 * @param ctx the parse tree
	 */
	void enterCreate_synonym(MocaSqlParser.Create_synonymContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_synonym}.
	 * @param ctx the parse tree
	 */
	void exitCreate_synonym(MocaSqlParser.Create_synonymContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void enterAlter_user(MocaSqlParser.Alter_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_user}.
	 * @param ctx the parse tree
	 */
	void exitAlter_user(MocaSqlParser.Alter_userContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void enterCreate_user(MocaSqlParser.Create_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_user}.
	 * @param ctx the parse tree
	 */
	void exitCreate_user(MocaSqlParser.Create_userContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_user_azure_sql_dw}.
	 * @param ctx the parse tree
	 */
	void enterCreate_user_azure_sql_dw(MocaSqlParser.Create_user_azure_sql_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_user_azure_sql_dw}.
	 * @param ctx the parse tree
	 */
	void exitCreate_user_azure_sql_dw(MocaSqlParser.Create_user_azure_sql_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_user_azure_sql}.
	 * @param ctx the parse tree
	 */
	void enterAlter_user_azure_sql(MocaSqlParser.Alter_user_azure_sqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_user_azure_sql}.
	 * @param ctx the parse tree
	 */
	void exitAlter_user_azure_sql(MocaSqlParser.Alter_user_azure_sqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_workload_group}.
	 * @param ctx the parse tree
	 */
	void enterAlter_workload_group(MocaSqlParser.Alter_workload_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_workload_group}.
	 * @param ctx the parse tree
	 */
	void exitAlter_workload_group(MocaSqlParser.Alter_workload_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_workload_group}.
	 * @param ctx the parse tree
	 */
	void enterCreate_workload_group(MocaSqlParser.Create_workload_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_workload_group}.
	 * @param ctx the parse tree
	 */
	void exitCreate_workload_group(MocaSqlParser.Create_workload_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void enterCreate_xml_schema_collection(MocaSqlParser.Create_xml_schema_collectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void exitCreate_xml_schema_collection(MocaSqlParser.Create_xml_schema_collectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_queue}.
	 * @param ctx the parse tree
	 */
	void enterCreate_queue(MocaSqlParser.Create_queueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_queue}.
	 * @param ctx the parse tree
	 */
	void exitCreate_queue(MocaSqlParser.Create_queueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#queue_settings}.
	 * @param ctx the parse tree
	 */
	void enterQueue_settings(MocaSqlParser.Queue_settingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#queue_settings}.
	 * @param ctx the parse tree
	 */
	void exitQueue_settings(MocaSqlParser.Queue_settingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_queue}.
	 * @param ctx the parse tree
	 */
	void enterAlter_queue(MocaSqlParser.Alter_queueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_queue}.
	 * @param ctx the parse tree
	 */
	void exitAlter_queue(MocaSqlParser.Alter_queueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#queue_action}.
	 * @param ctx the parse tree
	 */
	void enterQueue_action(MocaSqlParser.Queue_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#queue_action}.
	 * @param ctx the parse tree
	 */
	void exitQueue_action(MocaSqlParser.Queue_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#queue_rebuild_options}.
	 * @param ctx the parse tree
	 */
	void enterQueue_rebuild_options(MocaSqlParser.Queue_rebuild_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#queue_rebuild_options}.
	 * @param ctx the parse tree
	 */
	void exitQueue_rebuild_options(MocaSqlParser.Queue_rebuild_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_contract}.
	 * @param ctx the parse tree
	 */
	void enterCreate_contract(MocaSqlParser.Create_contractContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_contract}.
	 * @param ctx the parse tree
	 */
	void exitCreate_contract(MocaSqlParser.Create_contractContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#conversation_statement}.
	 * @param ctx the parse tree
	 */
	void enterConversation_statement(MocaSqlParser.Conversation_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#conversation_statement}.
	 * @param ctx the parse tree
	 */
	void exitConversation_statement(MocaSqlParser.Conversation_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#message_statement}.
	 * @param ctx the parse tree
	 */
	void enterMessage_statement(MocaSqlParser.Message_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#message_statement}.
	 * @param ctx the parse tree
	 */
	void exitMessage_statement(MocaSqlParser.Message_statementContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#receive_statement}.
	 * @param ctx the parse tree
	 */
	void enterReceive_statement(MocaSqlParser.Receive_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#receive_statement}.
	 * @param ctx the parse tree
	 */
	void exitReceive_statement(MocaSqlParser.Receive_statementContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(MocaSqlParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(MocaSqlParser.TimeContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database(MocaSqlParser.Create_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_database}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database(MocaSqlParser.Create_databaseContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_procedure}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_procedure(MocaSqlParser.Create_or_alter_procedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_procedure}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_procedure(MocaSqlParser.Create_or_alter_procedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_trigger}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_trigger(MocaSqlParser.Create_or_alter_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_trigger}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_trigger(MocaSqlParser.Create_or_alter_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_dml_trigger}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_dml_trigger(MocaSqlParser.Create_or_alter_dml_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_dml_trigger}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_dml_trigger(MocaSqlParser.Create_or_alter_dml_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#dml_trigger_option}.
	 * @param ctx the parse tree
	 */
	void enterDml_trigger_option(MocaSqlParser.Dml_trigger_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#dml_trigger_option}.
	 * @param ctx the parse tree
	 */
	void exitDml_trigger_option(MocaSqlParser.Dml_trigger_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#dml_trigger_operation}.
	 * @param ctx the parse tree
	 */
	void enterDml_trigger_operation(MocaSqlParser.Dml_trigger_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#dml_trigger_operation}.
	 * @param ctx the parse tree
	 */
	void exitDml_trigger_operation(MocaSqlParser.Dml_trigger_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_ddl_trigger}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_ddl_trigger(MocaSqlParser.Create_or_alter_ddl_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_ddl_trigger}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_ddl_trigger(MocaSqlParser.Create_or_alter_ddl_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#ddl_trigger_operation}.
	 * @param ctx the parse tree
	 */
	void enterDdl_trigger_operation(MocaSqlParser.Ddl_trigger_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#ddl_trigger_operation}.
	 * @param ctx the parse tree
	 */
	void exitDdl_trigger_operation(MocaSqlParser.Ddl_trigger_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_or_alter_function}.
	 * @param ctx the parse tree
	 */
	void enterCreate_or_alter_function(MocaSqlParser.Create_or_alter_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_or_alter_function}.
	 * @param ctx the parse tree
	 */
	void exitCreate_or_alter_function(MocaSqlParser.Create_or_alter_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_body_returns_select}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body_returns_select(MocaSqlParser.Func_body_returns_selectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_body_returns_select}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body_returns_select(MocaSqlParser.Func_body_returns_selectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_body_returns_table}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body_returns_table(MocaSqlParser.Func_body_returns_tableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_body_returns_table}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body_returns_table(MocaSqlParser.Func_body_returns_tableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#func_body_returns_scalar}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body_returns_scalar(MocaSqlParser.Func_body_returns_scalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#func_body_returns_scalar}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body_returns_scalar(MocaSqlParser.Func_body_returns_scalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#procedure_param}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_param(MocaSqlParser.Procedure_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#procedure_param}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_param(MocaSqlParser.Procedure_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#procedure_option}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_option(MocaSqlParser.Procedure_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#procedure_option}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_option(MocaSqlParser.Procedure_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#function_option}.
	 * @param ctx the parse tree
	 */
	void enterFunction_option(MocaSqlParser.Function_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#function_option}.
	 * @param ctx the parse tree
	 */
	void exitFunction_option(MocaSqlParser.Function_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_statistics}.
	 * @param ctx the parse tree
	 */
	void enterCreate_statistics(MocaSqlParser.Create_statisticsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_statistics}.
	 * @param ctx the parse tree
	 */
	void exitCreate_statistics(MocaSqlParser.Create_statisticsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#update_statistics}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_statistics(MocaSqlParser.Update_statisticsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#update_statistics}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_statistics(MocaSqlParser.Update_statisticsContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void enterAlter_database(MocaSqlParser.Alter_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_database}.
	 * @param ctx the parse tree
	 */
	void exitAlter_database(MocaSqlParser.Alter_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#database_optionspec}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_optionspec(MocaSqlParser.Database_optionspecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#database_optionspec}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_optionspec(MocaSqlParser.Database_optionspecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#auto_option}.
	 * @param ctx the parse tree
	 */
	void enterAuto_option(MocaSqlParser.Auto_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#auto_option}.
	 * @param ctx the parse tree
	 */
	void exitAuto_option(MocaSqlParser.Auto_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#change_tracking_option}.
	 * @param ctx the parse tree
	 */
	void enterChange_tracking_option(MocaSqlParser.Change_tracking_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#change_tracking_option}.
	 * @param ctx the parse tree
	 */
	void exitChange_tracking_option(MocaSqlParser.Change_tracking_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#change_tracking_option_list}.
	 * @param ctx the parse tree
	 */
	void enterChange_tracking_option_list(MocaSqlParser.Change_tracking_option_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#change_tracking_option_list}.
	 * @param ctx the parse tree
	 */
	void exitChange_tracking_option_list(MocaSqlParser.Change_tracking_option_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#containment_option}.
	 * @param ctx the parse tree
	 */
	void enterContainment_option(MocaSqlParser.Containment_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#containment_option}.
	 * @param ctx the parse tree
	 */
	void exitContainment_option(MocaSqlParser.Containment_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#cursor_option}.
	 * @param ctx the parse tree
	 */
	void enterCursor_option(MocaSqlParser.Cursor_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#cursor_option}.
	 * @param ctx the parse tree
	 */
	void exitCursor_option(MocaSqlParser.Cursor_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#alter_endpoint}.
	 * @param ctx the parse tree
	 */
	void enterAlter_endpoint(MocaSqlParser.Alter_endpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#alter_endpoint}.
	 * @param ctx the parse tree
	 */
	void exitAlter_endpoint(MocaSqlParser.Alter_endpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#database_mirroring_option}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_mirroring_option(MocaSqlParser.Database_mirroring_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#database_mirroring_option}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_mirroring_option(MocaSqlParser.Database_mirroring_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#mirroring_set_option}.
	 * @param ctx the parse tree
	 */
	void enterMirroring_set_option(MocaSqlParser.Mirroring_set_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#mirroring_set_option}.
	 * @param ctx the parse tree
	 */
	void exitMirroring_set_option(MocaSqlParser.Mirroring_set_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#mirroring_partner}.
	 * @param ctx the parse tree
	 */
	void enterMirroring_partner(MocaSqlParser.Mirroring_partnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#mirroring_partner}.
	 * @param ctx the parse tree
	 */
	void exitMirroring_partner(MocaSqlParser.Mirroring_partnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#mirroring_witness}.
	 * @param ctx the parse tree
	 */
	void enterMirroring_witness(MocaSqlParser.Mirroring_witnessContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#mirroring_witness}.
	 * @param ctx the parse tree
	 */
	void exitMirroring_witness(MocaSqlParser.Mirroring_witnessContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#witness_partner_equal}.
	 * @param ctx the parse tree
	 */
	void enterWitness_partner_equal(MocaSqlParser.Witness_partner_equalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#witness_partner_equal}.
	 * @param ctx the parse tree
	 */
	void exitWitness_partner_equal(MocaSqlParser.Witness_partner_equalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#partner_option}.
	 * @param ctx the parse tree
	 */
	void enterPartner_option(MocaSqlParser.Partner_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#partner_option}.
	 * @param ctx the parse tree
	 */
	void exitPartner_option(MocaSqlParser.Partner_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#witness_option}.
	 * @param ctx the parse tree
	 */
	void enterWitness_option(MocaSqlParser.Witness_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#witness_option}.
	 * @param ctx the parse tree
	 */
	void exitWitness_option(MocaSqlParser.Witness_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#witness_server}.
	 * @param ctx the parse tree
	 */
	void enterWitness_server(MocaSqlParser.Witness_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#witness_server}.
	 * @param ctx the parse tree
	 */
	void exitWitness_server(MocaSqlParser.Witness_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#partner_server}.
	 * @param ctx the parse tree
	 */
	void enterPartner_server(MocaSqlParser.Partner_serverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#partner_server}.
	 * @param ctx the parse tree
	 */
	void exitPartner_server(MocaSqlParser.Partner_serverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#mirroring_host_port_seperator}.
	 * @param ctx the parse tree
	 */
	void enterMirroring_host_port_seperator(MocaSqlParser.Mirroring_host_port_seperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#mirroring_host_port_seperator}.
	 * @param ctx the parse tree
	 */
	void exitMirroring_host_port_seperator(MocaSqlParser.Mirroring_host_port_seperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#partner_server_tcp_prefix}.
	 * @param ctx the parse tree
	 */
	void enterPartner_server_tcp_prefix(MocaSqlParser.Partner_server_tcp_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#partner_server_tcp_prefix}.
	 * @param ctx the parse tree
	 */
	void exitPartner_server_tcp_prefix(MocaSqlParser.Partner_server_tcp_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#port_number}.
	 * @param ctx the parse tree
	 */
	void enterPort_number(MocaSqlParser.Port_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#port_number}.
	 * @param ctx the parse tree
	 */
	void exitPort_number(MocaSqlParser.Port_numberContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#date_correlation_optimization_option}.
	 * @param ctx the parse tree
	 */
	void enterDate_correlation_optimization_option(MocaSqlParser.Date_correlation_optimization_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#date_correlation_optimization_option}.
	 * @param ctx the parse tree
	 */
	void exitDate_correlation_optimization_option(MocaSqlParser.Date_correlation_optimization_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#db_encryption_option}.
	 * @param ctx the parse tree
	 */
	void enterDb_encryption_option(MocaSqlParser.Db_encryption_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#db_encryption_option}.
	 * @param ctx the parse tree
	 */
	void exitDb_encryption_option(MocaSqlParser.Db_encryption_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#db_state_option}.
	 * @param ctx the parse tree
	 */
	void enterDb_state_option(MocaSqlParser.Db_state_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#db_state_option}.
	 * @param ctx the parse tree
	 */
	void exitDb_state_option(MocaSqlParser.Db_state_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#db_update_option}.
	 * @param ctx the parse tree
	 */
	void enterDb_update_option(MocaSqlParser.Db_update_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#db_update_option}.
	 * @param ctx the parse tree
	 */
	void exitDb_update_option(MocaSqlParser.Db_update_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#db_user_access_option}.
	 * @param ctx the parse tree
	 */
	void enterDb_user_access_option(MocaSqlParser.Db_user_access_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#db_user_access_option}.
	 * @param ctx the parse tree
	 */
	void exitDb_user_access_option(MocaSqlParser.Db_user_access_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#delayed_durability_option}.
	 * @param ctx the parse tree
	 */
	void enterDelayed_durability_option(MocaSqlParser.Delayed_durability_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#delayed_durability_option}.
	 * @param ctx the parse tree
	 */
	void exitDelayed_durability_option(MocaSqlParser.Delayed_durability_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#external_access_option}.
	 * @param ctx the parse tree
	 */
	void enterExternal_access_option(MocaSqlParser.External_access_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#external_access_option}.
	 * @param ctx the parse tree
	 */
	void exitExternal_access_option(MocaSqlParser.External_access_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#hadr_options}.
	 * @param ctx the parse tree
	 */
	void enterHadr_options(MocaSqlParser.Hadr_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#hadr_options}.
	 * @param ctx the parse tree
	 */
	void exitHadr_options(MocaSqlParser.Hadr_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#mixed_page_allocation_option}.
	 * @param ctx the parse tree
	 */
	void enterMixed_page_allocation_option(MocaSqlParser.Mixed_page_allocation_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#mixed_page_allocation_option}.
	 * @param ctx the parse tree
	 */
	void exitMixed_page_allocation_option(MocaSqlParser.Mixed_page_allocation_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#parameterization_option}.
	 * @param ctx the parse tree
	 */
	void enterParameterization_option(MocaSqlParser.Parameterization_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#parameterization_option}.
	 * @param ctx the parse tree
	 */
	void exitParameterization_option(MocaSqlParser.Parameterization_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#recovery_option}.
	 * @param ctx the parse tree
	 */
	void enterRecovery_option(MocaSqlParser.Recovery_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#recovery_option}.
	 * @param ctx the parse tree
	 */
	void exitRecovery_option(MocaSqlParser.Recovery_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#service_broker_option}.
	 * @param ctx the parse tree
	 */
	void enterService_broker_option(MocaSqlParser.Service_broker_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#service_broker_option}.
	 * @param ctx the parse tree
	 */
	void exitService_broker_option(MocaSqlParser.Service_broker_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#snapshot_option}.
	 * @param ctx the parse tree
	 */
	void enterSnapshot_option(MocaSqlParser.Snapshot_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#snapshot_option}.
	 * @param ctx the parse tree
	 */
	void exitSnapshot_option(MocaSqlParser.Snapshot_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#sql_option}.
	 * @param ctx the parse tree
	 */
	void enterSql_option(MocaSqlParser.Sql_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#sql_option}.
	 * @param ctx the parse tree
	 */
	void exitSql_option(MocaSqlParser.Sql_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#target_recovery_time_option}.
	 * @param ctx the parse tree
	 */
	void enterTarget_recovery_time_option(MocaSqlParser.Target_recovery_time_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#target_recovery_time_option}.
	 * @param ctx the parse tree
	 */
	void exitTarget_recovery_time_option(MocaSqlParser.Target_recovery_time_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#termination}.
	 * @param ctx the parse tree
	 */
	void enterTermination(MocaSqlParser.TerminationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#termination}.
	 * @param ctx the parse tree
	 */
	void exitTermination(MocaSqlParser.TerminationContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 */
	void enterDrop_procedure(MocaSqlParser.Drop_procedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_procedure}.
	 * @param ctx the parse tree
	 */
	void exitDrop_procedure(MocaSqlParser.Drop_procedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDrop_trigger(MocaSqlParser.Drop_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDrop_trigger(MocaSqlParser.Drop_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_dml_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDrop_dml_trigger(MocaSqlParser.Drop_dml_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_dml_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDrop_dml_trigger(MocaSqlParser.Drop_dml_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_ddl_trigger}.
	 * @param ctx the parse tree
	 */
	void enterDrop_ddl_trigger(MocaSqlParser.Drop_ddl_triggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_ddl_trigger}.
	 * @param ctx the parse tree
	 */
	void exitDrop_ddl_trigger(MocaSqlParser.Drop_ddl_triggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_function}.
	 * @param ctx the parse tree
	 */
	void enterDrop_function(MocaSqlParser.Drop_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_function}.
	 * @param ctx the parse tree
	 */
	void exitDrop_function(MocaSqlParser.Drop_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_statistics}.
	 * @param ctx the parse tree
	 */
	void enterDrop_statistics(MocaSqlParser.Drop_statisticsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_statistics}.
	 * @param ctx the parse tree
	 */
	void exitDrop_statistics(MocaSqlParser.Drop_statisticsContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#create_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_type(MocaSqlParser.Create_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_type(MocaSqlParser.Create_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#drop_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_type(MocaSqlParser.Drop_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#drop_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_type(MocaSqlParser.Drop_typeContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_statement(MocaSqlParser.Declare_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#declare_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_statement(MocaSqlParser.Declare_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 */
	void enterCursor_statement(MocaSqlParser.Cursor_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#cursor_statement}.
	 * @param ctx the parse tree
	 */
	void exitCursor_statement(MocaSqlParser.Cursor_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_database}.
	 * @param ctx the parse tree
	 */
	void enterBackup_database(MocaSqlParser.Backup_databaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_database}.
	 * @param ctx the parse tree
	 */
	void exitBackup_database(MocaSqlParser.Backup_databaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_log}.
	 * @param ctx the parse tree
	 */
	void enterBackup_log(MocaSqlParser.Backup_logContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_log}.
	 * @param ctx the parse tree
	 */
	void exitBackup_log(MocaSqlParser.Backup_logContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_certificate}.
	 * @param ctx the parse tree
	 */
	void enterBackup_certificate(MocaSqlParser.Backup_certificateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_certificate}.
	 * @param ctx the parse tree
	 */
	void exitBackup_certificate(MocaSqlParser.Backup_certificateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_master_key}.
	 * @param ctx the parse tree
	 */
	void enterBackup_master_key(MocaSqlParser.Backup_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_master_key}.
	 * @param ctx the parse tree
	 */
	void exitBackup_master_key(MocaSqlParser.Backup_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#backup_service_master_key}.
	 * @param ctx the parse tree
	 */
	void enterBackup_service_master_key(MocaSqlParser.Backup_service_master_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#backup_service_master_key}.
	 * @param ctx the parse tree
	 */
	void exitBackup_service_master_key(MocaSqlParser.Backup_service_master_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#kill_statement}.
	 * @param ctx the parse tree
	 */
	void enterKill_statement(MocaSqlParser.Kill_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#kill_statement}.
	 * @param ctx the parse tree
	 */
	void exitKill_statement(MocaSqlParser.Kill_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#kill_process}.
	 * @param ctx the parse tree
	 */
	void enterKill_process(MocaSqlParser.Kill_processContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#kill_process}.
	 * @param ctx the parse tree
	 */
	void exitKill_process(MocaSqlParser.Kill_processContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#kill_query_notification}.
	 * @param ctx the parse tree
	 */
	void enterKill_query_notification(MocaSqlParser.Kill_query_notificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#kill_query_notification}.
	 * @param ctx the parse tree
	 */
	void exitKill_query_notification(MocaSqlParser.Kill_query_notificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#kill_stats_job}.
	 * @param ctx the parse tree
	 */
	void enterKill_stats_job(MocaSqlParser.Kill_stats_jobContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#kill_stats_job}.
	 * @param ctx the parse tree
	 */
	void exitKill_stats_job(MocaSqlParser.Kill_stats_jobContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#security_statement}.
	 * @param ctx the parse tree
	 */
	void enterSecurity_statement(MocaSqlParser.Security_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#security_statement}.
	 * @param ctx the parse tree
	 */
	void exitSecurity_statement(MocaSqlParser.Security_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_certificate}.
	 * @param ctx the parse tree
	 */
	void enterCreate_certificate(MocaSqlParser.Create_certificateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_certificate}.
	 * @param ctx the parse tree
	 */
	void exitCreate_certificate(MocaSqlParser.Create_certificateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#existing_keys}.
	 * @param ctx the parse tree
	 */
	void enterExisting_keys(MocaSqlParser.Existing_keysContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#existing_keys}.
	 * @param ctx the parse tree
	 */
	void exitExisting_keys(MocaSqlParser.Existing_keysContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#private_key_options}.
	 * @param ctx the parse tree
	 */
	void enterPrivate_key_options(MocaSqlParser.Private_key_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#private_key_options}.
	 * @param ctx the parse tree
	 */
	void exitPrivate_key_options(MocaSqlParser.Private_key_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#generate_new_keys}.
	 * @param ctx the parse tree
	 */
	void enterGenerate_new_keys(MocaSqlParser.Generate_new_keysContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#generate_new_keys}.
	 * @param ctx the parse tree
	 */
	void exitGenerate_new_keys(MocaSqlParser.Generate_new_keysContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#date_options}.
	 * @param ctx the parse tree
	 */
	void enterDate_options(MocaSqlParser.Date_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#date_options}.
	 * @param ctx the parse tree
	 */
	void exitDate_options(MocaSqlParser.Date_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#open_key}.
	 * @param ctx the parse tree
	 */
	void enterOpen_key(MocaSqlParser.Open_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#open_key}.
	 * @param ctx the parse tree
	 */
	void exitOpen_key(MocaSqlParser.Open_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#close_key}.
	 * @param ctx the parse tree
	 */
	void enterClose_key(MocaSqlParser.Close_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#close_key}.
	 * @param ctx the parse tree
	 */
	void exitClose_key(MocaSqlParser.Close_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#create_key}.
	 * @param ctx the parse tree
	 */
	void enterCreate_key(MocaSqlParser.Create_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_key}.
	 * @param ctx the parse tree
	 */
	void exitCreate_key(MocaSqlParser.Create_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#key_options}.
	 * @param ctx the parse tree
	 */
	void enterKey_options(MocaSqlParser.Key_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#key_options}.
	 * @param ctx the parse tree
	 */
	void exitKey_options(MocaSqlParser.Key_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#algorithm}.
	 * @param ctx the parse tree
	 */
	void enterAlgorithm(MocaSqlParser.AlgorithmContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#algorithm}.
	 * @param ctx the parse tree
	 */
	void exitAlgorithm(MocaSqlParser.AlgorithmContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#encryption_mechanism}.
	 * @param ctx the parse tree
	 */
	void enterEncryption_mechanism(MocaSqlParser.Encryption_mechanismContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#encryption_mechanism}.
	 * @param ctx the parse tree
	 */
	void exitEncryption_mechanism(MocaSqlParser.Encryption_mechanismContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#decryption_mechanism}.
	 * @param ctx the parse tree
	 */
	void enterDecryption_mechanism(MocaSqlParser.Decryption_mechanismContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#decryption_mechanism}.
	 * @param ctx the parse tree
	 */
	void exitDecryption_mechanism(MocaSqlParser.Decryption_mechanismContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#grant_permission}.
	 * @param ctx the parse tree
	 */
	void enterGrant_permission(MocaSqlParser.Grant_permissionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#grant_permission}.
	 * @param ctx the parse tree
	 */
	void exitGrant_permission(MocaSqlParser.Grant_permissionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_statement(MocaSqlParser.Set_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#set_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_statement(MocaSqlParser.Set_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 */
	void enterTransaction_statement(MocaSqlParser.Transaction_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#transaction_statement}.
	 * @param ctx the parse tree
	 */
	void exitTransaction_statement(MocaSqlParser.Transaction_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#go_statement}.
	 * @param ctx the parse tree
	 */
	void enterGo_statement(MocaSqlParser.Go_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#go_statement}.
	 * @param ctx the parse tree
	 */
	void exitGo_statement(MocaSqlParser.Go_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_statement(MocaSqlParser.Use_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#use_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_statement(MocaSqlParser.Use_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#setuser_statement}.
	 * @param ctx the parse tree
	 */
	void enterSetuser_statement(MocaSqlParser.Setuser_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#setuser_statement}.
	 * @param ctx the parse tree
	 */
	void exitSetuser_statement(MocaSqlParser.Setuser_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#reconfigure_statement}.
	 * @param ctx the parse tree
	 */
	void enterReconfigure_statement(MocaSqlParser.Reconfigure_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#reconfigure_statement}.
	 * @param ctx the parse tree
	 */
	void exitReconfigure_statement(MocaSqlParser.Reconfigure_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 */
	void enterShutdown_statement(MocaSqlParser.Shutdown_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#shutdown_statement}.
	 * @param ctx the parse tree
	 */
	void exitShutdown_statement(MocaSqlParser.Shutdown_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#dbcc_clause}.
	 * @param ctx the parse tree
	 */
	void enterDbcc_clause(MocaSqlParser.Dbcc_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#dbcc_clause}.
	 * @param ctx the parse tree
	 */
	void exitDbcc_clause(MocaSqlParser.Dbcc_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#dbcc_options}.
	 * @param ctx the parse tree
	 */
	void enterDbcc_options(MocaSqlParser.Dbcc_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#dbcc_options}.
	 * @param ctx the parse tree
	 */
	void exitDbcc_options(MocaSqlParser.Dbcc_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#execute_clause}.
	 * @param ctx the parse tree
	 */
	void enterExecute_clause(MocaSqlParser.Execute_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#execute_clause}.
	 * @param ctx the parse tree
	 */
	void exitExecute_clause(MocaSqlParser.Execute_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#declare_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_local(MocaSqlParser.Declare_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#declare_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_local(MocaSqlParser.Declare_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#table_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterTable_type_definition(MocaSqlParser.Table_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#table_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitTable_type_definition(MocaSqlParser.Table_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#xml_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterXml_type_definition(MocaSqlParser.Xml_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#xml_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitXml_type_definition(MocaSqlParser.Xml_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void enterXml_schema_collection(MocaSqlParser.Xml_schema_collectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#xml_schema_collection}.
	 * @param ctx the parse tree
	 */
	void exitXml_schema_collection(MocaSqlParser.Xml_schema_collectionContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_cursor(MocaSqlParser.Declare_cursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#declare_cursor}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_cursor(MocaSqlParser.Declare_cursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_set_cursor_common(MocaSqlParser.Declare_set_cursor_commonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_set_cursor_common(MocaSqlParser.Declare_set_cursor_commonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common_partial}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_set_cursor_common_partial(MocaSqlParser.Declare_set_cursor_common_partialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#declare_set_cursor_common_partial}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_set_cursor_common_partial(MocaSqlParser.Declare_set_cursor_common_partialContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#fetch_cursor}.
	 * @param ctx the parse tree
	 */
	void enterFetch_cursor(MocaSqlParser.Fetch_cursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#fetch_cursor}.
	 * @param ctx the parse tree
	 */
	void exitFetch_cursor(MocaSqlParser.Fetch_cursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#set_special}.
	 * @param ctx the parse tree
	 */
	void enterSet_special(MocaSqlParser.Set_specialContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#set_special}.
	 * @param ctx the parse tree
	 */
	void exitSet_special(MocaSqlParser.Set_specialContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_variables}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_variables(MocaSqlParser.Moca_at_variablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_variables}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_variables(MocaSqlParser.Moca_at_variablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_variables}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_variables(MocaSqlParser.Moca_at_plus_variablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_variables}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_variables(MocaSqlParser.Moca_at_plus_variablesContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_mod_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_variable(MocaSqlParser.Moca_at_mod_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_mod_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_variable(MocaSqlParser.Moca_at_mod_variableContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_keep_directives}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_keep_directives(MocaSqlParser.Moca_at_keep_directivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_keep_directives}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_keep_directives(MocaSqlParser.Moca_at_keep_directivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_keep_directive(MocaSqlParser.Moca_at_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_keep_directive(MocaSqlParser.Moca_at_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_minus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_minus_keep_directive(MocaSqlParser.Moca_at_minus_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_minus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_minus_keep_directive(MocaSqlParser.Moca_at_minus_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_keep_directive(MocaSqlParser.Moca_at_plus_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_keep_directive(MocaSqlParser.Moca_at_plus_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_mod_keep_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_keep_directive(MocaSqlParser.Moca_at_mod_keep_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_mod_keep_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_keep_directive(MocaSqlParser.Moca_at_mod_keep_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_onstack_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_onstack_directive(MocaSqlParser.Moca_at_onstack_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_onstack_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_onstack_directive(MocaSqlParser.Moca_at_onstack_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_ignore_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_ignore_directive(MocaSqlParser.Moca_at_ignore_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_ignore_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_ignore_directive(MocaSqlParser.Moca_at_ignore_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_oldvar_directives}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_oldvar_directives(MocaSqlParser.Moca_at_oldvar_directivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_oldvar_directives}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_oldvar_directives(MocaSqlParser.Moca_at_oldvar_directivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_oldvar_directive(MocaSqlParser.Moca_at_plus_oldvar_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_oldvar_directive(MocaSqlParser.Moca_at_plus_oldvar_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_mod_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_oldvar_directive(MocaSqlParser.Moca_at_mod_oldvar_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_mod_oldvar_directive}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_oldvar_directive(MocaSqlParser.Moca_at_mod_oldvar_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_type_cast_variable(MocaSqlParser.Moca_at_type_cast_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_type_cast_variable(MocaSqlParser.Moca_at_type_cast_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_type_cast_variable(MocaSqlParser.Moca_at_plus_type_cast_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_type_cast_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_type_cast_variable(MocaSqlParser.Moca_at_plus_type_cast_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_plus_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_plus_database_qualifier_variable(MocaSqlParser.Moca_at_plus_database_qualifier_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_plus_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_plus_database_qualifier_variable(MocaSqlParser.Moca_at_plus_database_qualifier_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#moca_at_mod_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void enterMoca_at_mod_database_qualifier_variable(MocaSqlParser.Moca_at_mod_database_qualifier_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#moca_at_mod_database_qualifier_variable}.
	 * @param ctx the parse tree
	 */
	void exitMoca_at_mod_database_qualifier_variable(MocaSqlParser.Moca_at_mod_database_qualifier_variableContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#create_database_option}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database_option(MocaSqlParser.Create_database_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#create_database_option}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database_option(MocaSqlParser.Create_database_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#database_filestream_option}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_filestream_option(MocaSqlParser.Database_filestream_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#database_filestream_option}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_filestream_option(MocaSqlParser.Database_filestream_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#database_file_spec}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_file_spec(MocaSqlParser.Database_file_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#database_file_spec}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_file_spec(MocaSqlParser.Database_file_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#file_group}.
	 * @param ctx the parse tree
	 */
	void enterFile_group(MocaSqlParser.File_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#file_group}.
	 * @param ctx the parse tree
	 */
	void exitFile_group(MocaSqlParser.File_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#file_spec}.
	 * @param ctx the parse tree
	 */
	void enterFile_spec(MocaSqlParser.File_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#file_spec}.
	 * @param ctx the parse tree
	 */
	void exitFile_spec(MocaSqlParser.File_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#entity_name}.
	 * @param ctx the parse tree
	 */
	void enterEntity_name(MocaSqlParser.Entity_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#entity_name}.
	 * @param ctx the parse tree
	 */
	void exitEntity_name(MocaSqlParser.Entity_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#entity_name_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void enterEntity_name_for_azure_dw(MocaSqlParser.Entity_name_for_azure_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#entity_name_for_azure_dw}.
	 * @param ctx the parse tree
	 */
	void exitEntity_name_for_azure_dw(MocaSqlParser.Entity_name_for_azure_dwContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#entity_name_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void enterEntity_name_for_parallel_dw(MocaSqlParser.Entity_name_for_parallel_dwContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#entity_name_for_parallel_dw}.
	 * @param ctx the parse tree
	 */
	void exitEntity_name_for_parallel_dw(MocaSqlParser.Entity_name_for_parallel_dwContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#begin_conversation_timer}.
	 * @param ctx the parse tree
	 */
	void enterBegin_conversation_timer(MocaSqlParser.Begin_conversation_timerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#begin_conversation_timer}.
	 * @param ctx the parse tree
	 */
	void exitBegin_conversation_timer(MocaSqlParser.Begin_conversation_timerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#begin_conversation_dialog}.
	 * @param ctx the parse tree
	 */
	void enterBegin_conversation_dialog(MocaSqlParser.Begin_conversation_dialogContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#begin_conversation_dialog}.
	 * @param ctx the parse tree
	 */
	void exitBegin_conversation_dialog(MocaSqlParser.Begin_conversation_dialogContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#contract_name}.
	 * @param ctx the parse tree
	 */
	void enterContract_name(MocaSqlParser.Contract_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#contract_name}.
	 * @param ctx the parse tree
	 */
	void exitContract_name(MocaSqlParser.Contract_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#service_name}.
	 * @param ctx the parse tree
	 */
	void enterService_name(MocaSqlParser.Service_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#service_name}.
	 * @param ctx the parse tree
	 */
	void exitService_name(MocaSqlParser.Service_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#end_conversation}.
	 * @param ctx the parse tree
	 */
	void enterEnd_conversation(MocaSqlParser.End_conversationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#end_conversation}.
	 * @param ctx the parse tree
	 */
	void exitEnd_conversation(MocaSqlParser.End_conversationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#waitfor_conversation}.
	 * @param ctx the parse tree
	 */
	void enterWaitfor_conversation(MocaSqlParser.Waitfor_conversationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#waitfor_conversation}.
	 * @param ctx the parse tree
	 */
	void exitWaitfor_conversation(MocaSqlParser.Waitfor_conversationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#get_conversation}.
	 * @param ctx the parse tree
	 */
	void enterGet_conversation(MocaSqlParser.Get_conversationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#get_conversation}.
	 * @param ctx the parse tree
	 */
	void exitGet_conversation(MocaSqlParser.Get_conversationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#queue_id}.
	 * @param ctx the parse tree
	 */
	void enterQueue_id(MocaSqlParser.Queue_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#queue_id}.
	 * @param ctx the parse tree
	 */
	void exitQueue_id(MocaSqlParser.Queue_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#send_conversation}.
	 * @param ctx the parse tree
	 */
	void enterSend_conversation(MocaSqlParser.Send_conversationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#send_conversation}.
	 * @param ctx the parse tree
	 */
	void exitSend_conversation(MocaSqlParser.Send_conversationContext ctx);
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
	 * Enter a parse tree produced by {@link MocaSqlParser#default_value}.
	 * @param ctx the parse tree
	 */
	void enterDefault_value(MocaSqlParser.Default_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#default_value}.
	 * @param ctx the parse tree
	 */
	void exitDefault_value(MocaSqlParser.Default_valueContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MocaSqlParser#file_size}.
	 * @param ctx the parse tree
	 */
	void enterFile_size(MocaSqlParser.File_sizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaSqlParser#file_size}.
	 * @param ctx the parse tree
	 */
	void exitFile_size(MocaSqlParser.File_sizeContext ctx);
}