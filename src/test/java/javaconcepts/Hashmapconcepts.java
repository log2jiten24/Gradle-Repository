package javaconcepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmapconcepts {
	
	String name ;
	int age ;
	String dept ;
	
	
	public Hashmapconcepts(String name , int age , String dept) {
	
	this.name = name ;
	this.age = age ;
	this.dept = dept ;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//hashmap is a class which implements Map Interface
		//it extends AbstractMap Class
		//it contains only unique elements - no duplicate elements being stored..
		//it stores the values in the form of key and pair 
		//it may have one null key and multiple null values
		//it maintains no order
		//hashmap is non synchronized--not thread safe (anytime all can access)
		
		
		HashMap <Integer , String> hm = new HashMap <Integer , String> ();
		
		hm.put(1, "Selenium");
		hm.put(2, "UFT");
		hm.put(3, "RFT");
		hm.put(3, "RFT1");
		
		//it may have multiple duplicate key and the key with the updated value would get printed.
		
		for (Entry<Integer, String> allvalues : hm.entrySet() ) {
		System.out.println ("all values :" + allvalues.getKey() + " " + allvalues.getValue())	;
		
		}
		
		HashMap <Integer , Hashmapconcepts> newmap = new HashMap <Integer , Hashmapconcepts> () ;
		
		Hashmapconcepts h1 = new Hashmapconcepts("Jiten", 29, "IT");
		Hashmapconcepts h2 = new Hashmapconcepts("Jitendra", 30, "ITDept");
		Hashmapconcepts h3 = new Hashmapconcepts("Priya", 25, "Commerce");
		
		newmap.put(1, h1);
		
		newmap.put(2, h2);
		
		newmap.put(3, h3);
		
		//if its having same key ,then the last key value will get printed
		
		for (Entry<Integer, Hashmapconcepts> allvalues2 : newmap.entrySet()) {
		
			int key = allvalues2.getKey() ;
			
			Hashmapconcepts e = allvalues2.getValue();
			
			System.out.println (key + " " +  "Info");
			
			System.out.println ("all values for class object :" + e.age + " "+ e.name + " "+ e.dept);
			
		}
		
		}
		
	}


