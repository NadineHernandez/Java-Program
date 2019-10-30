package com.example.restcalculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class RestCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCalculatorServiceApplication.class, args);
	}

}
