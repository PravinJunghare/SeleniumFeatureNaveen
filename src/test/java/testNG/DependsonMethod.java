package testNG;

import org.testng.annotations.Test;

public class DependsonMethod 
{
	
	@Test
	public void loginTest()
	{
		System.out.println("Login Test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest()
	{
		System.out.println("Homepage Test");
	}


	@Test(dependsOnMethods = {"loginTest", "homePageTest"})
	public void searchTest()
	{
		System.out.println("Search Test");
	}

}
