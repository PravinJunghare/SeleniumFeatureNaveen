package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();;
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.amazon.in");
	    List<WebElement>linklist=driver.findElements(By.tagName("a"));
        System.out.println(linklist.size());
        
        for(int i=0;i<linklist.size();i++)
        {
        	System.out.println( linklist.get(i).getText());
        }
	}

}
