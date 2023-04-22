package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.model.MenuType;
import com.satyamcompany.app.service.MenuTypeService;

@RestController
@RequestMapping("/menuTypes")
public class MenuTypeController {
 
	@Autowired
	private MenuTypeService menuTypeService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping
	public List<MenuType>findAll(){
	return menuTypeService.findAll();	
   }
	
	
	@GetMapping("/{name}")
	public 	MenuType findByTypeName(@PathVariable("name")String type_name) {
		return menuTypeService.findByTypeName(type_name);	
	}
	
	
	/*
	 * Used to create the resources
	 * parameter menuType
	 * return menuType
	 */
	@PostMapping
	public MenuType create(@RequestBody MenuType menuType) {
		return menuTypeService.create(menuType);
	}
	
	
	
}
