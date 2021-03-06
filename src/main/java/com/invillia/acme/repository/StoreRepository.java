package com.invillia.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {
	List<Store> findByName(String name);
	List<Store> findByNameAndAddress(String name, String address);	
}
