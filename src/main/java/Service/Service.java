package Service;

import Logic.Gasolinera;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.util.logging.Logger;

public class Service {

    //private static Logger logger = LoggerFactory.getLogger(Service.class);
    public static void servir() throws InterruptedException {
        //Scanner teclado = new Scanner(System.in);
        //int numS;
        //System.out.println("¿Cuantos surtidores tiene esta gasolinera? ");
        //numS = teclado.nextInt();


        //logger.info("Abriendo gasolinera...");
        System.out.println("Abriendo gasolinera...");
        Gasolinera gasolinera = new Gasolinera();
        Thread dinner = new Thread(gasolinera);


        System.out.println("Empezando servicio...");
        dinner.start();
        dinner.join();
    }

}
