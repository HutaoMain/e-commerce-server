package com.rimsti.rimsti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RimstiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RimstiApplication.class, args);
	}

}
