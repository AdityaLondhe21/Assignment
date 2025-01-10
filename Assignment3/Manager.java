package emp.assignment;

public class Manager extends Employee {
	
	public Manager() {
		this.empSalary = 100000;
		this.setDesignation("Manager");
	}
	
	public Manager(String name,int age,int ID) {
		super(name,"Manager",100000,age,ID);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+15000);
	}

}

