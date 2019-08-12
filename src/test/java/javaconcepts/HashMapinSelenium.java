package javaconcepts;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import okhttp3.Credentials;

public class HashMapinSelenium {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
//	   System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
//	   WebDriver driver = new ChromeDriver();
//       driver.get("https://classic.crmpro.com/index.html");
//       driver.manage().window().maximize();
    
//		driver.findElement(By.name("username")).sendKeys("naveenautomation");
//		driver.findElement(By.name("password")).sendKeys("Test@123");
		
		System.out.println("details stored in hashmap :" + getusercredentials());
		//hash map - duplicate keys are not allowed but duplicate values are allowed
		//get(key) - to get the value at specific key 
		System.out.println ("to get the value of specific key :" + getusercredentials().get("customer"));
		
//		String credentials = getusercredentials().get("customer");
//		
//		String [] usercredentials = credentials.split(":");
//		String username = usercredentials[0];
//		String password = usercredentials[1];
//		
//		driver.findElement(By.name("username")).sendKeys(username);
        //driver.findElement(By.name("password")).sendKeys(password);
		//passing the split string array in one way
//		driver.findElement(By.name("password")).sendKeys(credentials.split(":")[1]);
//		Thread.sleep(3000);
//		driver.close();
//		
		//again launch the url and fetch username in more generic way 
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://classic.crmpro.com/index.html");
	    driver.manage().window().maximize();
	    
//	    driver.findElement(By.name("username")).sendKeys(getusername("admin"));
//	    driver.findElement(By.name("password")).sendKeys(getpassword("admin"));
	    String credentials = getusercredentials().get("admin");
	    driver.findElement(By.name("username")).sendKeys(credentials.split(":")[0]);
	    driver.findElement(By.name("password")).sendKeys(credentials.split(":")[1]);
	    
	    Thread.sleep(3000);
	    
	    driver.close();
	}
	
	public static HashMap <String , String > getusercredentials () {
		
		HashMap <String , String> usermap = new HashMap<String , String > ();
		
		//key - different role ,value = user name : password
		usermap.put("customer", "naveenautomation:Test@123");
		usermap.put("admin","arpit:arpit123");
		usermap.put("distributor","gulnaz:12323");
		usermap.put("seller","chetna:chetna9090");
		usermap.put("deliverygirl","reshma:reshma9090");
		//adding duplicate key 
		usermap.put("seller","chetna:chetna9090");
		return usermap ;
	}

	public static String  getusername (String role ) {
   String credentialss = getusercredentials().get("role");
//   String username[] = credentialss.split(":");
//   return username [0];		
   return credentialss.split(":")[0];
   
	}
	
	public static String  getpassword (String role ) {
    String credentialsss = getusercredentials().get("role");
    return credentialsss.split(":")[1];
			
			}
}
