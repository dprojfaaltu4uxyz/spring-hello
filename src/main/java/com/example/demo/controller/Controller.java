package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
}
