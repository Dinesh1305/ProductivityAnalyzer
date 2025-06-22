package com.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.model.Task;
import com.demo.service.TaskService;
@Controller
public class HomeController {

	@Autowired
	TaskService taskservice;
	
	@GetMapping("/")
	public String home_page()
	{
		return "index";
	}
	
	@GetMapping("/Add-Task")
	public String page_one(Model model)
	{
		model.addAttribute("task",new Task());
		return "Add-Task";
	}
	
	@GetMapping("/View")
	public String page_two(Model model)
	{
		model.addAttribute("Task", taskservice.get());
		return "View-Task";
	}
	

	
	@GetMapping("index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("filter")
	public String filter()
	{
		return "Filter";
	}
	
	
	@GetMapping("durations")
	public String duration()
	{
		return "choice";
	}
	
	
	
	@GetMapping("problems")
	public String problems(){
		return "problem";
	}
	
	
}
