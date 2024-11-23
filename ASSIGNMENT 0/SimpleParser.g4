/**
 * Define a grammar called Expressions
 */
grammar SimpleParser;

@header {    // Define name of package for generated Java files. 
    package generated;
}

// Syntax Specification ==> Context-free Grammar
//start: 'program Compute' '{' stmt* '}';
start: 'program ' ID '{' stmt* '}';

stmt:
    expr ';'
    | assign
    | declare
    | update
    | ifstmt
    | whilestmt
    | print;

expr:
    '(' expr ')'
    | expr ('*' | '/') expr
    | expr ('+' | '-') expr
    // Line below generated by AI
    | expr ('>' | '<' | '>=' | '<=' | '==' | '!=') expr
    | (INT | ID);

declare: TYPE ID ';';

assign: TYPE ID '=' expr ';';

update: ID '=' expr ';';

ifstmt: 'if' '(' expr ')' '{' stmt* '}' elsePart?;

elsePart: 'else' '{' stmt* '}';

whilestmt: 'while' '(' expr ')' '{' stmt* '}';

print: 'print' '(' ID ')' ';';

// Lexer Specification ==> Regular Expressions Only non-trivial expressions. Trivial token
// definitions are hard coded in grammar.
INT: ('0' ..'9')+;
ID: ('a' ..'z' | 'A' ..'Z')+;
WS: [ \t\r\n]+ -> skip;
TYPE: 'int' ' ';

// line below generated by AI
COMMENT: '//' (~[\r\n])* -> skip;