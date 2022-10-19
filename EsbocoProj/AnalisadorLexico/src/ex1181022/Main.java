import java.io.IOException;
import java.util.Scanner;
import token.lexa.Lexer;
import token.lexa.Token;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    try {

      while (true) {
    	Scanner scanner = new Scanner(System.in);
    	String linha = scanner.nextLine();
    	while (linha != null || scanner.hasNext())  {
        	Lexer lexer = new Lexer(linha);
            Token token = lexer.getNextToken();
            while (!token.getTipo().equals("EOF")) {
                System.out.println(token);
                token = lexer.getNextToken();
              }
            linha = scanner.next();
        }
        
      }
    } catch (RuntimeException re) {
      System.out.println("Error: " + re.getMessage());
      sc.close();
    }
  }
}
