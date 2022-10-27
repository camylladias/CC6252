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
    
    public String getInteger(){
        String resultado="";
        while(atual != '?' && Character.isDigit(atual)){
            resultado += atual;
            avancar();
        }
        return resultado;
    }
    
    public String getString(){
        String resultado="";
        while(atual != '?' && Character.isAlphabetic(atual)){
            resultado += atual;
            avancar();
        }
        return resultado;
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
            if(atual == '-'){
                avancar();
                return new Token("SUBTRAI", "-");
            }
            if(atual == '*'){
                avancar();
                return new Token("MULTIPLICA", "*");
            }
            if(atual == '/'){
                avancar();
                return new Token("DIVIDE", "/");
            }
            if(atual == '('){
                avancar();
                return new Token("LPAREN", "(");
            }
            if(atual == ')'){
                avancar();
                return new Token("FPAREN", ")");
            }
            if(atual == '?'){
                avancar();
                return new Token("EOF", "?");
            }
            if(Character.isDigit(atual)){
                return new Token("INTEGER", getInteger());
            }
            if(Character.isAlphabetic(atual)){
                return new Token("ID", getString());
            }
            erro();
        }
        return new Token("EOF", "?");
    }
}
