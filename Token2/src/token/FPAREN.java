package token;

public class FPAREN implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == ')'){
            return new Token("FPAREN", ")", 1);
        }
        return null;
    }
}