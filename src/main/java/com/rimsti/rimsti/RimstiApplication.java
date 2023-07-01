package com.rimsti.rimsti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.rimsti.rimsti.repository")
@ComponentScan(basePackages = "com.rimsti.rimsti")
public class RimstiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RimstiApplication.class, args);
	}

}
