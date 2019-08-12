package javaconcepts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadHashMap {

	public static final String EXCELFILELOCATION = "./TestData/Login_Credentials.xlsx";
	//public static final String EXCELFILELOCATION = "C:\\Users\\ACER\\OneDrive\\Desktop\\Selenium_Courses_udemy\\Login_Credentials.xlsx";
	private static FileInputStream fis ;
	private static XSSFWorkbook workbook ;
	private static XSSFSheet sheet ;
	private static XSSFRow row ;
	
	public static void loadExcel () throws Exception {
	
	System.out.println ("Loading Excel Data ");
	
	File file = new File (EXCELFILELOCATION);
	fis = new FileInputStream(file);
	
	workbook = new XSSFWorkbook(file);
	sheet = workbook.getSheet("TestData");
	
	fis.close();
	}
	
	
	public static   Map <String , Map <String , String>>  getDataMap () throws Exception 
	{
	
	if (sheet == null ) {
	loadExcel();	
	}
		
	Map <String , Map <String , String>> supermap = new HashMap <String , Map <String , String>>() ;
	//Map is an interface ,therefore we cannot create object of Map Interface 
	Map <String , String> mymap = new HashMap <String , String > () ;
	
	//to get the last row 
	for (int i = 1 ; i <sheet.getLastRowNum() + 1 ; i ++ ) 
	{
	row = sheet.getRow(i);
	//to get the  row value 
	String keyrowcell = row.getCell(0).getStringCellValue() ;
	
	//to get the total number of column 
	int colnum = row.getLastCellNum();
	
	for (int j = 1 ; j < colnum ; j ++ ) 
	{
	//to get the column value 	
	String colvalue = row.getCell(j).getStringCellValue()	;
	
	//store the values of row and column inside the hashmap
	mymap.put(keyrowcell, colvalue);
	}
	
	supermap.put("MASTERDATA", mymap);
	   }
	return supermap;
	}

	//to get the row value 
	public static String getValue (String key ) throws Exception 
	{
		
		Map <String ,String > myval = getDataMap().get("MASTERDATA") ;
		
		String keyvalue = myval.get(key);
		return keyvalue;
		
	}
	
	public static void main (String [] args) throws Exception {
	
		System.out.println ("value of url :" + getValue("baseurl"));
		System.out.println ("value of  username : " + getValue("Username1"));
		System.out.println ("value of  password : " + getValue("Password1"));
	}
}
