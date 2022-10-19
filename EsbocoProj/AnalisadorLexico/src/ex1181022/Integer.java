package token.lexa;

public class Integer implements AFD {
	private int marca = 0;
	 @Override
	 public Token processa(int pos, String texto){
		 char current_char = texto.charAt(pos);
		 if(isDigit(current_char) == true) {
			 return new Token("Int",makeInteger(current_char, texto, pos), marca);
		 }
		 return null;
	 }
	
	  public boolean isDigit(char c) {
	    switch (c) {
	      case '0':
	      case '1':
	      case '2':
	      case '3':
	      case '4':
	      case '5':
	      case '6':
	      case '7':
	      case '8':
	      case '9':
	        return true;
	    }
	    return false;
	  }
	
	  public String makeInteger(char c,String texto, int pos) {
		  String result="";
		  marca=0;
		  while(c != '!' && isDigit(c)){
			  pos+=1;
		      result += c;
		      c= texto.charAt(pos);
		      marca+=1;
		  }
		  return result;
	  }
	    
	}
