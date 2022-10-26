package Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gasolinera implements Runnable {

    private List<Surtidor> surtidores;
    private List<Coches> coches;
    private Iterator<Long> times;

    public Gasolinera(int numSurtidores) {
        if (numSurtidores < 2) {
            throw new IllegalArgumentException("Debe haber mas de un surtidor");
        }

        this.surtidores = new ArrayList<>();
        this.coches = new ArrayList<>();
        this.times = new Random().longs(5, 10).iterator();

        for (int i = 0; i < numSurtidores; ++i) {
            Surtidor f = new Surtidor();
            surtidores.add(f);
        }
        for (int i = 0; i < numSurtidores; ++i) {
            Surtidor surtidor = surtidores.get(i);
            int numSurtidor = i + 1;

            Coches p = new Coches("Coche en surtidor #" + (i + 1),this, surtidor, numSurtidor);
            coches.add(p);
        }
    }

    public synchronized long getTime() {
        return times.next();
    }

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(coches.size());
        for (Coches p : coches) {
            executorService.submit(p);
        }
    }
}
