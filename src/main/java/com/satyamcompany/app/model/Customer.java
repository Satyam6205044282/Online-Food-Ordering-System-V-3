package com.satyamcompany.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int customerId; 
	   
	@Column(name="customer_first_name")
	 private String customerFirstName;
	
	@Column(name="customer_last_name")
	 private String customerLastName;
	
	@Column(name="customer_email")
	    private String customerEmail;
	
	@Column(name="customer_phone_number")
	    private String customerPhoneNumber;
	
	@Column(name="customer_username")
	    private String customerUsername;
	
	@Column(name="customer_password")
	    private String customerPassword;
	
	@Column(name="account_status")
	    private int accountStatus;
	

//	@OneToOne(mappedBy= "customer")
//	private Order order;
	
	
	
	public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPhoneNumber,String customerUsername, String customerPassword, int accountStatus) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.accountStatus = accountStatus;
	}
	  	
	
}
