package javaconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import functionlibrary.*;
public class HashMappractice {
	
	public static WebDriver driver ;
	String baseUrl = "https://classic.crmpro.com/index.html";
	public String credentials ;
	public String userinfo[] ;
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
	//launch the browser 
	//Reusablefunctions.launchbrowser("Chrome", baseUrl);	
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.get(baseUrl);	
	}
	
	
	@Test (priority = 1 , description = "open the url and enter username and password for useradmin" , enabled = true)
	public void openurlandlogin() throws Exception 
	{
	credentials = Hashmapfunction.getuserlogin().get("useradmin");
	String userinfo[] = credentials.split(":");
			
	//enter the username and password 
	driver.findElement(By.name("username")).sendKeys(userinfo[0]);
	driver.findElement(By.name("password")).sendKeys(userinfo[1]);
	//click on login button
	WebElement loginbutton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
	
	JavascriptExecutor js = (JavascriptExecutor)driver ;
	js.executeScript("arguments[0].click();", loginbutton);
	
    Thread.sleep(3000);
    //switch to the frame by doing right click and select page source and select frame 
    driver.switchTo().frame("mainpanel");
    //to select values from drop down for month 
    Select oselect = new Select (driver.findElement(By.name("slctMonth"))) ;
    oselect.selectByVisibleText(Hashmapfunction.monthMap().get(8));
    
    Reusablefunctions.capturescreenshot(driver, "capturing the month name of useradmin");
    
    WebElement logout = driver.findElement(By.xpath("//td[@class='headertable']//td[4]//a"));
    logout.click();
    
    }
	
	@Test (priority = 2 , description = "open the url and enter username and password for admin" , enabled = true)
	public void loginadmin() throws Exception 
	{
	credentials = Hashmapfunction.getuserlogin().get("admin");
	String userinfo[] = credentials.split(":");
			
	//enter the user name and password 
	driver.findElement(By.name("username")).sendKeys(userinfo[0]);
	driver.findElement(By.name("password")).sendKeys(userinfo[1]);
	//click on login button
	WebElement loginbutton = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
	
	JavascriptExecutor js = (JavascriptExecutor)driver ;
	js.executeScript("arguments[0].click();", loginbutton);
	
    Thread.sleep(3000);
    //switch to the frame by doing right click and select page source and select frame 
    driver.switchTo().frame("mainpanel");
    //to select values from drop down for month 
    Select oselect = new Select (driver.findElement(By.name("slctMonth"))) ;
    oselect.selectByVisibleText(Hashmapfunction.monthMap().get(9));
    
    Reusablefunctions.capturescreenshot(driver, "capturing the month name of admin");
    
    WebElement logout = driver.findElement(By.xpath("//td[@class='headertable']//td[4]//a"));
    logout.click();
    
    }
	
	
	@AfterMethod
	public void closebrowser() {
	//close the browser
	driver.quit();	
	}
}