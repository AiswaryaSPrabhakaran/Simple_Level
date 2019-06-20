package com.training.generics;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class User_Registration_Extent_Report {
	private static ExtentReports extent ;
	private ExtentTest test;

	public void ExtentReport(ExtentTest test) {			
		this.test = test;			
	}

	public static ExtentReports getInstance()
	{

		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\User_Registration_Report.html",true);
		
		return extent;
		//test = extent.startTest(testName);
		//extent = new ExtentReports("eabtent.html");
		//extent.loadConfig(new File(System.getProperty("user.dir")+"/test-output/extend-config.html"));

	}
	}