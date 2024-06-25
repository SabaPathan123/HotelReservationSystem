package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Hotel;
import com.project.exception.HotelNotFoundException;
import com.project.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	public Hotel save(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public List<Hotel> getAllHotels(){
		return hotelRepository.findAll();
	}
	
	public Hotel findHotelById(int id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);
		if(hotel.isEmpty()) {
			throw new HotelNotFoundException("Requested hotel does not exist");
		}
		return hotel.get();
	}
	
	public void deleteById(int id) {
		hotelRepository.deleteById(id);
	}
}
