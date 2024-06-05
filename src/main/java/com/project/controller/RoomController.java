package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Room;
import com.project.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@PostMapping("/saveRoom")
	public Room saveRoom(@RequestBody Room room) {
		return roomService.save(room);
	}
	
	@GetMapping("/getAllRooms")
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@GetMapping("/getRoom/{id}")
	public Room getRoomById(@PathVariable int id) {
		return roomService.findById(id);
	}
	
	@DeleteMapping("/deleteRoom")
	public void deleteRoom(@PathVariable int id) {
		roomService.deleteById(id);
	}
	
	@PutMapping("/bookRoom/{roomId}/{userId}")
	public Room bookRoom(@PathVariable int roomId, @PathVariable int userId) {
		return roomService.bookRoom(roomId, userId);
	}
	
	@PutMapping("/updateRoom/{id}")
	public Room updateRoom(@PathVariable int id) {
		return roomService.updateRoomAvailability(id);
	}
}
