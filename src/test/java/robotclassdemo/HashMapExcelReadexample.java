package robotclassdemo;

import org.openqa.selenium.By;
import repository.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import functionlibrary.*;
import javaconcepts.*;

public class HashMapExcelReadexample extends Repositorycollection  {
	
	static WebDriver driver ;
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () throws Exception 
	{
	//get the value of url from hash map excel 	
	String baseurl = ExcelReadHashMap.getValue("baseurl") ;
	
	//launching of browser and url 
	Reusablefunctions.launchbrowser("chrome", baseurl);
	
	Reusablefunctions.wait (3000);
      }
	
	@Test (priority = 1 , description = "open the url and enter username and password for useradmin" , enabled = true)
	public void loginUseradmin () throws Exception 
	{
	
	    //login the user name and password 
		
		System.out.println ("print user name : " + ExcelReadHashMap.getValue("Username1")) ;
		System.out.println ("print password :  " + ExcelReadHashMap.getValue("Password1")) ;
		
		
		Reusablefunctions.type(Login_username_crmpro, ExcelReadHashMap.getValue("Username1"));
		
		Reusablefunctions.type(Login_password_crmpro, ExcelReadHashMap.getValue("Password1"));
		//click on login button
	    
		Reusablefunctions.JavaScriptClick(Login_button);
		
		//wait for 5 secs
		Reusablefunctions.wait(5000);
		
		//Reusablefunctions.waitforElement(Logout_crmpro);
		
		
		 //switch to the frame by doing right click and select page source and select frame 
		//switch to the frame by doing right click and select page source and select frame 
	    Reusablefunctions.switchtoFrame(ExcelReadHashMap.getValue("Framename"));
	    
	    //to select values from drop down for month 
	    Reusablefunctions.selectFromDropdown(Selectmonth_crmpro, ExcelReadHashMap.getValue("Month1"));
	    
	    Reusablefunctions.capturescreenshot(driver, "capturing the month name of useradmin");
	    
	    //click on logout 
	    Reusablefunctions.click(Logout_crmpro);
	}
	
	@Test (priority = 2 , description = "open the url and enter username and password for admin" , enabled = true)
	public void loginadmin() throws Exception 
	{
		
	//enter the user name and password 
     Reusablefunctions.type(Login_username_crmpro, ExcelReadHashMap.getValue("Username 2"));
		
	 Reusablefunctions.type(Login_password_crmpro, ExcelReadHashMap.getValue("Password2"));	
		
	//click on login button
	 Reusablefunctions.JavaScriptClick(Login_button);
	
	//wait for 5 secs
	Reusablefunctions.wait(5000);
	
	//switch to the frame by doing right click and select page source and select frame 
    Reusablefunctions.switchtoFrame(ExcelReadHashMap.getValue("Framename"));
    
    //to select values from drop down for month 
    Reusablefunctions.selectFromDropdown(Selectmonth_crmpro, ExcelReadHashMap.getValue("Month2"));
    
    Reusablefunctions.capturescreenshot(driver, "capturing the month name of useradmin");
    
    //click on logout 
    Reusablefunctions.click(Logout_crmpro);
    
    }
	
	@AfterMethod
	public void closethebrowser() {
	//close the browser
	Reusablefunctions.closeallbrowser();	
           }
   }