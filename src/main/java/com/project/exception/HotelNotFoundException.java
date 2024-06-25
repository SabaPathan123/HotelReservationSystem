package com.project.exception;


public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	public HotelNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
}
