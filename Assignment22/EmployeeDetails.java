
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeDetails {
	private static final List<String> designations = new ArrayList<>(Arrays.asList("CLERK", "MANAGER", "PROGRAMMER", "CEO", "OTHER"));
	public static int readAge(int minAge, int maxAge) {
        int age;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Age: ");
                try {
                    age = scanner.nextInt();
                    if (age < minAge || age > maxAge) {
                        throw new InvalidAgeException();
                    }
                    return age;
                } catch (InputMismatchException e) {
                    System.out.println("Please Enter Integer only.");
                    scanner.next(); // Clear the invalid input
                } catch (InvalidAgeException e) {
                    e.displayMessage(minAge, maxAge);
                }
            }
        }
    }

    public static String readName() {
        String name;
        String regex = "^[A-Z][a-z]+\\s[A-Z][a-z]+$";
        Pattern p = Pattern.compile(regex);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Name and Surname: ");
                name = scanner.nextLine();
                Matcher m = p.matcher(name);
                if (m.matches()) {
                    return name;
                } else {
                    System.out.println("Invalid name format. Please enter in 'Firstname Lastname' format.");
                }
            }
        }
    }

    static int maxID;

    public static int readCheckID(int max) {
        EmployeeDetails.maxID = max;
        int id;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Employee ID: ");
                try {
                    id = scanner.nextInt();
                    if (id < 1 || id > EmployeeDetails.maxID) {
                        throw new InvalidIDException();
                    }
                    if (EmployeeList.checkEmployeeID(id)) {
                        throw new EmployeeAlreadyExistsException();
                    }
                    return id;
                } catch (InputMismatchException e) {
                    System.out.println("Please Enter Integer only.");
                    scanner.next(); // Clear the invalid input
                } catch (InvalidIDException e) {
                    e.displayMessage(EmployeeDetails.maxID);
                } catch (EmployeeAlreadyExistsException e) {
                    e.displayMessage();
                }
            }
        }
    }

    public static int readID(int max) {
        EmployeeDetails.maxID = max;
        int id;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Employee ID: ");
                try {
                    id = scanner.nextInt();
                    if (id < 1 || id > EmployeeDetails.maxID) {
                        throw new InvalidIDException();
                    }
                    return id;
                } catch (InputMismatchException e) {
                    System.out.println("Please Enter Integer only.");
                    scanner.next(); // Clear the invalid input
                } catch (InvalidIDException e) {
                    e.displayMessage(EmployeeDetails.maxID);
                }
            }
        }
    }

    public static String readDesignation() {
        String designation;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Designation: ");
                designation = scanner.nextLine();
                if (EmployeeDetails.designations.contains(designation)) {
                    return designation;
                } else {
                    System.out.println("Invalid designation. Please enter one of the following: " + designations);
                }
            }
        }
    }

    public static int readSalary(int minSalary, int maxSalary) {
        int salary;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter Salary: ");
                try {
                    salary = scanner.nextInt();
                    if (salary < minSalary || salary > maxSalary) {
                        throw new InvalidAgeException();
                    }
                    return salary;
                } catch (InputMismatchException e) {
                    System.out.println("Please Enter Integer only.");
                    scanner.next(); // Clear the invalid input
                } catch (InvalidAgeException e) {
                    e.displayMessage(minSalary, maxSalary);
                }
            }
        }
    }

}
