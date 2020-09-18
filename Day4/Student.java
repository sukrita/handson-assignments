public class Student extends Person {

String rollNo, degree;
String grade;

Student(String name, String dob, int phone, String gender, Address address, String rollNo, String degree, String grade){
	super(name, dob, phone, gender, address);
	this.rollNo = rollNo;
	this.degree = degree;
	this.grade = grade;

}


public void testDisplay(){
	System.out.println("-----------------Display details-----------------");
	System.out.println("RollNo: "+ rollNo);
	System.out.println("Name: "+ super.getName());
	System.out.println("Dob: "+ super.getDob());
	System.out.println("phone: "+ super.getPhone());
	System.out.println("gender: "+ super.getGender());
	System.out.println("degree: "+degree);
	System.out.println("Grade: "+grade);
	System.out.println("--------------------------------------------------");

}

public void testUpdate(){
	System.out.println("-----------------Student update-----------------");
	this.grade= "A";		
	System.out.println("-------------------------------------------------");

}


}



