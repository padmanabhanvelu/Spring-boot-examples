package com.demo.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    //User findByUsername(String username);
}