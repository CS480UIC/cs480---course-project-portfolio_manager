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
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.Portfolio;
import edu.uic.cs480.service.PortfolioService;

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
	public ResponseEntity<List<Portfolio>> getAllPortfoliosListForAllUsers() {
		List<Portfolio> portfolioList = portfolioService.getAllPortfolioForAllUser();
		return ResponseEntity.ok().body(portfolioList);
	}

	@GetMapping("/api/getPortfolioForUserId/{userId}")
	public ResponseEntity<List<Portfolio>> getPortfolioForUserId(@PathVariable("userId") int userId) {
		List<Portfolio> portfolioListForUser = portfolioService.getPortfolioForUser(userId);
		return ResponseEntity.ok().body(portfolioListForUser);
	}

	@DeleteMapping("/api/deletePortfolio/{userId}")
	public ResponseEntity<?> deletePortfolioForUser(@PathVariable("userId") int userId) {
		portfolioService.deletePortfolioForUser(userId);
		return ResponseEntity.ok().body("Portfolio deleted for the user ID : " + userId);
	}

}
