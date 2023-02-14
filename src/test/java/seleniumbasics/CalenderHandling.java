package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("https://www.ixigo.com");
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		Thread.sleep(3000);
		
		// startdate
		
		
		 String startmonthvalue=  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div")).getText();
	    	System.out.println(startmonthvalue);
	    	  
	    	  while(!startmonthvalue.contains("February 2023"))
	    	  {
	    		 driver.findElement(By.xpath(("/html/body/div[2]/div[2]/div[2]/button"))).click();//next arrow   
	    		 startmonthvalue=  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div")).getText();
	    	  }
	    List<WebElement>startDateList=
	    		                      driver.findElements
	    		                                 (By.xpath("//div[@class='rd-month'][1]/table//div[contains(@class, 'day')]"));
		
	    for(WebElement e:startDateList)
	    {
	    	if (e.getText().equals("12"))
	    	{
	    		e.click();
	    		break;
	    	}
	    
	    	
	    }
	    Thread.sleep(3000);
	    
	    
	  
	  
	  
	  
	  // enddate
	    	driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
	    	  Thread.sleep(3000);
	    	  
	    	  
	    	 String endmonthvalue=  driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div")).getText();
	    	System.out.println(endmonthvalue);
	    	  
	    	  while(!endmonthvalue.contains("March 2023"))
	    	  {
	    		 driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[2]")).click();//next arrow   
	    		  endmonthvalue=  driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div")).getText();
	    	  }
		    List<WebElement>endDateList=
		    		                      driver.findElements
		    		                                 (By.xpath("//div[@class='rd-month'][2]/table//div[contains(@class, 'day')]"));
			
		    for(WebElement e1:endDateList)
		    {
		    	if (e1.getText().equals("19"))
		    	{
		    		e1.click();
		    		break;
		    	}

	    }
	    
	    
	}
	}
