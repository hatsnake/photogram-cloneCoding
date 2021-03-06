package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
public class HttpResponseJsonController {

	@GetMapping("/resp/json")
	public String respJson() {
		return "{\r\n"
				+ " \"username\" : \"cos\"\r\n"
				+ "}";
	}
	
	@GetMapping("/resp/json/object")
	public User respJsonObject() {
		User user = new User();
		user.setUsername("홍길동");
		return user;
	}	
}
