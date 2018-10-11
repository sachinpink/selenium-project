package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Exclreader.ReadExcel;
import com.test.TestBase.Setup;
import com.test.UIpages.RegistrationPage;

public class RegstrationPageTest extends Setup
{
	RegistrationPage rpage;
	ReadExcel readexcel;
	
	@BeforeMethod
	public void launch()
	{
		Init();
	}
	
	@Test()
	public void registration_With_InvalidData()
	{
	    rpage= new RegistrationPage(driver);
		rpage.register("pink", "1234567890", "pink@gmail.com", "123456");
		getScreenshot("registrationfailed");
		
	}
	@Test(dataProvider="RegData")
	public void registration_with_Excel_Data(String customers, String phone, String email, String password)
	{
		rpage=new RegistrationPage(driver);
		rpage.register(customers,phone,email ,password);
		Assert.assertEquals(rpage.StatusOfRegistration(), "There was a problem");
		
		
	}
	
	@DataProvider(name="RegData")
	public Object[][] getData()
	{
		readexcel=new ReadExcel(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\TestData\\Book1.xlsx");
		Object[][] r_data=readexcel.getDataFromExcel("registration");
		return r_data;
	}
	
	
	
	@AfterMethod
	public void terminate()
	{
		closing();
	}

}
