package org.shadow.simplecurd.controller;

import java.util.List;
import java.util.Map;

import org.shadow.simplecurd.entity.User;
import org.shadow.simplecurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/user/findAllMap")
	public List<Map<String, Object>> findAllMap(){
		return userService.findAllMap();
	}
	
	@GetMapping("/user/findAllByPage")
	public List<User> findAllByPage(
			@PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable pageable) {
		return userService.findAllByPage(pageable);
	}
	
	@PostMapping("/user")
	public User save(
			@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/user")
	public User update(
			@RequestBody User user) {
		return userService.save(user);//存在id即执行更新
	}
	
	@DeleteMapping("/user/{id}")
	public User delete(
			@PathVariable long id) {
		User user = userService.findByID(id);
		userService.delete(id);
		return user;
	}

}
