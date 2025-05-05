package umc.UMC8th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc8thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc8thApplication.class, args);
	}

}
