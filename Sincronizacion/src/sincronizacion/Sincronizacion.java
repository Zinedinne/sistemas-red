/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sincronizacion;

/**
 *
 * @author Zinedinne
 */
public class Sincronizacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        
        Thread us1 = new Thread(cajero, "Felipe");
        Thread us2 = new Thread(cajero, "Pedro");
        
        us1.start();
        us2.start();
    }
    
}
