package edu.uic.cs480.model;

/**
 * POJO class implemented to map the user table in Database.
 * 
 * @author Arvind Gupta
 *
 */
public class User {

	private String userName;
	private String password;
	private String emailID;
	private String contactNumber;
	private boolean isAdmin;

	/**
	 * getter.
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * setter.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
