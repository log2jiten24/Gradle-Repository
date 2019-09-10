package javaconcepts;

public class Constructorwiththiskeyword {
	
	String name ;
	int age ;
	String countryname1 ;//all these are global variables 
	
	public Constructorwiththiskeyword (String name , int age , String countryname ) {
	
	//this keyword is used to initialize the local variables of constructor with the global variables of the class 
	//if the constructor local	variable is same as the global variable then  only this keyword is used 
	this.name = name ;
	this.age = age ;
	
	//if the global variable name is different than  the local variable then we can assign the variable in the below mentioned way 
	countryname1 = countryname ;
	System.out.println ("name of the employee :" + name ) ;
	System.out.println ("employee age :" + age ) ;
	System.out.println ("country name of employee  :" + countryname ) ;
	}

	public static void main(String[] args) {
	
	//create the object of the class
	Constructorwiththiskeyword	obj = new Constructorwiththiskeyword("Jiten", 30, "INDIA") ;

	}

}
