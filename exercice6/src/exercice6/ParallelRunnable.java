package exercice6;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelRunnable {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 5000; i += 100) {
            executor.execute(new RootRunnable(i, i + 99));
        }

        // shutdown
        executor.shutdown();

        long end = System.currentTimeMillis();

        System.out.println("Temps parallèle Runnable = " + (end - start) + " ms");
    }
}