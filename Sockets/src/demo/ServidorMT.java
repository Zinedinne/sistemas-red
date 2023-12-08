/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zinedinne
 */
public class ServidorMT {

    
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(6001);
            System.out.println("Servidor listo..");
            while(true){   
                ManejadorCliente mc = new ManejadorCliente(ss.accept());
                Thread th = new Thread(mc);
                th.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorMT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
