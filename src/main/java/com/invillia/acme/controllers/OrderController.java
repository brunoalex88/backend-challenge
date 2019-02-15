package com.invillia.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository repository;
	
	@PostMapping("/order")
	public void createOrdem() {
		
	}
	
}
