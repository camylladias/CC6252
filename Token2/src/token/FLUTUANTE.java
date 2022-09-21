package token;

public class FLUTUANTE implements AFD{
    private char atual;
    private int pos;
    private String texto;
    
    public String getInteger(){
        String resultado="";
        while(atual != '?' && Character.isDigit(atual)){
            resultado += atual;
            atual = texto.charAt(pos);
        }
        return resultado;
    }
    
    @Override
    public Token processa(int pos, String texto){
        atual = texto.charAt(pos);
        String numeroChar = getInteger();
        int tamanho = numeroChar.length();
        
        if(Character.isDigit(atual)){
            return new Token("INTEGER", numeroChar, tamanho);
        }
        return null;
    }
}