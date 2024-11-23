grammar Parser;

@header {    // Define name of package for generated Java files. 
    package generated;
}

// Syntax Specification ==> Context-free Grammar
start: methodDef* mainDecl methodDef*;

stmt: assign
    | declare
    | update
    | arrayUpdate 
    | ifstmt
    | whilestmt
    | methodCall ';'
    | return
    ;

expr:
    '(' expr ')'
    | '-' expr // handle negative ints
    | expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | expr ('>' | '<' |'==') expr
    | (INT | FLOAT | ID | BOOL | STRING | CHAR)
    | methodCall
    | arrayAccess
    | dot
    ;


mainDecl : 'void' 'main' '(' ')' '{' stmt* '}' ;

declare: TYPE ID ';' ;

assign: TYPE ID '=' (expr | 'new' TYPE '[' expr ']' | '{' expr (',' expr)* '}') ';';

update: ID '=' (expr | 'new' TYPE '[' expr ']' | '{' expr (',' expr)* '}') ';';

ifstmt: 'if' '(' expr ')' ('{' stmt* '}' | stmt* ) elsePart?;

elsePart: 'else' ('{' stmt* '}' | stmt* );

whilestmt: 'while' '(' expr ')'('{' stmt* '}' | stmt* );

arrayAccess: ID '[' expr ']' ;
arrayUpdate: ID '[' expr ']' '=' expr ';' ;

dot: ID '.' ID;

methodCall: ID '(' (expr (',' expr)*)? ')';
methodDef: TYPE ID '(' (TYPE ID (',' TYPE ID)*)? ')' '{' stmt* '}';

return: 'return' expr? ';';

// Lexer Specification ==> Regular Expressions Only non-trivial expressions. Trivial token
// definitions are hard coded in grammar.
INT: '0' | (('1' ..'9') ('0' ..'9')*);
FLOAT: '0.0' | (( '0' | ('1' ..'9')('0' ..'9')*) '.' ('0' ..'9')*);
ID: ('a' ..'z' | 'A' ..'Z')+;
BOOL: 'true' | 'false';

// Only allowing the characters as specified in the OFP specification
STRING: '"' ( 'a' ..'z' | 'A' ..'Z' | ' ' | '!' | '.' | ',' | '?' | '=' | ';' | '(' | ')' )* '"';
CHAR: '\'' ( 'a' ..'z' | 'A' ..'Z' | ' ' | '!' | '.' | ',' | '?' | '=' | ';' | '(' | ')' )*'\'';

WS: [ \t\r\n]+ -> skip;
TYPE: ' '? ('int' | 'float' | 'bool' | 'string' | 'char' | 'int[]' | 'float[]' | 'char[]') ' '?;


COMMENT: '#' ~('\r'|'\n')* -> skip;

