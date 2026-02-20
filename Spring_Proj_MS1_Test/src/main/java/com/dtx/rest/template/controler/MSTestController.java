package com.dtx.rest.template.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class MSTestController {
	@GetMapping("/msg")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<String>("Message from Provider bill is = '5000'",HttpStatus.OK);
	}

}
