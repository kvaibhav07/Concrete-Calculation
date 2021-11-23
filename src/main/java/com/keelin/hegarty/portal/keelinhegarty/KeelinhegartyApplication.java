package com.keelin.hegarty.portal.keelinhegarty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan(basePackages = "com.keelin.hegarty.portal.*")
@OpenAPIDefinition(info = @Info(title = "Keelin Hegarty", version = "3.0", description = "Keelin Hegarty Microservice"))
public class KeelinhegartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeelinhegartyApplication.class, args);
	}

}
