grammar CMinusMinus;

// 词法定义
INT : 'int' ;   // 变量类型只有int
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
COMMENT : '/*' .*? '*/' -> skip ;   // skip表示跳过与之匹配的内容 不生成TOKEN
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
// 声明
declaration : variableDeclaration
            | functionDeclaration
            | arrayDeclaration
            ;
// 变量声明（不可赋初值）
variableDeclaration : INT ID SEMICOLON ;
// 函数声明
functionDeclaration : INT ID LEFT_PAREN parameterList RIGHT_PAREN block
                    | VOID ID LEFT_PAREN parameterList RIGHT_PAREN block;
// 数组声明
arrayDeclaration : INT ID LEFT_BRACKET NUM RIGHT_BRACKET (LEFT_BRACKET NUM RIGHT_BRACKET)* SEMICOLON;
// 参数列表（不能为空，只能写void）
parameterList : parameter (COMMA parameter)*
              | VOID
              ;
// 参数
parameter : INT ID ;
// 语句块（不能省略大括号）
block : LEFT_BRACE (innerDeclaration | statement)* RIGHT_BRACE ;
// 内部声明
innerDeclaration : variableDeclaration
                 | arrayDeclaration
                 ;
// 表达式语句
statement : ifStatement
          | whileStatement
          | returnStatement
          | assignmentStatement
          ;
// 赋值语句
assignmentStatement : ID ASSIGN expression SEMICOLON
                    | array ASSIGN expression SEMICOLON
                    ;
// 返回语句
returnStatement : RETURN expression? SEMICOLON ;
// while语句
whileStatement : WHILE LEFT_PAREN expression RIGHT_PAREN block ;
// if语句
ifStatement : IF LEFT_PAREN expression RIGHT_PAREN block (ELSE block)?;
// 比较表达式
expression : additiveExpression (relop additiveExpression)? ;
// 加减表达式
additiveExpression : multipleExpression (PLUS multipleExpression | MINUS multipleExpression)* ;
// 乘除表达式
multipleExpression : factor (MULTIPLY factor | DIVIDE factor)* ;

factor : NUM
       | LEFT_PAREN expression RIGHT_PAREN
       | ID call?
       | array
       ;
// 实参列表
call : LEFT_PAREN argument RIGHT_PAREN ;
// 实参
argument : expression (COMMA expression)*
         | // 空
         ;
// 数组元素
array : ID LEFT_BRACKET expression RIGHT_BRACKET
      | array LEFT_BRACKET expression RIGHT_BRACKET
      ;
// 比较运算符
relop : LESS
      | LESS_EQUALS
      | GREATER
      | GREATER_EQUALS
      | EQUALS
      | NOT_EQUALS
      ;
