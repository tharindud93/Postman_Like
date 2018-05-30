package com.postman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/Home";
	}
	
	@GetMapping("/get")
	public String getcheck() {
		return "/get";
	}
	
	@GetMapping("/post")
	public String postcheck() {
		return "/post";
	}
	
	@GetMapping("/put")
	public String putcheck() {
		return "/put";
	}
	
	@GetMapping("/delete")
	public String deletecheck() {
		return "/delete";
	}

}
