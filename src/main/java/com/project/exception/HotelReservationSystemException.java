package com.project.exception;

import org.springframework.http.HttpStatus;

public class HotelReservationSystemException {

	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public HotelReservationSystemException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	
	
}
