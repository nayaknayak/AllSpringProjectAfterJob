package com.dtx.rest.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringProjConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjConfigServerApplication.class, args);
	}

}
