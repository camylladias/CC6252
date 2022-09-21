package token;

public class RCHAVE implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '}'){
            return new Token("RCHAVE", "}", 1);
        }
        return null;
    }
}
