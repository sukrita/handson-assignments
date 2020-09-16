public class Account{

public static void main(String[] args){

Savings a=new Savings("sukrita", "Kerala", "palakkad", 12345678);
Savings b=new Savings(2345678, 50000, "pratyush", "Uttar Pradesh", "Lucknow", 234567);

a.deposit(10000);
b.withdraw(4000);
b.withdraw(55000);
b.display();





}


}