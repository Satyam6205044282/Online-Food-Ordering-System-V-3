package com.satyamcompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.OrderRepository;
import com.satyamcompany.app.exception.CustomerNotFoundException;
import com.satyamcompany.app.exception.OrderNotFoundException;
import com.satyamcompany.app.model.Order;

	@Service
	public class OrderServiceImpl implements OrderService{
		
		@Autowired
		private OrderRepository repository;
		
		@Override
		public Order create(Order order){
			return repository.save(order);
		}

		@Override
		public List<Order> findAll() {
			return repository.findAll();
		}

		@Override
		public Order findById(int order_id) throws OrderNotFoundException {
			Optional<Order>optional= repository.findById(order_id);
			if(optional.isEmpty()) {
			throw new CustomerNotFoundException("Order Not Found By Id: " + order_id);
			}
			return optional.get();
		}
	}

	
	