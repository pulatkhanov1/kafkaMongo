package com.example.producer.controller;

import com.example.producer.model.User;
import com.example.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ProducerController {

	@Autowired
	KafkaProducerService kafkaProducerService;

	@PostMapping("/produce/{id}")
	public String sendMessage(@PathVariable int id){
		User user = new User("John", "Williams",
				             "williams@gmail.com", LocalDateTime.now());
		for (int i = 0; i < id; i++) {
			kafkaProducerService.produce(user);
		}
		return "Message successfully sent";
	}
}
