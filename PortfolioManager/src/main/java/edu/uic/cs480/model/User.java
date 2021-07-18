package edu.uic.cs480.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * POJO class implemented to map the user table in Database.
 * 
 * @author Arvind Gupta
 *
 */
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	public int getUserID() {
		return user_id;
	}

	public void setUserID(int user_id) {
		this.user_id = user_id;
	}

	private String user_name;
	private String password;
	private String email_id;
	private String contact;
	private boolean is_admin;

	/**
	 * getter.
	 * 
	 * @return
	 */
	public String getUserName() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return email_id;
	}

	public void setEmailID(String emailID) {
		this.email_id = emailID;
	}

	public String getContactNumber() {
		return contact;
	}

	public void setContactNumber(String contactNumber) {
		this.contact = contactNumber;
	}

	public boolean isAdmin() {
		return is_admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.is_admin = isAdmin;
	}

	/**
	 * setter.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.user_name = userName;
	}

}
