package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Tasks;
import com.demo.repository.CompleteTaskRepo;

@Service 
public class ChartService {


@Autowired	
CompleteTaskRepo repo;


public List<Tasks> FullList()
{
	return repo.getFullList();


}



}