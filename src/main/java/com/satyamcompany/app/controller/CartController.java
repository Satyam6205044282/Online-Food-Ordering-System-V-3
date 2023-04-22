package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
 
	@Autowired
	private CartService cartService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping
	public List<Cart>findAll(){
	return cartService.findAll();	
   }
	
	
	@GetMapping("/{id}")
	public 	Cart findById(@PathVariable("id")int cart_id) {
		return cartService.findById(cart_id);
		
	}
	
	/*
	 * Used to create the resources
	 * parameter cart
	 * return cart
	 */
	@PostMapping
	public Cart create(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id")int cart_id) {   
		cartService.deleteById(cart_id);
    }
	
}