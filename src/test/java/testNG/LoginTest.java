package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class LoginTest
{

	
	// Before>Precondition=> Before Suite,Before Test, Before class,Before Method
	//Test
	//After>Postcondition=>After Suite, Test, Before class,Before Method
	
	By forgotlink=By.xpath("//a[@id=\"toPasswordRecoveryPageLink\"]");
	By username=By.name("username");
	By password=By.name("pwd");
	By loginButton=By.id("loginButton");
	
	By logoutButton=By.id("logoutLink");
	By reports=By.xpath("//a[@class='content reports']/div[1]");
	
	WebDriver driver;
	//@BeforeTest//Will execute only once
	@BeforeMethod// Will execute with test for each test it will execute 
	// Here BeforeMetho will execute 4 times so browser will launch 4 times
	public void setUp()
	{ 
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://online.actitime.com/trddt/login.do");
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
		
	}
	
	
	//The scheduling priority. Lower priorities will be scheduled first.
	// If priority is not set will execute in alphabetical order 
	
	
	@ Test(priority = 1)
	public void forgetlinkTest()
	{
	  org.testng.Assert.assertTrue(driver.findElement(forgotlink).isDisplayed());
	}
	
	@Test(priority = 2)
	public void getTitle() 
	{
	  String title=driver.getTitle();
	  System.out.println(title);
	  org.testng.Assert.assertEquals(title, "actiTIME - Login");
      //Asserts that two Strings are equal. If they are not,an AssertionError is thrown.
      //Parameters:actual the actual value
	  
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		driver.findElement(username).sendKeys("pravinjunghare01@gmail.com");
		driver.findElement(password).sendKeys("Pravin@1177");
		driver.findElement(loginButton).click();
		
		String reportstext=driver.findElement(reports).getText();
		org.testng.Assert.assertEquals(reportstext, "Reports");
	}
	
	
	/* @Test(priority = 4)
	public void logout() 
	{
		driver.findElement(logoutButton).click();
	}
	*/
	//@AfterTest
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
