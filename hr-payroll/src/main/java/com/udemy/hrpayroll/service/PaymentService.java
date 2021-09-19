package com.udemy.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.hrpayroll.clients.WorkerFeignClients;
import com.udemy.hrpayroll.entities.Payment;
import com.udemy.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private  WorkerFeignClients workerFeignClients;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		Worker worker = workerFeignClients.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
