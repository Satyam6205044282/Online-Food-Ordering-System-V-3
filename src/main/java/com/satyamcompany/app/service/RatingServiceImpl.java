package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.RatingRepository;

import com.satyamcompany.app.model.Rating;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository repository;
	
	@Override
	public Rating create(Rating rating){
		return repository.save(rating); 
	}
}
