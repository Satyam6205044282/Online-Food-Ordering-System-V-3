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

import com.satyamcompany.app.exception.MenuNotFoundException;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.service.MenuService;

@RestController
@RequestMapping("/api")
public class MenuController {
 
	@Autowired
	private MenuService menuService;
	
	
	/*
	 * Used to retrive the resources
	 * @return
	 */
	@GetMapping("/menus")
	public List<Menu>findAll(){
	return menuService.findAll();	
   }
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/v1/menus")
	public ResponseEntity<List<Menu>> findAllV1(){
		//log
		return new ResponseEntity<>(menuService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{name}")
	public 	Menu findByMenuName(@PathVariable("name")String menu_name) {
		return menuService.findByMenuName(menu_name);	
	}
	
	@GetMapping("/v1/menus/{name}")
	public ResponseEntity<Menu> findByMenuNameV1(@PathVariable("name") String menu_name) throws MenuNotFoundException{
		return new ResponseEntity<Menu>(menuService.findByMenuName(menu_name), HttpStatus.OK);
	}
	
	
	/*
	 * Used to create the resources
	 * parameter menu
	 * return menu
	 */
	@PostMapping("/v1/menus")
	public Menu create(@RequestBody Menu menu) {
		return menuService.create(menu);
	}
	
	@PostMapping("/menus") 
	public Menu createV1(@RequestBody Menu menu) {
		return menuService.create(menu);
	}
	
}
