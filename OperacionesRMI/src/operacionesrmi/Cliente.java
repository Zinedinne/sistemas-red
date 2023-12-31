
package operacionesrmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;
public class Cliente {
    public static void main(String[] args) {
        try{
            Calculadora calc =(Calculadora) Naming.lookup("rmi://10.50.5.16:1099/Calculadora");
            
            while(true){
                String opt = JOptionPane.showInputDialog("Calcular\n"+
                        "Suma......... (1)\n"+
                        "Resta........ (2)\n"+
                        "Multip....... (3)\n"+
                        "Division..... (4)\n"+
                        "Cancelar para salir\n");
                if(opt==null)break;
                int a= Integer.parseInt(JOptionPane.showInputDialog("Ingrese a"));
                int b= Integer.parseInt(JOptionPane.showInputDialog("Ingrese b"));
                
                
                switch(opt){
                    case "1":
                        JOptionPane.showMessageDialog(null, a+" + "+b+" = "+calc.sum(a, b));
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, a+" - "+b+" = "+calc.res(a, b));
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, a+" * "+b+" = "+calc.mul(a, b));
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(null, a+" / "+b+" = "+calc.div(a, b));
                        break;
                }

                        
            }
            
            
            
        }catch(RemoteException | NotBoundException | MalformedURLException ex){
            System.err.print(ex);
            } 
    }
    
}
