package ProducteurConsommateur;

public class Producteur implements Runnable {

    private File<Integer> file;

    public Producteur(File<Integer> file) {
        this.file = file;
    }

    @Override
    public void run() {
        int valeur = 0;

        for (int i = 1; i <= 30; i++) {   
            try {
                file.deposer(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}