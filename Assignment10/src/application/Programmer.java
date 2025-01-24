package application;

public final class Programmer extends Employee {

	private Programmer() {
		this.empSalary = 50000;		
		this.setDesignation("Programmer");
	}
	private Programmer(String name,int age,int ID) {
		super(name,"Programmer",50000,age,ID);
	}
	private Programmer(int ID) {
		super(ID,"Programmer",50000);
	}
	
	public static Programmer getProgrammer(int ID) {
		return new Programmer(ID);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+5000);
	}
}
