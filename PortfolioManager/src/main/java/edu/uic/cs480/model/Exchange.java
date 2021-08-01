package edu.uic.cs480.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "exchanges")
public class Exchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int exchange_id;
	String exchange_name;
	int number_of_stock;

	/**
	 * constructor.
	 * 
	 */
	public Exchange() {
		super();
	}

	/**
	 * @return the exchange_id
	 */
	public int getExchange_id() {
		return exchange_id;
	}

	/**
	 * @param exchange_id the exchange_id to set
	 */
	public void setExchange_id(int exchange_id) {
		this.exchange_id = exchange_id;
	}

	/**
	 * @return the exchange_name
	 */
	public String getExchange_name() {
		return exchange_name;
	}

	/**
	 * @param exchange_name the exchange_name to set
	 */
	public void setExchange_name(String exchange_name) {
		this.exchange_name = exchange_name;
	}

	/**
	 * @return the number_of_stocks
	 */
	public int getNumber_of_stock() {
		return number_of_stock;
	}

	/**
	 * @param number_of_stock the number_of_stock to set
	 */
	public void setNumber_of_stock(int number_of_stock) {
		this.number_of_stock = number_of_stock;
	}

}
