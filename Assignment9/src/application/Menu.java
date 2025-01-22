package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

	static int maxChoice;
	public static int readChoice(int max) {
		Menu.maxChoice=max;
		int choice;
		while(true) {
			System.out.print("Enter Choice : ");
			try {
				choice = new Scanner(System.in).nextInt();
				if(choice<1 || choice>Menu.maxChoice) {
					throw new InvalidChoiceException();
				}
				return choice;
			}
			catch(InputMismatchException e) {
				System.out.println("Please Enter Integer only.");
			}
			catch(InvalidChoiceException e) {
				e.displayMessage(Menu.maxChoice);
			}
		}
	}
	public static void mainMenu() {
        System.out.println("---------------------\n"
                + "1. Create.\n"
                + "2. Display.\n"
                + "3. Raise Salary.\n"
                + "4. Delete.\n"
                + "5. Search.\n"
                + "6. Exit\n"
                + "---------------------");
    }
    
    public static void createEmployeeMenu() {
        System.out.println("---------------------\n"
                + "1. Clerk.\n"
                + "2. Programmer.\n"
                + "3. Manager.\n"
                + "4. Exit.\n"
                + "---------------------");
    }
}

