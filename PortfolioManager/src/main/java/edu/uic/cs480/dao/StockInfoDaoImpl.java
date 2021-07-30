package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
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

	@Override
	public int addNewStock(StockInfo stockInfo) {
		sessionFactory.getCurrentSession().save(stockInfo);
		return stockInfo.getStockID();
	}

	@Override
	public int updateStockInfo(int stockId, String stockName) {
		Session session = sessionFactory.getCurrentSession();
		StockInfo stock = session.byId(StockInfo.class).load(stockId);
		stock.setStockName(stockName);
		return stock.getStockID();
	}

	@Override
	public void deleteStockInfo(int stockId) {
		Session session = sessionFactory.getCurrentSession();
		StockInfo stock = session.byId(StockInfo.class).load(stockId);
		session.delete(stock);
	}

}