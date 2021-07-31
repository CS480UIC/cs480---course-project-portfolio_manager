package edu.uic.cs480.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserPortfolio {

	private int userId;
	private String userName;
	private String stockName;
	private float avgPrice;
	private int quantity;
	private String latestTransactionDate;

	public UserPortfolio() {
		super();
	}

	public UserPortfolio(int userId, String userName, String stockName, float avgPrice, int quantity,//) {
			Date latestTransactionDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.stockName = stockName;
		this.avgPrice = avgPrice;
		this.quantity = quantity;
		this.latestTransactionDate = new SimpleDateFormat("yyyy-MM-dd").format(latestTransactionDate);
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * @return the avgPrice
	 */
	public float getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice the avgPrice to set
	 */
	public void setAvgPrice(float avgPrice) {
		this.avgPrice = avgPrice;
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
	 * @return the latestTransactionDate
	 */
	public String getLatestTransactionDate() {
		return latestTransactionDate;
	}

	/**
	 * @param latestTransactionDate the latestTransactionDate to set
	 */
	public void setLatestTransactionDate(String latestTransactionDate) {
		this.latestTransactionDate = latestTransactionDate;
	}

}
