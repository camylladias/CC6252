package parser;

public class Token {

  private String tipo;
  private String valor;
  private int length;

  public Token(String tipo, String valor, int length) {
    this.tipo = tipo;
    this.valor = valor;
    this.length = length;
  }

  @Override
  public String toString() {
    return "token<" + tipo + ", " + valor + ">";
  }

  public String getTipo() {
    return tipo;
  }

  public String getValor() {
    return valor;
  }
  
  public int getLength(){
      return this.length;
  }
}
