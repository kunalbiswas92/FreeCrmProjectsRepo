package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement newDealsBtn;
	
	@FindBy(xpath="//input[@autocomplete='new-password']")
	WebElement titleTxt;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement companyName;
	

}
