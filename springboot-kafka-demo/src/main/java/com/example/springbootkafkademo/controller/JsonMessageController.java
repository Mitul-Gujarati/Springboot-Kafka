package com.example.springbootkafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafkademo.entity.User;
import com.example.springbootkafkademo.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer producer;

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user) {
		producer.sendMessage(user);
		return new ResponseEntity<String>("Json Message Sent To Kafka Topic.", HttpStatus.CREATED);
	}

}
