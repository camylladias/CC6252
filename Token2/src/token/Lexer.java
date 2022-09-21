package token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String texto;
    private int pos;
    private char atual;
    private List<AFD> afds;

    
    public Lexer(String texto){
        this.texto = texto;
        pos = 0;
        atual = texto.charAt(0);
        afds = new ArrayList<>();
        afds.add(new Soma());
        afds.add(new Subtrai());
        afds.add(new Multiplica());
        afds.add(new Divide());
        afds.add(new LPAREN());
        afds.add(new FPAREN());
        afds.add(new Integer());
        afds.add(new ID());
    }
    
    public void erro(){
        throw new RuntimeException("caracter errado");
    }
    
    public void avancar(int qtde){
        pos+= qtde;
        if(pos > texto.length()-1){
            atual = '?';
        }else{
            atual = texto.charAt(pos);
        }
    }
    
    public void pularEspaco(){
        while(atual == ' '){
            avancar(1);
        }
    }
    
//    public String getInteger(){
//        String resultado="";
//        while(atual != '?' && Character.isDigit(atual)){
//            resultado += atual;
//            avancar(1);
//        }
//        return resultado;
//    }
//    
//    public String getString(){
//        String resultado="";
//        while(atual != '?' && Character.isAlphabetic(atual)){
//            resultado += atual;
//            avancar(1);
//        }
//        return resultado;
//    }
    
    public Token getNextToken(){
        while(atual != '?'){
            if(atual == ' '){
                pularEspaco();
                continue;
            }
            for(AFD afd : afds){
                Token reconhecido = 
                        afd.processa(pos, texto);
                if(reconhecido != null){
                    avancar(reconhecido.getLength());
                    return reconhecido;
                }
            }
            erro();
        }
        return new Token("EOF", "?", 1);
    }
}