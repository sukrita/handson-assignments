public abstract class Employee extends Person{

private String empId;
private double salary;

Employee(String name, String dob, int phone, String gender, Address address, String empId, double salary){
	super(name, dob, phone, gender, address);
	this.empId = empId;
	this.salary = salary;

}

public String getEmpId(){
	return empId;
}


public double getSalary(){
	return salary;
}

public void setSalary(Double salary){
	salary = salary;

}

public abstract void testDisplay();

public void testUpdate(){
	System.out.println("----------------Updating salary------------------");
	salary+= (salary*10/100);		
	System.out.println("-------------------------------------------------");

}




}