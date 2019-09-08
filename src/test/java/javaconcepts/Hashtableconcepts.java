package javaconcepts;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class Hashtableconcepts {
	
	//it is similar to hashmap ,but it is synchronized (thread safe) - one by one access
	//it stores the value on the basis of key value pair 
	//key -object >>hashcode - if two objects are equal it has same hash code.
	//hash table - stores the value of key value in the form of hash code 
	//it contains only unique values - no null key 
	//null values will not get stored 

	public static void main(String[] args) {
	
	 Hashtable h1 = new Hashtable () ;
	 
	 h1.put(1, "Jiten");
	 h1.put(2, "Jai");
	 h1.put(3, "Jitesh");
	 
	 Hashtable h2 = new Hashtable () ;
	
	 h2 = (Hashtable)h1.clone() ;
	
	 System.out.println ("the values from h1 :" + h1);
	 System.out.println ("the values from h2 :" + h2);
	 
	 h1.clear();
	 //it will remove the content inside the hash table 
	 System.out.println ("the values from h1 :" + h1);
	 System.out.println ("the values from h2 :" + h2);
	 
	 
	 Hashtable h3 = new Hashtable () ;
	 
	 h3.put("A", "Kumar");
	 h3.put("B", "Jiten");
	 h3.put("C", "Priya");
	 
	 if (h3.containsValue("Priya")) {
	 System.out.println ("Priya present ");	 
	 }
	//print all the elements using enumeration 
	Enumeration e =  h3.elements();
	
	while (e.hasMoreElements()) {
	System.out.println ("elements inside hashtable :"+ e.nextElement())	;
	}
	
	//print all the elements using entry set
	
	 Set s = h3.entrySet() ;
	 System.out.println (s);
	 
     Hashtable h4 = new Hashtable () ;
	 
	 h4.put("A", "Kumar");
	 h4.put("B", "Jiten");
	 h4.put("C", "Priya");
	 
	  
	 if (h3.equals(h4)) 
	 {
	 System.out.println ("both the objects are equal");
	 }
	 //to get the hashcode of hashtable object 
	 System.out.println ("the hash code value of hashtable :" + h4.hashCode());
	}

}
