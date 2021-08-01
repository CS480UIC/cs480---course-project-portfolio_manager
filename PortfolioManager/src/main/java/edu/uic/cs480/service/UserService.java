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

	/**
	 * implement to get user by email ID.
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	User getUserByEmail(String emailId, String password);

	/**
	 * implement to get all the users from the user table.
	 * 
	 * @return
	 */
	List<User> getAllUsers();

	/**
	 * implement to update the contact information for the given user ID.
	 * 
	 * @param userId
	 * @param contact
	 * @return
	 */
	int updateUser(int userId, String contact);

	/**
	 * implement to delete the given user.
	 * 
	 * @param userId
	 */
	void deleteUser(int userId);
}