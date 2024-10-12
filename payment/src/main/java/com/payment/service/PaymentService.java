package com.payment.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.enity.Payment;
import com.payment.respository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);


	public Payment doPayment(Payment payment) {
		logger.debug("Do Payment Called ...");
		payment.setPaymentStatus(paymentProcessing(payment));
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	//
	public String paymentProcessing(Payment payment) {
		// api should be 3dr part party payment gateway( paypay,gpay etc)
		if (payment.getAmmount() >= 1000) {
			
			logger.info("Payment Failed ...");
			return "Failed";
		}
			
		if (payment.getAmmount() <= 200) {
			logger.info("Payment Success ...");
			return "Success";
		}
		else
		return new Random().nextBoolean() ? "Success" : "Failed";
	}

}
