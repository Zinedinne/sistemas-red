package filosofos;

class Filosofo extends Thread {
    private Tenedor tenedorIzquierdo;
    private Tenedor tenedorDerecho;
    private int id;

    public Filosofo(int id, Tenedor izquierdo, Tenedor derecho) {
        this.id = id;
        this.tenedorIzquierdo = izquierdo;
        this.tenedorDerecho = derecho;
    }

    public void run() {
        while (true) {
            try {
                // Filósofo piensa
                System.out.println("Filósofo " + id + " está pensando.");

                // Filósofo toma los tenedores
                tenedorIzquierdo.tomar();
                System.out.println("Filósofo " + id + " tiene el tenedor izquierdo.");
                tenedorDerecho.tomar();
                System.out.println("Filósofo " + id + " tiene el tenedor derecho.");

                // Filósofo come
                System.out.println("Filósofo " + id + " está comiendo.");

                // Filósofo libera los tenedores
                tenedorDerecho.liberar();
                tenedorIzquierdo.liberar();
                System.out.println("Filósofo " + id + " ha terminado de comer.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}