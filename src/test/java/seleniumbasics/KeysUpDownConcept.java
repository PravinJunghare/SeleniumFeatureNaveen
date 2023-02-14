package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysUpDownConcept {

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Actions action =new Actions(driver);
		
	   // to go down
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		// to go Up
	   action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
       
	}

}
