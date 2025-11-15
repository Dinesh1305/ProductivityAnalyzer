package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Problems;
import com.demo.repository.ProblemRepo;

@Service
public class ProblemService {

	@Autowired
	ProblemRepo repo;

	public void add(Problems problem) {
		repo.save(problem);

	}

	public void delete(String name) {
		repo.deleteById(name);
	}

	public List<Problems> getAll() {
		return repo.findAll();
	}

}
