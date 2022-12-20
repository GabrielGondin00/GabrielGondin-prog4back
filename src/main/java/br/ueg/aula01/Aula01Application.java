package br.ueg.aula01;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.aula01.model.Tenis;
import br.ueg.aula01.repository.TenisRepository;

@SpringBootApplication
public class Aula01Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(TenisRepository repository) {
		return args -> {
          
       };
    }
}
