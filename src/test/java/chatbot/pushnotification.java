package chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class pushnotification {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //code to disable the notifications
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//click on image link
		WebElement link = driver.findElement(By.xpath("//img[contains(@src ,'https://s1.rdbuz.com/Images/RCC/new/274x147.png')]"));
		Thread.sleep(5000);
		link.click();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
