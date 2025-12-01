package com.example.demo.entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("path")
	public String getMethodName( String param) {
		return new String();
	}
	
	
}
