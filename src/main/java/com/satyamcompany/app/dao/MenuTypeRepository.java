package com.satyamcompany.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamcompany.app.model.MenuType;

	
	public interface MenuTypeRepository extends JpaRepository<MenuType, Integer>{
		
  }
