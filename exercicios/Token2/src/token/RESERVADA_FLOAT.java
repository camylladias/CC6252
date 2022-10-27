package token;

public class RESERVADA_FLOAT implements AFD{
    private char atual;
    
    public String getString(){
        String resultado="";
        while(atual != '?' && Character.isAlphabetic(atual)){
            resultado += atual;
        }
        return resultado;
    }
    
    @Override
    public Token processa(int pos, String texto){
        atual = texto.charAt(pos);
        if(Character.isAlphabetic(atual)){
                return new Token("RESERVADA_FLOAT", getString(), getString().length());
            }
        return null;
    }
}