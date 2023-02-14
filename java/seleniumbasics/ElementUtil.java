package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil 

{
	
	WebDriver driver;
	  
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*
	 * This method is used to create element on the basis of By locator
	 * @param Loctor
	 * 
	 */
	
  public WebElement getElement(By locator)
  {
	  WebElement element = null;
	  try {
		 element= driver.findElement(locator);
		
	} catch (Exception e) {
		System.out.println("Some Exception while creating webelement");
		System.out.println(e.getMessage());
	}
	  
	  return element;
	  
  }
  /*
	 * This method is used to create element on the basis of By locator
	 * @param Loctor
	 * 
	 */
  public void doClick(By locator)
  {
	  try {
		  getElement(locator).click();
		
	} catch (Exception e) {
		System.out.println("Some Exception while clicking webelement");
		System.out.println(e.getMessage());
	}
	}
  /*
	 * This method is used to send value to   element on the basis of By locator
	 * @param Loctor
	 * 
	 */ 
  
    public void dosendKey(By locator,String value)
    {
    	try {
    	getElement(locator).sendKeys(value);
	} catch (Exception e) {
		System.out.println("Some Exception sending value to webelement");
		System.out.println(e.getMessage());
	}
    		
    }
    
    public WebElement elemntTobepresent(By locator,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
		
    }
    
    
  }
  
  
  
  
  
  
  
  
  

