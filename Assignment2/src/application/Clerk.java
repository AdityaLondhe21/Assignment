package application;

public class Clerk extends Employee{

	public Clerk() {
		// TODO Auto-generated constructor stub
		this.setDesignation("Clerk");
	}
	public Clerk(String name,int age,int salary) {
		super(name,"Clerk",salary,age);

//		this.setName(name);
//		this.setAge(age);
//		this.setDesignation("Clerk");
//		this.setSalary(salary);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+2000);
	}
}
