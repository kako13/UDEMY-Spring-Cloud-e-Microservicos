package com.udemy.hrpayroll.service;

import org.springframework.stereotype.Service;

import com.udemy.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	/*
	 * Retorna pagamento mockado
	*/	
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.00, days);
	}
}
