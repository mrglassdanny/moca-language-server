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
		block catch_multi_expr? redirect_expr?
		| if_statement else_if_statement* else_statement?
		| try_block catch_sequence* finally_sequence? redirect_expr?
	);

block: remote_expr? command | remote_expr? sub_sequence;

command: groovy_script | sql_script | verb_noun_clause;

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
		| KEEP
		| ONSTACK
	)+ (WHERE verb_noun_clause_args)?;

verb_noun_clause_args:
	verb_noun_clause_arg (AND verb_noun_clause_arg)*;

verb_noun_clause_arg:
	OVERSTACKED_ARGS
	| (at_star | plus_variable)
	| expr;

sub_sequence:
	LEFT_BRACE sequence RIGHT_BRACE
	| LEFT_BRACE sub_sequence RIGHT_BRACE;

if_expr: IF LEFT_PAREN expr* RIGHT_PAREN;
if_statement: if_expr statement;
else_if_statement: ELSE if_statement;
else_statement: ELSE statement;

try_block: TRY block;
catch_single_expr:
	CATCH LEFT_PAREN expr RIGHT_PAREN;
catch_multi_expr:
	CATCH LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN;
catch_sequence:
	catch_single_expr LEFT_BRACE sequence? RIGHT_BRACE;
finally_sequence: FINALLY LEFT_BRACE sequence RIGHT_BRACE;

redirect_expr: DOUBLE_GREATER WORD;

remote_expr:
	remote_keyword LEFT_PAREN expr RIGHT_PAREN;


expr:
	literal_value
	| WORD
	| variable
	| at_bang
	| at_question
	| at_star
	| function_expr
	| groovy_script
    | SINGLE_BRACKET_STRING
	| (
		BANG (
			literal_value
			| WORD
			| variable
			| at_bang
			| at_question
			| at_star
			| function_expr
			| expr
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

variable:
	at_variable
	| at_minus_variable
	| environment_variable
	| keep_directive
	| onstack_directive
	| type_cast_variable
	| integration_variable;

plus_variable:
	at_plus_variable
	| at_mod_variable
	| at_plus_keep_directive
	| at_mod_keep_directive
	| oldvar_directive
	| database_qualifier_variable;

at_variable: AT WORD; // @variable
environment_variable: AT AT WORD; // @@variable
at_minus_variable: AT MINUS WORD; // @-variable
at_plus_variable: AT PLUS WORD; // @+variable
at_mod_variable: AT MOD WORD; // @%variable
at_star: AT STAR; // @*
at_question: AT QUESTION; // @?
at_bang: AT BANG; //@!

keep_directive:
	at_keep_directive
	| at_minus_keep_directive;
at_keep_directive:
	at_variable POUND KEEP; // @variable#keep
at_minus_keep_directive:
	at_minus_variable POUND KEEP; // @-variable#keep
at_plus_keep_directive:
	at_plus_variable POUND KEEP; // @+variable#keep
at_mod_keep_directive:
	at_mod_variable POUND KEEP; // @%variable#keep

onstack_directive:
	at_variable POUND ONSTACK
	| at_minus_variable POUND ONSTACK; // @variable#onstack

oldvar_directive:
	at_plus_oldvar_directive
	| at_mod_oldvar_directive;
at_plus_oldvar_directive:
	at_plus_variable CARET WORD; // @+newvariable^oldvariable
at_mod_oldvar_directive:
	at_mod_variable CARET WORD; // @%newvariable^oldvariable

type_cast_variable:
	at_variable COLON WORD
	| at_plus_variable COLON WORD; // @variable:raw

database_qualifier_variable:
	at_plus_variable DOT WORD; // @+tablename.variable

integration_variable: COLON WORD;

remote_keyword: | REMOTE | PARALLEL | INPARALLEL;


groovy_script: DOUBLE_BRACKET_STRING;
sql_script: SINGLE_BRACKET_STRING;


// LEXER ---------------------------------------------------------

DOUBLE_BRACKET_STRING: LEFT_BRACKET LEFT_BRACKET .* RIGHT_BRACKET RIGHT_BRACKET;
SINGLE_BRACKET_STRING: LEFT_BRACKET .* RIGHT_BRACKET;

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
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

OVERSTACKED_ARGS: '<<OVERSTACKED_ARGS>>';

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

ONSTACK: O N S T A C K;
KEEP: K E E P;

NUMERIC_LITERAL:
	DIGIT+ ('.' DIGIT*)? (E [-+]? DIGIT+)?
	| '.' DIGIT+ ( E [-+]? DIGIT+)?;


STRING_LITERAL: (
		'\'' ( ~'\'' | '\'\'')* '\''
		| '"' ( ~'"' | '""')* '"'
	);

WORD: [a-zA-Z_0-9.]+;

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
