grammar LProj;

MLN_COMMENT: BlockComment -> channel(HIDDEN) ;
SLN_COMMENT: LineComment  -> channel(HIDDEN) ;

fragment BlockComment   : '/*'  .*? ('*/' | EOF) ;
fragment LineComment    : '//' ~[\r\n]* ( '\r'? '\n' [ \t]* '//' ~[\r\n]* )*  ;

lproj
   : elements
   ;

elements
   :  (pair)*
   ;

pair
   :  key=STRING '=' value=STRING ';'
   ;


STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;

fragment ESC
   : '\\' (UNICODE | .)
   ;


fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;


fragment HEX
   : [0-9a-fA-F]
   ;


fragment SAFECODEPOINT
   : ~["\\\u0000-\u001F]
   | '\n'
   | '\r'
   | '\t'
   ;

WS
   : [ \t\n\r] + -> skip
   ;
