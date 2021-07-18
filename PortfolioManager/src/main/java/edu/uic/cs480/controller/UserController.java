package edu.uic.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.User;
import edu.uic.cs480.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	// Get All Users
	@GetMapping("/api/getAllUser")
	public ResponseEntity<List<User>> getAllUserList() {
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok().body(userList);
	}

	// TODO : add password to the query.
	@GetMapping("/api/getUserByName/{userName}/{password}")
	public ResponseEntity<User> getUserByName(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		User user = userService.getUserByName(userName);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/api/addUser")
	public ResponseEntity<?> createUser(@ModelAttribute("user") User user) {
		int id = userService.createUser(user);
		return ResponseEntity.ok().body("User Created with ID : " + id);
	}
	
	@PutMapping("/api/updateUser/{userId}/{contact}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") int userId,
			@PathVariable("contact") String contact) {
		int id = userService.updateUser(userId, contact);
		return ResponseEntity.ok().body("User Created with ID : " + id);
	}
	
	@DeleteMapping("/api/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok().body("User Created with ID : " + userId);
	}
}
