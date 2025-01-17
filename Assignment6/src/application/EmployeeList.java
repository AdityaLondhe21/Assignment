package application;

import java.util.Iterator;

public class EmployeeList implements Iterator{
		
	public int count=0;
	public Employee[] employees = new Employee[100];
	
	public EmployeeList() {
	}

	public boolean hasNext() {
		if(employees[count]!=null) {
			return true;
		}
		return false;
	}

	public Object next() {
		return employees[count++];
	}
	public Iterator iterator() {
		return this;
	}
	
	public void addEmployee(Employee e) {
		employees[count++] = e;
	}

}
