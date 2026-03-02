package ProducteurConsommateur;
import java.util.LinkedList;

public class File<T> {

    private LinkedList<T> buffer = new LinkedList<>();
    private int capacite;

    public File(int capacite) {
        this.capacite = capacite;
    }

    public synchronized void deposer(T item) throws InterruptedException {

        while (buffer.size() == capacite) {
            wait(); 
        }

        buffer.add(item);
        System.out.println("Produit ajouté : " + item);

        notifyAll();
    }

    public synchronized T retirer() throws InterruptedException {

        while (buffer.isEmpty()) {
            wait(); 
        }

        T item = buffer.removeFirst();
        System.out.println("Produit retiré : " + item);

        notifyAll(); 

        return item;
    }
}