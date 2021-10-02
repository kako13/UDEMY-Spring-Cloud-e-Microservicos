package com.udemy.hrpayroll.service.obsoleto;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.udemy.hrpayroll.entities.Payment;
import com.udemy.hrpayroll.entities.Worker;

//@Service
public class PaymentService_RestTemplate {
	
	@Value("${hr-worker.host}")
	private String WORKER_HOST; 
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		
		Worker worker = restTemplate.getForObject(WORKER_HOST+"/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
