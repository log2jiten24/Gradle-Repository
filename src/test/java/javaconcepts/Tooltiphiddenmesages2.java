package javaconcepts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import functionlibrary.Reusablefunctions;

public class Tooltiphiddenmesages2 {

	static WebDriver driver ;
	@BeforeTest( description = "launching of browser")
	public void launchbrowser () throws Exception 
	{	
		String baseurl = "https://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html";
		Reusablefunctions.launchbrowser("chrome", baseurl);
		
		Reusablefunctions.wait (3000);
     }

	@Test (description = "verifying the toolkit messages hidden messages")
	public void verifytoolkitmessages () throws Exception {
	
    Actions act = new Actions(driver);
	
	act.moveToElement(driver.findElement(By.xpath("//div[@class = 'tooltip']"))).perform();
	
	//to get the hidden text go to source and then press f8 key and stop the inspection,then we 
	//can inspect the hidden message 
	//String text = hiddenmsg.getText() ;
	String text = driver.findElement(By.xpath("//span[@class = 'tooltiptext']")).getText();
	System.out.println ("values printed inside text :" + text );
	
	//verify the condition 
	AssertJUnit.assertTrue(text.contains("Tooltip"));
			
	}
	
	@AfterTest (description = "closing the browser")
	public void closebrowser () {
	
	Reusablefunctions.closebrowser();	
	}
}	

