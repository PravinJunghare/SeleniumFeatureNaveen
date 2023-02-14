package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandleGenricMethod {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		
	    WebElement day=	driver.findElement(By.id("day"));
	    WebElement month=driver.findElement(By.id("month"));
	    WebElement year=driver.findElement(By.id("year"));
	    
	    //Select select =new Select(day);
	    //select.selectByVisibleText("21");
	    selectDropdownValueByText(year, "1991");
	    selectDropdownValueByText(month, "Dec");
	    selectDropdownValueByText(day, "28");
	    
	}


	
	// generic method for dropdown selection
	public static void selectDropdownValueByText(WebElement element, String value)
	{
		Select select =new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public static void selectDropdownValueByIndex(WebElement element, int index)
	{
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
}
