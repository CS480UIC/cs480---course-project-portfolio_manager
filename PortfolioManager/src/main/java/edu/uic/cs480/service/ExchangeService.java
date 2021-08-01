package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.Exchange;

/**
 * implement to add service for exchanges table.
 * 
 * @author Arvind Gupta
 *
 */
public interface ExchangeService {

	/**
	 * implement to add new exchange to exchanges table.
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
	 * implement to get list all exchanges sorted by name.
	 * 
	 * @return
	 */
	List<Exchange> getAllExchangesSortedByName();

	/**
	 * implement to update exchange information.
	 * 
	 * @param exchangeId
	 * @param numberOfStocks
	 * @return
	 */
	int updateExistingExchange(int exchangeId, int numberOfStocks);

	/**
	 * implement to delete an existing exchange.
	 * 
	 * @param exchangeId
	 */
	void deleteExchange(int exchangeId);
}
