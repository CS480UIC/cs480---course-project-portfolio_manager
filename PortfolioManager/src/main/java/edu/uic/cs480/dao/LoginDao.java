package edu.uic.cs480.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.uic.cs480.model.User;

/**
 * implemented to handle the database process for the login.
 * 
 * @author Arvind Gupta
 *
 */
public class LoginDao {

	/**
	 * get the search result with username
	 * 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public User findByUserName(String userName, String password)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/portfolio_manager?" + "user=DellPC&password=aarav001");

			String sql = "select * from users where user_name=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, userName);
			ResultSet resultSet = preparestatement.executeQuery();
			// ResultSet resultSet = preparestatement.executeUpdate();
			while (resultSet.next()) {
				String userResult = resultSet.getString("user_name");
				if (userResult.equals(userName)) {
					user.setUserName(resultSet.getString("user_name"));
					user.setPassword(resultSet.getString("password"));
					user.setEmailID(resultSet.getString("email_id"));
					user.setContactNumber(resultSet.getString("contact"));
					user.setAdmin(Boolean.parseBoolean(resultSet.getString("is_admin")));

				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

	/**
	 * 
	 * @param user
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public void addUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/portfolio_manager?" + "user=DellPC&password=aarav001");

			String sql = "insert into users (user_name, password, email_id, contact, is_admin) values(?, ?, ?, ?, ?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, user.getUserName());
			preparestatement.setString(2, user.getPassword());
			preparestatement.setString(3, user.getEmailID());
			preparestatement.setString(4, user.getContactNumber());
			preparestatement.setBoolean(5, false);
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/portfolio_manager?" + "user=DellPC&password=aarav001");

			String sql = "select * from users";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
				user.setEmailID(resultSet.getString("email_id"));
				user.setContactNumber(resultSet.getString("contact"));
				user.setAdmin(Boolean.parseBoolean(resultSet.getString("is_admin")));
				list.add(user);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}