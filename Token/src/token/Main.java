package token;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("entrada: ");
        String texto = sc.nextLine();
        Lexer lexer = new Lexer(texto);
        Token token = lexer.getNextToken();
        
        while(token.tipo != "EOF"){
            System.out.println(token);
            token = lexer.getNextToken();
        }
    }
}
