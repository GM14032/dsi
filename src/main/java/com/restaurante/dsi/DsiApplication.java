package com.restaurante.dsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.restaurante.dsi")
@SpringBootApplication
public class DsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsiApplication.class, args);
	}

}
