package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.enity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/dopayment")
	public Payment doPayment(@RequestBody Payment order) throws InterruptedException {
		
		//Thread.sleep(1000000000);
		return paymentService.doPayment(order);
	}

}