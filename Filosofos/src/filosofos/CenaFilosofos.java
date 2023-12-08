package filosofos;

public class CenaFilosofos {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Tenedor[] tenedores = new Tenedor[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Tenedor();
        }

        for (int i = 0; i < numFilosofos; i++) {
            Filosofo filosofo = new Filosofo(i, tenedores[i], tenedores[(i + 1) % numFilosofos]);
            filosofo.start();
        }
    }
}