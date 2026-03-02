package exercice6;

public class SequentialVersion {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i <= 5000; i++) {
            double r = Math.sqrt(i);
            System.out.println(r);
        }

        long end = System.currentTimeMillis();

        System.out.println("Temps séquentiel = " + (end - start) + " ms");
    }
}