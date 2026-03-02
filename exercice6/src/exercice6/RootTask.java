package exercice6;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class RootTask implements Callable<List<Double>> {

    private int debut;
    private int fin;

    public RootTask(int debut, int fin) {
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public List<Double> call() {

        List<Double> resultats = new ArrayList<>();

        for (int i = debut; i <= fin; i++) {
            resultats.add(Math.sqrt(i));
        }

        return resultats;
    }
}