package gradledemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctions;

public class DropdownSortdown {

	static WebDriver driver ;
	String baseUrl = "https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	@Test (priority = 1 , description = "open the url" , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);	
    //take the screenshot of url opened
	Reusablefunctions.capturescreenshot(driver, "Dropdownpageopened");
	//System.out.println ("Screenshot captured while opening google page");
	//print driver title
	System.out.println ("driver title capture :" + driver.getTitle()) ;
	}
	
	@Test (priority = 2 , description = "verify the dropdown" , enabled = true)
	public void verifydropdown () throws Exception 
	{
	 Select oclass = new Select (driver.findElement(By.id("tools"))) ;
	 
	 List actuallist = new ArrayList (); 
	 //store the elements inside the list
	 List<WebElement> alloptions = oclass.getOptions() ;
	 for (WebElement items : alloptions) {
	  //store all the values of dropdown 	 
	   String text = items.getText();
	   //add the items into another list 
	   Reusablefunctions.capturescreenshot(driver, "dropdown values captured");
	   //add the values inside  the arraylist
	   actuallist.add(text);	 
	 }
	 
	 List temp = new ArrayList ();
	 //add the collection
	 temp.addAll(actuallist);
	// sort the collection at ascending order
	Collections.sort(temp);
	
	Assert.assertTrue(actuallist.equals(temp));
	
}

	@AfterTest(description = "close browser")
	public void closebrowser () {
	
		driver.close();	
	}
	
}