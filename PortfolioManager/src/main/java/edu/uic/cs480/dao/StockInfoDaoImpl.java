package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.StockInfo;

/**
 * implemented to perform al the DB operations on the stock_info table.
 * 
 * @author Arvind Gupta
 *
 */
@Repository
public class StockInfoDaoImpl implements StockInfoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<StockInfo> getAllStocksInfo() {
		
		List<StockInfo> listOfAllStocks = (ArrayList<StockInfo>) sessionFactory.getCurrentSession()
				.createQuery("from stock_info").list();
		
		return listOfAllStocks;
	}

}
