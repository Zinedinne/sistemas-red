
package sincronizacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zinedinne
 */
public class Cajero implements Runnable{

   Cuenta cta;
   
   public Cajero(){
    cta = new Cuenta();   
   }

    @Override
    public void run() {
        for (int i= 0; i<5; i++){
            retirarDinero(10);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private synchronized void retirarDinero(int valorRetiro){
        if(cta.getSaldoActual()>= valorRetiro){
            System.out.println("Saldo actual: "+cta.getSaldoActual());
            cta.retiroCuenta(valorRetiro);
            System.out.println("El usuario "+Thread.currentThread().getName() + " está retirando $"+valorRetiro);
            System.out.println("Retiro Exitoso!");
            System.out.println("Nuevo saldo: "+cta.getSaldoActual());
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
}
