package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.CompleteTasks;
import com.demo.model.Task;
import com.demo.repository.CompleteTaskRepo;
import com.demo.repository.TaskRepo;

@Service
public class TaskService {
	@Autowired
	TaskRepo task;
	@Autowired
	CompleteTaskRepo completetasksrepo;
	
	
	public void save(Task t)
	{
		
		long size =task.count();
		if(size==0)
		task.save(t);
	}


	public List<Task> get() {
		
		
		
		return task.findAll();
	}


	public void remove(Integer id) {
	Optional<Task> t=	task.findById(id);

	
	
	Task temp=t.get();
	task.delete(temp);	
	
	
	
	CompleteTasks completetasks=new CompleteTasks();
	completetasks.setStarting_time(temp.getTime());
	
	completetasks.setWork(temp.getWork());
	completetasksrepo.save(completetasks);
	
	}
	
	
	
	
	
}
