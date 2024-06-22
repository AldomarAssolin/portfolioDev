package br.com.aldomarassolin;

import br.com.aldomarassolin.portifolio_dev.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortifolioDevApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(PortifolioDevApplication.class, args);}

	@Override
	public void run(String... args) {
		Principal principal = new Principal();
		principal.showMenu();
	}
}
