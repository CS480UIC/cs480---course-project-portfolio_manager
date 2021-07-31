package edu.uic.cs480.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.PortfolioDao;
import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioDao portfolioDao;

	@Override
	@Transactional
	public int addNewPortfolio(Portfolio portfolio) {
		return portfolioDao.addNewPortfolio(portfolio);
	}

	@Override
	@Transactional
	public List<UserPortfolio> getAllPortfolioForAllUser() {
		return portfolioDao.getAllPortfolioForAllUser();
	}

	@Override
	@Transactional
	public List<UserPortfolio> getPortfolioForUser(int userId) {
		return portfolioDao.getPortfolioForUser(userId);
	}

	@Override
	@Transactional
	public List<Portfolio> getPortfolioForStock(int stockId) {
		return portfolioDao.getPortfolioForStock(stockId);
	}

	@Override
	@Transactional
	public int updatePortfolioForUser(int userId, int stockId, float price, int totalQty, Date dateOfTransaction) {
		return portfolioDao.updatePortfolioForUser(userId, stockId, price, totalQty, dateOfTransaction);
	}

	@Override
	@Transactional
	public void deletePortfolioForUser(int userId, int stockId) {
		portfolioDao.deletePortfolioForUser(userId, stockId);
	}
}