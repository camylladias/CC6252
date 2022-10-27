package token;

public class LCHAVE implements AFD{
    @Override
    public Token processa(int pos, String texto){
        char atual = texto.charAt(pos);
        if(atual == '{'){
            return new Token("LCHAVE", "{", 1);
        }
        return null;
    }
}
