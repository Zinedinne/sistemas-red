/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

/**
 *
 * @author Zinedinne
 */
public class ServidorUDP {
    public static void main(String[] args) throws SocketException, IOException {
        int port = 6001;
        System.out.println("Servidor en puerto "+ port);
        DatagramSocket socketUDP = new DatagramSocket(port);
        byte[] buffer = new byte[1000];
        
        while(true){
        DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(peticion);
        
        System.out.println("Datagrama recibido del host: "+peticion.getAddress());
        System.out.println(" desde el puerto remoto: "+peticion.getPort());
        
        Date now = new Date();
        
        DatagramPacket resp = new DatagramPacket(
          now.toString().getBytes(),
                now.toString().getBytes().length,
                peticion.getAddress(),
                peticion.getPort()                
        );
        
        socketUDP.send(resp);
        
        
        }
    }
}
