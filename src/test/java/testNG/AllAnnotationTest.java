package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotationTest

{
	
	@BeforeSuite
	public void beforeSuite()
	{
	  System.out.println(" ---BeforeSuite---  ");	
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("--Before Class--");
	}
	@BeforeTest
	public void beforeTest()
	{
	   System.out.println("---Before Test---");	
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("---Before Method---");
	}
	
	@Test
	public void test1() 
	
	{
		System.out.println("--Test1--");
	}
			
	@Test
	public void test2() 
	
	{
		System.out.println("--Test2--");
	}
	
	
	@AfterSuite
	public void AfterSuite()
	{
	  System.out.println(" ---After Suite---  ");	
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("--After Class--");
	}
	@AfterTest
	public void afterTest()
	{
	   System.out.println("---After Test---");	
	}
	@AfterMethod
	public void AftereMethod()
	{
		System.out.println("---After Method---");
	}
	


}
