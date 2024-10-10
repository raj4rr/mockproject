package com.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FallBackController {

	@RequestMapping("/orderFallBack")
	public String orderFallBack(@RequestParam String param) {
		return new String("Order servive taking too long ...Try agaian");
	}

	@RequestMapping("/paymentFallBack")
	public String paymentFallBack(@RequestParam String param) {
		return new String("Payment servive taking too long ...Try agaian");
	}

}
