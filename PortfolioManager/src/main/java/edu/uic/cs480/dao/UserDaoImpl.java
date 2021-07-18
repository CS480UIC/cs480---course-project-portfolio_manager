package edu.uic.cs480.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

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
	public List<User> getAllUsers() {

		List<User> listOfUsers = sessionFactory.getCurrentSession().createQuery("from users").list();
		return listOfUsers;
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
