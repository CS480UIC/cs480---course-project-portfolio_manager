package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.Exchange;

public interface ExchangeService {

	int addNewExchange(Exchange exchangeInfo);

	List<Exchange> getAllExchanges();
	
	List<Exchange> getAllExchangesSortedByName();

	int updateExistingExchange(int exchangeId, int numberOfStocks);

	void deleteExchange(int exchangeId);
}
