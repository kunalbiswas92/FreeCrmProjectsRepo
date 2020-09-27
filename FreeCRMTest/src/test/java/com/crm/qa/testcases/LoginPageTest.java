package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	HomePage home;
	LoginPage loginobj;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("BEFORE METHOD");
		initialize();
		loginobj = new LoginPage();
	}
	@Test(priority=1)
	public void validateTitleTest()
	{
		String actualTitle = loginobj.validateTitle();
		Assert.assertEquals(actualTitle, "Cogmento CRM");
		
	}
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		home = loginobj.login(prop.getProperty("Username"), prop.getProperty("Password"));
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		System.out.println("BEFORE METHOD");
		driver.quit();
	}
}
