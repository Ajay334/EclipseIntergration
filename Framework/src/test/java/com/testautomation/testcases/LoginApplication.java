package com.testautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testautomation.pages.BaseClass;
import com.testautomation.pages.LoginPage;
import com.testautomation.utilities.BrowserFactory;
import com.testautomation.utilities.ExcelDataProvider;

public class LoginApplication extends BaseClass{

	
	@Test(priority=1)
	public void loginApplication() throws Exception
	{
			System.out.println("Login to appplication");
			ExtentTest logger=report.createTest("Login Test");
			logger.log(Status.INFO,"Login to CRM Application");
			logger.log(Status.PASS, "Passed Test");
			report.flush();
	   
		ExcelDataProvider excel=new ExcelDataProvider();;
	  LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
	// logger.info("Logging to application");
		loginpage.LoginMethods(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
 //  logger.pass("Login success");
	}
	
	
}
