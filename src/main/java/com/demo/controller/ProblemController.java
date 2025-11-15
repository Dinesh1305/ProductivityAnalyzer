package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Problems;
import com.demo.service.ProblemService;

@Controller
public class ProblemController {

	@Autowired
	ProblemService service;

	@PostMapping("addProblem")
	public String add(@ModelAttribute Problems p) {
		service.add(p);
		return "index";
	}

	@GetMapping("problems")
	public String get(Model m) {

		m.addAttribute("problems", service.getAll());

		return "ViewProblem";

	}

	@PostMapping("remove")
	public String remove(@RequestParam("name") String name) {
		service.delete(name);
		return "index";
	}
}
