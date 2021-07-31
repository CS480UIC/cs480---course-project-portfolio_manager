package edu.uic.cs480.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * POJO class to contain all the details for portfolio to be displayed to user.
 * 
 * @author Arvind Gupta
 *
 */
public class UserPortfolio {

	private int userId;
	private String userName;
	private int stockId;
	private String stockName;
	private float avgPrice;
	private int quantity;
	private String industryName;
	private String exchangeName;
	private String latestTransactionDate;

	/**
	 * default constructor.
	 */
	public UserPortfolio() {
		super();
	}

	/**
	 * constructor.
	 * 
	 * @param userId
	 * @param userName
	 * @param stockName
	 * @param avgPrice
	 * @param quantity
	 * @param latestTransactionDate
	 */
	public UserPortfolio(int userId, String userName, String stockName, float avgPrice, int quantity, // ) {
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
	 * constructor.
	 * 
	 * @param userId
	 * @param stockId
	 * @param userName
	 * @param stockName
	 * @param avgPrice
	 * @param quantity
	 * @param industryName
	 * @param exchangeName
	 * @param latestTransactionDate
	 */
	public UserPortfolio(int userId, int stockId, String userName, String stockName, float avgPrice, int quantity,
			String industryName, String exchangeName, Date latestTransactionDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.stockId = stockId;
		this.stockName = stockName;
		this.avgPrice = avgPrice;
		this.quantity = quantity;
		this.industryName = industryName;
		this.exchangeName = exchangeName;
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
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
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
	 * @return the industryName
	 */
	public String getIndustryName() {
		return industryName;
	}

	/**
	 * @param industryName the industryName to set
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	/**
	 * @return the exchangeName
	 */
	public String getExchangeName() {
		return exchangeName;
	}

	/**
	 * @param exchangeName the exchangeName to set
	 */
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
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
