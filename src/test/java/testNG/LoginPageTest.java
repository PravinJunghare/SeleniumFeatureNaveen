package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest

{
    WebDriver driver;
	@BeforeMethod
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
		//WebDriverWait wait =new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.titleContains("Hubspot"));
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
	
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
