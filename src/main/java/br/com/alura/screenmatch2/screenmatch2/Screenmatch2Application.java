package br.com.alura.screenmatch2.screenmatch2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.screenmatch2.screenmatch2.principal.Principal;




@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Screenmatch2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibeMenu();

    }
}
