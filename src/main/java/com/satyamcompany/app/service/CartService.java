package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;

public interface CartService {
	
	public Cart create(Cart cart);
	
	public List<Cart>findAll();

	Cart findById(int customer_id) throws CartNotFoundException;
	
	public void deleteById(int cart_id)throws CartNotFoundException;

	public Cart update(int cart_id, Cart cart);

	
}
