package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.StockCategory;

/**
 * implementaion of StockCategoryDao to interact with stock_category table.
 * 
 * @author Arvind Gupta
 *
 */
@Repository
public class StockCategoryDaoImpl implements StockCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addNewCategory(StockCategory stockCategory) {
		sessionFactory.getCurrentSession().save(stockCategory);
		return stockCategory.getCategory_id();
	}

	@Override
	public List<StockCategory> getAllStockCategories() {

		List<StockCategory> listOfAllCategories = (ArrayList<StockCategory>) sessionFactory.getCurrentSession()
				.createQuery("from stock_category").list();
		return listOfAllCategories;
	}

	@Override
	public List<StockCategory> getAllStockCategoriesSortedByIndustry() {
		List<StockCategory> listOfAllCategories = (ArrayList<StockCategory>) sessionFactory.getCurrentSession()
				.createQuery("from stock_category ORDER BY industry").list();
		return listOfAllCategories;
	}

	@Override
	public int updateExistingCategory(int categoryId, String marketCap) {
		Session session = sessionFactory.getCurrentSession();
		StockCategory stockCategory = session.byId(StockCategory.class).load(categoryId);
		stockCategory.setMarket_cap(marketCap);
		session.flush();

		return stockCategory.getCategory_id();
	}

	@Override
	public void deleteCategory(int categoryId) {

		Session session = sessionFactory.getCurrentSession();
		StockCategory stockCategory = session.byId(StockCategory.class).load(categoryId);
		session.delete(stockCategory);
	}

}