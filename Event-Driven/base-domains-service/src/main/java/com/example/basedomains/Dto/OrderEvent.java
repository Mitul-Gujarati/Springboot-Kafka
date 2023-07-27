package com.example.basedomains.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEvent {

	private String message;
	private String status;
	private Order order;

}
