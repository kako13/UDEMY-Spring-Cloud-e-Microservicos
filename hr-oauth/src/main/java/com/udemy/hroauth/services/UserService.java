package com.udemy.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.hroauth.clients.UserFeignClient;
import com.udemy.hroauth.entities.User;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserFeignClient userFeignClient;
	
	public User findByEmail(String email) throws IllegalAccessException {
		
		User user = userFeignClient.findById(email).getBody();
		
		if (user == null) {
			logger.error("Email not foud: " + email);
			throw new IllegalAccessException("Email not found");
		}
		logger.info("Email found: " + email);
		return user;
	}
	
	
	
	
}
