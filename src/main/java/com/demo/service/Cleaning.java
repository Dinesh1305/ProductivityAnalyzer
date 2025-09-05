package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.model.Task;

import jakarta.annotation.PreDestroy;
@Component
public class Cleaning {

@Autowired
TaskService service;

	
	@PreDestroy
	public void close()
	{
		Long count= service.getCount();
		List<Task>t=service.get();
		if(count==1)
		{
		service.remove(t.get(0).getId());	
		
		}
	}
	
}
