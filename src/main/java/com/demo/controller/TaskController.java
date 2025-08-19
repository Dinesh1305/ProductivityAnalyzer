package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Task;
import com.demo.service.TaskService;
@Controller
public class TaskController {

	@Autowired
	TaskService taskservice;
	
	@PostMapping("save")
	public String save(@ModelAttribute Task t)
	{
		taskservice.save(t);
		
		return "index";
	}
	@PostMapping("done/{id}")
	public String done(@PathVariable Integer id)
	{
		taskservice.remove(id);
		return "index";

		
	}

}
