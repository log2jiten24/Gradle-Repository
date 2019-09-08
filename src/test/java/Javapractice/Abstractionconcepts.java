package Javapractice;

//mark the class as abstract 
//abstract class has to have one abstract method(method with no body) and non abstract methods it can also have 

//Abstract class is to achieve partial abstraction (abstraction means to hide some implementation logic,implementation 
//logic will be defined always by the child class )

//cannot create object of the Abstractclass 
//it can have both static ,final and non static variables 

//Abstract class is faster than interface 

public abstract class Abstractionconcepts {

	   int amount = 100 ;//non static variables 
	   static int rate = 5;//static variables
	   final int loanrate = 10 ;//final variables 
	   
		public abstract void loan () ;//abstract method with no body defined 
		
		//non abstract methods --methods with body defined
		
		public void credit () {
			System.out.println ("Bank credit ");
		}
		
		public void debit () {
		System.out.println ("Bank debit ");	
		}

	}


