package Logic;


public class Coches implements Runnable {

    //private static Logger logger = LoggerFactory.getLogger(String.valueOf(Philosopher.class));

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
        //logger.info("{} thinking during {}ms", name, time);
        System.out.println(name + " repostando tardo " + time + " minutos");

        spendTime(time);
    }

    public void pagar() throws InterruptedException {
        takeForks();
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
                Thread.sleep(random);
                System.out.println("El surtidor #" + numSurtidor + " ha estado " + random + " minutos sin uso");
                repostar();
                pagar();

            } catch (Exception e) {
                //logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }
        }
    }

    private void takeForks() {
        surtidor.take();
    }

    private void dejarSurtidor() {
        surtidor.drop();
        System.out.println("El surtidor #" + numSurtidor + " esta libre");
    }

    private void spendTime(long time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }
}