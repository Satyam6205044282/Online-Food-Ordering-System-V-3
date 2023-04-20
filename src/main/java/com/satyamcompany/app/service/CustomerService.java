package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.model.Customer;

public interface CustomerService {
	
public Customer create(Customer customer);
	
public List<Customer>findAll();

public Customer findById(int id);

}
