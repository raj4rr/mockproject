package com.payment.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.enity.Payment;
import com.payment.respository.PaymentRepository;
import com.payment.service.PaymentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTests {

	@Mock
	private PaymentRepository paymentRepository;

	@InjectMocks
	private PaymentService paymentService;

	private Payment payment;

	@BeforeEach
	public void setup() {
		payment = new Payment();
		payment.setAmmount(100);
		payment.setOrderId(2);

	}

	@Test
	public void doPayment() {

		when(paymentRepository.save(payment)).thenReturn(payment);
		Payment doPayment = paymentService.doPayment(payment);
		assertThat(doPayment).isNotNull();
	}

	@Test
	public void paymentProcessing() {
		// when(paymentRepository.save(payment)).thenReturn(payment);
		String str = paymentService.paymentProcessing(payment);
		assertEquals("Success", str);
		;
	}

}
