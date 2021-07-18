package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.User;

/**
 * interface for user service which interacts with the DAO package to perform
 * CRUD operations on user.
 * 
 * @author Arvind Gupta
 *
 */
public interface UserService {

	/**
	 * implement to create the new user in DB.
	 * 
	 * @param user
	 * @return
	 */
	int createUser(User user);

	User getUserByName(String userName);

	List<User> getAllUsers();

	int updateUser(int userId, String contact);

	void deleteUser(int userId);
}