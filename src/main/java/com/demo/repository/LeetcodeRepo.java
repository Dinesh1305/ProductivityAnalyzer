package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.LeetCodeModel;

@Repository
public interface LeetcodeRepo extends JpaRepository<LeetCodeModel,Integer> {

}
