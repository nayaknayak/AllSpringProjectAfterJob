package com.dtx.rest.template.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/consumer")
public class RestConsumer {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private WebClient webClient;
	@GetMapping("/bill")
	public ResponseEntity<String> getMessage() {
		
		return new ResponseEntity<String>("Total msg is : "+getMessagefromProvider(), HttpStatus.OK);
	}

	public String getMessagefromProvider() {
		List<ServiceInstance> servletIns = discoveryClient.getInstances("BILLING-SERVICE");
		ServiceInstance serInstance = servletIns.get(0);
		URI uri = serInstance.getUri();
		String url = uri.toString() + "/payment/msg";
		
		/*
		 * String msg= webClient.get() .uri(url) .retrieve() .bodyToMono(String.class)
		 * .block();
		 */
		 
		return  webClient.get() .uri(url) .retrieve() .bodyToMono(String.class)
				  .block();
		
		

	}
}