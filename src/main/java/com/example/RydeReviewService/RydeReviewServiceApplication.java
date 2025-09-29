package com.example.RydeReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RydeReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RydeReviewServiceApplication.class, args);
	}

}
