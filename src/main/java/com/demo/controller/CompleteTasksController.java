package com.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.CompleteTasks;
import com.demo.model.Tasks;
import com.demo.service.CompleteTaskService;

@Controller
public class CompleteTasksController {

	@Autowired
	CompleteTaskService service;

	@GetMapping("Complete")
	public String complete(Model model) {

		List<CompleteTasks> k = service.getall();
		model.addAttribute("List", k);
		return "task";

	}

	@GetMapping("between")
	public String getTasks(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, Model model) {

		Date d1 = java.sql.Date.valueOf(startDate);
		Date d2 = java.sql.Date.valueOf(endDate);

		model.addAttribute("List", service.find(d1, d2));
		return "task";

	}

	@GetMapping("getAll")
	public String findAll(Model m) {
		List<Tasks> t = service.getAll();

		m.addAttribute("tasks", t);
		return "duration";
	}

	@GetMapping("week")
	public String findWeek(Model m) {
		m.addAttribute("tasks", service.getWeek());

		return "duration";
	}

	@GetMapping("today")
	public String findToday(Model m) {

		
		
		List<Tasks> t = service.getToday();
		//System.out.print(service.getDuartion());
		m.addAttribute("tasks", t);
		return "duration";
	}

	@GetMapping("date")
	public String FilterByDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			Model m) {
		Date t = java.sql.Date.valueOf(date);

		m.addAttribute("tasks", service.filterByDate(t));

		return "duration-summary";
	}

	@PostMapping("/removeTask/{id}")
	public String removeTask(@PathVariable int id) {
		service.Remove(id);
		return "index";
	}

}
