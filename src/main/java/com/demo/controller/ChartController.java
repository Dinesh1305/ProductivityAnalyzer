package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CompleteTasks;
import com.demo.model.Tasks;
import com.demo.service.CompleteTaskService;

@RestController
@RequestMapping("/api/chart")

public class ChartController {

	@Autowired
	CompleteTaskService service;
	
	


    
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
    
    @GetMapping("/week")
    public Map<String, Object> getWeek() {
        Map<String, Object> response = new HashMap<>();

        List<Tasks>t=service.getWeek();
        
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
    
    @GetMapping("/full")
    public Map<String, Object> getFull() {
        Map<String, Object> response = new HashMap<>();

        List<Tasks>t=service.getAll();
        
     //  System.out.println(t);
        List<CompleteTasks>t1=service.getall();
       
        
        for(Tasks y:t)
        {
        	 System.out.println(y);
        }
        
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
