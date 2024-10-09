package com.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.enity.Payment;
import com.payment.respository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing(payment));
			payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	//
	public String paymentProcessing(Payment payment) {
		//api should be 3dr part party payment gateway( paypay,gpay etc) 
		if(payment.getAmmount()>=1000) return "false";
		if(payment.getAmmount()<=200) return "Success";
		return new Random().nextBoolean()?"Success":"false";
}

}
