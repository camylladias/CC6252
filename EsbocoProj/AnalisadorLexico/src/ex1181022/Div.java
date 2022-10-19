package token.lexa;

public class Div implements AFD {
  

@Override
public Token processa(int pos, String texto) {
  char current_char = texto.charAt(pos);
  if (current_char == '/') {
    return new Token("DIV", "/", 1);
  }
  return null;
  }
}