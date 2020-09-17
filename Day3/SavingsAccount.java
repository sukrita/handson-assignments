class SavingsAccount extends Account { 
    String ifscCode;
    
    SavingsAccount(long accountNumber, double balance, String ifscCode) {
        super(accountNumber, balance);// Account(long, double)
        // this.accountNumber = accountNumber;
        // this.balance = balance;
        this.ifscCode = ifscCode;
        //System.out.println("SavingsAccount(long, double, String) intialized");
    }

    void minimumBalance() {
        System.out.println("You must have minimum 5000Rs. balance");
    }
    void withdrawLimit() {
        System.out.println("Withdraw limit in Savings is 50000");
    }


}