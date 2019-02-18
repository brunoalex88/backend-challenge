package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
	Payment findByOrderId(Long orderId);
}
