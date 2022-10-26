package Service;

import Logic.Gasolinera;

import java.util.Scanner;

public class Service {
    public static void servir() throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int numS;
        System.out.println("¿Cuantos surtidores tiene esta gasolinera? ");
        numS = teclado.nextInt();

        //logger.info("Setuping dinner...");
        System.out.println("Abriendo gasolinera...");
        Gasolinera gasolinera = new Gasolinera(numS);
        Thread dinner = new Thread(gasolinera);

        //logger.info("Starting dinner...");
        System.out.println("Empezando servicio...");
        dinner.start();
        dinner.join();
    }

}
