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
	private int stock_id;
	
	@Column(name = "stock_name")
	private String stock_name;
	
//	@ManyToOne
//	@JoinColumn(name = "category_id")
	private int category_id;
	
//	@ManyToOne
//	@JoinColumn(name = "exchange_id")
	private int exchange_id;

	/**
	 * @return the stockID
	 */
	public int getStockID() {
		return stock_id;
	}

	/**
	 * @param stockID the stockID to set
	 */
	public void setStockID(int stockID) {
		this.stock_id = stockID;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stock_name;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stock_name = stockName;
	}

	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the exchange_id
	 */
	public int getExchange_id() {
		return exchange_id;
	}

	/**
	 * @param exchange_id the exchange_id to set
	 */
	public void setExchange_id(int exchange_id) {
		this.exchange_id = exchange_id;
	}
}