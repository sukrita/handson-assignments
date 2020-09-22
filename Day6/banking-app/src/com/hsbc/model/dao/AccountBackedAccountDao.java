package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;

public class AccountBackedAccountDao implements AccountDao{
	
	// temporary database
	private static Account[] accountArray = new Account[10];
	
	private static int index = 0;

	@Override
	public Account store(Account account) {
		// TODO Auto-generated method stub
		accountArray[index++] = account;
		return account;

	}

	@Override
	public Account[] fetchAccounts() {
		// TODO Auto-generated method stub
		return accountArray;
	}

	@Override
	public Account fetchAccountById(int accountNumber) {
		// TODO Auto-generated method stub
		Account account = null;
		for(int i = 0; i < index; i++) {
			if(accountArray[i].getAccountNumber() == accountNumber) { 
				account = accountArray[i];
				return account;
			}
		}
		return null;
	}

	@Override
	public Account updateAccount(int accountNumber, Account account) {
		// TODO Auto-generated method stub
		accountArray[accountNumber-1] = account;
		
		return accountArray[accountNumber-1];
	}
	
	

}
