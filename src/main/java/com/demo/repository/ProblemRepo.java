package com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Problems;
@Repository
public interface ProblemRepo  extends JpaRepository<Problems,String>{
public void removeByName(String name);
}
