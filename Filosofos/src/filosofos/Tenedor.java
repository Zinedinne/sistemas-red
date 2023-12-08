package filosofos;

class Tenedor {
    private boolean disponible = true;

    public synchronized void tomar() throws InterruptedException {
        while (!disponible) {
            wait();
        }
        disponible = false;
    }

    public synchronized void liberar() {
        disponible = true;
        notifyAll();
    }
}
