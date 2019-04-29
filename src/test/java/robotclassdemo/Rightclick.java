package robotclassdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctions;

public class Rightclick {
	
	static WebDriver driver ;
	String baseUrl = "https://www.google.com/";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	
	
	@Test (priority = 1 , description = "open the url " , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);	
}
	
	@Test (priority = 2, description = "right click" , enabled = true)
	public void rightclick() throws Exception 
	{
		
	//Add implicit wait 	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
	
	WebElement search = driver.findElement(By.xpath("//input[@name='q']")) ;
	
	Actions act = new Actions (driver);
	
	//act.contextClick(search).click().perform();
	act.contextClick(search).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
	.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).click()
	.build().perform();
	
	Thread.sleep(9000);
	
	Reusablefunctions.capturescreenshot(driver, "right click happened");
	
	
}
	
	@AfterTest(description = "close browser")
	public void closebrowser () 
	{
	driver.close();	
	}
	
}
