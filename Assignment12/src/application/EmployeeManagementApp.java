package application;

public class EmployeeManagementApp {
	
    public static void main(String[] args) {
    	
    	EmployeeList.loadData();
    	
        int choice=0;
        if(CEO.isCEOCreated()==false) {
    		System.out.println("CEO Must be Created to proceed further.");
    		EmployeeList.createCEO();
    	}
        do {
            Menu.mainMenu();
            choice = Menu.readChoice(6); 
            switch(choice) {
            	case 1-> EmployeeList.addEmployee();
            	case 2-> EmployeeList.displayEmployees();
            	case 3-> EmployeeList.raiseEmployeeSalaries();
            	case 4-> EmployeeList.deleteEmployee();
            	case 5-> EmployeeList.searchEmployee();
            	default-> System.out.println("Total Number Of Employees: " + EmployeeList.getEmployeeCount());
            }
        } while (choice != 6);
        
        EmployeeList.saveData();
        
    }
}