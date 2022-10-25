package parser;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import parser.Token;

public class Main {

  public static void main(String[] args) throws IOException {
      ArrayList<Token> tokens = new ArrayList<>();
      tokens.add(new Token("reservado", "float", 1)); //1 == length
      tokens.add(new Token("id", "equacao", 1));
      tokens.add(new Token("parenl", "(", 1));
      tokens.add(new Token("type", "int", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("parenr", ")", 1));
      tokens.add(new Token("chavel", "{", 1));
      tokens.add(new Token("id", "return", 1));
      tokens.add(new Token("id", "x", 1));
      tokens.add(new Token("chaver", "}", 1));
      
      Parser p = new Parser(tokens);
  }
}