package com.hsbc.model.beans;

public class BalanceInsufficient extends Exception{
	
	public BalanceInsufficient() {
		super("Balance is not sufficient");
		// TODO Auto-generated constructor stub
	}

	public BalanceInsufficient(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
