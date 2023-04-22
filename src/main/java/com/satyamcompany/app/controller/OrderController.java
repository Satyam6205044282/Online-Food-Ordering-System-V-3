package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.model.Order;
import com.satyamcompany.app.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping
	public List<Order>findAll(){
	return orderService.findAll();	
   }
	
	
	@GetMapping("/{id}")
	public 	Order findById(@PathVariable("id")int order_id) {
		return orderService.findById(order_id);
		
	}
	
	/*
	 * Used to create the resources
	 * parameter order
	 * return order
	 */
	@PostMapping
	public Order create(@RequestBody Order order) {
		return orderService.create(order);
	}
	
}
