package org.shadow.simplecurd.service;

import java.util.List;

import org.shadow.simplecurd.entity.User;
import org.shadow.simplecurd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

}
