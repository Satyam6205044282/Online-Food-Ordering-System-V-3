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
	  
	
	public int getCustomerId() {
		return customerId;
	}

	

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	

	public String getCustomerLastName() {
		return customerLastName;
	}

	

	public String getCustomerEmail() {
		return customerEmail;
	}

	
	
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	

	public String getCustomerUsername() {
		return customerUsername;
	}

	

	public String getCustomerPassword() {
		return customerPassword;
	}

	
	
	public int getAccountStatus() {
		return accountStatus;
	}

	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerEmail=" + customerEmail
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", customerUsername=" + customerUsername
				+ ", customerPassword=" + customerPassword + ", accountStatus=" + accountStatus + "]";
	}
	
	
	
}
