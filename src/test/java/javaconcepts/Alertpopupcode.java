package javaconcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertpopupcode {

	static  WebDriver driver ;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver() ;
		//maximize the window		
    driver.manage().window().maximize(); 
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;	
    
    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	
    
    //click on go button
    
    driver.findElement(By.xpath("//input[@name='proceed']")).click();
    Alert alert = driver.switchTo().alert();
    System.out.println ("get the text of the alert :" + alert.getText());
    
    if (alert.getText().equalsIgnoreCase("Please enter a valid user name")) {
    System.out.println ("alert text present");	
    }else {
    System.out.println ("alert text not present");		
    }
    //alert.dismiss();//cancel button not present at the alert
    alert.accept();//click on ok button
    
    Thread.sleep(2000);
    
    driver.close();
	}

}
