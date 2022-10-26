package parser;

import java.util.ArrayList;

public class Parser {
  private ArrayList<Token> tokens;
  private Token atual;
  int controle=0; 
  public Token getnextToken(){
    //verificar antes de chamar o next token se a lista esta vazia na prpxima iteracao, se n tiver eu posso fazer a chamada de função.
        if (tokens.isEmpty()){
          System.out.println("Lista vazia");
          System.exit(0);
        }
        Token t = tokens.get(0);
        System.out.println(tokens);
        tokens.remove(0);
        /* if (controle<=t.getLength()){
          System.out.println("next token funcao "+t);
          controle=controle+1;
        } */
        return t;
    }
    
  private void erro(String regra) {
        System.out.println("Regra: " + regra);
        System.out.println("token inválido: " + atual.getValor());
        System.exit(0);
    }

  public void termo(){
    System.out.println("Entrei na regra termo");
    fator();
    //termoLinha();
    if(atual.getValor().equals('*')||atual.getValor().equals('/')){
      fator();
    }
  }

  //Tlinha
  public void termoLinha(){
    if(atual.getValor().equals('*')){
      atual = getnextToken();
      fator();
      termoLinha();
    }
    else if(atual.getValor().equals('/'){
      atual = getnextToken();
      fator();
      termoLinha();
    }else{
      return;
    }
  }

  public void expre(){
    System.out.println("Entrei na regra expr");
    termo();
    //EL(); -> adicionar barra AltrGr + Q 
    if(atual.getValor().equals('+')||atual.getValor().equals('-')){
      termo();
    }
  }

  //Elinha
  public void expreLinha(){
    if(atual.getValor().equals('+')){
      atual = getnextToken();
      termo();
      expreLinha();
    }
    else if(atual.getValor().equals('-'){
      atual = getnextToken();
      termo();
      expreLinha();
    }else{
      return;
    }
  }

  public void tipo(){
    System.out.println("Entrei na regra tipo");
    if (atual.getValor().equals("int")||atual.getValor().equals("double")||atual.getValor().equals("boolean")){
      atual = getnextToken();
    }else{
      erro("'tipo de dado inválido");
    }
  }

  public void function(){
    System.out.println("Entrei na regra fun");
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
    System.out.println("Entrei na regra lparent");
    if(atual.getValor().equals("(")){
      atual = getnextToken();
    }else{
      erro("'(' esperado");
    }
  }
  public void rparen(){
    System.out.println("Entrei na regra rparent");
    System.out.println("testeee  "+atual+atual.getValor()+atual.getTipo());
    if(atual.getValor().equals(")")){
      atual = getnextToken();
    }else{
      erro("')' esperado");
    }
  }
  public void lchave(){
    System.out.println("Entrei na regra lchave");
    if (atual.getValor().equals("{")){
      atual = getnextToken();    
    }else{
      erro("'{' esperado");
    }
  } 
  public void rchave(){
    System.out.println("Entrei na regra rchave");
      if (atual.getValor().equals("}")){
        atual = getnextToken();    
      }else{
        erro("'}' esperado");
      }
    }
  public void comando(){
    System.out.println("Entrei na regra comando");
    if (atual.getValor().equals("return")){
      atual = getnextToken();
      expre();
        }else{
          erro("tipo Comando esperado");
      }
  }
  public void arguments(){
    System.out.println("Entrei na regra args");
    tipo();
    if (atual.getTipo().equals("id")){
      atual = getnextToken();
    }else{
      erro("argumento tipo Id esperado");
    }
  }
  public void fator(){
    System.out.println("valor do fator "+atual);
    if(atual.getTipo().equals("id") ||atual.getTipo().equals("num")){
      atual = getnextToken();
    }else{
      lparen();
      expre();
      rparen();
    }
  }
  public void id(){
    System.out.println("Entrei na regra id");
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
    // while (tokens.isEmpty()==false){
    System.out.println("Valor do atual "+atual);
     function();
      /* if(atual.getValor().equals("return")){
        comando();
      }
      else{
        expre();
      } */
    // }
    System.out.println("Programa rodado por completo.");
  }
}
