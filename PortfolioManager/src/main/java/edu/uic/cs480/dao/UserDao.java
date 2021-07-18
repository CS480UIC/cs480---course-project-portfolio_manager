package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.User;

public interface UserDao {
	
	int createUser(User user);
	
	User getUserByName(String userName);
	
	List<User> getAllUsers();
	
}