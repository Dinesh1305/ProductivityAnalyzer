package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "index";
	}
	
	
	@GetMapping("problems")
	public String get(Model m)
	{
		
		
		m.addAttribute("problems", repo.findAll());
		
	List<Problems>t=repo.findAll();
		for(Problems y:t)
		{
			System.out.println(y.getName()+"   "+y.getUrl());
		}
		return "ViewProblem";
		
	}
}
