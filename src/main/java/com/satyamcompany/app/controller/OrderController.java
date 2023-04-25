package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.exception.OrderNotFoundException;
import com.satyamcompany.app.model.Order;
import com.satyamcompany.app.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping("/orders")
	public List<Order>findAll(){
	return orderService.findAll();	
   }
	
	@GetMapping("/v1/orders")
	public ResponseEntity<List<Order>> findAllV1(){
		//log
		return new ResponseEntity<>(orderService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public 	Order findById(@PathVariable("id")int order_id) {
		return orderService.findById(order_id);
		
	}
	
	@GetMapping("/v1/orders/{id}")
	public ResponseEntity<Order> findByIdV1(@PathVariable("id") int order_id) throws OrderNotFoundException{
		return new ResponseEntity<Order>(orderService.findById(order_id), HttpStatus.OK);
	}
	
	
	/*
	 * Used to create the resources
	 * parameter order
	 * return order
	 */
	@PostMapping("/v1/orders")
	public Order create(@RequestBody Order order) {
		return orderService.create(order);
	}
	
	
	@PostMapping("/orders") 
	public Order createV1(@RequestBody Order order) {
		return orderService.create(order);
	}
}
