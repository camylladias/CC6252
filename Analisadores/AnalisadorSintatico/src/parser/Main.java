package parser;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import parser.Token;

public class Main {

  public static void main(String[] args) throws IOException {
      ArrayList<Token> tokens = new ArrayList<>();
      /* tokens.add(new Token("reservado", "float", 1)); //1 == length
      tokens.add(new Token("id", "equacao", 1));
      tokens.add(new Token("lparen", "(", 1));
      tokens.add(new Token("reservado", "int", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rparen", ")", 1));
      tokens.add(new Token("lchave", "{", 1));
      tokens.add(new Token("reservado", "return", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rchave", "}", 1));
       */

      /* tokens.add(new Token("reservado", "float", 1)); //1 == length
      tokens.add(new Token("id", "equacao", 1));
      tokens.add(new Token("lparen", "(", 1));
      tokens.add(new Token("reservado", "int", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rparen", ")", 1));
      tokens.add(new Token("lchave", "{", 1));
      tokens.add(new Token("reservado", "return", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("sinal", "+", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rchave", "}", 1)); */

      tokens.add(new Token("reservado", "float", 1)); //1 == length
      tokens.add(new Token("id", "equacao", 1));
      tokens.add(new Token("lparen", "(", 1));
      tokens.add(new Token("reservado", "int", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rparen", ")", 1));
      tokens.add(new Token("lchave", "{", 1));
      tokens.add(new Token("reservado", "return", 1));
      tokens.add(new Token("lparen", "(", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("sinal", "+", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("rparen", ")", 1));
      tokens.add(new Token("sinal", "/", 1));
      tokens.add(new Token("id", "2", 1));
      tokens.add(new Token("sinal", "+", 1));
      tokens.add(new Token("id", "9", 1));
      tokens.add(new Token("rchave", "}", 1));

      Parser p = new Parser(tokens);
  }
}