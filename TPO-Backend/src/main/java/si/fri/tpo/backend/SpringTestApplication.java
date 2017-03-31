package si.fri.tpo.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import si.fri.tpo.backend.jpa.BarvaEpruvete;
import si.fri.tpo.backend.rest.BarvaEpruveteRepository;

@SpringBootApplication
public class SpringTestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BarvaEpruveteRepository repository) {

		return (args) -> {

			// fetch all people
			log.info("Ljudje found with findAll():");
			log.info("-------------------------------");
			for (BarvaEpruvete barva : repository.findAll()) {
				log.info(barva.toString());
			}
			log.info("");
		};

	}
}
