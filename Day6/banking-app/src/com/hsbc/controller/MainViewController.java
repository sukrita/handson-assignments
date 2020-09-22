package com.hsbc.controller;

import java.util.Scanner;


import com.hsbc.model.beans.Account;
import com.hsbc.model.beans.AccountNotFoundException;
import com.hsbc.model.beans.BalanceInsufficient;

import com.hsbc.model.service.AccountService;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;


public class MainViewController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		AccountService service = (AccountService) AccountFactory.getInstance(Type.SERVICE);
		
		int option = 0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All Accounts 3: Find Account by number 4: Transfer Amount 5: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				Account account = new Account();
				System.out.println("Enter Name");		
				account.setCustomerName(scanner.next());
				System.out.println("Enter Account Number");	
				account.setAccountNumber(scanner.nextInt());
				System.out.println("Enter phone no");	
				account.setContactNumber(scanner.nextLong());
				System.out.println("Enter balance");	
				account.setBalance(scanner.nextDouble());
				
				Account createdAccount = service.createAccount(account);
				System.out.println("Account created with an account number: "+createdAccount.getAccountNumber());
				break;
			case 2: 
				Account[] accounts = service.getAllAccounts();
				for(Account temp : accounts) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				System.out.println("Enter account number");
				try {
					Account accountFound = service.getAccountById(scanner.nextInt());
					// print on different device
					System.out.println(accountFound);
				} catch (AccountNotFoundException e) {
					// print error on different device
					System.err.println("ERROR:"+e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter source account number");
				int sourceNumber = scanner.nextInt();
				System.out.println("Enter destination account number");
				int destNumber = scanner.nextInt();
				System.out.println("Enter amount to transfer");
				double amount = scanner.nextDouble();
				try {
					service.transfer(sourceNumber, destNumber, amount);
				} catch (BalanceInsufficient e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR: "+ e.getMessage());
				}
				
				break;
				
				
			}
		} while(option != 6);
		
		scanner.close();

	}

}
