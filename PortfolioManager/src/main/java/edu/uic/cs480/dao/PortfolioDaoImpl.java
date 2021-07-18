package edu.uic.cs480.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.Portfolio;

@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	@Autowired
	private SessionFactory sessionFactory;

	// TODO : check if current stock for current user already exists and also get
	// the id of stock from the stock_info table based on the stock name added by
	// the user.
	@Override
	public int addNewPortfolio(Portfolio portfolio) {
		sessionFactory.getCurrentSession().save(portfolio);
		return portfolio.getUser_id();
	}

	@Override
	public List<Portfolio> getAllPortfolioForAllUser() {
		List<Portfolio> allPortfoliosListForAllUsers = sessionFactory.getCurrentSession().createQuery("from portfolio")
				.list();
		return allPortfoliosListForAllUsers;
	}

	@Override
	public List<Portfolio> getPortfolioForUser(int userId) {
		List<Portfolio> portfolioForGivenUser = sessionFactory.getCurrentSession()
				.createQuery("from portfolio where user_id='" + userId + "'").list();
		return portfolioForGivenUser;
	}

	@Override
	public List<Portfolio> getPortfolioForStock(int stockId) {
		List<Portfolio> givenStockPortfolio = sessionFactory.getCurrentSession()
				.createQuery("from portfolio where stock_id='" + stockId + "'").list();
		return givenStockPortfolio;
	}

	@Override
	public int updatePortfolioForUser(int userId, String stockName, float price, int totalQty, Date dateOfTransaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePortfolioForUser(int userId) {
		return 0;
	}
}