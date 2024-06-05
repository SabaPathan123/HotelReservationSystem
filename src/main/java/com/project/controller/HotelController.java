package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Hotel;
import com.project.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return hotelService.save(hotel);
	}
	
	@GetMapping("/getHotel")
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/getHotel/{id}")
	public Hotel getHotelById(@PathVariable int id) {
		return hotelService.findHotelById(id);
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public void deleteById(@PathVariable int id) {
		hotelService.deleteById(id);
	}
}
