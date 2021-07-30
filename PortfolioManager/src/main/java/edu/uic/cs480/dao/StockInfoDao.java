package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.StockInfo;

/**
 * implement to interact with the stock_info table.
 * 
 * @author Arvind Gupta
 *
 */
public interface StockInfoDao {

	/**
	 * implement to get information for all the stocks.
	 * 
	 * @return
	 */
	List<StockInfo> getAllStocksInfo();
	
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