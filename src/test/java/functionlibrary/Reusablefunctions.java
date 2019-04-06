package functionlibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
public class Reusablefunctions {
	
	//public static ExtentReports report;
	//public  static ExtentTest logger ;

	public static void capturescreenshot (WebDriver driver ,String screenshotname)
	{
		try {
		//TakesScreenshot is an interface ,we are typecasting interface to create object
		TakesScreenshot ts = (TakesScreenshot)driver  ;
		//getScreenshotAs - method to take screenshot and store in the memory
		File src = ts.getScreenshotAs(OutputType.FILE) ;
		//store the source file into the destination
		
		Files.copy(src, new File("./Screenshots/+ "+screenshotname+".png"));
		
		System.out.println ("Screenshots taken");
		} catch (Exception e) 
		{
		System.out.println("Screenshot failure :" + e.getMessage());
		}
	}
	
//	public static  void ExtentReports () {
////		//create object of ExtentHTMLTeporter
//		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OpenHRMpage.html")) ;		
//		report = new ExtentReports ();
//    	report.attachReporter(extent);	
//		}
	
	
	
	//to format current timestamp
		public static String getCurrentDateTime () {
		DateFormat customformat = new SimpleDateFormat("MM_dd_YYYY_HM_MM_SS") ;	
			
		Date currentDate = new Date ();
		return customformat.format(currentDate);
		
			
		}
		
		//capture screenshot
		
		
		public static String takeScreenshot (WebDriver driver) {
			
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/OpenHRM"+ getCurrentDateTime()+ ".png ";
		try {
		FileHandler.copy(src, new File(screenshotpath));	
		
		System.out.println ("Screenshot captured");
		}catch (IOException e ) {
		System.out.println ("unable to capture screenshots "+ e.getMessage());	
		}
		
		return screenshotpath ;
		}
}
