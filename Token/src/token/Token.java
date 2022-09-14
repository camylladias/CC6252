package token;

public class Token {
    public String tipo, valor;
    
    public Token(String tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public String toString(){
        return "<"+ tipo +", "+valor +">";
    } 
}
