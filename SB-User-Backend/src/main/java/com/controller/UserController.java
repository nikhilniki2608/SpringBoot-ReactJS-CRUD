package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserRepository;
import com.dto.User;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	public UserRepository uRepository;

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return uRepository.save(user);
	}

	@GetMapping("/users")
	public List<User> getAllUser() {
		return uRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return uRepository.findById(id).get();
	}

	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User User, @PathVariable Long id) {
		uRepository.findById(id);
		return uRepository.save(User);
	}


    @DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		uRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
