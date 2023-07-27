package com.example.stockservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.basedomains.Dto.OrderEvent;
import com.example.stockservice.Entity.OrderDetails;
import com.example.stockservice.repository.StockRepository;

@Service
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@Autowired
	private StockRepository repository;
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		
		LOGGER.info("Order Event Recieved In Stock Service => " + event.toString());
		
		//save the order event into the database
		OrderDetails order = new OrderDetails();
		order.setOrderId(event.getOrder().getOrderId());
		order.setName(event.getOrder().getName());
		order.setPrice(event.getOrder().getPrice());
		order.setQty(event.getOrder().getQty());
		
		repository.save(order);
	}

}
