package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {

	public WebDriver driver;

	@Parameters( { "browser" , "websiteUrl" } )
	@BeforeMethod
	public void beforeMethod(String browserName , String Url) throws InterruptedException {

		Ibrowsers(browserName, Url);
	}
	//********************************************************************************************************



	@AfterMethod
	public void afterMethod(){ 
		
		driver.close();
	}

	public void Ibrowsers(String NameofBrowser, String url) throws InterruptedException {
		
		if(NameofBrowser.equalsIgnoreCase("chrome")) {

			driver =  new ChromeDriver();
			
			
			driver.manage().window().maximize();
	
			
			driver.get(url);
			
			Thread.sleep(3000);
		}
		else if(NameofBrowser.equalsIgnoreCase("edge")) {
			
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\Dell Home\\Batch39\\project.selenium\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			
			driver.manage().window().maximize();
			
			driver.get(url);
			
			Thread.sleep(3000);
		}
		else if (NameofBrowser.equalsIgnoreCase("firefox")) {
			
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell Home\\Batch39\\project.selenium\\Drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
			driver.get(url);
			
			Thread.sleep(3000);
		}}

}