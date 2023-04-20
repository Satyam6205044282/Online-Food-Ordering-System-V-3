package com.satyamcompany.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "cart")
public class Cart {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int cartId;

	
	@Column(name= "menu_name")
    private String menuName;
	
	@Column(name= "price")
	    private float price;
	
	@Column(name= "quantity")
	    private int quantity;
	
	@Column(name= "total_amount")
	    private float totalAmount;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Order order;

	@OneToOne(mappedBy = "cart")
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	    
	    public Cart(String menuName, float price, int quantity, float totalAmount) {
			super();
		
			this.menuName = menuName;
			this.price = price;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
		}
	
}
