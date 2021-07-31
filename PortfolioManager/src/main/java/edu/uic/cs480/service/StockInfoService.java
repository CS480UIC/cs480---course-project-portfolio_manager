package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.utils.Stock;

/**
 * interface for stock info service which interacts with the DAO package to
 * perform CRUD operations on stock_info table.
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
	public List<Stock> getAllStocksInfo();

	/**
	 * implement to add a new stock to the database.
	 * 
	 * @param stockInfo
	 * @return
	 */
	int addNewStock(StockInfo stockInfo);

	/**
	 * implement to update the existing stock info row.
	 * 
	 * @param stockId
	 * @param stockName
	 * @return
	 */
	int updateStockInfo(int stockId, String stockName);

	/**
	 * implement to delete a stock.
	 * 
	 * @param stockId
	 */
	void deleteStockInfo(int stockId);

}
