package com.payment.test.service;

import static org.assertj.core.api.Assertions.assertThat;
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
		System.out.println(paymentRepository);
		System.out.println(paymentService);
		Payment doPayment = paymentService.doPayment(payment);
		System.out.println(doPayment);
		assertThat(doPayment).isNotNull();
	}

}
