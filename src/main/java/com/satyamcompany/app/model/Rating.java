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
@Table(name= "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ratingId;
	
	@Column(name= "menu_id")
    private int menuId;
	
	@Column(name= "rate")
    private int rate;
	
	@Column(name= "feedback")
    private String feedback;
	
	@Column(name= "date_recorded")
    private String dateRecorded;
	
	@Column(name= "customer_id")
    private int customerId;
	
	
	
	
	public Rating(int menuId, int rate, String feedback, String dateRecorded, int customerId) {
		super();
		
		this.menuId = menuId;
		this.rate = rate;
		this.feedback = feedback;
		this.dateRecorded = dateRecorded;
		this.customerId = customerId;
	}
}
