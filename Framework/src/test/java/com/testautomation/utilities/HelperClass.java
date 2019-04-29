package com.testautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {

	public static  String getScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath="C:\\Users\\Admin\\eclipse-2workspace\\Framework\\Screenshots\\"+CurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
System.out.println("Unable to capture screenshot"+e.getMessage());	

		}
		return screenshotPath;
	}
	
	public static String CurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	
	
}
