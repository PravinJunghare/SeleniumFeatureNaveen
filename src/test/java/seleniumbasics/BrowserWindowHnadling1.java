package seleniumbasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHnadling1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/OrangeHRM/\"]")).click();
		//get total window
		Set<String>handles=driver.getWindowHandles();
		
	   List<String>handlelist=new ArrayList<>(handles);
		
	   /*for(String e:handlelist)
		{
			System.out.println(e);
		}
		*/
		String parentWinId=handlelist.get(0);
		String childWinId=handlelist.get(1);
		
		driver.switchTo().window(childWinId);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWinId);
	 	System.out.println(driver.getTitle());
		
		
		
		
	}

}
