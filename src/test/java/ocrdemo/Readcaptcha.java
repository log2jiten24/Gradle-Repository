package ocrdemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import functionlibrary.Reusablefunctions;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Readcaptcha {

	
	static WebDriver driver ;
	String baseUrl = "https://www.irctc.co.in/nget/";
	
	@BeforeTest ( description = "launching of browser")
	public void launchbrowser () {
		//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
	   //WebDriver driver = new FirefoxDriver() ;
		
		//to handle the notifications
		ChromeOptions opt = new ChromeOptions() ;
		//to disable the notifications 
		opt.addArguments("--disable-notifications");
		//pass the argument to disable notifications
		driver = new ChromeDriver(opt) ;
		//maximize the window		
		driver.manage().window().maximize(); 	
		
	}
	
	@Test (priority = 1 , description = "open the url" , enabled = true)
	public void openurl() throws Exception 
	{
	//launching the url	
	driver.get(baseUrl);	
    //take the screenshot of url opened
	Reusablefunctions.capturescreenshot(driver, "IRCTC pageopened");
	System.out.println ("Screenshot captured while opening google page");
    }
	
	
	@Test (priority = 2 , description = "login irctc page" , enabled = true)
	public void login_irctc() throws Exception 
	{
	//add implicit wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)	;
	
	//click on irctc login 
	driver.findElement(By.xpath("//a[@id='loginText']")).click();
	
	Thread.sleep(8000);
	
	//fill the details for login id
	driver.findElement(By.xpath("//input[@id='userId']")).clear();
	driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("jeet2400");
	
	driver.findElement(By.xpath("//input[@id='pwd']")).clear();
	driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Ajiten#1990");
	
	//handle captcha ,capture the screenshot and store it inside the file 
	
	File src = driver.findElement(By.id("captchaImg")).getScreenshotAs(OutputType.FILE) ;
	//path where we want to store the screenshot
	String path = System.getProperty("user.dir") + "/Screenshots/captcha.png";
	
	//copy the captured screenshots to the desired path
	FileHandler.copy(src, new File(path));
	
	//code to capture the captcha
	ITesseract image = new Tesseract();
	String imagetext = image.doOCR(new File(path));
	System.out.println ("captured image from irctc:"+ imagetext);
	
	//split the string
	String mydata[] = imagetext.split("below");
	//it will replace all the characters with the spaces
	String captchastring = mydata[1].replaceAll("[^a-z A-Z0-9]", "");
	
	System.out.println ("final text captured:" + captchastring );
	
	//enter the captcha
	driver.findElement(By.xpath("//input[@id='nlpAnswer']")).sendKeys(captchastring);
	
	//click on sign in
	driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
	
	Thread.sleep(5000);
	
     }
	@AfterTest (description = "close the browser")
    public void close () throws Exception {
    //close the browser 
	driver.findElement(By.xpath("//a[@class='a ng-star-inserted']//span[contains(text(),'Logout')]")).click();
	Thread.sleep(3000);
	driver.close();
    }
       }