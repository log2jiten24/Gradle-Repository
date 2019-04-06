package gradledemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctions;

public class Gradledemoclass {
	
	static WebDriver driver ;
	String baseUrl = "https://www.google.co.in/";
	
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
	Reusablefunctions.capturescreenshot(driver, "Googlepageopened");
	System.out.println ("Screenshot captured while opening google page");
	//print driver title
	System.out.println ("driver title capture :" + driver.getTitle()) ;
	}
	
	@AfterTest (description = "close the browser")
    public void close () {
    //close the browser 
	driver.quit();	   
		   
	   }	

}
