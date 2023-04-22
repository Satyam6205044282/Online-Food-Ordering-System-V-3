package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;

public interface CartService {
	
	public Cart create(Cart cart);
	
	public List<Cart>findAll();

	public Cart findById(int cart_id)throws CartNotFoundException;
	 
	public void deleteById(int cart_id)throws CartNotFoundException;
}
