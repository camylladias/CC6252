package lexersimples;

public class Lexer{

    private String texto;
    private int pos;
    private char current_char;

    public Lexer(String texto){
      this.texto = texto;
      this.pos = 0;  
      this.current_char = texto.charAt(pos); 
    }

    public void error(){
      throw new RuntimeException("invalid character");
    }

    public void advance(){
      pos += 1;
      if (pos > (texto.length()-1)){
        current_char = '!';
      }else{
        current_char = texto.charAt(pos);
      }
    }

    public void skip_whitespace(){
      while (current_char != '!' && current_char == ' '){
        advance();
      }
    }

    public boolean isInteger(String integer){
        String regex = "[0-9]+";
        return integer.matches(regex);
    }
  
    public boolean isID(String character){
      String regex = "[A-Za-z]+";
      return character.matches(regex);
    }
    
    //reservada
    public boolean isRFloat(String floating){
        String regex = "[float]";
        return floating.matches(regex);
    }
    
    //reservada
    public String getRFloat(){
        String result="";
        while(current_char != '!' && isRFloat(String.valueOf(current_char))){
            result += current_char;
            advance();
        }
        return result;
    }
    
     //reservada
    public boolean isRInt(String integ){
        String regex = "[int]";
        return integ.matches(regex);
    }
    
    //reservada
    public String getRInt(){
        String result="";
        while(current_char != '!' && isRInt(String.valueOf(current_char))){
            result += current_char;
            advance();
        }
        return result;
    }
    
     //reservada
    public boolean isRReturn(String ret){
        String regex = "[return]";
        return ret.matches(regex);
    }
    
    //reservada
    public String getRReturn(){
        String result="";
        while(current_char != '!' && isRReturn(String.valueOf(current_char))){
            result += current_char;
            advance();
        }
        return result;
    }
  
    public String getString(){
        String result="";
        while(current_char != '!' && isID(String.valueOf(current_char))){
            result += current_char;
            advance();
        }
        return result;
    }

    public String getInteger(){
      String result="";
      while(current_char != '!' && isInteger(String.valueOf(current_char))){
        result += current_char;
        advance();
      }
      return result;
    }

  public Token getNextToken(){
    
    while(current_char != '!'){
      if (current_char == ' '){
        skip_whitespace();
        continue;
      }
      
      if(isRFloat(String.valueOf(current_char))){
          return new Token("RESERVADA_FLOAT", getRFloat());
      }
      
      if(isRInt(String.valueOf(current_char))){
          return new Token("RESERVADA_INT", getRInt());
      }
      
      if(isRReturn(String.valueOf(current_char))){
          return new Token("RESERVADA_RETURN", getRReturn());
      }
      
      if(isID(String.valueOf(current_char))){
          return new Token("ID", getString());
      }

      if (isInteger(String.valueOf(current_char))){
          return new Token("INTEGER", getInteger());
      }

      if (current_char == '+'){
        advance();
        return new Token("PLUS", "+");
      }

      if (current_char == '-'){
        advance();
        return new Token("MINUS", "-");
      }

      if (current_char == '*'){
        advance();
        return new Token("MUL", "*");
      }

      if (current_char == '/'){
        advance();
        return new Token("DIV", "/");
      }

      if (current_char == '('){
        advance();
        return new Token("LPAREN", "(");
      }

      if (current_char == ')'){
        advance();
        return new Token("RPAREN", ")");
      }
      error();
    }
    return new Token("EOF", "!");
  }
}
