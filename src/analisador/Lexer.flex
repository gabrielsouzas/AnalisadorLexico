package analisador;


import static analisador.Token.*;
%%
%class Lexer
%type Token

S = ([\"])
G = ([\"])
P = (.)
VAR = (neo)
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/* Operadores Aritméticos */

( "++" | "--" | "**" | "//" | "%%" )    {lexeme = yytext(); return ARITMETICO;}

/* Operadores Lógicos */
("&&" | "||" | "!" | "&" | "|" )    {lexeme = yytext(); return LOGICO;}

/*Operadores Relacionais */
("#>" | "<#" | "^^" | "!!" | ">^" | "<^" | "<<" | ">>")   {lexeme = yytext(); return CONDICAO;}

/* Operadores Atribuição */
("+^" | "-^"  | "*^" | "/^" | "%^" | "+++" | "---" | "~")      {lexeme = yytext(); return ATRIBUICAO;}

/*Operadores Booleanos*/
(true | false)      {lexeme=yytext(); return BOOLEANO;}

/*Separadores */
( "/'[a-zA-Z]'/" | "\'[a-zA-Z]\'" | "<" | ">" |"@" | "@" | "|" | "(" | ")" | "{" | "}" | "[" | "]" | ";" | "," |  "." |  "\"")      {lexeme = yytext(); return SEPARADOR;}

/* Caracteres Especiais */
/*(\b | "\t" | "\n" | "\f")   {lexeme = yytext(); return ESPECIAL;} */

/* Comentarios */
( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTARIO;}

/* palavras reservadas  */
(headin | headout | morpheu | trinity | smith | Oraculo
 | blue_pill | red_pill  | _b | _by | _c | _d
 | _f | _i | _l | _s  ) {lexeme = yytext(); return RESERVADA;}


{S}+{P}+{S}+ {lexeme=yytext(); return LITERAL;}
{S}+{L}+{G}+ {lexeme=yytext(); return LITERAL;}
{VAR}{L}({L}|{D})* {lexeme=yytext(); return VARIAVEL;}
 ("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

/*{VAR}({VAR}|{VAR})* {lexeme=yytext(); return VARIAVEL;}*/



. {return ERROR;}