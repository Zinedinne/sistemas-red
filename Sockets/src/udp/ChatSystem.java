
package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatSystem {
    public static void main(String[] args) {
        int port = 6789;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName("Wi-Fi");
            
            InetSocketAddress groupAddress = new InetSocketAddress("239.0.0.1", port);
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(groupAddress, networkInterface);
            
            // Hilo para recibir mensajes
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        DatagramPacket messagePacket = new DatagramPacket(buffer, buffer.length);
                        socket.receive(messagePacket);
                        String message = new String(messagePacket.getData(), 0, messagePacket.getLength());
                        System.out.println(message);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
            receiveThread.start();
            
            // Hilo para enviar mensajes
            Thread sendThread = new Thread(() -> {
                try {
                    while (true) {
                        String userMessage = scanner.nextLine();
                        
                        if (userMessage.equalsIgnoreCase("/bye")) {
                            // Abandonar el grupo y salir del programa
                            socket.leaveGroup(groupAddress, networkInterface);
                            socket.close();
                            System.exit(0);
                        }
                        
                        String formattedMessage = "[" + username + "]: " + userMessage;
                        byte[] messageBytes = formattedMessage.getBytes();
                        DatagramPacket messagePacket = new DatagramPacket(messageBytes, messageBytes.length, groupAddress);
                        socket.send(messagePacket);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
            sendThread.start();
            
            // Espera a que los hilos terminen
            receiveThread.join();
            sendThread.join();
        } catch (SocketException | InterruptedException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
