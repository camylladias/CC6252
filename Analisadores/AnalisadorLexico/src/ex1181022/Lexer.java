package token.lexa;

import java.util.List;
import java.util.ArrayList;

public class Lexer{

  private String texto;
  private int pos;
  private char current_char;
  private List<AFD> afds;

  public Lexer(String texto){
    this.texto = texto;
    this.pos = 0;  
    this.current_char = texto.charAt(pos);
    afds = new ArrayList<>();
    afds.add(new Plus());
    afds.add(new Mult());
    afds.add(new Minus());
    afds.add(new Div());
    afds.add(new Eof());
    afds.add(new Integer());
    afds.add(new Lparen());
    afds.add(new Rparen());
    afds.add(new Lkey());
    afds.add(new Rkey());
    afds.add(new Id());
    afds.add(new Equals());
    afds.add(new Comment());
  }

  public void error(){
    throw new RuntimeException("invalid character");
  }

  public void advance(int qtde){
    pos += qtde;
    if (pos > (texto.length()-1)){
      current_char = '!';
    }else{
      current_char = texto.charAt(pos);
    }
  }

  public void skip_whitespace(){
    while (current_char != '!' && current_char == ' '){
      advance(1);
    }
  }

 
  public Token getNextToken(){
    
    while(current_char != '!'){
      if (current_char == ' '){
        skip_whitespace();
        continue;
      }

      for (AFD afd : afds){
          Token reconhecido= afd.processa(pos,texto);
          if (reconhecido != null){
              advance(reconhecido.getLength());
              return reconhecido;
          }
      }
      error();
    }
    return new Token("EOF", "!",1);
  }
}
