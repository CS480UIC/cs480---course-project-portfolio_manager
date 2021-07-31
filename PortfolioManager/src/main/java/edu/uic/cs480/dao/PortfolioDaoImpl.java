package edu.uic.cs480.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.utils.PortfolioID;
import edu.uic.cs480.utils.UserPortfolio;

/**
 * 
 * @author Arvind Gupta
 *
 */
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserPortfolio> getAllPortfolioForAllUser() {
		
		Session session = sessionFactory.getCurrentSession();

		Query<UserPortfolio> query = session.createQuery(
				"select new edu.uic.cs480.utils.UserPortfolio( u.userId, u.user_name, "
						+ "s.stock_name, p.avg_price, "
						+ "p.quantity, p.latest_transaction_date )"
						+ " from edu.uic.cs480.model.Portfolio p" 
						+ " JOIN edu.uic.cs480.model.User u"
						+ " ON p.user_id = u.userId " 
						+ " JOIN edu.uic.cs480.model.StockInfo s "
						+ " ON p.stock_id = s.stock_id");
		List<UserPortfolio> results = query.list();
		
		
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserPortfolio> getPortfolioForUser(int userId) {
		Session session = sessionFactory.getCurrentSession();

		Query<UserPortfolio> query = session.createQuery(
				"select new edu.uic.cs480.utils.UserPortfolio( u.userId, u.user_name, "
						+ "s.stock_name, p.avg_price, "
						+ "p.quantity, sc.industry, "
						+ "e.exchange_name, p.latest_transaction_date )"
						+ " from edu.uic.cs480.model.Portfolio p" 
						+ " JOIN edu.uic.cs480.model.User u"
						+ " ON p.user_id = u.userId " 
						+ " JOIN edu.uic.cs480.model.StockInfo s "
						+ " ON p.stock_id = s.stock_id "
						+ " JOIN edu.uic.cs480.model.StockCategory sc"
						+ " ON s.category_id = sc.category_id"
						+ " JOIN edu.uic.cs480.model.Exchange e"
						+ " ON s.exchange_id = e.exchange_id");
		List<UserPortfolio> results = query.list();
		
		return results;
	}

	@Override
	public List<Portfolio> getPortfolioForStock(int stockId) {
		List<Portfolio> givenStockPortfolio = sessionFactory.getCurrentSession()
				.createQuery("from portfolio where stock_id='" + stockId + "'").list();
		return givenStockPortfolio;
	}

	@Override
	public int updatePortfolioForUser(int userId, int stockId, String stockName, float price, int totalQty, Date dateOfTransaction) {
		Session session = sessionFactory.getCurrentSession();
		PortfolioID portfolioId = new PortfolioID(userId, stockId);
		Portfolio portfolio = session.byId(Portfolio.class).load(portfolioId);
		portfolio.setStock_name(stockName);
		portfolio.setQuantity(portfolio.getQuantity() + totalQty);
		portfolio.setAvg_price((portfolio.getAvg_price() + price) / portfolio.getQuantity());
		portfolio.setLatest_transaction_date(dateOfTransaction);
		
		return portfolio.getUser_id();
	}

	@Override
	public void deletePortfolioForUser(int userId, int stockId) {
		Session session = sessionFactory.getCurrentSession();
		PortfolioID portfolioId = new PortfolioID(userId, stockId);
		Portfolio portfolio = session.byId(Portfolio.class).load(portfolioId);
		session.delete(portfolio);
	}
}