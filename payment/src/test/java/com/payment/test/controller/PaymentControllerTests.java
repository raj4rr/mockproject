package com.payment.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.enity.Payment;
import com.payment.service.PaymentService;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	PaymentService paymentService;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void doPayment() throws Exception {
		Payment payment = new Payment();
		payment.setAmmount(199);
		payment.setOrderId(12);

		MvcResult result = mockMvc
				.perform(post("/payment/dopayment").
						contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(payment)))
				.andReturn();
		result.getResponse().getContentAsByteArray();
		Payment resposnepayment = mapper.readValue(result.getResponse().getContentAsByteArray(), Payment.class);
		assertEquals("Success", resposnepayment.getPaymentStatus());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
