/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tradutor;

import java.io.File;


public class Analisador {
    
    //Essa classe foi comentada pois ja foi gerada a classe lexer

    
     
	public static void gerarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
        
    }
    public static void main(String[] args) {
        String path = "C:/Users/Lixo/Documents/Trabalho_Compilador/AnalisadorLexico/src/tradutor/Lexer.flex";
        gerarLexer(path);
    }//*/
}