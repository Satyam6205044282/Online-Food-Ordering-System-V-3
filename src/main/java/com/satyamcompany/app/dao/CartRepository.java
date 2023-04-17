package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.Cart;

	public interface CartRepository extends JpaRepository<Cart, Integer>{
		
}
