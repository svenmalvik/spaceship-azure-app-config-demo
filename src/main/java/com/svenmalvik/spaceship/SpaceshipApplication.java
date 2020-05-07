package com.svenmalvik.spaceship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MessageProperties.class)
public class SpaceshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceshipApplication.class, args);
	}

}
