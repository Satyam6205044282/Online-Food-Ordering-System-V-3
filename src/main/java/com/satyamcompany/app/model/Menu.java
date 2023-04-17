package com.satyamcompany.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int menuId;
	
	@Column(name= "menu_name")
    private String menuName;
	
	@Column(name= "price")
    private float price;
    
	@Column(name= "menu_type_id")
    private int menuTypeId;

	
	public Menu(String menuName, float price, int menuTypeId) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.menuTypeId = menuTypeId;
	}

	
	
	
	
}
