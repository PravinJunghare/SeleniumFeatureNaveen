package seleniumbasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutipleWindowHandlingClosing {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/OrangeHRM/\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://www.linkedin.com/company/orangehrm/mycompany/\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://twitter.com/orangehrm?lang=en\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://www.youtube.com/c/OrangeHRMInc\"]")).click();
		//get total window
		Set<String>handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		// for switching to child and close
		String Parwindid=it.next();	
		while(it.hasNext())
		{
		    
			String childWinId=it.next();
			driver.switchTo().window(childWinId);
			System.out.println(driver.getTitle());
			//driver.close()----------->closing all window
		//}
			// logic for not closing parent
			if(!Parwindid.equals(childWinId))
			{
				driver.close();
			}
	
			
				driver.switchTo().window(Parwindid);
				
				System.out.println("Parent Window");
			 
			
			
		}

	}

}
