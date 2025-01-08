package application;

public class Manager extends Employee {
	
	public Manager() {
		// TODO Auto-generated constructor stub
		this.setDesignation("Manager");
	}
	
	public Manager(String name,int age,int salary) {
		super(name,"Manager",salary,age);
		
//		this.setName(name);
//		this.setDesignation("Manager");
//		this.setAge(age);
//		this.setSalary(salary);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+15000);
	}

}
