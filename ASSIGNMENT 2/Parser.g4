grammar Parser;

@header {
    package generated;
}

prog : functionDecl* main functionDecl* ;

stmt : functionCall ';'                                                         #functionCallStmt
     | decl                                                                     #VarDecl
     | assign                                                                   #VarAssignStmt
     | arrayAssign                                                              #arrayAssignStmt
     | 'if' '(' expr ')' block  ( 'else' block )?                               #ifStmt
     | 'while' '(' expr ')' block                                               #whileStmt
     | returnStmt                                                               #return
     | printStmt                                                                #print
     ;

main : 'void' 'main' '(' ')' block ;

functionDecl : ( TYPE | 'void' ) ID '(' (TYPE ID ( ',' TYPE ID )* )? ')' block ;

functionCall : ID '(' ( expr ( ',' expr )* )? ')' ;

decl : TYPE ID ( '=' expr )? ';' ;

arrayInit : 'new' TYPE '[' expr ']' | '{' ( expr ( ',' expr )* )? '}' ;

arrayVar : ID '[' expr ']' ;

assign : ID '=' expr ';' ;

arrayAssign : arrayVar '=' expr ';' ;

block : stmt* | '{' stmt* '}' ;

printStmt : ( 'print' | 'println' ) '(' expr? ')' ';' ;

returnStmt : 'return' expr ';' ;

expr : '(' expr ')'                                                                       #parenthesesExpr
     | '-' expr                                                                           #UnaryExpr               // unary operator for numerals
     | expr '.' 'length'                                                                  #LengthExpr
     | expr ( '*' | '/' ) expr                                                            #MultExpr
     | expr ( '+' | '-' ) expr                                                            #AddSubExpr
     | expr ( '<' | '>' | '==') expr                                                      #ComparisonExpr
     | functionCall                                                                       #FunctionCallExpr
     | arrayInit                                                                          #arrayDecl
     | arrayVar                                                                           #ArrayAccessExpr
     | ID                                                                                 #idExpr
     | INT                                                                                #intExpr
     | FLOAT                                                                              #floatExpr
     | BOOL                                                                               #boolExpr
     | STRING                                                                             #stringExpr
     | CHAR                                                                               #charExpr 
     ;

//lexer
INT : '0' | ( '1'..'9' ) ( '0'..'9' )* ;
FLOAT : '0.0' | ( '0' | ( '1'..'9' ) ( '0'..'9' )* ) '.' ( '0'..'9' )* ;

BOOL : 'true' | 'false' ;

STRING : '"' ( 'a'..'z' | 'A'..'Z' | '!' | '.' | ',' | '?' | '=' | ':' | '(' | ')' | ' ' )* '"' ;
CHAR : '\'' ( 'a'..'z' | 'A'..'Z' | '!' | '.' | ',' | '?' | '=' | ':' | '(' | ')' | ' ' | '"' )* '\'' ;

ID  : ( 'a'..'z' | 'A'..'Z' )+ ;

TYPE : ' '* ( 
     'int' | 'float' | 'bool' | 'string' | 'char' |
     'int[]' | 'float[]' | 'char[]' 
     ) ' '* ;

WS : [ \t\r\n]+ -> skip ;
LINE_COMMENT : '#' (~[\r\n])* -> skip ;