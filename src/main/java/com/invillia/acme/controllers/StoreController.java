package com.invillia.acme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entities.Store;
import com.invillia.acme.repository.StoreRepository;

@RestController 
public class StoreController {

	@Autowired
	private StoreRepository repository;

	@PostMapping("/store")
	public Store create(@RequestBody Store store) {
		return repository.save(store);
	}	
	
	@PutMapping("/store/{id}")
	public Store update(@PathVariable Long id, @RequestBody Store store) {
		return repository.findById(id).map(newStore -> {
			newStore.setAddress(store.getAddress());
			newStore.setName(store.getName());
			return repository.save(newStore);
		}).orElseGet(() -> repository.save(store));
	}
	
	@GetMapping("/store")
	public Iterable<Store> retrieveAll() {
		return repository.findAll();
	}

	@GetMapping("/store/{id}")
	public Optional<Store> retrieveById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("/store/name/{name}/address/{address}")
	public List<Store> retrieveByNameAndAddress(@PathVariable String name, @PathVariable String address) {
		return repository.findByNameAndAddress(name, address);
	}

}
