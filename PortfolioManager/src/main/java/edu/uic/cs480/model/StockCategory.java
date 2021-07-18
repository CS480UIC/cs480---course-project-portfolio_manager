package edu.uic.cs480.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_id;
	String industry;
	String market_cap;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getMarket_cap() {
		return market_cap;
	}

	public void setMarket_cap(String market_cap) {
		this.market_cap = market_cap;
	}
}