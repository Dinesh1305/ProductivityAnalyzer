package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.Problems;
import com.demo.repository.ProblemRepo;

@Controller
public class ProblemController {
	
	
	@Autowired
	ProblemRepo repo;

	@PostMapping("addProblem")
	public String add(@ModelAttribute  Problems p)
	{
		repo.save(p);
		return "home";
	}
	

	
	
	
	
}
