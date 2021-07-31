package edu.uic.cs480.utils;

public class Stock {

	private int stockId;
	private String stockName;
	private String industry;
	private String marketCap;
	private String exchangeName;
	private int numberOfStocks;

	/**
	 * @return the marketCap
	 */
	public String getMarketCap() {
		return marketCap;
	}

	/**
	 * @param marketCap the marketCap to set
	 */
	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	/**
	 * @return the numberOfStocks
	 */
	public int getNumberOfStocks() {
		return numberOfStocks;
	}

	/**
	 * @param numberOfStocks the numberOfStocks to set
	 */
	public void setNumberOfStocks(int numberOfStocks) {
		this.numberOfStocks = numberOfStocks;
	}

	public Stock(int stockId, String stockName, String industry, String marketCap, String exchangeName,
			int numberOfStocks) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.industry = industry;
		this.marketCap = marketCap;
		this.exchangeName = exchangeName;
		this.numberOfStocks = numberOfStocks;
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
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
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

	public Stock() {
		super();
	}

}
