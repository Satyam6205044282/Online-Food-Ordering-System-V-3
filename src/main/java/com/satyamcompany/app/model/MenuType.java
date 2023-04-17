package com.satyamcompany.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "menu-type")
public class MenuType {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int menuTypeId;
	
	@Column(name= "type_name")
    private String typeName;
	
	@Column(name= "description")
    private String description;

	//many menu
	@OneToMany(mappedBy = "menuType")
	private List<Menu> menu= new ArrayList<>();
	
	
	public MenuType(String typeName, String description) {
		super();
		this.typeName = typeName;
		this.description = description;
	}
    
	
	
}
