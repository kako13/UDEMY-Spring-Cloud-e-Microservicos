package com.udemy.hrpayroll.resourses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udemy.hrpayroll.entities.Payment;
import com.udemy.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	private static Logger logger = LoggerFactory.getLogger(PaymentResources.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
													@PathVariable Integer days){
		
		logger.info("PORT = "+ env.getProperty("local.server.port"));
		
		Payment payment = service.getPayment(workerId, days);

		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
		
		Payment payment = new Payment("Brann", 400.0, days);

		return ResponseEntity.ok(payment);
	}
}
