package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.Exchange;

public interface ExchangeService {

	int addNewExchange(Exchange exchangeInfo);

	List<Exchange> getAllExchanges();

	int updateExistingExchange(int exchangeId, String exchangeName, String numberOfStocks);

	void deleteExchange(int exchangeId);
}
