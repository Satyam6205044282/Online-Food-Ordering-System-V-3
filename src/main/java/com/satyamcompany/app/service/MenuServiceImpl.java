package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamcompany.app.dao.MenuRepository;
import com.satyamcompany.app.model.Menu;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository repository;
	
	@Override
    public Menu create(Menu menu){
		return repository.save(menu);
	}
		
}


