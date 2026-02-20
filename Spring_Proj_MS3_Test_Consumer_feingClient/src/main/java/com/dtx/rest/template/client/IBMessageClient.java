package com.dtx.rest.template.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BILLING-SERVICE")
public interface IBMessageClient {
	@GetMapping("/payment/msg")
	public ResponseEntity<String> fetchBillingInfo();

}
