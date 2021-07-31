package edu.uic.cs480.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.StockCategoryDao;
import edu.uic.cs480.model.StockCategory;

/**
 * implementation of service for stock_category table.
 * 
 * @author Arvind Gupta
 *
 */
@Service
public class StockCategoryServiceImpl implements StockCategoryService {

	@Autowired
	StockCategoryDao stockCategoryDao;

	@Override
	@Transactional
	public int addNewCategory(StockCategory stockCategory) {
		return stockCategoryDao.addNewCategory(stockCategory);
	}

	@Override
	@Transactional
	public List<StockCategory> getAllStockCategories() {
		return stockCategoryDao.getAllStockCategories();
	}

	@Override
	public List<StockCategory> getAllStockCategoriesSortedByIndustry() {
		return stockCategoryDao.getAllStockCategoriesSortedByIndustry();
	}

	@Override
	@Transactional
	public int updateExistingCategory(int categoryId, String marketCap) {
		return stockCategoryDao.updateExistingCategory(categoryId, marketCap);
	}

	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		stockCategoryDao.deleteCategory(categoryId);
	}

}