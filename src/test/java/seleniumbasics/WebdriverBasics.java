package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebdriverBasics 
{
	
	public static void main(String args[]) 
	{
		WebDriver driver =new  ChromeDriver();
		driver.get("https://www.google.com/");
	    String title=	driver.getTitle();
	    System.out.println(title);
	   
	    if (title.equals("Google"))
	    {
	    	System.out.println("correct Title");
	    	
	    }		
	    
	    else
	    {
	    	System.out.println("incorret title");
	    }
	    
	    System.out.println(driver.getCurrentUrl());
	    		
	    driver.quit();
			
	    		
	    		
	}

}
