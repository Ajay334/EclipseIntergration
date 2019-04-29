package com.testautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver StartApplication(WebDriver driver,String browserName,String appUrl)
	{
	
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win321\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browserName.equals("Firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\eclipse-2workspace\\Framework\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			
		}
		else
		{
			System.out.println("We dont support this browser");
		}
		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void QuitDriver(WebDriver driver)
	{
		driver.quit();
	}
	
	
}

