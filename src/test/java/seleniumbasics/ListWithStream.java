package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStream {

	public static void main(String[] args)
	{
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		 // WebDriver driver =new FirefoxDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      
	      driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	      
	      By country =By.id("Form_getForm_Country");
         // Stream is applicable for list only
	      
	      By country_options= By.xpath("//select[@id='Form_getForm_Country']/option");
	      List<WebElement>count_list=driver.findElements(country_options);
	    //Sequential stream
	      // Order is maintained
	     // count_list.stream().forEach(ele ->System.out.println(ele.getText()));
	      
	      // parallel stream
	      // order not maintained
	      count_list.parallelStream().forEach(ele ->System.out.println(ele.getText()));
	      
	      driver.quit();
	      
	      
	}

}
