public class Programmer extends Employee {

String language;

Programmer(String name, String dob, int phone, String gender, Address address, String empId, double salary, String language){
	super(name, dob, phone, gender, address, empId, salary);
	this.language = language;

}


public void testDisplay(){
	System.out.println("-----------------Display details-----------------");
	System.out.println("ID: "+ super.getEmpId());
	System.out.println("Name: "+ super.getName());
	System.out.println("Dob: "+ super.getDob());
	System.out.println("phone: "+ super.getPhone());
	System.out.println("gender: "+ super.getGender());
	System.out.println("Salary: "+ super.getSalary());
	System.out.println("Language: "+language);
	System.out.println("--------------------------------------------------");

}


}