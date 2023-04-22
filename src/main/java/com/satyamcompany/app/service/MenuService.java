package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.MenuNotFoundException;
import com.satyamcompany.app.model.Menu;

public interface MenuService {
	
	public Menu create(Menu menu);
	
	public List<Menu>findAll();

	public Menu findByMenuName(String menu_name)throws MenuNotFoundException;
	
}
