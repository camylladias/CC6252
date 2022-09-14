package token;

public class Token {
    public String tipo, valor;
    
    public Token(String tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return "<"+ tipo +", "+valor +">";
    } 
    
    public String getTipo(){
        return tipo;
    }
    
    public String getValor(){
        return valor;
    }
}
