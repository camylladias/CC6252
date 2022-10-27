package token.lexa;
public class Id implements AFD {

  @Override
  public Token processa(int pos, String texto) {
    char current_char = texto.charAt(pos);
    String c="";
    int i=0;
    while (Character.isAlphabetic(current_char) && texto.charAt(pos) != '='){
      current_char = texto.charAt(pos);
      c+=current_char;
      pos+=1;
      i+=1;
    }
    if (c !=""){
	    if (c.equals("return")) {
	      return new Token("RESERVADA_RETURN", "return", 6);
	    }
	    if (c.equals("float")) {
	      return new Token("RESERVADA_FLOAT", "float", 5);
	    }
	    if (c.equals("int")) {
	      return new Token("RESERVADA_INT", "int", 3);
	    }
	    else{
	      return new Token("ID", c, i);
	    }
    }
    return null;
    }
}