package ua.hbi.PersonManager;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PersonManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}

