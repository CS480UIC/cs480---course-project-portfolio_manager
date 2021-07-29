package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.StockInfo;

/**
 * interface for stock info service which interacts with the DAO package to perform
 * CRUD operations on stock_info table.
 * 
 * @author Arvind Gupta
 *
 */
public interface StockInfoService {
	
	/**
	 * implement to get all stocks from stock_info table.
	 * 
	 * @return
	 */
	public List<StockInfo> getAllStocksInfo();

}
