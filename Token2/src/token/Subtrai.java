package token;

public class Subtrai implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '-'){
            return new Token("SUBTRAI", "-", 1);
        }
        return null;
    }
}
