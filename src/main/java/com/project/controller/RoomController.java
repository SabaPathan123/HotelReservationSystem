package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.project.response.ResponseHandler;
import com.project.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@PostMapping("/saveRoom")
	public ResponseEntity<Object> saveRoom(@RequestBody Room room) {
		return ResponseHandler.responseBuilder("New room saved.", HttpStatus.OK, roomService.save(room));
	}
	
	@GetMapping("/getAllRooms")
	public ResponseEntity<Object> getAllRooms() {
		return ResponseHandler.responseBuilder("List of Rooms", HttpStatus.OK, roomService.getAllRooms());
	}
	
	@GetMapping("/getRoom/{id}")
	public ResponseEntity<Object> getRoomById(@PathVariable int id) {
		return ResponseHandler.responseBuilder("Requested room details are given here", HttpStatus.OK,  roomService.findById(id));
	}
	
	@DeleteMapping("/deleteRoom")
	public void deleteRoom(@PathVariable int id) {
		roomService.deleteById(id);
	}
	
	@PutMapping("/bookRoom/{roomId}/{userId}")
	public ResponseEntity<Object> bookRoom(@PathVariable int roomId, @PathVariable int userId) {
		return ResponseHandler.responseBuilder("Room booked", HttpStatus.OK, roomService.bookRoom(roomId, userId));
	}
	
	@PutMapping("/updateRoom/{id}")
	public ResponseEntity<Object> updateRoom(@PathVariable int id) {
		return ResponseHandler.responseBuilder("Room updated", HttpStatus.OK, roomService.updateRoomAvailability(id));
	}
}
