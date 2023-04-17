package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.CartRepository;
import com.satyamcompany.app.model.Cart;

@Service
public class CartServiceImpl {
	
	@Autowired
	private CartRepository repository;
	
	public Cart create(Cart cart){
		return repository.save(cart);
	}
  
}