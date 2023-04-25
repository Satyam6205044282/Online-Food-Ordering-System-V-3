package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exception.MenuTypeNotFoundException;
import com.satyamcompany.app.model.MenuType;

public interface MenuTypeService {
	
	public MenuType create(MenuType menuType);
	
	public List<MenuType>findAll();

	public MenuType findByTypeName(String type_name)throws MenuTypeNotFoundException;





}
