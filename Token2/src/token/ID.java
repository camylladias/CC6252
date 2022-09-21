package token;

public class ID implements AFD{
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
                return new Token("ID", getString(), getString().length());
            }
        return null;
    }
}