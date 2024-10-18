/*

 This file is derived from TSql grammar which has the following license:

		T-SQL (Transact-SQL, MSSQL) grammar.
		The MIT License (MIT).
		Copyright (c) 2017, Mark Adams (madams51703@gmail.com)
		Copyright (c) 2015-2017, Ivan Kochurkin (kvanttt@gmail.com), Positive Technologies.
		Copyright (c) 2016, Scott Ure (scott@redstormsoftware.com).
		Copyright (c) 2016, Rui Zhang (ruizhang.ccs@gmail.com).
		Copyright (c) 2016, Marcus Henriksson (kuseman80@gmail.com).
		Permission is hereby granted, free of charge, to any person obtaining a copy
		of this software and associated documentation files (the "Software"), to deal
		in the Software without restriction, including without limitation the rights
		to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
		copies of the Software, and to permit persons to whom the Software is
		furnished to do so, subject to the following conditions:
		The above copyright notice and this permission notice shall be included in
		all copies or substantial portions of the Software.
		THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
		IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
		FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
		AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
		LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
		OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
		THE SOFTWARE.

Subsequent modifications have been done under the MIT License.

 */

grammar MocaSql;

@header {
package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;
}

moca_sql_script
    : batch* EOF
    ;

batch
    : sql_clauses
    ;

sql_clauses
    : (sql_clause SEMI?)+
    ;

sql_clause
    : dml_clause
    | ddl_clause
    ;

// Data Manipulation Language: https://msdn.microsoft.com/en-us/library/ff848766(v=sql.120).aspx
dml_clause
    : delete_statement
    | insert_statement
    | select_statement
    | update_statement
    ;

// Data Definition Language: https://msdn.microsoft.com/en-us/library/ff848799.aspx)
ddl_clause
    : create_sequence
	| alter_sequence
	| drop_sequence
	| create_table
    | alter_table
	| drop_table
    | create_index
    | drop_index
    | create_view
	| drop_view
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-sequence-transact-sql
drop_sequence
     : DROP SEQUENCE ( IF EXISTS )? ( COMMA? (database_name=id DOT)? (schema_name=id DOT)?          sequence_name=id )?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-sequence-transact-sql
alter_sequence
    : ALTER SEQUENCE (schema_name=id DOT)? sequence_name=id ( RESTART (WITH DECIMAL)? )? (INCREMENT BY sequnce_increment=DECIMAL )? ( MINVALUE DECIMAL| NO MINVALUE)? (MAXVALUE DECIMAL| NO MAXVALUE)? (CYCLE|NO CYCLE)? (CACHE DECIMAL | NO CACHE)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-sequence-transact-sql
create_sequence
    : CREATE SEQUENCE (schema_name=id DOT)? sequence_name=id
        (AS data_type  )?
        (START WITH DECIMAL)?
        (INCREMENT BY MINUS? DECIMAL)?
        (MINVALUE DECIMAL? | NO MINVALUE)?
        (MAXVALUE DECIMAL? | NO MAXVALUE)?
        (CYCLE|NO CYCLE)?
        (CACHE DECIMAL? | NO CACHE)?
     ;

// DML

// https://msdn.microsoft.com/en-us/library/ms189835.aspx
delete_statement
    : with_expression?
      DELETE (TOP '(' expression ')' PERCENT? | TOP DECIMAL)?
      FROM? delete_statement_from
      insert_with_table_hints?
      output_clause?
      (FROM table_sources)?
      (WHERE (search_condition | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
      for_clause? option_clause? ';'?
    ;

delete_statement_from
    : ddl_object
    | table_alias
    | rowset_function_limited
    | table_var=LOCAL_ID
    ;

// https://msdn.microsoft.com/en-us/library/ms174335.aspx
insert_statement
    : with_expression?
      INSERT (TOP '(' expression ')' PERCENT?)?
      INTO? (ddl_object | rowset_function_limited)
      insert_with_table_hints?
      ('(' column_name_list ')')?
      output_clause?
      insert_statement_value
      for_clause? option_clause? ';'?
    ;

insert_statement_value
    : table_value_constructor
    | derived_table
    | execute_statement
    | DEFAULT VALUES
    ;

// https://msdn.microsoft.com/en-us/library/ms189499.aspx
select_statement
    : with_expression? query_expression order_by_clause? for_clause? option_clause? ';'?
    ;

// https://msdn.microsoft.com/en-us/library/ms177523.aspx
update_statement
    : with_expression?
      UPDATE (TOP '(' expression ')' PERCENT?)?
      (ddl_object | rowset_function_limited)
      with_table_hints?
      SET update_elem (',' update_elem)*
      output_clause?
      (FROM table_sources)?
      (WHERE (search_condition_list | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
      for_clause? option_clause? ';'?
    ;

// https://msdn.microsoft.com/en-us/library/ms177564.aspx
output_clause
    : OUTPUT output_dml_list_elem (',' output_dml_list_elem)*
      (INTO (LOCAL_ID | table_name) ('(' column_name_list ')')? )?
    ;

output_dml_list_elem
    : (output_column_name | expression) as_column_alias?  // TODO: scalar_expression
    ;

output_column_name
    : (DELETED | INSERTED | table_name) '.' ('*' | id)
    | DOLLAR_ACTION
    ;

// DDL

// https://msdn.microsoft.com/en-us/library/ms188783.aspx
create_index
    : CREATE UNIQUE? clustered? INDEX id ON table_name_with_hint '(' column_name_list_with_order ')'
    (INCLUDE '(' column_name_list ')' )?
    (WHERE where=search_condition)?
    (index_options)?
    (ON id)?
    ';'?
    ;

// https://msdn.microsoft.com/en-us/library/ms174979.aspx
create_table
    : CREATE TABLE table_name '(' column_def_table_constraints ','? ')' (LOCK simple_id)? table_options* (ON id | DEFAULT)? (TEXTIMAGE_ON id | DEFAULT)?';'?
    ;

table_options
    : WITH ('(' index_option (',' index_option)* ')' | index_option (',' index_option)*)
    ;

// https://msdn.microsoft.com/en-us/library/ms187956.aspx
create_view
    : CREATE VIEW simple_name ('(' column_name_list ')')?
      (WITH view_attribute (',' view_attribute)*)?
      AS select_statement (WITH CHECK OPTION)? ';'?
    ;

view_attribute
    : ENCRYPTION | SCHEMABINDING | VIEW_METADATA
    ;

// https://msdn.microsoft.com/en-us/library/ms190273.aspx
alter_table
    : ALTER TABLE table_name (SET '(' LOCK_ESCALATION '=' (AUTO | TABLE | DISABLE) ')'
                             | ADD column_def_table_constraint
                             | ALTER COLUMN column_definition
                             | DROP COLUMN id
                             | DROP CONSTRAINT constraint=id
                             | WITH CHECK ADD CONSTRAINT constraint=id FOREIGN KEY '(' fk = column_name_list ')' REFERENCES table_name '(' pk = column_name_list')'
                             | CHECK CONSTRAINT constraint=id
                             | (ENABLE | DISABLE) TRIGGER id?
                             | REBUILD table_options)
                             ';'?
    ;

host
   : id DOT host
   | (id DOT |id)
   ;

// https://msdn.microsoft.com/en-us/library/ms176118.aspx
drop_index
    : DROP INDEX (IF EXISTS)?
    ( drop_relational_or_xml_or_spatial_index (',' drop_relational_or_xml_or_spatial_index)*
    | drop_backward_compatible_index (',' drop_backward_compatible_index)*
    )
    ';'?
    ;

drop_relational_or_xml_or_spatial_index
    : index_name=id ON full_table_name
    ;

drop_backward_compatible_index
    : (owner_name=id '.')? table_or_view_name=id '.' index_name=id
    ;

// https://msdn.microsoft.com/en-us/library/ms173790.aspx
drop_table
    : DROP TABLE (IF EXISTS)? table_name ';'?
    ;

// https://msdn.microsoft.com/en-us/library/ms173492.aspx
drop_view
    : DROP VIEW (IF EXISTS)? simple_name (',' simple_name)* ';'?
    ;

rowset_function_limited
    : openquery
    | opendatasource
    ;

// https://msdn.microsoft.com/en-us/library/ms188427(v=sql.120).aspx
openquery
    : OPENQUERY '(' linked_server=id ',' query=STRING ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms179856.aspx
opendatasource
    : OPENDATASOURCE '(' provider=STRING ',' init=STRING ')'
     '.' (database=id)? '.' (scheme=id)? '.' (table=id)
    ;


// https://msdn.microsoft.com/en-us/library/ms188332.aspx
execute_statement
    : EXECUTE execute_body
    ;

execute_body
    : (return_status=LOCAL_ID '=')? (func_proc_name_server_database_schema | expression) (execute_statement_arg (',' execute_statement_arg)*)? ';'?
    | '(' execute_var_string ('+' execute_var_string)* ')' (AS? (LOGIN | USER) '=' STRING)? ';'?
    ;

execute_statement_arg
    : (parameter=LOCAL_ID '=')? ((constant_LOCAL_ID | id) (OUTPUT | OUT)? | DEFAULT | NULL)
    ;

execute_var_string
    : LOCAL_ID
    | STRING
    ;


column_def_table_constraints
    : column_def_table_constraint (','? column_def_table_constraint)*
    ;

column_def_table_constraint
    : column_definition
    | materialized_column_definition
    | table_constraint
    ;

// https://msdn.microsoft.com/en-us/library/ms187742.aspx
column_definition
    : id (data_type | AS expression) (COLLATE id)? null_notnull?
      ((CONSTRAINT constraint=id)? null_or_default null_or_default?
       | IDENTITY ('(' seed=DECIMAL ',' increment=DECIMAL ')')? (NOT FOR REPLICATION)?)?
      ROWGUIDCOL?
      column_constraint*
    ;

materialized_column_definition
    : id (COMPUTE | AS) expression (MATERIALIZED | NOT MATERIALIZED)?
    ;

// https://msdn.microsoft.com/en-us/library/ms186712.aspx
column_constraint
    :(CONSTRAINT constraint=id)?
      ((PRIMARY KEY | UNIQUE) clustered? index_options?
      | CHECK (NOT FOR REPLICATION)? '(' search_condition ')'
      | (FOREIGN KEY)? REFERENCES table_name '(' pk = column_name_list')' on_delete? on_update?
      | null_notnull)
    ;

// https://msdn.microsoft.com/en-us/library/ms188066.aspx
table_constraint
    : (CONSTRAINT constraint=id)?
       ((PRIMARY KEY | UNIQUE) clustered? '(' column_name_list_with_order ')' index_options? (ON id)?
         | CHECK (NOT FOR REPLICATION)? '(' search_condition ')'
         | DEFAULT '('?  (STRING | PLUS | function_call | DECIMAL)+ ')'? FOR id
         | FOREIGN KEY '(' fk = column_name_list ')' REFERENCES table_name ('(' pk = column_name_list')')? on_delete? on_update?)
    ;

on_delete
    : ON DELETE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

on_update
    : ON UPDATE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

index_options
    : WITH '(' index_option (',' index_option)* ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms186869.aspx
// Id runtime checking. Id in (PAD_INDEX, FILLFACTOR, IGNORE_DUP_KEY, STATISTICS_NORECOMPUTE, ALLOW_ROW_LOCKS,
// ALLOW_PAGE_LOCKS, SORT_IN_TEMPDB, ONLINE, MAXDOP, DATA_COMPRESSION, ONLINE).
index_option
    : simple_id '=' (simple_id | on_off | DECIMAL)
    ;

constant_LOCAL_ID
    : constant
    | LOCAL_ID
    ;

// Expression.

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/expressions-transact-sql
// Operator precendence: https://docs.microsoft.com/en-us/sql/t-sql/language-elements/operator-precedence-transact-sql
expression
    : moca_at_variable
    | moca_at_minus_variable
    | moca_environment_variable
    | moca_integration_variable
    | primitive_expression
    | function_call
    | expression COLLATE id
    | case_expression
    | full_column_name
    | bracket_expression
    | unary_operator_expression
    | expression op=('*' | '/' | '%') expression
    | expression op=('+' | '-' | '&' | '^' | '|' | '||') expression
    | expression comparison_operator expression
    | expression assignment_operator expression
    | over_clause
    ;

moca_at_variable: LOCAL_ID (DOT simple_id)?  ((COLON simple_id) | ((SHARP KEEP) | (SHARP MOCA_ONSTACK) | (SHARP MOCA_IGNORE)))?;
moca_environment_variable: MOCA_ENVIRONMENT_VARIABLE;
moca_at_minus_variable: MOCA_AT_MINUS_VARIABLE (DOT simple_id)? ((COLON simple_id) | ((SHARP KEEP) | (SHARP MOCA_ONSTACK) | (SHARP MOCA_IGNORE)))?;
moca_at_plus_variable: MOCA_AT_PLUS_VARIABLE (DOT simple_id)? ((COLON simple_id) | (BIT_XOR simple_id))?;

moca_at_star: MOCA_AT_STAR;

moca_integration_variable: ':I_' simple_id;

primitive_expression
    : DEFAULT | NULL | LOCAL_ID | constant
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/case-transact-sql
case_expression
    : CASE caseExpr=expression switch_section+ (ELSE elseExpr=expression)? END
    | CASE switch_search_condition_section+ (ELSE elseExpr=expression)? END
    ;

unary_operator_expression
    : '~' expression
    | op=('+' | '-') expression
    ;

bracket_expression
    : '(' expression ')' | '(' subquery ')'
    ;

constant_expression
    : NULL
    | constant
    // system functions: https://msdn.microsoft.com/en-us/library/ms187786.aspx
    | function_call
    | LOCAL_ID         // TODO: remove.
    | '(' constant_expression ')'
    ;

subquery
    : select_statement
    ;

// https://msdn.microsoft.com/en-us/library/ms175972.aspx
with_expression
    : WITH (XMLNAMESPACES ',')? common_table_expression (',' common_table_expression)*
    | WITH BLOCKING_HIERARCHY ('(' full_column_name_list ')')? AS '(' select_statement ')'
    ;

common_table_expression
    : expression_name=id ('(' column_name_list ')')? AS '(' select_statement ')'
    ;

update_elem
    : (full_column_name | LOCAL_ID) ('=' | assignment_operator) expression
    | udt_column_name=id '.' method_name=id '(' expression_list ')'
    //| full_column_name '.' WRITE (expression, )
    ;

// https://msdn.microsoft.com/en-us/library/ms173545.aspx
search_condition_list
    : search_condition (',' search_condition)*
    ;

search_condition
    : search_condition_and (OR search_condition_and)*
    ;

search_condition_and
    : search_condition_not (AND search_condition_not)*
    ;

search_condition_not
    : NOT? predicate
    ;

predicate
    : EXISTS '(' subquery ')'
    | expression comparison_operator expression
    | expression comparison_operator (ALL | SOME | ANY) '(' subquery ')'
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN '(' (subquery | expression_list) ')'
    | expression NOT? LIKE expression (ESCAPE expression)?
    | expression IS null_notnull
	| moca_at_plus_variable
    | moca_at_star
	| (LOCAL_ID (DOT simple_id)? COLON 'RAW') // allowing a normal moca var is not correct here; has to be followed by a RAW type cast.
	| (MOCA_AT_MINUS_VARIABLE (DOT simple_id)? COLON 'RAW') // allowing a normal moca minus var is not correct here; has to be followed by a RAW type cast.
	| '(' search_condition ')';

// Changed union rule to sql_union to avoid union construct with C++ target.  Issue reported by person who generates into C++.  This individual reports change causes generated code to work

query_expression
    : (query_specification | '(' query_expression ')') sql_union*
    ;

sql_union
    : (UNION ALL? | EXCEPT | INTERSECT) (query_specification | ('(' query_expression ')'))
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
query_specification
    : SELECT (ALL | DISTINCT)? top_clause?
      select_list
      // https://msdn.microsoft.com/en-us/library/ms188029.aspx
      (INTO table_name)?
      (FROM table_sources)?
      (WHERE where=search_condition)?
      // https://msdn.microsoft.com/en-us/library/ms177673.aspx
      (GROUP BY (ALL)? group_by_item (',' group_by_item)*)?
      (HAVING having=search_condition)?
    ;

// https://msdn.microsoft.com/en-us/library/ms189463.aspx
top_clause
    : TOP (top_percent | top_count) (WITH TIES)?
    ;

top_percent
    : (REAL | FLOAT) PERCENT
    | '(' expression ')' PERCENT
    ;

top_count
    : DECIMAL
    | '(' expression ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms188385.aspx
order_by_clause
    : ORDER BY order_by_expression (',' order_by_expression)*
      (OFFSET expression (ROW | ROWS) (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/queries/select-for-clause-transact-sql
for_clause
    : FOR BROWSE
    | FOR XML (RAW ('(' STRING ')')? | AUTO) xml_common_directives*
      (COMMA (XMLDATA | XMLSCHEMA ('(' STRING ')')?))?
      (COMMA ELEMENTS (XSINIL | ABSENT))?
    | FOR XML EXPLICIT xml_common_directives*
      (COMMA XMLDATA)?
    | FOR XML PATH ('(' STRING ')')? xml_common_directives*
      (COMMA ELEMENTS (XSINIL | ABSENT))?
    | FOR JSON (AUTO | PATH)
      (COMMA ROOT ('(' STRING ')')?)?
      (COMMA INCLUDE_NULL_VALUES)?
      (COMMA WITHOUT_ARRAY_WRAPPER)?
    ;

xml_common_directives
      : ',' (BINARY_BASE64 | TYPE | ROOT ('(' STRING ')')?)
    ;

order_by_expression
    : expression (ASC | DESC)?
    ;

group_by_item
    : expression
    /*| rollup_spec
    | cube_spec
    | grouping_sets_spec
    | grand_total*/
    ;

option_clause
    // https://msdn.microsoft.com/en-us/library/ms181714.aspx
    : OPTION '(' option (',' option)* ')'
    ;

option
    : FAST number_rows=DECIMAL
    | (HASH | ORDER) GROUP
    | (MERGE | HASH | CONCAT) UNION
    | (LOOP | MERGE | HASH) JOIN
    | EXPAND VIEWS
    | FORCE ORDER
    | IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX
    | KEEP PLAN
    | KEEPFIXED PLAN
    | MAXDOP number_of_processors=DECIMAL
    | MAXRECURSION number_recursion=DECIMAL
    | OPTIMIZE FOR '(' optimize_for_arg (',' optimize_for_arg)* ')'
    | OPTIMIZE FOR UNKNOWN
    | PARAMETERIZATION (SIMPLE | FORCED)
    | RECOMPILE
    | ROBUST PLAN
    | USE PLAN STRING
    ;

optimize_for_arg
    : LOCAL_ID (UNKNOWN | '=' (constant | NULL))
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
select_list
    : select_list_elem (',' select_list_elem)*
    ;

udt_method_arguments
    : '(' execute_var_string (',' execute_var_string)* ')'
    ;

// https://docs.microsoft.com/ru-ru/sql/t-sql/queries/select-clause-transact-sql
asterisk
    : (table_name '.')? '*'
    ;

column_elem
    : ((table_name '.')? (column_name=id | '$' IDENTITY | '$' ROWGUID) | NULL) as_column_alias?
    ;

udt_elem
    : udt_column_name=id '.' non_static_attr=id udt_method_arguments as_column_alias?
    | udt_column_name=id ':' ':' static_attr=id udt_method_arguments? as_column_alias?
    ;

expression_elem
    : column_alias eq='=' expression
    | expression as_column_alias?
    ;

select_list_elem
    : asterisk
    | column_elem
    | udt_elem
    | expression_elem
    ;

table_sources
    : table_source (',' table_source)*
    ;

// https://msdn.microsoft.com/en-us/library/ms177634.aspx
table_source
    : table_source_item_joined
    | '(' table_source_item_joined ')'
    ;

table_source_item_joined
    : table_source_item join_part*
    ;

table_source_item
    : table_name_with_hint        as_table_alias?
    | full_table_name             as_table_alias?
    | rowset_function             as_table_alias?
    | derived_table              (as_table_alias column_alias_list?)?
    | change_table                as_table_alias
    | function_call              (as_table_alias column_alias_list?)?
    | LOCAL_ID                    as_table_alias?
    | LOCAL_ID '.' function_call (as_table_alias column_alias_list?)?
    | open_xml
    | ':' ':' function_call       as_table_alias? // Build-in function (old syntax)
    | (LOCAL_ID (DOT simple_id)? COLON 'RAW') // allowing a normal moca var is not correct here; has to be followed by a RAW type cast.
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/functions/openxml-transact-sql
open_xml
    : OPENXML '(' expression ',' expression (',' expression)? ')'
    (WITH '(' schema_declaration ')' )?
    ;

schema_declaration
    : column_declaration (',' column_declaration)*
    ;

column_declaration
    : ID data_type (STRING)?
    ;

change_table
    : CHANGETABLE '(' CHANGES table_name ',' (NULL | DECIMAL | LOCAL_ID) ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms191472.aspx
join_part
    // https://msdn.microsoft.com/en-us/library/ms173815(v=sql.120).aspx
    : (INNER? |
       join_type=(LEFT | RIGHT | FULL) OUTER?) (join_hint=(LOOP | HASH | MERGE | REMOTE))?
       JOIN table_source ON search_condition
    | CROSS JOIN table_source
    | CROSS APPLY table_source
    | OUTER APPLY table_source
    | PIVOT pivot_clause as_table_alias
    | UNPIVOT unpivot_clause as_table_alias
    ;

pivot_clause
    : '(' aggregate_windowed_function FOR full_column_name IN column_alias_list ')'
    ;

unpivot_clause
    : '(' expression FOR full_column_name IN '(' full_column_name_list ')' ')'
    ;

full_column_name_list
    : full_column_name (',' full_column_name)*
    ;

table_name_with_hint
    : table_name with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms190312.aspx
rowset_function
    :  (
        OPENROWSET LR_BRACKET provider_name = STRING COMMA connectionString = STRING COMMA sql = STRING RR_BRACKET
     )
     | ( OPENROWSET '(' BULK data_file=STRING ',' (bulk_option (',' bulk_option)* | id)')' )
    ;

// runtime check.
bulk_option
    : id '=' bulk_option_value=(DECIMAL | STRING)
    ;

derived_table
    : subquery
    | '(' subquery ')'
    | table_value_constructor
    | '(' table_value_constructor ')'
    ;

function_call
    : // https://msdn.microsoft.com/en-us/library/ms173784.aspx
     BINARY_CHECKSUM '(' '*' ')'                       #BINARY_CHECKSUM
    // https://msdn.microsoft.com/en-us/library/hh231076.aspx
    // https://msdn.microsoft.com/en-us/library/ms187928.aspx
    | CAST '(' expression AS data_type ')'              #CAST
    | CONVERT '(' convert_data_type=data_type ','convert_expression=expression (',' style=expression)? ')'                              #CONVERT
    // https://msdn.microsoft.com/en-us/library/ms189788.aspx
    | CHECKSUM '(' '*' ')'                              #CHECKSUM
    // https://msdn.microsoft.com/en-us/library/ms190349.aspx
    | COALESCE '(' expression_list ')'                  #COALESCE
    // https://msdn.microsoft.com/en-us/library/ms188751.aspx
    | CURRENT_TIMESTAMP                                 #CURRENT_TIMESTAMP
    // https://msdn.microsoft.com/en-us/library/ms176050.aspx
    | CURRENT_USER                                      #CURRENT_USER
    // https://msdn.microsoft.com/en-us/library/ms186819.aspx
    | DATEADD '(' ID ',' expression ',' expression ')'  #DATEADD
    // https://msdn.microsoft.com/en-us/library/ms189794.aspx
    | DATEDIFF '(' ID ',' expression ',' expression ')' #DATEDIFF
    // https://msdn.microsoft.com/en-us/library/ms174395.aspx
    | DATENAME '(' ID ',' expression ')'                #DATENAME
    // https://msdn.microsoft.com/en-us/library/ms174420.aspx
    | DATEPART '(' ID ',' expression ')'                #DATEPART
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/getdate-transact-sql
    | GETDATE '(' ')'                                   #GETDATE
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/getdate-transact-sql
    | GETUTCDATE '(' ')'                                #GETUTCDATE
    // https://msdn.microsoft.com/en-us/library/ms189838.aspx
    | IDENTITY '(' data_type (',' seed=DECIMAL)? (',' increment=DECIMAL)? ')'                                                           #IDENTITY
    // https://msdn.microsoft.com/en-us/library/bb839514.aspx
    | MIN_ACTIVE_ROWVERSION                             #MIN_ACTIVE_ROWVERSION
    // https://msdn.microsoft.com/en-us/library/ms177562.aspx
    | NULLIF '(' expression ',' expression ')'          #NULLIF
    // https://msdn.microsoft.com/fr-fr/library/ms188043.aspx
    | STUFF '(' expression ',' DECIMAL ',' DECIMAL ',' expression ')'                                                                   #STUFF
    // https://msdn.microsoft.com/en-us/library/ms177587.aspx
    | SESSION_USER                                      #SESSION_USER
    // https://msdn.microsoft.com/en-us/library/ms179930.aspx
    | SYSTEM_USER                                       #SYSTEM_USER
    // https://msdn.microsoft.com/en-us/library/ms184325.aspx
    | ISNULL '(' expression ',' expression ')'          #ISNULL
    // https://docs.microsoft.com/en-us/sql/t-sql/xml/xml-data-type-methods
    | xml_data_type_methods                             #XML_DATA_TYPE_FUNC
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/logical-functions-iif-transact-sql
    | IIF '(' search_condition ',' expression ',' expression ')'   #IFF
    | ranking_windowed_function                         #RANKING_WINDOWED_FUNC
    | aggregate_windowed_function                       #AGGREGATE_WINDOWED_FUNC
    | analytic_windowed_function                        #ANALYTIC_WINDOWED_FUNC
    | scalar_function_name '(' expression_list? ')'     #SCALAR_FUNCTION
    | STRING_AGG '(' expr=expression ',' separator=expression ')' (WITHIN GROUP '(' order_by_clause ')')?  #STRINGAGG
    ;

xml_data_type_methods
    : value_method
    | query_method
    | exist_method
    | modify_method
    | nodes_method
    ;

value_method
    : (LOCAL_ID | ID | EVENTDATA | query_method) '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    | (LOCAL_ID | ID | EVENTDATA | query_method) '.' ROW '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    | (LOCAL_ID | ID | EVENTDATA | query_method) '.' PARAM_NODE '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    ;

query_method
    : (LOCAL_ID | ID | full_table_name) '.' QUERY '(' xquery=STRING ')'
    | (LOCAL_ID | ID | full_table_name) '.' ROW '.' QUERY '(' xquery=STRING ')'
    ;

exist_method
    : (LOCAL_ID | ID) '.' EXIST '(' xquery=STRING ')'
    ;

modify_method
    : (LOCAL_ID | ID) '.' MODIFY '(' xml_dml=STRING ')'
    ;

nodes_method
    : (LOCAL_ID | ID) '.' NODES '(' xquery=STRING ')'
    ;


switch_section
    : WHEN expression THEN expression
    ;

switch_search_condition_section
    : WHEN search_condition THEN expression
    ;

as_column_alias
    : AS? column_alias
    ;

as_table_alias
    : AS? table_alias
    ;

table_alias
    : id with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
with_table_hints
    : WITH? '(' table_hint (','? table_hint)* ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
insert_with_table_hints
    : WITH '(' table_hint (','? table_hint)* ')'
    ;

// Id runtime check. Id can be (FORCESCAN, HOLDLOCK, NOLOCK, NOWAIT, PAGLOCK, READCOMMITTED,
// READCOMMITTEDLOCK, READPAST, READUNCOMMITTED, REPEATABLEREAD, ROWLOCK, TABLOCK, TABLOCKX
// UPDLOCK, XLOCK)
table_hint
    : NOEXPAND? ( INDEX ('(' index_value (',' index_value)* ')' | index_value (',' index_value)*)
                | INDEX '=' index_value
                | FORCESEEK ('(' index_value '(' ID  (',' ID)* ')' ')')?
                | SERIALIZABLE
                | SNAPSHOT
                | SPATIAL_WINDOW_MAX_CELLS '=' DECIMAL
                | ID)
    ;

index_value
    : id | DECIMAL
    ;

column_alias_list
    : '(' column_alias (',' column_alias)* ')'
    ;

column_alias
    : id
    | STRING
    ;

table_value_constructor
    : VALUES '(' expression_list ')' (',' '(' expression_list ')')*
    ;

expression_list
    : expression (',' expression)*
    ;

// https://msdn.microsoft.com/en-us/library/ms189798.aspx
ranking_windowed_function
    : (RANK | DENSE_RANK | ROW_NUMBER) '(' ')' over_clause
    | NTILE '(' expression ')' over_clause
    ;

// https://msdn.microsoft.com/en-us/library/ms173454.aspx
aggregate_windowed_function
    : (AVG | MAX | MIN | SUM | STDEV | STDEVP | VAR | VARP)
      '(' all_distinct_expression ')' over_clause?
    | (COUNT | COUNT_BIG)
      '(' ('*' | all_distinct_expression) ')' over_clause?
    | CHECKSUM_AGG '(' all_distinct_expression ')'
    | GROUPING '(' expression ')'
    | GROUPING_ID '(' expression_list ')'
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/functions/analytic-functions-transact-sql
analytic_windowed_function
    : (FIRST_VALUE | LAST_VALUE) '(' expression ')' over_clause
    | (LAG | LEAD) '(' expression  (',' expression (',' expression)? )? ')' over_clause
    ;

all_distinct_expression
    : (ALL | DISTINCT)? expression
    ;

// https://msdn.microsoft.com/en-us/library/ms189461.aspx
over_clause
    : OVER '(' (PARTITION BY expression_list)? order_by_clause? row_or_range_clause? ')'
    ;

row_or_range_clause
    : (ROWS | RANGE) window_frame_extent
    ;

window_frame_extent
    : window_frame_preceding
    | BETWEEN window_frame_bound AND window_frame_bound
    ;

window_frame_bound
    : window_frame_preceding
    | window_frame_following
    ;

window_frame_preceding
    : UNBOUNDED PRECEDING
    | DECIMAL PRECEDING
    | CURRENT ROW
    ;

window_frame_following
    : UNBOUNDED FOLLOWING
    | DECIMAL FOLLOWING
    ;

full_table_name
    : (server=id '.' database=id '.'  schema=id   '.'
      |              database=id '.' (schema=id)? '.'
      |                               schema=id   '.')? table=id
    ;

table_name
    : (database=id '.' (schema=id)? '.' | schema=id '.')? table=id
    | (database=id '.' (schema=id)? '.' | schema=id '.')? BLOCKING_HIERARCHY
    ;

simple_name
    : (schema=id '.')? name=id
    ;

func_proc_name_schema
    : ((schema=id) '.')? procedure=id
    ;

func_proc_name_database_schema
    : func_proc_name_schema
    | (database=id '.' (schema=id)? '.')? procedure=id
    ;

func_proc_name_server_database_schema
    : func_proc_name_database_schema
    | (server=id '.' database=id '.' (schema=id)? '.')? procedure=id
    ;

ddl_object
    : full_table_name
    | LOCAL_ID
    ;
/*  There are some RESERVED WORDS that can be column names */
full_column_name
    : (table_name '.')? column_name=id
    | (table_name '.')? COMPATIBILITY_LEVEL
    | (table_name '.')? STATUS
    | (table_name '.')? QUOTED_IDENTIFIER
    | (table_name '.')? ARITHABORT
    | (table_name '.')? ANSI_WARNINGS
    | (table_name '.')? ANSI_PADDING
    | (table_name '.')? ANSI_NULLS

    ;

column_name_list_with_order
    : id (ASC | DESC)? (',' id (ASC | DESC)?)*
    ;

column_name_list
    : id (',' id)*
    ;

cursor_name
    : id
    | LOCAL_ID
    ;

on_off
    : ON
    | OFF
    ;

clustered
    : CLUSTERED
    | NONCLUSTERED
    ;

null_notnull
    : NOT? NULL
    ;

null_or_default
    :(null_notnull | DEFAULT constant_expression (WITH VALUES)?)
    ;

scalar_function_name
    : func_proc_name_server_database_schema
    | RIGHT
    | LEFT
    | BINARY_CHECKSUM
    | CHECKSUM
    ;

// https://msdn.microsoft.com/en-us/library/ms187752.aspx
// TODO: implement runtime check or add new tokens.
data_type
    /*: BIGINT
    | BINARY '(' DECIMAL ')'
    | BIT
    | CHAR '(' DECIMAL ')'
    | DATE
    | DATETIME
    | DATETIME2
    | DATETIMEOFFSET '(' DECIMAL ')'
    | DECIMAL '(' DECIMAL ',' DECIMAL ')'
    | DOUBLE PRECISION?
    | FLOAT
    | GEOGRAPHY
    | GEOMETRY
    | HIERARCHYID
    | IMAGE
    | INT
    | MONEY
    | NCHAR '(' DECIMAL ')'
    | NTEXT
    | NUMERIC '(' DECIMAL ',' DECIMAL ')'
    | NVARCHAR '(' DECIMAL | MAX ')'
    | REAL
    | SMALLDATETIME
    | SMALLINT
    | SMALLMONEY
    | SQL_VARIANT
    | TEXT
    | TIME '(' DECIMAL ')'
    | TIMESTAMP
    | TINYINT
    | UNIQUEIDENTIFIER
    | VARBINARY '(' DECIMAL | MAX ')'
    | VARCHAR '(' DECIMAL | MAX ')'
    | XML*/
    : id IDENTITY? ('(' (DECIMAL | MAX) (',' DECIMAL)? ')')?
    | DOUBLE PRECISION?
    | INT
    | TINYINT
    | SMALLINT
    | BIGINT
    ;

// https://msdn.microsoft.com/en-us/library/ms179899.aspx
constant
    : STRING // string, datetime or uniqueidentifier
    | BINARY
    | sign? DECIMAL
    | sign? (REAL | FLOAT)  // float or decimal
    | sign? dollar='$' (DECIMAL | FLOAT)       // money
    ;

sign
    : PLUS
    | MINUS
    ;

// https://msdn.microsoft.com/en-us/library/ms175874.aspx
id
    : simple_id
    | DOUBLE_QUOTE_ID
    | SQUARE_BRACKET_ID
    ;

simple_id
    : ID
    | ABSOLUTE
    | ACCENT_SENSITIVITY
    | ACTION
    | ACTIVATION
    | ACTIVE
    | ADDRESS
    | AES_128
    | AES_192
    | AES_256
    | AFFINITY
    | AFTER
    | AGGREGATE
    | ALGORITHM
    | ALLOW_ENCRYPTED_VALUE_MODIFICATIONS
    | ALLOW_SNAPSHOT_ISOLATION
    | ALLOWED
    | ANSI_NULL_DEFAULT
    | ANSI_NULLS
    | ANSI_PADDING
    | ANSI_WARNINGS
    | APPLICATION_LOG
    | APPLY
    | ARITHABORT
    | ASSEMBLY
    | AUDIT
    | AUDIT_GUID
    | AUTO
    | AUTO_CLEANUP
    | AUTO_CLOSE
    | AUTO_CREATE_STATISTICS
    | AUTO_SHRINK
    | AUTO_UPDATE_STATISTICS
    | AUTO_UPDATE_STATISTICS_ASYNC
    | AVAILABILITY
    | AVG
    | BACKUP_PRIORITY
    | BEGIN_DIALOG
    | BIGINT
    | BINARY_BASE64
    | BINARY_CHECKSUM
    | BINDING
    | BLOB_STORAGE
    | BROKER
    | BROKER_INSTANCE
    | BULK_LOGGED
    | CALLED
    | CALLER
    | CAP_CPU_PERCENT
    | CAST
    | CATALOG
    | CATCH
    | CHANGE_RETENTION
    | CHANGE_TRACKING
    | CHECKSUM
    | CHECKSUM_AGG
    | CLEANUP
    | COLLECTION
    | COLUMN_MASTER_KEY
    | COMMITTED
    | COMPATIBILITY_LEVEL
    | CONCAT
    | CONCAT_NULL_YIELDS_NULL
    | CONTENT
    | CONTROL
    | COOKIE
    | COUNT
    | COUNT_BIG
    | COUNTER
    | CPU
    | CREATE_NEW
    | CREATION_DISPOSITION
    | CREDENTIAL
    | CRYPTOGRAPHIC
    | CURSOR_CLOSE_ON_COMMIT
    | CURSOR_DEFAULT
    | DATA
    | DATA_COMPRESSION
    | DATE_CORRELATION_OPTIMIZATION
    | DATEADD
    | DATEDIFF
    | DATENAME
    | DATEPART
    | DAYS
    | DB_CHAINING
    | DB_FAILOVER
    | DECRYPTION
    | DEFAULT_DOUBLE_QUOTE
    | DEFAULT_FULLTEXT_LANGUAGE
    | DEFAULT_LANGUAGE
    | DELAY
    | DELAYED_DURABILITY
    | DELETED
    | DENSE_RANK
    | DEPENDENTS
    | DES
    | DESCRIPTION
    | DESX
    | DHCP
    | DIALOG
    | DIRECTORY_NAME
    | DISABLE
    | DISABLE_BROKER
    | DISABLED
    | DISK_DRIVE
    | DOCUMENT
    | DYNAMIC
    | EMERGENCY
    | EMPTY
    | ENABLE
    | ENABLE_BROKER
    | ENCRYPTED_VALUE
    | ENCRYPTION
    | ENDPOINT_URL
    | ERROR_BROKER_CONVERSATIONS
    | EVENTDATA
    | EXCLUSIVE
    | EXECUTABLE
    | EXIST
    | EXPAND
    | EXPIREDATE
    | EXPIRY_DATE
    | EXPLICIT
    | FAIL_OPERATION
    | FAILOVER_MODE
    | FAILURE
    | FAILURE_CONDITION_LEVEL
    | FAST
    | FAST_FORWARD
    | FILEGROUP
    | FILEGROWTH
    | FILENAME
    | FILEPATH
    | FILESTREAM
    | FILLFACTOR
    | FILTER
    | FIRST
    | FIRST_VALUE
    | FOLLOWING
    | FORCE
    | FORCE_FAILOVER_ALLOW_DATA_LOSS
    | FORCED
    | FORCESEEK
    | FORMAT
    | FORWARD_ONLY
    | FULLSCAN
    | FULLTEXT
    | GB
    | GETDATE
    | GETUTCDATE
    | GLOBAL
    | GO
    | GROUP_MAX_REQUESTS
    | GROUPING
    | GROUPING_ID
    | HADR
    | HASH
    | HEALTH_CHECK_TIMEOUT
    | HIGH
    | HONOR_BROKER_PRIORITY
    | HOURS
    | IDENTITY_VALUE
    | IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX
    | IMMEDIATE
    | IMPERSONATE
    | IMPORTANCE
    | INCREMENTAL
    | INIT
    | INITIATOR
    | INPUT
    | INSENSITIVE
    | INSERTED
    | INT
    | IP
    | ISOLATION
    | KB
    | KEEP
    | KEEPFIXED
    | KEY
    | KEY_SOURCE
    | KEYS
    | KEYSET
    | LAG
    | LAST
    | LAST_VALUE
    | LEAD
    | LEVEL
    | LIST
    | LISTENER
    | LISTENER_URL
    | LOB_COMPACTION
    | LOCAL
    | LOCATION
    | LOCK
    | LOCK_ESCALATION
    | LOGIN
    | LOOP
    | LOW
    | MANUAL
    | MARK
    | MASTER
    | MATERIALIZED
    | MAX
    | MAX_CPU_PERCENT
    | MAX_DOP
    | MAX_FILES
    | MAX_IOPS_PER_VOLUME
    | MAX_MEMORY
    | MAX_MEMORY_PERCENT
    | MAX_PROCESSES
    | MAX_QUEUE_READERS
    | MAX_ROLLOVER_FILES
    | MAXDOP
    | MAXRECURSION
    | MAXSIZE
    | MB
    | MEDIUM
    | MEMORY_OPTIMIZED_DATA
    | MESSAGE
    | MIN
    | MIN_ACTIVE_ROWVERSION
    | MIN_CPU_PERCENT
    | MIN_IOPS_PER_VOLUME
    | MIN_MEMORY_PERCENT
    | MINUTES
    | MIRROR_ADDRESS
    | MIXED_PAGE_ALLOCATION
    | MODE
    | MODIFY
    | MOVE
    | MULTI_USER
    | NAME
    | NESTED_TRIGGERS
    | NEW_ACCOUNT
    | NEW_BROKER
    | NEW_PASSWORD
    | NEXT
    | NO
    | NO_TRUNCATE
    | NO_WAIT
    | NOCOUNT
    | NODES
    | NOEXPAND
    | NON_TRANSACTED_ACCESS
    | NORECOMPUTE
    | NORECOVERY
    | NOWAIT
    | NTILE
    | NUMANODE
    | NUMBER
    | NUMERIC_ROUNDABORT
    | OBJECT
    | OFFLINE
    | OFFSET
    | OFFSETS
    | OLD_ACCOUNT
    | ONLINE
    | ONLY
    | OPEN_EXISTING
    | OPTIMISTIC
    | OPTIMIZE
    | OUT
    | OUTPUT
    | OWNER
    | PAGE
    | PAGE_VERIFY
    | PARAMETERIZATION
    | PARTITION
    | PARTITIONS
    | PARTNER
    | PATH
    | POISON_MESSAGE_HANDLING
    | POLICY
    | POOL
    | PORT
    | PRECEDING
    | PRECISION
    | PRIMARY_ROLE
    | PRIOR
    | PRIORITY
    | PRIORITY_LEVEL
    | PRIVATE
    | PRIVATE_KEY
    | PRIVILEGES
    | PROCEDURE_NAME
    | PROPERTY
    | PROVIDER
    | PROVIDER_KEY_NAME
    | PUBLIC
    | QUERY
    | QUEUE
    | QUEUE_DELAY
    | QUOTED_IDENTIFIER
    | R
    | RANGE
    | RANK
    | RAW
    | RC2
    | RC4
    | RC4_128
    | READ_COMMITTED_SNAPSHOT
    | READ_ONLY
    | READ_ONLY_ROUTING_LIST
    | READ_WRITE
    | READONLY
    | REBUILD
    | RECEIVE
    | RECOMPILE
    | RECOVERY
    | RECURSIVE_TRIGGERS
    | RELATIVE
    | REMOTE
    | REMOTE_SERVICE_NAME
    | REMOVE
    | REORGANIZE
    | REPEATABLE
    | REPLICA
    | REQUEST_MAX_CPU_TIME_SEC
    | REQUEST_MAX_MEMORY_GRANT_PERCENT
    | REQUEST_MEMORY_GRANT_TIMEOUT_SEC
    | REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT
    | RESERVE_DISK_SPACE
    | RESOURCE
    | RESOURCE_MANAGER_LOCATION
    | RESTRICTED_USER
    | RETENTION
    | RETURN
    | RETURNS
    | ROBUST
    | ROLE
    | ROOT
    | ROUTE
    | ROW
    | ROW_NUMBER
    | ROWCOUNT
    | ROWGUID
    | ROWS
    | SAFETY
    | SAMPLE
    | SCHEMABINDING
    | SCOPED
    | SCROLL
    | SCROLL_LOCKS
    | SEARCH
    | SECONDARY
    | SECONDARY_ONLY
    | SECONDARY_ROLE
    | SECONDS
    | SECRET
    | SECURITY
    | SECURITY_LOG
    | SEEDING_MODE
    | SELF
    | SEMI_SENSITIVE
    | SEND
    | SENT
    | SEQUENCE
    | SERIALIZABLE
    | SERVER
    | SESSION_TIMEOUT
    | SETERROR
    | SHARE
    | SHOWPLAN
    | SID
    | SIGNATURE
    | SIMPLE
    | SINGLE_USER
    | SIZE
    | SMALLINT
    | SNAPSHOT
    | SOURCE
    | SPATIAL_WINDOW_MAX_CELLS
    | SPLIT
    | STANDBY
    | START
    | START_DATE
    | STATE
    | STATIC
    | STATS_STREAM
    | STATUS
    | STDEV
    | STDEVP
    | STOP
    | STOPLIST
    | STRING_AGG
    | STUFF
    | SUBJECT
    | SUM
    | SUSPEND
    | SYMMETRIC
    | SYNCHRONOUS_COMMIT
    | SYNONYM
    | SYSTEM
    | TAKE
    | TARGET
    | TARGET_RECOVERY_TIME
    | TB
    | TEXTIMAGE_ON
    | THROW
    | TIES
    | TIME
    | TIMEOUT
    | TIMER
    | TINYINT
    | TORN_PAGE_DETECTION
    | TRANSFORM_NOISE_WORDS
    | TRIPLE_DES
    | TRIPLE_DES_3KEY
    | TRUSTWORTHY
    | TRY
    | TSQL
    | TWO_DIGIT_YEAR_CUTOFF
    | TYPE
    | TYPE_WARNING
    | UNBOUNDED
    | UNCOMMITTED
    | UNKNOWN
    | UNLIMITED
    | URL
    | USING
    | VALID_XML
    | VALIDATION
    | VALUE
    | VAR
    | VARP
    | VIEW_METADATA
    | VIEWS
    | WAIT
    | WELL_FORMED_XML
    | WORK
    | WORKLOAD
    | XML
    | XMLNAMESPACES
    ;

// https://msdn.microsoft.com/en-us/library/ms188074.aspx
// Spaces are allowed for comparison operators.
comparison_operator:
	EQUAL
	| LESS
	| GREATER
	| LESS_EQUAL
	| GREATER_EQUAL
	| NOT_EQUAL
	| '!' '>'
	| '!' '<';

assignment_operator:
	PLUS_ASSIGN
	| MINUS_ASSIGN
	| MULT_ASSIGN
	| DIV_ASSIGN
	| MOD_ASSIGN
	| AND_ASSIGN
	| XOR_ASSIGN
	| OR_ASSIGN;

// Basic keywords (from https://msdn.microsoft.com/en-us/library/ms189822.aspx)
ABSENT: 'ABSENT';
ADD: 'ADD';
AES: 'AES';
ALL: 'ALL';
ALLOW_CONNECTIONS: 'ALLOW_CONNECTIONS';
ALLOW_MULTIPLE_EVENT_LOSS: 'ALLOW_MULTIPLE_EVENT_LOSS';
ALLOW_SINGLE_EVENT_LOSS: 'ALLOW_SINGLE_EVENT_LOSS';
ALTER: 'ALTER';
AND: 'AND';
ANONYMOUS: 'ANONYMOUS';
ANY: 'ANY';
APPEND: 'APPEND';
APPLICATION: 'APPLICATION';
AS: 'AS';
ASC: 'ASC';
ASYMMETRIC: 'ASYMMETRIC';
ASYNCHRONOUS_COMMIT: 'ASYNCHRONOUS_COMMIT';
AUTHORIZATION: 'AUTHORIZATION';
AUTHENTICATION: 'AUTHENTICATION';
AUTOMATED_BACKUP_PREFERENCE: 'AUTOMATED_BACKUP_PREFERENCE';
AUTOMATIC: 'AUTOMATIC';
AVAILABILITY_MODE: 'AVAILABILITY_MODE';
BACKSLASH: '\\';
BACKUP: 'BACKUP';
BEFORE: 'BEFORE';
BEGIN: 'BEGIN';
BETWEEN: 'BETWEEN';
BLOCK: 'BLOCK';
BLOCKSIZE: 'BLOCKSIZE';
BLOCKING_HIERARCHY: 'BLOCKING_HIERARCHY';
BREAK: 'BREAK';
BROWSE: 'BROWSE';
BUFFER: 'BUFFER';
BUFFERCOUNT: 'BUFFERCOUNT';
BULK: 'BULK';
BY: 'BY';
CACHE: 'CACHE';
CALLED: 'CALLED';
CASCADE: 'CASCADE';
CASE: 'CASE';
CERTIFICATE: 'CERTIFICATE';
CHANGETABLE: 'CHANGETABLE';
CHANGES: 'CHANGES';
CHECK: 'CHECK';
CHECKPOINT: 'CHECKPOINT';
CHECK_POLICY: 'CHECK_POLICY';
CHECK_EXPIRATION: 'CHECK_EXPIRATION';
CLASSIFIER_FUNCTION: 'CLASSIFIER_FUNCTION';
CLOSE: 'CLOSE';
CLUSTER: 'CLUSTER';
CLUSTERED: 'CLUSTERED';
COALESCE: 'COALESCE';
COLLATE: 'COLLATE';
COLUMN: 'COLUMN';
COMPRESSION: 'COMPRESSION';
COMMIT: 'COMMIT';
COMPUTE: 'COMPUTE';
CONFIGURATION: 'CONFIGURATION';
CONSTRAINT: 'CONSTRAINT';
CONTAINMENT: 'CONTAINMENT';
CONTAINS: 'CONTAINS';
CONTAINSTABLE: 'CONTAINSTABLE';
CONTEXT: 'CONTEXT';
CONTINUE: 'CONTINUE';
CONTINUE_AFTER_ERROR: 'CONTINUE_AFTER_ERROR';
CONTRACT: 'CONTRACT';
CONTRACT_NAME: 'CONTRACT_NAME';
CONVERSATION: 'CONVERSATION';
CONVERT: 'TRY_'? 'CONVERT';
COPY_ONLY: 'COPY_ONLY';
CREATE: 'CREATE';
CROSS: 'CROSS';
CURRENT: 'CURRENT';
CURRENT_DATE: 'CURRENT_DATE';
CURRENT_TIME: 'CURRENT_TIME';
CURRENT_TIMESTAMP: 'CURRENT_TIMESTAMP';
CURRENT_USER: 'CURRENT_USER';
CURSOR: 'CURSOR';
CYCLE: 'CYCLE';
DATA_COMPRESSION: 'DATA_COMPRESSION';
DATA_SOURCE: 'DATA_SOURCE';
DATABASE: 'DATABASE';
DATABASE_MIRRORING: 'DATABASE_MIRRORING';
DBCC: 'DBCC';
DEALLOCATE: 'DEALLOCATE';
DECLARE: 'DECLARE';
DEFAULT: 'DEFAULT';
DEFAULT_DATABASE: 'DEFAULT_DATABASE';
DEFAULT_SCHEMA: 'DEFAULT_SCHEMA';
DELETE: 'DELETE';
DENY: 'DENY';
DESC: 'DESC';
DIAGNOSTICS: 'DIAGNOSTICS';
DIFFERENTIAL: 'DIFFERENTIAL';
DISK: 'DISK';
DISTINCT: 'DISTINCT';
DISTRIBUTED: 'DISTRIBUTED';
DOUBLE: 'DOUBLE';
DOUBLE_BACK_SLASH: '\\\\';
DOUBLE_FORWARD_SLASH: '//';
DROP: 'DROP';
DTC_SUPPORT: 'DTC_SUPPORT';
DUMP: 'DUMP';
ELSE: 'ELSE';
ENABLED: 'ENABLED';
END: 'END';
ENDPOINT: 'ENDPOINT';
ERRLVL: 'ERRLVL';
ESCAPE: 'ESCAPE';
ERROR: 'ERROR';
EVENT: 'EVENT';
EVENTDATA: 'EVENTDATA' '(' ')';
EVENT_RETENTION_MODE: 'EVENT_RETENTION_MODE';
EXCEPT: 'EXCEPT';
EXECUTABLE_FILE: 'EXECUTABLE_FILE';
EXECUTE: 'EXEC' 'UTE'?;
EXISTS: 'EXISTS';
EXPIREDATE: 'EXPIREDATE';
EXIT: 'EXIT';
EXTENSION: 'EXTENSION';
EXTERNAL: 'EXTERNAL';
EXTERNAL_ACCESS: 'EXTERNAL_ACCESS';
FAILOVER: 'FAILOVER';
FAILURECONDITIONLEVEL: 'FAILURECONDITIONLEVEL';
FAN_IN: 'FAN_IN';
FETCH: 'FETCH';
FILE: 'FILE';
FILENAME: 'FILENAME';
FILLFACTOR: 'FILLFACTOR';
FILE_SNAPSHOT: 'FILE_SNAPSHOT';
FOR: 'FOR';
FORCESEEK: 'FORCESEEK';
FORCE_SERVICE_ALLOW_DATA_LOSS: 'FORCE_SERVICE_ALLOW_DATA_LOSS';
FOREIGN: 'FOREIGN';
FREETEXT: 'FREETEXT';
FREETEXTTABLE: 'FREETEXTTABLE';
FROM: 'FROM';
FULL: 'FULL';
FUNCTION: 'FUNCTION';
GET: 'GET';
GOTO: 'GOTO';
GOVERNOR: 'GOVERNOR';
GRANT: 'GRANT';
GROUP: 'GROUP';
HAVING: 'HAVING';
HASHED: 'HASHED';
HEALTHCHECKTIMEOUT: 'HEALTHCHECKTIMEOUT';
IDENTITY: 'IDENTITY';
IDENTITYCOL: 'IDENTITYCOL';
IDENTITY_INSERT: 'IDENTITY_INSERT';
IF: 'IF';
IIF: 'IIF';
IN: 'IN';
INCLUDE: 'INCLUDE';
INCREMENT: 'INCREMENT';
INDEX: 'INDEX';
INFINITE: 'INFINITE';
INIT: 'INIT';
INNER: 'INNER';
INSERT: 'INSERT';
INSTEAD: 'INSTEAD';
INTERSECT: 'INTERSECT';
INTO: 'INTO';
IPV4_ADDR:
	[']? IPV4_OCTECT DOT IPV4_OCTECT DOT IPV4_OCTECT DOT IPV4_OCTECT [']?;
IPV6_ADDR:
	[']? [0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:][0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:]
		[0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:][0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:]
		[0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:][0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:]
		[0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [:][0-9A-F]? [0-9A-F]? [0-9A-F]? [0-9A-F]? [']?;
IS: 'IS';
ISNULL: 'ISNULL';
JOIN: 'JOIN';
KERBEROS: 'KERBEROS';
KEY: 'KEY';
KEY_PATH: 'KEY_PATH';
KEY_STORE_PROVIDER_NAME: 'KEY_STORE_PROVIDER_NAME';
KILL: 'KILL';
LANGUAGE: 'LANGUAGE';
LEFT: 'LEFT';
LIBRARY: 'LIBRARY';
LIFETIME: 'LIFETIME';
LIKE: 'LIKE';
LINENO: 'LINENO';
LINUX: 'LINUX';
LISTENER_IP: 'LISTENER_IP';
LISTENER_PORT: 'LISTENER_PORT';
LOAD: 'LOAD';
LOCAL_SERVICE_NAME: 'LOCAL_SERVICE_NAME';
LOG: 'LOG';
MATCHED: 'MATCHED';
MASTER: 'MASTER';
MAX_MEMORY: 'MAX_MEMORY';
MAXTRANSFER: 'MAXTRANSFER';
MAXVALUE: 'MAXVALUE';
MAX_DISPATCH_LATENCY: 'MAX_DISPATCH_LATENCY';
MAX_EVENT_SIZE: 'MAX_EVENT_SIZE';
MAX_SIZE: 'MAX_SIZE';
MAX_OUTSTANDING_IO_PER_VOLUME: 'MAX_OUTSTANDING_IO_PER_VOLUME';
MEDIADESCRIPTION: 'MEDIADESCRIPTION';
MEDIANAME: 'MEDIANAME';
MEMBER: 'MEMBER';
MEMORY_PARTITION_MODE: 'MEMORY_PARTITION_MODE';
MERGE: 'MERGE';
MESSAGE_FORWARDING: 'MESSAGE_FORWARDING';
MESSAGE_FORWARD_SIZE: 'MESSAGE_FORWARD_SIZE';
MINVALUE: 'MINVALUE';
MIRROR: 'MIRROR';
MUST_CHANGE: 'MUST_CHANGE';
NATIONAL: 'NATIONAL';
NEGOTIATE: 'NEGOTIATE';
NOCHECK: 'NOCHECK';
NOFORMAT: 'NOFORMAT';
NOINIT: 'NOINIT';
NONCLUSTERED: 'NONCLUSTERED';
NONE: 'NONE';
NOREWIND: 'NOREWIND';
NOSKIP: 'NOSKIP';
NOUNLOAD: 'NOUNLOAD';
NO_CHECKSUM: 'NO_CHECKSUM';
NO_COMPRESSION: 'NO_COMPRESSION';
NO_EVENT_LOSS: 'NO_EVENT_LOSS';
NOT: 'NOT';
NOTIFICATION: 'NOTIFICATION';
NTLM: 'NTLM';
NULL: 'NULL';
NULLIF: 'NULLIF';
OF: 'OF';
OFF: 'OFF';
OFFSETS: 'OFFSETS';
OLD_PASSWORD: 'OLD_PASSWORD';
ON: 'ON';
ON_FAILURE: 'ON_FAILURE';
OPEN: 'OPEN';
OPENDATASOURCE: 'OPENDATASOURCE';
OPENQUERY: 'OPENQUERY';
OPENROWSET: 'OPENROWSET';
OPENXML: 'OPENXML';
OPTION: 'OPTION';
OR: 'OR';
ORDER: 'ORDER';
OUTER: 'OUTER';
OVER: 'OVER';
PAGE: 'PAGE';
PARAM_NODE: 'PARAM_NODE';
PARTIAL: 'PARTIAL';
PASSWORD: 'PASSWORD';
PERCENT: 'PERCENT';
PERMISSION_SET: 'PERMISSION_SET';
PER_CPU: 'PER_CPU';
PER_DB: 'PER_DB';
PER_NODE: 'PER_NODE';
PIVOT: 'PIVOT';
PLAN: 'PLAN';
PLATFORM: 'PLATFORM';
POLICY: 'POLICY';
PRECISION: 'PRECISION';
PREDICATE: 'PREDICATE';
PRIMARY: 'PRIMARY';
PRINT: 'PRINT';
PROC: 'PROC';
PROCEDURE: 'PROCEDURE';
PROCESS: 'PROCESS';
PUBLIC: 'PUBLIC';
PYTHON: 'PYTHON';
R: 'R';
RAISERROR: 'RAISERROR';
RAW: 'RAW';
READ: 'READ';
READTEXT: 'READTEXT';
READ_WRITE_FILEGROUPS: 'READ_WRITE_FILEGROUPS';
RECONFIGURE: 'RECONFIGURE';
REFERENCES: 'REFERENCES';
REGENERATE: 'REGENERATE';
RELATED_CONVERSATION: 'RELATED_CONVERSATION';
RELATED_CONVERSATION_GROUP: 'RELATED_CONVERSATION_GROUP';
REPLICATION: 'REPLICATION';
REQUIRED: 'REQUIRED';
RESET: 'RESET';
RESTART: 'RESTART';
RESTORE: 'RESTORE';
RESTRICT: 'RESTRICT';
RESUME: 'RESUME';
RETAINDAYS: 'RETAINDAYS';
RETURN: 'RETURN';
RETURNS: 'RETURNS';
REVERT: 'REVERT';
REVOKE: 'REVOKE';
REWIND: 'REWIND';
RIGHT: 'RIGHT';
ROLLBACK: 'ROLLBACK';
ROLE: 'ROLE';
ROWCOUNT: 'ROWCOUNT';
ROWGUIDCOL: 'ROWGUIDCOL';
RSA_512: 'RSA_512';
RSA_1024: 'RSA_1024';
RSA_2048: 'RSA_2048';
RSA_3072: 'RSA_3072';
RSA_4096: 'RSA_4096';
SAFETY: 'SAFETY';
RULE: 'RULE';
SAFE: 'SAFE';
SAVE: 'SAVE';
SCHEDULER: 'SCHEDULER';
SCHEMA: 'SCHEMA';
SCHEME: 'SCHEME';
SECURITYAUDIT: 'SECURITYAUDIT';
SELECT: 'SELECT';
SEMANTICKEYPHRASETABLE: 'SEMANTICKEYPHRASETABLE';
SEMANTICSIMILARITYDETAILSTABLE:
	'SEMANTICSIMILARITYDETAILSTABLE';
SEMANTICSIMILARITYTABLE: 'SEMANTICSIMILARITYTABLE';
SERVER: 'SERVER';
SERVICE: 'SERVICE';
SERVICE_BROKER: 'SERVICE_BROKER';
SERVICE_NAME: 'SERVICE_NAME';
SESSION: 'SESSION';
SESSION_USER: 'SESSION_USER';
SET: 'SET';
SETUSER: 'SETUSER';
SHUTDOWN: 'SHUTDOWN';
SID: 'SID';
SKIP_KEYWORD: 'SKIP';
SOFTNUMA: 'SOFTNUMA';
SOME: 'SOME';
SOURCE: 'SOURCE';
SPECIFICATION: 'SPECIFICATION';
SPLIT: 'SPLIT';
SQLDUMPERFLAGS: 'SQLDUMPERFLAGS';
SQLDUMPERPATH: 'SQLDUMPERPATH';
SQLDUMPERTIMEOUT: 'SQLDUMPERTIMEOUTS';
STATISTICS: 'STATISTICS';
STATE: 'STATE';
STATS: 'STATS';
START: 'START';
STARTED: 'STARTED';
STARTUP_STATE: 'STARTUP_STATE';
STOP: 'STOP';
STOPPED: 'STOPPED';
STOP_ON_ERROR: 'STOP_ON_ERROR';
SUPPORTED: 'SUPPORTED';
SYSTEM_USER: 'SYSTEM_USER';
TABLE: 'TABLE';
TABLESAMPLE: 'TABLESAMPLE';
TAPE: 'TAPE';
TARGET: 'TARGET';
TCP: 'TCP';
TEXTSIZE: 'TEXTSIZE';
THEN: 'THEN';
TO: 'TO';
TOP: 'TOP';
TRACK_CAUSALITY: 'TRACK_CAUSALITY';
TRAN: 'TRAN';
TRANSACTION: 'TRANSACTION';
TRANSFER: 'TRANSFER';
TRIGGER: 'TRIGGER';
TRUNCATE: 'TRUNCATE';
TSEQUAL: 'TSEQUAL';
UNCHECKED: 'UNCHECKED';
UNION: 'UNION';
UNIQUE: 'UNIQUE';
UNLOCK: 'UNLOCK';
UNPIVOT: 'UNPIVOT';
UNSAFE: 'UNSAFE';
UPDATE: 'UPDATE';
UPDATETEXT: 'UPDATETEXT';
URL: 'URL';
USE: 'USE';
USED: 'USED';
USER: 'USER';
VALUES: 'VALUES';
VARYING: 'VARYING';
VERBOSELOGGING: 'VERBOSELOGGING';
VIEW: 'VIEW';
VISIBILITY: 'VISIBILITY';
WAITFOR: 'WAITFOR';
WHEN: 'WHEN';
WHERE: 'WHERE';
WHILE: 'WHILE';
WINDOWS: 'WINDOWS';
WITH: 'WITH';
WITHIN: 'WITHIN';
WITHOUT: 'WITHOUT';
WITNESS: 'WITNESS';
WRITETEXT: 'WRITETEXT';

// Additional keywords. They can be id, please keep them in sync with the parser.
ABSOLUTE: 'ABSOLUTE';
ACCENT_SENSITIVITY: 'ACCENT_SENSITIVITY';
ACTION: 'ACTION';
ACTIVATION: 'ACTIVATION';
ACTIVE: 'ACTIVE';
ADDRESS: 'ADDRESS';
AES_128: 'AES_128';
AES_192: 'AES_192';
AES_256: 'AES_256';
AFFINITY: 'AFFINITY';
AFTER: 'AFTER';
AGGREGATE: 'AGGREGATE';
ALGORITHM: 'ALGORITHM';
ALLOW_ENCRYPTED_VALUE_MODIFICATIONS:
	'ALLOW_ENCRYPTED_VALUE_MODIFICATIONS';
ALLOW_SNAPSHOT_ISOLATION: 'ALLOW_SNAPSHOT_ISOLATION';
ALLOWED: 'ALLOWED';
ANSI_NULL_DEFAULT: 'ANSI_NULL_DEFAULT';
ANSI_NULLS: 'ANSI_NULLS';
ANSI_PADDING: 'ANSI_PADDING';
ANSI_WARNINGS: 'ANSI_WARNINGS';
APPLICATION_LOG: 'APPLICATION_LOG';
APPLY: 'APPLY';
ARITHABORT: 'ARITHABORT';
ASSEMBLY: 'ASSEMBLY';
AUDIT: 'AUDIT';
AUDIT_GUID: 'AUDIT_GUID';
AUTO: 'AUTO';
AUTO_CLEANUP: 'AUTO_CLEANUP';
AUTO_CLOSE: 'AUTO_CLOSE';
AUTO_CREATE_STATISTICS: 'AUTO_CREATE_STATISTICS';
AUTO_SHRINK: 'AUTO_SHRINK';
AUTO_UPDATE_STATISTICS: 'AUTO_UPDATE_STATISTICS';
AUTO_UPDATE_STATISTICS_ASYNC: 'AUTO_UPDATE_STATISTICS_ASYNC';
AVAILABILITY: 'AVAILABILITY';
AVG: 'AVG';
BACKUP_PRIORITY: 'BACKUP_PRIORITY';
BEGIN_DIALOG: 'BEGIN_DIALOG';
BIGINT: 'BIGINT';
BINARY_BASE64: 'BINARY BASE64';
BINARY_CHECKSUM: 'BINARY_CHECKSUM';
BINDING: 'BINDING';
BLOB_STORAGE: 'BLOB_STORAGE';
BROKER: 'BROKER';
BROKER_INSTANCE: 'BROKER_INSTANCE';
BULK_LOGGED: 'BULK_LOGGED';
CALLER: 'CALLER';
CAP_CPU_PERCENT: 'CAP_CPU_PERCENT';
CAST: 'TRY_'? 'CAST';
CATALOG: 'CATALOG';
CATCH: 'CATCH';
CHANGE_RETENTION: 'CHANGE_RETENTION';
CHANGE_TRACKING: 'CHANGE_TRACKING';
CHECKSUM: 'CHECKSUM';
CHECKSUM_AGG: 'CHECKSUM_AGG';
CLEANUP: 'CLEANUP';
COLLECTION: 'COLLECTION';
COLUMN_MASTER_KEY: 'COLUMN_MASTER_KEY';
COMMITTED: 'COMMITTED';
COMPATIBILITY_LEVEL: 'COMPATIBILITY_LEVEL';
CONCAT: 'CONCAT';
CONCAT_NULL_YIELDS_NULL: 'CONCAT_NULL_YIELDS_NULL';
CONTENT: 'CONTENT';
CONTROL: 'CONTROL';
COOKIE: 'COOKIE';
COUNT: 'COUNT';
COUNT_BIG: 'COUNT_BIG';
COUNTER: 'COUNTER';
CPU: 'CPU';
CREATE_NEW: 'CREATE_NEW';
CREATION_DISPOSITION: 'CREATION_DISPOSITION';
CREDENTIAL: 'CREDENTIAL';
CRYPTOGRAPHIC: 'CRYPTOGRAPHIC';
CURSOR_CLOSE_ON_COMMIT: 'CURSOR_CLOSE_ON_COMMIT';
CURSOR_DEFAULT: 'CURSOR_DEFAULT';
DATA: 'DATA';
DATE_CORRELATION_OPTIMIZATION: 'DATE_CORRELATION_OPTIMIZATION';
DATEADD: 'DATEADD';
DATEDIFF: 'DATEDIFF';
DATENAME: 'DATENAME';
DATEPART: 'DATEPART';
DAYS: 'DAYS';
DB_CHAINING: 'DB_CHAINING';
DB_FAILOVER: 'DB_FAILOVER';
DECRYPTION: 'DECRYPTION';
DEFAULT_DOUBLE_QUOTE: ["]'DEFAULT' ["];
DEFAULT_FULLTEXT_LANGUAGE: 'DEFAULT_FULLTEXT_LANGUAGE';
DEFAULT_LANGUAGE: 'DEFAULT_LANGUAGE';
DELAY: 'DELAY';
DELAYED_DURABILITY: 'DELAYED_DURABILITY';
DELETED: 'DELETED';
DENSE_RANK: 'DENSE_RANK';
DEPENDENTS: 'DEPENDENTS';
DES: 'DES';
DESCRIPTION: 'DESCRIPTION';
DESX: 'DESX';
DHCP: 'DHCP';
DIALOG: 'DIALOG';
DIRECTORY_NAME: 'DIRECTORY_NAME';
DISABLE: 'DISABLE';
DISABLE_BROKER: 'DISABLE_BROKER';
DISABLED: 'DISABLED';
DISK_DRIVE: [A-Z][:];
DOCUMENT: 'DOCUMENT';
DYNAMIC: 'DYNAMIC';
ELEMENTS: 'ELEMENTS';
EMERGENCY: 'EMERGENCY';
EMPTY: 'EMPTY';
ENABLE: 'ENABLE';
ENABLE_BROKER: 'ENABLE_BROKER';
ENCRYPTED_VALUE: 'ENCRYPTED_VALUE';
ENCRYPTION: 'ENCRYPTION';
ENDPOINT_URL: 'ENDPOINT_URL';
ERROR_BROKER_CONVERSATIONS: 'ERROR_BROKER_CONVERSATIONS';
EXCLUSIVE: 'EXCLUSIVE';
EXECUTABLE: 'EXECUTABLE';
EXIST: 'EXIST';
EXPAND: 'EXPAND';
EXPIRY_DATE: 'EXPIRY_DATE';
EXPLICIT: 'EXPLICIT';
FAIL_OPERATION: 'FAIL_OPERATION';
FAILOVER_MODE: 'FAILOVER_MODE';
FAILURE: 'FAILURE';
FAILURE_CONDITION_LEVEL: 'FAILURE_CONDITION_LEVEL';
FAST: 'FAST';
FAST_FORWARD: 'FAST_FORWARD';
FILEGROUP: 'FILEGROUP';
FILEGROWTH: 'FILEGROWTH';
FILEPATH: 'FILEPATH';
FILESTREAM: 'FILESTREAM';
FILTER: 'FILTER';
FIRST: 'FIRST';
FIRST_VALUE: 'FIRST_VALUE';
FOLLOWING: 'FOLLOWING';
FORCE: 'FORCE';
FORCE_FAILOVER_ALLOW_DATA_LOSS:
	'FORCE_FAILOVER_ALLOW_DATA_LOSS';
FORCED: 'FORCED';
FORMAT: 'FORMAT';
FORWARD_ONLY: 'FORWARD_ONLY';
FULLSCAN: 'FULLSCAN';
FULLTEXT: 'FULLTEXT';
GB: 'GB';
GETDATE: 'GETDATE';
GETUTCDATE: 'GETUTCDATE';
GLOBAL: 'GLOBAL';
GO: 'GO';
GROUP_MAX_REQUESTS: 'GROUP_MAX_REQUESTS';
GROUPING: 'GROUPING';
GROUPING_ID: 'GROUPING_ID';
HADR: 'HADR';
HASH: 'HASH';
HEALTH_CHECK_TIMEOUT: 'HEALTH_CHECK_TIMEOUT';
HIGH: 'HIGH';
HONOR_BROKER_PRIORITY: 'HONOR_BROKER_PRIORITY';
HOURS: 'HOURS';
IDENTITY_VALUE: 'IDENTITY_VALUE';
IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX:
	'IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX';
IMMEDIATE: 'IMMEDIATE';
IMPERSONATE: 'IMPERSONATE';
IMPORTANCE: 'IMPORTANCE';
INCLUDE_NULL_VALUES: 'INCLUDE_NULL_VALUES';
INCREMENTAL: 'INCREMENTAL';
INITIATOR: 'INITIATOR';
INPUT: 'INPUT';
INSENSITIVE: 'INSENSITIVE';
INSERTED: 'INSERTED';
INT: 'INT';
IP: 'IP';
ISOLATION: 'ISOLATION';
JOB: 'JOB';
JSON: 'JSON';
KB: 'KB';
KEEP: 'KEEP';
KEEPFIXED: 'KEEPFIXED';
KEY_SOURCE: 'KEY_SOURCE';
KEYS: 'KEYS';
KEYSET: 'KEYSET';
LAG: 'LAG';
LAST: 'LAST';
LAST_VALUE: 'LAST_VALUE';
LEAD: 'LEAD';
LEVEL: 'LEVEL';
LIST: 'LIST';
LISTENER: 'LISTENER';
LISTENER_URL: 'LISTENER_URL';
LOB_COMPACTION: 'LOB_COMPACTION';
LOCAL: 'LOCAL';
LOCATION: 'LOCATION';
LOCK: 'LOCK';
LOCK_ESCALATION: 'LOCK_ESCALATION';
LOGIN: 'LOGIN';
LOOP: 'LOOP';
LOW: 'LOW';
MANUAL: 'MANUAL';
MARK: 'MARK';
MATERIALIZED: 'MATERIALIZED';
MAX: 'MAX';
MAX_CPU_PERCENT: 'MAX_CPU_PERCENT';
MAX_DOP: 'MAX_DOP';
MAX_FILES: 'MAX_FILES';
MAX_IOPS_PER_VOLUME: 'MAX_IOPS_PER_VOLUME';
MAX_MEMORY_PERCENT: 'MAX_MEMORY_PERCENT';
MAX_PROCESSES: 'MAX_PROCESSES';
MAX_QUEUE_READERS: 'MAX_QUEUE_READERS';
MAX_ROLLOVER_FILES: 'MAX_ROLLOVER_FILES';
MAXDOP: 'MAXDOP';
MAXRECURSION: 'MAXRECURSION';
MAXSIZE: 'MAXSIZE';
MB: 'MB';
MEDIUM: 'MEDIUM';
MEMORY_OPTIMIZED_DATA: 'MEMORY_OPTIMIZED_DATA';
MESSAGE: 'MESSAGE';
MIN: 'MIN';
MIN_ACTIVE_ROWVERSION: 'MIN_ACTIVE_ROWVERSION';
MIN_CPU_PERCENT: 'MIN_CPU_PERCENT';
MIN_IOPS_PER_VOLUME: 'MIN_IOPS_PER_VOLUME';
MIN_MEMORY_PERCENT: 'MIN_MEMORY_PERCENT';
MINUTES: 'MINUTES';
MIRROR_ADDRESS: 'MIRROR_ADDRESS';
MIXED_PAGE_ALLOCATION: 'MIXED_PAGE_ALLOCATION';
MODE: 'MODE';
MODIFY: 'MODIFY';
MOVE: 'MOVE';
MULTI_USER: 'MULTI_USER';
NAME: 'NAME';
NESTED_TRIGGERS: 'NESTED_TRIGGERS';
NEW_ACCOUNT: 'NEW_ACCOUNT';
NEW_BROKER: 'NEW_BROKER';
NEW_PASSWORD: 'NEW_PASSWORD';
NEXT: 'NEXT';
NO: 'NO';
NO_TRUNCATE: 'NO_TRUNCATE';
NO_WAIT: 'NO_WAIT';
NOCOUNT: 'NOCOUNT';
NODES: 'NODES';
NOEXPAND: 'NOEXPAND';
NON_TRANSACTED_ACCESS: 'NON_TRANSACTED_ACCESS';
NORECOMPUTE: 'NORECOMPUTE';
NORECOVERY: 'NORECOVERY';
NOWAIT: 'NOWAIT';
NTILE: 'NTILE';
NUMANODE: 'NUMANODE';
NUMBER: 'NUMBER';
NUMERIC_ROUNDABORT: 'NUMERIC_ROUNDABORT';
OBJECT: 'OBJECT';
OFFLINE: 'OFFLINE';
OFFSET: 'OFFSET';
OLD_ACCOUNT: 'OLD_ACCOUNT';
ONLINE: 'ONLINE';
ONLY: 'ONLY';
OPEN_EXISTING: 'OPEN_EXISTING';
OPTIMISTIC: 'OPTIMISTIC';
OPTIMIZE: 'OPTIMIZE';
OUT: 'OUT';
OUTPUT: 'OUTPUT';
OVERRIDE: 'OVERRIDE';
OWNER: 'OWNER';
PAGE_VERIFY: 'PAGE_VERIFY';
PARAMETERIZATION: 'PARAMETERIZATION';
PARTITION: 'PARTITION';
PARTITIONS: 'PARTITIONS';
PARTNER: 'PARTNER';
PATH: 'PATH';
POISON_MESSAGE_HANDLING: 'POISON_MESSAGE_HANDLING';
POOL: 'POOL';
PORT: 'PORT';
PRECEDING: 'PRECEDING';
PRIMARY_ROLE: 'PRIMARY_ROLE';
PRIOR: 'PRIOR';
PRIORITY: 'PRIORITY';
PRIORITY_LEVEL: 'PRIORITY_LEVEL';
PRIVATE: 'PRIVATE';
PRIVATE_KEY: 'PRIVATE_KEY';
PRIVILEGES: 'PRIVILEGES';
PROCEDURE_NAME: 'PROCEDURE_NAME';
PROPERTY: 'PROPERTY';
PROVIDER: 'PROVIDER';
PROVIDER_KEY_NAME: 'PROVIDER_KEY_NAME';
QUERY: 'QUERY';
QUEUE: 'QUEUE';
QUEUE_DELAY: 'QUEUE_DELAY';
QUOTED_IDENTIFIER: 'QUOTED_IDENTIFIER';
RANGE: 'RANGE';
RANK: 'RANK';
RC2: 'RC2';
RC4: 'RC4';
RC4_128: 'RC4_128';
READ_COMMITTED_SNAPSHOT: 'READ_COMMITTED_SNAPSHOT';
READ_ONLY: 'READ_ONLY';
READ_ONLY_ROUTING_LIST: 'READ_ONLY_ROUTING_LIST';
READ_WRITE: 'READ_WRITE';
READONLY: 'READONLY';
REBUILD: 'REBUILD';
RECEIVE: 'RECEIVE';
RECOMPILE: 'RECOMPILE';
RECOVERY: 'RECOVERY';
RECURSIVE_TRIGGERS: 'RECURSIVE_TRIGGERS';
RELATIVE: 'RELATIVE';
REMOTE: 'REMOTE';
REMOTE_SERVICE_NAME: 'REMOTE_SERVICE_NAME';
REMOVE: 'REMOVE';
REORGANIZE: 'REORGANIZE';
REPEATABLE: 'REPEATABLE';
REPLICA: 'REPLICA';
REQUEST_MAX_CPU_TIME_SEC: 'REQUEST_MAX_CPU_TIME_SEC';
REQUEST_MAX_MEMORY_GRANT_PERCENT:
	'REQUEST_MAX_MEMORY_GRANT_PERCENT';
REQUEST_MEMORY_GRANT_TIMEOUT_SEC:
	'REQUEST_MEMORY_GRANT_TIMEOUT_SEC';
REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT:
	'REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT';
RESERVE_DISK_SPACE: 'RESERVE_DISK_SPACE';
RESOURCE: 'RESOURCE';
RESOURCE_MANAGER_LOCATION: 'RESOURCE_MANAGER_LOCATION';
RESTRICTED_USER: 'RESTRICTED_USER';
RETENTION: 'RETENTION';
ROBUST: 'ROBUST';
ROOT: 'ROOT';
ROUTE: 'ROUTE';
ROW: 'ROW';
ROW_NUMBER: 'ROW_NUMBER';
ROWGUID: 'ROWGUID';
ROWS: 'ROWS';
SAMPLE: 'SAMPLE';
SCHEMABINDING: 'SCHEMABINDING';
SCOPED: 'SCOPED';
SCROLL: 'SCROLL';
SCROLL_LOCKS: 'SCROLL_LOCKS';
SEARCH: 'SEARCH';
SECONDARY: 'SECONDARY';
SECONDARY_ONLY: 'SECONDARY_ONLY';
SECONDARY_ROLE: 'SECONDARY_ROLE';
SECONDS: 'SECONDS';
SECRET: 'SECRET';
SECURITY: 'SECURITY';
SECURITY_LOG: 'SECURITY_LOG';
SEEDING_MODE: 'SEEDING_MODE';
SELF: 'SELF';
SEMI_SENSITIVE: 'SEMI_SENSITIVE';
SEND: 'SEND';
SENT: 'SENT';
SEQUENCE: 'SEQUENCE';
SERIALIZABLE: 'SERIALIZABLE';
SESSION_TIMEOUT: 'SESSION_TIMEOUT';
SETERROR: 'SETERROR';
SHARE: 'SHARE';
SHOWPLAN: 'SHOWPLAN';
SIGNATURE: 'SIGNATURE';
SIMPLE: 'SIMPLE';
SINGLE_USER: 'SINGLE_USER';
SIZE: 'SIZE';
SMALLINT: 'SMALLINT';
SNAPSHOT: 'SNAPSHOT';
SPATIAL_WINDOW_MAX_CELLS: 'SPATIAL_WINDOW_MAX_CELLS';
STANDBY: 'STANDBY';
START_DATE: 'START_DATE';
STATIC: 'STATIC';
STATS_STREAM: 'STATS_STREAM';
STATUS: 'STATUS';
STATUSONLY: 'STATUSONLY';
STDEV: 'STDEV';
STDEVP: 'STDEVP';
STOPLIST: 'STOPLIST';
STRING_AGG: 'STRING_AGG';
STUFF: 'STUFF';
SUBJECT: 'SUBJECT';
SUBSCRIPTION: 'SUBSCRIPTION';
SUM: 'SUM';
SUSPEND: 'SUSPEND';
SYMMETRIC: 'SYMMETRIC';
SYNCHRONOUS_COMMIT: 'SYNCHRONOUS_COMMIT';
SYNONYM: 'SYNONYM';
SYSTEM: 'SYSTEM';
TAKE: 'TAKE';
TARGET_RECOVERY_TIME: 'TARGET_RECOVERY_TIME';
TB: 'TB';
TEXTIMAGE_ON: 'TEXTIMAGE_ON';
THROW: 'THROW';
TIES: 'TIES';
TIME: 'TIME';
TIMEOUT: 'TIMEOUT';
TIMER: 'TIMER';
TINYINT: 'TINYINT';
TORN_PAGE_DETECTION: 'TORN_PAGE_DETECTION';
TRANSFORM_NOISE_WORDS: 'TRANSFORM_NOISE_WORDS';
TRIPLE_DES: 'TRIPLE_DES';
TRIPLE_DES_3KEY: 'TRIPLE_DES_3KEY';
TRUSTWORTHY: 'TRUSTWORTHY';
TRY: 'TRY';
TSQL: 'TSQL';
TWO_DIGIT_YEAR_CUTOFF: 'TWO_DIGIT_YEAR_CUTOFF';
TYPE: 'TYPE';
TYPE_WARNING: 'TYPE_WARNING';
UNBOUNDED: 'UNBOUNDED';
UNCOMMITTED: 'UNCOMMITTED';
UNKNOWN: 'UNKNOWN';
UNLIMITED: 'UNLIMITED';
UOW: 'UOW';
USING: 'USING';
VALID_XML: 'VALID_XML';
VALIDATION: 'VALIDATION';
VALUE: 'VALUE';
VAR: 'VAR';
VARP: 'VARP';
VIEW_METADATA: 'VIEW_METADATA';
VIEWS: 'VIEWS';
WAIT: 'WAIT';
WELL_FORMED_XML: 'WELL_FORMED_XML';
WITHOUT_ARRAY_WRAPPER: 'WITHOUT_ARRAY_WRAPPER';
WORK: 'WORK';
WORKLOAD: 'WORKLOAD';
XML: 'XML';
XMLDATA: 'XMLDATA';
XMLNAMESPACES: 'XMLNAMESPACES';
XMLSCHEMA: 'XMLSCHEMA';
XSINIL: 'XSINIL';

DOLLAR_ACTION: '$ACTION';

MOCA_ONSTACK: 'ONSTACK';
MOCA_IGNORE: 'IGNORE';



SPACE: [ \t\r\n]+ -> channel(HIDDEN);
// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/slash-star-comment-transact-sql
COMMENT: '/*' (COMMENT | .)*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '--' ~[\r\n]* -> channel(HIDDEN);

// TODO: ID can be not only Latin.
DOUBLE_QUOTE_ID: '"' ~'"'+ '"';
SINGLE_QUOTE: '\'';
SQUARE_BRACKET_ID: '[' ~']'+ ']';

// LOCAL_ID: '@' ([A-Z_$@#0-9] | FullWidthLetter)+; -- see adjusted version for moca below!
// NOTE: not including possibility for '.' in regex due to how mocasql behaves differently regarding '.'s in vars than moca does.
LOCAL_ID: AT [a-zA-Z_0-9]+;
MOCA_ENVIRONMENT_VARIABLE: AT AT [a-zA-Z_0-9]+;
MOCA_AT_MINUS_VARIABLE: AT MINUS [a-zA-Z_0-9]+;
MOCA_AT_PLUS_VARIABLE: AT (PLUS | MODULE) [a-zA-Z_0-9]+;
MOCA_AT_STAR: AT STAR;


DECIMAL: DEC_DIGIT+;
// ID: ([A-Z_#] | FullWidthLetter) ([A-Z_#$@0-9] | FullWidthLetter)*; -- see adjusted version for moca below!
ID: ([A-Z_] | FullWidthLetter) ([A-Z_$@0-9] | FullWidthLetter)*;
QUOTED_URL:
	'\'' ([A-Z][A-Z]+ [:]) '//' (
		([A-Z]+ [.] | [A-Z]+)
		| IPV4_ADDR
	) [:] DECIMAL '\'';
QUOTED_HOST_AND_PORT:
	'\'' (([A-Z]+ [.] | [A-Z]+) | IPV4_ADDR) ([:] DECIMAL) '\'';
STRING: 'N'? '\'' (~'\'' | '\'\'')* '\'';
BINARY: '0' 'X' HEX_DIGIT*;
FLOAT: DEC_DOT_DEC;
REAL: (DECIMAL | DEC_DOT_DEC) ('E' [+-]? DEC_DIGIT+);

EQUAL: '=';
NOT_EQUAL: '!=' | '<>';
GREATER: '>';
LESS: '<';
GREATER_EQUAL: '>=';
LESS_EQUAL: '<=';
EXCLAMATION: '!';

PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MULT_ASSIGN: '*=';
DIV_ASSIGN: '/=';
MOD_ASSIGN: '%=';
AND_ASSIGN: '&=';
XOR_ASSIGN: '^=';
OR_ASSIGN: '|=';

DOUBLE_BAR: '||';
DOT: '.';
UNDERLINE: '_';
AT: '@';
SHARP: '#';
DOLLAR: '$';
LR_BRACKET: '(';
RR_BRACKET: ')';
COMMA: ',';
SEMI: ';';
COLON: ':';
STAR: '*';
DIVIDE: '/';
MODULE: '%';
PLUS: '+';
MINUS: '-';
BIT_NOT: '~';
BIT_OR: '|';
BIT_AND: '&';
BIT_XOR: '^';

fragment LETTER: [A-Z_];
fragment IPV6_OCTECT: [0-9A-F][0-9A-F][0-9A-F][0-9A-F];
IPV4_OCTECT: [0-9]? [0-9]? [0-9];
fragment DEC_DOT_DEC: (
		DEC_DIGIT+ '.' DEC_DIGIT+
		| DEC_DIGIT+ '.'
		| '.' DEC_DIGIT+
	);
fragment HEX_DIGIT: [0-9A-F];
fragment DEC_DIGIT: [0-9];

fragment FullWidthLetter:
	'\u00c0' ..'\u00d6'
	| '\u00d8' ..'\u00f6'
	| '\u00f8' ..'\u00ff'
	| '\u0100' ..'\u1fff'
	| '\u2c00' ..'\u2fff'
	| '\u3040' ..'\u318f'
	| '\u3300' ..'\u337f'
	| '\u3400' ..'\u3fff'
	| '\u4e00' ..'\u9fff'
	| '\ua000' ..'\ud7ff'
	| '\uf900' ..'\ufaff'
	| '\uff00' ..'\ufff0';
// | '\u10000'..'\u1F9FF' //not support four bytes chars | '\u20000'..'\u2FA1F';