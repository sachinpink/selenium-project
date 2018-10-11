package com.test.UIpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.TestBase.Setup;

public class RegistrationPage extends Setup
{
	public WebDriver driver;
	
	@FindBy(xpath=".//*[@id='nav-link-yourAccount']/span[1]")
	WebElement signin;
	
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement crateaccount;
	
	@FindBy(xpath=".//*[@id='ap_customer_name']")
	WebElement yourname;
	
	@FindBy(xpath=".//*[@id='ap_phone_number']")
	WebElement mobilenumber;
	
	@FindBy(xpath=".//*[@id='ap_email']")
	WebElement emailid;
	
	@FindBy(xpath=".//*[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h4[contains(text(),'There was a problem')]")
	WebElement Reg_Message;
	
	
	public RegistrationPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void register(String customer,String phone, String email,String pass)
	{
		signin.click();
		crateaccount.click();
		yourname.sendKeys(customer);
		mobilenumber.sendKeys(phone);
		emailid.sendKeys(email);
		password.sendKeys(pass);
		continuebtn.submit();	
	}
	
	public String StatusOfRegistration()
	{
		 return Reg_Message.getText();
	}

	

}
