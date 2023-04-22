package com.satyamcompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.CartRepository;
import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository repository;
	
	@Override
	public Cart create(Cart cart){
		return repository.save(cart);
	}
	
	@Override
	public List<Cart> findAll() {
	
		return repository.findAll();
	}

	@Override
	public Cart findById(int cart_id) throws CartNotFoundException{
		Optional<Cart>optional= repository.findById(cart_id);
		if(optional.isEmpty()) {
		throw new CartNotFoundException("Cart Not Found By Id: " + cart_id);
		}
		return optional.get();
	}
  
	@Override
	public void deleteById(int cart_id)throws CartNotFoundException {
		Cart cart= findById(cart_id);
		repository.deleteById(cart_id); 
	}
}
