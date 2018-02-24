package com.diamondmarket.diamonds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.diamondmarket.diamonds", "com.diamondmarket.diamonds.api" })
public class DiamondDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiamondDatabaseApplication.class, args);
	}
}
