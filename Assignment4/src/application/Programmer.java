package application;

public class Programmer extends Employee {

	public Programmer() {
		this.empSalary = 50000;		
		this.setDesignation("Programmer");
	}
	public Programmer(String name,int age,int ID) {
		super(name,"Programmer",50000,age,ID);
	}
	public Programmer(int ID) {
		super(ID,"Programmer",50000);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+5000);
	}
}
