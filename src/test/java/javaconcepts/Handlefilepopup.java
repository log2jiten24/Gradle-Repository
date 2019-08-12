package javaconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlefilepopup {

	static  WebDriver driver ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver() ;
			//maximize the window		
	    driver.manage().window().maximize(); 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;	
	    
	    driver.get("https://html.com/input-type-file/");	
	    //dont click on browser button
	    driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/Users/ACER/OneDrive/Desktop/Priya_SBI_Clerk");
	    
	    driver.close();

	}

}
