package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.Order;

public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
