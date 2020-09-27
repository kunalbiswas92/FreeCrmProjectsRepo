package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	//page factory : OR
		@FindBy(xpath="//button[contains(text(),'New')]")
		WebElement CreateNewContactBtn;
		
		@FindBy(xpath="//input[@name='first_name']")
		WebElement FirstNameTxtField;
		
		@FindBy(xpath="//input[@name='last_name']")
		WebElement LastNameTxtField;
		
		@FindBy(xpath="//div[@name='company']//input[@class='search']")
		WebElement CompanyName;
		
		@FindBy(xpath="//button[@class='ui linkedin button']")
		WebElement SaveBtn;
		
		//initialise the pageobjects
		public ContactsPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		
	
		public void createNewContact(String fname, String lname, String company) throws InterruptedException
		{
			CreateNewContactBtn.click();
			Thread.sleep(5000);
			FirstNameTxtField.sendKeys(fname);
			LastNameTxtField.sendKeys(lname);
			CompanyName.sendKeys(company);
			SaveBtn.click();
			Thread.sleep(5000);
			System.out.println("contact created");
			
		}
}
