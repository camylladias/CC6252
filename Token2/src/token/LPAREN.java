package token;

public class LPAREN implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '('){
            return new Token("LPAREN", "(", 1);
        }
        return null;
    }
}
