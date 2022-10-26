package SpringApplication;

import Service.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GasolineraApplication {

	public static void main(String[] args) throws InterruptedException {
		Service.servir();
	}

}
