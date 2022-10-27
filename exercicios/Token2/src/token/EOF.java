package token;

public class EOF implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '?'){
                return new Token("EOF", "?", 1);
        }
        return null;
    }
}