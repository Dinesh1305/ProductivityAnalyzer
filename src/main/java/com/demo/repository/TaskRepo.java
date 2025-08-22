package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

}
