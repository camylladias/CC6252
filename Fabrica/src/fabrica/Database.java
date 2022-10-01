/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

/**
 *
 * @author unifebrito
 */
public class Database {
    private boolean isWriting;
    private int numReader;
    
    public Database(){
        this.isWriting=false;
        this.numReader=0;
        
    }
   
    synchronized void adquiriTravaLeitura(int id){
        while(isWriting == true){
            try{
                 wait();
            }catch (InterruptedException e){
                
            }
        }
        numReader++;
        System.out.println("Estou lendo "+id);
        
    }
    
    synchronized void liberaTravaLeitura(int id){
        numReader--;
        System.out.println("Acabei de ler "+id);
        if (numReader==0){
            notify();
        }
    }
    
     synchronized void adquiriTravaEscrita(int id){
        
        while (numReader>0)
            try{
               wait(); 
            
        }catch(InterruptedException e){
            
        }
        isWriting=true;
        System.out.println("Estou escrevendo");
        
        
    }
    
    synchronized void liberaTravaEscrita(int id){
        if(isWriting==false){
            System.out.println("Terminei de escrever");
            notifyAll();
        }
    }
    }

