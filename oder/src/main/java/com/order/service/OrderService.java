package com.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Order;
import com.order.model.Payment;
import com.order.repository.OrderRepository;
import com.order.request.TransactionRequest;
import com.order.response.TransactionResponse;



@Service
//@RefreshScope
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
   
	@Autowired
	@Lazy
	RestTemplate res;
	 private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	 
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String DO_PAYMENT_SERVICE_ENDPOINT_URL;

	public TransactionResponse addOrder(TransactionRequest transactionRequest) {
		logger.info("Order Service Called...");
		String response = "";
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setAmmount(order.getTotalPrice());
		payment.setOrderId(order.getId());
		// do Rest call to payment and pass the order id .
		Payment paymentResponse = res.postForObject(DO_PAYMENT_SERVICE_ENDPOINT_URL, payment, Payment.class);
		if (paymentResponse.getPaymentStatus().equals("Success"))
			response = "Payment done";
		else
			response = "Failed";
		logger.info("Payment status..."+response);
		TransactionResponse transactionResponse =new TransactionResponse();
		transactionResponse.setMessage(response);
		transactionResponse.setAmount(paymentResponse.getAmmount());
		transactionResponse.setTransactionId(paymentResponse.getTransactionId());
		order=orderRepository.save(order);
		transactionResponse.setOrder(order);
		
		return transactionResponse;

	}
	
	//rePayment in case of payment failed ..from GUI 

	

}
