package chatbot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Pushnotification_firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver");
		
		FirefoxOptions opt = new FirefoxOptions() ;
		
		opt.addPreference("dom.webnotifications.enabled", false);
		
		WebDriver driver = new FirefoxDriver(opt);
		
        driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
	}

}
