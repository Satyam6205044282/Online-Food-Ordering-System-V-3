package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.exception.CustomerNotFoundException;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.service.CustomerService;


@RestController
@RequestMapping("/api") 
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping("/v1/customers")
	public ResponseEntity<List<Customer>> findAllV1(){
		//log
		return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") int customer_id) {
		return customerService.findById(customer_id);
	} 
	
	@GetMapping("/v1/customers/{id}")
	public ResponseEntity<Customer> findByIdV1(@PathVariable("id") int customer_id) throws CustomerNotFoundException{
		return new ResponseEntity<Customer>(customerService.findById(customer_id), HttpStatus.OK);
	}
	
	
	/**
	 * Used to create the resources
	 * @param employee
	 * @return employee
	 */
	@PostMapping("/v1/customers")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		ResponseEntity<Customer> responseEntity;
		responseEntity=new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/customers") 
	public Customer createV1(@RequestBody Customer customer) {
		return customerService.create(customer);
	}
	
	
	@DeleteMapping("/customers/{id}")	
	public void deleteById(@PathVariable("id") int customer_id) {
		 customerService.deleteById(customer_id);
	}
	
	@PutMapping("/customers/{id}")
	public Customer update(@PathVariable("id") int customer_id, @RequestBody Customer customer) {
		return customerService.update(customer_id, customer);
	}
	
	
}
