/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Zinedinne
 */
public class Servidor {
    
    public static void main(String[] args) {
        int puerto= 6001;
    
    try{
        ServerSocket ss = new ServerSocket(puerto);
        Socket ch = ss.accept();
        
        PrintWriter out = new PrintWriter(ch.getOutputStream());
        InputStreamReader is = new InputStreamReader(ch.getInputStream());
        BufferedReader in = new BufferedReader(is);
        
        out.println("Dato 1");
        out.println("Dato 2");
        
        out.close();
        in.close();
        is.close();
        ch.close();
        ss.close();
        
    }catch(IOException ex){}
    }
}
