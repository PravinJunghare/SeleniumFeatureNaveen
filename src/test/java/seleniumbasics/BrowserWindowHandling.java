package seleniumbasics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandling {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/OrangeHRM/\"]")).click();
		//get total window
		Set<String>handles=driver.getWindowHandles();
		//Return a set of window handles which can be used to iterate over all open windows of thisWebDriver instance by passing them to switchTo().Options.window() 
		
		java.util.Iterator<String>it=handles.iterator();
		//Returns an iterator over the elements in this set. The elements arereturned in no particular order (unless this set is an instance of someclass that provides a guarantee).
		String prentWindowId=it.next();
		System.out.println("Parent window Id :"+prentWindowId);
		//To get Window Id
		String childWindowId=it.next();
		System.out.println("Child window Id :" +childWindowId);
		
		//Move to child and perform operation
		driver.switchTo().window(childWindowId);
		String childTitle=driver.getTitle();
		System.out.println("ChildTitle------  "+ childTitle);
		driver.close();// to close child window now driver has lost so again need to move to parent
		// driver.quit();------No Such Session Exception
		// Move to parent and perform operation
		driver.switchTo().window(prentWindowId);
		// if without switching  you are interacting with parent window
		// it will throw NoSuchWindowException: window already closed 
		
		
		String parentTitile=driver.getTitle();
		System.out.println("ParentTitle -------- "+parentTitile);
		driver.close();

		
		
		
		
		
		
		
	}

}
