package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.utils.UserPortfolio;

/**
 * implement to add All the DB operations for exchanges table.
 * 
 * @author Arvind Gupta
 *
 */
public interface PortfolioDao {

	/**
	 * implement to add new portfolio to the portfolio table.
	 * 
	 * @param portfolio
	 * @return
	 */
	int addNewPortfolio(Portfolio portfolio);

	/**
	 * implement to get all portfolio information for all the users.
	 * 
	 * @return
	 */
	List<UserPortfolio> getAllPortfolioForAllUser();

	/**
	 * implement to get portfolio for one specific user.
	 * 
	 * @param userId
	 * @return
	 */
	List<UserPortfolio> getPortfolioForUser(int userId);

	/**
	 * implement to get portfolio according to stock.
	 * 
	 * @param stockId
	 * @return
	 */
	List<Portfolio> getPortfolioForStock(int stockId);

	/**
	 * implement to update portfolio for a given user.
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
	 * implement to delete portfolio for a given user.
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
