package exercice6;
import java.util.*;
import java.util.concurrent.*;

public class ParallelCallable {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<List<Double>>> futures = new ArrayList<>();

        for (int i = 0; i <= 5000; i += 100) {
            futures.add(
                    executor.submit(new RootTask(i, i + 99))
            );
        }

        for (Future<List<Double>> future : futures) {
            List<Double> results = future.get();

            for (Double d : results) {
                System.out.println(d);
            }
        }

        executor.shutdown();

        long end = System.currentTimeMillis();

        System.out.println("Temps Callable = "+ (end - start) + " ms");
    }
}
