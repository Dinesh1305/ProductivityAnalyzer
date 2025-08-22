package com.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Users;

public interface UsersRepo extends JpaRepository<Users, UUID> {

}
