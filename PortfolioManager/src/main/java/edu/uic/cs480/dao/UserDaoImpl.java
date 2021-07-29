package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.User;

/**
 * implemented to perform all the DB operations on the User table.
 * 
 * @author Arvind Gupta
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getUserId();
	}

	@Override
	public User getUserByEmail(String emailID, String password) {
		List<User> user = sessionFactory.getCurrentSession()
				.createQuery("from users where email_id='" + emailID + "' and password='" + password + "'").list();
		return user.get(0);
	}

	@Override
	public List<User> getAllUsers() {

		List<User> listOfUsers = (ArrayList<User>) sessionFactory.getCurrentSession()
				.createQuery("from users where is_admin=" + false).list();
		return listOfUsers;
	}

	@Override
	public int updateUser(int userId, String contact) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(userId);
		user.setContact(contact);
		session.flush();

		return user.getUserId();
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(userId);
		session.delete(user);
	}
}