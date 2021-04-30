package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@Value("${app.restful-service.endpoint}")
	private String endpoint;

	private RestTemplate restTemplate;

	public Controller() {
		restTemplate = new RestTemplate();
	}

	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		ResponseEntity<String> responseEntity = restTemplate.exchange(getEndpoint(), HttpMethod.GET, null,
				String.class);
		if (responseEntity == null)
			throw new RuntimeException("Null response from restful service");
		return new ResponseEntity<>("Hello World " + responseEntity.getBody(), HttpStatus.OK);
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
