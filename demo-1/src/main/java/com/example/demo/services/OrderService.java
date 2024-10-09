package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	
	public Order addOrder(Order order) {
		//call rest ....
		orderRepository.save(order);
		return null;
		
	}

}
