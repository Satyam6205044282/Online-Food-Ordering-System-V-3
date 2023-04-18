package com.satyamcompany.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satyamcompany.app.dao.MenuTypeRepository;
import com.satyamcompany.app.model.MenuType;

@Service
public class MenuTypeServiceImpl implements MenuTypeService{
	
	@Autowired
	private MenuTypeRepository repository;
	
	@Override
	public MenuType create(MenuType menuType){
		return repository.save(menuType);
	}
}
