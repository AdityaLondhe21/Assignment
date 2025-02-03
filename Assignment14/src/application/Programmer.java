package application;

public final class Programmer extends Employee {

	private Programmer() {
		this.setSalary(50000);		
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
	
	private Programmer(String name,String designation,int salary,int age,int empID) {
		super(name,designation,salary,age,empID);
	}
	public static Programmer loadProgrammer(String name,String designation,int salary,int age,int empID) {
		return new Programmer(name,designation,salary,age,empID);
	} 
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+5000);
	}
}
