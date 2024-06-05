package com.project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "hotel_id")
	@SequenceGenerator(name="hotel_id",initialValue = 100,allocationSize = 1)
	private int id;
	private String name;
	private String address;
	private String city;
	private String country;
}
