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
    
  public void function(){
    if (atual.getValor().equals("float")){
      atual = getnextToken();
    }else{
      erro("'float' esperado");
    }    
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
  public void lchave(){
    if (atual.getValor().equals("{")){
      atual = getnextToken();    
    }else{
      erro("'{' esperado");
    }
  } 
  public void rchave(){
      if (atual.getValor().equals("}")){
        atual = getnextToken();    
      }else{
        erro("'}' esperado");
      }
    }
  public void comando(){
    if (atual.getTipo().equals("comando")){
      atual = getnextToken();    
        }else{
          erro("tipo Comando esperado");
      }
  }
  public void arguments(){
    if (atual.getTipo().equals("args")){
      atual = getnextToken();
    }else{
      erro("tipo args esperado");
  }}
  public void fator(){
    if(atual.getTipo().equals("id") ||atual.getTipo().equals("id")){
      atual = getnextToken();
    }else{
      erro("Num ou Id esperado");
    }
  }
  public void id(){
    if (atual.getTipo().equals("id")){
      atual = getnextToken();
    }else{
      erro("tipo Id esperado");
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
