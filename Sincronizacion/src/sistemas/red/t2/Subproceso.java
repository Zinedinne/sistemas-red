/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.red.t2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zinedinne
 */
public class Subproceso implements Runnable{

    @Override
    public void run() {
        System.out.println("Pulse \"enter\" para"+
                "detener la espera de " +
                Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Subproceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    synchronized (this){
            this.notifyAll();
        }
    }
    
}
