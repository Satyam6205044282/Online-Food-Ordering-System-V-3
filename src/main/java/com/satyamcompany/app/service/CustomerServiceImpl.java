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
	public Customer findById(int customer_id) throws CustomerNotFoundException{
		Optional<Customer>optional= repository.findById(customer_id);
		if(optional.isEmpty()) {
		throw new CustomerNotFoundException("Customer Not Found By Id: " + customer_id);
		}
		return optional.get();
	}
  
	@Override
	public void deleteById(int customer_id)throws CustomerNotFoundException {
		Customer customer= findById(customer_id);
		repository.deleteById(customer_id); 
	}
}

