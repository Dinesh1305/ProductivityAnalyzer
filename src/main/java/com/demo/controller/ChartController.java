package com.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Tasks;
import com.demo.service.ChartService;
import com.demo.service.CompleteTaskService;

@RestController
@RequestMapping("/api/chart")

public class ChartController {

	@Autowired
	CompleteTaskService service;

	@Autowired
	ChartService service2;

	@GetMapping("/full")
	public Map<String, Object> getFull() {
		Map<String, Object> response = new HashMap<>();

		List<Tasks> t1 = service2.FullList();

		List<String> work = new ArrayList<>();

		List<Long> duration = new ArrayList<>();

		Map<Long, String> map = new TreeMap<>(Collections.reverseOrder());

		for (Tasks temp : t1) {

			map.put(temp.getTotalSeconds(), temp.getWork());
		}

		for (Long temp : map.keySet()) {

			duration.add(temp);
			work.add(map.get(temp));
		}
		// Labels for x-axis
		response.put("labels", work);

		// Data for y-axis
		response.put("data", duration);

		return response;

	}

	@GetMapping("/today")
	public Map<String, Object> getToday() {
		Map<String, Object> response = new HashMap<>();

		List<Tasks> t = service.getToday();

		List<String> work = new ArrayList<>();

		List<Long> duration = new ArrayList<>();

		for (Tasks temp : t) {
			work.add(temp.getWork());

			duration.add(temp.getTotalSeconds());
		}
		// Labels for x-axis
		response.put("labels", work);

		// Data for y-axis
		response.put("data", duration);

		return response;

	}

	@GetMapping("/week")
	public Map<String, Object> getWeek() {
		Map<String, Object> response = new HashMap<>();

		List<Tasks> t = service.getWeek();

		List<String> work = new ArrayList<>();

		List<Long> duration = new ArrayList<>();

		Map<Long, String> map = new TreeMap<>(Collections.reverseOrder());

		for (Tasks temp : t) {

			map.put(temp.getTotalSeconds(), temp.getWork());
		}

		for (Long temp : map.keySet()) {

			duration.add(temp);
			work.add(map.get(temp));
		}
		// Labels for x-axis
		response.put("labels", work);

		// Data for y-axis
		response.put("data", duration);

		return response;

	}

	@GetMapping("weekly")
	public Map<String, Object> getWeekly() {
		Map<String, Object> map = new HashMap<>();

		List<Object[]> t1 = service2.getWeekDuration();

		List<String> work = new ArrayList<>();

		List<Long> duration = new ArrayList<>();

		for (Object[] t : t1) {
			// System.out.println(t[0]+" "+t[1]);
			work.add(String.valueOf(t[0]));

			duration.add(((Number) t[1]).longValue());
		}
		map.put("labels", work);

		// Data for y-axis
		map.put("data", duration);

		return map;
	
	}

}
