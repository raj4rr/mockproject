package com.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class FallBackController {

	@RestController
	public class FallbackController {
	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallBack(){
	    return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServiceFallBack(){
	    return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
	}
	}

}
