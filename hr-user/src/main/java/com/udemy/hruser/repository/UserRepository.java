package com.udemy.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
