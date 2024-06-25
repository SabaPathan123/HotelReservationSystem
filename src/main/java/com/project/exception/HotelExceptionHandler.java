package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HotelExceptionHandler {
	
	@ExceptionHandler(value = {HotelNotFoundException.class})
	public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException hotelNotFoundException){
		
		HotelReservationSystemException hotelException = new HotelReservationSystemException(hotelNotFoundException.getMessage(),
				hotelNotFoundException.getCause(),HttpStatus.NOT_FOUND);
	
		return new ResponseEntity<>(hotelException,HttpStatus.NOT_FOUND);
	
	}

}
