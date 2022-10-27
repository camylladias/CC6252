package token;

public class Divide implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '/'){
            return new Token("DIVIDE", "/", 1);
        }
        return null;
    }
}

