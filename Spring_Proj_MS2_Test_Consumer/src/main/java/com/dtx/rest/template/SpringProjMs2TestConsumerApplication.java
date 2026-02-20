package com.dtx.rest.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringProjMs2TestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjMs2TestConsumerApplication.class, args);
	}
	@Bean
	public WebClient webTemplate() {
		return WebClient.builder().build();
	}

}
