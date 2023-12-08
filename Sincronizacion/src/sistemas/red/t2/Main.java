
package sistemas.red.t2;

/**
 *
 * @author Zinedinne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        Thread p1 = new Thread(new Subproceso(), "subpro1");
        p1.start();
        
        synchronized (p1){
            p1.wait();
        }
        
        System.out.println("La espera ha finalizado");
    }
}
