package application;

public class Clerk extends Employee{

	public Clerk() {
		// TODO Auto-generated constructor stub
		this.setDesignation("Clerk");
	}
	public Clerk(String name,int age,int salary) {
		this.setName(name);
		this.setAge(age);
		this.setDesignation("Clerk");
		this.setSalary(salary);
	}
	
	public void riseSalary(Programmer P,int raise) {
		if(raise>0) {
			System.out.println("Old Salary: "+ P.getSalary());

			P.setSalary(P.getSalary()+raise);
			System.out.println("New Salary:"+ P.getSalary());

			
		}else {
			System.out.println("Raise amount is less than 0");
		}
	}
	public void riseSalary(Manager M,int raise) {
		if(raise>0) {
			System.out.println("Old Salary: "+ M.getSalary());

			M.setSalary(M.getSalary()+raise);
			System.out.println("New Salary:"+ M.getSalary());

			
		}else {
			System.out.println("Raise amount is less than 0");
		}
	}
}
