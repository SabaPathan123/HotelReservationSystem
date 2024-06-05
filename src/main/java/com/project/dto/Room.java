package com.project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "room_id")
	@SequenceGenerator(name = "room_id",initialValue = 200,allocationSize = 1)
	private int id;
	private String type;
	private double price;
	private boolean available;
	@ManyToOne
	@JoinColumn(name="userId")
	private Users bookedBy;
}
