
package edu.uic.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.service.PortfolioService;
import edu.uic.cs480.utils.UserPortfolio;

/**
 * implemented to provide APIs for portfolio table.
 * 
 * @author Arvind Gupta
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	/**
	 * implemented to add new portfolio row for given user.
	 * 
	 * @param portfolio
	 * @return
	 */
	@PostMapping("/api/addPortfolioRow")
	public ResponseEntity<?> addPortfolioForUser(@ModelAttribute("portfolio") Portfolio portfolio) {
		int userId = portfolioService.addNewPortfolio(portfolio);
		return ResponseEntity.ok().body("Row added for user : " + userId);
	}

	/**
	 * implemented to get list of all portfolios for all the users.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllPortfoliosForAllUsers")
	public ResponseEntity<List<UserPortfolio>> getAllPortfoliosListForAllUsers() {
		List<UserPortfolio> portfolioList = portfolioService.getAllPortfolioForAllUser();
		return ResponseEntity.ok().body(portfolioList);
	}

	/**
	 * implemented to get list of portfolio for given user.
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/api/getPortfolioForUserId/{userId}")
	public ResponseEntity<List<UserPortfolio>> getPortfolioForUserId(@PathVariable("userId") int userId) {
		List<UserPortfolio> portfolioListForUser = portfolioService.getPortfolioForUser(userId);
		return ResponseEntity.ok().body(portfolioListForUser);
	}

	/**
	 * implemented to update the portfolio for given user.
	 * 
	 * @param userId
	 * @param stockId
	 * @param price
	 * @param totalQty
	 * @param dateOfTransaction
	 * @return
	 */
	@PutMapping("/api/updatePortfolioForUser/{userId}/{stockId}/{price}/{totalQty}/{dateOfTransaction}")
	public ResponseEntity<?> updatePortfolioForUser(@PathVariable("userId") int userId,
			@PathVariable("stockId") int stockId, @PathVariable("price") float price,
			@PathVariable("totalQty") int totalQty, @PathVariable("dateOfTransaction") String dateOfTransaction) {

		int id = portfolioService.updatePortfolioForUser(userId, stockId, price, totalQty, dateOfTransaction);
		return ResponseEntity.ok().body("Portfolio updated for user Id : " + id);
	}

	/**
	 * implemented to delete a portfolio.
	 * 
	 * @param userId
	 * @param stockId
	 * @return
	 */
	@DeleteMapping("/api/deletePortfolio/{userId}/{stockId}")
	public ResponseEntity<?> deletePortfolioForUser(@PathVariable("userId") int userId,
			@PathVariable("stockId") int stockId) {
		portfolioService.deletePortfolioForUser(userId, stockId);
		return ResponseEntity.ok().body("Portfolio deleted for the user ID : " + userId);
	}

	/**
	 * implemented to get user data grouped according to user id.
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/api/getGroupedDataAccordingToUsers/{userId}")
	public ResponseEntity<List<UserPortfolio>> getGroupedDataAccordingToUsers(@PathVariable("userId") int userId) {
		List<UserPortfolio> groupedListForUser = portfolioService.getGroupedDataAccordingToUsers(userId);
		return ResponseEntity.ok().body(groupedListForUser);
	}
}
