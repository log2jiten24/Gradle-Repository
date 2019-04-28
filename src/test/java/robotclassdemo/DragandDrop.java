package robotclassdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.*;

public class DragandDrop {
	
	static WebDriver driver ;
	String baseUrl = "http://jqueryui.com/resources/demos/droppable/default.html";
	
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

	@Test (priority = 2 , description = "drag and drop " , enabled = true)
	public void draganddrop () throws Exception 
	{
		
	//Add implicit wait 	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
	//create Actions class 
	Actions act = new Actions (driver);
	
	Thread.sleep(5000);
	
	// find element which  we need to drag
	WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	 // find element which we need to drop
	WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
    //drag and drop the element and perdorm
	//act.dragAndDrop(drag, drop).build().perform();
	
	//drag and drop to specifuc coordinates
	act.dragAndDropBy(drag, 250, 150).build().perform();
	
	Reusablefunctions.capturescreenshot(driver, "drag and drop happened");	
}
	
	@AfterTest(description = "close browser")
	public void closebrowser () {
	driver.close();	
	}
	
}