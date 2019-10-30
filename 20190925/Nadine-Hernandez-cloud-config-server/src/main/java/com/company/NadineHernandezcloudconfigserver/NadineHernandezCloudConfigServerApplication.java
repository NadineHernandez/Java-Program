package com.company.NadineHernandezcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NadineHernandezCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NadineHernandezCloudConfigServerApplication.class, args);
	}

}
