package tradutor;


import static tradutor.Matrix.*;
%%
%class Lexer
%type Matrix

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

( "++" )    {lexeme = yytext(); return MAIS;}

( "--" )    {lexeme = yytext(); return MENOS;}

( "**" )    {lexeme = yytext(); return MULT;}

( "//" )    {lexeme = yytext(); return DIV;}


/* Operadores Lógicos */

("&&" )    {lexeme = yytext(); return E;}

("||" )    {lexeme = yytext(); return OU;}



/*Operadores Relacionais */

("#>" )   {lexeme = yytext(); return MAIOR;}

("<#" )   {lexeme = yytext(); return MENOR;}

("^^" )   {lexeme = yytext(); return IGUAL;}

("!!" )   {lexeme = yytext(); return DIFERENTE;}

(">^" )   {lexeme = yytext(); return MAIORIGUAL;}

("<^" )   {lexeme = yytext(); return MENORIGUAL;}


/* Operadores Atribuição */
( "~" )      {lexeme = yytext(); return ATRIBUICAO;}


/*Separadores */

( "@(" )      {lexeme = yytext(); return ABREPARENTESES;}

( "@)" )      {lexeme = yytext(); return FECHAPARENTESES;}

( "@{" )      {lexeme = yytext(); return ABRECOLCHETES;}

( "@}" )      {lexeme = yytext(); return FECHACOLCHETES;}

( ";" )      {lexeme = yytext(); return PONTOEVIRGULA;}

/* Caracteres Especiais */
/*(\b | "\t" | "\n" | "\f")   {lexeme = yytext(); return ESPECIAL;} */

/* Comentarios */
( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTARIO;}

/* palavras reservadas  */

(headin ) {lexeme = yytext(); return CIN;}

(headout ) {lexeme = yytext(); return COUT;}

(morpheu ) {lexeme = yytext(); return IF;}

(trinity ) {lexeme = yytext(); return WHILE;}

(smith ) {lexeme = yytext(); return FOR;}

(Oraculo ) {lexeme = yytext(); return MAIN;}

(red_pill ) {lexeme = yytext(); return ELSE;}

(_b ) {lexeme = yytext(); return BOOL;}

(_f ) {lexeme = yytext(); return FLOAT;}

(_i ) {lexeme = yytext(); return INT;}

(_s ) {lexeme = yytext(); return CHAR;}


{S}+{P}+{S}+ {lexeme=yytext(); return LITERAL;}
{S}+{L}+{G}+ {lexeme=yytext(); return LITERAL;}
{VAR}{L}({L}|{D})* {lexeme=yytext(); return VARIAVEL;}
 ("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

/*{VAR}({VAR}|{VAR})* {lexeme=yytext(); return VARIAVEL;}*/



. {return ERROR;}