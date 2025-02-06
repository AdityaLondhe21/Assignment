package application;

class A
{
	public void print1to10()
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println("Range : "+i);
		}
	}
}
class B
{
	public void evenTill50()
	{
		for(int i=0; i<=50; i+=2)
		{
			System.out.println("Even : "+i);
		}
	}
}
class C
{
	public void fibonacciFrom1to1000()
	{
		int a = 0, b = 1;
        while (a <= 1000) {
            System.out.println("Fibonacci : " + a);
            int next = a + b;
            a = b;
            b = next;
        }
	}
}

class Multithreading
{
	public static void main(String args[])
	{
		
		//note: For creating a thread without implementing Runnable interface in class
		//      Create Anonymous inner class which implements Runnable interface and override run() method 
//		Thread threadA = new Thread(
//        		new Runnable() {
//        			public void run() {
//        				A a = new A();
//        				a.print1to10();
//        			}
//        		});
		
		//Alternate method
//		1
		new Thread(new A()::print1to10).start();
		new Thread(new B()::evenTill50).start();
		new Thread(new C()::fibonacciFrom1to1000).start();

//		Thread threadA = new Thread(new A()::print1to10);
		
//		2
//		Runnable obj1 =()-> new A();
//		Thread threadA = new Thread(obj1);
		
//        Thread threadB = new Thread(
//        		new Runnable() {
//        			public void run() {
//        				B b = new B();
//        				b.evenTill50();
//        			}
//        		});
//
//        Thread threadC = new Thread(
//        		new Runnable() {
//        			public void run() {
//        				C c = new C();
//        				c.fibonacciFrom1to1000();
//        			}
//        		});

//        threadA.start();
//        threadB.start();
//        threadC.start();
        
	}
}
 
 