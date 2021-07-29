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

}
