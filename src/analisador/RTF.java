package analisador;

import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class RTF {
    private StringBuilder texto;
    public String getTexto() {
        return texto.toString();
    }
    public void setTexto(String texto2) {
        this.texto = criaRTF(texto2);
    }
    public StringBuilder criaRTF(String texto2){
        StringBuilder arquivortf = new StringBuilder("{\\rtf1\\ansi\\deff0\n");
                                    // \cf1 = Preto (cor padrao)      ;\cf2 = vermelho        ;\cf3 =  Azul
        arquivortf.append("{\\colortbl;\\red0\\green0\\blue0;\\red255\\green0\\blue0;\\red50\\green0\\blue255;}\n");
        arquivortf.append(texto2);
        arquivortf.append("\n}");
        return arquivortf;
    }
    public void colorirTextoAzul(String palavra)
    {
        //Colore com a cor Azul i.e \cf3
        String palavraColorida = "{\\cf3" + palavra + "}";
        int indice = texto.indexOf(palavra);
        while (indice != -1)
        {
            texto.replace(indice, indice + palavra.length(), palavraColorida);
            // vai ao fim da substituicao
            indice += palavraColorida.length();
            indice = texto.indexOf(palavra, indice);
        }
    }
    
    public void colorirTextoVermelho(String palavra)
    {
        //Colore com a cor Azul i.e \cf3
        String palavraColorida = "{\\cf2" + palavra + "}";
        int indice = texto.indexOf(palavra);
        while (indice != -1)
        {
            texto.replace(indice, indice + palavra.length(), palavraColorida);
            // vai ao fim da substituicao
            indice += palavraColorida.length();
            indice = texto.indexOf(palavra, indice);
        }
    }
    
    public void colorirTextoVerde(String palavra)
    {
        //Colore com a cor Azul i.e \cf3
        String palavraColorida = "{\\cf4" + palavra + "}";
        int indice = texto.indexOf(palavra);
        while (indice != -1)
        {
            texto.replace(indice, indice + palavra.length(), palavraColorida);
            // vai ao fim da substituicao
            indice += palavraColorida.length();
            indice = texto.indexOf(palavra, indice);
        }
    }
    
    
    
    
    public void salvaRTF(String nomeArquivo){
        try {
            PrintWriter saida = new PrintWriter(nomeArquivo + ".rtf");
            saida.println(texto);
            saida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

