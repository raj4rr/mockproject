package com.payment;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.controller.PaymentController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	PaymentController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
