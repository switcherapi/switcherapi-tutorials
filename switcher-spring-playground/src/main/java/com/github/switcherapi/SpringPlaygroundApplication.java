package com.github.switcherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
	}

}
