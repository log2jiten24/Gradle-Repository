package javaconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class WebTablehandling {

	
static WebDriver driver ; 
	
	@BeforeTest
	public void openbrowser () throws Exception 
	{ 
	
    System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver() ;
	
	String baseUrl = "https://www.w3schools.com/html/html_tables.asp" ;
	driver.get(baseUrl);
	//maximize the browser 
	driver.manage().window().maximize();
	 }
	
	 @Test (priority = 0 , enabled = true , description = "webtable verification for the header file")

    public void verifytableheader () throws Exception
   {
	
	//Implicit Wait 
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS)	 ;
	
	//to count the total  number of rows 
      List<WebElement> tblrowdetails = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr"));
	  int rowcount = tblrowdetails.size();
      
      System.out.println ("total num of rows :" + rowcount);
      
      //to get the table header details 
      
      String beforexpathheader = "//table[@id = 'customers']/tbody/tr/th[";
      String afterxpathheader  = "]";
      
      for (int j = 1 ; j <=rowcount ; j ++) 
      {
      String actualxpath = beforexpathheader + j + afterxpathheader ;
      
      WebElement tblheaderdetails = driver.findElement(By.xpath(actualxpath));
      String headerdetails = tblheaderdetails.getText();
      
      System.out.println ("table header  details : " + headerdetails ) ;
    	  
      }
   }
      
      @Test (priority = 1 , enabled = true , description = "webtable verification for the table column ")

      public void verifytabledetails () throws Exception
     {
  	
  	//Implicit Wait 
  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS)	 ;
  //to count the total  number of rows 
    List<WebElement> tblrowdetails = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr"));
	int rowcount = tblrowdetails.size();
    
    String beforexpath = "//table[@id = 'customers']/tbody/tr[";
  	String afterxpath = "]/td[1]";
  	
  	 for (int j = 2 ; j <= rowcount ; j ++) 
     {
     String actualxpath = beforexpath + j + afterxpath ;
     WebElement tblcolfirstdet = driver.findElement(By.xpath(actualxpath)) ;
     System.out.println("company column details :" + tblcolfirstdet.getText());
     if (tblcolfirstdet.getText().equalsIgnoreCase("Ernst Handel"))
     {
     System.out.println("1st column content present :" +tblcolfirstdet.getText() + " "+ "present at" + " "+ (j-1 ));	 
     break ;
     }
	}
  	 System.out.println("*******************");  
     
     
    //to print the contact details of the contact column ,we observed that tr will change and td will keep constant 
      
      String afterxpathh = "]/td[2]" ;
    	
   	 for (int j = 2 ; j <= rowcount ; j ++) 
      {
      String actualxpathh = beforexpath + j + afterxpathh ;
      WebElement tblcolsecondtdet = driver.findElement(By.xpath(actualxpathh)) ;
      System.out.println("contact  details :" + tblcolsecondtdet.getText());
      if (tblcolsecondtdet.getText().equalsIgnoreCase("Roland Mende"))
      {
      System.out.println("2nd column content present :" +tblcolsecondtdet.getText() + " "+ "present at" + " "+ (j-1 ));	 
      break ;
      }
 	}
   	 System.out.println("*******************");  
      
      
    //to print the country details 
      String afterxpathcontry = "]/td[3]" ;
      
      for (int j = 2 ; j<=rowcount ; j ++)
      {
   	String actualxpathcontry =  beforexpath + j + afterxpathcontry ;
   	WebElement tbldetailscontry = driver.findElement(By.xpath(actualxpathcontry)) ;
   	System.out.println("country column details :" + tbldetailscontry.getText());
   	if (tbldetailscontry.getText().equalsIgnoreCase("Canada"))
   	{
   	System.out.println("3rd column content present :" +tbldetailscontry.getText() + " "+ "present at" + " "+ (j-1 ));
   	break ;
   	}
      } 
      System.out.println("*******************");  
      
}    
      
      @AfterTest (description = "close the browser")
      public void close () {
      //close the browser 
  	  driver.quit();	   
  		   
  	   }	
   }


//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]

//*[@id='crmcalendar']/table/tbody/tr[1]/td//select[@name = 'slctMonth']

//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]//td[1]

