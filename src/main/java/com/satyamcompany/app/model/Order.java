package com.satyamcompany.app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name= "`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "order_id")
	private int orderId;
    
	@Column(name= "order_date")
    private String orderDate;
    
	@Column(name= "total_amount")
    private String totalAmount;
	
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<Cart> cart= new ArrayList<>();

	
	
	public Order(String orderDate, String totalAmount) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		
		
	}
	
}




























//package com.satyamcompany.app.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name= "`order`")
//public class Order {
//	
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	private int orderId;
//	
//    
//	@Column(name= "order_date")
//    private String orderDate;
//    
//	@Column(name= "total_amount")
//    private String totalAmount;
//	
//	
//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
//	
//	@OneToMany(mappedBy = "order")
//	private List<Cart> cart= new ArrayList<>();
//
//	
//	
//	public Order(String orderDate, String totalAmount) {
//		super();
//		this.orderDate = orderDate;
//		this.totalAmount = totalAmount;
//		
//		
//	}
//	
//}
