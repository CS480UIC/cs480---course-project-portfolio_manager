package edu.uic.cs480.service;

import java.util.List;

import edu.uic.cs480.model.StockCategory;

public interface StockCategoryService {

	int addNewCategory(StockCategory stockCategory);

	List<StockCategory> getAllStockCategories();

	int updateExistingCategory(int categoryId, String marketCap);

	void deleteCategory(int categoryId);
}
