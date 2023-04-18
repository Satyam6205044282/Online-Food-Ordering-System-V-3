package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.OrderRepository;
import com.satyamcompany.app.model.Order;

	@Service
	public class OrderServiceImpl implements OrderService{
		
		@Autowired
		private OrderRepository repository;
		
		@Override
		public Order create(Order order){
			return repository.save(order);
		}
	}
