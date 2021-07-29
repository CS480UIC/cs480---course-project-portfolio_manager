package edu.uic.cs480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.service.StockInfoService;

/**
 * Controller class for StockInfo service.
 * 
 * @author Arvind Gupta
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockInfoController {
	
	@Autowired
	private StockInfoService stockInfoService;

	@GetMapping("/api/getAllStocks")
	public ResponseEntity<List<StockInfo>> getAllStocksInfo() {
		List<StockInfo> allStocksList = stockInfoService.getAllStocksInfo();
		return ResponseEntity.ok().body(allStocksList);
	}
}
