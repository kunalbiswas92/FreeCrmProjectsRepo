package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		loginpage = new LoginPage();
		homepage= loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void validateHomePageTitleTest()
	{
		String homePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM" , "Login successful");
	}
	@Test(priority=2)
	public void validateCorrectUsernameTest()
	{
		String userName = homepage.validateCorrectUsername();
		Assert.assertEquals(userName, "Kunal Biswas" , "Login successful");
		
	}
	@Test(priority=3)
	public void clickOnContactsButton()
	{
		contactsPage =homepage.contactsButtonClick();
	}
	@AfterMethod
	public void teardown() 
	{
		System.out.println("BEFORE METHOD");
		driver.quit();
	}
	
}
