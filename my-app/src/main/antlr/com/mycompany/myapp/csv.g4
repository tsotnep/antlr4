grammar csv;

//  P A R S E R
parse //when non capital letter, it uses this as grammar
    : line + EOF //+ is >= than 1 EOF = end of file
;

line
    : TEXT (',' TEXT)* '\n'//* zero or more
    | NUMBER (',' NUMBER)* '\n'
;

// L E X E R
TEXT //when capital leter, it means it uses this part as lexer
    : [a-zA-Z]+
;

NUMBER
    : [0-9]+
;

WS
    : [ \t]+ -> skip
;