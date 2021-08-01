package edu.uic.cs480.dao;

import java.util.List;

import edu.uic.cs480.model.StockCategory;

/**
 * implement to add All the DB operations for stock_category table.
 * 
 * @author Arvind Gupta
 *
 */
public interface StockCategoryDao {

	/**
	 * implement to add new category to stock_category table
	 * 
	 * @param stockCategory
	 * @return
	 */
	int addNewCategory(StockCategory stockCategory);

	/**
	 * implement to get list of all categories.
	 * 
	 * @return
	 */
	List<StockCategory> getAllStockCategories();

	/**
	 * implement to get list of all categories in sorted order.
	 * 
	 * @return
	 */
	List<StockCategory> getAllStockCategoriesSortedByIndustry();

	/**
	 * implement to update an existing category for its market cap.
	 * 
	 * @param categoryId
	 * @param marketCap
	 * @return
	 */
	int updateExistingCategory(int categoryId, String marketCap);

	/**
	 * implement to delete a category according to it ID.
	 * 
	 * @param categoryId
	 */
	void deleteCategory(int categoryId);
}