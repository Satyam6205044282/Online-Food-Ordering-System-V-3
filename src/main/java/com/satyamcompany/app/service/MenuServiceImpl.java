package com.satyamcompany.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satyamcompany.app.dao.MenuRepository;
import com.satyamcompany.app.exception.MenuNotFoundException;
import com.satyamcompany.app.model.Menu;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository repository;
	
	@Override
    public Menu create(Menu menu){
		return repository.save(menu);
	}
	
	@Override
	public List<Menu> findAll() {
	
		return repository.findAll();
	} 

	@Override
	public Menu findByMenuName(String menu_name) throws MenuNotFoundException{
		Optional<Menu>optional= repository.findByMenuName(menu_name);
		if(optional.isEmpty()) {
		throw new MenuNotFoundException("Menu Not Found By Name: " + menu_name);
		}
		return optional.get();
	}
  
	

}
