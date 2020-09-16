class EmployeeArray {
    public static void main(String[] args){

	Address address=new Address("Tamil Nadu", "Coimbatore", 6884448);

        Employee[] employees = new Employee[5];
	employees[0] = new Employee(515, "Ram", 50000);
	employees[1] = new Employee(200, "Alex", 88000);
	employees[2] = new Employee(400, "Xi", 5000);
	employees[3] = new Employee(500, "Li", 73000, address);
	employees[4] = new Employee(430, "Aravind", 23000);

	for(int i=0; i<5 ; i++){
		if(employees[i].salary > 50000)
			employees[i].display();


	}
	
    }
}