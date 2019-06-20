package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Forgot_Password {
	private WebDriver driver;
	private ExtentTest test;
	
	public Forgot_Password(WebDriver driver,ExtentTest test) {
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
	@FindBy(xpath="//*[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warningmessage;
	@FindBy(partialLinkText="Forgotten Password")
	private WebElement ForgotPwd;
	@FindBy(id="input-email")
	private WebElement PwdRecoveryEmail;
	@FindBy(xpath="//*[@class='btn btn-primary' and @value='Continue']")
	private WebElement ContinueButton;
	@FindBy(xpath="//*[contains(text(),'An email with a confirmation link has been sent your email address.')]")
	private WebElement ResetPwdLink;
	
	
	public void clickAccountBtn() {
		this.Account.click(); 
		test.log(LogStatus.INFO, "Clicked on Account");}
	public void Email(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
		test.log(LogStatus.INFO, "Email Entered");}
	public void LoginPassword(String LoginPassword) {
		this.LoginPassword.clear();
		this.LoginPassword.sendKeys(LoginPassword);
		test.log(LogStatus.INFO, "Wrong Password Entered");}
	public void LoginButton() {
		this.LoginButton.click();
		test.log(LogStatus.INFO, "Clicked on Login Button");}
	public boolean warningmessage() {
		test.log(LogStatus.INFO, "Warning message");
		return this.warningmessage.isDisplayed();}
	public void ForgotPwd() {
		this.ForgotPwd.click();
		test.log(LogStatus.INFO, "Clicked on Forgot Password link");}
	public void PwdRecoveryEmail(String PwdRecoveryEmail ) {
		this.PwdRecoveryEmail.clear();
		this.PwdRecoveryEmail.sendKeys(PwdRecoveryEmail);
		test.log(LogStatus.INFO, "Provided Recovery Email Address");}
	public void Continue() {
		this.ContinueButton.click();
		test.log(LogStatus.INFO, "Clicked on Continue Button");}
	public boolean ResetPwdLink() {
		test.log(LogStatus.INFO, "Password Reset");
		return this.ResetPwdLink.isDisplayed();
		}
	}


	

