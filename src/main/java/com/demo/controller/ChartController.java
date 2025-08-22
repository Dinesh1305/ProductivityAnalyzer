package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Tasks;
import com.demo.service.CompleteTaskService;

@RestController
@RequestMapping("/api/chart")

public class ChartController {

	@Autowired
	CompleteTaskService service;
	

    @GetMapping("/sales")
    public Map<String, Object> getSalesData() {
        Map<String, Object> response = new HashMap<>();

        // Labels for x-axis
   
        
        
        
        
        response.put("labels", List.of("Jan", "Feb", "Mar", "Apr", "May"));

        // Data for y-axis
        response.put("data", List.of(120, 150, 180, 90, 200));

        return response;

}
    
    @GetMapping("/today")
    public Map<String, Object> getToday() {
        Map<String, Object> response = new HashMap<>();

        List<Tasks>t=service.getToday();
        
        System.out.println(t);
        
        
        List<String>work=new ArrayList<>();
        
        List<Long>duration=new ArrayList<>();
        
        for(Tasks temp:t)
        {
        	work.add(temp.getWork());
        	
        	duration.add(temp.getTotalSeconds());
        }
        // Labels for x-axis
        response.put("labels", work);

        // Data for y-axis
        response.put("data", duration);

        return response;

}
    
    
    
  
}
