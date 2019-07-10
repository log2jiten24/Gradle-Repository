package robotclassdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MovetoElement {
	
	static WebDriver driver ;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
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

	@Test (priority = 2 , description = "login to orangehrm" , enabled = true)
	public void draganddrop () throws Exception 
	{
		
	//Add implicit wait 	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
    //login to hrm page
  WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
  username.click();
  username.sendKeys("Admin");
  
  WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']")) ;	
  password.click();
  password.sendKeys("admin123");
  
  //click on submit
  driver.findElement(By.id("btnLogin")).click();
	
	
	//example of explicit wait 
 WebDriverWait wait = new WebDriverWait(driver, 20) ;
 WebElement logout = driver.findElement(By.xpath("//a[@id='welcome']"));
 logout = wait.until(ExpectedConditions.elementToBeClickable(logout)) ;

}
	
	@Test (priority = 3 , description = "move to element" , enabled = true)
	public void movetoelement () throws Exception 
	{
	
	Actions act = new Actions (driver);	
	
	WebElement admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]")) ;
	WebElement usermgr = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
	
	WebElement users = driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")) ;
	
	act.moveToElement(admin).moveToElement(usermgr).moveToElement(users).click().build().perform();
	
	
	}
	@AfterTest(description = "close browser")
	public void closebrowser () {
	//click on logout
		
	WebElement welcomeadmin = driver.findElement(By.xpath("//a[@id='welcome']"));	
	welcomeadmin.click();
	
	WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	logout.click();
	
	driver.close();	
	
	driver.quit();
	}
}