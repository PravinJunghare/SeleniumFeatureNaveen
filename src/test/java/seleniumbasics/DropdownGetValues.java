package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownGetValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		
	    WebElement day=	driver.findElement(By.id("day"));
	    WebElement month=driver.findElement(By.id("month"));
	    WebElement year=driver.findElement(By.id("year"));
	    getDropdownValue(year);
	    getDropdownValue(month);
	    getDropdownValue(day);

	}
	
	public static void getDropdownValue(WebElement elemet)
	{
		Select select =new Select(elemet);
		
		   System.out.println("===========================");
		   List<WebElement>droplist= select.getOptions();
		  
		   System.out.println("Total no values in dropdown "+ droplist.size());
		  
		   for(int i=0;i<droplist.size();i++)
				  
		  {
			 String text= droplist.get(i).getText();
			 System.out.println(text);
		  }
		  
		//  for(WebElement dropelement:droplist)
			  
		//  {
		//	 String text= dropelement.getText();
		//	 System.out.println(text);
		 // }
	}

}
