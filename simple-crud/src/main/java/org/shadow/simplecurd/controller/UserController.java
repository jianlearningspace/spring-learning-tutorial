package org.shadow.simplecurd.controller;

import java.util.List;

import org.shadow.simplecurd.entity.User;
import org.shadow.simplecurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	public UserService userService;
	
	@GetMapping("/user")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@PostMapping("/user")
	public User save(
			@RequestBody User user) {
		return userService.save(user);
	}

}
