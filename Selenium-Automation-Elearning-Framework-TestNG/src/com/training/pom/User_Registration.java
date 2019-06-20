package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class User_Registration {
	private WebDriver driver; 
	private ExtentTest test;
	
	
	public User_Registration(WebDriver driver,ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement Account;
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement Register;
	@FindBy(name="firstname")
	private WebElement userName; 
	@FindBy(name="lastname")
	private WebElement password;
	@FindBy(id="input-email")
	private WebElement email; 
	@FindBy(name="telephone")
	private WebElement phone; 
	@FindBy(id="input-address-1")
	private WebElement address_1; 
	@FindBy(id="input-address-2")
	private WebElement address_2; 
	@FindBy(id="input-city")
	private WebElement city; 
	@FindBy(id="input-postcode")
	private WebElement postcode; 
	@FindBy(id="input-country")
	private WebElement country;
	@FindBy(id="input-zone")
	private WebElement state;
	@FindBy(id="input-password")
	private WebElement Input_Password;
	@FindBy(id="input-confirm")
	private WebElement Confirm_Password;
	@FindBy(xpath="//*[@name='newsletter' and @value='0']")
	private WebElement RadioButton; 
	@FindBy(xpath="//*[@name='agree' and @value='1']")
	private WebElement Agree; 
	@FindBy(xpath="//*[@value='Continue' and @type='submit']")
	private WebElement Continue;
	@FindBy(name="email")
	private WebElement Email;
	@FindBy(name="password")
	private WebElement LoginPassword;
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement LoginButton;
	

	
		
	public void clickAccountBtn() {
		this.Account.click(); 
		test.log(LogStatus.INFO, "Clicked on Account");}
	public void clickRegisterBtn() {
		this.Register.click(); 
		test.log(LogStatus.INFO, "Clicked on Register");}
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		test.log(LogStatus.INFO, "Username Entered");}	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
		test.log(LogStatus.INFO, "Password Entered");}	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);	
		test.log(LogStatus.INFO, "Email Entered");}	
	public void sendPhone(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone);
		test.log(LogStatus.INFO, "Phone Number Entered");}	
	public void sendaddr1(String address_1) {
		this.address_1.clear(); 
		this.address_1.sendKeys(address_1);
		test.log(LogStatus.INFO, "Address_1 Entered");}
	public void sendaddr2(String address_2) {
		this.address_2.clear(); 
		this.address_2.sendKeys(address_2);
		test.log(LogStatus.INFO, "Address_2 Entered");}
	public void sendcity(String city) {
		this.city.clear(); 
		this.city.sendKeys(city); 
		test.log(LogStatus.INFO, "City Entered");}
	public void sendpostcode(String postcode) {
		this.postcode.clear(); 
		this.postcode.sendKeys(postcode); 
		test.log(LogStatus.INFO, "postcode Entered");}
	public void clickcountry() {
		Select sel1 = new Select(country);
		sel1.selectByVisibleText("India");
		test.log(LogStatus.INFO, "Country Selected from Dropdown");}
	public void clickstate() {
		Select sel2 = new Select(state);
		sel2.selectByVisibleText("Karnataka"); 
		test.log(LogStatus.INFO, "State Selected from Dropdown");}
	public void sendInput_Password(String Input_Password) {
		this.Input_Password.clear(); 
		this.Input_Password.sendKeys(Input_Password);
		test.log(LogStatus.INFO, "Input_Password Entered");}
	public void sendConfirm_Password(String Confirm_Password) {
		this.Confirm_Password.clear(); 
		this.Confirm_Password.sendKeys(Confirm_Password); 
		test.log(LogStatus.INFO, "Confirm_Password Entered");}
	public void clickRadio() {
		this.RadioButton.click();
		test.log(LogStatus.INFO, "Selected 'No' Radio Button");}
	public void clickAgree() {
		this.Agree.click();
		test.log(LogStatus.INFO, "Agree button clicked");}	
	public void clickContinue() {
		this.Continue.click();
		test.log(LogStatus.INFO, "Continue button clicked");}
		}


	

