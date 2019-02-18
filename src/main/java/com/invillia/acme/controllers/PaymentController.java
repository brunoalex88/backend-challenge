package com.invillia.acme.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entities.Payment;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.repository.PaymentRepository;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@PostMapping("/order/{orderId}/payment")
	public Payment createPayment(@PathVariable Long orderId, @RequestBody @Valid Payment payment) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			payment.setOrder(order);
			return paymentRepository.save(payment);
		}).orElseThrow(() -> 
			new ResourceNotFoundException("Ordem informada: " + orderId.toString() + " não encontrada")
		);
	}
	
	@GetMapping("payment")
	public Iterable<Payment> retrieveAll() {
		return paymentRepository.findAll();
	}
	
	@GetMapping("payment/{id}")
	public Optional<Payment> retrieveById(@PathVariable Long id) {
		return paymentRepository.findById(id);
	}
	
}
