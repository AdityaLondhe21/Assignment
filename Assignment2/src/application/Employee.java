package application;

public abstract class Employee {
	
	protected String empName;
	protected String empDesignation;
	protected int empSalary;
	protected int empAge;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		this.empName="";
		this.empDesignation="";
		this.empSalary=0;
		this.empAge=0;
	}
	
	public Employee(String name,String designation,int salary,int age) {
		this.empName=name;
		this.empDesignation=designation;
		this.empSalary=salary;
		this.empAge=age;
	}
	
	public void setName(String name) {
		this.empName=name;
	}
	
	public void setDesignation(String designation) {
		this.empDesignation = designation;
	}
	
	public void setAge(int age) {
		this.empAge = age;
	}
	
	public void setSalary(int salary) {
		this.empSalary = salary;
	}
	
	public String getName() {
		return this.empName;
	}
	
	public String getDesignation() {
		return this.empDesignation;
	}
	
	public int getAge() {
		return this.empAge;
	}
	
	public int getSalary() {
		return this.empSalary;
	}
	
	
	public void display() {
		System.out.println("Name:"+this.getName()
				+",\tDesignation:"+this.getDesignation()
				+",\tAge:"+this.getAge()
				+",\tSalary:"+this.getSalary());
	}
	
}
