package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.exception.CartNotFoundException;
import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.service.CartService;


@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	/**
	 * Used to retrieve the resources
	 * @return
	 */
	@GetMapping("/carts")
	public List<Cart> findAll(){
		return cartService.findAll();
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping("/v1/carts")
	public ResponseEntity<List<Cart>> findAllV1(){
		//log
		return new ResponseEntity<>(cartService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/carts/{id}")
	public Cart findById(@PathVariable("id") int customer_id) {
		return cartService.findById(customer_id);
	} 
	
	@GetMapping("/v1/carts/{id}")
	public ResponseEntity<Cart> findByIdV1(@PathVariable("id") int customer_id) throws CartNotFoundException{
		return new ResponseEntity<Cart>(cartService.findById(customer_id), HttpStatus.OK);
	}
	
	
	/**
	 * Used to create the resources
	 * @param cart
	 * @return cart
	 */
	@PostMapping("/v1/carts")
	public ResponseEntity<Cart> create(@RequestBody Cart cart) {
		ResponseEntity<Cart> responseEntity;
		responseEntity=new ResponseEntity<>(cartService.create(cart), HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/carts") 
	public Cart createV1(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	
	@DeleteMapping("/carts/{id}")	
	public void deleteById(@PathVariable("id") int cart_id) {
		 cartService.deleteById(cart_id);
	}
	
	@PutMapping("/carts/{id}")
	public Cart update(@PathVariable("id") int cart_id, @RequestBody Cart cart) {
		return cartService.update(cart_id, cart);
	}
	
	
}
