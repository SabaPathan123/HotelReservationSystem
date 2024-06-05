package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Users;
import com.project.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public Users saveUser(@RequestBody Users user) {
		return userService.save(user);
	}
	
	@GetMapping("/getUser")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public Users findUsersById(@PathVariable int id) {
		return userService.findById(id);
	}
}
