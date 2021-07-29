package edu.uic.cs480.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "stock_info")
public class StockInfo {

	@Id
	@Column(name = "stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockID;
	private String stockName;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private StockCategory category_id;
	
	@ManyToOne
	@JoinColumn(name = "exchange_id")
	private Exchange exchange_id;

	/**
	 * @return the stockID
	 */
	public int getStockID() {
		return stockID;
	}

	/**
	 * @param stockID the stockID to set
	 */
	public void setStockID(int stockID) {
		this.stockID = stockID;
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
	 * @return the category_id
	 */
	public StockCategory getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(StockCategory category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the exchange_id
	 */
	public Exchange getExchange_id() {
		return exchange_id;
	}

	/**
	 * @param exchange_id the exchange_id to set
	 */
	public void setExchange_id(Exchange exchange_id) {
		this.exchange_id = exchange_id;
	}
}