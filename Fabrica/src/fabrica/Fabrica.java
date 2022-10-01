/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fabrica;

/**
 *
 * @author unifebrito
 */
public class Fabrica{  
    public static final int NUM_OF_READERS = 3; 
    public static final int NUM_OF_WRITERS = 2;  
    public static void main(String[] args){ 
    Database server = new Database();  
    Thread[] readerArray = new Thread[NUM_OF_READERS];
    Thread[] writerArray = new Thread[NUM_OF_WRITERS];
    for(int i = 0; i < NUM_OF_READERS; i++){
        readerArray[i]= new Thread(new Reader(server,i));
        readerArray[i].start();
    }
    for(int i = 0; i < NUM_OF_WRITERS; i++){
        writerArray[i]= new Thread(new Writer(server,i));
        writerArray[i].start();
    }

    }
}