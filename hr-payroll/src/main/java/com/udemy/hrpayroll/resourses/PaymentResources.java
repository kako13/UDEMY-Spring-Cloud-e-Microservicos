package com.udemy.hrpayroll.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.hrpayroll.entities.Payment;
import com.udemy.hrpayroll.service.obsoleto.PaymentService_RestTemplate;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	@Autowired
	private PaymentService_RestTemplate service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long workerId,
													@PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);

		return ResponseEntity.ok(payment);
	}
	
}
