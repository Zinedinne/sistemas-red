/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package operacionesrmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Zinedinne
 */
public class CalcRMI extends UnicastRemoteObject implements Calculadora, Serializable{
    
    
    public CalcRMI() throws RemoteException{}

    @Override
    public int div(int a, int b) throws RemoteException {
        System.out.println("dividiendo "+a+"/"+b+"="+(a/b));
        return a/b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        System.out.println("multiplicando "+a+"*"+b+"="+(a*b));
        return a*b;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        System.out.println("sumando "+a+"+"+b+"="+(a+b));
        return a+b;
    }

    @Override
    public int res(int a, int b) throws RemoteException {
        System.out.println("restando "+a+"-"+b+"="+(a-b));
        return a-b;
    }

   
}
