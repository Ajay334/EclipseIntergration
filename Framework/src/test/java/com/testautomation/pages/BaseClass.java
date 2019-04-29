package com.testautomation.pages;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.MediaName;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testautomation.utilities.BrowserFactory;
import com.testautomation.utilities.ConfigDataProvider;
import com.testautomation.utilities.ExcelDataProvider;
import com.testautomation.utilities.HelperClass;

public class BaseClass {

	public WebDriver driver;
	//thi si not been commited
	/*
	 * // public ConfigDataProvider config;
	 * 
	 * 
	 * @BeforeSuite public void SetUpSuite() throws Exception {
	 * 
	 * excel=new ExcelDataProvider();
	 * 
	 * // config=new ConfigDataProvider(); }
	 */
	public ExtentReports report;
	public ExtentTest logger;
	ExtentHtmlReporter reporter;

	@BeforeClass
	public void Setup() {
		driver = BrowserFactory.StartApplication(driver,"chrome","https://freecrm.com");

		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\Admin\\eclipse-2workspace\\Framework\\Reports\\extetReports"+HelperClass.CurrentDateTime()+".html");
			report=new ExtentReports();
			report.attachReporter(reporter);
		
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.QuitDriver(driver);
	}
	
	@AfterMethod
	public void tearDownScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.getScreenshot(driver)).build());
		}
		
		  else if(result.getStatus()==ITestResult.SUCCESS) {
		  
		  logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(
		  HelperClass.getScreenshot(driver)).build()); }
		 
		
		
		report.flush();
	}

}
