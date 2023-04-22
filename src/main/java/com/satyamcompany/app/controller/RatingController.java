package com.satyamcompany.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.satyamcompany.app.model.Rating;
import com.satyamcompany.app.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	
	
	/*
	 * Used to create the resources
	 * parameter order
	 * return order
	 */
	@PostMapping
	public Rating create(@RequestBody Rating rating) {
		return ratingService.create(rating);
	}

	
}
