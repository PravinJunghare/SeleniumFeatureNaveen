package com.testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;
	@BeforeTest
	//@org.testng.annotations.Parameters({"url"})
	//public void setup(String url) 
	public void setup() 
	{
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.actitime.com/");
	}
	
	
	@ Test(priority =1)
	public void loginPageTitleTest() 
	{
	;
	    String title= driver.getTitle();
	    System.out.println("Page Title is :    "+title);
	   // Assert.assertEquals(title, "actiTIME - Time Tracking Software");
	   Assert.assertEquals(title, "actiTIME - Time Tracking Software","Title is not matched");
	}
	
	@ Test(priority =2)
	public void tryforFreelinlTest()
	{
	// boolean flag=	driver.findElement(By.xpath("//a[text( )='Try Free']")).isDisplayed();
	 Assert.assertTrue(driver.findElement(By.xpath("//a[text( )='Try Free']")).isDisplayed());
	}
	@AfterTest
	public void closeBrowser() 
	{
		driver.quit();
	}


}
