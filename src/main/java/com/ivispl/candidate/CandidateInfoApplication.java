package com.ivispl.candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class CandidateInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateInfoApplication.class, args);
	}


}


