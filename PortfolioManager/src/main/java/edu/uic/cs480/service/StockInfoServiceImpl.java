package edu.uic.cs480.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uic.cs480.dao.StockInfoDao;
import edu.uic.cs480.model.StockInfo;
import edu.uic.cs480.utils.Stock;

/**
 * implemented to interact with the DAO class.
 * 
 * @author Arvind Gupta
 *
 */
@Service
public class StockInfoServiceImpl implements StockInfoService {

	@Autowired
	private StockInfoDao stockInfoDao;
	
	@Override
	@Transactional
	public List<Stock> getAllStocksInfo() {
		
		return stockInfoDao.getAllStocksInfo();
	}

	@Override
	@Transactional
	public int addNewStock(StockInfo stockInfo) {
		return stockInfoDao.addNewStock(stockInfo);
	}

	@Override
	@Transactional
	public int updateStockInfo(int stockId, String stockName) {
		return stockInfoDao.updateStockInfo(stockId, stockName);
	}

	@Override
	@Transactional
	public void deleteStockInfo(int stockId) {
		stockInfoDao.deleteStockInfo(stockId);
	}
}