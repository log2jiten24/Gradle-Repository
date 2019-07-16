package chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handlingchatbot2 {

	static WebDriver driver ;
	String baseUrl = "https://classic.crmpro.com/index.html";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	@Test (priority = 1 , description = "open the url and handle the chatbot" , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);
   
	//xpath writing using and /contains keyword for iframe
	//iframe[contains(@style ,'height') and contains(@class ,'intercom')]
	//div[contains(text(),'Sign up the team')]
	
	//div[contains(@class ,'dismiss -button')]
	
	WebDriverWait wait = new WebDriverWait (driver,30); 
	System.out.println ("waiting for frame ");
	//explicit wait
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@style ,'height') and contains(@class ,'intercom')]")));
	System.out.println ("frame found and switched ");
	
	Actions act = new Actions (driver);
	
	act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Sign up the team')]"))).perform();
	
	System.out.println ("mouse hover");
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//div[contains(@class,'dismiss-button')]")).click();
	System.out.println("closing chat bot");
	}
	
	@AfterTest (description = "close the browser")
    public void close () {
    //close the browser 
	driver.quit();	   
		   
}
	
}