package com.rimsti.rimsti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableJpaRepositories(basePackages = "com.rimsti.rimsti.repository")
@ComponentScan(basePackages = "com.rimsti.rimsti")
public class RimstiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RimstiApplication.class, args);
	}

}
