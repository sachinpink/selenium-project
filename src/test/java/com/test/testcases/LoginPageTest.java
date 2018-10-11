package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Exclreader.ReadExcel;
import com.test.TestBase.Setup;
import com.test.UIpages.LoginPage;

public class LoginPageTest extends Setup
{
	 
	LoginPage L_page;
	ReadExcel r_Excel;
	
	@BeforeMethod
	public void launch()
	{
		Init();
	}
	@Test(enabled=false)
	public void Verifylogin_InvalidDetails()
	{
		L_page= new LoginPage(driver);
		L_page.LoginTest("sachinzagade59@gmail.com", "123");
		System.out.println(L_page.loginmessage());
		Assert.assertEquals(L_page.loginmessage(), "Your password is incorrect");
		
	
	}
	@Test(enabled=false)
	public void Verifylogin_ValidDetails()
	{
		L_page= new LoginPage(driver);
		L_page.LoginTest("sachinzagade59@gmail.com", "9579287883");
	//	Assert.assertEquals(L_page.loginmessage(), "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");
	}
	
	@Test(dataProvider="loginData")
	public void login_Data_From_Excel(String email,String passd)
	{
		L_page= new LoginPage(driver);
		L_page.LoginTest(email, passd);
		 
	}
	
	@DataProvider(name="loginData")
	public Object[][] getData()
	{
		r_Excel=new ReadExcel(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\TestData\\Book1.xlsx");
		Object Data[][]=r_Excel.getDataFromExcel("sheet1");
		return Data;
		
	}
	
	
	@AfterMethod
	public void close()
	{
		closing();
	}

}
