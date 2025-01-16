class A {
        private static A a1 = null;
    	A() {
		if(this instanceof B){
			System.out.println("B instance is created.");
		}
		else if(this instanceof A && a1==null){
			a1 = this;
			System.out.println("A instance is created.");
		}
		else{
			throw new InstanceAlreadyExistException("Only one instance of A is allowed.");

		}
    	}

    	public static A getObject() {
		if (a1==null) {
            		a1 = new A();
        	} 
		else{
			throw new InstanceAlreadyExistException("Only one instance of A is allowed.");
		}
        	return a1;
    	}
}

class B extends A {
    	private static final B b1 = new B();
	private static boolean b =true;
    	private B() {
    	}

	public static B getObject() {
		if(b){
			b = false;
               		return b1;
		}
		else{
			throw new InstanceAlreadyExistException("Only one instance of B is allowed.");
		}
    	}
}

class InstanceAlreadyExistException extends RuntimeException
{
	public InstanceAlreadyExistException()
	{
	}
	public InstanceAlreadyExistException(String msg)
	{
		super(msg);
	}
}

public class SingletonAssignment {
    public static void main(String args[]) {
        try {
            A a1 = A.getObject();
	    System.out.println(a1);
	    System.out.println("-----------------------------");
		
	    //A a2 = A.getObject(); 
	    //System.out.println(a2);
	    //System.out.println("-----------------------------");

            B b1 = B.getObject();
	    System.out.println(b1);
	    System.out.println("-----------------------------");
            
	    A a3 = new A(); 
	    System.out.println(a3);
	    System.out.println("-----------------------------");
            
	    B b2 = B.getObject(); 
	    System.out.println(b2);
	    System.out.println("-----------------------------");
		
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}