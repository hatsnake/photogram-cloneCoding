package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpResponseController {

	@GetMapping("/txt")
	public String txt() {
		return "test.txt";
	}	
	
	@GetMapping("/mus")
	public String mus() {
		return "test";
	}
	
	@GetMapping("/jsp")
	public String jsp() {
		return "test";
	}
	
}
