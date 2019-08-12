package javaconcepts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import functionlibrary.Hashmapfunction;
import functionlibrary.Reusablefunctions;

public class CalendarAutomation {

	public static WebDriver driver ;
	String baseUrl = "https://classic.crmpro.com/index.html";
	
	public String credentials ;
	public String userinfo[] ;
	
	@BeforeMethod( description = "launching of browser")
	public void launchbrowser () {
		
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
	//get the user name and password from the hash map 	
	credentials = Hashmapfunction.getuserlogin().get("useradmin");
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
    oselect.selectByVisibleText(Hashmapfunction.monthMap().get(10));
    //to select the calendar value from the drop down
    
    WebElement Calendar = driver.findElement(By.xpath("//div[@id = 'crmcalendar']/table/tbody/tr[1]//td//select[@name = 'slctYear']"));
    
    Select oSelect = new Select (Calendar);
    oSelect.selectByVisibleText("2019");
    
  //div[@id ='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1] -- Complete xpath 
    
    String beforexpath = "//*[@id ='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[" ;
    String afterxpath = "]/td[" ;
    
    final int totalnumberofweekdays = 7 ;
   // [2][1] [2][2] [2][3] [2][4] [2][5] [2][6] [2][7] ;
    // [3][1] [3][2] [3][3] [3][4] [3][5] [3][6] [3][7]		
    
    boolean flag = false ;
    String datetext = null ;
    for (int rownumber = 2 ; rownumber <=7 ; rownumber ++ ) {
    for  (int columnnum = 1 ;columnnum <=totalnumberofweekdays ; columnnum ++ ) {
    
    	String finalxpath = beforexpath + rownumber + afterxpath + columnnum + "]" ;
    	//System.out.println ("final xpath " + finalxpath) ;
    	try {
         datetext = driver.findElement(By.xpath(finalxpath)).getText()	;
    	}catch (NoSuchElementException e) {
    		
    	System.out.println ("Please enter correct date value :");	
    	flag = false ;
    	break ;
    	}
    
    	//select the date value 
    	System.out.println ("Date value printed :" + datetext);
        if(datetext.equalsIgnoreCase("31")) {
        driver.findElement(By.xpath(finalxpath)).click();
        
        Reusablefunctions.capturescreenshot(driver, "date selected");
        flag = true ;
        break ;
        }	
           }
       
       if (flag) {
    	break ;
    	//break the outer loop
       }
    
    }
       }
	
	@AfterTest
	public void closebrowser () {
		
	WebElement logout = driver.findElement(By.xpath("//td[@class='headertable']//td[4]//a"));
    logout.click();	
   
    driver.close();
	}
}


//steps involved
//a) with the help of dynamic xpath write the final xpath
//b) Iterate the entire row and column on calendar drid
//c) Match the value and select day
//d) Handle No Such Element exception for the case of 31 st day 


