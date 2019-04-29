package com.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com']")
	WebElement login;

	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;
	
	
	public void LoginMethods(String usernames,String passwords)
	{
		login.click();
		email.sendKeys(usernames);
		password.sendKeys(passwords);
		loginButton.click();
	}
}
