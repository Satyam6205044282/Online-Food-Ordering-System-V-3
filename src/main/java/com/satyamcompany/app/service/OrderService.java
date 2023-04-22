package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.OrderNotFoundException;
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.model.Order;

public interface OrderService {
	public Order create(Order order);
	
	public List<Order>findAll();

	public Order findById(int order_id)throws OrderNotFoundException;
}
