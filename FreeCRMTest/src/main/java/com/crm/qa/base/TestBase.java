package com.crm.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverListener listener;
	//initialize properties object first as this is necessary to be used while fetching data from properties file
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"F:\\Local Git Repo\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//initialize WebDriver object once properties file is loaded through properties object
	
	public static void initialize() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Drivers\\Firefox\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Drivers\\Edge Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		//WebDriverFire event
	/*	e_driver = new EventFiringWebDriver(driver);
		listener = new WebDriverListener();
		e_driver.register(listener);
		driver = e_driver;*/
		//maximize and delete cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//for page timeout
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		//open browser with specific URL present in properties file
		driver.get(prop.getProperty("Url"));
	}
	
	

}
