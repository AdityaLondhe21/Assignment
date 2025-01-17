package application;

public final class Clerk extends Employee{

	private Clerk() {
		this.empSalary = 20000;
		this.setDesignation("Clerk");
	}
	private Clerk(String name,int age,int ID) {
		super(name,"Clerk",20000,age,ID);
	}
	private Clerk(int ID) {
		super(ID,"Clerk",20000);
	}
	
	public static Clerk getClerk(int ID) {
		return new Clerk(ID);
	}

	public void raiseSalary() {
		this.setSalary(this.getSalary()+2000);
	}
}
