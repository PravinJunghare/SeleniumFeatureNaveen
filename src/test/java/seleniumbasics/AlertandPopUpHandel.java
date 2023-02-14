package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertandPopUpHandel {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Alert alert =driver.switchTo().alert();
	    String text=alert.getText();
	    if(text.equals("Please enter a valid user name"))
	    {
	    	System.out.println("CorrectError Message");
	    }
	    else
	    {
	    	System.out.println("Incorrect erro Message");
	    }
	    
	    alert.accept();
	    
	    driver.quit();
	}

}
