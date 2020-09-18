public class Application {

public static void main(String[] args) {


	Address address = new Address( "Tamil Nadu", "Coimbatore", 1234567);
	Account account = new Account(232323232, 700000);

	Person manager = new Manager( "Ram", "03/02/1998", 1234567890, "Male", address, "123H", 70000, "Research Manager");

	Person programmer = new Programmer("Sukrita", "04/05/1998", 1234566, "Female", address, "123X", 30000, "Java");

	Person admin = new Admin("Alex", "09/06/1998", 45454544, "Male", address, "234K", 89000, "Level 1");

	Person student = new Student("Aby", "8/5/1997",454545454, "Male", address, "323232Uv3343", "CSE", "B");

	Person customer = new Customer("Ashley", "8/5/1997",454545454, "Female", address, "323232U", account);

	String newGrade="A";
	double newBalance= 888888888;

	
	manager.testDisplay();
	manager.testUpdate();
	manager.testDisplay();

	programmer.testDisplay();
	programmer.testUpdate();
	programmer.testDisplay();

	admin.testDisplay();
	admin.testUpdate();
	admin.testDisplay();

	student.testDisplay();
	student.testUpdate();
	student.testDisplay();

	customer.testDisplay();
	customer.testUpdate();
	customer.testDisplay();


}

}