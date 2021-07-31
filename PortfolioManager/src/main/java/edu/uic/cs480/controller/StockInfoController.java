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

import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.service.StockInfoService;
import edu.uic.cs480.utils.Stock;

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

	/**
	 * Get all stocks from the database.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllStocks")
	public ResponseEntity<List<Stock>> getAllStocksInfo() {
		List<Stock> allStocksList = stockInfoService.getAllStocksInfo();
		return ResponseEntity.ok().body(allStocksList);
	}

	/**
	 * Adds a new stock to the table stock_info.
	 * 
	 * @param stockInfo
	 * @return
	 */
	@PostMapping("/api/addNewStockInfo")
	public ResponseEntity<?> addNewStockInfo(@ModelAttribute("stockInfo") StockInfo stockInfo) {
		int stockId = stockInfoService.addNewStock(stockInfo);
		return ResponseEntity.ok().body("Stock added with Id : " + stockId);
	}

	/**
	 * Updates the stock name based on the stock ID.
	 * 
	 * @param stockId
	 * @param stockName
	 * @return
	 */
	@PutMapping("/api/updateStockInfo/{stockId}/{stockName}")
	public ResponseEntity<?> updateStockInfo(@PathVariable("stockId") int stockId,
			@PathVariable("stockName") String stockName) {
			int id = stockInfoService.updateStockInfo(stockId, stockName);
			return ResponseEntity.ok().body("Stock updated with Id : " + id);
	}
	
	/**
	 * Deletes the stock with given Id.
	 * 
	 * @param stockId
	 * @return
	 */
	@DeleteMapping("/api/deleteStockInfo/{stockId}")
	public ResponseEntity<?> deleteStock(@PathVariable("stockId") int stockId) {
		stockInfoService.deleteStockInfo(stockId);
		return ResponseEntity.ok().body("Stock deleted with Id : " + stockId);
	}
}
