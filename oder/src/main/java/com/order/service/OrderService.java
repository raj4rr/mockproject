package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Order;
import com.order.model.Payment;
import com.order.repository.OrderRepository;
import com.order.request.TransactionRequest;
import com.order.response.TransactionResponse;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RestTemplate res;

	public TransactionResponse addOrder(TransactionRequest transactionRequest) {
		String response = "";
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setAmmount(order.getTotalPrice());
		payment.setOrderId(order.getId());
		//
		Payment paymentResponse = res.postForObject("http://localhost:8088/payment/dopayment", payment, Payment.class);
		if (paymentResponse.getPaymentStatus().equals("Success"))
			response = "Payment done";
		else
			response = "Failed";
		TransactionResponse transactionResponse =new TransactionResponse();
		transactionResponse.setMessage(response);
		transactionResponse.setAmount(paymentResponse.getAmmount());
		transactionResponse.setTransactionId(paymentResponse.getTransactionId());
		order=orderRepository.save(order);
		transactionResponse.setOrder(order);
		return transactionResponse;

	}

	// do Rest call to payment and pass the order id .

}
