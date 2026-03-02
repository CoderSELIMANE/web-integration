package compteBancaire;

public class Main {

    public static void main(String[] args) {

        Compte compte = new Compte();

        JobAhmedEtFatima job = new JobAhmedEtFatima(compte);

        Thread ahmed = new Thread(job,"Ahmed");
        Thread fatima = new Thread(job,"Fatima");

        ahmed.start();
        fatima.start();
    }
}
