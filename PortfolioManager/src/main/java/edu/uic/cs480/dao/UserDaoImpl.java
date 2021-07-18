package edu.uic.cs480.dao;

import java.util.ArrayList;
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
		sessionFactory.getCurrentSession().save(user);
		return user.getUser_id();
	}

	@Override
	public User getUserByName(String userName) {
		List<User> user = sessionFactory.getCurrentSession().createQuery("from users where user_name='"+userName+"'").list();
		return user.get(0);
	}

	@Override
	public List<User> getAllUsers() {

		List<User> listOfUsers = (ArrayList<User>) sessionFactory.getCurrentSession().createQuery("from users").list();
		return listOfUsers;
	}
}