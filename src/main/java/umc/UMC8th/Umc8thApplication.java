package umc.UMC8th;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.UMC8th.domain.Store;
import umc.UMC8th.service.StoreQueryService;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Umc8thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc8thApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}
}
