package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory : OR
	@FindBy(xpath="//span[@class='user-display']")
	WebElement UserNameDisplay;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsBtn;

	@FindBy(xpath="//*[@id=\"main-nav\"]/a[5]/span")
	WebElement dealsBtn;
	
	//initialise the pageobjects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public String validateCorrectUsername()
	{
		return UserNameDisplay.getText();
		
	}
	public ContactsPage contactsButtonClick()
	{
		ContactsBtn.click();
		return new ContactsPage();
	}
	public DealsPage dealsButtonClick()
	{
		dealsBtn.click();
		return new DealsPage();
	}
	
	
	

}
