package Javapractice;


//interface - will have only abstract methods (method with no body -only method declaration written)
//interface - no need to add abstract keyword (achieve 100% abstraction ) 
//interface - we cannot create object of the Interface-to acces the methods we need to create variables of the interface with the child class
//variable 

//interface - by default all the variables inside the interface is declared as static and final 

//interface - since jdk 1.8 interface can also have body defined for static and default methods 

public interface Car {

	static int wheels = 4;
	//by default the variables declared will be static and final 
	int turbinator = 2 ;
	
	public void start () ;
	
	public void stop () ;
	
	public void refuel () ;
	
	static void cartyre () {
		System.out.println ("Car tyres present at interface ");
	}
	
	default void cartype () {
	System.out.println ("car types present at interface  ")	;
	}
}
