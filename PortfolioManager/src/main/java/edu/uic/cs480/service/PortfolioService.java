package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

/**
 * implement to add service for portfolio table.
 * 
 * @author Arvind Gupta
 *
 */
public interface PortfolioService {

	/**
	 * implement to add new portfolio.
	 * 
	 * @param portfolio
	 * @return
	 */
	int addNewPortfolio(Portfolio portfolio);

	/**
	 * implement to get all portfolios for all users.
	 * 
	 * @return
	 */
	List<UserPortfolio> getAllPortfolioForAllUser();

	/**
	 * implement to get portfolio for a particular user.
	 * 
	 * @param userId
	 * @return
	 */
	List<UserPortfolio> getPortfolioForUser(int userId);

	/**
	 * implement to get portfolio according to a stock.
	 * 
	 * @param stockId
	 * @return
	 */
	List<Portfolio> getPortfolioForStock(int stockId);

	/**
	 * implement to update portfolio for a particular user.
	 * 
	 * @param userId
	 * @param stockId
	 * @param price
	 * @param totalQty
	 * @param dateOfTransaction
	 * @return
	 */
	int updatePortfolioForUser(int userId, int stockId, float price, int totalQty, String dateOfTransaction);

	/**
	 * implement to delete portfolio for given user.
	 * 
	 * @param userId
	 * @param stockId
	 */
	void deletePortfolioForUser(int userId, int stockId);

	/**
	 * implement to show grouped data according to user ID.
	 * 
	 * @param userId
	 */
	void getGroupedDataAccordingToUsers(int userId);
}
