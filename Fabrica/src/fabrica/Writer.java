/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

/**
 *
 * @author unifebrito
 */
public class Writer implements Runnable{
    
    private Database db;
    private int id;
    
    public Writer(Database db,int id){
        this.id=id;
        this.db=db;
    }
    public void run(){
        JobUtil.nap();
        db.adquiriTravaEscrita(id);
        JobUtil.nap();
        //Selec * from 
        db.liberaTravaEscrita(id);
    }
    
    
}
