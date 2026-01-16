package com.polytech.courses.dpo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DpoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpoSpringApplication.class, args);
	}

}
