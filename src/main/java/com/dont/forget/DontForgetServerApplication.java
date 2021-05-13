package com.dont.forget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DontForgetServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DontForgetServerApplication.class, args);
	}

}
