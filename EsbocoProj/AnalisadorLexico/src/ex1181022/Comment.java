package token.lexa;

public class Comment implements AFD {

  @Override
  public Token processa(int pos, String texto) {
    char current_char = texto.charAt(pos);
    String c = "";
    if (current_char == '"') {
    	c+=current_char;
	      pos += 1;
	      int i = 0;
	      current_char = texto.charAt(pos);
	      while (current_char != '"') {
		        current_char = texto.charAt(pos);
		        c+=current_char;
		        pos += 1;
		        i += 1;
	      }
      c+="'";
      i += 1;
      return new Token("Comment", c, i);
    }
    return null;
  }
}