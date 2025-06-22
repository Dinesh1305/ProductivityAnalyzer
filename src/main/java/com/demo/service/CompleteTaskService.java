package com.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.CompleteTasks;
import com.demo.model.Tasks;
import com.demo.repository.CompleteTaskRepo;

@Service
public class CompleteTaskService {

	@Autowired
	CompleteTaskRepo repo;
	public List<CompleteTasks> getall() {
	
	
		
		
		return 	repo.findTodayTasksSummary();
	}
	public List<CompleteTasks> find(Date d1, Date d2) {
	
		
		return repo.find(d1,d2);
	}

	public List<CompleteTasks> getDuartion()
	{
		return repo.getWorkDurations();
	}
	
	
	
	public List<Tasks> getAll()
	{
		return repo.getall();
	}
	public List<Tasks> getToday() {
		
		return repo.getTodayTasks();
	}
	public List<Tasks> getWeek() {
		
		return repo.getCurrentWeekTasks();
	}


}
