package com.example.producer.service;

import com.example.producer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);
	private static final String TOPIC = "kafka-task1";

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void produce(User user){
		LOG.info("Sending message : {}", user);
		Message<User>message= MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, TOPIC)
				.build();
		System.out.println("Produced Message: "+user);
		this.kafkaTemplate.send(message);
	}
}
