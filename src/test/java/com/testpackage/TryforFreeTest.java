package com.testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryforFreeTest 
{
	 WebDriver driver;
	 
	   By tryfreebtn=By.xpath("//a[text( )='Try Free']");
	   By freetext =By.xpath("//*[@id=\"my-app\"]/div/div[1]/div/div[1]/div[2]");
		@BeforeTest
		public void setup() 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("https://www.actitime.com/");
			
		}
		
		@Test
		public void TryfortextTest()
		{
			driver.findElement(tryfreebtn).click();
		     String actText=driver.findElement(freetext).getText();
		     System.out.println(actText);
		     Assert.assertEquals(actText, "Start your free 30-day trial");
			
		}
		
		@AfterTest
		public void closeBrowser() 
		{
			driver.quit();
		}
	
		
}
