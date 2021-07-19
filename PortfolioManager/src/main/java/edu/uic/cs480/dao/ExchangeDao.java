package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.Exchange;

public interface ExchangeDao {

	int addNewExchange(Exchange exchangeInfo);
	
	List<Exchange> getAllExchanges();
	
	int updateExistingExchange(int exchangeId, int numberOfStocks);
	
	void deleteExchange(int exchangeId);
}