package com.invillia.acme.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.Payment;
import com.invillia.acme.entities.StatusEnum;
import com.invillia.acme.exceptions.ResourceNotFoundException;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.repository.PaymentRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@PostMapping("/order")
	public Order createOrdem(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/order")
	public Iterable<Order> retrieveAll() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Optional<Order> retrieveById(@PathVariable Long id) {
		return orderRepository.findById(id);
	}
	
	@GetMapping("/order/address/{address}/status/{status}/confirmationDate/{confirmationDate}")
	public Iterable<Order> retrieveOrderByAddressAndStatusAndConfirmationDate(@PathVariable String address, @PathVariable StatusEnum status, @PathVariable Date confirmationDate) {
		return orderRepository.findByAddressAndConfirmationDateAndStatus(address, confirmationDate, status);
	}
	
	@DeleteMapping("/order/{orderId}")
	public void refundOrder(@PathVariable Long orderId) throws ResourceNotFoundException {
		Payment payment = paymentRepository.findByOrderId(orderId);
		if (payment != null) {
			LocalDate paymentDate = payment.getPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
			LocalDate orderDate = payment.getOrder().getConfirmationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate atualDate = LocalDate.now();
			if (paymentDate.plusDays(10).isBefore(atualDate) 
					&& orderDate.plusDays(10).isBefore(atualDate)) {
				refundOrder(payment);
			}
		} else {
			throw new ResourceNotFoundException("Ordem informada: " + orderId.toString() + " não foi encontrada");
		}	
	}
	
	private void refundOrder(Payment payment) {
		paymentRepository.delete(payment);
	}
	
}
