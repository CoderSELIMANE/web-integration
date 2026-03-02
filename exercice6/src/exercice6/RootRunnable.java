package exercice6;

public class RootRunnable implements Runnable {

    private int debut;
    private int fin;

    public RootRunnable(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {

        for (int i = debut; i <= fin; i++) {
            double r = Math.sqrt(i);
            System.out.println(Thread.currentThread().getName()+ " -> " + r);
        }
    }
}
