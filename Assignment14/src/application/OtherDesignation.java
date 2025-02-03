package application;

public class OtherDesignation extends Employee{
	private OtherDesignation() {
		this.setSalary(50000);
		this.setDesignation("Other");
	}
	private OtherDesignation(String name,int age,int ID) {
		super(name,"Other",50000,age,ID);
	}
	
	private OtherDesignation(int ID) {
		super(ID,"Other",50000);
	}
	public static OtherDesignation getOther(int ID) {
		return new OtherDesignation(ID);
	}
	
	private OtherDesignation(String name,String designation,int salary,int age,int empID) {
		super(name,designation,salary,age,empID);
	}
	public static OtherDesignation loadOther(String name,String designation,int salary,int age,int empID) {
		return new OtherDesignation(name,designation,salary,age,empID);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+4000);
	}

}
