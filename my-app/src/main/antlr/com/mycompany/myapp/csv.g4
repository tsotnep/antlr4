grammar csv;

//  P A R S E R
//* zero or more
//+ 1 or more
//EOF = end of file
//when capital leter, it means it uses this part as lexer
//when non capital letter, it means it uses this oart as grammar

parse
    : line + EOF
;

line
    : TEXT (',' TEXT)* '\n'
    | NUMBER (',' NUMBER)* '\n'
;

// L E X E R
TEXT
    : [a-zA-Z]+
;

NUMBER
    : [0-9]+
;

WS
    : [ \t]+ -> skip
;