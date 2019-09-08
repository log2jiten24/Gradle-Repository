package Javapractice;

public class Testbank {

	public static void main(String[] args) {
		
		
	HDFCBank hb = new HDFCBank () ;
	
	//always we can create object of the parent class with reference of the child class 
	//Abstractionconcepts hb1 = new Testbank() () ;
	
	//by creating object of the hdfc class ,we can also access the methods of the Abstractionconcepts method as hdfc
	//bank is inheriting the Abstractionconcepts class 
	
	//it will execute the methods of the hdfcbank class 
    hb.credit();
    
    hb.debit();
	//overriddden methods 
	hb.loan();
	
	//to access the fundshdfc method
	hb.fundshdfc();
	
	//to access the overridden method 
	hb.credit();
	
//to fetch the abstract method of the abstractionconcepts class 
//	hb1.loan();
//	
//	hb1.credit();
//HDFCBank hb3 = new Abstractionconcepts() { -- this is not possible as we cannot create object of the child class having reference
//of parent class 
	
	
	
	//to achieve dynamic polymorhism
	Abstractionconcepts hb1 = new HDFCBank() ;
	//always parent class reference object is created with the child class reference
	//hb1 is reference variable of Abstractclass(Abstractionconcepts )
	//hb1 will have only methods of the Abstractionconcepts class ,but any abstract method whose body is 
	//written or implemented in the child class - child class method will execute 
	//child class method will execute 
	hb1.credit();
	
	hb1.debit();
	//always the child class method will execute 
	hb1.loan();
	
	//fundshdfc method cant be accessed here 
    
	//abstractclass -object cannot be created 
	
	//Abstractionconcepts hb3 = new Abstractionconcepts() ;
	//cannot instantaite the object of the abstractclass 		
	

	}

}
