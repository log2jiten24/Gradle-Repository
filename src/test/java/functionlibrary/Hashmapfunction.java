package functionlibrary;

import java.util.HashMap;

public class Hashmapfunction {
	
	
	
	//hash map to store the user name and password depending upon user roles
	public  static HashMap <String , String > getuserlogin () 
	{
		HashMap <String ,String> usermap = new HashMap <String , String> () ;
		usermap.put("useradmin", "log2jiten24:Ajiten#1990");
		usermap.put("admin", "log2jeet24:Ajiten#1990");
		return usermap ;
		}
	
	//to get the user name from hashmap 
	public static String getUsername (String role) 
	{
	//split the string to get the username 
	  String credentials[] = getuserlogin().get(role).split(":");
		return credentials[0];
	}

	//to get the password from hashmap 
		public static String getPassword (String role) 
		{
		//split the string to get the username 
		  String credentials[] = getuserlogin().get(role).split(":");
			return credentials[1];
		}
		
		public static HashMap <Integer,String> monthMap () {
		//store the month of the calendar
		HashMap <Integer,String> monthmap = new HashMap <Integer,String> ();	
		monthmap.put(1, "January");
		monthmap.put(2, "February");
		monthmap.put(3, "March");
		monthmap.put(4, "April");
		monthmap.put(5, "May");
		monthmap.put(6, "June");
		monthmap.put(7, "July");
		monthmap.put(8, "August");
		monthmap.put(9, "September");
		monthmap.put(10, "October");
		monthmap.put(11, "November");
		monthmap.put(12, "December");
	
		return monthmap ;
		
		}
		
		
		
}
