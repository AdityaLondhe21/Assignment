package application;

public class Manager extends Employee {
	
	public Manager() {
		this.empSalary = 100000;
		this.setDesignation("Manager");
	}
	
	public Manager(String name,int age,int ID) {
		super(name,"Manager",100000,age,ID);
	}
	public Manager(int ID) {
		super(ID,"Manager",100000);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+15000);
	}

}

