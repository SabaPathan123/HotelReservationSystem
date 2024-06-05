package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.Users;
import com.project.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	UsersRepository userRepository;
	
	public Users save(Users user) {
		return userRepository.save(user);
	}
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Users findById(int id) {
		Optional<Users> user = userRepository.findById(id);
		return user.get();
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
}
