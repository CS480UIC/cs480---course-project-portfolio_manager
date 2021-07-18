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
	public int createUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUSer(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void updateUser(String userName, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub

	}

}
