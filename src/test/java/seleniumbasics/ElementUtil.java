package seleniumbasics;

import java.util.List;

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
    // Wait Methods;Utilites
    public void visibilityofAllElements(List<WebElement> elements,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    	
    }
    
    
    public WebElement waitforelementTobepresent(By locator,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
		
    }
    public WebElement waitforelementTobeclickable(By locator,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
		
    }
    public WebElement waitforelementTobevisible(By locator,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
    	WebElement element= getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
		
    }
    
    public String waitforUrl(String url,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
 
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
		
    }
    public Boolean waitforAlertToBePresent(String url,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
 
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
		
    }
    
    public void clickwhenReady(By locator,int timeout)
    
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
    	wait.until(ExpectedConditions.elementToBeClickable(locator));
    	getElement(locator).click();
    	
    }
 
    public String waitforTitletobebepresent(String title,int timeout)
    {
    	WebDriverWait wait =new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		
    }
    

    
    
  }
  
  
  
  
  
  
  
  
  

