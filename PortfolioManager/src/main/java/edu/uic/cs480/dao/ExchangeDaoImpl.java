package edu.uic.cs480.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uic.cs480.model.Exchange;

@Repository
public class ExchangeDaoImpl implements ExchangeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addNewExchange(Exchange exchangeInfo) {
		sessionFactory.getCurrentSession().save(exchangeInfo);
		return exchangeInfo.getExchange_id();
	}

	@Override
	public List<Exchange> getAllExchanges() {
		List<Exchange> listOfAllExchanges = (ArrayList<Exchange>) sessionFactory.getCurrentSession()
				.createQuery("from exchanges").list();
		return listOfAllExchanges;
	}

	@Override
	public List<Exchange> getAllExchangesSortedByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateExistingExchange(int exchangeId, int numberOfStocks) {
		Session session = sessionFactory.getCurrentSession();
		Exchange exchangeInfo = session.byId(Exchange.class).load(exchangeId);
		exchangeInfo.setNumber_of_stock(numberOfStocks);
		session.flush();

		return exchangeId;
	}

	@Override
	public void deleteExchange(int exchangeId) {
		Session session = sessionFactory.getCurrentSession();
		Exchange exchangeInfo = session.byId(Exchange.class).load(exchangeId);
		session.delete(exchangeInfo);
	}

}