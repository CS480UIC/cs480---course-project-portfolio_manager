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

import edu.uic.cs480.model.StockCategory;
import edu.uic.cs480.service.StockCategoryService;

/**
 * Controller class for Stock category service.
 * 
 * @author Arvind Gupta
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockCategoryController {

	@Autowired
	private StockCategoryService stockCategoryService;

	@PostMapping("/api/addCategory")
	public ResponseEntity<?> addCategory(@ModelAttribute("category") StockCategory stockCategory) {
		int categoryId = stockCategoryService.addNewCategory(stockCategory);
		return ResponseEntity.ok().body("New Category created with ID : " + categoryId);
	}

	@GetMapping("/api/getAllStockCategories")
	public ResponseEntity<List<StockCategory>> getAllCategories() {
		List<StockCategory> allCategories = stockCategoryService.getAllStockCategories();
		return ResponseEntity.ok().body(allCategories);
	}

	@PutMapping("/api/updateStockCategory/{categoryId}/{marketCap}")
	public ResponseEntity<?> updateStockCategory(@PathVariable("categoryId") int categoryId,
			@PathVariable("marketCap") String marketCap) {
		int id = stockCategoryService.updateExistingCategory(categoryId, marketCap);
		return ResponseEntity.ok().body("Category market cap updated with ID : " + id);
	}

	@DeleteMapping("/api/deleteStockCategory/{categoryId}")
	public ResponseEntity<?> deleteStockCategory(@PathVariable("categoryId") int categoryId) {
		stockCategoryService.deleteCategory(categoryId);
		return ResponseEntity.ok().body("Stock category deleted with ID : " + categoryId);
	}
}
