package com.demo.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;
@Component
public class Cleaning {


	@PreDestroy
	public void close()
	{
		
	}
	
}
