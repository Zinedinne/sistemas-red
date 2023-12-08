/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Zinedinne
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String ipServidor = "localhost";
        int puerto = 6001;
        
        try{
            Socket cs = new Socket(ipServidor, puerto);
            
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            InputStreamReader is = new InputStreamReader(cs.getInputStream());
            BufferedReader in = new BufferedReader(is);
            
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            
            out.println("Confirmación");
            
            out.close();
            in.close();
            is.close();
            cs.close();
            
        }catch(IOException ex){
            System.out.println("error");
        }
    }
}
