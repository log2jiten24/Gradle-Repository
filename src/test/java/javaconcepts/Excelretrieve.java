package javaconcepts;

import functionlibrary.*;


public class Excelretrieve {

	public static String filepath = "E:\\excelfolder\\Demo_01.xlsx" ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//to retrieve the data for second row and 2nd column
		
		System.out.println("the values stored in the excel" + "-"  + Reusablefunctions.getData(filepath, 0, 1, 0));
		
		if (Reusablefunctions.getData(filepath, 0, 1, 0).equalsIgnoreCase("jeet2400")) 
		{
			System.out.println("testcase pased");
		}else {
			System.out.println("testcase failed");
		}
		}

	}


