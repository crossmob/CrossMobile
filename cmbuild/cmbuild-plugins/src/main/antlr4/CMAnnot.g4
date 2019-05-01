grammar CMAnnot;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip; // Match "//" stuff '\n' 
COMMENT : '/*' .*? '*/' -> skip; // Match "/*" stuff "*/"
WS : [ \t\r\n] -> skip ;

UI_APPEARANCE_SELECTOR : 'UI_APPEARANCE_SELECTOR' ->skip;
UIKIT_EXTERN : 'UIKIT_EXTERN' ->skip;
NULLABLE : '_Nullable' -> skip;
NONNULL : '_Nonnull' -> skip;
EXTERN : 'extern' -> skip;
ONEWAY : 'oneway' -> skip;
UNSIGNED : 'unsigned' -> skip;
KINDOF : '__kindof' -> skip;

ID : [a-zA-Z_][a-zA-Z_0-9]* ;
VERSION : [0-9] '_' [0-9];
NUM : INT | HEX;
fragment HEX : '0x' INT;
fragment INT : '-'? [0-9]+;


classdef : classtype=('@interface'|'@protocol') classname=ID ('(' category=ID ')' )? inheritance?  method* '@end';


protinheritance : '<' inh=ID (',' inh=ID)* '>';
inheritance : ':' classname=ID protinheritance? ;

method
    : property
    | selector;

property 
    : objc='@property' variable  ';'
    | objc='@property' '(' propertydef (',' propertydef)* ')' variable  ';'
    | variable ';'
    ;

propertydef
    : 'atomic'
    | 'nonatomic'
    | 'readwrite'
    | clazz='class'
    | strong='retain'
    | strong='strong'
    | weak='assign'
    | weak='weak'
    | copy='copy'
    | readonly='readonly'
    | 'getter' '=' getter=ID
    ;

cparts
    : func
    | extconst;

func
    : constant='const'? vartype name=ID '(' listofvariables ')' ';';

extconst : constant='const'? vartype name=ID ;

selector 
    : returntype (name=ID|retain='retain') (selectorParam selectorNamedParam*)? (',' varargs='...')? ';';


selectorNamedParam : paramname=ID? selectorparam=selectorParam;
selectorParam : ':' '(' vartype ')' variablename=ID;

returntype : isstatic=('+' | '-') '(' vartype ')' ;

listofvariables 
    : var_type_name (',' var_type_name)*
    | voidTK=ID
    |
    ;

var_type_name : vartype varname=ID (s3='[' ']')? (',' varargs='...')? ;

variable : vartype ID;

vartype 
    :  block
    | constant='const'? type=ID '<' vartype (',' vartype)*'>' s1='*'? s2='*'?
    | constant='const'? type=ID ID? s1='*'? s2='*'?
    | 'id<' protocol=ID (',' protocol=ID )* '>';

block : constant='const'? simple_vartype_name '(' '^' ID? ')' '(' simple_vartype_name  (',' simple_vartype_name )* ')';

simple_vartype_name : simple_vartype name=ID?;

simple_vartype
    : constant='const'? type=ID '<' simple_vartype (',' simple_vartype)* '>' s1='*'? s2='*'?
    | constant='const'? 'id<' type=ID '>' s1='*'?
    | type=ID s1='*'?;


visibility
    : '@private'
    | '@public'
    | '@protected' 
    | '@package' 
    ;



