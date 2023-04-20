package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping
	public List<Customer>findAll(){
	return service.findAll();	
   }
	
	
	@GetMapping("/{id}")
	public 	Customer findById(@PathVariable("id")int id) {
		return service.findById(id);
		
	}
	
	/*
	 * Used to create the resources
	 * parameter customer
	 * return customer
	 */
	@PostMapping
	public Customer create(@RequestBody Customer customer) {
		return service.create(customer);
	}
	
}
