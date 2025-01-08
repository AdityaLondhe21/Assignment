package application;

public class Manager extends Employee {
	
	public Manager() {
		// TODO Auto-generated constructor stub
		this.setDesignation("Manager");
	}
	
	public Manager(String name,int age,int salary) {
		this.setName(name);
		this.setDesignation("Manager");
		this.setAge(age);
		this.setSalary(salary);
	}

}
