package javaconcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//1 alert java script Pop up -- Alert API (--dismiss ,accept)
// 2.File upload Pop Up - Browse button (type -file ,send keys (path)
//Browser pop ups - Window Pop up (window handler API - getWindowHandles )


public class Windowhandling {

	static  WebDriver driver ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver() ;
	//maximize the window		
	driver.manage().window().maximize(); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
	driver.get("http://www.popuptest.com/");	
	
	//click on link
	
   driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/font[1]/b[1]/a[1]")).click();
   //Return a set of window handles which can be used to iterate over all open windows of thisWebDriver 
   //instance by passing them to switchTo().Options.window()
   Set <String> allwindows = driver.getWindowHandles() ;
   //Returns an iterator over the elements in this set. The elements are returned in no particular order
   Iterator <String> itr = allwindows.iterator() ;
   
   String parentwindow = itr.next() ;
   //print the parent window
   System.out.println ("parent window :" + parentwindow);
   
   String childwindow = itr.next();
   //print the child window
   System.out.println ("child window :" + childwindow);
   //switch to child window
   driver.switchTo().window(childwindow);
   //get the driver title
   System.out.println ("driver title of child window :"+ driver.getTitle() );
   //close the child window
   driver.close();
   
   //switch to parent window
  driver.switchTo().window(parentwindow) ;
  System.out.println ("driver title of parent window :"+ driver.getTitle() );
   
	}

}
