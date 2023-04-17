package com.satyamcompany.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
	
	
	@ManyToOne
	@JoinColumn(name = "menu_type_id")
	private MenuType menuType;
	
	public Menu(String menuName, float price) {
		super();
		this.menuName = menuName;
		this.price = price;
		
	}
	
	
	
}
