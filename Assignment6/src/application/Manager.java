package application;

public final class Manager extends Employee {
	
	private Manager() {
		this.empSalary = 100000;
		this.setDesignation("Manager");
	}
	
	private Manager(String name,int age,int ID) {
		super(name,"Manager",100000,age,ID);
	}
	private Manager(int ID) {
		super(ID,"Manager",100000);
	}
	
	public static Manager getManager(int ID) {
		return new Manager(ID);
	}
	
	public void raiseSalary() {
		this.setSalary(this.getSalary()+15000);
	}

}

