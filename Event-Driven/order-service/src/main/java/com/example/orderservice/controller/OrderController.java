package com.example.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basedomains.Dto.Order;
import com.example.basedomains.Dto.OrderEvent;
import com.example.orderservice.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("Order Status Is In Pending State");
		orderEvent.setOrder(order);
		
		orderProducer.sendMessage(orderEvent); 
		
		return "Order Placed Succeessfully....";
	}

}
