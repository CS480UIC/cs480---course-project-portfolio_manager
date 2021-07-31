
package edu.uic.cs480.controller;

import java.sql.Date;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@PostMapping("/api/addPortfolioRow")
	public ResponseEntity<?> addPortfolioForUser(@ModelAttribute("portfolio") Portfolio portfolio) {
		int userId = portfolioService.addNewPortfolio(portfolio);
		return ResponseEntity.ok().body("Row added for user : " + userId);
	}

	@GetMapping("/api/getAllPortfoliosForAllUsers")
	public ResponseEntity<List<UserPortfolio>> getAllPortfoliosListForAllUsers() {
		List<UserPortfolio> portfolioList = portfolioService.getAllPortfolioForAllUser();
		return ResponseEntity.ok().body(portfolioList);
	}

	@GetMapping("/api/getPortfolioForUserId/{userId}")
	public ResponseEntity<List<UserPortfolio>> getPortfolioForUserId(@PathVariable("userId") int userId) {
		List<UserPortfolio> portfolioListForUser = portfolioService.getPortfolioForUser(userId);
		return ResponseEntity.ok().body(portfolioListForUser);
	}

	@PutMapping("/api/updatePortfolioForUser/{userId}/{stockId}/{stockName}/{price}/{totalQty}/{dateOfTransaction}")
	public ResponseEntity<?> updatePortfolioForUser(@PathVariable("userId") int userId,
			@PathVariable("stockId") int stockId, @PathVariable("stockName") String stockName,
			@PathVariable("price") float price, @PathVariable("totalQty") int totalQty,
			@PathVariable("dateOfTransaction") Date dateOfTransaction) {
		
		int id = portfolioService.updatePortfolioForUser(userId, stockId, stockName, price, totalQty, dateOfTransaction);
		return ResponseEntity.ok().body("Portfolio updated for user Id : " + id);
	}

	@DeleteMapping("/api/deletePortfolio/{userId}")
	public ResponseEntity<?> deletePortfolioForUser(@PathVariable("userId") int userId,
			@PathVariable("stockId") int stockId) {
		portfolioService.deletePortfolioForUser(userId, stockId);
		return ResponseEntity.ok().body("Portfolio deleted for the user ID : " + userId);
	}

}
