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
 * implemented to provide APIs for stock_category table.
 * 
 * @author Arvind Gupta
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockCategoryController {

	@Autowired
	private StockCategoryService stockCategoryService;

	/**
	 * implemented to add new stock category.
	 * 
	 * @param stockCategory
	 * @return
	 */
	@PostMapping("/api/addCategory")
	public ResponseEntity<?> addCategory(@ModelAttribute("category") StockCategory stockCategory) {
		int categoryId = stockCategoryService.addNewCategory(stockCategory);
		return ResponseEntity.ok().body("New Category created with ID : " + categoryId);
	}

	/**
	 * implemented to get list of all the stock categories.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllStockCategories")
	public ResponseEntity<List<StockCategory>> getAllCategories() {
		List<StockCategory> allCategories = stockCategoryService.getAllStockCategories();
		return ResponseEntity.ok().body(allCategories);
	}

	/**
	 * implemented to get list of all the stock categories sorted by industry.
	 * 
	 * @return
	 */
	@GetMapping("/api/getAllCategoriesSortedByIndustry")
	public ResponseEntity<List<StockCategory>> getAllCategoriesSortedByIndustry() {
		List<StockCategory> allCategories = stockCategoryService.getAllStockCategoriesSortedByIndustry();
		return ResponseEntity.ok().body(allCategories);
	}

	/**
	 * implemented to update existing stock category.
	 * 
	 * @param categoryId
	 * @param marketCap
	 * @return
	 */
	@PutMapping("/api/updateStockCategory/{categoryId}/{marketCap}")
	public ResponseEntity<?> updateStockCategory(@PathVariable("categoryId") int categoryId,
			@PathVariable("marketCap") String marketCap) {
		int id = stockCategoryService.updateExistingCategory(categoryId, marketCap);
		return ResponseEntity.ok().body("Category market cap updated with ID : " + id);
	}

	/**
	 * implemented to delete a given stock category according to its ID.
	 * 
	 * @param categoryId
	 * @return
	 */
	@DeleteMapping("/api/deleteStockCategory/{categoryId}")
	public ResponseEntity<?> deleteStockCategory(@PathVariable("categoryId") int categoryId) {
		stockCategoryService.deleteCategory(categoryId);
		return ResponseEntity.ok().body("Stock category deleted with ID : " + categoryId);
	}
}
