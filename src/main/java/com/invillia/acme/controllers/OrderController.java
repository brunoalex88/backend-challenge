package com.invillia.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entities.Order;
import com.invillia.acme.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository repository;
	
	@PostMapping("/order")
	public Order createOrdem(@RequestBody Order order) {
		return repository.save(order);
	}
	
	@GetMapping("/order")
	public Iterable<Order> retrieveAll() {
		return repository.findAll();
	}
	
}
