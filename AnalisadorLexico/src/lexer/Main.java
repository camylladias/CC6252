package lexer;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try{
            while(true){
                System.out.println("Lexer: ");
                String texto = "float equacao(int x){ return (x + x) / 2 + 9 \n}";
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