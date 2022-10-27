package token;

public class Multiplica implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '*'){
            return new Token("MULTIPLICA", "*", 1);
        }
        return null;
    }
}
