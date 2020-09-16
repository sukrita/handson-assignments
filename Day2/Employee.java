class Employee {
    int id;
    String name;
    double salary;

    Address address;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;

	this.address = address;
    }

    void display() {
	System.out.println("----------------------------------------------------------");
        System.out.println("Id = "+id+", Name = "+name+", Salary = "+salary);
	
	if(address != null)
		address.display();
    }
}