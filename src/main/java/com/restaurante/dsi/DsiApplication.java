package com.restaurante.dsi;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


@EntityScan(basePackages = "com.restaurante.dsi")
@SpringBootApplication
@SecurityScheme(
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
@EnableScheduling
public class DsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsiApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Restaurante API")
						.version("1.0")
						.description("Restaurante API"));
	}
	//@Scheduled(cron = "0/5 * * * * *")
	//public void everyFiveSeconds() {
//		System.out.println("Periodic task: " + new Date());
	//}
}
