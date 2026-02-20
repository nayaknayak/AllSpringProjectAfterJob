package com.dtx.rest.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtx.rest.template.client.IBMessageClient;

@RestController
@RequestMapping("/test")
public class TestUsingFeingClient {
	@Autowired
	public IBMessageClient client;
	@Value("${Employee.name}")
	private String name;
	@Value("${Employee.lname}")
	private String lName;
	@GetMapping("/msg/{id}")
	public ResponseEntity<String> getMessageFromProducer(@PathVariable(name = "id",required=false) String msgId) {
		String msgFromClient = client.fetchBillingInfo().getBody();
		String msg = "Hi " + msgId + " your Bill is " + msgFromClient;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	@GetMapping("fname")
	public ResponseEntity<String> getName(){
		return new ResponseEntity<String>(name+""+lName,HttpStatus.OK);
	}
	
	
}
