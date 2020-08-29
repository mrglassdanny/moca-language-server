grammar Moca;

@header {
package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;
}

// TODO: Strings are not currently perfectly inline with std MOCA parser UNIMPLEMENTED: Annotations,
// SQL Hints, Special command arguments, @SuppressWarnings/other directives?

// PARSER --------------------------------------------------------

moca_script: sequence EOF;

sequence: stream (SEMI_COLON stream)* SEMI_COLON?;

stream: group (PIPE group)*;

group: statement (AMPERSAND statement)*;

statement: (
		block catch_multi_expr? moca_redirect_expr?
		| if_statement else_if_statement* else_statement?
		| try_block catch_sequence* finally_sequence? moca_redirect_expr?
	);

block: command | moca_remote_expr? sub_sequence;

command: sql_script | groovy_script | verb_noun_clause;

verb_noun_clause:
	CARET? (
		WORD
		| AND
		| LIKE
		| OR
		| IS
		| NOT
		| NULL
		| IF
		| ELSE
		| TRY
		| CATCH
		| FINALLY
		| REMOTE
		| PARALLEL
		| INPARALLEL
	)+ (WHERE verb_noun_clause_args)?;

verb_noun_clause_args:
	verb_noun_clause_arg (AND verb_noun_clause_arg)*;

verb_noun_clause_arg:
	SINGLE_BRACKET_STRING
	| MOCA_INTEGRATOR_OVERSTACKED_ARGS
	| ( moca_at_star | moca_plus_variable)
	| (
		WORD (
			IS NULL
			| IS NOT NULL
			| EQUAL
			| NOT_EQUAL
			| LESS
			| GREATER
			| LESS_EQUAL
			| GREATER_EQUAL
			| LIKE
			| NOT LIKE
		)
	) (
		verb_noun_clause_arg_expr
	);

verb_noun_clause_arg_expr:
	literal_value
	| WORD
	| moca_variable
	| moca_at_bang
	| moca_at_question
	| function_expr
	| SINGLE_BRACKET_STRING
	| (
		BANG (
			literal_value
			| WORD
			| moca_variable
			| moca_at_bang
			| moca_at_question
			| function_expr
		)
	)
	| verb_noun_clause_arg_expr DOUBLE_PIPE verb_noun_clause_arg_expr
	| verb_noun_clause_arg_expr ( STAR | DIV | MOD) verb_noun_clause_arg_expr
	| verb_noun_clause_arg_expr ( PLUS | MINUS) verb_noun_clause_arg_expr
	| LEFT_PAREN verb_noun_clause_arg_expr RIGHT_PAREN
	| verb_noun_clause_arg_expr NOT? (LIKE) verb_noun_clause_arg_expr
	| verb_noun_clause_arg_expr ( IS | NULL | NOT NULL);

sub_sequence:
	LEFT_BRACE sequence RIGHT_BRACE
	| LEFT_BRACE sub_sequence RIGHT_BRACE;

if_expr: IF LEFT_PAREN expr* RIGHT_PAREN;
if_statement: if_expr statement;
else_if_statement: ELSE if_statement;
else_statement: ELSE statement;

try_block: TRY block;
catch_single_expr:
	CATCH LEFT_PAREN (
		(
			literal_value
			| moca_at_question
			| moca_at_bang
			| WORD
			| moca_variable
			| function_expr
		)
	) RIGHT_PAREN;
catch_multi_expr:
	CATCH LEFT_PAREN (
		(
			literal_value
			| moca_at_question
			| moca_at_bang
			| WORD
			| moca_variable
			| function_expr
		) (
			COMMA (
				literal_value
				| moca_at_question
				| moca_at_bang
				| WORD
				| moca_variable
				| function_expr
			)
		)*
	) RIGHT_PAREN;
catch_sequence:
	catch_single_expr LEFT_BRACE sequence RIGHT_BRACE;
finally_sequence: FINALLY LEFT_BRACE sequence RIGHT_BRACE;

moca_redirect_expr: DOUBLE_GREATER WORD;

moca_remote_expr:
	moca_remote_keyword LEFT_PAREN (
		literal_value
		| WORD
		| moca_variable
	) RIGHT_PAREN;


expr:
	literal_value
	| WORD
	| moca_variable
	| moca_at_bang
	| moca_at_question
	| moca_at_star
	| function_expr
	| SINGLE_BRACKET_STRING
	| (
		BANG (
			literal_value
			| WORD
			| moca_variable
			| moca_at_bang
			| moca_at_question
			| moca_at_star
			| function_expr
		)
	)
	| expr DOUBLE_PIPE expr
	| expr ( STAR | DIV | MOD) expr
	| expr ( PLUS | MINUS) expr
	| expr (LESS | LESS_EQUAL | GREATER | GREATER_EQUAL) expr
	| expr ( EQUAL | NOT_EQUAL | IS | IS NOT | LIKE) expr
	| expr AND expr
	| expr OR expr
	| LEFT_PAREN expr RIGHT_PAREN
	| expr NOT? (LIKE) expr
	| expr ( IS | NULL | NOT NULL)
	| expr IS NOT? expr;

function_expr:
	WORD LEFT_PAREN (expr ( COMMA expr)*)? RIGHT_PAREN;

literal_value:
	MINUS NUMERIC_LITERAL
	| NUMERIC_LITERAL
	| STRING_LITERAL
	| NULL;

moca_variable:
	moca_at_variable
	| moca_at_minus_variable
	| moca_environment_variable
	| moca_keep_directive
	| moca_onstack_directive
	| moca_type_cast_variable
	| moca_integration_variable;

moca_plus_variable:
	moca_at_plus_variable
	| moca_at_mod_variable
	| moca_oldvar_directive
	| moca_database_qualifier_variable;

moca_at_variable: AT WORD; // @variable
moca_environment_variable: AT AT WORD; // @@variable
moca_at_minus_variable: AT MINUS WORD; // @-variable
moca_at_plus_variable: AT PLUS WORD; // @+variable
moca_at_mod_variable: AT MOD WORD; // @%variable
moca_at_star: AT STAR; // @*
moca_at_question: AT QUESTION; // @?
moca_at_bang: AT BANG; //@!

moca_keep_directive:
	moca_at_keep_directive
	| moca_at_minus_keep_directive;
moca_at_keep_directive:
	moca_at_variable POUND 'keep'; // @variable#keep
moca_at_minus_keep_directive:
	moca_at_minus_variable POUND 'keep'; // @-variable#keep
moca_at_plus_keep_directive: // DOES NOT SEEM TO BE VALID
	moca_at_plus_variable POUND 'keep'; // @+variable#keep
moca_at_mod_keep_directive: // DOES NOT SEEM TO BE VALID
	moca_at_mod_variable POUND 'keep'; // @%variable#keep

moca_onstack_directive:
	moca_at_variable POUND 'onstack'; // @variable#onstack
moca_ignore_directive: // ONLY VALID IN SQL
	moca_at_variable POUND 'ignore'; // @variable#ignore

moca_oldvar_directive:
	moca_at_plus_oldvar_directive
	| moca_at_mod_oldvar_directive;
moca_at_plus_oldvar_directive:
	moca_at_plus_variable CARET WORD; // @+newvariable^oldvariable
moca_at_mod_oldvar_directive:
	moca_at_mod_variable CARET WORD; // @%newvariable^oldvariable

moca_type_cast_variable:
	moca_at_variable COLON WORD
	| moca_at_plus_variable COLON WORD; // @variable:raw

moca_database_qualifier_variable:
	moca_at_plus_variable DOT WORD; // @+tablename.variable

moca_integration_variable: COLON WORD;

moca_remote_keyword: | REMOTE | PARALLEL | INPARALLEL;

sql_script: SINGLE_BRACKET_STRING;
groovy_script: DOUBLE_BRACKET_STRING;

// LEXER ---------------------------------------------------------

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LESS: '<';
GREATER: '>';
LESS_EQUAL: '<=';
GREATER_EQUAL: '>=';
DOUBLE_LESS: '<<';
DOUBLE_GREATER: '>>';
PLUS: '+';
MINUS: '-';
STAR: '*';
DIV: '/';
MOD: '%';
BACKSLASH: '\\';
AMPERSAND: '&';
CARET: '^';
BANG: '!';
QUESTION: '?';
COLON: ':';
SEMI_COLON: ';';
COMMA: ',';
PIPE: '|';
DOUBLE_PIPE: '||';
POUND: '#';
AT: '@';
EQUAL: '=';
NOT_EQUAL: '!=' | '<>';
DOT: '.';

DOUBLE_BRACKET_STRING: '[[' .*? ']]';
SINGLE_BRACKET_STRING: '[' .*? ']';

MOCA_INTEGRATOR_OVERSTACKED_ARGS: '<<OVERSTACKED_ARGS>>';

WHERE: W H E R E;
AND: A N D;
LIKE: L I K E;
OR: O R;
IS: I S;
NOT: N O T;
NULL: N U L L;
IF: I F;
ELSE: E L S E;
TRY: T R Y;
CATCH: C A T C H;
FINALLY: F I N A L L Y;
REMOTE: R E M O T E;
PARALLEL: P A R A L L E L;
INPARALLEL: I N P A R A L L E L;

WORD: [a-zA-Z_] [a-zA-Z_0-9]*;

NUMERIC_LITERAL:
	DIGIT+ ('.' DIGIT*)? (E [-+]? DIGIT+)?
	| '.' DIGIT+ ( E [-+]? DIGIT+)?;

STRING_LITERAL: (
		'\'' ( ~'\'' | '\'\'')* '\''
		| '"' ( ~'"' | '""')* '"'
	);

BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

WHITESPACE: [ \t]+ -> channel(HIDDEN);

NEWLINE: ( '\r' '\n'? | '\n') -> channel(HIDDEN);

fragment DIGIT: [0-9];

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];
