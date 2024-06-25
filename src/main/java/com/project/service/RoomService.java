package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Room;
import com.project.dto.Users;
import com.project.exception.RoomNotFoundException;
import com.project.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	UserService userService;
	
	public Room save(Room room) {
		return roomRepository.save(room);
	}
	
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	
	public Room findById(int id) {
		Optional<Room> room = roomRepository.findById(id);
		if(room.isEmpty()) {
			throw new RoomNotFoundException("Requested room does not exist");
		}
		return room.get();
	}
	
	public void deleteById(int id) {
		roomRepository.deleteById(id);
	}
	
	public Room bookRoom(int id,int userId) {
		Room room = findById(id);
		Users user = userService.findById(userId);
		if(room != null && user != null) {
			room.setAvailable(false);
			room.setBookedBy(user);
			roomRepository.save(room);
		}
		return room;
	}
	
	public Room updateRoomAvailability(int id) {
		Room room = findById(id);
		if(room != null) {
			room.setAvailable(true);
			room.setBookedBy(null);
			roomRepository.save(room);
		}
		return room;
		
	}
}
