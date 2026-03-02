package ProducteurConsommateur;

public class Consommateur implements Runnable {

    private File<Integer> file;

    public Consommateur(File<Integer> file) {
        this.file = file;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = file.retirer();
                System.out.println("Consommation : " + item);
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}