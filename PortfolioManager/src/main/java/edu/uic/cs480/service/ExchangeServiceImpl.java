package edu.uic.cs480.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.ExchangeDao;
import edu.uic.cs480.model.Exchange;

/**
 * implemented to provide service for exchanges table.
 * 
 * @author Arvind Gupta
 *
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	private ExchangeDao exchangeDao;

	@Override
	@Transactional
	public int addNewExchange(Exchange exchangeInfo) {
		return exchangeDao.addNewExchange(exchangeInfo);
	}

	@Override
	@Transactional
	public List<Exchange> getAllExchanges() {
		return exchangeDao.getAllExchanges();
	}

	@Override
	@Transactional
	public List<Exchange> getAllExchangesSortedByName() {
		return exchangeDao.getAllExchangesSortedByName();
	}

	@Override
	@Transactional
	public int updateExistingExchange(int exchangeId, int numberOfStocks) {
		return exchangeDao.updateExistingExchange(exchangeId, numberOfStocks);
	}

	@Override
	@Transactional
	public void deleteExchange(int exchangeId) {
		exchangeDao.deleteExchange(exchangeId);
	}

}
