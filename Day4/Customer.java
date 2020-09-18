public class Customer extends Person {

String customerId;
Account account;

Customer(String name, String dob, int phone, String gender, Address address, String customerId, Account account){
	super(name, dob, phone, gender, address);
	this.customerId = customerId;
	this.account=account;

}


public void testDisplay(){
	System.out.println("-----------------Display details-----------------");
	System.out.println("Customer ID: "+ customerId);
	System.out.println("Name: "+ super.getName());
	System.out.println("Dob: "+ super.getDob());
	System.out.println("phone: "+ super.getPhone());
	System.out.println("gender: "+ super.getGender());
	account.accountInformation();
	System.out.println("--------------------------------------------------");
	
}

public void testUpdate(){
	System.out.println("----------------Updating Balance------------------");
	account.setBalance(0);	
	System.out.println("-------------------------------------------------");

}

public void testUpdate(double balance){
	System.out.println("----------------Updating Balance------------------");
	account.setBalance(88888888);	
	System.out.println("-------------------------------------------------");

}



}



