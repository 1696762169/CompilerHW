grammar CMinusMinus;

// 词法定义
INT : 'int' ;
VOID : 'void' ;
IF : 'if' ;
ELSE : 'else' ;
WHILE : 'while' ;
RETURN : 'return' ;
ID : [a-zA-Z][a-zA-Z0-9]*;
NUM : [0-9]+ ;
ASSIGN : '=' ;
PLUS : '+' ;
MINUS : '-' ;
MULTIPLY : '*' ;
DIVIDE : '/' ;
EQUALS : '==' ;
GREATER : '>' ;
GREATER_EQUALS : '>=' ;
LESS : '<' ;
LESS_EQUALS : '<=' ;
NOT_EQUALS : '!=' ;
SEMICOLON : ';' ;
COMMA : ',' ;
COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
LEFT_PAREN : '(' ;
RIGHT_PAREN : ')' ;
LEFT_BRACE : '{' ;
RIGHT_BRACE : '}' ;
LEFT_BRACKET : '[' ;
RIGHT_BRACKET : ']' ;
WS : [ \t\r\n]+ -> skip ;

// 语法定义
program : declaration*;

declaration : INT ID declarationType
            | VOID ID functionDeclaration
            ;

declarationType : variableDeclaration
                | functionDeclaration
                | arrayDeclaration
                ;

variableDeclaration : SEMICOLON ;

functionDeclaration : LEFT_PAREN parameterList RIGHT_PAREN block ;

arrayDeclaration : LEFT_BRACKET (NUM)+ (LEFT_BRACKET (NUM)+ RIGHT_BRACKET)* ;

parameterList : parameter (COMMA parameter)*
              | VOID
              ;

parameter : INT ID ;

block : LEFT_BRACE innerDeclaration* statement* RIGHT_BRACE ;

innerDeclaration : variableDeclaration SEMICOLON
                 | INT ID
                 ;

statement : ifStatement
          | whileStatement
          | returnStatement
          | assignmentStatement
          ;

assignmentStatement : ID ASSIGN expression
                    | array ASSIGN expression SEMICOLON
                    ;

returnStatement : RETURN expression? SEMICOLON ;

whileStatement : WHILE LEFT_PAREN expression RIGHT_PAREN block ;

ifStatement : IF LEFT_PAREN expression RIGHT_PAREN block (ELSE block)?;

expression : additiveExpression (relop additiveExpression)* ;

additiveExpression : term (PLUS term | MINUS term)* ;

term : factor (MULTIPLY factor | DIVIDE factor)* ;

factor : NUM
       | LEFT_PAREN expression RIGHT_PAREN
       | ID ftype
       | array
       ;

ftype : call?
      | // Empty
      ;

call : LEFT_PAREN argument RIGHT_PAREN ;

array : ID LEFT_BRACKET expression RIGHT_BRACKET
      | array LEFT_BRACKET expression RIGHT_BRACKET
      ;

argument : expression (COMMA expression)*
         | // Empty
         ;


relop : LESS
      | LESS_EQUALS
      | GREATER
      | GREATER_EQUALS
      | EQUALS
      | NOT_EQUALS
      ;
