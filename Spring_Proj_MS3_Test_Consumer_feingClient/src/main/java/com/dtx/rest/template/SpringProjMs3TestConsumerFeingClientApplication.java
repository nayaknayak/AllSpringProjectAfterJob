package com.dtx.rest.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableFeignClients
public class SpringProjMs3TestConsumerFeingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjMs3TestConsumerFeingClientApplication.class, args);
	}

}
