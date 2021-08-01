package edu.uic.cs480.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.UserDao;
import edu.uic.cs480.model.User;

/**
 * implemented to interact with the DAO class.
 * 
 * @author Arvind Gupta
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public int createUser(User user) {
		return userDao.createUser(user);
	}

	@Override
	@Transactional
	public User getUserByEmail(String emailID, String password) {
		return userDao.getUserByEmail(emailID, password);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	@Transactional
	public int updateUser(int userId, String contact) {
		return userDao.updateUser(userId, contact);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}
}