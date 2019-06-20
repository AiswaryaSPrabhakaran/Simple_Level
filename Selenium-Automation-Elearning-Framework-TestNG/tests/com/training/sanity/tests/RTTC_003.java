package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.Forgot_Password_Extent_Report;
import com.training.generics.ScreenShot;
import com.training.pom.Forgot_Password;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_003 {

	private WebDriver driver;
	private String baseUrl;
	private Forgot_Password loginPOM3;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentTest test;
	private Forgot_Password_Extent_Report report;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		extent = report.getInstance();
		test = extent.startTest("Forgot Password");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM3 = new Forgot_Password(driver,test);
		//baseUrl = properties.getProperty("baseUrl");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://retail.upskills.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM3.clickAccountBtn();
		loginPOM3.Email("abcd@gmail.com");
		loginPOM3.LoginPassword("qazmlp1");
		loginPOM3.LoginButton();
		loginPOM3.warningmessage();
		Assert.assertTrue(loginPOM3.warningmessage());
		screenShot.captureScreenShot("5");
		loginPOM3.ForgotPwd();
		Thread.sleep(3000);
		loginPOM3.PwdRecoveryEmail("abcd@gmail.com");
		loginPOM3.Continue();
		loginPOM3.ResetPwdLink();
		Assert.assertTrue(loginPOM3.ResetPwdLink());
		screenShot.captureScreenShot("6");
		test.log(LogStatus.PASS, "An email with a confirmation link has been sent your email address.");
		
	}
	
	
	@AfterClass
	public void Afterclasss() throws Exception{
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
		
	}
	}
