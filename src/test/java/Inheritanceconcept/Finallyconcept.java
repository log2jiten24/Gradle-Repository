package Inheritanceconcept;

public class Finallyconcept {

	//finally is a block
	
	public static void main(String[] args) {
		
//		test1();
	
//		test2();
	
     // divisionbyzeroerror();
		
		divisionbyzeroerrornothandled();
	}
		public static void test1 ()
		{
		try {
		System.out.println ("inside the test1 method");
		
		}
		
		//finally is a block which will always execute 
		finally {
	    System.out.println ("inside the finally  method block ");	
		}
		}
		
		public static void test2 ()
		{
		try {
		System.out.println ("inside the test1 method");
		throw new RuntimeException("test");
		
		}catch (Exception e) 
		{
			System.out.println ("catch the Exception ");	
		}
		
		//finally is a block which will always execute 
		finally {
	    System.out.println ("inside the finally  method block ");	
		}
		}
	
		public static  void divisionbyzeroerror () {
			
			int i = 20 ;
		try	{
		System.out.println ("inside the try block ");
		int k = i/0;
		}
		//handle the exception 
		catch (ArithmeticException e) {
		System.out.println ("catch the Exception");
		System.out.println ("catch the Arithemetic Exception :" +e.getMessage());
		}
		finally {
		System.out.println ("execute this code even after any exception ");	
		}
		}
		
		//output 
//		inside the try block 
//		catch the Exception
//		catch the Arithemetic Exception :/ by zero
//		execute this code even after any exception 
		
       public static  void divisionbyzeroerrornothandled () {
			
			int i = 20 ;
		try	{
		System.out.println ("inside the try block ");
		int k = i/0;
		}
		//handle the exception --it will not go inside the catch block and it will throw an exception as exception
		//handled is not proper as the exception handled is null pointer instead of Arithmetic exception 
		catch (NullPointerException e) {
		System.out.println ("catch the Exception");
		System.out.println ("catch the nullpointer Exception :" +e.getMessage());
		}
		finally {
		System.out.println ("execute this code even after any exception ");	
		}
		}
		
		//it executed first try block and then the catch block and then the exceptiom 
       
//       inside the try block 
//       execute this code even after any exception 
//       Exception in thread "main" java.lang.ArithmeticException: / by zero
//       	at Inheritanceconcept.Finallyconcept.divisionbyzeroerrornothandled(Finallyconcept.java:73)
//       	at Inheritanceconcept.Finallyconcept.main(Finallyconcept.java:13)
	}




