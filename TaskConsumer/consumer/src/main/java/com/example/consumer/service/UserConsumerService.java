package com.example.consumer.service;

import com.example.consumer.model.User;
import com.example.consumer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConsumerService {

private final UserRepository userRepository;

	public UserConsumerService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	public void saveUser(User user){
		userRepository.save(user);
	}

	public List<User> userList(){
	return userRepository.findAll();
	}
}
