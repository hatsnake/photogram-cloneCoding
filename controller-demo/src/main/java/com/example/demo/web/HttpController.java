package com.example.demo.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	
	@GetMapping("/get")
	public String get() {
		return "<h1>get요청</h1>";
	}
	
	@PostMapping("/post")
	public String post() {
		return "post요청";
	}
	
	@PutMapping("/put")
	public String put() {
		return "put요청";
	}
	
	@DeleteMapping("/delete")
	public String delete() {
		return "delete요청";
	}
}
