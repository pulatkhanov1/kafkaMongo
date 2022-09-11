package com.example.consumer.controller;

import com.example.consumer.model.User;
import com.example.consumer.service.UserConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConsumerController {

	private final UserConsumerService userConsumerService;

	public UserConsumerController(UserConsumerService userConsumerService) {
		this.userConsumerService = userConsumerService;
	}
	@GetMapping("/getUsers")
	public Iterable<User> getUsers() {
		return userConsumerService.getUsers();
	}

	@KafkaListener(topics= "kafka-task1", groupId = "grOne", containerFactory = "listenerConsumerFactory")
	public void consumeMessage(User user) {
		System.out.println("Consumed message: " + user);
		try {
			userConsumerService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
