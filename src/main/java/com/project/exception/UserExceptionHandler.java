package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException){
		
		HotelReservationSystemException hotelException = new HotelReservationSystemException(userNotFoundException.getMessage(),
				userNotFoundException.getCause(),HttpStatus.NOT_FOUND);
	
		return new ResponseEntity<>(hotelException,HttpStatus.NOT_FOUND);
	}

}
