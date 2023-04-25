package com.satyamcompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamcompany.app.exception.MenuTypeNotFoundException;
import com.satyamcompany.app.model.MenuType;
import com.satyamcompany.app.service.MenuTypeService;

@RestController
@RequestMapping("/api")
public class MenuTypeController {
 
	@Autowired
	private MenuTypeService menuTypeService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping("/menuTypes")
	public List<MenuType>findAll(){
	return menuTypeService.findAll();	
   }
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/v1/menuTypes")
	public ResponseEntity<List<MenuType>> findAllV1(){
		//log
		return new ResponseEntity<>(menuTypeService.findAll(),HttpStatus.OK);
	}

	
	@GetMapping("/{typename}")
	public 	MenuType findByTypeName(@PathVariable("typename")String type_name) {
		return menuTypeService.findByTypeName(type_name);	
	}
	
	
	@GetMapping("/v1/menuTypes/{typename}")
	public ResponseEntity<MenuType> findByTypeNameV1(@PathVariable("typename") String type_name) throws MenuTypeNotFoundException{
		return new ResponseEntity<MenuType>(menuTypeService.findByTypeName(type_name), HttpStatus.OK);
	}
	
	
	/*
	 * Used to create the resources
	 * parameter menuType
	 * return menuType
	 */
	@PostMapping("/v1/menuTypes")
	public MenuType create(@RequestBody MenuType menuType) {
		return menuTypeService.create(menuType);
	}
	
	@PostMapping("/menuTypes") 
	public MenuType createV1(@RequestBody MenuType menuType) {
		return menuTypeService.create(menuType);
	}
	
}
