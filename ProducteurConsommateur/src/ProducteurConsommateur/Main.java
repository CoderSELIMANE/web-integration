package ProducteurConsommateur;

public class Main {

    public static void main(String[] args) {

        File<Integer> file = new File<>(5);

        Thread p1 = new Thread(new Producteur(file));
        Thread p2 = new Thread(new Producteur(file));

        Thread c1 = new Thread(new Consommateur(file));
        Thread c2 = new Thread(new Consommateur(file));

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}