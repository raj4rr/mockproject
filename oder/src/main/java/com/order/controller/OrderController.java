package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.request.TransactionRequest;
import com.order.response.TransactionResponse;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
	public TransactionResponse addOrder(@RequestBody TransactionRequest transactionRequest) {
		
		
		return orderService.addOrder(transactionRequest);
	}
	
	

}
