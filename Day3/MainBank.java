public class MainBank {
    public static void main(String[] args) {
        //pass the accountNo and amount to deposit from CLA
        //get the Account using the accountNo by calling getAccount(...)
        // if accountNo is wrong show the error message and must not perform any below
        // operation
        
        // show the account information before deposit
        //deposit the amount to that particular Account
        //show the account information after deposit


/*
	System.out.println("------1st Requirement--------");
	long accountNo = Long.parseLong(args[0]);
	double amount = Double.parseDouble(args[1]);

	Account account = getAccount(accountNo);
*/

	System.out.println("------2nd Requirement--------");
	long sourceAccNo = Long.parseLong(args[0]);
	long destAccNo = Long.parseLong(args[1]);
	double amount = Double.parseDouble(args[2]);

	Account sourceAccount = getAccount(sourceAccNo);
	Account destAccount = getAccount(destAccNo);


	//Checking source and destination accounts
	if(!accountCheck(sourceAccount) && !accountCheck(destAccount)){

	System.out.println("------------------------------------------");
	System.out.println("enter correct account details");
	System.out.println("------------------------------------------");
	return ;


	}

	//When account exists
	System.out.println("------------------------------------------");

	System.out.println("------Source account details-----");
	sourceAccount.accountInformation();
	System.out.println("-----Destination account details------");
	destAccount.accountInformation();

	System.out.println("------------------------------------------");
	System.out.println("------Transferring Cash from source to dest-----");
	sourceAccount.withdraw(amount);
	destAccount.deposit(amount);

	System.out.println("------------------------------------------");

	System.out.println("------Source account details-----");
	sourceAccount.accountInformation();
	System.out.println("-----Destination account details------");
	destAccount.accountInformation();
	System.out.println("------------------------------------------");


	

	


	
	
	
	

/*
	System.out.println("Part of 1st Requirement")


	if(!accountCheck(account))
		return ;
		
	//When account exists
	account.accountInformation();
	System.out.println("------------------------------------------");
	account.deposit(amount);
	System.out.println("------------------------------------------");
	account.accountInformation();	

*/

	

	



    }

    // pass the accountNO and get the Account from Accounts[] 
    public static Account getAccount(long accountNo) {
        Account[] accounts = AccountsDB.getAccounts();



        // get the account from accounts using the accountNo
	for(Account account : accounts){

		if(account.getAccountNumber() == accountNo)
			return account;

	}

	return null;
    }


    public static Boolean accountCheck(Account account) {

	//When account doesn't exist
	if(account == null){
		
		System.out.println("------------------------------------------");
		System.out.println("Sorry Account not found");
		System.out.println("------------------------------------------");

		return false;

	}
	return true;



}
}