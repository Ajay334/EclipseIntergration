package com.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	public ConfigDataProvider()
	{
		File src=new File("C:\\Users\\Admin\\eclipse-2workspace\\Framework\\Config\\config.properties");
	   try {
		FileInputStream fis=new FileInputStream(src);
		  prop=new Properties();
		  prop.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
System.out.println("Not able to open config file" +e.getMessage());	}
	 
	}
	
	
	public String getDatafromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getAppUrl()
	{
		return prop.getProperty("appUrl");
	}
}
