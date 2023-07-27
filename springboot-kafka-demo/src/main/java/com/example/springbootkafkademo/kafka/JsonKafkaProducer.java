package com.example.springbootkafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.springbootkafkademo.entity.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Value("${spring.kafka.topic-json.name}")
	private String topicJsonName;

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User data) {

		LOGGER.info("Message sent: " + data.toString());

		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, topicJsonName).build();
		kafkaTemplate.send(message);
	}
	
	//.\bin\windows\kafka-console-consumer.bat --topic namik --from-beginning --bootstrap-server localhost:9092

}
