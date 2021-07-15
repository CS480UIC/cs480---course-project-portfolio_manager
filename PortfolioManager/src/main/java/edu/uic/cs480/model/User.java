package edu.uic.cs480.model;

/**
 * POJO class implemented to map the user table in Database.
 * 
 * @author Arvind Gupta
 *
 */
public class User {
	
	private String userName;

	/**
	 * getter.
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
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
