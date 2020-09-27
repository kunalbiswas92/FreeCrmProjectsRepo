package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contacts;
	
	public ContactsPageTest()
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
	
	
	
	@DataProvider
	public  Object[][] dataFetch()
	
	{
		Object[][] ArrayObj = TestUtil.testData(prop.getProperty("SheetName"));
		return ArrayObj;
		
	}
	
	
	@Test(priority=1 ,dataProvider = "dataFetch")
	public void createNewContact(String Fname , String Lname , String Company) throws InterruptedException
	{
		
		contacts = homepage.contactsButtonClick();
		contacts.createNewContact(Fname, Lname, Company);
	}
	
	@AfterMethod
	public void teardown() 
	{
		
		driver.quit();
	}
	
}
