package compteBancaire;

public class JobAhmedEtFatima implements Runnable {
	private Compte compte;

    public JobAhmedEtFatima(Compte compte) {
        this.compte = compte;
    }

    public void doRetrait(int montant) {

        if (compte.getSolde() >= montant) {

            System.out.println(Thread.currentThread().getName()+" va retirer "+montant);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}

            compte.retirer(montant);

            System.out.println("Nouveau solde : "+ compte.getSolde());
        }
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            doRetrait(10);
        }
    }

}
