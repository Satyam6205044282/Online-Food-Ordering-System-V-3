package com.satyamcompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.CustomerRepository;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer create(Customer customer){
		return repository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
	
		return repository.findAll();
	}

	@Override
	public Customer findById(int id) throws CustomerNotFoundException{
		Optional<Customer>optional= repository.findById(id);
		if(optional.isEmpty()) {
		throw new CustomerNotFoundException("Customer Not Found By Id: " + id);
		}
		return optional.get();
	}
  
	
	public void deleteById(int id) {
		repository.deleteById(id); 
	}
}

