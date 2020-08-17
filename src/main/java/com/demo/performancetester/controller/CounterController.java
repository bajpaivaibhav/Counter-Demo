package com.demo.performancetester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.performancetester.models.Counter;
import com.demo.performancetester.service.CounterService;

@RestController
public class CounterController {

	@Autowired
	CounterService counterService;

	@GetMapping(value = "/counter", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Counter> incrementCounter() {

		Counter counter = new Counter();
		return ResponseEntity.ok().body(counterService.updateCounter(counter));
	}
}
