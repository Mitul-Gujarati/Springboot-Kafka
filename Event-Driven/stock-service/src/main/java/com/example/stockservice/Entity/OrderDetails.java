package com.example.stockservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetails {
	
	@Id
	private String orderId;
	private String name;
	private int qty;
	private double price;
}
