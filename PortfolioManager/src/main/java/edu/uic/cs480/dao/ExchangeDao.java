package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.Exchange;

/**
 * implement to add All the DB operations for exchanges table.
 * 
 * @author Arvind Gupta
 *
 */
public interface ExchangeDao {

	/**
	 * implement to add new exchange to exchanges table
	 * 
	 * @param exchangeInfo
	 * @return
	 */
	int addNewExchange(Exchange exchangeInfo);

	/**
	 * implement to get list of all exchanges.
	 * 
	 * @return
	 */
	List<Exchange> getAllExchanges();

	/**
	 * implement to get list of all exchanges in sorted order.
	 * 
	 * @return
	 */
	List<Exchange> getAllExchangesSortedByName();

	/**
	 * implement to update the number of stocks for existing exchange.
	 * 
	 * @param exchangeId
	 * @param numberOfStocks
	 * @return
	 */
	int updateExistingExchange(int exchangeId, int numberOfStocks);

	/**
	 * implement to delete an exchange.
	 * 
	 * @param exchangeId
	 */
	void deleteExchange(int exchangeId);
}