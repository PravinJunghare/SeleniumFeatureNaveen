package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandel {

	// for dropdown having select tag
	
	 static WebDriver driver;
	public static void main(String[] args)
	{
	  WebDriverManager.chromiumdriver().setup();
      driver =new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
      
      By country =By.id("Form_getForm_Country");
     // Select select =new  Select(driver.findElement(country));
     // select.selectByVisibleText("India");
      
      // if there are many dropdown so need create more object so this is not best approach
     
    //  doSelectByVisibletext(country, "India");
       selectDropdownvalue(country, "index", "5");
      
       
       driver.quit();
	}
	
	
	public static void selectDropdownvalue(By locator, String type,String value)
	{
		Select select =new Select(getelement(locator));
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;


		default:
			System.out.println("Enter valid data for search criteria ");
			break;
		}
	}
	
	public static WebElement getelement(By locator)
	{
		return driver.findElement(locator);
		
	}
	
	public static void doSelectByVisibletext(By locator,String value)
	{
		Select select =new  Select(getelement(locator));
	      select.selectByVisibleText(value);
	      
	}

	public static void doSelectByIndex(By locator,int index)
	{
		Select select =new  Select(getelement(locator));
	      select.selectByIndex(index);;
	      
	}
	
	public static void doSelectByValue(By locator,String value)
	{
		Select select =new  Select(getelement(locator));
	      select.selectByValue(value);
	}
	
	
}
