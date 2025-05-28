package com.app.divyansh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.divyansh.model.LoginUser;
import com.app.divyansh.model.User;
import com.app.divyansh.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Tag(name="Users",description="User management operation's API")
public class UserController {
 
	@Autowired
	private UserService userServiceA;
	
	@PostMapping("/signup")
    @Operation(summary="Register first time users")
    public ResponseEntity<User> registerUser(@RequestBody User user){
    	return ResponseEntity.ok(userServiceA.saveUser(user));
    }
	
	@PostMapping("/login")
	@Operation(summary="Login user for further operations")
	public ResponseEntity<String> login(@RequestBody LoginUser loginRequest_User, HttpSession session) {
	    String email_User=loginRequest_User.getEmail();
	    String password_User=loginRequest_User.getPassword();
	    User user = userServiceA.loginUser(email_User, password_User);
	    session.setAttribute("loggedInUser", user);
	    return ResponseEntity.ok("Login successful for the user!");
	}
	@PostMapping("/logout")
	@Operation(summary="Logout user finally after operations")
	public ResponseEntity<String> logout(HttpSession session) {
	    session.invalidate();
	    return ResponseEntity.ok("Logged out successfully for the user.");
	}

}
