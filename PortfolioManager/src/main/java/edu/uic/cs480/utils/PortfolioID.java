package edu.uic.cs480.utils;

import java.io.Serializable;

/**
 * Primary key class for Portfolio table.
 * 
 * @author Arvind Gupta
 *
 */
@SuppressWarnings("serial")
public class PortfolioID implements Serializable {

	int user_id;
	int stock_id;

	/**
	 * default constructor.
	 * 
	 */
	public PortfolioID() {
		super();
	}

	/**
	 * constructor.
	 * 
	 * @param user_id
	 * @param stock_id
	 */
	public PortfolioID(int user_id, int stock_id) {
		super();
		this.user_id = user_id;
		this.stock_id = stock_id;
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
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
