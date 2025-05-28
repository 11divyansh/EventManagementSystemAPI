package com.app.divyansh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.divyansh.model.User;
import com.app.divyansh.repository.UserRepository;

@Service
public class UserService {

	
	 @Autowired
	 private UserRepository userRepositoryA;
	 
	 @Autowired
	    private PasswordEncoder passwordEncoderB;

	 public User saveUser(User user){
		 
		 return userRepositoryA.save(user);
	 }
	 public User loginUser(String emailForUser,String passwordForUser) {
	        return userRepositoryA.findByUserEmailAndUserPassword(emailForUser,passwordForUser)
	                .orElseThrow(()->new RuntimeException("Invalid credentials"));
	 }
}
