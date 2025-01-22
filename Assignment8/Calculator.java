import java.lang.reflect.*;
import java.util.*;

public class Calculator
{
	public double add(double a, double b)
	{
		return a+b;
	}
	public double sub(double a, double b)
	{
		return a-b;
	}
	public double mul(double a, double b)
	{
		return a*b;
	}
	public double div(double a, double b)
	{
		return a/b;
	}
	
	public static void main(String args[])
	{
		try(Scanner sc = new Scanner(System.in)){

			System.out.println("Java Calculation\n Method options:");
			Method[] methods = Calculator.class.getDeclaredMethods();
			for(int i=1;i<methods.length;i++){
				System.out.println((i)+") "+methods[i].getName());
			}
			System.out.print("Enter operation : ");
			String methodName = sc.next();
			Method method = Calculator.class.getMethod(methodName,double.class,double.class);

			System.out.print("Enter parameter 1 : ");
			double parameter1 = sc.nextInt();
			System.out.print("Enter parameter 2 : ");
			double parameter2 = sc.nextInt();

			Object result = method.invoke(new Calculator(),parameter1,parameter2);
			System.out.println("Answer of "+methodName+" operation is : "+result);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}


