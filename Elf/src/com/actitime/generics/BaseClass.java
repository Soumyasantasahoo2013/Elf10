package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.objectreposiretery.EnterTimeTrackPage;
import com.actitime.objectreposiretery.LoginPage;

public class BaseClass {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static WebDriver driver;
	public FileLib f=new FileLib();
	public WebDriverCommonLib w=new WebDriverCommonLib();
	
	@BeforeTest
	public void openBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		String un=f.getPropertyValue("UN");
		String pw=f.getPropertyValue("PWD");
		driver.get(f.getPropertyValue("URL"));
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickLogoutLink();
	}

}
