package edu.uic.cs480.controller;

import edu.uic.cs480.dao.LoginDao;
import edu.uic.cs480.model.User;

public class LoginController {

	private LoginDao loginDao = new LoginDao();

	public String testService(String userName) {

		return "Hello " + userName;
	}

	public User getUser(String userName, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = loginDao.findByUserName(userName, password);
		return user;
	}

}
