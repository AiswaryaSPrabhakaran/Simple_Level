package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.generics.User_Login_Extent_Report;
import com.training.pom.User_Login;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002 {

	private WebDriver driver;
	private String baseUrl;
	private User_Login loginPOM2;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentTest test;
	private User_Login_Extent_Report report;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		extent = report.getInstance();
		test = extent.startTest("User Login");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM2 = new User_Login(driver,test);
		//baseUrl = properties.getProperty("baseUrl");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://retail.upskills.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void validLoginTest() {
		loginPOM2.clickAccountBtn();
		loginPOM2.sendEmail("abcd@gmail.com");
		loginPOM2.LoginPassword("qazmlp");
		loginPOM2.LoginButton();
		screenShot.captureScreenShot("4");
		test.log(LogStatus.PASS, "My Account Page Opened Successfully");
		
	}
	
	
	
	@AfterClass
	public void Afterclass() throws Exception{
		
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.quit();
				
	}
	
	}
