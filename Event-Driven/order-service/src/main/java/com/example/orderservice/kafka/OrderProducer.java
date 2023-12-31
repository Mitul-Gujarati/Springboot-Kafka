package com.example.orderservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.basedomains.Dto.Order;
import com.example.basedomains.Dto.OrderEvent;

@Service
public class OrderProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

	private NewTopic topic;

	private KafkaTemplate<String, Order> kafkaTemplate;

	public OrderProducer(NewTopic topic, KafkaTemplate<String, Order> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(OrderEvent event) {

		// log event
		LOGGER.info("Order Event => " + event.toString());

		// create message
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		
		//send message
		kafkaTemplate.send(message);

	}

}
