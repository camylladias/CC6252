package token;

public class Integer implements AFD{
    private char atual;
    private int pos;
    private char texto;
    public String getInteger(){
        String resultado="";
        while(atual != '?' && Character.isDigit(atual)){
            resultado += atual;
            atual = texto.charAt(pos);
            System.out.println(resultado);
        }
        return resultado;
    }
    
    @Override
    public Token processa(int pos, String texto){
        atual = texto.charAt(pos);
        if(Character.isDigit(atual)){
            return new Token("INTEGER", getInteger(), getInteger().length());
        }
        return null;
    }
}