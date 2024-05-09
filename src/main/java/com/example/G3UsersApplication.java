package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class G3UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(G3UsersApplication.class, args);
	}

}
