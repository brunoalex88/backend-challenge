package com.invillia.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.entities.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	List<OrderItem> findByOrderId(Long orderId);
}
