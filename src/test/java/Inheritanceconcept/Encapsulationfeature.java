package Inheritanceconcept;

//Encapsulation in Java is a process of wrapping code and data together into a single unit, 
//for example, a capsule which is mixed of several medicines.
//We can create a fully encapsulated class in Java by making all the data members of the class private. 
//Now we can use setter and getter methods to set and get the data in it.
public class Encapsulationfeature {
	
	private String fullname ;
	private String countryname ;
	private int age ;
	
	//writing setters to return 
	public String setfullname (String givename) {
	//assigning global variables to the method (local level variable ) 
	this.fullname = givename ;
	return givename ;
	}
	
	public String setCountryname (String country) {
		
	this.countryname = country ;
	return countryname ;
		}
    
	public int setAge (int studentage) {
	
	this.age = studentage ;
	return studentage ;
		}
	
	
	//writing the getter method to retrieve the private variables values 
	
	public String getfullname () {
		return fullname ;
	}
	
	public String getcountryname () {
		return countryname ;
	}
	
	public int getage () {
		return age ;
	}
}
