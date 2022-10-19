package parser;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import parser.Token;

public class Main {

  public static void main(String[] args) throws IOException {
      ArrayList<Token> tokens = new ArrayList<>();
      tokens.add(new Token("reservado", "if", 1)); //1 == length
      tokens.add(new Token("parenl", "(", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("op_relacional", ">", 1));
      tokens.add(new Token("num", "5", 1));
      tokens.add(new Token("parenr", ")", 1));
      tokens.add(new Token("chavel", "{", 1));
      tokens.add(new Token("id", "y", 1));
      tokens.add(new Token("op_atribuicao", "=", 1));
      tokens.add(new Token("num", "10", 1));
      tokens.add(new Token("chaver", "}", 1));
      
      tokens.add(new Token("reservado", "else", 1));
      tokens.add(new Token("chavel", "{", 1));
      tokens.add(new Token("id", "y", 1));
      tokens.add(new Token("op_atribuicao", "=", 1));
      tokens.add(new Token("num", "2", 1));
      tokens.add(new Token("chaver", "}", 1));
      
      Parser p = new Parser(tokens);
  }
}