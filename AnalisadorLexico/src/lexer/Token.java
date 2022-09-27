package lexer;

public class Token {

  private String tipo;
  private String valor;

  public Token(String tipo, String valor) {
    this.tipo = tipo;
    this.valor = valor;
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

}
