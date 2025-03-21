package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Assignment27Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment27Application.class, args);
	}

}
