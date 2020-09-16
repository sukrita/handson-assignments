class Savings{

String name, IFSC, state, city;
int pin, accountNo;
float balance;


Savings(String name, String state, String city, int accountNo){
this.name=name;
this.state=state;
this.city=city;
this.accountNo=accountNo;

IFSC="HSBC001";
balance=0.0f;

}

Savings(int accountNo, int balance, String name, String state, String city, String pin){
this.accountNo=accountNo;
this.balance=balance;
this.name=name;
this.state=state;
this.city=city;
this.pin=pin;

IFSC="HSBC001";


}


void deposit(float cash){
balance+=cash;
System.out.println("--------------------------------------------");
System.out.println(cash+" is deposited in your account");
System.out.println("--------------------------------------------");


}

void withdraw(float cash){
if((balance-cash)==0.0){
	System.out.println("--------------------------------------------");
	System.out.println("Sorry not enough cash");
	System.out.println("--------------------------------------------");

}
else{
balance-=cash;
	System.out.println("--------------------------------------------");
	System.out.println(cash+" is debited from your account");
	System.out.println("--------------------------------------------");

}


}


void display(){
System.out.println("--------------------------------------------");
System.out.println("Name: "+name);
System.out.println("Account number: "+accountNo);
System.out.println("Balance: "+balance);
System.out.println("IFSC: "+IFSC);
System.out.println("City: "+city);
System.out.println("State: "+state);
System.out.println("Pin: "+pin);
System.out.println("--------------------------------------------");


}


}