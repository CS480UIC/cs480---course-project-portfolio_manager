package edu.uic.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.User;
import edu.uic.cs480.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//Get All Users
	@GetMapping("/api/user")
	public ResponseEntity<List<User>> getAllUserList() {
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok().body(userList);
	}
	
}
