package Inheritanceconcept;

public class Encapsulationtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//creating object of the Encapsulation class - here we are together trying to fetch the private variables along with the 
		//by creating the objects of the class by using getters and setters method to achieve java concept of encapsulation
		Encapsulationfeature obj = new Encapsulationfeature();
		
		obj.setfullname("Jitendra Kumar");
		
		obj.setCountryname("India");
		
		obj.setAge(30);
		
		//to retrieve the value using getters and setters 
		System.out.println ("fullname value :" + obj.getfullname() + " " + "country name :" +obj.getcountryname()
		+ " " + "Employee age :" + obj.getage()) ;
	}
	
//output - fullname value :Jitendra Kumar country name :India Employee age :30
	
}
