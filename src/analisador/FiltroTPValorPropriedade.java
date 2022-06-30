package analisador;

import java.awt.Color;  

import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.DocumentFilter;  
import javax.swing.text.SimpleAttributeSet;  
import javax.swing.text.StyleConstants;  
import javax.swing.text.StyleContext;  
  
public class FiltroTPValorPropriedade extends DocumentFilter{  
  
      
    private StyleContext sc = StyleContext.getDefaultStyleContext();  
      
    //Na hora de inserir um novo texto  
    public void insertString(FilterBypass fb, int offset, String string,  
            AttributeSet attr) throws BadLocationException {  
  
        for(String texto : string.split("\n")){  
            if(!texto.isEmpty())  
            super.insertString(fb, offset, texto + "\n", getAtributos(texto));            
              
        }  
    }  
  
  
    //Na hora de trocar o texto  
    public void replace(FilterBypass fb, int offset, int length, String text,  
            AttributeSet attrs) throws BadLocationException {  
  
        for(String texto : text.split("\n")){  
            if(!texto.isEmpty())  
            super.replace(fb, offset, length, texto + "\n", getAtributos(texto));             
              
        }  
          
    }  
      
    //Método em que a brincadeira toda acontece  
    private AttributeSet getAtributos(String text){  
          
        //Formatação do texto  
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, getColor(text));  
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");  
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);  
        return aset;  
    }  
      
    //Método para selecionar as cores baseado no texto que é passado  
    private Color getColor(String text){  
        if(text.contains("<nome>")){  
            return Color.blue;  
        }else if(text.contains("<imports>")){  
            return Color.RED;  
        }else if(text.contains("<valor>")){  
            return new Color(0,140,0);  
        }else if(text.contains("<tipo>")){  
            return new Color(0, 0, 150);  
        }  
        return Color.black;  
    }  
}  
