package application;

public class Programmer extends Employee {

	public Programmer() {
		// TODO Auto-generated constructor stub
		this.setDesignation("Programmer");
	}
	public Programmer(String name,int age,int salary) {
		super(name,"Programmer",salary,age);

//		this.setName(name);
//		this.setDesignation("Programmer");
//		this.setAge(age);
//		this.setSalary(salary);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+5000);
	}
}
