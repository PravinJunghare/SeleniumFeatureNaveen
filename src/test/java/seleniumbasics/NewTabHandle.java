package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {

	public static void main(String[] args) 
	{
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("http://www.google.com");
      String pwinid=driver.getWindowHandle();
      
      //Return an opaque handle to this window that uniquely identifies it within this driver instance.This can be used to switch to this window at a later date
      // for opening new tab
     //driver.switchTo().newWindow(WindowType.TAB);
      
      
      // for opening new window and driver will by default shift here
      driver.switchTo().newWindow(WindowType.WINDOW);//sel  4x....
      
      driver.get("http://www.facebook.com");
      System.out.println(driver.getTitle());
      driver.close();
      driver.switchTo().window(pwinid);
      System.out.println(driver.getTitle());
      
      
	}

}
