/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesrmi;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Zinedinne
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            System.out.println("Creando registro RMI...\n");
            
            Registry registry = LocateRegistry.createRegistry(1099);
            
            System.out.println("Enlazando métodos remotos Calculadora");
            registry.rebind("Calculadora", new CalcRMI());
            
            System.out.println("Servidor ejecutandose!\n");
        } catch (RemoteException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
}
