package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Users;
import com.project.response.ResponseHandler;
import com.project.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<Object> saveUser(@RequestBody Users user) {
		return ResponseHandler.responseBuilder("New user saved.", HttpStatus.OK, userService.save(user));
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<Object> getAllUsers(){
		return ResponseHandler.responseBuilder("List of Users", HttpStatus.OK, userService.getAllUsers());
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Object> findUsersById(@PathVariable int id) {
		return ResponseHandler.responseBuilder("List of Users", HttpStatus.OK,userService.findById(id));
	}
}
