package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;


@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		//call apis
		
		paymentRepository.save(payment);
		return null;
	}

}
