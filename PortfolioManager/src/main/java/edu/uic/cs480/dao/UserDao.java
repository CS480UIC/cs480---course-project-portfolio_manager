package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.User;

/**
 * implement to add functionality to interact with user table.
 * 
 * @author Arvind Gupta
 *
 */
public interface UserDao {

	/**
	 * implement to add new user.
	 * 
	 * @param user
	 * @return
	 */
	int createUser(User user);

	/**
	 * implement to get the user by user emailID.
	 * 
	 * @param emailID
	 * @param password
	 * @return
	 */
	User getUserByEmail(String emailID, String password);

	/**
	 * implement to get all the users from the user table.
	 * 
	 * @return
	 */
	List<User> getAllUsers();

	/**
	 * implement to update the given user's contact.
	 * 
	 * @param userId
	 * @param contact
	 * @return
	 */
	int updateUser(int userId, String contact);

	/**
	 * implement to delete the user with given id.
	 * 
	 * @param userId
	 */
	void deleteUser(int userId);
}