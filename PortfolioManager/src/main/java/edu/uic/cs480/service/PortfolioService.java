package edu.uic.cs480.service;

import java.sql.Date;
import java.util.List;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

public interface PortfolioService {

	int addNewPortfolio(Portfolio portfolio);

	List<UserPortfolio> getAllPortfolioForAllUser();

	List<UserPortfolio> getPortfolioForUser(int userId);

	List<Portfolio> getPortfolioForStock(int stockId);

	int updatePortfolioForUser(int userId, int stockId, float price, int totalQty, Date dateOfTransaction);

	void deletePortfolioForUser(int userId, int stockId);
}
