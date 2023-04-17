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
@Table(name= "cart")
public class Cart {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int cartId;
	
	@Column(name= "customer_id")
	    private int customerId;
	
	@Column(name= "menu_id")
	    private int menuId;
	
	@Column(name= "price")
	    private float price;
	
	@Column(name= "quantity")
	    private int quantity;
	
	@Column(name= "total_amount")
	    private float totalAmount;
	    
	    public Cart(int customerId, int menuId, float price, int quantity, float totalAmount) {
			super();
			this.customerId = customerId;
			this.menuId = menuId;
			this.price = price;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
		}
	
}
