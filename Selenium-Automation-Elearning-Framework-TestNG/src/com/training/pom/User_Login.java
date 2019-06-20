package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class User_Login {
	private WebDriver driver; 
	private ExtentTest test;
	
	public User_Login(WebDriver driver,ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement Account;
	@FindBy(name="email")
	private WebElement Email;
	@FindBy(name="password")
	private WebElement LoginPassword;
	@FindBy(xpath="//*[@class='btn btn-primary' and @value='Login']")
	private WebElement LoginButton;
	
	public void clickAccountBtn() {
		this.Account.click(); 
		test.log(LogStatus.INFO, "Clicked on Account");}
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
		test.log(LogStatus.INFO, "Email entered");}
	public void LoginPassword(String LoginPassword) {
		this.LoginPassword.clear();
		this.LoginPassword.sendKeys(LoginPassword);
		test.log(LogStatus.INFO, "Password Entered");}
	public void LoginButton() {
		this.LoginButton.click();
		test.log(LogStatus.INFO, "Clicked on Login Button");}
	}


	

