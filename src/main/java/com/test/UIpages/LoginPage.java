package com.test.UIpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.TestBase.Setup;

public class LoginPage extends Setup
{ 
	WebDriver driver;
	
 
  @FindBy(xpath=".//*[@id='nav-link-yourAccount']/span[1]")
  WebElement loginmenu;
  
  @FindBy(xpath=".//*[@id='ap_email']")
  WebElement emailid;
  
  @FindBy(xpath=".//input[@id='continue']")
  WebElement continuebutton;
  
  @FindBy(xpath=".//*[@id='ap_password']")
  WebElement password;
  
  @FindBy(xpath=".//*[@id='signInSubmit']")
  WebElement login;
  

  @FindBy(xpath=".//*[@id='auth-warning-message-box']/div/div/ul/li/span")
  WebElement Invalidloginmessage;
  
  
  
	public LoginPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void LoginTest(String emailId, String pass)
	{
		loginmenu.click();
		emailid.sendKeys(emailId);
		continuebutton.click();
		password.sendKeys(pass);
		login.submit();
		
	}
	public String loginmessage()
	{
		String message=Invalidloginmessage.getText();
		return message;
	}
	

}
