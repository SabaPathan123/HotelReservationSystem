package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoomExceptionHandler {

	@ExceptionHandler(value = {RoomNotFoundException.class})
	public ResponseEntity<Object> handleRoomNotFoundException(RoomNotFoundException roomNotFoundException){
		
		HotelReservationSystemException hotelException = new HotelReservationSystemException(roomNotFoundException.getMessage(),
				roomNotFoundException.getCause(),HttpStatus.NOT_FOUND);
	
		return new ResponseEntity<>(hotelException,HttpStatus.NOT_FOUND);
		
	}
}
