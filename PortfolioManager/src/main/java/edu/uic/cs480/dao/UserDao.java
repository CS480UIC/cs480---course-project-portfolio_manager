package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.User;

public interface UserDao {
	
	int createUser(User user);
	
	User getUSer(String userName);
	
	List<User> getAllUsers();
	
	void updateUser(String userName, User user);

	void deleteUser(String userName);
}
