package Logic;


import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class Coches implements Runnable {

    //private static Logger logger = LoggerFactory.getLogger(String.valueOf(Philosopher.class));
    //private static Logger logger = (Logger) LoggerFactory.getLogger(Coches.class);
    private String name;
    private Logic.Gasolinera gasolinera;
    private Surtidor surtidor;

    private int numSurtidor;

    private int tiempoPago = 3;


    public Coches(String name, Logic.Gasolinera gasolinera, Surtidor surtidor, int numSurtidor) {
        this.name = name;
        this.gasolinera = gasolinera;
        this.surtidor = surtidor;
        this.numSurtidor = numSurtidor;

    }

    public void repostar() throws InterruptedException {
        long time = gasolinera.getTime();


        System.out.println("El coche " + name + " está buscando un surtidor libre");
        surtidor = gasolinera.buscarSurtidorLibre();
        System.out.println("El coche " + name + " ha encontrado un surtidor libre");
        surtidor.take();
        System.out.println("El coche " + name + " está repostando durante " + time + " minutos");
        Thread.sleep(gasolinera.getTime());
        surtidor.drop();
        System.out.println("El coche " + name + " ha terminado de repostar");


        //logger.info("{} thinking during {}ms", name, time);
        System.out.println(name + " repostando tardo " + time + " minutos");

        //spendTime(time);
    }

    public void pagar() throws InterruptedException {
        long time = tiempoPago;
        //logger.info("{} eating during {}ms", name, time);
        System.out.println(name +" pagando tardo " + time + " minutos");
        //spendTime(time);

        spendTime(time);
        dejarSurtidor();
    }

    public void run() {
        while (true) {
            try {
                //numero random entre 1 y 10
                int random = (int) (Math.random() * 10 + 1);
                //Thread.sleep(random);
                //System.out.println("El surtidor #" + numSurtidor + " ha estado " + random + " minutos sin uso");
                repostar();
                pagar();

            } catch (Exception e) {
                //logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }
        }
    }



    private void dejarSurtidor() {
        surtidor.drop();
        System.out.println("El surtidor #" + numSurtidor + " esta libre");
    }

    private void spendTime(long time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }
}