package com.invillia.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entities.OrderItem;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repository.OrderItemRepository;
import com.invillia.acme.repository.OrderRepository;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemRepository orderItemrepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/order/{orderId}/items")
	public Iterable<OrderItem> retrieveAllOrderItemsByOrderId(@PathVariable Long orderId) {
		return orderItemrepository.findByOrderId(orderId);
	}
	
	@PostMapping("/order/{orderId}/items")
	public OrderItem addOrderItemToOrder(@PathVariable Long orderId, @RequestBody OrderItem orderItem) throws ResourceNotFoundException {
		return orderRepository.findById(orderId)
				.map(order -> {
					orderItem.setOrder(order);
					return orderItemrepository.save(orderItem);
				}).orElseThrow(() -> 
					new ResourceNotFoundException("Ordem informada: " + orderId.toString() + " não foi encontrada")
				);
	}
	
}
