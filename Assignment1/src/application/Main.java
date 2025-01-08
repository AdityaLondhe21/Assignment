package application;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager M = new Manager("Ankit",45,3000000);
		
		Programmer P = new Programmer("Aman",32,200000);
		
		Clerk C = new Clerk("Rishi",37,150000);
		
		C.riseSalary(P, 20000);
		C.riseSalary(M, 321);
		
		P.display();
	}

}
