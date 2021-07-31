package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.Exchange;
import edu.uic.cs480.model.StockCategory;
import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.utils.Stock;

/**
 * implemented to perform all the DB operations on the stock_info table.
 * 
 * @author Arvind Gupta
 *
 */
@Repository
public class StockInfoDaoImpl implements StockInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAllStocksInfo() {

		Session session = sessionFactory.getCurrentSession();

		Query<Stock> query = session.createQuery(
				"select new edu.uic.cs480.utils.Stock(si.stock_id, si.stock_name, "
						+ "s.industry, s.market_cap, e.exchange_name, e.number_of_stock )"
						+ " from edu.uic.cs480.model.StockInfo si" 
						+ " JOIN edu.uic.cs480.model.StockCategory s"
						+ " ON si.category_id = s.category_id " 
						+ " JOIN edu.uic.cs480.model.Exchange e "
						+ " ON si.exchange_id = e.exchange_id");
		List<Stock> results = query.list();

		return results;
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