package parser;

import java.util.ArrayList;

public class Parser {
    private ArrayList<Token> tokens;
    private Token atual;
    
    public Token getnextToken(){
        Token t = tokens.get(0);
        tokens.remove(0);
        
        return t;
    }
    
    private void erro(String regra) {
        System.out.println("Regra: " + regra);
        System.out.println("token inválido: " + atual.getValor());
        System.exit(0);
    }
    
    public void lparen(){
        if(atual.getValor().equals("(")){
            atual = getnextToken();
        }else{
            erro("'(' esperado");
        }
    }
    public void rparen(){
        if(atual.getValor().equals(")")){
            atual = getnextToken();
        }else{
            erro("')' esperado");
        }
    }
    
    
    public void fator(){
        if(atual.getTipo().equals("id") ||atual.getTipo().equals("id")){
           atual = getnextToken();
        }else{
            erro("Num ou Id esperado");
        }
    }
    public void opRelacional(){
        if(atual.getTipo().equals("op_relacional") ){
           atual = getnextToken();
        }else{
            erro("op_relacional esperado");
        }
    }
    public void condicao(){
        fator();
        fator();
    }
    
    public void ifelse(){
        if(atual.getValor().equals("if")){
            atual = getnextToken();
            lparen();
            
            rparen();
        }
    }
    
    public Parser(ArrayList<Token> tokens){
        this.tokens = tokens;
        System.out.println(tokens.size());
        System.out.println(getnextToken().getValor());
        System.out.println(getnextToken().getValor());
        System.out.println(tokens.size());
    }
}
