package application;

public class EmployeeManagementApp {

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 6) {
            Menu.mainMenu();
            choice = Menu.readChoice(6);
            switch(choice) {
            	case 1->  EmployeeDAO.addEmployee();
            	case 2-> EmployeeDAO.displayEmployee();
            	case 3-> EmployeeDAO.raiseSalary();
            	case 4-> EmployeeDAO.searchEmployee();
            	case 5-> EmployeeDAO.deleteEmployee();
            	default -> System.out.println("----- Exited ----");
            }
        }
    }
}