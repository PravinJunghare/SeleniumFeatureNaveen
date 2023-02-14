package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalmageCount {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.amazon.in");
		  List<WebElement>imagelist=driver.findElements(By.tagName("img"));
	        System.out.println(imagelist.size());
	        
	        for(int i=0;i<imagelist.size();i++)
	        {
	        	String imageurl= imagelist.get(i).getAttribute("src");
	        	System.out.println(imageurl);
	        }


	}

}
