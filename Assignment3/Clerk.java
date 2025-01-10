package emp.assignment;

public class Clerk extends Employee {

	public Clerk() {
		this.empSalary = 20000;
		this.setDesignation("Clerk");
	}
	public Clerk(String name,int age,int ID) {
		super(name,"Clerk",20000,age,ID);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+2000);
	}
}
