package emp.assignment;

public abstract class Employee {
	
	protected String empName;
	protected String empDesignation;
	protected int empSalary;
	protected int empAge;
	protected int empID;
	static int count;	

	public Employee() {
		this.empName="";
		this.empDesignation="";
		this.empSalary=0;
		this.empAge=0;
		this.empID=0;
		count++;
	}
	
	public Employee(String name,String designation,int salary,int age,int empID) {
		this.empID = empID;
		this.empName=name;
		this.empDesignation=designation;
		this.empSalary=salary;
		this.empAge=age;
		count++;
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
	public int getID(){
		return this.empID;
	}
	

	abstract void raiseSalary();
	
	final public void display() {
		System.out.println("ID:"+this.getID()
				+",\tName:"+this.getName()
				+",\tDesignation:"+this.getDesignation()
				+",\tAge:"+this.getAge()
				+",\tSalary:"+this.getSalary());
	}

	public static void deleteEmployee() {
		count--;
	} 
	
}

