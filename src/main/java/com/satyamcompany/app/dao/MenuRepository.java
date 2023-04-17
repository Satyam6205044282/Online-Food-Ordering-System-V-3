package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.Menu;


public interface MenuRepository extends JpaRepository<Menu, Integer>{
	

}
