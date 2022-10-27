/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package token.lexa;

/**
 *
 * @author unifgversolato
 */
public class Minus implements AFD{
    @Override
    public Token processa(int pos, String texto){
       char current_char = texto.charAt(pos);
       if (current_char == '-'){
        return new Token("MINUS", "-",1);
      }
       
        return null;
    }   
}
