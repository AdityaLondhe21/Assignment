package application;

public class EmployeeManagementApp {

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 6) {
            Menu.mainMenu();
            choice = Menu.readChoice(6);
            if (choice == 1) 
            {
                EmployeeDAO.addEmployee();
            } 
            else if (choice == 2) 
            {
                EmployeeDAO.displayEmployee();
            }
            else if (choice == 3) 
            {
                EmployeeDAO.raiseSalary();
            }
            else if (choice == 4) 
            {
                EmployeeDAO.searchEmployee();
            }
            else if (choice == 5) 
            {
                EmployeeDAO.deleteEmployee();
            }
            else 
            {
                System.out.println("----- Exited ----");
            }
        }
    }
}