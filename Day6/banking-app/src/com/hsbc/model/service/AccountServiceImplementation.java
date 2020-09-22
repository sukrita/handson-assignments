package com.hsbc.model.service;


import com.hsbc.model.beans.Account;
import com.hsbc.model.beans.AccountNotFoundException;
import com.hsbc.model.beans.BalanceInsufficient;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;


public class AccountServiceImplementation implements AccountService{
	
	private AccountDao accDao;
	

	public AccountServiceImplementation() {
		super();
		this.accDao = (AccountDao)AccountFactory.getInstance(Type.DAO);
	}
	

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		
		Account createdAccount = accDao.store(account);
		
		return createdAccount;
	}

	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account account = accDao.fetchAccountById(accountNumber);
		if(account == null) {
			throw new AccountNotFoundException("Sorry account number: "+accountNumber+" not found");
		}
		return account;
	}

	@Override
	public void transfer(int from, int to, double amount) throws BalanceInsufficient {
		// TODO Auto-generated method stub
		try {
			Account sourceAccount = this.getAccountById(from);
			Account destAccount = this.getAccountById(to);
			if(sourceAccount.getBalance() < amount)
				throw new BalanceInsufficient("balance not sufficient");
			
			sourceAccount.setBalance(sourceAccount.getBalance()-amount);
			Account accSource = accDao.updateAccount(from, sourceAccount);
			destAccount.setBalance(destAccount.getBalance()+amount);
			Account accDest = accDao.updateAccount(to, destAccount);
			accDao.updateAccount(from, sourceAccount);
			accDao.updateAccount(to, destAccount);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: "+ e.getMessage());
		}
		
	}


	@Override
	public Account[] getAllAccounts() {
		// TODO Auto-generated method stub
		return accDao.fetchAccounts();
	}

}
