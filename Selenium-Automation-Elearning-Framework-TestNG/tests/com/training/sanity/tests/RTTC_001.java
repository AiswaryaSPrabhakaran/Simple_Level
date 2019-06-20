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
import com.training.generics.User_Registration_Extent_Report;
import com.training.generics.ScreenShot;
import com.training.pom.User_Registration;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_001 {

	private WebDriver driver;
	private String baseUrl;
	private User_Registration loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentTest test;
	private User_Registration_Extent_Report report;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		extent = report.getInstance();
		test = extent.startTest("User Registration");
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new User_Registration(driver,test); 
		//baseUrl = properties.getProperty("baseUrl");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://retail.upskills.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void validLoginTest() {
		loginPOM.clickAccountBtn();
		loginPOM.clickRegisterBtn();
		loginPOM.sendUserName("Mangotree");
		loginPOM.sendPassword("Mangotree");
		loginPOM.sendemail("Tree@gmail.com");
		loginPOM.sendPhone("9876543000");
		loginPOM.sendaddr1("Hebball");
		screenShot.captureScreenShot("1");
		loginPOM.sendaddr2("Bangalore");
		loginPOM.sendcity("Bangalore");
		loginPOM.sendpostcode("560025");
		loginPOM.clickcountry();
		loginPOM.clickstate();
		loginPOM.sendInput_Password("qazmlp");
		loginPOM.sendInput_Password("qazmlp");
		screenShot.captureScreenShot("2");
		loginPOM.clickRadio();
		loginPOM.clickAgree();
		loginPOM.clickContinue();
		screenShot.captureScreenShot("3");
		test.log(LogStatus.PASS, "Congratulations! Your new account has been successfully created!");
}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	@AfterClass
	public void Afterclass() throws Exception{
		
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
		extent.close();
				
	}
	
	}
