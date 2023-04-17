package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satyamcompany.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
