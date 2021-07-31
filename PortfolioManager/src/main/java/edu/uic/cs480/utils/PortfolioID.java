package edu.uic.cs480.utils;

import java.io.Serializable;

/**
 * 
 * @author Arvind Gupta
 *
 */
public class PortfolioID implements Serializable {

	int user_id;
	int stock_id;

	public PortfolioID() {
		super();
	}

	public PortfolioID(int user_id, int stock_id) {
		super();
		this.user_id = user_id;
		this.stock_id = stock_id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the stock_id
	 */
	public int getStock_id() {
		return stock_id;
	}

	/**
	 * @param stock_id the stock_id to set
	 */
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
