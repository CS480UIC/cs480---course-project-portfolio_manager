package edu.uic.cs480.dao;

import java.sql.Date;
import java.util.List;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

public interface PortfolioDao {

	int addNewPortfolio(Portfolio portfolio);

	List<UserPortfolio> getAllPortfolioForAllUser();

	List<Portfolio> getPortfolioForUser(int userId);

	List<Portfolio> getPortfolioForStock(int stockId);

	int updatePortfolioForUser(int userId, String stockName, float price, int totalQty, Date dateOfTransaction);

	int deletePortfolioForUser(int userId);
}
