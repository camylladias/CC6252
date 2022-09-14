package token;

public class Lexer {
    String texto;
    int pos;
    char atual;
    
    public Lexer(String texto){
        this.texto = texto;
        pos = 0;
        atual = texto.charAt(0);
    }
    
    public void erro(){
        throw new RuntimeException("caracter errado");
    }
    
    public void avancar(){
        pos++;
        if(pos > texto.length()-1){
            atual = '?';
        }else{
            atual = texto.charAt(pos);
        }
    }
    
    public void pularEspaco(){
        while(atual == ' '){
            avancar();
        }
    }
    
    public Token getNextToken(){
        while(atual != '?'){
            if(atual == ' '){
                pularEspaco();
                continue;
            }
            if(atual == '+'){
                avancar();
                return new Token("SOMA", "+");
            }
            erro();
        }
        return new Token("EOF", "?");
    }
}
