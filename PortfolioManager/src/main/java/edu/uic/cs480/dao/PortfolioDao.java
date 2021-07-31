package edu.uic.cs480.dao;

import java.sql.Date;
import java.util.List;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

public interface PortfolioDao {

	int addNewPortfolio(Portfolio portfolio);

	List<UserPortfolio> getAllPortfolioForAllUser();

	List<UserPortfolio> getPortfolioForUser(int userId);

	List<Portfolio> getPortfolioForStock(int stockId);

	int updatePortfolioForUser(int userId, int stockId, String stockName, float price, int totalQty, Date dateOfTransaction);

	void deletePortfolioForUser(int userId, int stockId);
}
