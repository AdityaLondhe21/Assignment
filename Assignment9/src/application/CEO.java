package application;

public class CEO extends Employee{
	
	private static CEO ceo = null;

	private CEO() {
		super();
	}
	private CEO(String name,int age,int ID) {
		super(name,"CEO",500000,age,ID);
	}
	private CEO(int ID) {
		super(ID,"CEO",500000);
	}
	
	public static CEO getCEO() {
		if(ceo==null) {
			int ID = EmployeeDetails.readID(100);
			ceo = new CEO(ID);
		}
		return ceo;
	}
	
	public static boolean isCEOCreated() {
		if(ceo==null) {
			return false;
		}
		return true;
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary());
	}

}
