package sintatico;

import java.io.File;

public class Gerador {
   
	
	public static void main(String[] args) {
	
		String path = "C:/Users/Lixo/Documents/Trabalho_Compilador/AnalisadorLexico/src/sintatico/";		
		String arquivo = path + "linguagem.lex";
	    
	    File file = new File(arquivo );        
	    jflex.Main.generate(file);
	    
	}		
	
}
