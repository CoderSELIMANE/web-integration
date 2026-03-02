package compteBancaire;

class Compte {
    private int solde = 1000;

    public int getSolde() {
        return solde;
    }

    public synchronized void retirer(int montant) {
        solde -= montant;
    }
}
