package com.ninos.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.Greet;

@RestController
public class GreetingController {
	
	private static final String template = "Hello,%s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greet")
	public Greet greeting(@RequestParam(value="name",defaultValue = "world") String name) {
		
		return new Greet(counter.incrementAndGet(),String.format(template, name));
	}

}
