package tradutor;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.awt.SystemColor;

public class InterfaceTradutor {

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
					InterfaceTradutor window = new InterfaceTradutor();
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
       
       String codigo = "";
       
       while(true){
           Matrix matrix = lexer.yylex();
           if(matrix == null){
               
        	   textArea_1.setText(resultado);
        	   textArea_2.setText("Total de Palavras Reconhecidas e Traduzidas: "+ cont + "\n");
        			   				/*"Total de Palavras Reservadas: "+ cont_reser + "\n" +
        			   				"Total de Palavras Identificadas como Variaveis: "+ cont_var + "\n" +
        			   				"Total de Operadores Aritmeticos: "+ cont_opar + "\n" +
        			   				"Total de Operadores Logicos: "+ cont_oplo + "\n" +
        			   				"Total de Operadores de Atribuicao: "+ cont_at + "\n" +
        			   				"Total de Operadores Condicao: "+ cont_con + "\n" +
        			   				"Total de Separadores: "+ cont_sep + "\n" +
        			   				"Total de Palavras nao Reconhecidas: "+ cont_erro + "\n");*/
                return;
           }
                
                
       
               switch(matrix){
                
               case CIN:
                	resultado = resultado +  lexer.lexeme + "--->cin " + "\n";
                	codigo = codigo + "->cin>> " + " ";
                    break;
                case COUT:
                	resultado = resultado +  lexer.lexeme + "--->cout " + "\n";
                	codigo = codigo + "cout<<" + " ";
                     break;
                case IF:
                	resultado = resultado +  lexer.lexeme + "--->if " + "\n";
                	codigo = codigo + "\n" + "" + "if" + " ";
                      break;
                case WHILE:
                	resultado = resultado +  lexer.lexeme + "--->while " + "\n";
                	codigo = codigo + "\n" + "" + "while" + " ";
                      break;
                case FOR:
                	resultado = resultado +  lexer.lexeme + "--->for " + "\n";
                	codigo = codigo + "\n" + "" + "for" + " ";  
                	break;
                case MAIN:
                	resultado = resultado +  lexer.lexeme + "--->int main() " + "\n";
                	codigo = codigo + "int main() {" + "\n";
                      break;
                case ABREPARENTESES:
                	resultado = resultado +  lexer.lexeme + "--->( " + "\n";
                	codigo = codigo + "( " + " ";
                    break;
                case FECHAPARENTESES:
                	resultado = resultado +  lexer.lexeme + "--->) " + "\n";
                	codigo = codigo + ") " + "\n";
                    break;
                case ABRECOLCHETES:
                	resultado = resultado +  lexer.lexeme + "--->{ " + "\n";
                	codigo = codigo + "{ " + "\n";
                    break;
                case FECHACOLCHETES:
                	resultado = resultado +  lexer.lexeme + "--->} " + "\n";
                	codigo = codigo + "\n" + " }" + " ";
                    break;
                case BOOL:
                	resultado = resultado +  lexer.lexeme + "--->bool " + "\n";
                	codigo = codigo + "bool " + " ";
                    break;
                case MAIS:
                	resultado = resultado +  lexer.lexeme + "--->+ " + "\n";
                	codigo = codigo + " + " + " ";
                    break;
                case MENOS:
                	resultado = resultado +  lexer.lexeme + "--->- " + "\n";
                	codigo = codigo + "-" + " ";
                    break;
                case MULT:
                	resultado = resultado +  lexer.lexeme + "--->* " + "\n";
                	codigo = codigo + " * " + " ";
                    break;
                 case ERROR:
                    resultado = resultado +  "--ERRO, SIMBOLO NÃO RECONHECIDO-- \n";
                    cont-= 1;
                     break;
                case LITERAL:
                    resultado = resultado +  "--LITERAL-- " + lexer.lexeme +"\n";
                    codigo = codigo + lexer.lexeme + " ";
                    break;
                case NUMERO:
                	resultado = resultado +  lexer.lexeme + "->Numero " + "\n";
                	codigo = codigo + lexer.lexeme + " ";
                    break;
                case VARIAVEL:
                	resultado = resultado +  lexer.lexeme + "--->Variavel " + "\n";
                	codigo = codigo + lexer.lexeme + " ";
                    break;
                case PONTOEVIRGULA:
                	resultado = resultado + lexer.lexeme + "--->; " + "\n";
                	codigo = codigo + ";" + "";
                    break;
                case ATRIBUICAO:
                	resultado = resultado +  lexer.lexeme + "--->= " + "\n";
                	codigo = codigo + " =" + " ";
                    break;
                case MENOR:
                	resultado = resultado +  lexer.lexeme + "--->< " + "\n";
                	codigo = codigo + " <" + " ";
                    break;
                case CHAR:
                	resultado = resultado +  lexer.lexeme + "--->char " + "\n";
                	codigo = codigo + "char " + " ";
                    break;
                case INT:
                	resultado = resultado +  lexer.lexeme + "--->int " + "\n";
                	codigo = codigo + "int " + " ";
                    break;
                case DIFERENTE:
                	resultado = resultado +  lexer.lexeme + "--->!= " + "\n";
                	codigo = codigo + " !=" + " ";
                    break;
                case DIV:
                	resultado = resultado +  lexer.lexeme + "--->/ " + "\n";
                	codigo = codigo + " /" + " ";
                    break;
                case COMENTARIO:
                	resultado = resultado +  lexer.lexeme + "-->// " + "\n";
                	codigo = codigo + "// " + " ";
                    break;
                case E:
                	resultado = resultado +  lexer.lexeme + "--->& " + "\n";
                	codigo = codigo + "& " + " ";
                    break;
                default:
                    resultado = resultado + "<" + lexer.lexeme +">" ;
                   
            
           
           }
               cont+= 1;
               geraArquivo(codigo);
       }
       
       
       
    }
    
    private void geraArquivo(String conteudo) {  
        try {  
            FileWriter writer = new FileWriter(new File("C:/Users/Lixo/Documents/Trabalho_Compilador/AnalisadorLexico/src/tradutor/codigo.txt"));    
            PrintWriter saida = new PrintWriter(writer);  
            saida.print(conteudo);  
            saida.close();    
            writer.close();  
            //System.out.println("Arquivo criado com sucesso!");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
} 
    
    public void preencherTotalizador(){
    	//textArea_2.setText("Total de palavras reservadas: "+ cont);
    	
    }
    /*
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
    	
    }*/
    /*
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
	
}*/
    
    public void executar2()throws Exception{
        
        /*
        
        int cont = 0;
        jText = textArea;
        String expr;
        expr = (String)jText.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        
        String resultado="";
        
        while(true){
            Matrix matrix = lexer.yylex();
            if(matrix == null){
                
            	textArea.setText(resultado);
                 return;
            }
                 
                 
        
                switch(matrix){
                 
                 case CIN:
                 	resultado = resultado + cont + "-cin-> " + lexer.lexeme + "\n";
                     break;
                 case COUT:
                  	resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                      break;
                 case IF:
                   	resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                       break;
                 case WHILE:
                   	resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                       break;
                 case FOR:
                   	resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                       break;
                 case MAIN:
                   	resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                       break;
                 case ARITMETICO:
                     resultado = resultado + cont + "-- "  + lexer.lexeme + "\n";
                     break;
                 case LOGICO:
                     resultado = resultado + cont + "-- "  + lexer.lexeme + "\n";
                     break;
                 case ATRIBUICAO:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                     break;
                 case CONDICAO:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                     break;
                 case BOOL:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                     break;
                 case MAIS:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                     break;
                 case MENOS:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
                     break;
                 case MULT:
                     resultado = resultado + cont + "-- " + lexer.lexeme + "\n";
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
        
       */
        
     }
	
	public InterfaceTradutor() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 854, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAnalisadorLxicoLinguagem = new JLabel("Tradutor - Matrix para C++");
		lblAnalisadorLxicoLinguagem.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAnalisadorLxicoLinguagem.setBounds(290, 11, 265, 26);
		frame.getContentPane().add(lblAnalisadorLxicoLinguagem);
		
		JButton btnNewButton = new JButton("Traduzir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		            executar();
		            //salvaRTF();
		            //salvaRTFCompilado();
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
		
		Label label_1 = new Label("Resultado da traducao");
		label_1.setFont(new Font("Arial", Font.BOLD, 13));
		label_1.setBounds(438, 332, 147, 22);
		frame.getContentPane().add(label_1);
		
		textArea = new TextArea();
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setBounds(27, 43, 380, 412);
		frame.getContentPane().add(textArea);
		
		textArea_1 = new TextArea();
		textArea_1.setForeground(Color.MAGENTA);
		textArea_1.setBounds(438, 43, 380, 283);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new TextArea();
		textArea_2.setBounds(438, 358, 380, 97);
		frame.getContentPane().add(textArea_2);
	}
}
