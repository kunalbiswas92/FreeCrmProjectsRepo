package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name="email")
	WebElement usernamefield;
	
	@FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	//Initialize the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateTitle()
	{
		return driver.getTitle();
	}
	public HomePage login(String uname , String pass)
	{
		
		usernamefield.sendKeys(uname);
		passwordfield.sendKeys(pass);
		loginButton.click();
		return new HomePage();
	}
	public void signUp()
	{
		signUpLink.click();
	}
}
