package webIntegration;

class Compteur {
    private int c = 0;

    public synchronized void incrementer() {
        c++;
    }

    public int getValeur() {
        return c;
    }
}


