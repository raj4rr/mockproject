package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request;
import com.example.demo.model.Response;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@PostMapping("/add")
	public Response addOrder(@RequestBody Request order) {
		
		return null;
	}
	
	
	

}
