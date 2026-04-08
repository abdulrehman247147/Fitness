package com.fitness.userservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.userservice.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
} 
