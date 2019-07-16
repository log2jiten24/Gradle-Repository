package chatbot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handlingchatbot {

	static WebDriver driver ;
	String baseUrl = "https://ksrtc.in/oprs-web/";
	
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
    //get all the elements
	List<WebElement> allelements = driver.findElements(By.xpath("//div[@id='corover-close-btn']"));
	System.out.println ("found all chatbots");
	
	if (allelements.size()>0)
	{
	
	allelements.get(0).click();
	System.out.println ("chatbots closed");
	
	}
	   }

	@AfterTest (description = "close the browser")
    public void close () {
    //close the browser 
	driver.quit();	   
		   
	   }
}