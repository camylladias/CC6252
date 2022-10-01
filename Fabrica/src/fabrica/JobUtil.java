/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

/**
 *
 * @author unifebrito
 */
 public class JobUtil {
    private static final int NAP_TIME = 5;
    public static void nap() {
    nap(NAP_TIME);
}

 public static void nap(int duration) {
    int sleeptime = (int) (duration * Math.random());
    try {
        Thread.sleep(sleeptime * 1000);
    }catch (InterruptedException e) {
    }
 }
}

