package token;

public class Soma implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '+'){
            return new Token("SOMA", "+", 1);
        }
        return null;
    }
}
