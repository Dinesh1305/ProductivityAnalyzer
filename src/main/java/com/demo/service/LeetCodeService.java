package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Problems;
import com.demo.repository.ProblemRepo;

@Service
public class LeetCodeService {
	
	@Autowired
	ProblemRepo pr;


	public void remove(Problems p)
	{
	//	pr.removeById(p.getId());
		pr.delete(p);
	}
	
}
