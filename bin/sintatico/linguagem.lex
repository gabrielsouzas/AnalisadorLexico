package sintatico;

import java_cup.runtime.*;

%%

%{

private void log(String descricao, String lexema) {
	 System.out.println(lexema + " - " + descricao);
	 
}

%}

%cup
%public
%class AnalisadorLexico
%type java_cup.runtime.Symbol

BRANCO = [\n| |\t\r]
CONSTANTE_NUMERICA = 0|[1-9][0-9]*
VARIAVEL = [A-Za-z_][A-Za-z_0-9]*

%%

"oraculoini"	{ log("Palavra reservada", yytext()); return new Symbol(sym.ORACULOINI); }
"oraculofim"	{ log("Palavra reservada", yytext()); return new Symbol(sym.ORACULOFIM); }
"smith"			{ log("Palavra reservada", yytext()); return new Symbol(sym.SMITH); }
":"				{ log("Palavra reservada", yytext()); return new Symbol(sym.SEPARADOR); }


{CONSTANTE_NUMERICA} 	{ log("Constante numerica", yytext()); return new Symbol(sym.NUMERO); }
{VARIAVEL}				{ log("Variavel", yytext()); return new Symbol(sym.VARIAVEL); }
"**"					{ log("Operador de multiplicacao", yytext()); return new Symbol(sym.MULTIPLICACAO); }
"~" 					{ log("Sinal de atribuicao", yytext()); return new Symbol(sym.ATRIBUICAO); }

{BRANCO} {  }

. {  }

