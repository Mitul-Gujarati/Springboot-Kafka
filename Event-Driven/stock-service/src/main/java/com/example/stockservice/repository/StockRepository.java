package com.example.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stockservice.Entity.OrderDetails;

@Repository
public interface StockRepository extends JpaRepository<OrderDetails, String> {

}
