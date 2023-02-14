package testNG;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept 
{
	
	@Test(expectedExceptions = Throwable.class)
	public void test()
	{
	 System.out.println("Test started");
	 int i=9/0;
	 System.out.println("Test end");
	}
	
	// Used when need to pass all cases where exception are coming
	// exa : While giving demos

}
