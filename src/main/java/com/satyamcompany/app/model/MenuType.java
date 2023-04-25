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

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "`menu-type`")
public class MenuType implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "menu_type_id")
	private int menuTypeId;
	
	@Column(name= "type_name")
    private String typeName;
	
	@Column(name= "description")
    private String description;

	
	
	public MenuType(String typeName, String description) {
		super();
		this.typeName = typeName;
		this.description = description;

	}
    
	
	
}