package javaconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.*;
import junit.framework.Assert;

public class Tooltiphiddenmessages {
	
static WebDriver driver ;
	
	@BeforeTest( description = "launching of browser")
	public void launchbrowser () throws Exception 
	{	
		String baseurl = "https://seleniumpractise.blogspot.com/2019/09/bootstrap-tooltip-in-selenium.html#";
		Reusablefunctions.launchbrowser("chrome", baseurl);
		
		Reusablefunctions.wait (3000);
     }

	@Test (description = "verifying the toolkit messages hidden messages")
	public void verifytoolkitmessage () throws Exception {
	
	//WebElement strlink = driver.findElement(By.xpath("//a[contains(text(),'Hover over me')]"));
	//WebElement strlink = driver.findElement(By.xpath("//a[text() ='Hover over me']"));	
	//WebElement hiddenmsg = driver.findElement(By.xpath("//div[contains(text(),'Hooray!')]")) ;
	//WebElement hiddenmsg = driver.findElement(By.xpath("//div[@class = 'tooltip-inner']"));
	
	//to perform mouse hover 
	
	Thread.sleep(5000);
	
	Actions act = new Actions(driver);
	//act.moveToElement(strlink).perform();
	act.moveToElement(driver.findElement(By.xpath("//a[text() ='Hover over me']"))).build().perform();
	
	//to get the hidden text go to source and then press f8 key and stop the inspection,then we 
	//can inspect the hidden message 
	//String text = hiddenmsg.getText() ;
	String text = driver.findElement(By.xpath("//div[@class = 'tooltip-inner']")).getText();
	System.out.println ("values printed inside text :" + text );
	
	//verify the condition 
	Assert.assertTrue(text.contains("Hooray"));
			
	}
	
	@AfterTest (description = "closing the browser")
	public void closebrowser () {
	
	Reusablefunctions.closebrowser();	
	}
}