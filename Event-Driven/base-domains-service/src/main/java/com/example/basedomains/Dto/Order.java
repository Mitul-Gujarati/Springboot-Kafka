package com.example.basedomains.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

	private String orderId;
	private String name;
	private int qty;
	private double price;

}
