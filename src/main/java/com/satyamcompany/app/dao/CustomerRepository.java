package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

