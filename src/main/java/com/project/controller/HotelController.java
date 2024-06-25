package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Hotel;
import com.project.response.ResponseHandler;
import com.project.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public ResponseEntity<Object> saveHotel(@RequestBody Hotel hotel) {
		
		return ResponseHandler.responseBuilder("New hotel saved.",
				HttpStatus.OK, hotelService.save(hotel));
		
	}
	
	@GetMapping("/getHotel")
	public ResponseEntity<Object> getAllHotels(){
		
		return ResponseHandler.responseBuilder("List of Hotels.",
				HttpStatus.OK, hotelService.getAllHotels());
	}
	
	@GetMapping("/getHotel/{id}")
	public ResponseEntity<Object> getHotelById(@PathVariable int id) {
		return ResponseHandler.responseBuilder("Requested hotel details are given here.",
				HttpStatus.OK, hotelService.findHotelById(id));
		 
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public void deleteById(@PathVariable int id) {
		hotelService.deleteById(id);
	}
}
