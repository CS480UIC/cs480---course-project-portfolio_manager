package edu.uic.cs480.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.UserDao;
import edu.uic.cs480.model.User;

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
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public int updateUser(int userId, String contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}
}