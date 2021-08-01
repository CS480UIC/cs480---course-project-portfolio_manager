package edu.uic.cs480.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import edu.uic.cs480.utils.PortfolioID;

@Entity(name = "portfolio")
@IdClass(PortfolioID.class)
public class Portfolio {

	public Portfolio() {
	}

	@Id
	int user_id;

	@Id
	int stock_id;
	float avg_price;
	int quantity;
	String latest_transaction_date;

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

	/**
	 * @return the avg_price
	 */
	public float getAvg_price() {
		return avg_price;
	}

	/**
	 * @param avg_price the avg_price to set
	 */
	public void setAvg_price(float avg_price) {
		this.avg_price = avg_price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the latest_transaction_date
	 */
	public String getLatest_transaction_date() {
		return latest_transaction_date;
	}

	/**
	 * @param latest_transaction_date the latest_transaction_date to set
	 */
	public void setLatest_transaction_date(String latest_transaction_date) {
		this.latest_transaction_date = latest_transaction_date;
	}

}