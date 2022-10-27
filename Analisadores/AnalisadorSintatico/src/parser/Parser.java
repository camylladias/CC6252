package parser;

import java.util.ArrayList;

public class Parser {
  private ArrayList<Token> tokens;
  private Token atual;
  Token controle=new Token("EOF","!",1); 
  public Token getnextToken(){
        if (tokens.isEmpty()){
          return controle;
        }
        Token t = tokens.get(0);
        tokens.remove(0);
        return t;
    }
    
  private void erro(String regra) {
        System.out.println("Regra: " + regra);
        System.out.println("token inválido: " + atual.getValor());
        System.exit(0);
    }

  public void termo(){
    fator();
    termoLinha();
  }

  //Tlinha
  public void termoLinha(){
    if(atual.getValor().equals("*")){
      atual = getnextToken();
      fator();
      termoLinha();
    }
    else if(atual.getValor().equals("/")){
      atual = getnextToken();
      fator();
      termoLinha();
    }else{
      return;
    }
  }

  public void expre(){
    termo();
    expreLinha(); 
  }

  //Elinha
  public void expreLinha(){
    if(atual.getValor().equals("+")){
      atual = getnextToken();
      termo();
      expreLinha();
    }
    else if(atual.getValor().equals("-")){
      atual = getnextToken();
      termo();
      expreLinha();
    }else{
      return;
    }
  }

  public void EOF(){
    if(atual.getTipo().equals("EOF")){
      System.out.println("Leitura finalizada com sucesso!");
    }
  }

  public void tipo(){
    if (atual.getValor().equals("int")||atual.getValor().equals("double")||atual.getValor().equals("boolean")){
      atual = getnextToken();
    }else{
      erro("'tipo de dado inválido");
    }
  }

  public void function(){
    if (atual.getValor().equals("float")){
      atual = getnextToken();
      id();
      lparen();
      arguments(); 
      rparen();
      lchave();
      comando();
      rchave(); 
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
      EOF();
    }
  public void comando(){
    if (atual.getValor().equals("return")){
      atual = getnextToken();
      expre();
        }else{
          erro("tipo Comando esperado");
      }
  }
  public void arguments(){
    tipo();
    if (atual.getTipo().equals("id")){
      atual = getnextToken();
    }else{
      erro("argumento tipo Id esperado");
    }
  }
  public void fator(){
    if(atual.getTipo().equals("id") ||atual.getTipo().equals("num")){
      atual = getnextToken();
    }else{
      lparen();
      expre();
      rparen();
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
    Analiza();
  }
  public void Analiza(){
    atual = getnextToken();
     function();

  }
}
