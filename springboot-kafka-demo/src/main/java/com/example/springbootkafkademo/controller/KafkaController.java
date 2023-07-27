package com.example.springbootkafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafkademo.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping("/publish/{message}")
	public ResponseEntity<String> sendMessage(@PathVariable String message) {
		kafkaProducer.sendMessage(message);
		return new ResponseEntity<String>("Message sent to the topic.", HttpStatus.OK);
	}

}
