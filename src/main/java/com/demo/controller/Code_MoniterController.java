package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Code_MoniterController {

	@GetMapping("getDetails")
	public String details()
	{
	return "home";	
	}
}
