package com.company.NadineHernandezserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NadineHernandezServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NadineHernandezServiceRegistryApplication.class, args);
	}

}
