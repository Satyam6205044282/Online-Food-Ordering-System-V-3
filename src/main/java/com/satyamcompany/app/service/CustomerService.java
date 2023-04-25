package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.CustomerNotFoundException;
import com.satyamcompany.app.model.Customer;

public interface CustomerService {
	
public Customer create(Customer customer);
	
public List<Customer>findAll();

public Customer findById(int customer_id)throws CustomerNotFoundException;
 
public void deleteById(int customer_id)throws CustomerNotFoundException;

public Customer update(int customer_id, Customer customer);

}
