package com.satyamcompany.app.model;


import java.time.LocalDate;

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
@Table(name= "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private int ratingId;
	
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	@Column(name= "rate")
    private int rate;
	
	@Column(name= "feedback")
    private String feedback;
	
	@Column(name= "date_recorded")
    private LocalDate dateRecorded;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	
	
	
	
	public Rating(int rate, String feedback, LocalDate dateRecorded) {
		super();
		
	
		this.rate = rate;
		this.feedback = feedback;
		this.dateRecorded = dateRecorded;
	
	}
}
