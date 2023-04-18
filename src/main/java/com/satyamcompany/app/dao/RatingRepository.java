package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.Rating;

	public interface RatingRepository  extends JpaRepository<Rating, Integer>{
	
}
