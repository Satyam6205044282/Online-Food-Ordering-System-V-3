package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.CustomerRepository;
import com.satyamcompany.app.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer create(Customer customer){
		return repository.save(customer);
	}
  
}

