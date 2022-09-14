package token;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try{
            while(true){
                System.out.println("Lexer: ");
                String texto = sc.nextLine();
                Lexer lexer = new Lexer(texto);
                Token token = lexer.getNextToken();
                
                while(!token.getTipo().equals("EOF")){
                    System.out.println(token);
                    token = lexer.getNextToken();
                }
            }
        }catch(RuntimeException re){
            System.out.println("Error: " + re.getMessage());
            sc.close();
        }
    }
}
