package com.test.TestBase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup 
{
  public WebDriver driver;
  
  String browser="firefox";
  
  public void Init()
  {
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  driver=new FirefoxDriver();  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
	  }
	  
	  else
	  {
		  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\selenium setup\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
	  }
	
  }
  public void closing()
  {
	  driver.close();
  }
  
  public void getScreenshot(String Scrrenshot_name)
  {
	 try
	  {
		 TakesScreenshot sshot=(TakesScreenshot) driver;
		 File srcfile= sshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcfile,new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\screenshots\\Scrrenshot_name.png"));
	  }
	 catch(Exception e)
	 {
		 
	 }
	 
  }
}
