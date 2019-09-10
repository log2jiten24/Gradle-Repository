package javaconcepts;

public class Constructorconcepts {
	
	//constructor - class entity to define class features while creating objects in the form of global variables 
	//constructor cannot return any values and it doesn't have any return type 
	//constructor - same name as class name 
	
	//default constructor with no parameters 
	public Constructorconcepts() 
	{
	System.out.println ("Default constructor ");	
	}
	
	//constructor with single parameter 
	public Constructorconcepts(int i) 
	{
	System.out.println ("single parameter constructor ");	
	System.out.println ("the value of i is : " + i);	
	}

	//constructor with double  parameter 
		public Constructorconcepts(int i, int k) 
		{
		System.out.println ("double parameter constructor ");	
		System.out.println ("the value of i is : " + i);
		System.out.println ("the value of k is : " + k);
		}
	//example of constructor overloading 	
		
	public static void main(String[] args) {
	
	//creating objects and calling the constructor --while creating object default constructor is being called by default 
	Constructorconcepts	obj = new Constructorconcepts();
	
	Constructorconcepts	obj1 = new Constructorconcepts(20);
	//parametrized constructor calling 
	Constructorconcepts	obj2 = new Constructorconcepts(20,30);
		

	}

}
