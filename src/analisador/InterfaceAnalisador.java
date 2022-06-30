package analisador;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;

import javax.swing.JTextPane;

public class InterfaceAnalisador {

	private JFrame frame;
	private TextArea textArea;
	private TextArea textArea_1;
	private JTextPane textPane; 
	private TextArea textArea_2;
	  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAnalisador window = new InterfaceAnalisador();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
public TextArea jText;
    
    public void executar()throws Exception{
        
      
       
       int cont = 0;
       int cont_reser = 0;
       int cont_var = 0;
       int cont_opar = 0;
       int cont_oplo = 0;
       int cont_at = 0;
       int cont_con = 0;
       int cont_sep = 0;
       int cont_erro = 0;
       jText = textArea;
       String expr;
       expr = (String)jText.getText();
       Lexer lexer = new Lexer(new StringReader(expr));
       
       String resultado="";
       
       while(true){
           Token token = lexer.yylex();
           if(token == null){
               
        	   textArea_1.setText(resultado);
        	   textArea_2.setText("Total de Palavras Reconhecidas: "+ cont + "\n" +
        			   				"Total de Palavras Reservadas: "+ cont_reser + "\n" +
        			   				"Total de Palavras Identificadas como Variaveis: "+ cont_var + "\n" +
        			   				"Total de Operadores Aritmeticos: "+ cont_opar + "\n" +
        			   				"Total de Operadores Logicos: "+ cont_oplo + "\n" +
        			   				"Total de Operadores de Atribuicao: "+ cont_at + "\n" +
        			   				"Total de Operadores Condicao: "+ cont_con + "\n" +
        			   				"Total de Separadores: "+ cont_sep + "\n" +
        			   				"Total de Palavras nao Reconhecidas: "+ cont_erro + "\n");
                return;
           }
                
                
       
               switch(token){
                
               case RESERVADA:
                	resultado = resultado + cont + "--PALAVRA_RESERVADA-- " + lexer.lexeme + "\n";
                	cont_reser+= 1;
                    break;
                case ARITMETICO:
                    resultado = resultado + cont + "--OPERADOR_ARITMETICO-- "  + lexer.lexeme + "\n";
                    cont_opar+= 1;
                    break;
                case LOGICO:
                    resultado = resultado + cont + "--OPERADOR_LOGICO-- "  + lexer.lexeme + "\n";
                    cont_oplo+= 1;
                    break;
                case ATRIBUICAO:
                    resultado = resultado + cont + "--OPERADOR_ATRIBUIÇÃO-- " + lexer.lexeme + "\n";
                    cont_at+= 1;
                    break;
                case CONDICAO:
                	cont_con+= 1;
                	resultado = resultado + cont + "--OPERADOR_CONDIÇÃO-- " + lexer.lexeme + "\n";
                    break;
                case BOOLEANO:
                    resultado = resultado + cont + "--OPERADOR_BOOLEANO-- " + lexer.lexeme + "\n";
                    break;
                case SEPARADOR:
                    resultado = resultado + cont + "--SEPARADOR-- " + lexer.lexeme + "\n";
                    cont_sep+= 1;
                    break;
                case ESPECIAL:
                    resultado = resultado + cont + "--CARACTER_ESPECIAL-- " + lexer.lexeme + "\n";
                    break;
                case COMENTARIO:
                    resultado = resultado + cont + "--COMENTARIO-- " + lexer.lexeme + "\n";
                    break;
                 case ERROR:
                    resultado = resultado + cont + "--ERRO, SIMBOLO NÃO RECONHECIDO-- \n";
                    cont_erro+= 1;
                    cont-= 1;
                     break;
                case LITERAL:
                    resultado = resultado + cont + "--LITERAL-- " + lexer.lexeme +"\n";
                    break;
                case NUMERO:
                    resultado = resultado + cont + "--NUMERO-- " + lexer.lexeme + "\n";
                    break;
                case VARIAVEL:
                    resultado = resultado + cont + "--VARIAVEL-- " + lexer.lexeme + "\n";
                    cont_var+= 1;
                    break;
                default:
                    resultado = resultado + "<" + lexer.lexeme +">" ;
                   
            
           
           }
               cont+= 1;
       }
       
       
    }
    
    public void preencherTotalizador(){
    	//textArea_2.setText("Total de palavras reservadas: "+ cont);
    	
    }
    
    public void salvaRTF()throws Exception{
    	
    		String texto = textArea.getText();
    		RTF rtf = new RTF();
    		rtf.setTexto(texto);
    		rtf.colorirTextoAzul("Oraculo()");
    		rtf.colorirTextoVermelho("neo");
    		rtf.colorirTextoAzul("_i");
    		rtf.colorirTextoAzul("_f");
    		rtf.colorirTextoAzul("_b");
    		rtf.colorirTextoAzul("_l");
    		rtf.colorirTextoAzul("_s");
    		rtf.colorirTextoAzul("headin");
    		rtf.colorirTextoAzul("headout");
    		rtf.colorirTextoVermelho("morpheu");
    		rtf.colorirTextoVermelho("trinity");
    		rtf.colorirTextoVermelho("smith");
    		rtf.colorirTextoVermelho("blue_pill");
    		rtf.colorirTextoVermelho("red_pill");
    		rtf.salvaRTF("arquivoCodigo");

    		File docx = new File("C:/android-topicos-2015/workspace/AnalisadorLexico/arquivoCodigo.rtf");

    		try {
    			Desktop.getDesktop().open(docx);
    			//Runtime.getRuntime().exec("cmd /c start \\Trabalho\\Tpdejava\\javadoc\\autores.doc");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} //C:\android-topicos-2015\workspace\GistProjectColor\arquivoColorido");

    		//System.out.print(rtf.getTexto());
    	
    }
    
    public void salvaRTFCompilado()throws Exception{
    	
		String texto = textArea_1.getText();
		RTF rtf = new RTF();
		rtf.setTexto(texto);
		rtf.colorirTextoAzul("Oraculo");
		rtf.colorirTextoVermelho("neo");
		rtf.colorirTextoAzul("_i");
		rtf.colorirTextoAzul("_f");
		rtf.colorirTextoAzul("_b");
		rtf.colorirTextoAzul("_l");
		rtf.colorirTextoAzul("_s");
		rtf.colorirTextoAzul("headin");
		rtf.colorirTextoAzul("headout");
		rtf.colorirTextoVermelho("morpheu");
		rtf.colorirTextoVermelho("trinity");
		rtf.colorirTextoVermelho("smith");
		rtf.colorirTextoVermelho("blue_pill");
		rtf.colorirTextoVermelho("red_pill");
		rtf.salvaRTF("arquivoCompilado");
		
		File docx = new File("E:/Faculdade/arquivoCompilado.rtf");

		try {
			Desktop.getDesktop().open(docx);
			//Runtime.getRuntime().exec("cmd /c start \\Trabalho\\Tpdejava\\javadoc\\autores.doc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //C:\android-topicos-2015\workspace\GistProjectColor\arquivoColorido");

		//System.out.print(rtf.getTexto());
	
}
    
    public void executar2()throws Exception{
        
        
        
        int cont = 0;
        jText = textArea;
        String expr;
        expr = (String)jText.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        
        String resultado="";
        
        while(true){
            Token token = lexer.yylex();
            if(token == null){
                
            	textArea.setText(resultado);
                 return;
            }
                 
                 
        
                switch(token){
                 
                 case RESERVADA:
                 	resultado = resultado + cont + "--PALAVRA_RESERVADA-- " + lexer.lexeme + "\n";
                     break;
                 case ARITMETICO:
                     resultado = resultado + cont + "--OPERADOR_ARITMETICO-- "  + lexer.lexeme + "\n";
                     break;
                 case LOGICO:
                     resultado = resultado + cont + "--OPERADOR_LOGICO-- "  + lexer.lexeme + "\n";
                     break;
                 case ATRIBUICAO:
                     resultado = resultado + cont + "--OPERADOR_ATRIBUIÇÃO-- " + lexer.lexeme + "\n";
                     break;
                 case CONDICAO:
                     resultado = resultado + cont + "--OPERADOR_CONDIÇÃO-- " + lexer.lexeme + "\n";
                     break;
                 case BOOLEANO:
                     resultado = resultado + cont + "--OPERADOR_BOOLEANO-- " + lexer.lexeme + "\n";
                     break;
                 case SEPARADOR:
                     resultado = resultado + cont + "--SEPARADOR-- " + lexer.lexeme + "\n";
                     break;
                 case ESPECIAL:
                     resultado = resultado + cont + "--CARACTER_ESPECIAL-- " + lexer.lexeme + "\n";
                     break;
                 case COMENTARIO:
                     resultado = resultado + cont + "--COMENTARIO-- " + lexer.lexeme + "\n";
                     break;
                  case ERROR:
                     resultado = resultado + cont + "--ERRO, SIMBOLO NÃO RECONHECIDO-- \n";
                     cont-= 1;
                      break;
                 case LITERAL:
                     resultado = resultado + cont + "--LITERAL-- " + lexer.lexeme +"\n";
                     break;
                 case NUMERO:
                     resultado = resultado + cont + "--NUMERO-- " + lexer.lexeme + "\n";
                     break;
                 case VARIAVEL:
                     resultado = resultado + cont + "--VARIAVEL-- " + lexer.lexeme + "\n";
                     break;
                 default:
                     resultado = resultado + "<" + lexer.lexeme +">" ;
                    
             
            
            }
                cont+= 1;
        }
     }
	
	public InterfaceAnalisador() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAnalisadorLxicoLinguagem = new JLabel("Analisador L\u00E9xico - Linguagem Matrix");
		lblAnalisadorLxicoLinguagem.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 15));
		lblAnalisadorLxicoLinguagem.setBounds(231, 11, 387, 26);
		frame.getContentPane().add(lblAnalisadorLxicoLinguagem);
		
		JButton btnNewButton = new JButton("Compilar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		            executar();
		            salvaRTF();
		            salvaRTFCompilado();
		        }catch(Exception e){e.printStackTrace();}
			}
		});
		btnNewButton.setBounds(312, 488, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea_1.setText("");
			}
		});
		btnNewButton_1.setBounds(722, 488, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		Label label = new Label("C\u00F3digo");
		label.setFont(new Font("Arial", Font.PLAIN, 13));
		label.setBounds(27, 461, 62, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Resultado do Analisador");
		label_1.setFont(new Font("Arial", Font.PLAIN, 13));
		label_1.setBounds(438, 332, 147, 22);
		frame.getContentPane().add(label_1);
		
		textArea = new TextArea();
		textArea.setForeground(Color.RED);
		textArea.setBounds(27, 43, 380, 412);
		frame.getContentPane().add(textArea);
		
		textArea_1 = new TextArea();
		textArea_1.setForeground(Color.BLUE);
		textArea_1.setBounds(438, 43, 380, 283);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new TextArea();
		textArea_2.setBounds(438, 358, 380, 97);
		frame.getContentPane().add(textArea_2);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(438, 461, 200, 50);
		frame.getContentPane().add(label_2);
	}
}
