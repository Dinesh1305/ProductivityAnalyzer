package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chart")

public class ChartController {


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

        // Labels for x-axis
        response.put("labels", List.of("Jan", "Feb", "Mar", "Apr", "May"));

        // Data for y-axis
        response.put("data", List.of(120, 150, 180, 90, 200));

        return response;

}
    
    
    
  
}
