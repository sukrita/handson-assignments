public abstract class Person {

private String name;
private String dob;
private int phone;
private String gender;

Address address;

Person(String name, String dob, int phone, String gender, Address address){

	this.name = name;
	this.dob = dob;
	this.phone = phone;
	this.gender = gender;
	this.address = address;


}

public String getName(){
	return name;
}


public String getDob() {
	return dob;
}

public String getGender(){
	return gender;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

public abstract void testDisplay();

public abstract void testUpdate();



}