package testNG;

import org.testng.annotations.Test;

public class InnocationCountConcept 

{
	
	// To run Test multiple time or number of time
  @Test(invocationCount = 10)
  public void test()
  {
	  System.out.println("Create Test");
	  
  }
}
// To Create Multiple User