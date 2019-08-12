package javaconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hashmap_practice_makemytrip {

	public static WebDriver driver ;
	String baseUrl = "https://www.makemytrip.com/";
	
	@BeforeTest( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		driver = new ChromeDriver() ;
		//maximize the window		
		driver.manage().window().maximize(); 
		//launching the url
		//add implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.get(baseUrl);
		
		
	}
	
	@Test (priority = 1 , description = "close the widget" )
	public void openurlandlogin() throws Exception 
	{
	
	Thread.sleep(10000);
	
    driver.findElement(By.xpath("//a[contains(@class,'close')]")).click();
    
    Thread.sleep(5000);
	
	//driver.switchTo().parentFrame();
	
	//driver.switchTo().defaultContent() ;
	//close the alert
	
	//driver.findElement(By.xpath("//button[@id='deny']")).click();
	//close the cookies page
  //driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
	
	driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Delhi");
	}
}
