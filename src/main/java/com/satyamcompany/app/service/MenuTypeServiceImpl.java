package com.satyamcompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satyamcompany.app.dao.MenuTypeRepository;
import com.satyamcompany.app.exception.MenuTypeNotFoundException;
import com.satyamcompany.app.model.MenuType;

@Service
public class MenuTypeServiceImpl implements MenuTypeService{
	
	@Autowired
	private MenuTypeRepository repository;
	
	@Override
	public MenuType create(MenuType menuType){
		return repository.save(menuType);
	}
	
	@Override
	public List<MenuType> findAll() {
	
		return repository.findAll();
	} 

	@Override
	public MenuType findByTypeName(String type_name) throws MenuTypeNotFoundException{
		Optional<MenuType>optional= repository.findByTypeName(type_name);
		if(optional.isEmpty()) {
		throw new MenuTypeNotFoundException("MenuType Not Found By Type-Name: " + type_name);
		}
		return optional.get();
	}
	
}
