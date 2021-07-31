package edu.uic.cs480.model;

import java.io.Serializable;

public class PortfolioID implements Serializable {

	int user_id;
	int stock_id;

	public PortfolioID(int user_id, int stock_id) {
		super();
		this.user_id = user_id;
		this.stock_id = stock_id;
	}

}
