package com.invillia.acme.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.entities.Order;
import com.invillia.acme.entities.StatusEnum;

public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findByAddressAndConfirmationDateAndStatus(String address, Date confirmationDate, StatusEnum status);
}
